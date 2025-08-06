package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;

public class UINT32 extends UintBase {
    private static final BigInteger MAX = new BigInteger("FFFFFFFF", 16);

    public UINT32(int i11) {
        super(i11);
    }

    public UINT32(long j11) {
        super(j11);
    }

    public UINT32(BigInteger bigInteger) {
        super(bigInteger);
    }

    public UINT32(ASN1Integer aSN1Integer) {
        super(aSN1Integer);
    }

    public static UINT32 getInstance(Object obj) {
        if (obj instanceof UINT8) {
            return (UINT32) obj;
        }
        if (obj != null) {
            return new UINT32(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public void assertLimit() {
        if (this.value.signum() >= 0) {
            BigInteger bigInteger = this.value;
            BigInteger bigInteger2 = MAX;
            if (bigInteger.compareTo(bigInteger2) > 0) {
                throw new IllegalArgumentException("value must not exceed " + bigInteger2.toString(16));
            }
            return;
        }
        throw new IllegalArgumentException("value must not be negative");
    }
}
