package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.cognitoidentity.model.InvalidIdentityPoolConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidIdentityPoolConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidIdentityPoolConfigurationExceptionUnmarshaller() {
        super(InvalidIdentityPoolConfigurationException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidIdentityPoolConfigurationException invalidIdentityPoolConfigurationException = (InvalidIdentityPoolConfigurationException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidIdentityPoolConfigurationException.setErrorCode("InvalidIdentityPoolConfigurationException");
        return invalidIdentityPoolConfigurationException;
    }
}
