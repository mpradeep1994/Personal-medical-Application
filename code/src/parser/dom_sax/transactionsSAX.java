package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class transactionsSAX {
    
    public static void main(String[] args){

		      try {	
		         File inputFile = new File("transactions.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlertransactions userhandler = new UserHandlertransactions();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
}



class UserHandlertransactions extends DefaultHandler{
    
    boolean transactionID = false;
    boolean OrderID = false;
    boolean priceID = false;
    boolean employeeID = false;
    boolean transactionDate = false;
    boolean transactionDescription = false;
    boolean transactionAmount = false;
    boolean TruckID = false;
    boolean truckNo = false;
    boolean make = false;
    boolean model = false;
    boolean year = false;
    boolean VIN = false;
    boolean runNumber = false;
    boolean quantity= false;
    boolean discount = false;
    boolean unitPrice = false;
    boolean driverPrice = false;
    boolean rate = false;
    boolean surcharge = false;
    boolean special = false;
    
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("transactions")) {
	    	         
	      } else if (qName.equalsIgnoreCase("transaction1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("transactionID")){
	        	transactionID = true; 
	         }
	         else if (qName.equalsIgnoreCase("OrderID")) {
	        	 OrderID = true;
	      } 
	     else if (qName.equalsIgnoreCase("priceID")) {
	    	 priceID = true;
	      }
	     else if (qName.equalsIgnoreCase("employeeID")) {
	    	 employeeID = true;
	      }
	     else if (qName.equalsIgnoreCase("transactionDate")) {
	    	 transactionDate = true;
	      }
	     else if (qName.equalsIgnoreCase("transactionDescription")) {
	    	 transactionDescription = true;
	      }
	     else if (qName.equalsIgnoreCase("transactionAmount")) {
	    	 transactionAmount = true;
	      }
	     else if (qName.equalsIgnoreCase("truck_detail")) {
	    	 
	      }
	     else if (qName.equalsIgnoreCase("TruckID")) {
	    	 TruckID = true;
	      }
	     else if (qName.equalsIgnoreCase("truckNo")) {
	    	 truckNo = true;
	    	
	      }
	     else if(qName.equalsIgnoreCase("car_details")){
	    		 
             }
	    	 else if (qName.equalsIgnoreCase("make")) {
	    		 make = true;
	      } 
	    	 else if(qName.equalsIgnoreCase("model")){
	    		 model = true;
	    	 }
	    	 else if (qName.equalsIgnoreCase("year")) {
	    		 year = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("VIN")) {
	    		 VIN = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("runNumber")) {
	    		 runNumber = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("quantity")) {
	    		 quantity = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("Price_estimate")) {
	    		 
	      } 
	    	 else if(qName.equalsIgnoreCase("discount")){
	    		 discount = true;
	    	 }
	    	 else if (qName.equalsIgnoreCase("driverPrice")) {
	    		driverPrice = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("rate")) {
	    		 rate = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("surcharge")) {
	    		surcharge = true;
	      } 
	    	 else if (qName.equalsIgnoreCase("special")) {
	    		 special = true;
	      } 
    
  }
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("transactions")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (transactionID) {
	            System.out.println("transactionID: " 
	            + new String(ch, start, length));
	            transactionID = false;
	         } else if (OrderID) {
	            System.out.println("OrderID: " 
	            + new String(ch, start, length));
	            OrderID = false;
	         } else if (priceID) {
	            System.out.println("priceID: " 
	            + new String(ch, start, length));
	            priceID = false;
	         } else if (employeeID) {
	            System.out.println("employeeID: " 
	            + new String(ch, start, length));
	            employeeID = false;
	         }
	         else if (transactionDate) {
		            System.out.println("transactionDate: " 
		            + new String(ch, start, length));
		            transactionDate = false;
		         }
	         else if (transactionDescription) {
		            System.out.println("transactionDescription: " 
		            + new String(ch, start, length));
		            transactionDescription = false;
		         }
	         
	         else if (transactionAmount) {
		            System.out.println("transactionAmount: " 
		            + new String(ch, start, length));
		            transactionAmount = false;
		         }
	         
	         else if (TruckID) {
		            System.out.println("TruckID: " 
		            + new String(ch, start, length));
		            TruckID = false;
		         }
	         
	         else if (truckNo) {
		            System.out.println("truckNo: " 
		            + new String(ch, start, length));
		            truckNo = false;
		         }
	         else if (make) {
		            System.out.println("make: " 
		            + new String(ch, start, length));
		            make = false;
		         }
	         else if (model) {
		            System.out.println("model: " 
		            + new String(ch, start, length));
		            model = false;
		         }
	         else if (year) {
		            System.out.println("year: " 
		            + new String(ch, start, length));
		            year = false;
		         }
	         else if (VIN) {
		            System.out.println("VIN: " 
		            + new String(ch, start, length));
		            VIN = false;
		         }
	         else if (runNumber) {
		            System.out.println("runNumber: " 
		            + new String(ch, start, length));
		            runNumber = false;
		         } 
                  else if (quantity) {
		            System.out.println("quantity: " 
		            + new String(ch, start, length));
		            quantity = false;
		         } 
                  else if (discount) {
		            System.out.println("discount: " 
		            + new String(ch, start, length));
		            discount = false;
		         } 
                  else if (unitPrice) {
		            System.out.println("unitPrice: " 
		            + new String(ch, start, length));
		            unitPrice = false;
		         } 
                  else if (driverPrice) {
		            System.out.println("driverPrice: " 
		            + new String(ch, start, length));
		            driverPrice = false;
		         } 
                  else if (rate) {
		            System.out.println("rate: " 
		            + new String(ch, start, length));
		            rate = false;
		         } 
                  else if (surcharge) {
		            System.out.println("surcharge: " 
		            + new String(ch, start, length));
		            surcharge = false;
		         } 
                  else if (special) {
		            System.out.println("special: " 
		            + new String(ch, start, length));
		            special = false;
		         } 
                               
                 }
}
   


