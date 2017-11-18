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
public class trucks_dom {
    
    public static void main(String[] args) {
    
        try{     
        File xml;
        xml = new File("src/xml/trucks.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("truck");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                String TruckID = newElement.getElementsByTagName("TruckID").item(0).getTextContent();
                String TruckNo = newElement.getElementsByTagName("TruckNo").item(0).getTextContent();
                String Make = newElement.getElementsByTagName("Make").item(0).getTextContent();
                String Year = newElement.getElementsByTagName("Year").item(0).getTextContent();
                String Model = newElement.getElementsByTagName("Model").item(0).getTextContent();
                String Color = newElement.getElementsByTagName("Color").item(0).getTextContent();
                String LicensePlateNo = newElement.getElementsByTagName("LicensePlateNo").item(0).getTextContent();
                String VIN = newElement.getElementsByTagName("VIN").item(0).getTextContent();
                
                values.add(TruckID);
                values.add(TruckNo);
                values.add(Make);
                values.add(Year);
                values.add(Model);
                values.add(Color);
                values.add(LicensePlateNo);
                values.add(VIN);
                db.inserttruck(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
}