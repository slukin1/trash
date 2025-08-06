package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.cognitoidentity.model.DeveloperUserAlreadyRegisteredException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class DeveloperUserAlreadyRegisteredExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DeveloperUserAlreadyRegisteredExceptionUnmarshaller() {
        super(DeveloperUserAlreadyRegisteredException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        DeveloperUserAlreadyRegisteredException developerUserAlreadyRegisteredException = (DeveloperUserAlreadyRegisteredException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        developerUserAlreadyRegisteredException.setErrorCode("DeveloperUserAlreadyRegisteredException");
        return developerUserAlreadyRegisteredException;
    }
}
