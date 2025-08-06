package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.InvalidAuthorizationMessageException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidAuthorizationMessageExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidAuthorizationMessageExceptionUnmarshaller() {
        super(InvalidAuthorizationMessageException.class);
    }

    /* renamed from: d */
    public AmazonServiceException a(Node node) throws Exception {
        String c11 = c(node);
        if (c11 == null || !c11.equals("InvalidAuthorizationMessageException")) {
            return null;
        }
        return (InvalidAuthorizationMessageException) super.a(node);
    }
}
