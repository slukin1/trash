package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyInvalidResponseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyInvalidResponseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyInvalidResponseExceptionUnmarshaller() {
        super(XksProxyInvalidResponseException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyInvalidResponseException xksProxyInvalidResponseException = (XksProxyInvalidResponseException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyInvalidResponseException.setErrorCode("XksProxyInvalidResponseException");
        return xksProxyInvalidResponseException;
    }
}
