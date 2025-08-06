package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class S3Credentials implements Serializable {
    private String accessKeyId;
    private long expiration;
    private String secretAccessKey;
    private String sessionToken;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setExpiration(long j11) {
        this.expiration = j11;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }
}
