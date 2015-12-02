package fr.faylixe.googlecodejam.client.webservice;

import fr.faylixe.googlecodejam.client.common.NamedObject;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * <p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 * request, using Gson API. {@link ProblemInput} instance belong
 * to a {@link Problem} object, and describes input submission
 * available for a given {@link Problem}.</p>
 * 
 * @author fv
 */
public final class ProblemInput extends NamedObject implements Serializable {

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** Difficulty rank of this problem input. **/
	@SerializedName("difficulty")
	private int difficulty;

	/** TODO : Figure out what number is for => PROBABLY NUMBER OF ATTEMPT. **/
	@SerializedName("number")
	private int number;

	/** Number of points this problem input deliver. **/
	@SerializedName("points")
	private int points;

	/** Parent problem of this input. **/
	private transient Problem parent;

	/**
	 * Suffix used for this problem input.
	 * Correspond to the attempt number in
	 * effective contest.
	 */
	@SerializedName("suffix")
	private String suffix;

	/**
	 * Getter for the parent problem of this input.
	 * 
	 * @return Parent problem instance of this input.
	 */
	public Problem getProblem() {
		return parent;
	}

	/**
	 * Sets the parent problem of this input.
	 * 
	 * @param parent Parent problem to set.
	 */
	protected void setParent(final Problem parent) {
		this.parent = parent;
	}

	/**
	 * Getter for the problem input difficulty.
	 * 
	 * @return Difficulty rank of this problem input. 
	 * @see #difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Getter for the problem input number.
	 * 
	 * @return TODO : Figure out what number is for.
	 * @see #number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Getter for the input number of point.
	 * 
	 * @return Number of points this problem input deliver.
	 * @see #points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Getter for the input suffix.
	 * 
	 * @return Suffix used for this problem input.
	 * @see #suffix
	 */
	public String getSuffix() {
		return suffix;
	}

}
