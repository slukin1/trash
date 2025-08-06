package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class BodyPartID extends ASN1Object {
    public static final long bodyIdMax = 4294967295L;

    /* renamed from: id  reason: collision with root package name */
    private final long f59035id;

    public BodyPartID(long j11) {
        if (j11 < 0 || j11 > 4294967295L) {
            throw new IllegalArgumentException("id out of range");
        }
        this.f59035id = j11;
    }

    private BodyPartID(ASN1Integer aSN1Integer) {
        this(convert(aSN1Integer.getValue()));
    }

    private static long convert(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 32) {
            return bigInteger.longValue();
        }
        throw new IllegalArgumentException("id out of range");
    }

    public static BodyPartID getInstance(Object obj) {
        if (obj instanceof BodyPartID) {
            return (BodyPartID) obj;
        }
        if (obj != null) {
            return new BodyPartID(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public long getID() {
        return this.f59035id;
    }

    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f59035id);
    }
}
