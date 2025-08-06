package com.huobi.woodpecker.kalle.exception;

import com.huobi.woodpecker.kalle.Headers;

public class DownloadError extends ReadException {
    private int mCode;
    private Headers mHeaders;

    public DownloadError(int i11, Headers headers, String str) {
        super(str);
        this.mCode = i11;
        this.mHeaders = headers;
    }

    public int getCode() {
        return this.mCode;
    }

    public Headers getHeaders() {
        return this.mHeaders;
    }

    public DownloadError(int i11, Headers headers, Throwable th2) {
        super(th2);
        this.mCode = i11;
        this.mHeaders = headers;
    }
}
