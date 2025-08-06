package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;

public class Elevation extends UINT16 {
    public Elevation(int i11) {
        super(i11);
    }

    public Elevation(long j11) {
        super(j11);
    }

    public Elevation(BigInteger bigInteger) {
        super(bigInteger);
    }

    public Elevation(ASN1Integer aSN1Integer) {
        super(aSN1Integer);
    }

    public Elevation(UINT16 uint16) {
        super(uint16.getValue());
    }

    public static Elevation getInstance(Object obj) {
        if (obj instanceof Elevation) {
            return (Elevation) obj;
        }
        if (obj != null) {
            return new Elevation(UINT16.getInstance(obj));
        }
        return null;
    }
}
