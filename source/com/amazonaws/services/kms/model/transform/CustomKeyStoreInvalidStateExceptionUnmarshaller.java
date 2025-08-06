package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CustomKeyStoreInvalidStateException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreInvalidStateExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreInvalidStateExceptionUnmarshaller() {
        super(CustomKeyStoreInvalidStateException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CustomKeyStoreInvalidStateException customKeyStoreInvalidStateException = (CustomKeyStoreInvalidStateException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        customKeyStoreInvalidStateException.setErrorCode("CustomKeyStoreInvalidStateException");
        return customKeyStoreInvalidStateException;
    }
}
