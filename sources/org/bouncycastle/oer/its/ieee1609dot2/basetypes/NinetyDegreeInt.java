package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class NinetyDegreeInt extends ASN1Object {
    private static final BigInteger loweBound = new BigInteger("-900000000");
    private static final BigInteger unknown = new BigInteger("900000001");
    private static final BigInteger upperBound = new BigInteger("900000000");
    private final BigInteger value;

    public NinetyDegreeInt(long j11) {
        this(BigInteger.valueOf(j11));
    }

    public NinetyDegreeInt(BigInteger bigInteger) {
        if (!bigInteger.equals(unknown)) {
            if (bigInteger.compareTo(loweBound) < 0) {
                throw new IllegalStateException("ninety degree int cannot be less than -900000000");
            } else if (bigInteger.compareTo(upperBound) > 0) {
                throw new IllegalStateException("ninety degree int cannot be greater than 900000000");
            }
        }
        this.value = bigInteger;
    }

    private NinetyDegreeInt(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }

    public static NinetyDegreeInt getInstance(Object obj) {
        if (obj instanceof NinetyDegreeInt) {
            return (NinetyDegreeInt) obj;
        }
        if (obj != null) {
            return new NinetyDegreeInt(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.value;
    }

    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.value);
    }
}
