package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

public abstract class ASN1BMPString extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1BMPString.class, 30) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1BMPString.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final char[] string;

    public ASN1BMPString(String str) {
        Objects.requireNonNull(str, "'string' cannot be null");
        this.string = str.toCharArray();
    }

    public ASN1BMPString(byte[] bArr) {
        Objects.requireNonNull(bArr, "'string' cannot be null");
        int length = bArr.length;
        if ((length & 1) == 0) {
            int i11 = length / 2;
            char[] cArr = new char[i11];
            for (int i12 = 0; i12 != i11; i12++) {
                int i13 = i12 * 2;
                cArr[i12] = (char) ((bArr[i13 + 1] & 255) | (bArr[i13] << 8));
            }
            this.string = cArr;
            return;
        }
        throw new IllegalArgumentException("malformed BMPString encoding encountered");
    }

    public ASN1BMPString(char[] cArr) {
        Objects.requireNonNull(cArr, "'string' cannot be null");
        this.string = cArr;
    }

    public static ASN1BMPString createPrimitive(byte[] bArr) {
        return new DERBMPString(bArr);
    }

    public static ASN1BMPString createPrimitive(char[] cArr) {
        return new DERBMPString(cArr);
    }

    public static ASN1BMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1BMPString)) {
            return (ASN1BMPString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1BMPString) {
                return (ASN1BMPString) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1BMPString) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1BMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1BMPString) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BMPString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((ASN1BMPString) aSN1Primitive).string);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        int length = this.string.length;
        aSN1OutputStream.writeIdentifier(z11, 30);
        aSN1OutputStream.writeDL(length * 2);
        byte[] bArr = new byte[8];
        int i11 = length & -4;
        int i12 = 0;
        while (i12 < i11) {
            char[] cArr = this.string;
            char c11 = cArr[i12];
            char c12 = cArr[i12 + 1];
            char c13 = cArr[i12 + 2];
            char c14 = cArr[i12 + 3];
            i12 += 4;
            bArr[0] = (byte) (c11 >> 8);
            bArr[1] = (byte) c11;
            bArr[2] = (byte) (c12 >> 8);
            bArr[3] = (byte) c12;
            bArr[4] = (byte) (c13 >> 8);
            bArr[5] = (byte) c13;
            bArr[6] = (byte) (c14 >> 8);
            bArr[7] = (byte) c14;
            aSN1OutputStream.write(bArr, 0, 8);
        }
        if (i12 < length) {
            int i13 = 0;
            do {
                char c15 = this.string[i12];
                i12++;
                int i14 = i13 + 1;
                bArr[i13] = (byte) (c15 >> 8);
                i13 = i14 + 1;
                bArr[i14] = (byte) c15;
            } while (i12 < length);
            aSN1OutputStream.write(bArr, 0, i13);
        }
    }

    public final boolean encodeConstructed() {
        return false;
    }

    public final int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.string.length * 2);
    }

    public final String getString() {
        return new String(this.string);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.string);
    }

    public String toString() {
        return getString();
    }
}
