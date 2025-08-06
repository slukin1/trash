package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler$JsonErrorResponse;
import com.amazonaws.services.kms.model.XksProxyUriUnreachableException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

public class XksProxyUriUnreachableExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public XksProxyUriUnreachableExceptionUnmarshaller() {
        super(XksProxyUriUnreachableException.class);
    }

    /* renamed from: c */
    public AmazonServiceException a(JsonErrorResponseHandler$JsonErrorResponse jsonErrorResponseHandler$JsonErrorResponse) throws Exception {
        XksProxyUriUnreachableException xksProxyUriUnreachableException = (XksProxyUriUnreachableException) super.a(jsonErrorResponseHandler$JsonErrorResponse);
        xksProxyUriUnreachableException.setErrorCode("XksProxyUriUnreachableException");
        return xksProxyUriUnreachableException;
    }
}
