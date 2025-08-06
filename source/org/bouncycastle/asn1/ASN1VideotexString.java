package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public abstract class ASN1VideotexString extends ASN1Primitive implements ASN1String {
    public static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1VideotexString.class, 21) {
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1VideotexString.createPrimitive(dEROctetString.getOctets());
        }
    };
    public final byte[] contents;

    public ASN1VideotexString(byte[] bArr, boolean z11) {
        this.contents = z11 ? Arrays.clone(bArr) : bArr;
    }

    public static ASN1VideotexString createPrimitive(byte[] bArr) {
        return new DERVideotexString(bArr, false);
    }

    public static ASN1VideotexString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1VideotexString)) {
            return (ASN1VideotexString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1VideotexString) {
                return (ASN1VideotexString) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1VideotexString) TYPE.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ASN1VideotexString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return (ASN1VideotexString) TYPE.getContextInstance(aSN1TaggedObject, z11);
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1VideotexString)) {
            return false;
        }
        return Arrays.areEqual(this.contents, ((ASN1VideotexString) aSN1Primitive).contents);
    }

    public final void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 21, this.contents);
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
}
