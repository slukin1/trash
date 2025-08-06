package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.UnsupportedOperationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class UnsupportedOperationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedOperationExceptionUnmarshaller() {
        super(UnsupportedOperationException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        UnsupportedOperationException unsupportedOperationException = (UnsupportedOperationException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        unsupportedOperationException.setErrorCode("UnsupportedOperationException");
        return unsupportedOperationException;
    }
}
