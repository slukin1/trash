package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksKeyNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksKeyNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksKeyNotFoundExceptionUnmarshaller() {
        super(XksKeyNotFoundException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksKeyNotFoundException xksKeyNotFoundException = (XksKeyNotFoundException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksKeyNotFoundException.setErrorCode("XksKeyNotFoundException");
        return xksKeyNotFoundException;
    }
}
