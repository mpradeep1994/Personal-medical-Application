package Controller;
import java.util.List;

import javax.swing.JOptionPane;

import dao.patientDAO;
import dialogControls.dialogForm;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.mainFrame;
import model.patient;
import model.userRole;
/**
 * 
 *It is used get the review details from the patient and store in the database
 *@author pradeep
 */
public class writeReviewController extends dialogForm {
	userRole u;
	@FXML
	private ComboBox<String> mname;
	@FXML
	private Label error;
	@FXML
	private TextArea mreview;
	/**
	 * It is used to set Frame visible and close the current frame 
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
		super.close();
		mainFrame.stage.show();
		
	}
	/**
	 * It is used to populate the medicine which the patient is prescribed in drop box 
	 * @param ID ID
	 */
	public void review(int ID){
		
		System.out.println(ID);
		@SuppressWarnings("resource")
		patientDAO D1=new patientDAO();
		
		List<String> typeName =  D1.getMedicine(ID);
		System.out.println("Types: " + typeName);

		if (typeName.isEmpty()){
			error.setText("NO RECORDS FOUND ");
		}
		else{
		for (String types : typeName) {
			mname.getItems().addAll(types);
			mname.getSelectionModel().select(0);
			}	
		
		}	
	}
	/**
	 *It is used to get the review details from the patient and store in database 
	 */
	public void writeReview(){
		u = loginController.getUser(); 
	    String username =u.getUsername();
	    
		String review= this.mreview.getText();
		if(review == ""){
		
			JOptionPane.showMessageDialog(null, "enter your Review");
	
		}
		String mname = this.mname.getValue().toString();
		
		System.out.println(mname.toString() +" "+ review.toString());
		patient r1=new patient();
		
	//	review r1= new review();
		r1.setMedcineName(mname);
		r1.setReview(review);
		r1.setPid(loginController.userID());
		r1.setPatientName(username);
		@SuppressWarnings("resource")
		patientDAO d= new patientDAO();

		int did= d.getDocName(r1.getPid());
		r1.setDocId(did);
		
				
		@SuppressWarnings("resource")
		patientDAO pp=new patientDAO();
		pp.CRUD(r1);
		JOptionPane.showMessageDialog(null, "your Review Added ");
		close();
		mainFrame.stage.show();
    	
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
