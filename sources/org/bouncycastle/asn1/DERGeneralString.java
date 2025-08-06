package org.bouncycastle.asn1;

public class DERGeneralString extends ASN1GeneralString {
    public DERGeneralString(String str) {
        super(str);
    }

    public DERGeneralString(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERGeneralString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGeneralString)) {
            return (DERGeneralString) obj;
        }
        if (obj instanceof ASN1GeneralString) {
            return new DERGeneralString(((ASN1GeneralString) obj).contents, false);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERGeneralString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERGeneralString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERGeneralString)) ? getInstance(object) : new DERGeneralString(ASN1OctetString.getInstance(object).getOctets(), true);
    }
}
