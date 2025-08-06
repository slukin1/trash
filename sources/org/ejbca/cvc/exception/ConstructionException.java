package org.ejbca.cvc.exception;

public class ConstructionException extends CvcException {
    private static final long serialVersionUID = 1;

    public ConstructionException() {
    }

    public ConstructionException(String str) {
        super(str);
    }

    public ConstructionException(Throwable th2) {
        super(th2);
    }

    public ConstructionException(String str, Throwable th2) {
        super(str, th2);
    }
}
