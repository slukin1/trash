package org.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SoftException extends RuntimeException {
    private static final boolean HAVE_JAVA_14;
    public Throwable inner;

    static {
        boolean z11;
        try {
            Class.forName("java.nio.Buffer");
            z11 = true;
        } catch (Throwable unused) {
            z11 = false;
        }
        HAVE_JAVA_14 = z11;
    }

    public SoftException(Throwable th2) {
        this.inner = th2;
    }

    public Throwable getCause() {
        return this.inner;
    }

    public Throwable getWrappedThrowable() {
        return this.inner;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th2 = this.inner;
        if (!HAVE_JAVA_14 && th2 != null) {
            printStream.print("Caused by: ");
            th2.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th2 = this.inner;
        if (!HAVE_JAVA_14 && th2 != null) {
            printWriter.print("Caused by: ");
            th2.printStackTrace(printWriter);
        }
    }
}
