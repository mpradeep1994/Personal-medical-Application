package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.userRole;

/**
 * It is used to check the login 
 *It extends connection Source
 * @author pradeep
 */
public class loginDao extends connectionSource  {

	/**
	 * It is used to get user details based on the username
	 * @param username username
	 * @return user
	 */
	public userRole  getByUsername(String username) {
		userRole  user = null;
		String query = "SELECT * FROM pmohan_login WHERE username = ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	user = new userRole(
            			resultSet.getInt("id"),
            			resultSet.getString("username"),
            			resultSet.getString("password"),
            			resultSet.getBoolean("role")
            		);
            }
        } catch(SQLException e){
            System.out.println("Error Finding User by Username: " + e);
        }
        return user;
    }
}
