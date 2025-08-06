package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CustomKeyStoreHasCMKsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreHasCMKsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreHasCMKsExceptionUnmarshaller() {
        super(CustomKeyStoreHasCMKsException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CustomKeyStoreHasCMKsException customKeyStoreHasCMKsException = (CustomKeyStoreHasCMKsException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        customKeyStoreHasCMKsException.setErrorCode("CustomKeyStoreHasCMKsException");
        return customKeyStoreHasCMKsException;
    }
}
