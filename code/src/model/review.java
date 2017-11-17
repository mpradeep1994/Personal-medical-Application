package model;

/**
 * It is the class for review with medicinal review properties
 * @author pradeep
 *
 */
public class review {
	private Integer pid;
	private String medcineName;
	private String review;
	private String patientName;
	//private int did;
	
	/**
	 * It will get the patient name  
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * It will set the patient name
	 * @param patientName patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * It will give the patient ID
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
	 * It will give the medcineName
	 * @return medcineName
	 */
	public String getMedcineName() {
		return medcineName;
	}
	/**
	 * It will set the medcineName 
	 * @param medcineName medcineName
	 */
	public void setMedcineName(String medcineName) {
		this.medcineName = medcineName;
	}
	/**
	 * It will get review
	 * @return review
	 */
	public String getReview() {
		return review;
	}
	/**
	 * It will set the review
	 * @param review review
	 */
	public void setReview(String review) {
		this.review = review;
	}
	
	
	
}
