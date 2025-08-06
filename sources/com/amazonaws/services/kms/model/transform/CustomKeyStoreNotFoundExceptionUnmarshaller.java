package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CustomKeyStoreNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreNotFoundExceptionUnmarshaller() {
        super(CustomKeyStoreNotFoundException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CustomKeyStoreNotFoundException customKeyStoreNotFoundException = (CustomKeyStoreNotFoundException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        customKeyStoreNotFoundException.setErrorCode("CustomKeyStoreNotFoundException");
        return customKeyStoreNotFoundException;
    }
}
