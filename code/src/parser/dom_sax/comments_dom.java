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
public class comments_dom {
    
    public static void main(String[] args) {
    
        try{    
        File xml;
        xml = new File("src/xml/comments.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("comment");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String commentID = newElement.getElementsByTagName("commentID").item(0).getTextContent();
                String customerID = newElement.getElementsByTagName("customerID").item(0).getTextContent();
                String transactionID = newElement.getElementsByTagName("transactionID").item(0).getTextContent();
                String locationID = newElement.getElementsByTagName("locationID").item(0).getTextContent();
                String TruckID = newElement.getElementsByTagName("TruckID").item(0).getTextContent();
                String CommentTime = newElement.getElementsByTagName("CommentTime").item(0).getTextContent();
                String comment_data = newElement.getElementsByTagName("comment_data").item(0).getTextContent();
               
                values.add(commentID);
                values.add(customerID);
                values.add(transactionID);
                values.add(locationID);
                values.add(TruckID);
                values.add(CommentTime);
                values.add(comment_data);
                System.out.println(values.size());
                db.insertcomment(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        
    }
    
}
