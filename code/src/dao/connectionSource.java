package dao;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * It is the class which implements the connection to the database
 *It implements the AutoCloseable
 *@author pradeep
 */
	public class connectionSource implements AutoCloseable {
		
		protected Connection connection;
	    private String url = "jdbc:mysql://www.papademas.net:3306/510labs";
	    private String username = "db510";
	    private String password = "510";
	    public connectionSource() 
	    {
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(url,username,password);
	        } catch(SQLException|  ClassNotFoundException e) {
	            System.out.println("Error creating connection to database: " + e);
	            System.exit(-1);
	        }
	    }
	    
		/**
		 * Closes the connection and set the connection to NULL
		 */
	    @Override
		public void close() {
	    	try {
	            connection.close();
	            connection = null;
	        } catch(SQLException e) {
	            System.out.println("Error closing connection: " + e);
	        }
		}
}


