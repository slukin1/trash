package com.facebook.stetho.dumpapp;

class DumpappOutputBrokenException extends RuntimeException {
    public DumpappOutputBrokenException() {
    }

    public DumpappOutputBrokenException(String str) {
        super(str);
    }

    public DumpappOutputBrokenException(String str, Throwable th2) {
        super(str, th2);
    }

    public DumpappOutputBrokenException(Throwable th2) {
        super(th2);
    }
}
