package com.sun.istack;

import org.xml.sax.SAXException;

public class SAXException2 extends SAXException {
    public SAXException2(String str) {
        super(str);
    }

    public Throwable getCause() {
        return getException();
    }

    public SAXException2(Exception exc) {
        super(exc);
    }

    public SAXException2(String str, Exception exc) {
        super(str, exc);
    }
}
