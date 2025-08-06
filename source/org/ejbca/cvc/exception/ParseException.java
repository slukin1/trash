package org.ejbca.cvc.exception;

public class ParseException extends CvcException {
    private static final long serialVersionUID = 1;

    public ParseException() {
    }

    public ParseException(String str) {
        super(str);
    }

    public ParseException(Throwable th2) {
        super(th2);
    }

    public ParseException(String str, Throwable th2) {
        super(str, th2);
    }
}
