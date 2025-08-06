package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CloudHsmClusterNotActiveException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CloudHsmClusterNotActiveExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterNotActiveExceptionUnmarshaller() {
        super(CloudHsmClusterNotActiveException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CloudHsmClusterNotActiveException cloudHsmClusterNotActiveException = (CloudHsmClusterNotActiveException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        cloudHsmClusterNotActiveException.setErrorCode("CloudHsmClusterNotActiveException");
        return cloudHsmClusterNotActiveException;
    }
}
