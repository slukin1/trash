package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.DisabledException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DisabledExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DisabledExceptionUnmarshaller() {
        super(DisabledException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        DisabledException disabledException = (DisabledException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        disabledException.setErrorCode("DisabledException");
        return disabledException;
    }
}
