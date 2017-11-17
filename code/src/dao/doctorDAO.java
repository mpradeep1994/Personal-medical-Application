package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
/**
 * 
 *DoctorDAO is used which extends the connectionSource
 *It implements the DocInterface 
 *@author pradeep
 */
public class doctorDAO extends connectionSource implements model.docInterface{

	/**
	 * IT is used to insert a new patient records
	 * @return patient 
	 */
	public patient AddPatient(patient p){
		int role= 0;Integer id=null;
		String query1 = "INSERT INTO pmohan_patient_details (firstname, lastname,gender,dob,age,docId,fid) VALUES (?,?, ?, ?, ?, ?,?) ;";
		String query2 = "INSERT INTO pmohan_login(id, username,password,role) VALUES (?,?,?,?); ";
		String query3= "SELECT * FROM pmohan_patient_details WHERE firstname= ?;";
		String query4= "INSERT INTO pmohan_family_details(fid,fname) VALUES (?,?);";
		//String query4 = "INSERT INTO pmohan_prescription(fid,fname) VALUES (?,?);";
		try(PreparedStatement statement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS))
		{
            statement.setString(1, p.getFirstname());
            statement.setString(2, p.getLastname());
            statement.setString(3, p.getGender());
            statement.setString(4, p.getDob());
            statement.setInt(5, p.getAge());
            statement.setInt(6,p.getDocId() );
            statement.setInt(7,p.getFid());
            statement.executeUpdate();
         
            PreparedStatement statement11 = connection.prepareStatement(query3);
            statement11.setString(1, p.getFirstname());
            ResultSet resultSet = statement11.executeQuery();
           while (resultSet.next())
           {
        	   id= resultSet.getInt(2);
        	   System.out.println(id);
           }
           PreparedStatement statement111 = connection.prepareStatement(query4);
           statement111.setInt(1, p.getFid());
           statement111.setString(2, p.getFirstname());
           statement111.executeUpdate();
            
           	PreparedStatement statement2 = connection.prepareStatement(query2); 
         	statement2.setInt(1,id );
        	statement2.setString(2, p.getUsername());
            statement2.setString(3, p.getPassword());
            statement2.setInt(4, role);
            statement2.executeUpdate();
		
		}
		
		catch(Exception e){
			p = null;
            System.out.println("Error Creating patient: " + e);
		} 
		
		 return p;
	}
	
	/**
	 * It is a overridden method which is used to insert the medicine details for the patient
	 *@param m1 m1
	 */
	@Override
	public void AddPatient(medicine m1) {
		
		String query1 = "INSERT INTO pmohan_prescription (pid,docId, mName,mpurpose,mTiming,pname,fid) VALUES (?,?,?, ?, ?, ?, ?) ;";
		
		try(PreparedStatement statement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS))
		{
			statement.setInt(1, m1.getPid());
			statement.setInt(2, m1.getDocId());
            statement.setString(3, m1.getMedcineName());
            statement.setString(4, m1.getMedicinePurpose());
            statement.setString(5, m1.getmTiming());
            statement.setString(6, m1.getPatientName());
            statement.setInt(7, getFid(m1.getPid()));
            statement.executeUpdate();
		}
		catch(Exception e){
	
            System.out.println("Error Creating patient: " + e);
		}

	}
	
	/**
	 *It is used to get the family ID
	 *@return a
	 *@param pid pid
	 */
	@Override
	public Integer getFid(Integer pid) {
	// TODO Auto-generated method stub
		
		Integer a = null;
		String query = "SELECT * FROM pmohan_patient_details WHERE pid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			 statement.setInt(1, pid);
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next())
			 {
				   a= resultSet.getInt(1);
				   System.out.println(a);
				   System.out.println(pid);
			 }
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		return a;	
	}
	/**
	 * It is used to create a observable list of patient
	 *@return patient 
	 */
	@Override
	public ObservableList<patient> findBydocId(int userId) {
		patient p=null;
		ObservableList<patient> patient =FXCollections.observableArrayList();
		String query = "SELECT * FROM pmohan_patient_details WHERE docId = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			System.out.println("Here I am doc!!");
			 statement.setInt(1, userId);
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()) 
			 {
	            	p= new patient();
	            	p.setFid(resultSet.getInt(1));
	            	p.setPid(resultSet.getInt(2));
	            	p.setFirstname(resultSet.getString(3));
	            	p.setLastname(resultSet.getString(4));
	            	p.setGender(resultSet.getString(5));
	            	p.setDob(resultSet.getString(6));
	            	p.setAge(resultSet.getInt(7));
	            	p.setDocId(resultSet.getInt(8));
	            	
	            	patient.add(p);
	            	
	             }
			
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patient;
	}

	/**
	 * It is used to create a observable list of reviews 
	 *@return medicine 
	 */
	@Override
	public ObservableList<patient> findReviewBydocId(int userID) {
		// TODO Auto-generated method stub
		patient m1=null;
		ObservableList<patient> review =FXCollections.observableArrayList();
		String query = "SELECT * FROM pmohan_medicine WHERE Did= ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			statement.setInt(1, userID);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				m1= new patient();
				m1.setMedcineName(resultSet.getString(1));
				m1.setReview(resultSet.getString(2));
				m1.setPatientName(resultSet.getString(4));
				m1.setPid(resultSet.getInt(3));
				m1.setDocId(userID);
				review.add(m1); 
			 } 
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return review;
	}
	
	/**
	 * It is used to get the first name of the patient based on the ID
	 * @param pname pname
	 * @return a
	 */
	public int getPid(String pname) {
		// TODO Auto-generated method stub
		Integer a= null;
		String query = "SELECT pid FROM pmohan_patient_details WHERE firstname = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			 statement.setString(1, pname);
			 ResultSet resultSet = statement.executeQuery();
			 if(resultSet.next()){
				   
				   a= resultSet.getInt(1);
			 }
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		return a;	
	}
	/**
	 * @param patientId,did
	 * @return firstname
	 */
	public String findBypID(String patientId, int did) {
		// TODO Auto-generated method stub
		String firstname= null;
		String query = "SELECT firstname FROM pmohan_patient_details WHERE pid = ? AND docId =?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
			 statement.setString(1, patientId);
			 statement.setInt(2, did);
			 ResultSet resultSet = statement.executeQuery();
			 if(resultSet.next())
			 {
				 firstname= resultSet.getString(1);
			 }
			 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstname;
	}

	/**
	 * It is used to get the list of medicines 
	 * @return mname
	 */
	public List<String> fetchTypeName() {
		// TODO Auto-generated method stub
		List<String> mname =null;
		String query = "SELECT * FROM pmohan_medicine_details;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			 ResultSet resultSet = statement.executeQuery();
			 mname= new ArrayList<String>();
			 while(resultSet.next()){
				   
				 String typeName= resultSet.getString(2);
				 mname.add(typeName);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mname;
	}
	
	/**
	 * get the last family ID in the database 
	 * @return a
	 */
	public int getlastfid() {
		// TODO Auto-generated method stub
		String query = "SELECT MAX(fid) FROM pmohan_family_details;";
		Integer a=null;
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
			 ResultSet resultSet = statement.executeQuery();
			 if(resultSet.next()){
				   
				   a= resultSet.getInt(1);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a+1;
	}
	
	/**
	 *It is used to check the username
	 *@param username username
		 */	
	public boolean checkuname(String username) {
		// TODO Auto-generated method 
		
		String  query = "select username FROM pmohan_login where username ='"+ username +"';";
		
		try {
			Statement s=connection.prepareStatement(query);
			 ResultSet resultSet = s.executeQuery(query);
			
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
