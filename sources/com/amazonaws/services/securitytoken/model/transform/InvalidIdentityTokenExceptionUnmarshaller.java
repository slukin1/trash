package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.InvalidIdentityTokenException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidIdentityTokenExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidIdentityTokenExceptionUnmarshaller() {
        super(InvalidIdentityTokenException.class);
    }

    /* renamed from: d */
    public AmazonServiceException a(Node node) throws Exception {
        String c11 = c(node);
        if (c11 == null || !c11.equals("InvalidIdentityToken")) {
            return null;
        }
        return (InvalidIdentityTokenException) super.a(node);
    }
}
