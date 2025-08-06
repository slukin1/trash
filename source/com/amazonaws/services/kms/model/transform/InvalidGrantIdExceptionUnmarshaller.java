package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidGrantIdException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidGrantIdExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidGrantIdExceptionUnmarshaller() {
        super(InvalidGrantIdException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidGrantIdException invalidGrantIdException = (InvalidGrantIdException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidGrantIdException.setErrorCode("InvalidGrantIdException");
        return invalidGrantIdException;
    }
}
