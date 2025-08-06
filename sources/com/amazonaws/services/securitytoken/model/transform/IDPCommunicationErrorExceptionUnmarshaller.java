package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.IDPCommunicationErrorException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class IDPCommunicationErrorExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public IDPCommunicationErrorExceptionUnmarshaller() {
        super(IDPCommunicationErrorException.class);
    }

    /* renamed from: d */
    public AmazonServiceException a(Node node) throws Exception {
        String c11 = c(node);
        if (c11 == null || !c11.equals("IDPCommunicationError")) {
            return null;
        }
        return (IDPCommunicationErrorException) super.a(node);
    }
}
