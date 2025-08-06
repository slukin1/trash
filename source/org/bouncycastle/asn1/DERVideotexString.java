package org.bouncycastle.asn1;

public class DERVideotexString extends ASN1VideotexString {
    public DERVideotexString(byte[] bArr) {
        this(bArr, true);
    }

    public DERVideotexString(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERVideotexString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVideotexString)) {
            return (DERVideotexString) obj;
        }
        if (obj instanceof ASN1VideotexString) {
            return new DERVideotexString(((ASN1VideotexString) obj).contents, false);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERVideotexString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERVideotexString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERVideotexString)) ? getInstance(object) : new DERVideotexString(ASN1OctetString.getInstance(object).getOctets());
    }
}
