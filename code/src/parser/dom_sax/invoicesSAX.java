package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class invoicesSAX {
    
      public static void main(String[] args){

		      try {	
		         File inputFile = new File("invoices.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlerinvoices userhandler = new UserHandlerinvoices();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
}

class UserHandlerinvoices extends DefaultHandler{
    
    boolean invoiceID = false;
    boolean OrderID = false;
    boolean CustomerID = false;
    boolean PaymentID = false;
    boolean fromLocationID1 = false;
    boolean TolocationID1 = false;
    boolean fromlocationID2 = false;
    boolean TolocationID2 = false;
    boolean Description = false;
    boolean Price = false;
    boolean Quantity = false;
    boolean Contact_Name = false;
    boolean EmailAddress = false;
       
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("invoices")) {
	    	         
	      } else if (qName.equalsIgnoreCase("invoice1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("invoiceID")){
	        	invoiceID = true; 
	         }
	         else if (qName.equalsIgnoreCase("OrderID")) {
	        	OrderID = true;
	      } 
	     else if (qName.equalsIgnoreCase("CustomerID")) {
	    	 CustomerID = true;
	      }
	     else if (qName.equalsIgnoreCase("PaymentID")) {
	    	 PaymentID = true;
	      }
	     else if (qName.equalsIgnoreCase("fromLocationID1")) {
	    	 fromLocationID1 = true;
	      }
	     else if (qName.equalsIgnoreCase("TolocationID1")) {
	    	 TolocationID1 = true;
	      }
	     else if (qName.equalsIgnoreCase("fromlocationID2")) {
	    	 fromlocationID2 = true;
	      }
	     else if (qName.equalsIgnoreCase("TolocationID2")) {
	    	 TolocationID2 = true;
	      }
	     else if (qName.equalsIgnoreCase("location")) {
	    	 
	      }
	     else if (qName.equalsIgnoreCase("Description")) {
	    	 Description = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("Price")) {
	    	 Price = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("Quantity")) {
	    	 Quantity = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("Contact_Name")) {
	    	 Contact_Name = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("EmailAddress")) {
	    	 EmailAddress = true;
	    	
	      }
     	    	 
       }
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("invoices")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (invoiceID) {
	            System.out.println("invoiceID: " 
	            + new String(ch, start, length));
	            invoiceID = false;
	         } else if (OrderID) {
	            System.out.println("OrderID: " 
	            + new String(ch, start, length));
	            OrderID = false;
	         } else if (CustomerID) {
	            System.out.println("CustomerID: " 
	            + new String(ch, start, length));
	            CustomerID = false;
	         } else if (PaymentID) {
	            System.out.println("PaymentID: " 
	            + new String(ch, start, length));
	            PaymentID = false;
	         }
	         else if (fromLocationID1) {
		            System.out.println("fromLocationID1: " 
		            + new String(ch, start, length));
		            fromLocationID1 = false;
		         }
	         else if (TolocationID1) {
		            System.out.println("TolocationID1: " 
		            + new String(ch, start, length));
		            TolocationID1 = false;
		         }
	         
	         else if (fromlocationID2) {
		            System.out.println("fromlocationID2: " 
		            + new String(ch, start, length));
		            fromlocationID2 = false;
		         }
	         
	         else if (TolocationID2) {
		            System.out.println("TolocationID2: " 
		            + new String(ch, start, length));
		            TolocationID2 = false;
		         }
	         
	         else if (Price) {
		            System.out.println("Price: " 
		            + new String(ch, start, length));
		            Price = false;
		         }
	         else if (Quantity) {
		            System.out.println("Quantity: " 
		            + new String(ch, start, length));
		            Quantity = false;
		         }
	          else if (Contact_Name) {
		            System.out.println("Contact_Name: " 
		            + new String(ch, start, length));
		            Contact_Name = false;
		         }
                    else if (EmailAddress) {
		            System.out.println("EmailAddress: " 
		            + new String(ch, start, length));
		            EmailAddress = false;
		         }
                 
                 }
}

