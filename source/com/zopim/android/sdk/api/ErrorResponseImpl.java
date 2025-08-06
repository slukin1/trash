package com.zopim.android.sdk.api;

import com.zopim.android.sdk.api.ErrorResponse;

class ErrorResponseImpl implements ErrorResponse {
    private ErrorResponse.Kind mKind;
    private String mReason;
    private String mResponseBody;
    private String mResponseBodyType;
    private int mStatusCode;
    private String mUrl;

    public static class Builder {
        /* access modifiers changed from: private */
        public ErrorResponse.Kind kind;
        /* access modifiers changed from: private */
        public String reason;
        /* access modifiers changed from: private */
        public String responseBody;
        /* access modifiers changed from: private */
        public String responseBodyType;
        /* access modifiers changed from: private */
        public int statusCode;
        /* access modifiers changed from: private */
        public String url;

        public ErrorResponseImpl build() {
            return new ErrorResponseImpl(this);
        }

        public Builder kind(ErrorResponse.Kind kind2) {
            this.kind = kind2;
            return this;
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public Builder responseBody(String str) {
            this.responseBody = str;
            return this;
        }

        public Builder responseBodyType(String str) {
            this.responseBodyType = str;
            return this;
        }

        public Builder status(int i11) {
            this.statusCode = i11;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    public ErrorResponse.Kind getKind() {
        return null;
    }

    public String getReason() {
        return null;
    }

    public String getResponseBody() {
        return null;
    }

    public String getResponseBodyType() {
        return null;
    }

    public int getStatus() {
        return -1;
    }

    public String getUrl() {
        return null;
    }

    public String toString() {
        return "kind:" + this.mKind + " reason:" + this.mReason + " status:" + this.mStatusCode + " response:" + this.mResponseBody + " url:" + this.mUrl;
    }

    private ErrorResponseImpl() {
    }

    private ErrorResponseImpl(Builder builder) {
        this.mKind = builder.kind;
        this.mReason = builder.reason;
        this.mStatusCode = builder.statusCode;
        this.mUrl = builder.url;
        this.mResponseBody = builder.responseBody;
        this.mResponseBodyType = builder.responseBodyType;
    }
}
