/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dom_sax.*;
import java.util.ArrayList;
import modelDAO.DAOModel;
import java.util.Arrays;

/**
 *
 * @author Pradeep
 */

public class DAOModel {
private static Statement statement= null;

public void insertrows( ArrayList values) throws Exception{
    
    try	{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into customers (CustomerID, CustomerTitle, BusinessName, Company_Name, Contact_Name, BillingAddress, City, StateOrProvince, PostalCode, Country_Region, PhoneNumber, CellNumber, FaxNumber, EmailAddress, contact_number, Alternate_Contact_Name, DateEntered, sfrom, to_one, to_two, to_three, status) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"','"+values.get(10)+"','"+values.get(11)+"',"+
        "'"+values.get(12)+"','"+values.get(13)+"','"+values.get(14)+"','"+values.get(15)+"','"+values.get(16)+"','"+values.get(17)+"','"+values.get(18)+"',"+
        "'"+values.get(19)+"','"+values.get(20)+"','"+values.get(21)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}
}

    public void insertlocation(ArrayList values) {
     
  try	{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into locations (locationID, locName, locationCode, isAuction, address_street1, address_street2, city, state, postalCode, country_region, location_contact_name, locPhone, locFaxNumber, locEmail) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"','"+values.get(10)+"','"+values.get(11)+"',"+
        "'"+values.get(12)+"','"+values.get(13)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}
}

    public void insertprice(ArrayList values) {

             
  try	{
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into pricing (priceID, CustomerID, locationIDFrom, locationIDTO, locationCodeFrom, locationCodeTo, locationNameFrom, locationNameTo, price ) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}
        

    }

    public void insertorder(ArrayList values) {
             
  try	{
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into orders (OrderID, customerID, transaction1ID, transaction2ID, locationID, TruckID, EmployeeID, isSPecial, PurchaseOrderNumber, OrderTotalAmount, OrderDate, CommentTime, comments ) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"','"+values.get(10)+"','"+values.get(11)+"',"+
        "'"+values.get(12)+"')";
        
        System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}  
    }

    public void insertcomment(ArrayList values) {
          try	{
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into comments (commentID, customerID, transactionID, locationID, TruckID, CommentTime, comments) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"')";
       
        System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}  
    }

    public void insertpayment(ArrayList values) {
       
          try	{
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into payments (PaymentID, OrderID, PaymentMethodID, PaymentAmount, PaymentDate, ChequeNumber_CreditCard, CreditCardNumber, CardholdersName, CreditCardExpDate, CreditCardAuthorizationNumber) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
         "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"')";
       
        System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}  
    }

    public void inserttransaction(ArrayList values) {
      try	{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into transactions (transactionID, priceID, employeeID, transactionDate, transactionDescription, transactionAmount, truckid, truckNo, make, model, year, VIN, runNumber, quantity, discount, unitPrice, driverPrice, rate, surcharge, special) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"','"+values.get(10)+"','"+values.get(11)+"',"+
        "'"+values.get(12)+"','"+values.get(13)+"','"+values.get(14)+"','"+values.get(15)+"','"+values.get(16)+"','"+values.get(17)+"','"+values.get(18)+"',"+
        "'"+values.get(19)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}  
    }

    public void insertinvoice(ArrayList values) {
       try	{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into invoices (invoiceID, OrderID, CustomerID, PaymentID, fromLocationID1, TolocationID1, fromLocationID2, TolocationID2, Description, Price, Quantity, Contact_Name, EmailAddress) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"','"+values.get(10)+"','"+values.get(11)+"',"+
        "'"+values.get(12)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}    
    }

    public void insertexpense(ArrayList values) {
    try	{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into expenses (ExpenseID, EmployeeID, ExpenseType, PurposeofExpense, AmountSpent, Description, DatePurchased, DateSubmitted, AdvanceAmount, PaymentMethod) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}    
    
    
    }

    public void insertemployees(ArrayList values) {
     try{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into employees (EmployeeID, FirstName, LastName, Email, Extension, HomePhone, CellPhone, Job_title, SocialSecurityNumber, DriverLicenseNumber, Address, City, State, PostalCode, Birthdate, DateHired, Salary, Notes) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"','"+values.get(8)+"','"+values.get(9)+"','"+values.get(10)+"','"+values.get(11)+"',"+
        "'"+values.get(12)+"','"+values.get(13)+"','"+values.get(14)+"','"+values.get(15)+"','"+values.get(16)+"','"+values.get(17)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}
    }

    public void inserttruck(ArrayList values) {
     try{
        System.out.println(values.size());
        statement= connector.getConnection().createStatement();
        String sqlinsert=null;
        sqlinsert = " insert into trucks (TruckID, TruckNo, Make, Year, Model, Color, LicensePlateNo, VIN) values('"+values.get(0)+"','"+values.get(1)+"','"+values.get(2)+"','"+values.get(3)+"','"+values.get(4)+"',"+
        "'"+values.get(5)+"','"+values.get(6)+"','"+values.get(7)+"')";	
	System.out.println(sqlinsert);
        statement.executeUpdate(sqlinsert);
	System.out.println("record inserted into the table Customers");
	statement.close();
        
        }	
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}   
    }
}