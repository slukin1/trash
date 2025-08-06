package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidParameterExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidParameterExceptionUnmarshaller() {
        super(InvalidParameterException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidParameterException invalidParameterException = (InvalidParameterException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidParameterException.setErrorCode("InvalidParameterException");
        return invalidParameterException;
    }
}
