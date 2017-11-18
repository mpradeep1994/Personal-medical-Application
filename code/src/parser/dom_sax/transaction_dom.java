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
public class transaction_dom {
    
    public static void main(String[] args) {
    
        try{
        File xml;
        xml = new File("src/xml/transactions.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("transaction");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String transactionID = newElement.getElementsByTagName("transactionID").item(0).getTextContent();
                String OrderID = newElement.getElementsByTagName("OrderID").item(0).getTextContent();
                String priceID = newElement.getElementsByTagName("priceID").item(0).getTextContent();
                String employeeID = newElement.getElementsByTagName("employeeID").item(0).getTextContent();
                String transactionDate = newElement.getElementsByTagName("transactionDate").item(0).getTextContent();
                String transactionDescription = newElement.getElementsByTagName("transactionDescription").item(0).getTextContent();
                String transactionAmount = newElement.getElementsByTagName("transactionAmount").item(0).getTextContent();
                String TruckID = newElement.getElementsByTagName("TruckID").item(0).getTextContent();
                String truckNo = newElement.getElementsByTagName("truckNo").item(0).getTextContent();
                String make = newElement.getElementsByTagName("make").item(0).getTextContent();
                String model = newElement.getElementsByTagName("model").item(0).getTextContent();
                String year = newElement.getElementsByTagName("year").item(0).getTextContent();
                String VIN = newElement.getElementsByTagName("VIN").item(0).getTextContent();
                String runNumber = newElement.getElementsByTagName("runNumber").item(0).getTextContent();
                String quantity = newElement.getElementsByTagName("quantity").item(0).getTextContent();
                String discount = newElement.getElementsByTagName("discount").item(0).getTextContent();
                String unitPrice = newElement.getElementsByTagName("unitPrice").item(0).getTextContent();
                String driverPrice = newElement.getElementsByTagName("driverPrice").item(0).getTextContent();
                String rate = newElement.getElementsByTagName("rate").item(0).getTextContent();
                String surcharge = newElement.getElementsByTagName("surcharge").item(0).getTextContent();
                String special = newElement.getElementsByTagName("special").item(0).getTextContent();
                
                values.add(transactionID);
                values.add(OrderID);
                values.add(priceID);
                values.add(employeeID);
                values.add(transactionDate);
                values.add(transactionDescription);
                values.add(transactionAmount);
                values.add(TruckID);
                values.add(truckNo);
                values.add(make);
                values.add(model);
                values.add(year);
                values.add(VIN);
                values.add(runNumber);
                values.add(quantity);
                values.add(discount);
                values.add(unitPrice);
                values.add(driverPrice);
                values.add(rate);
                values.add(surcharge);
                values.add(special);

                db.inserttransaction(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
}