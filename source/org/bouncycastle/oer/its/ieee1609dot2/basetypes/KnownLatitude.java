package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;

public class KnownLatitude extends NinetyDegreeInt {
    public KnownLatitude(long j11) {
        super(j11);
    }

    public KnownLatitude(BigInteger bigInteger) {
        super(bigInteger);
    }

    private KnownLatitude(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }

    public static KnownLatitude getInstance(Object obj) {
        if (obj instanceof KnownLatitude) {
            return (KnownLatitude) obj;
        }
        if (obj != null) {
            return new KnownLatitude(ASN1Integer.getInstance(obj));
        }
        return null;
    }
}
