package fr.faylixe.googlecodejam.client.application;

import org.apache.commons.cli.Options;

/**
 * <p>Constants used for managing command
 * line parameters.</p>
 * 
 * @author fv
 */
public final class ApplicationConstant {

	/** Syntax of the command line script. **/
	public static final String SYNTAX = "codejamclient.sh action parameter";

	/** Short option for the initialization action. **/
	public static final String INIT = "i";

	/** Long option for the initialization action**/
	public static final String INIT_LONG = "init";

	/** Description of the initialization action. **/
	public static final String INIT_DESCRIPTION = "Initializes code jam context by logging user in, and selects an active contest and round.";

	/** Short option for the download action. **/
	public static final String DOWNLOAD = "d";

	/** Long option for the download action. **/
	public static final String DOWNLOAD_LONG = "download";

	/** Description of the download action. **/
	public static final String DOWNLOAD_DESCRIPTION = "Downloads an input file for a given problem and target dataset.";

	/** Short option for the submit action. **/
	public static final String SUBMIT = "s";

	/** Long option for the submit action. **/
	public static final String SUBMIT_LONG = "submit";

	/** Description of the submission action. **/
	public static final String SUBMIT_DESCRIPTION = "Submits an output file as solution source as well for a given problem and target dataset.";

	/** Short option for the problem parameter. **/
	public static final String PROBLEM = "p";

	/** Long option for the problem parameter. **/
	public static final String PROBLEM_LONG = "problem";

	/** Description of the problem parameter. **/
	public static final String PROBLEM_DESCRIPTION = "Problem to download or submit problem from, consists in a letter or the problem list index.";

	/** Short option for the input type parameter. **/
	public static final String INPUT_TYPE = "t";

	/** Long option for the input type parameter. **/
	public static final String INPUT_TYPE_LONG = "inputtype";

	/** Description of the input type parameter. **/
	public static final String INPUT_TYPE_DESCRIPTION = "Dataset input type, usually small or large.";

	/** Short option for the output parameter. **/
	public static final String OUTPUT = "o";

	/** Long option for the output parameter. **/
	public static final String OUTPUT_LONG = "output";

	/** Description of the output parameter. **/
	public static final String OUTPUT_DESCRIPTION = "Output file to submit.";

	/** Short option for the source parameter. **/
	public static final String SOURCE = "f";

	/** Long option for the source parameter. **/
	public static final String SOURCE_LONG = "sourcefile";

	/** Description of the source parameter. **/
	public static final String SOURCE_DESCRIPTION = "This parameter specifies the source file to upload.";

	/**
	 * Static factory method that creates the {@link Options} list
	 * for the command line arguments parsing.
	 * 
	 * @return Created options list.
	 */
	public static Options createOptions() {
		final Options options = new Options();
		options.addOption(INIT, INIT_LONG, false, INIT_DESCRIPTION);
		options.addOption(DOWNLOAD, DOWNLOAD_LONG, false, DOWNLOAD_DESCRIPTION);
		options.addOption(SUBMIT, SUBMIT_LONG, false, SUBMIT_DESCRIPTION);
		options.addOption(PROBLEM, PROBLEM_LONG, true, PROBLEM_DESCRIPTION);
		options.addOption(INPUT_TYPE, INPUT_TYPE_LONG, true, INPUT_TYPE_DESCRIPTION);
		options.addOption(OUTPUT, OUTPUT_LONG, true, OUTPUT_DESCRIPTION);
		options.addOption(SOURCE, SOURCE_LONG, true, SOURCE_DESCRIPTION);
		return options;
	}

	/**
	 * Private constructor for avoiding instantiation.
	 */
	private ApplicationConstant() {
		// Do nothing.
	}

}
