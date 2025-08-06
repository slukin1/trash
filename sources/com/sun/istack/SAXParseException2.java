package com.sun.istack;

import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

public class SAXParseException2 extends SAXParseException {
    public SAXParseException2(String str, Locator locator) {
        super(str, locator);
    }

    public Throwable getCause() {
        return getException();
    }

    public SAXParseException2(String str, Locator locator, Exception exc) {
        super(str, locator, exc);
    }

    public SAXParseException2(String str, String str2, String str3, int i11, int i12) {
        super(str, str2, str3, i11, i12);
    }

    public SAXParseException2(String str, String str2, String str3, int i11, int i12, Exception exc) {
        super(str, str2, str3, i11, i12, exc);
    }
}
