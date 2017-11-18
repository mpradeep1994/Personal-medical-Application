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
public class employees_dom {
    
    public static void main(String[] args) {
    
        try{
        File xml;
        xml = new File("src/xml/employees.xml");
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        Document d =build.parse(xml);
        ArrayList values;
        d.getDocumentElement().normalize();
        System.out.println("Root Element:"+ d.getDocumentElement().getNodeName());
        NodeList nodes =  d.getElementsByTagName("employee");
        DAOModel db = new DAOModel();
        for(int i =0; i< nodes.getLength();i++){
        Node n = nodes.item(i);
         System.out.println("current  Element:"+ n.getNodeName());
            if(n.getNodeType() == Node.ELEMENT_NODE){
                Element newElement = (Element) n;
                 values = new ArrayList();
                
                String EmployeeID = newElement.getElementsByTagName("EmployeeID").item(0).getTextContent();
                String FirstName = newElement.getElementsByTagName("FirstName").item(0).getTextContent();
                String LastName = newElement.getElementsByTagName("LastName").item(0).getTextContent();
                String Email = newElement.getElementsByTagName("Email").item(0).getTextContent();
                String Extension = newElement.getElementsByTagName("Extension").item(0).getTextContent();
                String HomePhone = newElement.getElementsByTagName("HomePhone").item(0).getTextContent();
                String CellPhone = newElement.getElementsByTagName("CellPhone").item(0).getTextContent();
                String Job_title = newElement.getElementsByTagName("Job_title").item(0).getTextContent();
                String SocialSecurityNumber = newElement.getElementsByTagName("SocialSecurityNumber").item(0).getTextContent();
                String DriverLicenseNumber = newElement.getElementsByTagName("DriverLicenseNumber").item(0).getTextContent();
                String Address = newElement.getElementsByTagName("Address").item(0).getTextContent();
                String City = newElement.getElementsByTagName("City").item(0).getTextContent();
                String State = newElement.getElementsByTagName("State").item(0).getTextContent();
                String PostalCode = newElement.getElementsByTagName("PostalCode").item(0).getTextContent();
                String Birthdate = newElement.getElementsByTagName("Birthdate").item(0).getTextContent();
                String DateHired = newElement.getElementsByTagName("DateHired").item(0).getTextContent();
                String Salary = newElement.getElementsByTagName("Salary").item(0).getTextContent();
                String Notes = newElement.getElementsByTagName("Notes").item(0).getTextContent();

                
                values.add(EmployeeID);
                values.add(FirstName);
                values.add(LastName);
                values.add(Email);
                values.add(Extension);
                values.add(HomePhone);
                values.add(CellPhone);
                values.add(Job_title);
                values.add(SocialSecurityNumber);
                values.add(DriverLicenseNumber);
                values.add(Address);
                values.add(City);
                values.add(State);
                values.add(PostalCode);
                values.add(Birthdate);
                values.add(DateHired);
                values.add(Salary);
                values.add(Notes);
                db.insertemployees(values);
            } 
        }
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
    }
}