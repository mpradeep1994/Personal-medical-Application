package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
/**
 * It is used to hold 
 *It extends connection Source
 *It implements the patientInterface
 * @author pradeep
  */
public class patientDAO  extends connectionSource implements patientInterface {
	/**
	 *It creates the observable prescription
	 *@param userID userID 
	 *@return prescription 
	 *
	 */
	@Override
	public ObservableList<prescription> findBypID(int userID) {
		// TODO Auto-generated method stub
		prescription p=null;
		ObservableList<prescription> prescription =FXCollections.observableArrayList();
		String query = "SELECT * FROM pmohan_prescription WHERE pid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
				statement.setInt(1, userID);
			 	ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 p= new prescription();
				 p.setDocId(resultSet.getInt(3));
				 p.setMedcineName(resultSet.getString(4));
				 p.setMedicinePurpose(resultSet.getString(5));
				 p.setEat(resultSet.getString(6));
				 p.setPatientName(resultSet.getString(7));
				 p.setDocName(docName(resultSet.getInt(3)));
				 p.setPid(resultSet.getInt(2));
				 prescription.add(p);
		 }
	 }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return prescription;
	}
	
	/**
	 *It creates the observable list of prescription for user ID
	 *@param userID userID 
	 *@return prescription  
	 */
		public ObservableList<prescription> findBydID(int userID) {
		// TODO Auto-generated method stub
		prescription p=null;
		
		ObservableList<prescription> prescription =FXCollections.observableArrayList();
		String query = "SELECT * FROM pmohan_prescription WHERE docId = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
			 statement.setInt(1, userID);
			 ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				 p= new prescription();
				 p.setDocId(resultSet.getInt(3));
				 p.setMedcineName(resultSet.getString(4));
				 p.setMedicinePurpose(resultSet.getString(5));
				 p.setEat(resultSet.getString(6));
				 p.setPatientName(resultSet.getString(7));
				 p.setPid(resultSet.getInt(2));
				 p.setDocName(docName(resultSet.getInt(3)));
				// p.setDocName(pName(resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
				 prescription.add(p);
		 }
		 }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return prescription;
	}
		/**
		 * @param mname mname,mpurpose mpurpose,mtime mtime
		 * It is used insert the prescription for the patient
		 * @return dname
		 */
	@Override
	public String pName(String mname,String mpurpose,String mtime) {
		// TODO Auto-generated method stub
		String dname=null;
		String query = "SELECT * FROM pmohan_prescription WHERE mName = ? AND mPurpose = ?  AND mTiming = ? ;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			 statement.setString(1, mname);
			 statement.setString(2, mpurpose);
			 statement.setString(3, mtime);
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()) 
			 {
				 dname= resultSet.getString(7);
			 }
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	
		return dname;
	}
	
	/**
	 * @param docid
	 * It is used find the docname based on the DocID
	 * @return dname
	 */
	@Override
	public String docName(int docid) {
		// TODO Auto-generated method stub
		String dname=null;
		String query = "SELECT * FROM pmohan_docter_detail WHERE docId = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
			 statement.setInt(1, docid);
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()) 
			 {
				 dname= resultSet.getString(2);
			 }
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	
		return dname;
	}
	/**
	 * It is used to fetch the user details based on the user ID
	 * @param userID userID
	 * @return patient
	 * 
	 */
	@Override
	public patient getProfile(int userID) {
		// TODO Auto-generated method stub
		patient pp=null;
		String query = "SELECT * FROM pmohan_patient_details WHERE pid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
			 statement.setInt(1, userID);
			 ResultSet resultSet1 = statement.executeQuery();
			 System.out.println("bgvf"); 
			
			 while(resultSet1.next()) 
			 {
				 pp = new patient();
				 pp.setPid(userID);
				
				 pp.setFirstname(resultSet1.getString(3)); 
				 pp.setLastname(resultSet1.getString(4));
				 pp.setGender(resultSet1.getString(5));
				 pp.setDob(resultSet1.getString(6));
				 pp.setAge(resultSet1.getInt(7));
				 
			 }
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return pp;
	}
	/**
	 * It is used to update the user details based on the user ID
	 * @param pupdate pupdate
	 *
	 */
	@Override
	public void updateProfile(patient pupdate) {
		// TODO Auto-generated method stub
		String query = " UPDATE pmohan_patient_details SET firstname = ? , lastname = ? , gender = ? , dob = ?, age =?  WHERE pid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			 statement.setString(1, pupdate.getFirstname());
			 statement.setString(2, pupdate.getLastname());
			 statement.setString(3, pupdate.getGender());
			 statement.setString(4, pupdate.getDob());
			 statement.setInt(5, pupdate.getAge());
			 statement.setInt(6, pupdate.getPid());
			statement.executeUpdate();
			 System.out.println("update done");
		}
		catch(Exception e){
			System.out.println("update problem " + e);
			e.printStackTrace();
		}

	}
	/**
	 *It creates the observable list of prescription for user ID
	 *@param a a  
	 *@return prescription   
	 */
	@Override
	public ObservableList<prescription> findBypfID(int a) {
		// TODO Auto-generated method stub
		prescription p=null;
		
		ObservableList<prescription> prescription =FXCollections.observableArrayList();
		String query = "SELECT * FROM pmohan_prescription WHERE fid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			System.out.println(a);
			 statement.setInt(1, a);
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 p= new prescription();
				 p.setDocId(resultSet.getInt(3));
				 p.setMedcineName(resultSet.getString(4));
				 p.setMedicinePurpose(resultSet.getString(5));
				 p.setEat(resultSet.getString(6));
				 p.setDocName(docName(resultSet.getInt(3)));
				 p.setPname(resultSet.getString(7));
				 prescription.add(p);
		 }
		 }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return prescription;
	}
