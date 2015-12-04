package fr.faylixe.googlecodejam.client.webservice;

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

}
