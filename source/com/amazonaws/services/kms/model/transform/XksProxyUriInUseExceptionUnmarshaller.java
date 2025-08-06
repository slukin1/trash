package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyUriInUseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyUriInUseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriInUseExceptionUnmarshaller() {
        super(XksProxyUriInUseException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyUriInUseException xksProxyUriInUseException = (XksProxyUriInUseException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyUriInUseException.setErrorCode("XksProxyUriInUseException");
        return xksProxyUriInUseException;
    }
}
