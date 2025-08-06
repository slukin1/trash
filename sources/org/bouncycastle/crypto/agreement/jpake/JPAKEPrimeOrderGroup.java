package org.bouncycastle.crypto.agreement.jpake;

import fv.g;
import java.math.BigInteger;

public class JPAKEPrimeOrderGroup {

    /* renamed from: g  reason: collision with root package name */
    private final BigInteger f59105g;

    /* renamed from: p  reason: collision with root package name */
    private final BigInteger f59106p;

    /* renamed from: q  reason: collision with root package name */
    private final BigInteger f59107q;

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    public JPAKEPrimeOrderGroup(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z11) {
        JPAKEUtil.validateNotNull(bigInteger, TtmlNode.TAG_P);
        JPAKEUtil.validateNotNull(bigInteger2, "q");
        JPAKEUtil.validateNotNull(bigInteger3, g.f22793a);
        if (!z11) {
            BigInteger bigInteger4 = JPAKEUtil.ONE;
            if (!bigInteger.subtract(bigInteger4).mod(bigInteger2).equals(JPAKEUtil.ZERO)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            } else if (bigInteger3.compareTo(BigInteger.valueOf(2)) == -1 || bigInteger3.compareTo(bigInteger.subtract(bigInteger4)) == 1) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            } else if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(bigInteger4)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            } else if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            } else if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.f59106p = bigInteger;
        this.f59107q = bigInteger2;
        this.f59105g = bigInteger3;
    }

    public BigInteger getG() {
        return this.f59105g;
    }

    public BigInteger getP() {
        return this.f59106p;
    }

    public BigInteger getQ() {
        return this.f59107q;
    }
}
