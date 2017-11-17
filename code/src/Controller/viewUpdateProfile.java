package Controller;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;
import dao.patientDAO;
import dialogControls.dialogForm;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import main.mainFrame;
import model.patient;
/**
 * It displays all the details about the patient and It can updated by the patient
 * @author pradeep
 *
 */
public class viewUpdateProfile extends dialogForm {

	@FXML
	private TextField id;
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField age;
	@FXML
	private Text error;
	@FXML
	private DatePicker dob;
	@FXML
	private ToggleGroup  gender;
	@FXML
	private RadioButton male;
	@FXML
	private RadioButton female;
	
	String date1;
	String genderset= "MALE";
	
/**
 * It is used to find the patient details based on the currently logged in user	ID
 * @param userID userID
 */
public void findBypID(int userID) {
		
		patient p=new patient();
		System.out.println(userID);
		try
		{
			
			@SuppressWarnings("resource")
			patientDAO D1=new patientDAO();
			p= D1.getProfile(userID);

		}
		catch(Exception e){
			System.out.println("error while fetching records" + e.getStackTrace());
		}
			
			id.setText(p.getPid().toString());
		
			firstname.setText(p.getFirstname());
			lastname.setText(p.getLastname());
			age.setText(p.getAge().toString());
		
			if(p.getGender() == "FEMALE"){
				female.setSelected(true);
			}
			
			dob.setPromptText(p.getDob());
			date1 = p.getDob();
	}
	
	/**
	 * It is used to calculate the age of the patient when he selects the date of birth
	 */
	public void setdob(){
		
		int year1=0;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		LocalDate d= dob.getValue();
		date1= d.toString();
		
		year1 = d.getYear();
		int age = year - year1;
		String sage= "" +age;
		this.age.setText(sage);
		
	}
	/**
	 * It is used to clear 
	 */
	public void clear(){
		error.setText("");
	}
	/**
	 *It is overridden to update the patient profile
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub
		String  firstname = this.firstname.getText();
		
		if(firstname == null || firstname.trim().equals("")) {
			
			error.setText("enter your first name");
			return;
		}
		String lastname = this.lastname.getText();
		if(lastname == null || lastname.trim().equals("")) {
			error.setText("lastName cannot be empty");
			return;
		}
		
		int age = Integer.parseInt(this.age.getText().toString());
	
		if(female.isSelected())
		{
			genderset = "FEMALE";
		} 
		
		String dob = date1;
		int pid = Integer.parseInt(this.id.getText());
		@SuppressWarnings("resource")
		patientDAO D1=new patientDAO();
		patient pupdate = new patient();
		pupdate.setFirstname(firstname);
		pupdate.setLastname(lastname);
		pupdate.setGender(genderset);
		pupdate.setDob(dob);
		pupdate.setAge(age);
		pupdate.setPid(pid);
		try{
		D1.updateProfile(pupdate);
		JOptionPane.showMessageDialog(null, "Update done");
		}
		catch(Exception e ){
			System.out.println("error while updating");
			e.printStackTrace();
		}
	}
	/**
	 *It will clear the fields 
	 */
	@Override
	public void reset() {
		this.age.setText("");
		this.dob.setPromptText("");
		this.firstname.setText("");
		
		this.lastname.setText("");
			
	}
	/**
	 * It is used to set Frame visible and close the current frame 
	 */
	public void back(){
		 mainFrame.stage.show();
		 super.close();
	}

}
