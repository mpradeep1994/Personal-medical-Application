package model;

import javafx.collections.ObservableList;
/**
 * It is a interface with list of methods used by the patient
 * @author pradeep
 *
 */
public interface patientInterface {

	public ObservableList<prescription> findBypID(int userID);
	public ObservableList<prescription> findBydID(int userID);
	public String pName(String mname,String mpurpose,String mtime);
	public String docName(int docid);
	public patient getProfile(int userID);
	public String getDocName2(int did);	
	public ObservableList<prescription> findBypfID(int a);
	public Integer getDocName(Integer a);
	public void CRUD(patient r1);
	public void CRUD(Integer pid);
	public void close();
	public void updateProfile(patient pupdate);

		
}
