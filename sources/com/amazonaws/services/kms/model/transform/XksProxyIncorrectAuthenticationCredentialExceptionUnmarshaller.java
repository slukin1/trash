package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyIncorrectAuthenticationCredentialException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyIncorrectAuthenticationCredentialExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyIncorrectAuthenticationCredentialExceptionUnmarshaller() {
        super(XksProxyIncorrectAuthenticationCredentialException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyIncorrectAuthenticationCredentialException xksProxyIncorrectAuthenticationCredentialException = (XksProxyIncorrectAuthenticationCredentialException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyIncorrectAuthenticationCredentialException.setErrorCode("XksProxyIncorrectAuthenticationCredentialException");
        return xksProxyIncorrectAuthenticationCredentialException;
    }
}
