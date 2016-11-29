package Controller;
import javax.swing.JOptionPane;

import dao.patientDAO;
import dialogControls.dialogForm;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.mainFrame;
import model.prescription;
/**
 * 
 *this is used to show the prescription
 *@author pradeep
 */
public class viewPrescription extends dialogForm {
	@FXML
	private TableView<prescription> prescription;
	
	/**
	 * it is used to display the prescription in the table view
	 * @param prescription prescription
	 */ 
	@SuppressWarnings("unchecked")
	public void setData(ObservableList<prescription> prescription){
		
	
		this.prescription.getItems().addAll(prescription);

	   	TableColumn<prescription, Integer> titleCol0 = new TableColumn<prescription,Integer >("DOCTER  ID");
		 titleCol0.setCellValueFactory(new PropertyValueFactory<prescription, Integer>("docId"));
		 
		 TableColumn<prescription, String> titleCol2 = new TableColumn<prescription,String >("MEDICINE NAME");
		 titleCol2.setCellValueFactory(new PropertyValueFactory<prescription,String >("medcineName"));
		 
		 TableColumn<prescription, String> titleCol7 = new TableColumn<prescription,String >("DOCTOR NAME");
		 titleCol7.setCellValueFactory(new PropertyValueFactory<prescription,String >("docName"));
		 
		
		 TableColumn<prescription, Integer> titleCol4 = new TableColumn<prescription,Integer >("MEDICINE TIMING");
		 titleCol4.setCellValueFactory(new PropertyValueFactory<prescription,Integer>("eat"));		
	
		 TableColumn<prescription, Integer> titleCol9 = new TableColumn<prescription,Integer >("PATIENT ID");
		 titleCol9.setCellValueFactory(new PropertyValueFactory<prescription,Integer>("pid"));		
		

		 TableColumn<prescription, String> titleCol3 = new TableColumn<prescription,String >("MEDICINE PURPOSE");
		 titleCol3.setCellValueFactory(new PropertyValueFactory<prescription,String >("medicinePurpose"));
	


		 this.prescription.getColumns().setAll(titleCol0,titleCol9,titleCol2,titleCol3,titleCol4,titleCol7);
		
		
	}
/**
 * It is used to select a particular patient record and update the prescription details
 */
	public void delete(){
		prescription setp = new prescription();
		
	setp = this.prescription.getSelectionModel().getSelectedItem();
	//System.out.println(setp.getFirstname().);
	if(this.prescription.getSelectionModel().getSelectedItem()== null)
	{
		JOptionPane.showMessageDialog(null, "select a prescription");
		return;
	}
	System.out.println(setp.getPid());
	patientDAO c1 = new patientDAO();
	 c1.CRUD(setp.getPid());
	 c1.close();
	 
			JOptionPane.showMessageDialog(null, "Prescription Removed");
			
	
			super.close();
			mainFrame.stage.show();	
			return;
	
	}
/**
 * it is used to hide the previous view and set the current page
 */
	public void save()
	{
		super.close();
		mainFrame.stage.show();
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}





}

