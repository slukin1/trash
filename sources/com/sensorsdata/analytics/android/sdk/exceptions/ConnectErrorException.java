package com.sensorsdata.analytics.android.sdk.exceptions;

import com.jumio.core.cdn.CDNDownload;

public class ConnectErrorException extends Exception {
    private int mRetryAfter;

    public ConnectErrorException(String str) {
        super(str);
        this.mRetryAfter = CDNDownload.DEFAULT_TIMEOUT;
    }

    public int getRetryAfter() {
        return this.mRetryAfter;
    }

    public ConnectErrorException(String str, String str2) {
        super(str);
        try {
            this.mRetryAfter = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            this.mRetryAfter = 0;
        }
    }

    public ConnectErrorException(Throwable th2) {
        super(th2);
    }
}
