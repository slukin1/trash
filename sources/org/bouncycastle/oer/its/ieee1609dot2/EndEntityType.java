package org.bouncycastle.oer.its.ieee1609dot2;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;

public class EndEntityType extends ASN1Object {
    public static final int app = 128;
    public static final int enrol = 64;
    private final ASN1BitString type;

    public EndEntityType(int i11) {
        this(new DERBitString(i11));
    }

    private EndEntityType(DERBitString dERBitString) {
        this.type = dERBitString;
    }

    public static EndEntityType getInstance(Object obj) {
        if (obj instanceof EndEntityType) {
            return (EndEntityType) obj;
        }
        if (obj != null) {
            return new EndEntityType(DERBitString.getInstance(obj));
        }
        return null;
    }

    public ASN1BitString getType() {
        return this.type;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.type;
    }
}
