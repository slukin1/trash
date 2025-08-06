package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;

public class Longitude extends OneEightyDegreeInt {
    public Longitude(long j11) {
        super(j11);
    }

    public Longitude(BigInteger bigInteger) {
        super(bigInteger);
    }

    private Longitude(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }

    public static Longitude getInstance(Object obj) {
        if (obj instanceof Longitude) {
            return (Longitude) obj;
        }
        if (obj != null) {
            return new Longitude(ASN1Integer.getInstance(obj));
        }
        return null;
    }
}
