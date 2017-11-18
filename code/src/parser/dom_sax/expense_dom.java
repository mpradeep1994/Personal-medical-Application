
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
public class expense_dom {
    
    public static void main(String[] args) {
    
        try{
            
            
            
        File xml;
        xml = new File("src/xml/expenses.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("expense");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String ExpenseID = newElement.getElementsByTagName("ExpenseID").item(0).getTextContent();
                String EmployeeID = newElement.getElementsByTagName("EmployeeID").item(0).getTextContent();
                String ExpenseType = newElement.getElementsByTagName("ExpenseType").item(0).getTextContent();
                String PurposeofExpense = newElement.getElementsByTagName("PurposeofExpense").item(0).getTextContent();
                String AmountSpent = newElement.getElementsByTagName("AmountSpent").item(0).getTextContent();
                String Description = newElement.getElementsByTagName("Description").item(0).getTextContent();
                String DatePurchased = newElement.getElementsByTagName("DatePurchased").item(0).getTextContent();
                String DateSubmitted = newElement.getElementsByTagName("DateSubmitted").item(0).getTextContent();
                String AdvanceAmount = newElement.getElementsByTagName("AdvanceAmount").item(0).getTextContent();
                String PaymentMethod = newElement.getElementsByTagName("PaymentMethod").item(0).getTextContent();
                
                values.add(ExpenseID);
                values.add(EmployeeID);
                values.add(ExpenseType);
                values.add(PurposeofExpense);
                values.add(AmountSpent);
                values.add(Description);
                values.add(DatePurchased);
                values.add(DateSubmitted);
                values.add(AdvanceAmount);
                values.add(PaymentMethod);
                db.insertexpense(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
}