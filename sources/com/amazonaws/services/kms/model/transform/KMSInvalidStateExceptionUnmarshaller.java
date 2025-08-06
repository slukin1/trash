package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.KMSInvalidStateException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KMSInvalidStateExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInvalidStateExceptionUnmarshaller() {
        super(KMSInvalidStateException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        KMSInvalidStateException kMSInvalidStateException = (KMSInvalidStateException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        kMSInvalidStateException.setErrorCode("KMSInvalidStateException");
        return kMSInvalidStateException;
    }
}
