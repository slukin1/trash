package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.KMSInvalidMacException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KMSInvalidMacExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KMSInvalidMacExceptionUnmarshaller() {
        super(KMSInvalidMacException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        KMSInvalidMacException kMSInvalidMacException = (KMSInvalidMacException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        kMSInvalidMacException.setErrorCode("KMSInvalidMacException");
        return kMSInvalidMacException;
    }
}
