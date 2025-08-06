package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1UTF8String extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1UTF8String.class, 12) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1UTF8String.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1UTF8String(String str) {
        this(Strings.toUTF8ByteArray(str), false);
    }

    public ASN1UTF8String(byte[] bArr, boolean z11) {
        this.contents = z11 ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1UTF8String createPrimitive(byte[] bArr) {
        return new DERUTF8String(bArr, false);
    }

    public static ASN1UTF8String getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UTF8String)) {
            return (ASN1UTF8String) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1UTF8String) {
                return (ASN1UTF8String) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1UTF8String) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1UTF8String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1UTF8String) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1UTF8String)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1UTF8String) aSN1Primitive).contents);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 12, this.contents);
    }

    public final boolean encodeConstructed() {
        return false;
    }

    public final int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, this.contents.length);
    }

    public final String getString() {
        return Strings.fromUTF8ByteArray(this.contents);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }
}
