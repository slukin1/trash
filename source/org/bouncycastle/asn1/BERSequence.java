package org.bouncycastle.asn1;

import java.io.IOException;

public class BERSequence extends ASN1Sequence {
    public BERSequence() {
    }

    public BERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public BERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public BERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingIL(z11, 48, this.elements);
    }

    public int encodedLength(boolean z11) throws IOException {
        int i11 = z11 ? 4 : 3;
        for (ASN1Encodable aSN1Primitive : this.elements) {
            i11 += aSN1Primitive.toASN1Primitive().encodedLength(true);
        }
        return i11;
    }

    public ASN1BitString toASN1BitString() {
        return new BERBitString(getConstructedBitStrings());
    }

    public ASN1External toASN1External() {
        return ((ASN1Sequence) toDLObject()).toASN1External();
    }

    public ASN1OctetString toASN1OctetString() {
        return new BEROctetString(getConstructedOctetStrings());
    }

    public ASN1Set toASN1Set() {
        return new BERSet(false, toArrayInternal());
    }
}
