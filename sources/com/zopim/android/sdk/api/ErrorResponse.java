package com.zopim.android.sdk.api;

interface ErrorResponse {
    public static final int NON_HTTP_ERROR = -1;

    public enum Kind {
        HTTP,
        NETWORK,
        UNEXPECTED
    }

    Kind getKind();

    String getReason();

    String getResponseBody();

    String getResponseBodyType();

    int getStatus();

    String getUrl();
}
