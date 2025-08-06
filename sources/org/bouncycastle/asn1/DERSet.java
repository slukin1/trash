package org.bouncycastle.asn1;

import java.io.IOException;

public class DERSet extends ASN1Set {
    private int contentsLength = -1;

    public DERSet() {
    }

    public DERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, true);
    }

    public DERSet(boolean z11, ASN1Encodable[] aSN1EncodableArr) {
        super(checkSorted(z11), aSN1EncodableArr);
    }

    public DERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, true);
    }

    private static boolean checkSorted(boolean z11) {
        if (z11) {
            return z11;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    public static DERSet convert(ASN1Set aSN1Set) {
        return (DERSet) aSN1Set.toDERObject();
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
        aSN1OutputStream.writeIdentifier(z11, 49);
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

    public ASN1Primitive toDERObject() {
        return this.isSorted ? this : super.toDERObject();
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
