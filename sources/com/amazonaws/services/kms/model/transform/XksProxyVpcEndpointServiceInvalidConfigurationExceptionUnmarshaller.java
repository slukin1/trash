package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyVpcEndpointServiceInvalidConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyVpcEndpointServiceInvalidConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyVpcEndpointServiceInvalidConfigurationExceptionUnmarshaller() {
        super(XksProxyVpcEndpointServiceInvalidConfigurationException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyVpcEndpointServiceInvalidConfigurationException xksProxyVpcEndpointServiceInvalidConfigurationException = (XksProxyVpcEndpointServiceInvalidConfigurationException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyVpcEndpointServiceInvalidConfigurationException.setErrorCode("XksProxyVpcEndpointServiceInvalidConfigurationException");
        return xksProxyVpcEndpointServiceInvalidConfigurationException;
    }
}
