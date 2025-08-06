package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.LimitExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class LimitExceededExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public LimitExceededExceptionUnmarshaller() {
        super(LimitExceededException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        LimitExceededException limitExceededException = (LimitExceededException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        limitExceededException.setErrorCode("LimitExceededException");
        return limitExceededException;
    }
}
