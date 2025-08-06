package org.bouncycastle.oer;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.asn1.ASN1Encodable;

public class OEREncoder {
    public static byte[] toByteArray(ASN1Encodable aSN1Encodable, Element element) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new OEROutputStream(byteArrayOutputStream).write(aSN1Encodable, element);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e11) {
            throw new IllegalStateException(e11.getMessage(), e11);
        }
    }
}
