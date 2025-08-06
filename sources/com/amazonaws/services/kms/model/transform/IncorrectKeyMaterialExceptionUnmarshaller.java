package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.IncorrectKeyMaterialException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class IncorrectKeyMaterialExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public IncorrectKeyMaterialExceptionUnmarshaller() {
        super(IncorrectKeyMaterialException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        IncorrectKeyMaterialException incorrectKeyMaterialException = (IncorrectKeyMaterialException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        incorrectKeyMaterialException.setErrorCode("IncorrectKeyMaterialException");
        return incorrectKeyMaterialException;
    }
}
