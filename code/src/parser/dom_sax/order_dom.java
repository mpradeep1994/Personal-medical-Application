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
public class order_dom {
    
    public static void main(String[] args) {
    
        try{  
        File xml;
        xml = new File("src/xml/orders.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("order");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String OrderID = newElement.getElementsByTagName("OrderID").item(0).getTextContent();
                String customerID = newElement.getElementsByTagName("customerID").item(0).getTextContent();
                String transaction1ID = newElement.getElementsByTagName("transaction1ID").item(0).getTextContent();
                String transaction2ID = newElement.getElementsByTagName("transaction2ID").item(0).getTextContent();
                String locationID = newElement.getElementsByTagName("locationID").item(0).getTextContent();
                String TruckID = newElement.getElementsByTagName("TruckID").item(0).getTextContent();
                String EmployeeID = newElement.getElementsByTagName("EmployeeID").item(0).getTextContent();
                String isSPecial = newElement.getElementsByTagName("isSPecial").item(0).getTextContent();
                String PurchaseOrderNumber =newElement.getElementsByTagName("PurchaseOrderNumber").item(0).getTextContent();
                String OrderTotalAmount = newElement.getElementsByTagName("OrderTotalAmount").item(0).getTextContent();
                String OrderDate = newElement.getElementsByTagName("OrderDate").item(0).getTextContent();
                String CommentTime =newElement.getElementsByTagName("CommentTime").item(0).getTextContent();
                String comments = newElement.getElementsByTagName("comments").item(0).getTextContent();

                
                values.add(OrderID);
                values.add(transaction1ID);
                values.add(customerID);
                values.add(transaction2ID);
                values.add(locationID);
                values.add(TruckID);
                values.add(EmployeeID);
                values.add(isSPecial);
                values.add(PurchaseOrderNumber);
                values.add(OrderTotalAmount);
                values.add(OrderDate);
                values.add(CommentTime);
                values.add(comments);

                db.insertorder(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
}