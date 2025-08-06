package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.NotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class NotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public NotFoundExceptionUnmarshaller() {
        super(NotFoundException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        NotFoundException notFoundException = (NotFoundException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        notFoundException.setErrorCode("NotFoundException");
        return notFoundException;
    }
}
