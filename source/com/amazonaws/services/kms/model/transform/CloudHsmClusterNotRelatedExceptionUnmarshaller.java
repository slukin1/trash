package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.CloudHsmClusterNotRelatedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class CloudHsmClusterNotRelatedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CloudHsmClusterNotRelatedExceptionUnmarshaller() {
        super(CloudHsmClusterNotRelatedException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        CloudHsmClusterNotRelatedException cloudHsmClusterNotRelatedException = (CloudHsmClusterNotRelatedException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        cloudHsmClusterNotRelatedException.setErrorCode("CloudHsmClusterNotRelatedException");
        return cloudHsmClusterNotRelatedException;
    }
}
