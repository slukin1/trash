package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.ExpiredTokenException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class ExpiredTokenExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public ExpiredTokenExceptionUnmarshaller() {
        super(ExpiredTokenException.class);
    }

    /* renamed from: d */
    public AmazonServiceException a(Node node) throws Exception {
        String c11 = c(node);
        if (c11 == null || !c11.equals("ExpiredTokenException")) {
            return null;
        }
        return (ExpiredTokenException) super.a(node);
    }
}
