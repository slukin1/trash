package org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Absent extends ASN1Primitive {
    public static final ASN1Absent INSTANCE = new ASN1Absent();

    private ASN1Absent() {
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive == this;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
    }

    public boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) throws IOException {
        return 0;
    }

    public int hashCode() {
        return 0;
    }
}
