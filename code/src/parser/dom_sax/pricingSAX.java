package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class pricingSAX {
    
     public static void main(String[] args){

		      try {	
		         File inputFile = new File("pricing.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlerpricing userhandler = new UserHandlerpricing();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
}


class UserHandlerpricing extends DefaultHandler{
    
    boolean priceID = false;
    boolean customerID = false;
    boolean locationIDFrom = false;
    boolean locationIDTO = false;
    boolean locationCodeFrom = false;
    boolean locationCodeTo = false;
    boolean locationNameFrom = false;
    boolean locationNameTo = false;
    boolean price = false;
      
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("Price")) {
	    	         
	      } else if (qName.equalsIgnoreCase("price1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("priceID")){
	        	priceID = true; 
	         }
	         else if (qName.equalsIgnoreCase("customerID")) {
	        	customerID = true;
	      } 
	     else if (qName.equalsIgnoreCase("location")) {
	    	
	      }
	     else if (qName.equalsIgnoreCase("locationIDFrom")) {
	    	 locationIDFrom = true;
	      }
	     else if (qName.equalsIgnoreCase("locationIDTO")) {
	    	 locationIDTO = true;
	      }
	     else if (qName.equalsIgnoreCase("locationCodeFrom")) {
	    	 locationCodeFrom = true;
	      }
	     else if (qName.equalsIgnoreCase("locationCodeTo")) {
	    	 locationCodeTo = true;
	      }
	     else if (qName.equalsIgnoreCase("locationNameFrom")) {
	    	 locationNameFrom = true;
	      }
	     else if (qName.equalsIgnoreCase("locationNameTo")) {
	    	locationNameTo = true;
	      }
	     else if (qName.equalsIgnoreCase("price")) {
	    	 price = true;
	    	
	      }
         
}
    
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("pricing")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (priceID) {
	            System.out.println("priceID: " 
	            + new String(ch, start, length));
	            priceID = false;
	         } else if (customerID) {
	            System.out.println("customerID: " 
	            + new String(ch, start, length));
	            customerID = false;
	         } else if (locationIDFrom) {
	            System.out.println("locationIDFrom: " 
	            + new String(ch, start, length));
	            locationIDFrom = false;
	         } else if (locationIDTO) {
	            System.out.println("locationIDTO: " 
	            + new String(ch, start, length));
	            locationIDTO = false;
	         }
	         else if (locationCodeFrom) {
		            System.out.println("locationCodeFrom: " 
		            + new String(ch, start, length));
		            locationCodeFrom = false;
		         }
	         else if (locationCodeTo) {
		            System.out.println("locationCodeTo: " 
		            + new String(ch, start, length));
		            locationCodeTo = false;
		         }
	         
	         else if (locationNameFrom) {
		            System.out.println("locationNameFrom: " 
		            + new String(ch, start, length));
		            locationNameFrom = false;
		         }
	         
	         else if (locationNameTo) {
		            System.out.println("locationNameTo: " 
		            + new String(ch, start, length));
		            locationNameTo = false;
		         }
	         
	         else if (price) {
		            System.out.println("price: " 
		            + new String(ch, start, length));
		            price = false;
		         }
	        
              }
}
