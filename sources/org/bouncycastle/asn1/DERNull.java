package org.bouncycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    private static final byte[] zeroBytes = new byte[0];

    private DERNull() {
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 5, zeroBytes);
    }

    public boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, 0);
    }
}
