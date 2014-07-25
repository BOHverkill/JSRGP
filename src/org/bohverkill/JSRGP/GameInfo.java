/**
 * Java Steam Random Games Picker Package
 */
package org.bohverkill.JSRGP;

/**
 * Game infos for steam games
 * 
 * @author BOHverkill
 * @version 1.0
 * @see JSRGPControl
 * @see JSRGPModel
 * @see JSRGPView
 */
public class GameInfo {
	private int appID;
	private String name;

	/**
	 * The default constructor
	 */
	public GameInfo() {
		this(0, "");
	}

	/**
	 * The constructor
	 * 
	 * @param appID
	 *            new AppID
	 * @param name
	 *            new Name
	 * 
	 */
	public GameInfo(int appID, String name) {
		this.appID = appID;
		this.name = name;
	}

	/**
	 * Return the AppID of the object
	 * 
	 * @return the AppID
	 */
	public int getAppID() {
		return appID;
	}

	/**
	 * Set the AppID of the object
	 * 
	 * @param appID
	 *            the AppID to set
	 */
	public void setAppID(int appID) {
		this.appID = appID;
	}

	/**
	 * Return the Name of the object
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Name of the object
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
