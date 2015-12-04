package fr.faylixe.googlecodejam.client.webservice;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author fv
 */
public final class SubmitResponse {

	/** **/
	@SerializedName("msg")
	private String message;

	/** **/
	@SerializedName("ok")
	private boolean success;

	/** **/
	@SerializedName("inputId")
	private int inputId;

	/** **/
	@SerializedName("problemId")
	private int problemId;

	/**
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * 
	 * @return
	 */
	public int getInputId() {
		return inputId;
	}

	/**
	 * 
	 * @return
	 */
	public int getProblemId() {
		return problemId;
	}

}
