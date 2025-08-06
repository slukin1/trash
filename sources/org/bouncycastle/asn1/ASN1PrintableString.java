package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1PrintableString extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1PrintableString.class, 19) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1PrintableString.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1PrintableString(String str, boolean z11) {
        if (!z11 || isPrintableString(str)) {
            this.contents = Strings.toByteArray(str);
            return;
        }
        throw new IllegalArgumentException("string contains illegal characters");
    }

    public ASN1PrintableString(byte[] bArr, boolean z11) {
        this.contents = z11 ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1PrintableString createPrimitive(byte[] bArr) {
        return new DERPrintableString(bArr, false);
    }

    public static ASN1PrintableString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1PrintableString)) {
            return (ASN1PrintableString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1PrintableString) {
                return (ASN1PrintableString) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1PrintableString) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1PrintableString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1PrintableString) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public static boolean isPrintableString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            if (charAt > 127) {
                return false;
            }
            if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && !(('0' <= charAt && charAt <= '9') || charAt == ' ' || charAt == ':' || charAt == '=' || charAt == '?'))) {
                switch (charAt) {
                    case '\'':
                    case '(':
                    case ')':
                        continue;
                    default:
                        switch (charAt) {
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                                break;
                            default:
                                return false;
                        }
                }
            }
        }
        return true;
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1PrintableString)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1PrintableString) aSN1Primitive).contents);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 19, this.contents);
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
