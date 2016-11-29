package Controller;
import dialogControls.dialogForm;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.mainFrame;
import model.patient;
/**
 * 
 *It is used to show the review written by the patient on the tablet on which he is prescribed
 *extend the dialogForm class
 *@author pradeep
 */
public class viewReviewController extends dialogForm  {

	@FXML
	private TableView<patient> review;
	/**
	 * It is used close the particular view and shows the  
	
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		super.close();
		mainFrame.stage.show();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}
	/**
	 *It is used set the particular view and shows the  
	 *@param review review
	 */
	@SuppressWarnings("unchecked")
	public void setData(ObservableList<patient> review) {
	
		this.review.getItems().addAll(review);
			
		TableColumn<patient, String> titleCol1 = new TableColumn<patient,String >("DOCTER ID");
		 titleCol1.setCellValueFactory(new PropertyValueFactory<patient,String >("docId"));
		 
		 
		 TableColumn<patient, String> titleCol2 = new TableColumn<patient,String >("PATIENT ID");
		 titleCol2.setCellValueFactory(new PropertyValueFactory<patient,String >("pid"));
		 
		 TableColumn<patient, String> titleCol3 = new TableColumn<patient,String >("PATIENT NAME");
		 titleCol3.setCellValueFactory(new PropertyValueFactory<patient,String >("patientName"));
		 
		 TableColumn<patient, String> titleCol4 = new TableColumn<patient,String >("MEDICINE NAME");
		 titleCol4.setCellValueFactory(new PropertyValueFactory<patient,String >("medcineName"));
		 
		 TableColumn<patient, String> titleCol5 = new TableColumn<patient,String >("MEDICINE REVIEW");
		 titleCol5.setCellValueFactory(new PropertyValueFactory<patient,String >("review"));
		 
		 this.review.getColumns().setAll(titleCol2,titleCol3,titleCol4,titleCol5,titleCol1);
	}

}
