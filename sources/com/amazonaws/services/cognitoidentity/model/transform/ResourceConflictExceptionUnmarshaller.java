package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.cognitoidentity.model.ResourceConflictException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ResourceConflictExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceConflictExceptionUnmarshaller() {
        super(ResourceConflictException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        ResourceConflictException resourceConflictException = (ResourceConflictException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        resourceConflictException.setErrorCode("ResourceConflictException");
        return resourceConflictException;
    }
}
