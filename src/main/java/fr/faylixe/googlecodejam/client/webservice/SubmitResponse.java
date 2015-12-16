package fr.faylixe.googlecodejam.client.webservice;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.gson.annotations.SerializedName;

/**
 * <p>POJO that aims to be bind to the <tt>SubmitAnswer</tt>
 * command request, using Gson API. Contains detail about
 * the performed submission.</p>
 * 
 * @author fv
 */
public final class SubmitResponse {

	/** Information message about submission. **/
	@SerializedName("msg")
	private String message;

	/** Indicates if the submission was successful or not. **/
	@SerializedName("ok")
	private boolean success;

	/** Target input identifier of this submission. **/
	@SerializedName("inputId")
	private int inputId;

	/** Target problem identifier of this submission. **/
	@SerializedName("problemId")
	private int problemId;

	/**
	 * Getter for the information message.
	 * 
	 * @return Information message about submission.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Indicates if the submission was successful or not.
	 * 
	 * @return <tt>true</tt> if this submission was a success, <tt>false</tt> otherwise.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Getter for the submission identifier.
	 * 
	 * @return Target input identifier of this submission. 
	 */
	public int getInputId() {
		return inputId;
	}

	/**
	 * Getter for the problem identifier.
	 * 
	 * @return Target problem identifier of this submission.
	 */
	public int getProblemId() {
		return problemId;
	}

	/** {@inheritDoc} **/
	@Override
	public int hashCode() {
		final HashCodeBuilder builder = new HashCodeBuilder();
		builder
			.append(message)
			.append(success)
			.append(inputId)
			.append(problemId);
		return builder.toHashCode();
	}

	/** {@inheritDoc} **/
	@Override
	public boolean equals(final Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || object.getClass() != getClass()) {
			return false;
		}
		final SubmitResponse other = (SubmitResponse) object;
		final EqualsBuilder builder = new EqualsBuilder();
		builder
			.append(message, other.getMessage())
			.append(success, other.isSuccess())
			.append(inputId, other.getInputId())
			.append(problemId, other.getProblemId());
		return builder.isEquals();
	}

}
