package fr.faylixe.googlecodejam.client.common;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Class that represents a object which
 * could be identified by a name.</p>
 * 
 * @author fv
 */
public class NamedObject implements Serializable {

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** Name of this object. **/
	@SerializedName("name")
	private String name;

	/**
	 * Default constructor.
	 */
	protected NamedObject() {
		// Protected constructor for avoiding raw instantiation.
	}
	
	/**
	 * Constructor with name parameter
	 * that should be used when such object
	 * are created without using JSON serialization.
	 * 
	 * @param name Name of this object.
	 */
	protected NamedObject(final String name) {
		this.name = name;
	}

	/**
	 * Getter for the name of this object.
	 * 
	 * @return Name of this object.
	 * @see #name
	 */
	public final String getName() {
		return name;
	}

}
