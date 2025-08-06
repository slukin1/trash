package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;

public class JsonErrorUnmarshaller extends AbstractErrorUnmarshaller<JsonErrorResponseHandler$JsonErrorResponse> {
    public JsonErrorUnmarshaller() {
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        String b11 = jsonErrorResponseHandler$JsonErrorResponse.b();
        String a11 = jsonErrorResponseHandler$JsonErrorResponse.a();
        if ((b11 == null || b11.isEmpty()) && (a11 == null || a11.isEmpty())) {
            throw new AmazonClientException("Neither error message nor error code is found in the error response payload.");
        }
        AmazonServiceException b12 = b(b11);
        b12.setErrorCode(a11);
        return b12;
    }

    public JsonErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        super(cls);
    }
}
