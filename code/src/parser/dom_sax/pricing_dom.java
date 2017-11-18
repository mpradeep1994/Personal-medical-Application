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
public class pricing_dom {
    
    public static void main(String[] args) {
    
        try{
            
            
            
        File xml;
        xml = new File("src/xml/pricing.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("pricex");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String priceID = newElement.getElementsByTagName("priceID").item(0).getTextContent();
                String customerID = newElement.getElementsByTagName("customerID").item(0).getTextContent();
                String locationIDFrom = newElement.getElementsByTagName("locationIDFrom").item(0).getTextContent();
                String locationIDTO = newElement.getElementsByTagName("locationIDTO").item(0).getTextContent();
                String locationCodeFrom = newElement.getElementsByTagName("locationCodeFrom").item(0).getTextContent();
                String locationCodeTo = newElement.getElementsByTagName("locationCodeTo").item(0).getTextContent();
                String locationNameFrom = newElement.getElementsByTagName("locationNameFrom").item(0).getTextContent();
                String locationNameTo = newElement.getElementsByTagName("locationNameTo").item(0).getTextContent();
                String price = newElement.getElementsByTagName("price").item(0).getTextContent();
                
                
                values.add(priceID);
                values.add(customerID);
                values.add(locationIDFrom);
                values.add(locationIDTO);
                values.add(locationCodeFrom);
                values.add(locationCodeTo);
                values.add(locationNameFrom);
                values.add(locationNameTo);
                values.add(price);
                
                System.out.println(values.size());
                db.insertprice(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        
    }
    
}
