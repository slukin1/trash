package org.bouncycastle.oer.its.etsi102941.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.UINT8;

public class Version extends ASN1Object {
    private final BigInteger version;

    public Version(int i11) {
        this(BigInteger.valueOf((long) i11));
    }

    public Version(long j11) {
        this(BigInteger.valueOf(j11));
    }

    public Version(BigInteger bigInteger) {
        this.version = bigInteger;
    }

    public Version(ASN1Integer aSN1Integer) {
        this.version = aSN1Integer.getValue();
    }

    public static Version getInstance(Object obj) {
        if (obj instanceof UINT8) {
            return (Version) obj;
        }
        if (obj != null) {
            return new Version(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.version);
    }
}
