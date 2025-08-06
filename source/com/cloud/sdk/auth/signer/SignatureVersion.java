package com.cloud.sdk.auth.signer;

public enum SignatureVersion {
    V1("1");
    
    private String value;

    private SignatureVersion(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
