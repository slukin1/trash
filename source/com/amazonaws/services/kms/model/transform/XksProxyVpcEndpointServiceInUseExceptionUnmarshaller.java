package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyVpcEndpointServiceInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyVpcEndpointServiceInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyVpcEndpointServiceInUseExceptionUnmarshaller() {
        super(XksProxyVpcEndpointServiceInUseException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyVpcEndpointServiceInUseException xksProxyVpcEndpointServiceInUseException = (XksProxyVpcEndpointServiceInUseException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyVpcEndpointServiceInUseException.setErrorCode("XksProxyVpcEndpointServiceInUseException");
        return xksProxyVpcEndpointServiceInUseException;
    }
}
