package org.bouncycastle.oer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;

public class OERDecoder {
    public static ASN1Encodable decode(InputStream inputStream, Element element) throws IOException {
        return new OERInputStream(inputStream).parse(element);
    }

    public static ASN1Encodable decode(byte[] bArr, Element element) throws IOException {
        return decode((InputStream) new ByteArrayInputStream(bArr), element);
    }
}
