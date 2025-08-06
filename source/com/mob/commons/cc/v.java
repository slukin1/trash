package com.mob.commons.cc;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class v extends RuntimeException {
    public v(String str, Throwable th2) {
        super(str, th2);
    }

    public void printStackTrace(PrintStream printStream) {
        printStream.println("" + getMessage());
    }

    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("" + getMessage());
    }
}
