package co.edureka.main;

import co.edureka.model.Student;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;

public class Client {
	public static void main(String... ars)
	{
		Student s1=new Student();
		s1.roll = 101;
		s1.name ="John"; 
		s1.email = "john@example.com";
		s1.age = 23;
		s1.address ="Jalgaon"; 
		
		
		//DOM API's
		
		
		try
		{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.newDocument();
		/*	
			Element root=document.createElement("Students");
			document.appendChild(root);
			
			Element studentElm=document.createElement("Student");
			document.appendChild(studentElm);
			
			root.appendChild(studentElm);
			
			Attr atr=document.createAttribute("RollNo");
			atr.setValue(String.valueOf(s1.roll));
			studentElm.setAttributeNode(atr);
			
			Element nameElm=document.createElement("soham");
			nameElm.appendChild(document.createTextNode(s1.name));
			studentElm.appendChild(nameElm);
			
			*/
			
			
			Element rootElm=document.createElement("Students");
			Element studentElm=document.createElement("Student");
			Element rollElm=document.createElement("Roll");
			Element nameElm=document.createElement("Name");
			Element emailElm=document.createElement("Email");
			Element ageElm=document.createElement("Age");
			Element addressElm=document.createElement("Address");
			
			//generating the data
			Text txtRoll=document.createTextNode(String.valueOf(s1.roll));
			Text txtName=document.createTextNode(s1.name);
			Text txtEmail=document.createTextNode(s1.email);
			Text txtAge=document.createTextNode(String.valueOf(s1.age));
			Text txtAddress=document.createTextNode(s1.address);
			
			//setting the data within the tag
			rollElm.appendChild(txtRoll);
			nameElm.appendChild(txtName);
			emailElm.appendChild(txtEmail);
			ageElm.appendChild(txtAge);
			addressElm.appendChild(txtAddress);
			
			studentElm.appendChild(rollElm);
			studentElm.appendChild(nameElm);
			studentElm.appendChild(emailElm);
			studentElm.appendChild(ageElm);
			studentElm.appendChild(addressElm);
			
			rootElm.appendChild(studentElm);
			
			document.appendChild(rootElm);
			
			File file=new File("MyStudent.xml");
			FileOutputStream fos=new FileOutputStream(file);
			StreamResult result=new StreamResult(fos);
			
			DOMSource source=new DOMSource(document);
			
			//we need to transform DOMSource into the StreamResult
			TransformerFactory transformerfactory=TransformerFactory.newInstance();
			Transformer transformer=transformerfactory.newTransformer();
			
			transformer.transform(source, result);
			
			System.out.println(file.getName()+" fie has been created!!!");
			
		}
		catch(Exception ex)
		{
			
			System.out.print("error"+ex);
			
		}
	
	}
	

}
