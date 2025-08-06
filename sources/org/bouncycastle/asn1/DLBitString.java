package org.bouncycastle.asn1;

import java.io.IOException;

public class DLBitString extends ASN1BitString {
    public DLBitString(byte b11, int i11) {
        super(b11, i11);
    }

    public DLBitString(int i11) {
        super(ASN1BitString.getBytes(i11), ASN1BitString.getPadBits(i11));
    }

    public DLBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public DLBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DLBitString(byte[] bArr, int i11) {
        super(bArr, i11);
    }

    public DLBitString(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static void encode(ASN1OutputStream aSN1OutputStream, boolean z11, byte b11, byte[] bArr, int i11, int i12) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 3, b11, bArr, i11, i12);
    }

    public static void encode(ASN1OutputStream aSN1OutputStream, boolean z11, byte[] bArr, int i11, int i12) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 3, bArr, i11, i12);
    }

    public static int encodedLength(boolean z11, int i11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, i11);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 3, this.contents);
    }

    public boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
