package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1IA5String extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1IA5String.class, 22) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1IA5String.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1IA5String(String str, boolean z11) {
        Objects.requireNonNull(str, "'string' cannot be null");
        if (!z11 || isIA5String(str)) {
            this.contents = Strings.toByteArray(str);
            return;
        }
        throw new IllegalArgumentException("'string' contains illegal characters");
    }

    public ASN1IA5String(byte[] bArr, boolean z11) {
        this.contents = z11 ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1IA5String createPrimitive(byte[] bArr) {
        return new DERIA5String(bArr, false);
    }

    public static ASN1IA5String getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1IA5String)) {
            return (ASN1IA5String) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1IA5String) {
                return (ASN1IA5String) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1IA5String) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1IA5String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1IA5String) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public static boolean isIA5String(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > 127) {
                return false;
            }
        }
        return true;
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1IA5String)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1IA5String) aSN1Primitive).contents);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 22, this.contents);
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
