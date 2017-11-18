package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class employeesSAX {
    
    	   public static void main(String[] args){

		      try {	
		         File inputFile = new File("employees.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandleremployees userhandler = new UserHandleremployees();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
}


class UserHandleremployees extends DefaultHandler{
    
    boolean EmployeeID = false;
    boolean FirstName = false;
    boolean LastName = false;
    boolean Email = false;
    boolean Extension = false;
    boolean HomePhone = false;
    boolean CellPhone = false;
    boolean Job_title = false;
    boolean SocialSecurityNumber = false;
    boolean DriverLicenseNumber = false;
    boolean Address = false;
    boolean City = false;
    boolean State = false;
    boolean PostalCode = false;
    boolean Birthdate= false;
    boolean DateHired = false;
    boolean Salary = false;
    boolean Notes = false;

    
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("employees")) {
	    	         
	      } else if (qName.equalsIgnoreCase("employee1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("EmployeeID")){
	        	EmployeeID = true; 
	         }
	         else if (qName.equalsIgnoreCase("Name")) {
	        	
	      } 
	     else if (qName.equalsIgnoreCase("FirstName")) {
	    	 FirstName = true;
	      }
	     else if (qName.equalsIgnoreCase("LastName")) {
	    	 LastName = true;
	      }
	     else if (qName.equalsIgnoreCase("contact")) {
	    	 
	      }
	     else if (qName.equalsIgnoreCase("Email")) {
	    	 Email = true;
	      }
	     else if (qName.equalsIgnoreCase("Extension")) {
	    	 Extension = true;
	      }
	     else if (qName.equalsIgnoreCase("HomePhone")) {
	    	 HomePhone = true;
	      }
	     else if (qName.equalsIgnoreCase("CellPhone")) {
	    	 CellPhone = true;
	      }
	     else if (qName.equalsIgnoreCase("Job_title")) {
	    	 Job_title = true;
	    	
	      }
	     else if(qName.equalsIgnoreCase("SocialSecurityNumber")){
	    		 SocialSecurityNumber = true;
	    	 }
	    	 else if (qName.equalsIgnoreCase("DriverLicenseNumber")) {
	    		 DriverLicenseNumber = true;
	      } 
	    	 else if(qName.equalsIgnoreCase("Location")){
	    		 
	    	 }
	    	 else if (qName.equalsIgnoreCase("Address")) {
	    		 Address = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("City")) {
	    		 City = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("State")) {
	    		 State = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("PostalCode")) {
	    		 PostalCode = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("Birthdate")) {
	    		 Birthdate = true;
	      } 
	    	 else if(qName.equalsIgnoreCase("DateHired")){
	    		 DateHired = true;
	    	 }
	    	 else if (qName.equalsIgnoreCase("Salary")) {
	    		Salary = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("Notes")) {
	    		 Notes = true;
	      } 
              
              else if (qName.equalsIgnoreCase("employee1")) {
	    		 
	      } 
	    	 
       }
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("employees")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (EmployeeID) {
	            System.out.println("EmployeeID: " 
	            + new String(ch, start, length));
	            EmployeeID = false;
	         } else if (FirstName) {
	            System.out.println("FirstName: " 
	            + new String(ch, start, length));
	            FirstName = false;
	         } else if (LastName) {
	            System.out.println("LastName: " 
	            + new String(ch, start, length));
	            LastName = false;
	         } else if (Email) {
	            System.out.println("Email: " 
	            + new String(ch, start, length));
	            Email = false;
	         }
	         else if (Extension) {
		            System.out.println("Extension: " 
		            + new String(ch, start, length));
		            Extension = false;
		         }
	         else if (HomePhone) {
		            System.out.println("HomePhone: " 
		            + new String(ch, start, length));
		            HomePhone = false;
		         }
	         
	         else if (CellPhone) {
		            System.out.println("CellPhone: " 
		            + new String(ch, start, length));
		            CellPhone = false;
		         }
	         
	         else if (Job_title) {
		            System.out.println("Job_title: " 
		            + new String(ch, start, length));
		            Job_title = false;
		         }
	         
	         else if (SocialSecurityNumber) {
		            System.out.println("SocialSecurityNumber: " 
		            + new String(ch, start, length));
		            SocialSecurityNumber = false;
		         }
	         else if (DriverLicenseNumber) {
		            System.out.println("DriverLicenseNumber: " 
		            + new String(ch, start, length));
		            DriverLicenseNumber = false;
		         }
	         else if (Address) {
		            System.out.println("Address: " 
		            + new String(ch, start, length));
		            Address = false;
		         }
	         else if (City) {
		            System.out.println("City: " 
		            + new String(ch, start, length));
		            City = false;
		         }
	         else if (State) {
		            System.out.println("State: " 
		            + new String(ch, start, length));
		            State = false;
		         }
	         else if (PostalCode) {
		            System.out.println("PostalCode: " 
		            + new String(ch, start, length));
		            PostalCode = false;
		         } 
                  else if (Birthdate) {
		            System.out.println("Birthdate: " 
		            + new String(ch, start, length));
		            Birthdate = false;
		         } 
                  else if (DateHired) {
		            System.out.println("DateHired: " 
		            + new String(ch, start, length));
		            DateHired = false;
		         } 
                  else if (Salary) {
		            System.out.println("Salary: " 
		            + new String(ch, start, length));
		            Salary = false;
		         } 
                  else if (Notes) {
		            System.out.println("Notes: " 
		            + new String(ch, start, length));
		            Notes = false;
		         } 
                  
                 
                 }
}
   
