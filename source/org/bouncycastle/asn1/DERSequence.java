package org.bouncycastle.asn1;

import java.io.IOException;

public class DERSequence extends ASN1Sequence {
    private int contentsLength = -1;

    public DERSequence() {
    }

    public DERSequence(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSequence(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector);
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr);
    }

    public DERSequence(ASN1Encodable[] aSN1EncodableArr, boolean z11) {
        super(aSN1EncodableArr, z11);
    }

    public static DERSequence convert(ASN1Sequence aSN1Sequence) {
        return (DERSequence) aSN1Sequence.toDERObject();
    }

    private int getContentsLength() throws IOException {
        if (this.contentsLength < 0) {
            int i11 = 0;
            for (ASN1Encodable aSN1Primitive : this.elements) {
                i11 += aSN1Primitive.toASN1Primitive().toDERObject().encodedLength(true);
            }
            this.contentsLength = i11;
        }
        return this.contentsLength;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeIdentifier(z11, 48);
        DEROutputStream dERSubStream = aSN1OutputStream.getDERSubStream();
        int length = this.elements.length;
        int i11 = 0;
        if (this.contentsLength >= 0 || length > 16) {
            aSN1OutputStream.writeDL(getContentsLength());
            while (i11 < length) {
                this.elements[i11].toASN1Primitive().toDERObject().encode(dERSubStream, true);
                i11++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            ASN1Primitive dERObject = this.elements[i13].toASN1Primitive().toDERObject();
            aSN1PrimitiveArr[i13] = dERObject;
            i12 += dERObject.encodedLength(true);
        }
        this.contentsLength = i12;
        aSN1OutputStream.writeDL(i12);
        while (i11 < length) {
            aSN1PrimitiveArr[i11].encode(dERSubStream, true);
            i11++;
        }
    }

    public int encodedLength(boolean z11) throws IOException {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, getContentsLength());
    }

    public ASN1BitString toASN1BitString() {
        return new DERBitString(BERBitString.flattenBitStrings(getConstructedBitStrings()), false);
    }

    public ASN1External toASN1External() {
        return new DERExternal(this);
    }

    public ASN1OctetString toASN1OctetString() {
        return new DEROctetString(BEROctetString.flattenOctetStrings(getConstructedOctetStrings()));
    }

    public ASN1Set toASN1Set() {
        return new DLSet(false, toArrayInternal());
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
