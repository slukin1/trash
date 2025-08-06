package com.tencent.android.tpush.service.channel.exception;

public class NullReturnException extends Exception {
    private static final long serialVersionUID = -2623309261327598087L;
    private int statusCode = -1;

    public NullReturnException(String str) {
        super(str);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public NullReturnException(Exception exc) {
        super(exc);
    }

    public NullReturnException(String str, int i11) {
        super(str);
        this.statusCode = i11;
    }

    public NullReturnException(String str, Exception exc) {
        super(str, exc);
    }

    public NullReturnException(String str, Exception exc, int i11) {
        super(str, exc);
        this.statusCode = i11;
    }
}