/**
 * It is used to find the list of medicines 
 * @param PID PID
 * @return mname mname
 */
	public List<String> getMedicine(int PID) {
		// TODO Auto-generated method stub
		List<String> mname =null;
		String query = "SELECT * FROM pmohan_prescription WHERE pid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{ 
			
			 statement.setInt(1, PID);
			 ResultSet resultSet1 = statement.executeQuery();
			 mname= new ArrayList<String>();
			 while(resultSet1.next()) 
			 {
				
				String typeName = (resultSet1.getString(4));
				
				mname.add(typeName);
			
			 }
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(mname);
		return mname;
	}
	/**
	 * It is used to insert the medicine review by the patient
	 *@param r1 r1
	 */
	public void CRUD(patient r1) {
		// TODO Auto-generated method stub
		String query1 = "INSERT INTO pmohan_medicine (medicineName, review,pid,pname,Did) VALUES ( ?, ?, ?,?,?) ;";
		
		try(PreparedStatement statement = connection.prepareStatement(query1))
		{ 
			statement.setString(1, r1.getMedcineName());
			statement.setString(2, r1.getReview());	
			statement.setString(4, r1.getPatientName());
			statement.setInt(3, r1.getPid());
			statement.setInt(5, r1.getDocId());
			statement.executeUpdate();
		}
		
	catch(Exception e){
	System.out.println(e.getMessage());	
	}
}
	/**
	 * It is used to get the doctorid based on the patientID
	 *@param PID PID 
	 */
	public Integer getDocName(Integer PID)
	{
		Integer docid=null;
		String query = "SELECT * FROM pmohan_patient_details WHERE pid = ?;";
		
		try(PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setInt(1,PID);
			ResultSet resultSet1 = statement.executeQuery();
			while(resultSet1.next()){
				docid = resultSet1.getInt(8);
			
			}
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return docid;
	}

	public String getDocName2(int did) {
		// TODO Auto-generated method stub
		String docName=null;
		String query = "SELECT * FROM pmohan_docter_detail WHERE docId = ?;";
		
		try(PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setInt(1,did);
			ResultSet resultSet1 = statement.executeQuery();
			while(resultSet1.next()){
				docName = resultSet1.getString(2);
			
			}
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return docName;
	}
	/**
	 * It is used to delete the particular prescription from the database
	 * @param pid pid
	 */
	@Override
	public void CRUD(Integer pid) {
		// TODO Auto-generated method stub
		
		String query ="delete from  pmohan_prescription where pid = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setInt(1,pid);
			statement.executeUpdate();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
				
	}
	/**
	 * It is used to find the name of the patient
	 * @param  integer integer
	 * @return patientName
	 */
	public String getfirstName(Integer integer) {
		// TODO Auto-generated method stub
		String patientName=null;
		String query = "SELECT * FROM pmohan_patient_details WHERE pid = ?;";
		
		try(PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setInt(1,integer);
			ResultSet resultSet1 = statement.executeQuery();
			while(resultSet1.next()){
				patientName = resultSet1.getString(3);
			
			}
			
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return patientName;

	}
	

}
