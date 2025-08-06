package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class StandardErrorUnmarshaller extends AbstractErrorUnmarshaller<Node> {
    public StandardErrorUnmarshaller() {
    }

    public String c(Node node) throws Exception {
        return XpathUtils.b("ErrorResponse/Error/Code", node);
    }

    /* renamed from: d */
    public AmazonServiceException a(Node node) throws Exception {
        String c11 = c(node);
        String b11 = XpathUtils.b("ErrorResponse/Error/Type", node);
        String b12 = XpathUtils.b("ErrorResponse/RequestId", node);
        AmazonServiceException b13 = b(XpathUtils.b("ErrorResponse/Error/Message", node));
        b13.setErrorCode(c11);
        b13.setRequestId(b12);
        if (b11 == null) {
            b13.setErrorType(AmazonServiceException.ErrorType.Unknown);
        } else if ("Receiver".equalsIgnoreCase(b11)) {
            b13.setErrorType(AmazonServiceException.ErrorType.Service);
        } else if ("Sender".equalsIgnoreCase(b11)) {
            b13.setErrorType(AmazonServiceException.ErrorType.Client);
        }
        return b13;
    }

    public StandardErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        super(cls);
    }
}
