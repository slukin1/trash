package org.bouncycastle.asn1;

public class DERT61String extends ASN1T61String {
    public DERT61String(String str) {
        super(str);
    }

    public DERT61String(byte[] bArr) {
        this(bArr, true);
    }

    public DERT61String(byte[] bArr, boolean z11) {
        super(bArr, z11);
    }

    public static DERT61String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERT61String)) {
            return (DERT61String) obj;
        }
        if (obj instanceof ASN1T61String) {
            return new DERT61String(((ASN1T61String) obj).contents, false);
        }
        if (obj instanceof byte[]) {
            try {
                return (DERT61String) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e11) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e11.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static DERT61String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z11 || (object instanceof DERT61String)) ? getInstance(object) : new DERT61String(ASN1OctetString.getInstance(object).getOctets(), true);
    }
}
