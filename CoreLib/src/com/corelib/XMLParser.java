package com.corelib;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * XMLParser.java
 *
 * XML manipulation.
 *
 * @author	Eric Potvin
 * @version 1.0
 */
public class XMLParser extends com.corelib.CoreLib {

	/**
	 * The class tag name
	 */
	final static private String TAG = "XMLParser";

	/**
	 * Constructor
	 *
	 */
	public XMLParser() {
	}

	/**
	 * Get an XML file
	 *
	 * @param file The full path and filename of the XML file
	 * @return The content of the XML file (can be empty if the URL is not provided)
	 * @throws java.io.IOException
	 */
	public String getXml(String file) throws IOException {
		String data = "";
		if(file.equals("")) {
			return data;
		}
		try {
			com.corelib.FileCache f = new com.corelib.FileCache(file);
			data = f.read();
		}
		catch (IOException e) {
			throw e;
		}
		return data;
	}

	/**
	 * Get the DOM of the XML file
	 *
	 * @param xml The content of the XML file
	 * @return The document
	 * @throws javax.xml.parsers.ParserConfigurationException
	 * @throws org.xml.sax.SAXException
	 * @throws java.io.IOException
	 */
	public Document getDomElement(String xml) throws ParserConfigurationException, SAXException, IOException {
		Document doc = null;
		if(xml.equals("")) {
			return doc;
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			doc = db.parse(is);
		}
		catch (ParserConfigurationException e) {
			throw e;
		}
		catch (SAXException e) {
			throw e;
		}
		catch (IOException e) {
			throw e;
		}
		return doc;
	}

	/**
	 * Get the value of a node
	 *
	 * @param item The element
	 * @return The element value
	 */
	public String getValue(Element item, String str) {
		if(item == null || str.equals("")) {
			return "";
		}
		NodeList n = item.getElementsByTagName(str);
		if(n == null || n.getLength() == 0) {
			return "";
		}
		Node child, elem = n.item(0);
		if( elem == null) {
			return "";
		}
		if (!elem.hasChildNodes()) {
			return "";
		}
		for(child = elem.getFirstChild(); child != null; child = child.getNextSibling()) {
			if(child.getNodeType() == Node.TEXT_NODE){
				return child.getNodeValue().trim();
			}
		}
		return "";
	}
}
