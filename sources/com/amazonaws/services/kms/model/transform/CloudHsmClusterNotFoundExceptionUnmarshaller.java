package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CloudHsmClusterNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CloudHsmClusterNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterNotFoundExceptionUnmarshaller() {
        super(CloudHsmClusterNotFoundException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CloudHsmClusterNotFoundException cloudHsmClusterNotFoundException = (CloudHsmClusterNotFoundException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        cloudHsmClusterNotFoundException.setErrorCode("CloudHsmClusterNotFoundException");
        return cloudHsmClusterNotFoundException;
    }
}
