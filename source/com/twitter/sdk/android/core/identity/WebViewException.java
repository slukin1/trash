package com.twitter.sdk.android.core.identity;

class WebViewException extends Exception {
    private static final long serialVersionUID = -7397331487240298819L;
    private final int errorCode;
    private final String failingUrl;

    public WebViewException(int i11, String str, String str2) {
        super(str);
        this.errorCode = i11;
        this.failingUrl = str2;
    }

    public String getDescription() {
        return getMessage();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }
}
