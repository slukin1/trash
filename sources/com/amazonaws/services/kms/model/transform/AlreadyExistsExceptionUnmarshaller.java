package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.AlreadyExistsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class AlreadyExistsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public AlreadyExistsExceptionUnmarshaller() {
        super(AlreadyExistsException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        AlreadyExistsException alreadyExistsException = (AlreadyExistsException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        alreadyExistsException.setErrorCode("AlreadyExistsException");
        return alreadyExistsException;
    }
}
