package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

abstract class AbstractSSEHandler extends AbstractHandler implements ServerSideEncryptionResult {
    public abstract ServerSideEncryptionResult f();

    public final void setSSEAlgorithm(String str) {
        ServerSideEncryptionResult f11 = f();
        if (f11 != null) {
            f11.setSSEAlgorithm(str);
        }
    }

    public final void setSSECustomerAlgorithm(String str) {
        ServerSideEncryptionResult f11 = f();
        if (f11 != null) {
            f11.setSSECustomerAlgorithm(str);
        }
    }

    public final void setSSECustomerKeyMd5(String str) {
        ServerSideEncryptionResult f11 = f();
        if (f11 != null) {
            f11.setSSECustomerKeyMd5(str);
        }
    }
}
