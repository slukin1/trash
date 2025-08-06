package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i11) {
        this("Http request failed with status code: " + i11, i11);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i11) {
        this(str, i11, (Throwable) null);
    }

    public HttpException(String str, int i11, Throwable th2) {
        super(str, th2);
        this.statusCode = i11;
    }
}
