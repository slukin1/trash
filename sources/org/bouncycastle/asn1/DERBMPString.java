package org.bouncycastle.asn1;

public class DERBMPString extends ASN1BMPString {
    public DERBMPString(String str) {
        super(str);
    }

    public DERBMPString(byte[] bArr) {
        super(bArr);
    }

    public DERBMPString(char[] cArr) {
        super(cArr);
    }

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        if (obj instanceof ASN1BMPString) {
            return new DERBMPString(((ASN1BMPString) obj).string);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERBMPString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERBMPString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERBMPString)) ? getInstance(object) : new DERBMPString(ASN1OctetString.getInstance(object).getOctets());
    }
}
