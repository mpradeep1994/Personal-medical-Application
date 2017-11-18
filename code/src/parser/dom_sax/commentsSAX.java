package dom_sax;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class commentsSAX {
    
    	   public static void main(String[] args){

		      try {	
		         File inputFile = new File("comments.xml");
		         SAXParserFactory factory = SAXParserFactory.newInstance();
		         SAXParser saxParser = factory.newSAXParser();
		         UserHandlercomments userhandler = new UserHandlercomments();
		         saxParser.parse(inputFile, userhandler);     
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
}
    
class UserHandlercomments extends DefaultHandler{
    
    boolean commentID = false;
    boolean customerID = false;
    boolean transactionID = false;
    boolean locationID = false;
    boolean TruckID = false;
    boolean CommentTime = false;
    boolean comments = false;
    
    
    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException{
        
        if (qName.equalsIgnoreCase("comment")) {
	    	  	         
	      } else if (qName.equalsIgnoreCase("commentID")) {
	    	  commentID = true;
	    	 
	     }
	      else if(qName.equalsIgnoreCase("customerID")){
	        	customerID = true; 
	         }
	         else if (qName.equalsIgnoreCase("transactionID")) {
	        	 transactionID = true;
	      } 
	     else if (qName.equalsIgnoreCase("TruckID")) {
	    	 TruckID = true;
	      }
	     else if (qName.equalsIgnoreCase("CommentTime")) {
	    	 CommentTime = true;
	      }
	     else if (qName.equalsIgnoreCase("comments")) {
	    	 comments = true;
	      }
	    
    }            
    
    
   @Override
   public void endElement(String uri, 
	         String localName, String qName) throws SAXException {
	         if (qName.equalsIgnoreCase("comment")) {
	            System.out.println("End Element :" + qName);
	            System.out.println("\n\n");
	         }
	      }
   
   @Override
	      public void characters(char ch[], 
	         int start, int length) throws SAXException {
   
                if (commentID) {
	            System.out.println("commentID: " 
	            + new String(ch, start, length));
	            commentID = false;
	         } else if (customerID) {
	            System.out.println("customerID: " 
	            + new String(ch, start, length));
	            customerID = false;
	         } else if (transactionID) {
	            System.out.println("transactionID: " 
	            + new String(ch, start, length));
	            transactionID = false;
	         } else if (locationID) {
	            System.out.println("locationID: " 
	            + new String(ch, start, length));
	            locationID = false;
	         }
	         else if (TruckID) {
		            System.out.println("TruckID: " 
		            + new String(ch, start, length));
		            TruckID = false;
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

