package Controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import main.mainFrame;

/**
 *It is the entry controller class
 * @author pradeep
 *
 */
public class entryController extends mainFrame {
	/**
	 * closes the stage and set its unvisible
	 * */
	public void close(){
	try{
				
		    // do what you have to do
		    stage.close();
		    System.exit(0);
		}
		catch(Exception e){
			System.out.println("Error occured while inflating view: " + e);	
		}
		
	}
	/**
	 * this method is used show the credit page   
	 * */
	public void credits(){
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/views/creditsPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login");
		} catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " +e);
		}
		
	}
	/**
	 * This method is take user to front page
	 * */
	public void back()
	{
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/views/entryPoint.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login");
		} catch (Exception e) {
			
			System.out.print( "Error occured while inflating view: " +e);
		}
	}
	/**
	 * This method is used navigate to the login page   
	 * */
	public void enter() {
		try {
			AnchorPane root;
			 root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/login.fxml"));
			 Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Home");
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

	

}
