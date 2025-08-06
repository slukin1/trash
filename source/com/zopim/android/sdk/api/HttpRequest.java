package com.zopim.android.sdk.api;

import java.util.concurrent.TimeUnit;

interface HttpRequest {
    public static final String CHARSET = "UTF-8";
    public static final int MAX_BUFFER_SIZE = 4096;
    public static final long REQUEST_TIMEOUT = TimeUnit.SECONDS.toMillis(10);

    public interface ProgressListener {
        void onProgressUpdate(int i11);
    }

    public enum Status {
        SUCCESS,
        REDIRECT,
        CLIENT_ERROR,
        SERVER_ERROR,
        UNKNOWN;

        public static Status getStatus(int i11) {
            if (i11 >= 200 && i11 < 300) {
                return SUCCESS;
            }
            if (i11 >= 300 && i11 < 400) {
                return REDIRECT;
            }
            if (i11 >= 400 && i11 < 500) {
                return CLIENT_ERROR;
            }
            if (i11 < 500 || i11 >= 600) {
                return UNKNOWN;
            }
            return SERVER_ERROR;
        }
    }
}
