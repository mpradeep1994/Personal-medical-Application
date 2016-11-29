package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * It is the main frame which extends the application class to create stage
 * @author pradeep
 *
 */
public class mainFrame extends Application {
	public static Stage stage;

	/**
	 * this method create a primary stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// mainFrame 
		try {
			stage = primaryStage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/entryPoint.fxml"));
			Scene scene = new Scene(root);
			
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	/**
	 * here is the main method
	 * @param args args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
