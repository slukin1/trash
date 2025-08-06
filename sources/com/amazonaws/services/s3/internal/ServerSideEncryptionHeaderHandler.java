package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

public class ServerSideEncryptionHeaderHandler<T extends ServerSideEncryptionResult> implements HeaderHandler<T> {
    /* renamed from: b */
    public void a(T t11, HttpResponse httpResponse) {
        t11.setSSEAlgorithm(httpResponse.c().get("x-amz-server-side-encryption"));
        t11.setSSECustomerAlgorithm(httpResponse.c().get("x-amz-server-side-encryption-customer-algorithm"));
        t11.setSSECustomerKeyMd5(httpResponse.c().get("x-amz-server-side-encryption-customer-key-MD5"));
    }
}
