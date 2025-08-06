package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksKeyInvalidConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksKeyInvalidConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksKeyInvalidConfigurationExceptionUnmarshaller() {
        super(XksKeyInvalidConfigurationException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksKeyInvalidConfigurationException xksKeyInvalidConfigurationException = (XksKeyInvalidConfigurationException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksKeyInvalidConfigurationException.setErrorCode("XksKeyInvalidConfigurationException");
        return xksKeyInvalidConfigurationException;
    }
}
