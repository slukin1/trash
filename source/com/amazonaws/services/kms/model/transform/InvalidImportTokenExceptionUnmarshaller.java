package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidImportTokenException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidImportTokenExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidImportTokenExceptionUnmarshaller() {
        super(InvalidImportTokenException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidImportTokenException invalidImportTokenException = (InvalidImportTokenException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidImportTokenException.setErrorCode("InvalidImportTokenException");
        return invalidImportTokenException;
    }
}
