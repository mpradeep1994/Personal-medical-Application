package Controller;


import dao.loginDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import main.mainFrame;
import model.userRole;
/**
 * 
 *
 *This class is used to check the user login 
 *based on the role navigate to doctor or patient
 * @author pradeep
 */
public class loginController {

	/**
	 * default constructor
	 */
	public loginController() {
		// TODO Auto-generated constructor stub
	}
	
	private static userRole user;
	@FXML 
	private Label error1,error2;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	
	public static int id;
	public void reset(){
		
		try{
		this.username.clear(); 
		//this.username.setText("");
		this.password.clear();
		return;
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	

	/**
	 * This method take user based on the role
	 * DOCTOR AND PATIENT are the roles available
	 * */
	public void login() {
		userRole u;
		String username = this.username.getText();
		String password = this.password.getText();
		//Validations
		if(username == null || username.trim().equals("")) {
			error1.setText("Username Cannot be empty or spaces");
			return;
		}
		if(password == null || password.trim().equals("")) {
			error2.setText("Password Cannot be empty or spaces");
			return;
		}
		
		
		//Get user
				loginDao l = new loginDao();
				u = l.getByUsername(username);
				l.close();
				if(u == null) {
					error1.setText("USER NAME CANNOT BE EMPTY");
					return;
				}
				//If user not found
				System.out.println(u.getUsername());
				System.out.println(username);
				if(!u.getUsername().equals(username)) {
					error1.setText("ENTER A VALID USER NAME");
					return;
				}
				//If passwords dont match
				if(!(u.getPassword().equals(password.trim()))) {
					error2.setText("Username and Password dont match");
					return;
				}
				//Set user as Logged in user
				user = u;
				
				try {
					AnchorPane root;
					
					if(user.getIsDoc()) {
						
						//If user is admin, inflate admin view
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/doctor.fxml"));
						 root = loader.load();
						doctorController dc= loader.getController();
						
						dc.setScene();
					}
					else {
						//If user is customer, inflate customer view
						
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/patients.fxml"));
					root = loader.load();
					patientController pc= loader.getController();
					pc.setScene();	
					}
					
					Scene scene = new Scene(root);
					mainFrame.stage.setScene(scene);
					mainFrame.stage.setTitle("Home");
					mainFrame.stage.show();
				}
				catch(Exception e) {
					System.out.println("Error occured while inflating view: " +e.getMessage());
				}
				
			}
		/**
		 * gives the userRole
		 * @return useRole
		 */
			public static userRole getUser() {
				return user;
			}
			/**
			 * gives the user ID
			 * @return id
			 */
			public static int userID(){
				
				id= user.getId();
				return id;
				
			}
			/**
			 * closes the stage
			 * 
			 */
			
			public void close(){
				try{
						
				    // do what you have to do
				    mainFrame.stage.close();
				    System.exit(0);
				}
				catch(Exception e){
					System.out.println("Error occured while inflating view: " + e);	
				}
				
			}
			/**
			 * takes the users to the credit page
			 */
			public void credits(){
				try {
					AnchorPane root = FXMLLoader.load(getClass().getResource("/views/creditsPage.fxml"));
					Scene scene = new Scene(root);
					mainFrame.stage.setScene(scene);
					mainFrame.stage.setTitle("Login");
				} catch (Exception e) {
					
					System.out.print( "Error occured while inflating view: " +e);
				}
				
			}
			/**
			 *clear the error fields 
			 */
			public void clear(){
				
				this.error1.setText("");
				this.error2.setText("");
			}
				
				/**
				 * makes the user logged out
				 */
			public static void logout() {
				user = null;
			}
}
	

