package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class trucksSAX {
    
        public static void main(String[] args){

		      try {	
		         File inputFile = new File("trucks.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlertrucks userhandler = new UserHandlertrucks();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
    
}


class UserHandlertrucks extends DefaultHandler{
    
    boolean TruckID = false;
    boolean TruckNo = false;
    boolean Make = false;
    boolean Year = false;
    boolean Model = false;
    boolean Color = false;
    boolean LicensePlateNo = false;
    boolean VIN = false;
  
    
    public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
    if (qName.equalsIgnoreCase("Trucks")) {
	    	         
	      } else if (qName.equalsIgnoreCase("truck1")) {
	    	  
	    	 
	     }
	      else if(qName.equalsIgnoreCase("TruckID")){
	        	TruckID = true; 
	         }
	         else if (qName.equalsIgnoreCase("TruckNo")) {
	        	TruckNo = true;
	      } 
	     else if (qName.equalsIgnoreCase("Truckdesc")) {
	    	
	      }
	     else if (qName.equalsIgnoreCase("Make")) {
	    	 Make = true;
	      }
	     else if (qName.equalsIgnoreCase("Year")) {
	    	 Year = true;
	      }
	     else if (qName.equalsIgnoreCase("Model")) {
	    	 Model = true;
	      }
	     else if (qName.equalsIgnoreCase("Color")) {
	    	 Color = true;
	      }
	     else if (qName.equalsIgnoreCase("LicensePlateNo")) {
	    	 LicensePlateNo = true;
	      }
	     else if (qName.equalsIgnoreCase("VIN")) {
	    	VIN = true;
	      }
	          
}
    
    
    @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("trucks")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
    
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
	         
                 if (TruckID) {
	            System.out.println("TruckID: " 
	            + new String(ch, start, length));
	            TruckID = false;
	         } else if (TruckNo) {
	            System.out.println("TruckNo: " 
	            + new String(ch, start, length));
	            TruckNo = false;
	         } else if (Make) {
	            System.out.println("Make: " 
	            + new String(ch, start, length));
	            Make = false;
	         } else if (Year) {
	            System.out.println("Year: " 
	            + new String(ch, start, length));
	            Year = false;
	         }
	         else if (Model) {
		            System.out.println("Model: " 
		            + new String(ch, start, length));
		            Model = false;
		         }
	         else if (Color) {
		            System.out.println("Color: " 
		            + new String(ch, start, length));
		            Color = false;
		         }
	         
	         else if (LicensePlateNo) {
		            System.out.println("LicensePlateNo: " 
		            + new String(ch, start, length));
		            LicensePlateNo = false;
		         }
	         
	         else if (VIN) {
		            System.out.println("VIN: " 
		            + new String(ch, start, length));
		            VIN = false;
		         }
	         
	       
              }
}
