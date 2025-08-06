package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;

public class ExtCertPathBuilderException extends CertPathBuilderException implements ExtException {
    private Throwable cause;

    public ExtCertPathBuilderException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public ExtCertPathBuilderException(String str, Throwable th2, CertPath certPath, int i11) {
        super(str, th2);
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
