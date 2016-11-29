package Controller;

import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JOptionPane;

import dao.doctorDAO;
import dialogControls.dialogForm;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.mainFrame;
import model.patient;
import model.*;
/**
 * It is used to get the information from the doctor about the patient and add him as a patient
 * It extends the dialogFrom class 
 * @author pradeep
 *
 */
public class addPatientController extends dialogForm {
	//private fields of the view
	userRole u;
	@FXML
	private TextField firstname;
	@FXML
	private Label newfid;
	@FXML
	private TextField fid;
	@FXML
	private Label error1,error2,error3,error4,error5,error6;
	@FXML
	private TextField username;
	@FXML
	private TextField lastname;
	@FXML
	private TextField password;
	@FXML
	private TextField age;
	@FXML
	private ToggleGroup  gender;
	@FXML
	private RadioButton male;
	@FXML
	private RadioButton female;
	@FXML
	private DatePicker dob;
	@FXML
	private ProgressBar pb;
	@FXML
	private ProgressIndicator pi;
	
	double status= 0.0;
	
	/**
	 *This method is used to add the patient 
	  */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		u= loginController.getUser();
		Integer docId= u.getId();
		
		String fid = this.fid.getText();
		if( fid.trim().equals("")) {
					
					error1.setText("enter your family ID");
					return;
				}
		
		String firstname = this.firstname.getText();
		if(firstname == null || firstname.trim().equals("")) {
					
					error2.setText("enter your first name");
					return;
				}
		String lastname = this.lastname.getText();	
		if(lastname == null || lastname.trim().equals("")) {
			error3.setText("lastName cannot be empty");
			return;
		}
		
		String username = this.username.getText();
		if(username == null || username.trim().equals("")) {
			error4.setText("username cannot be empty");
			return;
		}
		String password = this.password.getText();
		if(password == null || password.trim().equals("")) {
			error5.setText("password cannot be empty");
			return;
		}
		
		String age =  this.age.getText();
		
			
			String gender="MALE";
			LocalDate dobb;
			String dob="";
		try
			{			
				dobb = this.dob.getValue();
				dob= dobb.toString();
				
				if(female.isSelected())
				{
					gender = "FEMALE";
				} 
		 	
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		if(dob == null || dob.equals("")) {
			error6.setText("please select your date of birth");
			return;
		}
		pb.setProgress(0.6f);
		if( (isNumeric(age)) ||   age == null || age.equals("")) {
			error5.setText("enter your age");
			return;
		}
		try{
		pb.setProgress(1.0);
        patient p1= new patient();
        p1.setFid(Integer.parseInt(this.fid.getText()));
        p1.setAge(Integer.parseInt(age));
        p1.setDob(dob);
        p1.setFirstname(firstname);
        p1.setLastname(lastname);
        p1.setGender(gender);
        p1.setPassword(password);
        p1.setUsername(username);
        p1.setDocId(docId);
    	
        	@SuppressWarnings("resource")
        	docInterface d1=new doctorDAO();
        	
        	d1.AddPatient(p1);
        	JOptionPane.showMessageDialog(null, "Patient  Record Added ");
        	
        }
        catch(Exception e){
        	System.out.printf("Error Creating patient: " + e.getMessage());
  
        }
        
		//System.out.println( this.gender.getText());
		mainFrame.stage.show();
		close();
		
	}
	/**
	 *This method is used to check if the username is already exists in the database 
	 */	
	public void checjDuplicateUname() {
		// TODO Auto-generated method stub

		String username = this.username.getText();
		@SuppressWarnings("resource")
		docInterface d1=new doctorDAO();
		boolean a= d1.checkuname(username);
		if (a == true){
			JOptionPane.showMessageDialog(null, "please enter a New username!!  USERNAME ALREADY IN USE");
			this.username.setText("");
			
			return;
		}
	}  
	/**
	 *This method is used to set the age based on the date selected in date picker 
	 */	
	public	void setage(){
		try{
		int year1=0;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		LocalDate a= this.dob.getValue();
		year1 = a.getYear();
		int age = year - year1;
		String sage= "" +age;
		this.age.setText(sage);
		}
		catch(Exception e)
		{
			System.out.println("set again");
			e.printStackTrace();
		}
	}
	/**
	 *It is used to check whether it is a number or not 
	 */	
	boolean isNumeric(String a){
		try{
			Integer.parseInt(a);
		}
		catch(NumberFormatException ex)
	    {
	        return true;
	    }
			
	return false;
	}

	public void statusbar(){
		status = status + .20;
		pi.setProgress(status);
	}
	public void statusComplete(){
		pb.setProgress(1.00);
	}
/**
 * set the default Family ID
 */
	public void setfid(){
		
		@SuppressWarnings("resource")
		doctorDAO d1=new doctorDAO();
		int a = d1.getlastfid();
		System.out.println(a);
		String aa =  Integer.toString(a);
		fid.setText(aa);	
	}
	/**
	 * clear the error message
	 */
	public void error1(){
		error1.setText("");
	}

	/**
	 * clear the error message
	 */
	public void error2(){
		
		error2.setText("");
		
	}

	/**
	 * clear the error message
	 */
	public void error3(){
	
	error3.setText("");
	
	}

	/**
	 * clear the error message
	 */
	public void error4(){
	
	error4.setText("");
	
}

	/**
	 * clear the error message
	 */	
	public void error5(){
	error5.setText("");
	}

	/**
	 * clear the error message
	 */	
	public void error6(){
	
	error6.setText("");
	
		}
	/**
	 *This method is used to set all field empty
	*/	
	
	public void reset() {
		this.fid.setText("");
		this.firstname.setText("");
		this.lastname.setText("");
		this.username.setText("");
		this.password.setText("");
		this.age.setText("");
		this.dob.setValue(null);
		pi.setProgress(0);
		status=0;
	}
	/**
	 *This method is used to close the connection 
	 */	

	public void close()
	{
	mainFrame.stage.show();		
	super.close();
	
	}
	
	
	
	
}
