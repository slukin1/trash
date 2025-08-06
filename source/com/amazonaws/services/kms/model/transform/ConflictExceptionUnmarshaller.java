package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.ConflictException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ConflictExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ConflictExceptionUnmarshaller() {
        super(ConflictException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        ConflictException conflictException = (ConflictException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        conflictException.setErrorCode("ConflictException");
        return conflictException;
    }
}
