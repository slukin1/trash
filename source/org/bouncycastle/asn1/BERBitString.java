package org.bouncycastle.asn1;

import java.io.IOException;

public class BERBitString extends ASN1BitString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
    private final ASN1BitString[] elements;
    private final int segmentLimit;

    public BERBitString(byte b11, int i11) {
        super(b11, i11);
        this.elements = null;
        this.segmentLimit = 1000;
    }

    public BERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        this(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public BERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public BERBitString(byte[] bArr, int i11) {
        this(bArr, i11, 1000);
    }

    public BERBitString(byte[] bArr, int i11, int i12) {
        super(bArr, i11);
        this.elements = null;
        this.segmentLimit = i12;
    }

    public BERBitString(byte[] bArr, boolean z11) {
        super(bArr, z11);
        this.elements = null;
        this.segmentLimit = 1000;
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr) {
        this(aSN1BitStringArr, 1000);
    }

    public BERBitString(ASN1BitString[] aSN1BitStringArr, int i11) {
        super(flattenBitStrings(aSN1BitStringArr), false);
        this.elements = aSN1BitStringArr;
        this.segmentLimit = i11;
    }

    public static byte[] flattenBitStrings(ASN1BitString[] aSN1BitStringArr) {
        if (r0 == 0) {
            return new byte[]{0};
        } else if (r0 == 1) {
            return aSN1BitStringArr[0].contents;
        } else {
            int i11 = r0 - 1;
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11) {
                byte[] bArr = aSN1BitStringArr[i12].contents;
                if (bArr[0] == 0) {
                    i13 += bArr.length - 1;
                    i12++;
                } else {
                    throw new IllegalArgumentException("only the last nested bitstring can have padding");
                }
            }
            byte[] bArr2 = aSN1BitStringArr[i11].contents;
            byte b11 = bArr2[0];
            byte[] bArr3 = new byte[(i13 + bArr2.length)];
            bArr3[0] = b11;
            int i14 = 1;
            for (ASN1BitString aSN1BitString : aSN1BitStringArr) {
                byte[] bArr4 = aSN1BitString.contents;
                int length = bArr4.length - 1;
                System.arraycopy(bArr4, 1, bArr3, i14, length);
                i14 += length;
            }
            return bArr3;
        }
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        if (!encodeConstructed()) {
            byte[] bArr = this.contents;
            DLBitString.encode(aSN1OutputStream, z11, bArr, 0, bArr.length);
            return;
        }
        aSN1OutputStream.writeIdentifier(z11, 35);
        aSN1OutputStream.write(128);
        ASN1BitString[] aSN1BitStringArr = this.elements;
        if (aSN1BitStringArr != null) {
            aSN1OutputStream.writePrimitives(aSN1BitStringArr);
        } else {
            byte[] bArr2 = this.contents;
            if (bArr2.length >= 2) {
                byte b11 = bArr2[0];
                int length = bArr2.length;
                int i11 = length - 1;
                int i12 = this.segmentLimit - 1;
                while (i11 > i12) {
                    DLBitString.encode(aSN1OutputStream, true, (byte) 0, this.contents, length - i11, i12);
                    i11 -= i12;
                }
                DLBitString.encode(aSN1OutputStream, true, b11, this.contents, length - i11, i11);
            }
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    public boolean encodeConstructed() {
        return this.elements != null || this.contents.length > this.segmentLimit;
    }

    public int encodedLength(boolean z11) throws IOException {
        if (!encodeConstructed()) {
            return DLBitString.encodedLength(z11, this.contents.length);
        }
        int i11 = z11 ? 4 : 3;
        if (this.elements != null) {
            int i12 = 0;
            while (true) {
                ASN1BitString[] aSN1BitStringArr = this.elements;
                if (i12 >= aSN1BitStringArr.length) {
                    return i11;
                }
                i11 += aSN1BitStringArr[i12].encodedLength(true);
                i12++;
            }
        } else {
            byte[] bArr = this.contents;
            if (bArr.length < 2) {
                return i11;
            }
            int i13 = this.segmentLimit;
            int length = (bArr.length - 2) / (i13 - 1);
            return i11 + (DLBitString.encodedLength(true, i13) * length) + DLBitString.encodedLength(true, this.contents.length - (length * (this.segmentLimit - 1)));
        }
    }
}
