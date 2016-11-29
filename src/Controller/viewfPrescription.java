package Controller;

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
 *THIS CLASS IS USED TO DISPLAY THE FAMILY PRESCRIPTION
 *IT EXTENDS THE DIALOGFORM CLASS
 *@author pradeep
 */
public class viewfPrescription  extends dialogForm{
	@FXML
	private TableView<prescription> fprescription;
	
	/**
	 * it is used to display the prescription for the family members
	 * @param prescription prescription
	 */
	@SuppressWarnings("unchecked")
	public void setData(ObservableList<prescription> prescription){
		
		
		this.fprescription.getItems().addAll(prescription);
		
		TableColumn<prescription, String> titleCol7 = new TableColumn<prescription,String >("PATIENT NAME");
		 titleCol7.setCellValueFactory(new PropertyValueFactory<prescription,String >("pname"));
		
		TableColumn<prescription, Integer> titleCol0 = new TableColumn<prescription,Integer >("DOCTER  ID");
		 titleCol0.setCellValueFactory(new PropertyValueFactory<prescription, Integer>("docId"));
		 
		 TableColumn<prescription, String> titleCol2 = new TableColumn<prescription,String >("MEDICINE NAME");
		 titleCol2.setCellValueFactory(new PropertyValueFactory<prescription,String >("medcineName"));
				
		 TableColumn<prescription, Integer> titleCol4 = new TableColumn<prescription,Integer >("MEDICINE TIMING");
		 titleCol4.setCellValueFactory(new PropertyValueFactory<prescription,Integer>("eat"));		
		
		 TableColumn<prescription, String> titleCol3 = new TableColumn<prescription,String >("MEDICINE PURPOSE");
		 titleCol3.setCellValueFactory(new PropertyValueFactory<prescription,String >("medicinePurpose"));
	
		 TableColumn<prescription, String> titleCol5 = new TableColumn<prescription,String >("DOCTOR NAME");
		 titleCol5.setCellValueFactory(new PropertyValueFactory<prescription,String >("docName"));
		 
		 
		 this.fprescription.getColumns().setAll(titleCol7,titleCol0,titleCol2,titleCol3,titleCol4,titleCol5);
		
		
	}
	
	
	/**
	 * set the stage active and hides the previous view
	
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

}
