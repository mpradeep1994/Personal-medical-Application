package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ordersSAX {
    
    
      public static void main(String[] args){

		      try {	
		         File inputFile = new File("orders.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlerorders userhandler = new UserHandlerorders();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
}


class UserHandlerorders extends DefaultHandler{
    
    boolean OrderID = false;
    boolean customerID = false;
    boolean transaction1ID = false;
    boolean transaction2ID = false;
    boolean locationID = false;
    boolean TruckID = false;
    boolean EmployeeID = false;
    boolean isSPecial = false;
    boolean PurchaseOrderNumber = false;
    boolean OrderTotalAmount = false;
    boolean OrderDate = false;
    boolean CommentTime = false;
    boolean comments = false;
   

       
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("orders")) {
	    	         
	      } else if (qName.equalsIgnoreCase("order1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("OrderID")){
	        	OrderID = true; 
	         }
	         else if (qName.equalsIgnoreCase("customerID")) {
	        	customerID = true;
	      } 
	     else if (qName.equalsIgnoreCase("transactions")) {
	    	 
	      }
	     else if (qName.equalsIgnoreCase("transaction1ID")) {
	    	 transaction1ID = true;
	      }
	     else if (qName.equalsIgnoreCase("transaction2ID")) {
	    	 transaction2ID = true;
	      }
	     else if (qName.equalsIgnoreCase("locationID")) {
	    	 locationID = true;
	      }
	     else if (qName.equalsIgnoreCase("TruckID")) {
	    	 TruckID = true;
	      }
	     else if (qName.equalsIgnoreCase("EmployeeID")) {
	    	 EmployeeID = true;
	      }
	     else if (qName.equalsIgnoreCase("isSPecial")) {
	    	 isSPecial = true;
	      }
	     else if (qName.equalsIgnoreCase("PurchaseOrderNumber")) {
	    	 PurchaseOrderNumber = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("OrderTotalAmount")) {
	    	OrderTotalAmount = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("OrderDate")) {
	    	OrderDate = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("CommentTime")) {
	    	 CommentTime = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("comments")) {
	    	 comments = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("order2")) {
	    	
	    	
	      }
     else if (qName.equalsIgnoreCase("order3")) {
	    
	    	
	      }
     	    	 
       }
    
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("orders")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (OrderID) {
	            System.out.println("OrderID: " 
	            + new String(ch, start, length));
	            OrderID = false;
	         } else if (customerID) {
	            System.out.println("customerID: " 
	            + new String(ch, start, length));
	            customerID = false;
	         } else if (transaction1ID) {
	            System.out.println("transaction1ID: " 
	            + new String(ch, start, length));
	            transaction1ID = false;
	         } else if (transaction2ID) {
	            System.out.println("transaction2ID: " 
	            + new String(ch, start, length));
	            transaction2ID = false;
	         }
	         else if (locationID) {
		            System.out.println("locationID: " 
		            + new String(ch, start, length));
		            locationID = false;
		         }
	         else if (TruckID) {
		            System.out.println("TruckID: " 
		            + new String(ch, start, length));
		            TruckID = false;
		         }
	         
	         else if (EmployeeID) {
		            System.out.println("EmployeeID: " 
		            + new String(ch, start, length));
		            EmployeeID = false;
		         }
	         
	         else if (isSPecial) {
		            System.out.println("isSPecial: " 
		            + new String(ch, start, length));
		            isSPecial = false;
		         }
	         
	         else if (PurchaseOrderNumber) {
		            System.out.println("PurchaseOrderNumber: " 
		            + new String(ch, start, length));
		            PurchaseOrderNumber = false;
		         }
	         else if (OrderTotalAmount) {
		            System.out.println("OrderTotalAmount: " 
		            + new String(ch, start, length));
		            OrderTotalAmount = false;
		         }
	          else if (OrderDate) {
		            System.out.println("OrderDate: " 
		            + new String(ch, start, length));
		            OrderDate = false;
		         }
                    else if (CommentTime) {
		            System.out.println("CommentTime: " 
		            + new String(ch, start, length));
		            CommentTime = false;
		         }
                 else if (comments) {
		            System.out.println("comments: " 
		            + new String(ch, start, length));
		            comments = false;
		         }
                                 
                 }
}

