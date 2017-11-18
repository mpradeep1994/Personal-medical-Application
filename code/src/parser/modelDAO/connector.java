/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

/**
 *
 * @author Pradeep
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {

		static Connection connect= null;

		// JDBC driver name and database URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	    //string contains the URL for the DB
	    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/soa";
 	   //Database credentials
	    static final String USER = "root";
	    static final String PASS = "root";
/**
 * It creates the connection to the database
 * @return connection
 */
	   public static Connection getConnection(){
		   try{ 
			// sets the Driver for the Program
			Class.forName("com.mysql.jdbc.Driver");  
			//establish connection for the database based on the Username and password
			connect = DriverManager.getConnection(DB_URL, USER,PASS);
			connect.createStatement();
                        System.out.println("connection established!!");
			}
			catch(SQLException e){
			System.out.println("Problem while connecting: contact Administrator ");
			System.out.println(e.getMessage());
			}
			catch (ClassNotFoundException e){
			System.out.println("Problem while connecting: contact Administrator");
			e.printStackTrace();
			}
		return connect;	
	}
	
}