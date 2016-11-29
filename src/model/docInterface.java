package model;

import javafx.collections.ObservableList;
/**
 * List of interface used by the doctor
 * @author pradeep
 *
 */
public interface docInterface {

	
	public void AddPatient(medicine m1);
	public Integer getFid(Integer pid);
	public ObservableList<patient> findBydocId(int userId);
	public boolean checkuname(String username);
	public ObservableList<patient> findReviewBydocId(int userID);
	public String findBypID(String patientId, int did); 
	public void close();
	public patient AddPatient(patient p);
}
