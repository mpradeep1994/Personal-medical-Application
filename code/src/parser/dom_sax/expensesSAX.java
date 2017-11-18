package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class expensesSAX {
    
    public static void main(String[] args){

		      try {	
		         File inputFile = new File("expenses.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlerexpenses userhandler = new UserHandlerexpenses();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
}


class UserHandlerexpenses extends DefaultHandler{
    
    boolean ExpenseID = false;
    boolean EmployeeID = false;
    boolean ExpenseType = false;
    boolean PurposeofExpense = false;
    boolean AmountSpent = false;
    boolean Description = false;
    boolean DatePurchased = false;
    boolean DateSubmitted = false;
    boolean AdvanceAmount = false;
    boolean PaymentMethod = false;
       
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("expense")) {
	    	         
	      } else if (qName.equalsIgnoreCase("expense1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("ExpenseID")){
	        	ExpenseID = true; 
	         }
	         else if (qName.equalsIgnoreCase("EmployeeID")) {
	        	EmployeeID = true;
	      } 
	     else if (qName.equalsIgnoreCase("ExpenseType")) {
	    	 ExpenseType = true;
	      }
	     else if (qName.equalsIgnoreCase("PurposeofExpense")) {
	    	 PurposeofExpense = true;
	      }
	     else if (qName.equalsIgnoreCase("AmountSpent")) {
	    	 AmountSpent = true;
	      }
	     else if (qName.equalsIgnoreCase("Description")) {
	    	 Description = true;
	      }
	     else if (qName.equalsIgnoreCase("DatePurchased")) {
	    	 DatePurchased = true;
	      }
	     else if (qName.equalsIgnoreCase("DateSubmitted")) {
	    	 DateSubmitted = true;
	      }
	     else if (qName.equalsIgnoreCase("AdvanceAmount")) {
	    	 AdvanceAmount = true;
	      }
	     else if (qName.equalsIgnoreCase("PaymentMethod")) {
	    	 PaymentMethod = true;
	    	
	      }
              else if (qName.equalsIgnoreCase("expense1")) {
	    	 
	    	
	      }
	    	 
       }
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("expense")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (ExpenseID) {
	            System.out.println("ExpenseID: " 
	            + new String(ch, start, length));
	            ExpenseID = false;
	         } else if (EmployeeID) {
	            System.out.println("EmployeeID: " 
	            + new String(ch, start, length));
	            EmployeeID = false;
	         } else if (ExpenseType) {
	            System.out.println("ExpenseType: " 
	            + new String(ch, start, length));
	            ExpenseType = false;
	         } else if (PurposeofExpense) {
	            System.out.println("PurposeofExpense: " 
	            + new String(ch, start, length));
	            PurposeofExpense = false;
	         }
	         else if (PurposeofExpense) {
		            System.out.println("PurposeofExpense: " 
		            + new String(ch, start, length));
		            PurposeofExpense = false;
		         }
	         else if (Description) {
		            System.out.println("Description: " 
		            + new String(ch, start, length));
		            Description = false;
		         }
	         
	         else if (DatePurchased) {
		            System.out.println("DatePurchased: " 
		            + new String(ch, start, length));
		            DatePurchased = false;
		         }
	         
	         else if (DateSubmitted) {
		            System.out.println("DateSubmitted: " 
		            + new String(ch, start, length));
		            DateSubmitted = false;
		         }
	         
	         else if (AdvanceAmount) {
		            System.out.println("AdvanceAmount: " 
		            + new String(ch, start, length));
		            AdvanceAmount = false;
		         }
	         else if (PaymentMethod) {
		            System.out.println("PaymentMethod: " 
		            + new String(ch, start, length));
		            PaymentMethod = false;
		         }
	       
                 
                 }
}
