package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomersSAX {
    
    	   public static void main(String[] args){

		      try {	
		         File inputFile = new File("Customers.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlercustomer userhandler = new UserHandlercustomer();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
}

class UserHandlercustomer extends DefaultHandler{
    
    boolean CustomerID = false;
    boolean CustomerTitle = false;
    boolean BusinessName = false;
    boolean Company_Name = false;
    boolean Contact_Name = false;
    boolean BillingAddress = false;
    boolean City = false;
    boolean StateOrProvince = false;
    boolean PostalCode = false;
    boolean Country_Region = false;
    boolean PhoneNumber = false;
    boolean CellNumber = false;
    boolean FaxNumber = false;
    boolean EmailAddress = false;
    boolean contact_number= false;
    boolean Alternate_Contact_Name = false;
    boolean DateEntered = false;
    boolean from = false;
    boolean to_one = false;
    boolean to_two = false;
    boolean to_three = false;
    boolean status = false;
    
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("customers")) {
	    	         
	      } else if (qName.equalsIgnoreCase("customer1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("CustomerID")){
	        	CustomerID = true; 
	         }
	         else if (qName.equalsIgnoreCase("CustomerTitle")) {
	        	 CustomerTitle = true;
	      } 
	     else if (qName.equalsIgnoreCase("BusinessName")) {
	    	 BusinessName = true;
	      }
	     else if (qName.equalsIgnoreCase("Company_Name")) {
	    	 Company_Name = true;
	      }
	     else if (qName.equalsIgnoreCase("Contact_Name")) {
	    	 Contact_Name = true;
	      }
	     else if (qName.equalsIgnoreCase("address")) {
	    	 
	      }
	     else if (qName.equalsIgnoreCase("BillingAddress")) {
	    	 BillingAddress = true;
	      }
	     else if (qName.equalsIgnoreCase("City")) {
	    	 City = true;
	      }
	     else if (qName.equalsIgnoreCase("StateOrProvince")) {
	    	 StateOrProvince = true;
	      }
	     else if (qName.equalsIgnoreCase("PostalCode")) {
	    	 PostalCode = true;
	    	
	      }
	     else if(qName.equalsIgnoreCase("Country_Region")){
	    		 Country_Region = true;
	    	 }
	    	 else if (qName.equalsIgnoreCase("contactdetails")) {
	    		 
	      } 
	    	 else if(qName.equalsIgnoreCase("contactnumber")){
	    		 
	    	 }
	    	 else if (qName.equalsIgnoreCase("PhoneNumber")) {
	    		 PhoneNumber = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("CellNumber")) {
	    		 CellNumber = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("FaxNumber")) {
	    		 FaxNumber = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("EmailAddress")) {
	    		 EmailAddress = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("alternatecontact")) {
	    		 
	      } 
	    	 else if(qName.equalsIgnoreCase("DateEntered")){
	    		 DateEntered = true;
	    	 }
	    	 else if (qName.equalsIgnoreCase("Eligibility")) {
	    		
	      } 
	    	 else if (qName.equalsIgnoreCase("from")) {
	    		 from = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("to")) {
	    		
	      } 
	    	 else if (qName.equalsIgnoreCase("to_one")) {
	    		 to_one = true;
	      } 
    
                 else if (qName.equalsIgnoreCase("to_two")) {
	    		 to_two = true;
	      } 
    
                else if (qName.equalsIgnoreCase("to_three")) {
	    		 to_three = true;
	      } 
    
                else if (qName.equalsIgnoreCase("status")) {
	    		 status = true;
	      } 
    
       }
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("customers")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (CustomerID) {
	            System.out.println("CustomerID: " 
	            + new String(ch, start, length));
	            CustomerID = false;
	         } else if (CustomerTitle) {
	            System.out.println("CustomerTitle: " 
	            + new String(ch, start, length));
	            CustomerTitle = false;
	         } else if (BusinessName) {
	            System.out.println("BusinessName: " 
	            + new String(ch, start, length));
	            BusinessName = false;
	         } else if (Company_Name) {
	            System.out.println("Company_Name: " 
	            + new String(ch, start, length));
	            Company_Name = false;
	         }
	         else if (Contact_Name) {
		            System.out.println("Contact_Name: " 
		            + new String(ch, start, length));
		            Contact_Name = false;
		         }
	         else if (BillingAddress) {
		            System.out.println("BillingAddress: " 
		            + new String(ch, start, length));
		            BillingAddress = false;
		         }
	         
	         else if (City) {
		            System.out.println("City: " 
		            + new String(ch, start, length));
		            City = false;
		         }
	         
	         else if (StateOrProvince) {
		            System.out.println("StateOrProvince: " 
		            + new String(ch, start, length));
		            StateOrProvince = false;
		         }
	         
	         else if (PostalCode) {
		            System.out.println("PostalCode: " 
		            + new String(ch, start, length));
		            PostalCode = false;
		         }
	         else if (Country_Region) {
		            System.out.println("Country_Region: " 
		            + new String(ch, start, length));
		            Country_Region = false;
		         }
	         else if (PhoneNumber) {
		            System.out.println("PhoneNumber: " 
		            + new String(ch, start, length));
		            PhoneNumber = false;
		         }
	         else if (CellNumber) {
		            System.out.println("CellNumber: " 
		            + new String(ch, start, length));
		            CellNumber = false;
		         }
	         else if (FaxNumber) {
		            System.out.println("FaxNumber: " 
		            + new String(ch, start, length));
		            FaxNumber = false;
		         }
	         else if (EmailAddress) {
		            System.out.println("EmailAddress: " 
		            + new String(ch, start, length));
		            EmailAddress = false;
		         } 
                  else if (contact_number) {
		            System.out.println("contact_number: " 
		            + new String(ch, start, length));
		            contact_number = false;
		         } 
                  else if (Alternate_Contact_Name) {
		            System.out.println("Alternate_Contact_Name: " 
		            + new String(ch, start, length));
		            Alternate_Contact_Name = false;
		         } 
                  else if (DateEntered) {
		            System.out.println("DateEntered: " 
		            + new String(ch, start, length));
		            DateEntered = false;
		         } 
                  else if (from) {
		            System.out.println("from: " 
		            + new String(ch, start, length));
		            from = false;
		         } 
                  else if (to_one) {
		            System.out.println("to_one: " 
		            + new String(ch, start, length));
		            to_one = false;
		         } 
                  else if (to_two) {
		            System.out.println("to_two: " 
		            + new String(ch, start, length));
		            to_two = false;
		         } 
                  else if (to_three) {
		            System.out.println("to_three: " 
		            + new String(ch, start, length));
		            to_three = false;
		         } 
                  else if (status) {
		            System.out.println("status: " 
		            + new String(ch, start, length));
		            status = false;
		         } 
                  
                 
                 }
}
   


