package org.bouncycastle.asn1;

public class DERGraphicString extends ASN1GraphicString {
    public DERGraphicString(byte[] bArr) {
        this(bArr, true);
    }

    public DERGraphicString(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERGraphicString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGraphicString)) {
            return (DERGraphicString) obj;
        }
        if (obj instanceof ASN1GraphicString) {
            return new DERGraphicString(((ASN1GraphicString) obj).contents, false);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERGraphicString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERGraphicString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERGraphicString)) ? getInstance(object) : new DERGraphicString(ASN1OctetString.getInstance(object).getOctets());
    }
}
