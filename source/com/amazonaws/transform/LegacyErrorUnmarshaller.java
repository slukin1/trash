package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class LegacyErrorUnmarshaller implements Unmarshaller<AmazonServiceException, Node> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends AmazonServiceException> f15508a;

    public LegacyErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    public String b(Node node) throws Exception {
        return XpathUtils.b("Response/Errors/Error/Code", node);
    }

    /* renamed from: c */
    public AmazonServiceException a(Node node) throws Exception {
        String b11 = b(node);
        String b12 = XpathUtils.b("Response/Errors/Error/Message", node);
        String b13 = XpathUtils.b("Response/RequestID", node);
        String b14 = XpathUtils.b("Response/Errors/Error/Type", node);
        AmazonServiceException amazonServiceException = (AmazonServiceException) this.f15508a.getConstructor(new Class[]{String.class}).newInstance(new Object[]{b12});
        amazonServiceException.setErrorCode(b11);
        amazonServiceException.setRequestId(b13);
        if (b14 == null) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Unknown);
        } else if ("server".equalsIgnoreCase(b14)) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
        } else if ("client".equalsIgnoreCase(b14)) {
            amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
        }
        return amazonServiceException;
    }

    public LegacyErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.f15508a = cls;
    }
}
