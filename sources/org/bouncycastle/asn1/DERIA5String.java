package org.bouncycastle.asn1;

public class DERIA5String extends ASN1IA5String {
    public DERIA5String(String str) {
        this(str, false);
    }

    public DERIA5String(String str, boolean z11) {
        super(str, z11);
    }

    public DERIA5String(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERIA5String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERIA5String)) {
            return (DERIA5String) obj;
        }
        if (obj instanceof ASN1IA5String) {
            return new DERIA5String(((ASN1IA5String) obj).contents, false);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERIA5String) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERIA5String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERIA5String)) ? getInstance(object) : new DERIA5String(ASN1OctetString.getInstance(object).getOctets(), true);
    }
}
