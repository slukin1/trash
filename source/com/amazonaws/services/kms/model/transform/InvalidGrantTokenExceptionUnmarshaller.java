package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidGrantTokenException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidGrantTokenExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidGrantTokenExceptionUnmarshaller() {
        super(InvalidGrantTokenException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidGrantTokenException invalidGrantTokenException = (InvalidGrantTokenException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidGrantTokenException.setErrorCode("InvalidGrantTokenException");
        return invalidGrantTokenException;
    }
}
