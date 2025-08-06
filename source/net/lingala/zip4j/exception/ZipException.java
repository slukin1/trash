package net.lingala.zip4j.exception;

public class ZipException extends Exception {
    private static final long serialVersionUID = 1;
    private int code = -1;

    public ZipException() {
    }

    public int getCode() {
        return this.code;
    }

    public ZipException(String str) {
        super(str);
    }

    public ZipException(String str, Throwable th2) {
        super(str, th2);
    }

    public ZipException(String str, int i11) {
        super(str);
        this.code = i11;
    }

    public ZipException(String str, Throwable th2, int i11) {
        super(str, th2);
        this.code = i11;
    }

    public ZipException(Throwable th2) {
        super(th2);
    }

    public ZipException(Throwable th2, int i11) {
        super(th2);
        this.code = i11;
    }
}
