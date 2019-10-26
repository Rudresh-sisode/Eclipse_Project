package co.edureka.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			File file=new File("MyStudent.xml");
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.parse(file);
			
			System.out.println("root element "+document.getDocumentElement().getNodeName());
			
			NodeList nodelist=document.getElementsByTagName("Student");
			
			System.out.println("node list lenght is "+nodelist.getLength());
			
			for(int i=0;i<nodelist.getLength();i++)
			{
				Node node=nodelist.item(i);
				System.out.println("Node name "+node.getNodeName());
				
				if(node.getNodeType()==Node.ELEMENT_NODE) {
					Element element=(Element)node;
					System.out.println("Roll "+element.getElementsByTagName("Roll").item(0).getTextContent());
					System.out.println("Name "+element.getElementsByTagName("Name").item(0).getTextContent());
					System.out.println("Email "+element.getElementsByTagName("Email").item(0).getTextContent());
					System.out.println("Age "+element.getElementsByTagName("Age").item(0).getTextContent());
					System.out.println("Address "+element.getElementsByTagName("Address").item(0).getTextContent());
					
					
				}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("exception occuted"+ex);
		}

	}

}
