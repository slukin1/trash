package com.facebook.stetho.dumpapp;

class UnexpectedFrameException extends DumpappFramingException {
    public UnexpectedFrameException(byte b11, byte b12) {
        super("Expected '" + b11 + "', got: '" + b12 + "'");
    }
}
