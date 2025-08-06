package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1NumericString extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1NumericString.class, 18) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1NumericString.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1NumericString(String str, boolean z11) {
        if (!z11 || isNumericString(str)) {
            this.contents = Strings.toByteArray(str);
            return;
        }
        throw new IllegalArgumentException("string contains illegal characters");
    }

    public ASN1NumericString(byte[] bArr, boolean z11) {
        this.contents = z11 ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1NumericString createPrimitive(byte[] bArr) {
        return new DERNumericString(bArr, false);
    }

    public static ASN1NumericString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1NumericString)) {
            return (ASN1NumericString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1NumericString) {
                return (ASN1NumericString) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1NumericString) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1NumericString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1NumericString) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public static boolean isNumericString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt > 127) {
                return false;
            }
            if (('0' > charAt || charAt > '9') && charAt != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericString(byte[] bArr) {
        for (byte b11 : bArr) {
            if (b11 != 32) {
                switch (b11) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1NumericString)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1NumericString) aSN1Primitive).contents);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 18, this.contents);
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
        return Strings.fromByteArray(this.contents);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
