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
public class payments_dom {
    
    public static void main(String[] args) {
    
        try{
        File xml;
        xml = new File("src/xml/payments.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("payment");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String PaymentID = newElement.getElementsByTagName("PaymentID").item(0).getTextContent();
                String OrderID = newElement.getElementsByTagName("OrderID").item(0).getTextContent();
                String PaymentMethodID = newElement.getElementsByTagName("PaymentMethodID").item(0).getTextContent();
                String PaymentAmount = newElement.getElementsByTagName("PaymentAmount").item(0).getTextContent();
                String PaymentDate = newElement.getElementsByTagName("PaymentDate").item(0).getTextContent();
                String ChequeNumber_CreditCard = newElement.getElementsByTagName("ChequeNumber_CreditCard").item(0).getTextContent();
                String CreditCardNumber = newElement.getElementsByTagName("CreditCardNumber").item(0).getTextContent();
                String CardholdersName = newElement.getElementsByTagName("CardholdersName").item(0).getTextContent();
                String CreditCardExpDate = newElement.getElementsByTagName("CreditCardExpDate").item(0).getTextContent();
                String CreditCardAuthorizationNumber = newElement.getElementsByTagName("CreditCardAuthorizationNumber").item(0).getTextContent();

                
                values.add(PaymentID);
                values.add(OrderID);
                values.add(PaymentMethodID);
                values.add(PaymentAmount);
                values.add(PaymentDate);
                values.add(ChequeNumber_CreditCard);
                values.add(CreditCardNumber);
                values.add(CardholdersName);
                values.add(CreditCardExpDate);
                values.add(CreditCardAuthorizationNumber);

                db.insertpayment(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        
    }
}