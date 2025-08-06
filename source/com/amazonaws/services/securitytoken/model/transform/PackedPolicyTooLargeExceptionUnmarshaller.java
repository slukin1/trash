package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.securitytoken.model.PackedPolicyTooLargeException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class PackedPolicyTooLargeExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public PackedPolicyTooLargeExceptionUnmarshaller() {
        super(PackedPolicyTooLargeException.class);
    }

    /* renamed from: d */
    public AmazonServiceException a(Node node) throws Exception {
        String c11 = c(node);
        if (c11 == null || !c11.equals("PackedPolicyTooLarge")) {
            return null;
        }
        return (PackedPolicyTooLargeException) super.a(node);
    }
}
