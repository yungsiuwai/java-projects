package org.yung.util;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class GoodUtils {
	public static String getXPath(Document root, String elementName) {
		try {
			XPathExpression expr = XPathFactory.newInstance().newXPath().compile("//" + elementName);
			Node node = (Node) expr.evaluate(root, XPathConstants.NODE);

			if (node != null) {
				return getXPath(node);
			}
		} catch (XPathExpressionException e) {
		}

		return null;
	}

	public static String getXPath(Node node) {
		if (node == null || node.getNodeType() != Node.ELEMENT_NODE) {
			return "";
		}

		return getXPath(node.getParentNode()) + "/" + node.getNodeName();
	}
}
