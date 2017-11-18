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
public class customer_dom {
    
    public static void main(String[] args) {
    
        try{
            
            
            
        File xml;
        xml = new File("src/xml/Customers.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        
        NodeList nodes =  d.getElementsByTagName("customer");
        
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                int CustomerID = Integer.parseInt(newElement.getElementsByTagName("CustomerID").item(0).getTextContent());
                String CustomerTitle = newElement.getElementsByTagName("CustomerTitle").item(0).getTextContent();
                String BusinessName = newElement.getElementsByTagName("BusinessName").item(0).getTextContent();
                String Company_Name = newElement.getElementsByTagName("Company_Name").item(0).getTextContent();
                String Contact_Name = newElement.getElementsByTagName("Contact_Name").item(0).getTextContent();
                String address = newElement.getElementsByTagName("BillingAddress").item(0).getTextContent();
                String City = newElement.getElementsByTagName("City").item(0).getTextContent();
                String StateOrProvince = newElement.getElementsByTagName("StateOrProvince").item(0).getTextContent();
                long PostalCode = Long.parseLong(newElement.getElementsByTagName("PostalCode").item(0).getTextContent());
                String Country_Region = newElement.getElementsByTagName("Country_Region").item(0).getTextContent();
                long PhoneNumber = Long.parseLong(newElement.getElementsByTagName("PhoneNumber").item(0).getTextContent());
                long CellNumber = Long.parseLong(newElement.getElementsByTagName("CellNumber").item(0).getTextContent());
                long FaxNumber = Long.parseLong(newElement.getElementsByTagName("FaxNumber").item(0).getTextContent());
                String EmailAddress = newElement.getElementsByTagName("EmailAddress").item(0).getTextContent();
                long contact_number = Long.parseLong(newElement.getElementsByTagName("contact_number").item(0).getTextContent());
                String Alternate_Contact_Name = newElement.getElementsByTagName("Alternate_Contact_Name").item(0).getTextContent();
                String DateEntered = newElement.getElementsByTagName("DateEntered").item(0).getTextContent();
                String from = newElement.getElementsByTagName("from").item(0).getTextContent();
                String to_one = newElement.getElementsByTagName("to_one").item(0).getTextContent();
                String to_two = newElement.getElementsByTagName("to_two").item(0).getTextContent();
                String to_three = newElement.getElementsByTagName("to_three").item(0).getTextContent();
                String status = newElement.getElementsByTagName("status").item(0).getTextContent();
                values.add(CustomerID);
                values.add(CustomerTitle);
                values.add(BusinessName);
                values.add(Company_Name);
                values.add(Contact_Name);
                values.add(address);
                values.add(City);
                values.add(StateOrProvince);
                values.add(PostalCode);
                values.add(Country_Region);
                values.add(PhoneNumber);
                values.add(CellNumber);
                values.add(FaxNumber);
                values.add(EmailAddress);
                values.add(contact_number);
                values.add(Alternate_Contact_Name);
                values.add(DateEntered);
                values.add(from);
                values.add(to_one);
                values.add(to_two);
                values.add(to_three);
                values.add(status);
               
                
                db.insertrows(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
