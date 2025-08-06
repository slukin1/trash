package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.IncorrectTrustAnchorException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class IncorrectTrustAnchorExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public IncorrectTrustAnchorExceptionUnmarshaller() {
        super(IncorrectTrustAnchorException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        IncorrectTrustAnchorException incorrectTrustAnchorException = (IncorrectTrustAnchorException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        incorrectTrustAnchorException.setErrorCode("IncorrectTrustAnchorException");
        return incorrectTrustAnchorException;
    }
}
