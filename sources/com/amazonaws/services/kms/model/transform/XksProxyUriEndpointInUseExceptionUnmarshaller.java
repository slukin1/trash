package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyUriEndpointInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyUriEndpointInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriEndpointInUseExceptionUnmarshaller() {
        super(XksProxyUriEndpointInUseException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyUriEndpointInUseException xksProxyUriEndpointInUseException = (XksProxyUriEndpointInUseException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyUriEndpointInUseException.setErrorCode("XksProxyUriEndpointInUseException");
        return xksProxyUriEndpointInUseException;
    }
}
