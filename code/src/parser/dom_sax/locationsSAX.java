package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class locationsSAX {
    
      public static void main(String[] args){

		      try {	
		         File inputFile = new File("locations.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlerlocations userhandler = new UserHandlerlocations();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
}


class UserHandlerlocations extends DefaultHandler{
    
    boolean locationID = false;
    boolean locName = false;
    boolean locationCode = false;
    boolean isAuction = false;
    boolean address_street1 = false;
    boolean address_street2 = false;
    boolean city = false;
    boolean state = false;
    boolean postalCode = false;
    boolean country_region = false;
    boolean location_contact_name = false;
    boolean locPhone = false;
    boolean locFaxNumber = false;
    boolean locEmail = false;

       
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("locations")) {
	    	         
	      } else if (qName.equalsIgnoreCase("location1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("locationID")){
	        	locationID = true; 
	         }
	         else if (qName.equalsIgnoreCase("locName")) {
	        	locName = true;
	      } 
	     else if (qName.equalsIgnoreCase("locationCode")) {
	    	 locationCode = true;
	      }
	     else if (qName.equalsIgnoreCase("isAuction")) {
	    	 isAuction = true;
	      }
	     else if (qName.equalsIgnoreCase("address_street1")) {
	    	 address_street1 = true;
	      }
	     else if (qName.equalsIgnoreCase("address_street2")) {
	    	 address_street2 = true;
	      }
	     else if (qName.equalsIgnoreCase("city")) {
	    	 city = true;
	      }
	     else if (qName.equalsIgnoreCase("state")) {
	    	 state = true;
	      }
	     else if (qName.equalsIgnoreCase("postalCode")) {
	    	 postalCode = true;
	      }
	     else if (qName.equalsIgnoreCase("country_region")) {
	    	 country_region = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("address")) {
	    	
	    	
	      }
     else if (qName.equalsIgnoreCase("locationcontact")) {
	    	
	    	
	      }
     else if (qName.equalsIgnoreCase("location_contact_name")) {
	    	 location_contact_name = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("locPhone")) {
	    	 locPhone = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("locFaxNumber")) {
	    	 locFaxNumber = true;
	    	
	      }
     else if (qName.equalsIgnoreCase("locEmail")) {
	    	 locEmail = true;
	    	
	      }
     	    	 
       }
    
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("locations")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (locationID) {
	            System.out.println("locationID: " 
	            + new String(ch, start, length));
	            locationID = false;
	         } else if (locName) {
	            System.out.println("locName: " 
	            + new String(ch, start, length));
	            locName = false;
	         } else if (locationCode) {
	            System.out.println("locationCode: " 
	            + new String(ch, start, length));
	            locationCode = false;
	         } else if (isAuction) {
	            System.out.println("isAuction: " 
	            + new String(ch, start, length));
	            isAuction = false;
	         }
	         else if (address_street1) {
		            System.out.println("address_street1: " 
		            + new String(ch, start, length));
		            address_street1 = false;
		         }
	         else if (address_street2) {
		            System.out.println("address_street2: " 
		            + new String(ch, start, length));
		            address_street2 = false;
		         }
	         
	         else if (city) {
		            System.out.println("city: " 
		            + new String(ch, start, length));
		            city = false;
		         }
	         
	         else if (state) {
		            System.out.println("state: " 
		            + new String(ch, start, length));
		            state = false;
		         }
	         
	         else if (postalCode) {
		            System.out.println("postalCode: " 
		            + new String(ch, start, length));
		            postalCode = false;
		         }
	         else if (country_region) {
		            System.out.println("country_region: " 
		            + new String(ch, start, length));
		            country_region = false;
		         }
	          else if (location_contact_name) {
		            System.out.println("location_contact_name: " 
		            + new String(ch, start, length));
		            location_contact_name = false;
		         }
                    else if (locPhone) {
		            System.out.println("locPhone: " 
		            + new String(ch, start, length));
		            locPhone = false;
		         }
                 else if (locFaxNumber) {
		            System.out.println("locFaxNumber: " 
		            + new String(ch, start, length));
		            locFaxNumber = false;
		         }
                 else if (locEmail) {
		            System.out.println("locEmail: " 
		            + new String(ch, start, length));
		            locEmail = false;
		         }
                 
                 }
}
