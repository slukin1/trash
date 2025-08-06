package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.DryRunOperationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DryRunOperationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DryRunOperationExceptionUnmarshaller() {
        super(DryRunOperationException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        DryRunOperationException dryRunOperationException = (DryRunOperationException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        dryRunOperationException.setErrorCode("DryRunOperationException");
        return dryRunOperationException;
    }
}
