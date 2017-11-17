package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import dao.doctorDAO;
import dialogControls.dialogForm;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import main.mainFrame;
import model.prescription;
import model.userRole;

/**
 * It is used to add prescription by the doctor for his patient 
 * It extends the dialogFrom class 
 * @author pradeep
 *
 */
public class addPrescription extends dialogForm {
	userRole u;
	double status= 0.0;
	@FXML
	private TextField patientName; 
	@FXML
	private TextField problemName;
	
	@FXML
	private CheckBox M,A,N;
	@FXML
	private ProgressIndicator pbar;
	@FXML
	private Hyperlink back;
	@FXML
	private ComboBox<String> medicinelist  ;
	@FXML
	private Label error1,error2,error3,error4;
	
	public String a;
	public int id;
	
	/*
	 * This method is used to get the list of medicines from the database which the doctor can prescribe
	 * list the medicines in dropbox
	 * */
	 public void setProperty(String id)
	 {	
		 this.id=Integer.parseInt(id); 
		 System.out.println(id + "for this ID" );
		 a= doctorController.getPname();
		 patientName.setText(a);
		 	 try
			{
			@SuppressWarnings("resource")
			doctorDAO pd=new doctorDAO();
			List<String> medicineName = pd.fetchTypeName();
			System.out.println("Types: " + medicineName);

			for (String types : medicineName) {
				medicinelist.getItems().addAll(types);
				medicinelist.getSelectionModel().select(0);
			}
			}
		 catch(Exception e)
			{
			 
			 error3.setText("medcine list not available right now");
			 System.out.println("medcine list not available"+ e.getMessage());
			}
	 	 
	 }
	 /*
	  * This method is used to get the list of medicines from the database which the doctor can prescribe
	  * list the medicines in dropbox
	  * */
	 public void setPropertyFromTable(String a,int pid)
	 {
		 id= pid;
		 patientName.setText(a);
		 System.out.println(id + "for this ID insert medicine" );
		 	 try
			{
			@SuppressWarnings("resource")
			doctorDAO pd=new doctorDAO();
			List<String> medicineName = pd.fetchTypeName();
			System.out.println("Types: " + medicineName);

			for (String types : medicineName) {
				medicinelist.getItems().addAll(types);
				medicinelist.getSelectionModel().select(0);
				
			}
			}
		 catch(Exception e)
			{
			 System.out.println("medcine list not available"+ e.getMessage());
			}
	 	 
	 }
	
	/**
	 *This method is used to store the  prescribed medicine for the user into database
	 */

	public void save() {
		// TODO Auto-generated method stub
		u= loginController.getUser();
		String M1="0";
		String A1="0";
		String N1="0";
		Integer pid = null;
		Integer docId= u.getId();
	
		String pname = patientName.getText();
		if(pname == null || pname.trim().equals("")) {
			
			JOptionPane.showMessageDialog(null, "enter your first name");
			return;
		}
		
		String probname = problemName.getText();

		if(probname == null || probname.trim().equals("")) {
			
			JOptionPane.showMessageDialog(null, "enter Problem name");
			return;
		}
		 String medicine = null;
		 medicine = this.medicinelist.getValue().toString();
		 System.out.println(medicine);
		
		if(medicine == null || medicine.trim().equals(""))
		{
			
			JOptionPane.showMessageDialog(null, "enter medicine name");
			return;
		}
		
		try
		{

		pid=id;
			System.out.println(pid);
		}
		
		catch(Exception e)
		{
			System.out.print ("Wrong patient name" );
			System.out.println(" cannot find match");
			JOptionPane.showMessageDialog(null, "enter valid name");
			close();
			return ;
		}
		if(M.isSelected()){	 M1= "M";}
		if(A.isSelected()){	 A1= "A";}
		if(N.isSelected()){	 N1= "N";}
		
		String mTime = M1+ "-" + A1 + "-" + N1; 
		if(mTime.equalsIgnoreCase("0-0-0") )
		{
			JOptionPane.showMessageDialog(null, "please Enter the medicine Timings");
		
			return ;	
			
		}
		System.out.println(mTime);

		prescription m1= new prescription();
		m1.setDocId(docId);
		m1.setMedcineName(medicine);
		m1.setMedicinePurpose(probname);
		m1.setmTiming(mTime);
		m1.setPatientName(pname);
		m1.setPid(pid);
		try{
	        	@SuppressWarnings("resource")
				doctorDAO d1=new doctorDAO();
	        	
	             d1.AddPatient(m1);
	        	 int reply = JOptionPane.showConfirmDialog(null, "Patient Record inserted!! ADD NEW ?", "ADD NEW", JOptionPane.YES_NO_OPTION);
	             if (reply == JOptionPane.YES_OPTION) {
	             reset(); 
	             }
	             else 
	             {
	              close(); 
	              mainFrame.stage.show();
	             }

	        }
	        catch(Exception e){
	        	System.out.println("Error ADDING PRESCRIPTION: " + e.getMessage());
	        }
		
	}
	/**
	 *This method is used to status of the process
	 */
	public void statusbar(){
		status = status + .25;
		
		pbar.setProgress(status);
		}
	
	/**
	 *This method is used to clear all the fields
	 */
	
	public void reset() {
		
	this.problemName.setText("");
		
		M.setSelected(false);
		A.setSelected(false);
		N.setSelected(false);
		pbar.setProgress(0);
		status=0;
	}
	/**
	 *This method is used to close current window
	 */
	public void back(){
		   close(); 
           mainFrame.stage.show();
	}


}
