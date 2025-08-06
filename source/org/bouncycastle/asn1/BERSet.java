package org.bouncycastle.asn1;

import java.io.IOException;

public class BERSet extends ASN1Set {
    public BERSet() {
    }

    public BERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public BERSet(boolean z11, ASN1Encodable[] aSN1EncodableArr) {
        super(z11, aSN1EncodableArr);
    }

    public BERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingIL(z11, 49, this.elements);
    }

    public int encodedLength(boolean z11) throws IOException {
        int i11 = z11 ? 4 : 3;
        for (ASN1Encodable aSN1Primitive : this.elements) {
            i11 += aSN1Primitive.toASN1Primitive().encodedLength(true);
        }
        return i11;
    }
}
