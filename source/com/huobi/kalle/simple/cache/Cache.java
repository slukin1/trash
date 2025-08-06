package com.huobi.kalle.simple.cache;

import com.huobi.kalle.Headers;
import java.io.Serializable;

public class Cache implements Serializable {
    private byte[] mBody;
    private int mCode;
    private long mExpires;
    private Headers mHeaders;
    private String mKey;

    public byte[] getBody() {
        return this.mBody;
    }

    public int getCode() {
        return this.mCode;
    }

    public long getExpires() {
        return this.mExpires;
    }

    public Headers getHeaders() {
        return this.mHeaders;
    }

    public String getKey() {
        return this.mKey;
    }

    public void setBody(byte[] bArr) {
        this.mBody = bArr;
    }

    public void setCode(int i11) {
        this.mCode = i11;
    }

    public void setExpires(long j11) {
        this.mExpires = j11;
    }

    public void setHeaders(Headers headers) {
        this.mHeaders = headers;
    }

    public void setKey(String str) {
        this.mKey = str;
    }
}
