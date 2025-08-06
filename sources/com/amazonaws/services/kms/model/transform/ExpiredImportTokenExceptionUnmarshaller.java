package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.ExpiredImportTokenException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ExpiredImportTokenExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ExpiredImportTokenExceptionUnmarshaller() {
        super(ExpiredImportTokenException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        ExpiredImportTokenException expiredImportTokenException = (ExpiredImportTokenException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        expiredImportTokenException.setErrorCode("ExpiredImportTokenException");
        return expiredImportTokenException;
    }
}
