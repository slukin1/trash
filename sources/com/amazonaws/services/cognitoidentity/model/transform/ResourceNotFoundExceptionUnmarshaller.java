package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.cognitoidentity.model.ResourceNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class ResourceNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ResourceNotFoundExceptionUnmarshaller() {
        super(ResourceNotFoundException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        ResourceNotFoundException resourceNotFoundException = (ResourceNotFoundException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        resourceNotFoundException.setErrorCode("ResourceNotFoundException");
        return resourceNotFoundException;
    }
}
