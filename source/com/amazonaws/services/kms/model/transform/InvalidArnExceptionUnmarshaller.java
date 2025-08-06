package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidArnException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidArnExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidArnExceptionUnmarshaller() {
        super(InvalidArnException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidArnException invalidArnException = (InvalidArnException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidArnException.setErrorCode("InvalidArnException");
        return invalidArnException;
    }
}
