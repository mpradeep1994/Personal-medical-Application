package Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.doctorDAO;
import dao.patientDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.mainFrame;
import model.prescription;
import model.userRole;
/**
 * This class is used for the patient interface
 * It show all the functionalities that a patient can do
 * function: VIEW PRESCRIPTION, VIEW FAMILY MEMBERS PRESCRIPTION 
 * @author pradeep
 */

public class patientController {
	
	public  String username;
	userRole u;
	public patientController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * set the user logged out of the application
	 */
	public void logout(){
		
		try{
			loginController.logout();
			AnchorPane root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
		    Scene scene = new Scene(root);
			mainFrame.stage.setScene(scene);
			mainFrame.stage.setTitle("Login");
			}
		catch(Exception e){
			System.out.println("Error occured while inflating view: " + e);	
		}
		
	}

	@FXML
	private Label uname,date;
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

	/**
	 * Set the patient interface with the name of the patient and insert the date in the screen  
	 */
	public void setScene() 
	{
		    u = loginController.getUser(); 
		    @SuppressWarnings("resource")
			patientDAO p1 = new patientDAO();
		    this.username= p1.getfirstName(u.getId());
		    uname.setText(username +"!!");
		    mainFrame.stage.show();
			date.setText(timeStamp);				
	}
	
	/**
	 * It is used to move the user to write Review for the medicine
	 * Patient can write review only for the medicines which he is prescribed for  
	 * */
	public void writeReview(){
		try
		 {
			
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/writeReview.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("WRITE REVIEW");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	        writeReviewController wr= loader.getController();
	        wr.review(loginController.userID());
	        wr.setDialogStage(dialogStage);
			mainFrame.stage.hide();
			dialogStage.show();        
			 }
			catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " + e.getLocalizedMessage());
			}
		
	}
	
	/**
	 * It is used to move the patient to view the user profile
	 * Patient can update the details about the profile 
	 * */
	public void view(){
		
		try
		 {
			
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/viewProfile.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("VIEW PROFILE");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  

	        viewUpdateProfile vp= loader.getController();
	    	vp.findBypID(loginController.userID());
		    vp.setDialogStage(dialogStage);


			 mainFrame.stage.hide();
			 dialogStage.show();
	        
			 }
			catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " + e.getLocalizedMessage());
			}
		
	}
	/**
	 * Patient can view the family members prescription 
	 * */
	public void viewfPrescription()
	{
		try
		 {
			
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/familyPrescription.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("VIEW FAMILY PRISCRIPTION");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	       
				ObservableList<prescription> fprescription; 
				patientDAO c1 = new patientDAO();
				try(doctorDAO D1 = new doctorDAO())
				{
					 System.out.println(loginController.userID());
					int a = D1.getFid(loginController.userID());
					
					fprescription =  c1.findBypfID(a);
			
				c1.close();
				}
			 viewfPrescription vpc= loader.getController();
			 vpc.setDialogStage(dialogStage);
			 vpc.setData(FXCollections.observableArrayList(fprescription));
			
			 mainFrame.stage.hide();
			 dialogStage.show();
	        
			 }
			catch (Exception e) {
			
			System.out.print( "Error werwer occured while inflating view: " + e.getLocalizedMessage());
			}
		
	
		}


	/**
	 * It is used to view the patient prescription written by the doctor
	 * */
	public void viewPrescription()
	{
		try
		 {
			
			FXMLLoader loader  =new  FXMLLoader(getClass().getResource("/views/viewPrescription.fxml"));
			AnchorPane root =(AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("VIEW PRISCRIPTION");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        Scene scene = new Scene(root);
	        dialogStage.setScene(scene);  
	       
				ObservableList<prescription> prescription; 
				patientDAO c1 = new patientDAO();
				{
					 System.out.println(loginController.userID());
				prescription =  c1.findBypID(loginController.userID());
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


}
