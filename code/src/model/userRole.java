package model;

/**
 * It will have the basic details about the user
 * @author pradeep
 *
 */
public class userRole {

	private String username;
	private String password;
	private Integer id;
	private Boolean isDoc;
	
	/**
	 * Parameterized constructor
	 * @param id id
	 * @param username username
	 * @param password password
	 * @param isDoc isDoc
	 */
	public userRole( int id ,String username, String password, Boolean isDoc ) {
	
		this.username = username;
		this.password = password;
		this.isDoc = isDoc;
		this.id= id;
	}

	/**
	 * it will give the username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * It will set the username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * It will give the password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * It will set the password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * It will give boolean value based on the role
	 * @return isDoc
	 */
	public Boolean getIsDoc() {
		return isDoc;
	}
	/**
	 * It will set boolean the role 
	 * @param isDoc isDoc
	 */
	public void setIsDoc(Boolean isDoc) {
		this.isDoc = isDoc;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}
