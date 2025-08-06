package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;

public class KeyUsage extends ASN1Object {
    public static final int cRLSign = 2;
    public static final int dataEncipherment = 16;
    public static final int decipherOnly = 32768;
    public static final int digitalSignature = 128;
    public static final int encipherOnly = 1;
    public static final int keyAgreement = 8;
    public static final int keyCertSign = 4;
    public static final int keyEncipherment = 32;
    public static final int nonRepudiation = 64;
    private ASN1BitString bitString;

    public KeyUsage(int i11) {
        this.bitString = new DERBitString(i11);
    }

    private KeyUsage(ASN1BitString aSN1BitString) {
        this.bitString = aSN1BitString;
    }

    public static KeyUsage fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.keyUsage));
    }

    public static KeyUsage getInstance(Object obj) {
        if (obj instanceof KeyUsage) {
            return (KeyUsage) obj;
        }
        if (obj != null) {
            return new KeyUsage(ASN1BitString.getInstance(obj));
        }
        return null;
    }

    public byte[] getBytes() {
        return this.bitString.getBytes();
    }

    public int getPadBits() {
        return this.bitString.getPadBits();
    }

    public boolean hasUsages(int i11) {
        return (this.bitString.intValue() & i11) == i11;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.bitString;
    }

    public String toString() {
        StringBuilder sb2;
        byte b11;
        byte[] bytes = this.bitString.getBytes();
        if (bytes.length == 1) {
            sb2 = new StringBuilder();
            sb2.append("KeyUsage: 0x");
            b11 = bytes[0] & 255;
        } else {
            sb2 = new StringBuilder();
            sb2.append("KeyUsage: 0x");
            b11 = (bytes[0] & 255) | ((bytes[1] & 255) << 8);
        }
        sb2.append(Integer.toHexString(b11));
        return sb2.toString();
    }
}
