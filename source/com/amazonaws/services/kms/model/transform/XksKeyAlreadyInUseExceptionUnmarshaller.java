package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksKeyAlreadyInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksKeyAlreadyInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksKeyAlreadyInUseExceptionUnmarshaller() {
        super(XksKeyAlreadyInUseException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksKeyAlreadyInUseException xksKeyAlreadyInUseException = (XksKeyAlreadyInUseException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksKeyAlreadyInUseException.setErrorCode("XksKeyAlreadyInUseException");
        return xksKeyAlreadyInUseException;
    }
}
