package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CustomKeyStoreNameInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CustomKeyStoreNameInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CustomKeyStoreNameInUseExceptionUnmarshaller() {
        super(CustomKeyStoreNameInUseException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CustomKeyStoreNameInUseException customKeyStoreNameInUseException = (CustomKeyStoreNameInUseException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        customKeyStoreNameInUseException.setErrorCode("CustomKeyStoreNameInUseException");
        return customKeyStoreNameInUseException;
    }
}
