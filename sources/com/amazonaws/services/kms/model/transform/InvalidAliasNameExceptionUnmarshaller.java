package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.InvalidAliasNameException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class InvalidAliasNameExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidAliasNameExceptionUnmarshaller() {
        super(InvalidAliasNameException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        InvalidAliasNameException invalidAliasNameException = (InvalidAliasNameException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        invalidAliasNameException.setErrorCode("InvalidAliasNameException");
        return invalidAliasNameException;
    }
}
