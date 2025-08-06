package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.KMSInvalidSignatureException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KMSInvalidSignatureExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInvalidSignatureExceptionUnmarshaller() {
        super(KMSInvalidSignatureException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        KMSInvalidSignatureException kMSInvalidSignatureException = (KMSInvalidSignatureException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        kMSInvalidSignatureException.setErrorCode("KMSInvalidSignatureException");
        return kMSInvalidSignatureException;
    }
}
