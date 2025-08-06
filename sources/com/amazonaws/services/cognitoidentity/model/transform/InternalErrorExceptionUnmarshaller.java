package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.cognitoidentity.model.InternalErrorException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InternalErrorExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InternalErrorExceptionUnmarshaller() {
        super(InternalErrorException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InternalErrorException internalErrorException = (InternalErrorException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        internalErrorException.setErrorCode("InternalErrorException");
        return internalErrorException;
    }
}
