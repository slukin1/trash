package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidCiphertextException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidCiphertextExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidCiphertextExceptionUnmarshaller() {
        super(InvalidCiphertextException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidCiphertextException invalidCiphertextException = (InvalidCiphertextException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidCiphertextException.setErrorCode("InvalidCiphertextException");
        return invalidCiphertextException;
    }
}
