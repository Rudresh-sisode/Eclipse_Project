package co.edureka.main;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


class SAXHandler extends DefaultHandler{
	
	
	public void startDocument()throws SAXException{
		System.out.println("Document parsing started");
	}
	
	public void startElement(String uri,String localName,String qName,Attributes attributes)throws SAXException{
		
	}
	
	public void characters(char[] ch,int start,int length)throws SAXException
	{
		
	}
	
	public void endElement(String uri,String localName,String qName,Attributes attributes)throws SAXException
	{
		
	}
	
	@Override
	public void endDocument()throws SAXException{
		System.out.println("Document ending");
	}
}

public class SAXParserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
