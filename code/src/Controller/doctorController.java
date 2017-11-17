package Controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import dao.doctorDAO;
import dao.patientDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.mainFrame;
import model.docInterface;
import model.patient;
import model.patientInterface;
import model.prescription;
import model.userRole;


/**
 *
 *  This class is used for the doctor interface
 * It show all the functionalities that an doctor can do
 * function: ADD PATIEN, ADD PRESCRIPTION, VIEW REVIEW FOR MEDICINE; VIEW PATIENT 
 * @author pradeep
 *
 * */
public class doctorController  {

	public static String username= "";
	public static String patientId;
	userRole u;
	//get all the FXML items 
	@FXML
	private Label uname,date;
	@FXML
	public TextField pname;
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

	public doctorController()  {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * It is used to close the current window
	 * */
	public void close(){
	try{
			loginController.logout();
			AnchorPane root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));// do what you have to do   
		    Scene scene = new Scene(root);
			mainFrame.stage.setScene(scene);
			mainFrame.stage.setTitle("Login");
		}
		catch(Exception e){
			System.out.println("Error occured while inflating view: " + e);	
		}
	}
	/**
	 * It show the credit page
	 * */
	public void credits(){
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/views/creditsPage.fxml"));
			Scene scene = new Scene(root);
			mainFrame.stage.setScene(scene);
			mainFrame.stage.setTitle("CREDITS");
		} catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " +e);
		}
		
		
	}
	/**
	 * This method take the doctor to the add patient view
	 * */
	public void addPatient(){
	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/addPatient.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("ADD PATIENT");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);  
            addPatientController controller = loader.getController();
            controller.setfid();
            controller.setDialogStage(dialogStage);
            dialogStage.show();
            mainFrame.stage.hide();

		}catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " +e.getMessage());
		}
	}

	/**
	 * This method set the username by using the PAtient ID
	 * */
	public void setPname() 
	{
	doctorController.patientId = pname.getText();
	@SuppressWarnings("resource")
	docInterface c = new doctorDAO();
		try
		{
			username = c.findBypID(doctorController.patientId, loginController.userID());		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method returns the username
	 * @return username
	 * */
	public static String getPname()
	{
		return username;
	}
	/**
	 * This method take the doctor to write patient prescription
	 * doctor need to enter the patient ID
	 * */
	public void writePrescription() {
		
			if( pname.getText().equalsIgnoreCase(""))
			{ 
				JOptionPane.showMessageDialog(null, "please enter a vaid patient ID");
				return;
			}
			setPname();
			String unamee =username;
			System.out.println(unamee );
			
			if(unamee== null || unamee.trim().equals(""))

			{
				JOptionPane.showMessageDialog(null, "please enter a vaid patient ID");
				return;
				
			}	
			try
			{
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/addPrescription.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("ADD PATIENT");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	        addPrescription controller = loader.getController();
	        controller.setProperty(pname.getText());
	        controller.setDialogStage(dialogStage);
	        mainFrame.stage.hide();
	        dialogStage.show();
			} 
			catch (Exception e) 
			{
				System.out.print( "Error occured while inflating view: " +e);
			}
	}

	/**
	 * This method take the doctor to view the prescription 
	 * It shows only the prescription given by that particular doctor  
	 * */
	public void viewPrescription(){
		try
		 {
			
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/viewdPrescription.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("VIEW PRISCRIPTION");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	       
				ObservableList<prescription> prescription; 
				patientInterface c1 = new patientDAO();
			
				{
					
				prescription =  c1.findBydID(loginController.userID());
			
				c1.close();
				}
						
			 viewPrescription vpc= loader.getController();
			 vpc.setDialogStage(dialogStage);
			 vpc.setData(FXCollections.observableArrayList(prescription));
			 mainFrame.stage.hide();
			 dialogStage.show();
	        
			 }
			catch (Exception e) {
			
			System.out.print( "Error werwer occured while inflating view: " + e.getLocalizedMessage());
			}
		
	}
	
	/**
	 * This method sets the basic screen details for the doctor login
	 */
	public void setScene() {
			
			// TODO Auto-generated method stub
			u = loginController.getUser(); 
		    doctorController.username=u.getUsername();
		    uname.setText(username +"!!");
		    date.setText(timeStamp);
			mainFrame.stage.show();
		}


	/**
	 * This method take the doctor to view his patient
	 */
public void viewPatients(){
	try {
		
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/viewPatients.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("VIEW PRESCRIPTION");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	       
			//array 
	        @SuppressWarnings("resource")
			docInterface c = new doctorDAO();
			ObservableList<patient> patients = null; 
			 try
			 {		
			         patients = c.findBydocId(loginController.userID());
			       
	         }
			 catch(Exception e){
				 System.out.print( "Error occured while inflating view: " +e.getMessage());
				 
	        }
			viewPatientController vpc= loader.getController();
			vpc.setData(FXCollections.observableArrayList(patients));
			vpc.setDialogStage(dialogStage);
			mainFrame.stage.hide();
	        dialogStage.show();
			
		} 
		catch (Exception e){
		
		System.out.print( "Error occured while inflating view: " +e.getMessage());
		}
}


/**
 * This method take the doctor to the view the medicine review
  */
public void writeReview(){
	try {
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/viewReview.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("VIEW REVIEW");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	     	ObservableList<patient> patient = null; 
			@SuppressWarnings("resource")
			docInterface c = new doctorDAO();
				 try
				 {
					 System.out.println(loginController.userID());
					 patient = c.findReviewBydocId(loginController.userID());
				       
		         }
				catch (Exception e)
				{
				System.out.print( "Error occured while inflating view: " +e.getMessage());
				}
				 
			viewReviewController vpc= loader.getController();
			vpc.setData(FXCollections.observableArrayList(patient));
			vpc.setDialogStage(dialogStage);
			mainFrame.stage.hide();
	        dialogStage.show();
			} 
		catch (Exception e) {
		
		System.out.print( "Error occured while inflating view: " +e);
	}
}
}
