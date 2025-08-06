package org.apache.commons.io;

import java.io.IOException;

@Deprecated
public class IOExceptionWithCause extends IOException {
    private static final long serialVersionUID = 1;

    public IOExceptionWithCause(String str, Throwable th2) {
        super(str, th2);
    }

    public IOExceptionWithCause(Throwable th2) {
        super(th2);
    }
}
