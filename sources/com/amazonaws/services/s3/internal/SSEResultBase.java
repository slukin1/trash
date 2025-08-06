package com.amazonaws.services.s3.internal;

public abstract class SSEResultBase implements ServerSideEncryptionResult {
    private String sseAlgorithm;
    private String sseCustomerAlgorithm;
    private String sseCustomerKeyMD5;

    public final String getSSEAlgorithm() {
        return this.sseAlgorithm;
    }

    public final String getSSECustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public final String getSSECustomerKeyMd5() {
        return this.sseCustomerKeyMD5;
    }

    @Deprecated
    public final String getServerSideEncryption() {
        return this.sseAlgorithm;
    }

    public final void setSSEAlgorithm(String str) {
        this.sseAlgorithm = str;
    }

    public final void setSSECustomerAlgorithm(String str) {
        this.sseCustomerAlgorithm = str;
    }

    public final void setSSECustomerKeyMd5(String str) {
        this.sseCustomerKeyMD5 = str;
    }
}
