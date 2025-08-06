package org.cybergarage.xml.parser;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

public class JaxpParser extends Parser {
    public Node b(InputStream inputStream) throws ParserException {
        try {
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputStream)).getDocumentElement();
            if (documentElement != null) {
                return d((Node) null, documentElement);
            }
            return null;
        } catch (Exception e11) {
            throw new ParserException(e11);
        }
    }

    public Node d(Node node, org.w3c.dom.Node node2) {
        return e(node, node2, 0);
    }

    public Node e(Node node, org.w3c.dom.Node node2, int i11) {
        short nodeType = node2.getNodeType();
        String nodeName = node2.getNodeName();
        String nodeValue = node2.getNodeValue();
        NamedNodeMap attributes = node2.getAttributes();
        if (attributes != null) {
            attributes.getLength();
        }
        if (nodeType == 3) {
            node.d(nodeValue);
            return node;
        } else if (nodeType != 1) {
            return node;
        } else {
            Node node3 = new Node();
            node3.z(nodeName);
            node3.G(nodeValue);
            if (node != null) {
                node.c(node3);
            }
            NamedNodeMap attributes2 = node2.getAttributes();
            if (attributes2 != null) {
                int length = attributes2.getLength();
                for (int i12 = 0; i12 < length; i12++) {
                    org.w3c.dom.Node item = attributes2.item(i12);
                    node3.y(item.getNodeName(), item.getNodeValue());
                }
            }
            org.w3c.dom.Node firstChild = node2.getFirstChild();
            if (firstChild == null) {
                node3.G("");
                return node3;
            }
            do {
                e(node3, firstChild, i11 + 1);
                firstChild = firstChild.getNextSibling();
            } while (firstChild != null);
            return node3;
        }
    }
}
