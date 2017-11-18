package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class paymentsSAX {
    
       public static void main(String[] args){

		      try {	
		         File inputFile = new File("payments.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlerpayments userhandler = new UserHandlerpayments();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
 }



class UserHandlerpayments extends DefaultHandler{
    
    boolean PaymentID = false;
    boolean OrderID = false;
    boolean PaymentMethodID = false;
    boolean PaymentAmount = false;
    boolean PaymentDate = false;
    boolean ChequeNumber_CreditCard = false;
    boolean CreditCardNumber = false;
    boolean CardholdersName = false;
    boolean CreditCardExpDate = false;
    boolean CreditCardAuthorizationNumber = false;
    
       
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("payments")) {
	    	         
	      } else if (qName.equalsIgnoreCase("payment1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("PaymentID")){
	        	PaymentID = true; 
	         }
	         else if (qName.equalsIgnoreCase("OrderID")) {
	        	OrderID = true;
	      } 
	     else if (qName.equalsIgnoreCase("PaymentMethodID")) {
	    	 PaymentMethodID = true;
	      }
	     else if (qName.equalsIgnoreCase("PaymentAmount")) {
	    	 PaymentAmount = true;
	      }
	     else if (qName.equalsIgnoreCase("PaymentDate")) {
	    	 PaymentDate = true;
	      }
	     else if (qName.equalsIgnoreCase("ChequeNumber_CreditCard")) {
	    	 ChequeNumber_CreditCard = true;
	      }
	     else if (qName.equalsIgnoreCase("CreditCardNumber")) {
	    	 CreditCardNumber = true;
	      }
	     else if (qName.equalsIgnoreCase("CardholdersName")) {
	    	 CardholdersName = true;
	      }
	     else if (qName.equalsIgnoreCase("card_details")) {
	    	
	      }
	     else if (qName.equalsIgnoreCase("CreditCardExpDate")) {
	    	 CreditCardExpDate = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("CreditCardAuthorizationNumber")) {
	    	CreditCardAuthorizationNumber = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("payment2")) {
	    
	    	
	      }
     else if (qName.equalsIgnoreCase("payment3")) {
	    	 
	    	
	      }
     
       }
    
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("payments")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (PaymentID) {
	            System.out.println("PaymentID: " 
	            + new String(ch, start, length));
	            PaymentID = false;
	         } else if (OrderID) {
	            System.out.println("OrderID: " 
	            + new String(ch, start, length));
	            OrderID = false;
	         } else if (PaymentMethodID) {
	            System.out.println("PaymentMethodID: " 
	            + new String(ch, start, length));
	            PaymentMethodID = false;
	         } else if (PaymentAmount) {
	            System.out.println("PaymentAmount: " 
	            + new String(ch, start, length));
	            PaymentAmount = false;
	         }
	         else if (PaymentDate) {
		            System.out.println("PaymentDate: " 
		            + new String(ch, start, length));
		            PaymentDate = false;
		         }
	         else if (ChequeNumber_CreditCard) {
		            System.out.println("ChequeNumber_CreditCard: " 
		            + new String(ch, start, length));
		            ChequeNumber_CreditCard = false;
		         }
	         
	         else if (CreditCardNumber) {
		            System.out.println("CreditCardNumber: " 
		            + new String(ch, start, length));
		            CreditCardNumber = false;
		         }
	         
	         else if (CardholdersName) {
		            System.out.println("CardholdersName: " 
		            + new String(ch, start, length));
		            CardholdersName = false;
		         }
	         
	         else if (CreditCardExpDate) {
		            System.out.println("CreditCardExpDate: " 
		            + new String(ch, start, length));
		            CreditCardExpDate = false;
		         }
	         else if (CreditCardAuthorizationNumber) {
		            System.out.println("CreditCardAuthorizationNumber: " 
		            + new String(ch, start, length));
		            CreditCardAuthorizationNumber = false;
		         }
              }
}

