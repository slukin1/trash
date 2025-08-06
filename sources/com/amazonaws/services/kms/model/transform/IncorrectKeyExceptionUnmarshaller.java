package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.IncorrectKeyException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class IncorrectKeyExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public IncorrectKeyExceptionUnmarshaller() {
        super(IncorrectKeyException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        IncorrectKeyException incorrectKeyException = (IncorrectKeyException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        incorrectKeyException.setErrorCode("IncorrectKeyException");
        return incorrectKeyException;
    }
}
