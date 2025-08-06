package org.cybergarage.soap;

import org.cybergarage.xml.Node;
import org.cybergarage.xml.Parser;

public class SOAP {

    /* renamed from: a  reason: collision with root package name */
    public static Parser f59831a;

    public static final Node a() {
        Node node = new Node("s:Envelope");
        node.y("xmlns:s", "http://schemas.xmlsoap.org/soap/envelope/");
        node.y("s:encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
        node.c(new Node("s:Body"));
        return node;
    }

    public static final Parser b() {
        return f59831a;
    }

    public static final void c(Parser parser) {
        f59831a = parser;
    }
}
