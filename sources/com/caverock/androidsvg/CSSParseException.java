package com.caverock.androidsvg;

class CSSParseException extends Exception {
    public CSSParseException(String str) {
        super(str);
    }

    public CSSParseException(String str, Exception exc) {
        super(str, exc);
    }
}
