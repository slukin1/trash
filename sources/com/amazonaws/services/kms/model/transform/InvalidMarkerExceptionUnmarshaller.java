package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidMarkerException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidMarkerExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidMarkerExceptionUnmarshaller() {
        super(InvalidMarkerException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidMarkerException invalidMarkerException = (InvalidMarkerException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidMarkerException.setErrorCode("InvalidMarkerException");
        return invalidMarkerException;
    }
}
