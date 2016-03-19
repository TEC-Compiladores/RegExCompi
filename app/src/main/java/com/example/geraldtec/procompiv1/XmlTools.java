package com.example.geraldtec.procompiv1;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by GeraldF on 12/03/2016.
 */
public class XmlTools implements Constants {
    public Document createEmptyDoc() {
        Document document = null;
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            document = docBuilder.newDocument();
        } catch (ParserConfigurationException e) {
        }
        return document;
    }

    /**
     *
     * @param pDocument
     * @return
     */
    public String parseToString(Document pDocument) {
        String xml;

        try {
            DOMSource domSource = new DOMSource(pDocument);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            xml = writer.toString();

        } catch (TransformerException tfe) {
            xml = null;
        }

        return xml;
    }

    /**
     *
     * @param pString
     * @return
     */
    public Document parseToDocument(String pString) {
        Document doc = null;
        boolean flag = true;

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(pString));
            doc = db.parse(is);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            flag = false;
        }

        if (!flag)
            return null;
        else
            return doc;
    }
    /**
     *
     */
    public NodeList getValueList(Document pDocument, String pXPath) {
        NodeList values;
        try {

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expression = xpath.compile(pXPath);
            values = (NodeList) expression.evaluate(pDocument, XPathConstants.NODESET);

        } catch (XPathExpressionException e) {
            values = null;
        }

        return values;
    }




}
