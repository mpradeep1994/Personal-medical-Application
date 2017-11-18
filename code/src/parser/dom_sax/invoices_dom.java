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
public class invoices_dom {
    
    public static void main(String[] args) {
    
        try{
            
            
            
        File xml;
        xml = new File("src/xml/invoices.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("invoice");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String invoiceID = newElement.getElementsByTagName("invoiceID").item(0).getTextContent();
                String OrderID = newElement.getElementsByTagName("OrderID").item(0).getTextContent();
                String CustomerID = newElement.getElementsByTagName("CustomerID").item(0).getTextContent();
                String PaymentID = newElement.getElementsByTagName("PaymentID").item(0).getTextContent();
                String fromLocationID1 = newElement.getElementsByTagName("fromLocationID1").item(0).getTextContent();
                String TolocationID1 = newElement.getElementsByTagName("TolocationID1").item(0).getTextContent();
                String fromlocationID2 = newElement.getElementsByTagName("fromlocationID2").item(0).getTextContent();
                String TolocationID2 = newElement.getElementsByTagName("TolocationID2").item(0).getTextContent();
                String Description = newElement.getElementsByTagName("Description").item(0).getTextContent();
                String Price = newElement.getElementsByTagName("Price").item(0).getTextContent();
                String Quantity = newElement.getElementsByTagName("Quantity").item(0).getTextContent();
                String Contact_Name = newElement.getElementsByTagName("Contact_Name").item(0).getTextContent();
                String EmailAddress = newElement.getElementsByTagName("EmailAddress").item(0).getTextContent();
                
                values.add(invoiceID);
                values.add(OrderID);
                values.add(CustomerID);
                values.add(PaymentID);
                values.add(fromLocationID1);
                values.add(TolocationID1);
                values.add(fromlocationID2);
                values.add(TolocationID2);
                values.add(Description);
                values.add(Price);
                values.add(Quantity);
                values.add(Contact_Name);
                values.add(EmailAddress);
                
                db.insertinvoice(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
}