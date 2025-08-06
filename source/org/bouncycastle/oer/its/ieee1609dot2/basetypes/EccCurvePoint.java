package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import org.bouncycastle.asn1.ASN1Object;

public abstract class EccCurvePoint extends ASN1Object {
    public abstract byte[] getEncodedPoint();
}
