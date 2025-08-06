package org.cybergarage.xml.parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;
import org.kxml2.io.KXmlParser;

public class kXML2Parser extends Parser {
    public Node b(InputStream inputStream) throws ParserException {
        Node node;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            KXmlParser kXmlParser = new KXmlParser();
            kXmlParser.setInput(inputStreamReader);
            Node node2 = null;
            Node node3 = null;
            for (int eventType = kXmlParser.getEventType(); eventType != 1; eventType = kXmlParser.next()) {
                if (eventType == 2) {
                    node = new Node();
                    node.z(kXmlParser.getName());
                    int attributeCount = kXmlParser.getAttributeCount();
                    for (int i11 = 0; i11 < attributeCount; i11++) {
                        node.y(kXmlParser.getAttributeName(i11), kXmlParser.getAttributeValue(i11));
                    }
                    if (node2 != null) {
                        node2.c(node);
                    }
                    if (node3 == null) {
                        node2 = node;
                        node3 = node2;
                    }
                } else if (eventType != 3) {
                    if (eventType == 4) {
                        String text = kXmlParser.getText();
                        if (node2 != null) {
                            node2.G(text);
                        }
                    }
                } else {
                    node = node2.q();
                }
                node2 = node;
            }
            return node3;
        } catch (Exception e11) {
            throw new ParserException(e11);
        }
    }
}
