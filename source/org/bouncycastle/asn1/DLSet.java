package org.bouncycastle.asn1;

import java.io.IOException;

public class DLSet extends ASN1Set {
    private int contentsLength = -1;

    public DLSet() {
    }

    public DLSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public DLSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public DLSet(boolean z11, ASN1Encodable[] aSN1EncodableArr) {
        super(z11, aSN1EncodableArr);
    }

    public DLSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }

    private int getContentsLength() throws IOException {
        if (this.contentsLength < 0) {
            int i11 = 0;
            for (ASN1Encodable aSN1Primitive : this.elements) {
                i11 += aSN1Primitive.toASN1Primitive().toDLObject().encodedLength(true);
            }
            this.contentsLength = i11;
        }
        return this.contentsLength;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeIdentifier(z11, 49);
        DLOutputStream dLSubStream = aSN1OutputStream.getDLSubStream();
        int length = this.elements.length;
        int i11 = 0;
        if (this.contentsLength >= 0 || length > 16) {
            aSN1OutputStream.writeDL(getContentsLength());
            while (i11 < length) {
                dLSubStream.writePrimitive(this.elements[i11].toASN1Primitive(), true);
                i11++;
            }
            return;
        }
        ASN1Primitive[] aSN1PrimitiveArr = new ASN1Primitive[length];
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            ASN1Primitive dLObject = this.elements[i13].toASN1Primitive().toDLObject();
            aSN1PrimitiveArr[i13] = dLObject;
            i12 += dLObject.encodedLength(true);
        }
        this.contentsLength = i12;
        aSN1OutputStream.writeDL(i12);
        while (i11 < length) {
            dLSubStream.writePrimitive(aSN1PrimitiveArr[i11], true);
            i11++;
        }
    }

    public int encodedLength(boolean z11) throws IOException {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, getContentsLength());
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
