package model;

import java.util.ArrayList;
/**
*It is the medicine class with properties about the medicine
 * @author pradeep
 */

public class medicine {
	private Integer docId;
	private String patientName;
	private Integer pid;
	private String medcineName;
	private String medicinePurpose;
	private String mTiming;
	public medicine(){
		//default constructor
		}
	/**
	 * default  constructor
	 * @param docId docId
	 * @param patientName patientName 
	 * @param medcineName medcineName
	 * @param medicinePurpose medicinePurpose
	 * @param mTiming mTiming
	 */
	public medicine(int docId,String patientName, String medcineName, String medicinePurpose, String mTiming) {
		super();
		this.docId= docId;
		this.patientName = patientName;
		this.medcineName = medcineName;
		this.medicinePurpose = medicinePurpose;
		this.mTiming = mTiming;
	}
	/**
	 * get patientName
	 * @return patientName
	 */
	public String getPatientName() {
		return patientName;
	}
	/**
	 * set patientName
	 * @param patientName patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	/**
	 * get medcineName
	 * @return medcineName
	 */
	public String getMedcineName() {
		return medcineName;
	}
	/**
	 * set the medcineName
	 * @param medcineName medcineName
	 */
	public void setMedcineName(String medcineName) {
		this.medcineName = medcineName;
	}
	/**
	 * get the medicinePurpose
	 * @return medicinePurpose
	 */
	public String getMedicinePurpose() {
		return medicinePurpose;
	}
	/**
	 * set the  medicinePurpose
	 * @param medicinePurpose medicinePurpose
	 */
	public void setMedicinePurpose(String medicinePurpose) {
		this.medicinePurpose = medicinePurpose;
	}
	/**
	 * get the medicine Timing
	 * @return mTiming
	 */
	public String getmTiming() {
		return mTiming;
	}
	/**
	 * set the medicine Timing
	 * @param mTiming mTiming
	 */
	public void setmTiming(String mTiming) {
		this.mTiming = mTiming;
	}
	/**
	 * get the DoctorID
	 * @return docId
	 */
	public Integer getDocId() {
		return docId;
	}
	/**
	 * set the doctor ID
	 * @param docId docId
	 */
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	/**
	 * get the patient Id
	 * @return pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * set the patient ID
	 * @param pid pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private ArrayList<medicine> medicine;
	
	/**
	 * 
	 * @return medicine
	 */
	public ArrayList<medicine> getPrescription() {
		return medicine;
	}
	
}
