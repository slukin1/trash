package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public abstract class ASN1UniversalString extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1UniversalString.class, 28) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1UniversalString.createPrimitive(dEROctetString.getOctets());
        }
    };
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] contents;

    public ASN1UniversalString(byte[] bArr, boolean z11) {
        this.contents = z11 ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1UniversalString createPrimitive(byte[] bArr) {
        return new DERUniversalString(bArr, false);
    }

    private static void encodeHexByte(StringBuffer stringBuffer, int i11) {
        char[] cArr = table;
        stringBuffer.append(cArr[(i11 >>> 4) & 15]);
        stringBuffer.append(cArr[i11 & 15]);
    }

    private static void encodeHexDL(StringBuffer stringBuffer, int i11) {
        if (i11 < 128) {
            encodeHexByte(stringBuffer, i11);
            return;
        }
        byte[] bArr = new byte[5];
        int i12 = 5;
        do {
            i12--;
            bArr[i12] = (byte) i11;
            i11 >>>= 8;
        } while (i11 != 0);
        int i13 = 5 - i12;
        int i14 = i12 - 1;
        bArr[i14] = (byte) (i13 | 128);
        while (true) {
            int i15 = i14 + 1;
            encodeHexByte(stringBuffer, bArr[i14]);
            if (i15 < 5) {
                i14 = i15;
            } else {
                return;
            }
        }
    }

    public static ASN1UniversalString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UniversalString)) {
            return (ASN1UniversalString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1UniversalString) {
                return (ASN1UniversalString) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1UniversalString) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1UniversalString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1UniversalString) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UniversalString)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1UniversalString) aSN1Primitive).contents);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 28, this.contents);
    }

    public final boolean encodeConstructed() {
        return false;
    }

    public final int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public final byte[] getOctets() {
        return Arrays.clone(this.contents);
    }

    public final String getString() {
        StringBuffer stringBuffer = new StringBuffer(((ASN1OutputStream.getLengthOfDL(r0) + r0) * 2) + 3);
        stringBuffer.append("#1C");
        encodeHexDL(stringBuffer, r0);
        for (byte encodeHexByte : this.contents) {
            encodeHexByte(stringBuffer, encodeHexByte);
        }
        return stringBuffer.toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
