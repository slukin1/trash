package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidKeyUsageException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidKeyUsageExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidKeyUsageExceptionUnmarshaller() {
        super(InvalidKeyUsageException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidKeyUsageException invalidKeyUsageException = (InvalidKeyUsageException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidKeyUsageException.setErrorCode("InvalidKeyUsageException");
        return invalidKeyUsageException;
    }
}
