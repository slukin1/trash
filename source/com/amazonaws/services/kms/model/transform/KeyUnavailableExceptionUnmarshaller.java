package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.KeyUnavailableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class KeyUnavailableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public KeyUnavailableExceptionUnmarshaller() {
        super(KeyUnavailableException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        KeyUnavailableException keyUnavailableException = (KeyUnavailableException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        keyUnavailableException.setErrorCode("KeyUnavailableException");
        return keyUnavailableException;
    }
}
