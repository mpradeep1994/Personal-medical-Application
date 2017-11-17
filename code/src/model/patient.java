package model;

import java.util.ArrayList;

/**
 *It extends the review class
 *It has the details about the patient 
 * @author pradeep
 */

public class patient extends review  {
	
	private Integer fid;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private Integer age;
	private String dob;
	private String gender;
	private Integer docId;
	private Integer pid;
	private ArrayList<patient> patient;
	/**
	 * default constructor
	 */
	public patient()
	{
	super();
		//default constructor	
	}
	/**
	 * parameterised constructor
	 * @param firstname firstname
	 * @param lastname lastname
	 * @param username username
	 * @param password password
	 * @param age age
	 * @param  dob dob
	 * @param gender gender
	 * @param docId docId
	 */
	public patient(String firstname, String lastname, String username, String password, Integer age, String dob,
			String gender, Integer docId) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.setDocId(docId);
	}
	/**
	 * get the firstname
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * set the first name of the patiet
	 * @param firstname firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * It gets the lastname
	 * @return lastname
	 */
	
	public String getLastname() {
		return lastname;
	}
	/**
	 *  it sets the lastname
	 * @param lastname lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * get the username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * it sets the username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * get the password
	 * @return password password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * It will set the Password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * it will get the age
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * It will set the age
	 * @param age age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * it will get the DOB
	 * @return dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * It will set the DOB
	 * @param dob dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * It will get the gender
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * It will set the gender
	 * @param gender gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * It will get the docter ID
	 * @return docId
	 */
	public Integer getDocId() {
		return docId;
	}
	/**
	 * It will set the Doctor ID
	 * @param docId docId
	 */

	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public ArrayList<patient> getAccounts() {
		return patient;
	}

	public void setAccounts(ArrayList<patient> accounts) {
		this.patient = accounts;
	}
	/**
	 * It will get the Patient ID
	 * @return pid
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * It will set the patient ID
	 * @param pid pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * It will get the Family Id
	 * @return fid
	 */
	public Integer getFid() {
		return fid;
	}
	/**
	 * It will set the family id
	 * @param fid fid
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	
}
