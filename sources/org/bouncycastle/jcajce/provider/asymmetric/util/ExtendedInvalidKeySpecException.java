package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.spec.InvalidKeySpecException;

public class ExtendedInvalidKeySpecException extends InvalidKeySpecException {
    private Throwable cause;

    public ExtendedInvalidKeySpecException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
