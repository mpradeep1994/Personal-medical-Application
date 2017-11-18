/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom_sax;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import org.w3c.dom.*;
import java.sql.*;
import java.util.ArrayList;
import modelDAO.DAOModel;

/**
 *
 * @author Pradeep
 */
public class location_dom {
    
    public static void main(String[] args) {
    
        try{
            
            
            
        File xml;
        xml = new File("src/xml/locations.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("location");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String locationID = newElement.getElementsByTagName("locationID").item(0).getTextContent();
                String locName = newElement.getElementsByTagName("locName").item(0).getTextContent();
                String locationCode = newElement.getElementsByTagName("locationCode").item(0).getTextContent();
                String isAuction = newElement.getElementsByTagName("isAuction").item(0).getTextContent();
                String address_street1 = newElement.getElementsByTagName("address_street1").item(0).getTextContent();
                String address_street2 = newElement.getElementsByTagName("address_street2").item(0).getTextContent();
                String City = newElement.getElementsByTagName("city").item(0).getTextContent();
                String state = newElement.getElementsByTagName("state").item(0).getTextContent();
                String postalCode =newElement.getElementsByTagName("postalCode").item(0).getTextContent();
                String country_region = newElement.getElementsByTagName("country_region").item(0).getTextContent();
                String location_contact_name = newElement.getElementsByTagName("location_contact_name").item(0).getTextContent();
                String locPhone =newElement.getElementsByTagName("locPhone").item(0).getTextContent();
                String locFaxNumber = newElement.getElementsByTagName("locFaxNumber").item(0).getTextContent();
                String locEmail = newElement.getElementsByTagName("locEmail").item(0).getTextContent();
                
                values.add(locationID);
                values.add(locationCode);
                values.add(locName);
                values.add(isAuction);
                values.add(address_street1);
                values.add(address_street2);
                values.add(City);
                values.add(state);
                values.add(postalCode);
                values.add(country_region);
                values.add(location_contact_name);
                values.add(locPhone);
                values.add(locFaxNumber);
                values.add(locEmail);
                db.insertlocation(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
