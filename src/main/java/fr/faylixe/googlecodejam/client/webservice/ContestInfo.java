package fr.faylixe.googlecodejam.client.webservice;

import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.Request;
import fr.faylixe.googlecodejam.client.webservice.Problem.Deserializer;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * <p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 * request, using Gson API.</p>
 * 
 * @author fv
 */
public final class ContestInfo implements Serializable, ObjectInputValidation {

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** Boolean flag that indicates if this contest have analysis available. **/
	@SerializedName("has_analysis")
	private int analysis;

	/** Integer that defines the problems version. **/
	@SerializedName("problem_version")
	private int version;

	/** List of problem this contest is exposing. **/
	@SerializedName("problems")
	private Problem [] problems;

	/**
	 * Indicates if this contests already have
	 * analysis committed or not.
	 * 
	 * @return <tt>true</tt> if contest analysis is available, <tt>false</tt> otherwise.
	 */
	public boolean hasAnalysis() {
		return analysis == 1;
	}
	
	/**
	 * Getter for the problems version.
	 * 
	 * @return Integer that defines the problems version.
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * Returns {@link Problem} instance associated
	 * to this contest.
	 * 
	 * @return List of problem this contest exposes.
	 */
	public List<Problem> getProblems() {
		return (problems == null ? Collections.emptyList() : Arrays.asList(problems));
	}
	
	/**
	 * Shortcut method for reducing law of Demeters issues.
	 * 
	 * @param index Index of the problem to retrieve.
	 * @return Problem instance required.
	 * @throws ArrayIndexOutOfBoundsException If the given index is not valid.
	 */
	public Problem getProblem(final int index) {
		final List<Problem> problems = getProblems();
		if (index < 0 || problems.size() <= index) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return problems.get(index);
	}

	/** {@inheritDoc} **/
	@Override
	public void validateObject() throws InvalidObjectException {
		for (final Problem problem : problems) {
			problem.setParent(this);
		}
	}
	
	/**
	 * Custom readObject method that registers this object as a deserialization validator.
	 * 
	 * @param stream {@link ObjectInputStream} to register this validator to.
	 * @throws OptionalDataException If any error occurs while reading the object.
	 * @throws ClassNotFoundException If the default readObject call can not find a required class.
	 * @throws IOException If any error occurs while reading the object.
	 */
	private void readObject(final ObjectInputStream stream) throws OptionalDataException, ClassNotFoundException, IOException {
		stream.registerValidation(this, 0);
		stream.defaultReadObject();
	}

	/**
	 * Static factory method that builds a {@link ContestInfo} instance
	 * from the given <tt>round</tt> using a <tt>/ContestInfo</tt>
	 * request from the round dashboard.
	 * 
	 * @param executor Executor instance used to perform the request.
	 * @param round Round to retrieve {@link ContestInfo} from.
	 * @return Built {@link ContestInfo} instance.
	 * @throws IOException IF any error occurs while executing request.
	 */
	public static ContestInfo get(final HttpRequestExecutor executor, final Round round) throws IOException {
		final StringBuilder builder = new StringBuilder();
		builder.append(round.getURL()).append(Request.CONTEST_INFO);
		final String json = executor.get(builder.toString());
		final Deserializer adapter = new Deserializer(executor.getHostname());
		final Gson parser = new GsonBuilder().registerTypeAdapter(Problem.class, adapter).create();
		final ContestInfo info = parser.fromJson(json, ContestInfo.class);
		for (final Problem problem : info.getProblems()) {
			problem.setParent(info);
		}
		return info;
	}

}
