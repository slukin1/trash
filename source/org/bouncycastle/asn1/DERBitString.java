package org.bouncycastle.asn1;

import java.io.IOException;

public class DERBitString extends ASN1BitString {
    public DERBitString(byte b11, int i11) {
        super(b11, i11);
    }

    public DERBitString(int i11) {
        super(ASN1BitString.getBytes(i11), ASN1BitString.getPadBits(i11));
    }

    public DERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(byte[] bArr, int i11) {
        super(bArr, i11);
    }

    public DERBitString(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERBitString convert(ASN1BitString aSN1BitString) {
        return (DERBitString) aSN1BitString.toDERObject();
    }

    public static DERBitString fromOctetString(ASN1OctetString aSN1OctetString) {
        return new DERBitString(aSN1OctetString.getOctets(), true);
    }

    public static DERBitString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBitString)) {
            return (DERBitString) obj;
        }
        if (obj instanceof ASN1BitString) {
            return convert((ASN1BitString) obj);
        }
        if (obj instanceof byte[]) {
            try {
                return convert((ASN1BitString) ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERBitString)) ? getInstance(object) : fromOctetString(ASN1OctetString.getInstance(object));
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        byte[] bArr = this.contents;
        int length = bArr.length - 1;
        byte b11 = bArr[length];
        byte b12 = (byte) ((255 << (bArr[0] & 255)) & bArr[length]);
        if (b11 == b12) {
            aSN1OutputStream.writeEncodingDL(z11, 3, bArr);
        } else {
            aSN1OutputStream.writeEncodingDL(z11, 3, bArr, 0, length, b12);
        }
    }

    public boolean encodeConstructed() {
        return false;
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
