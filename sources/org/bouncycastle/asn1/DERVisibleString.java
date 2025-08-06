package org.bouncycastle.asn1;

public class DERVisibleString extends ASN1VisibleString {
    public DERVisibleString(String str) {
        super(str);
    }

    public DERVisibleString(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERVisibleString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERVisibleString)) {
            return (DERVisibleString) obj;
        }
        if (obj instanceof ASN1VisibleString) {
            return new DERVisibleString(((ASN1VisibleString) obj).contents, false);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERVisibleString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERVisibleString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERVisibleString)) ? getInstance(object) : new DERVisibleString(ASN1OctetString.getInstance(object).getOctets(), true);
    }
}
