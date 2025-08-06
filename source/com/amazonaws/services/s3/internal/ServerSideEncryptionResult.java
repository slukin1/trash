package com.amazonaws.services.s3.internal;

public interface ServerSideEncryptionResult {
    void setSSEAlgorithm(String str);

    void setSSECustomerAlgorithm(String str);

    void setSSECustomerKeyMd5(String str);
}
