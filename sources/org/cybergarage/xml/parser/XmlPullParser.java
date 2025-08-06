package org.cybergarage.xml.parser;

import java.io.InputStream;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;
import org.cybergarage.xml.ParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParser extends Parser {
    public Node b(InputStream inputStream) throws ParserException {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            return d(newInstance.newPullParser(), inputStream);
        } catch (Exception e11) {
            throw new ParserException(e11);
        }
    }

    public Node d(org.xmlpull.v1.XmlPullParser xmlPullParser, InputStream inputStream) throws ParserException {
        Node node;
        Node node2 = null;
        try {
            xmlPullParser.setInput(inputStream, (String) null);
            int eventType = xmlPullParser.getEventType();
            Node node3 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    node = new Node();
                    String prefix = xmlPullParser.getPrefix();
                    String name = xmlPullParser.getName();
                    StringBuffer stringBuffer = new StringBuffer();
                    if (prefix != null && prefix.length() > 0) {
                        stringBuffer.append(prefix);
                        stringBuffer.append(":");
                    }
                    if (name != null && name.length() > 0) {
                        stringBuffer.append(name);
                    }
                    node.z(stringBuffer.toString());
                    int attributeCount = xmlPullParser.getAttributeCount();
                    for (int i11 = 0; i11 < attributeCount; i11++) {
                        node.y(xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
                    }
                    if (node2 != null) {
                        node2.c(node);
                    }
                    if (node3 == null) {
                        node2 = node;
                        node3 = node2;
                        eventType = xmlPullParser.next();
                    }
                } else if (eventType != 3) {
                    if (eventType == 4) {
                        String text = xmlPullParser.getText();
                        if (!(text == null || node2 == null)) {
                            node2.G(text);
                        }
                    }
                    eventType = xmlPullParser.next();
                } else {
                    node = node2.q();
                }
                node2 = node;
                eventType = xmlPullParser.next();
            }
            return node3;
        } catch (Exception e11) {
            throw new ParserException(e11);
        }
    }
}
