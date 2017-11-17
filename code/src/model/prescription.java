package model;
import java.util.ArrayList;
/**
 * It is the class about the prescription 
 * It extends the medicine class
 * @author pradeep
 *
 */
public class prescription extends medicine{
	
	private String docName;
	private String eat;
	private String pname;
	/**
	 * It will get the patient name
	 * @return pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * It will set the pname
	 * @param pname pname
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * It will set the medicine edibles
	 * @return eat
	 */
	public String getEat() {
		return eat;
	}
	/**
	 * It will set the eat items
	 * @param eat eat
	 */
	public void setEat(String eat) {
		this.eat = eat;
	}
	@SuppressWarnings("unused")
	private ArrayList<prescription> prescription;
	public String getDocName() {
		return docName;
	}
	/**
	 * It will set the doctor name
	 * @param docName docName
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	public void setPrescription(ArrayList<prescription> prescription) {
		this.prescription = prescription;
	}

}



	
	

