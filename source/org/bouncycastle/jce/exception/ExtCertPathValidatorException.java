package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

public class ExtCertPathValidatorException extends CertPathValidatorException implements ExtException {
    private Throwable cause;

    public ExtCertPathValidatorException(String str) {
        super(str);
    }

    public ExtCertPathValidatorException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public ExtCertPathValidatorException(String str, Throwable th2, CertPath certPath, int i11) {
        super(str, th2, certPath, i11);
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
