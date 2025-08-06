package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CloudHsmClusterInvalidConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CloudHsmClusterInvalidConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterInvalidConfigurationExceptionUnmarshaller() {
        super(CloudHsmClusterInvalidConfigurationException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CloudHsmClusterInvalidConfigurationException cloudHsmClusterInvalidConfigurationException = (CloudHsmClusterInvalidConfigurationException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        cloudHsmClusterInvalidConfigurationException.setErrorCode("CloudHsmClusterInvalidConfigurationException");
        return cloudHsmClusterInvalidConfigurationException;
    }
}
