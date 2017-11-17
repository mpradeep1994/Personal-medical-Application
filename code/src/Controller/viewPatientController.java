package Controller;

import javax.swing.JOptionPane;

import dialogControls.dialogForm;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.mainFrame;
import model.patient;
/**
 * It is used to list the patient list of the particular doctor
 *IT EXTENDS THE DIALOGFORM CLASS
 *@author pradeep
 */
public class viewPatientController extends dialogForm {
	
	@FXML
	private TableView<patient> patient;
	
	/**
	 * It sets the patient details into the tabel view
	 * @param patients patients
	 */
	@SuppressWarnings("unchecked")
	public void setData(ObservableList<patient> patients) {

		for(int i=0;i<patients.size();i++)
		{
			 System.out.println(patients.get(i).getDocId());
			 System.out.println(patients.get(i).getFirstname());
		}

	     this.patient.getItems().setAll(patients);
		 TableColumn<patient, String> titleCol0 = new TableColumn<patient,String >("PATIENT ID");
		 titleCol0.setCellValueFactory(new PropertyValueFactory<patient, String>("pid"));
		 TableColumn<patient, String> famid = new TableColumn<patient,String >("FAMILY ID");
		 famid.setCellValueFactory(new PropertyValueFactory<patient,String >("fid"));
		 
		 TableColumn<patient, String> titleCol = new TableColumn<patient,String >("FIRST NAME");
		 titleCol.setCellValueFactory(new PropertyValueFactory<patient, String>("firstname"));
		 
		 
		 TableColumn<patient, String> titleCol2 = new TableColumn<patient,String >("LAST NAME");
		 titleCol2.setCellValueFactory(new PropertyValueFactory<patient,String >("lastname"));

		 TableColumn<patient, String> titleCol3 = new TableColumn<patient,String >("AGE");
		 titleCol3.setCellValueFactory(new PropertyValueFactory<patient,String >("age"));
		
		 TableColumn<patient, String> titleCol4 = new TableColumn<patient,String >("DOB");
		 titleCol4.setCellValueFactory(new PropertyValueFactory<patient,String >("dob"));
		 
		 TableColumn<patient, String> titleCol5 = new TableColumn<patient,String >("GENDER");
		 titleCol5.setCellValueFactory(new PropertyValueFactory<patient,String >("gender"));
		 
		 TableColumn<patient, String> titleCol6 = new TableColumn<patient,String >("DOC_ID");
    	 titleCol6.setCellValueFactory(new PropertyValueFactory<patient,String >("docId"));

		 patient.getColumns().setAll(titleCol0,famid,titleCol,titleCol2,titleCol3,titleCol4,titleCol5,titleCol6);
		 	
	}
	
	/**
	 * It is used close the particular view and shows the  
	
	 */
	public void setSelected(){
	
			patient setp = new patient();
			setp.setFirstname(null);
		setp = this.patient.getSelectionModel().getSelectedItem();
		//System.out.println(setp.getFirstname().);
		if(this.patient.getSelectionModel().getSelectedItem()== null)
		{
			JOptionPane.showMessageDialog(null, "select a patient");
			return;
		}
		System.out.println(setp.getFirstname());
		try {
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/addPrescription.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("ADD PATIENT");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	        addPrescription controller = loader.getController();
	        controller.setPropertyFromTable(setp.getFirstname(),setp.getPid());
	        controller.setDialogStage(dialogStage);
	        mainFrame.stage.hide();
	        dialogStage.show();
			
		} catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " +e);
		}
		
		
		
	}
		
	/**
	 * It is used close the particular view and shows the  
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		super.close();
		mainFrame.stage.show();
	}

	/**
	 * It is used close the particular view and shows the  
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	

	
}
