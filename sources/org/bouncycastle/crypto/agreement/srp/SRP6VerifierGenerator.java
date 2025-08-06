package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6VerifierGenerator {
    public BigInteger N;
    public Digest digest;

    /* renamed from: g  reason: collision with root package name */
    public BigInteger f59123g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f59123g.modPow(SRP6Util.calculateX(this.digest, this.N, bArr, bArr2, bArr3), this.N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.N = bigInteger;
        this.f59123g = bigInteger2;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2) {
        this.N = sRP6GroupParameters.getN();
        this.f59123g = sRP6GroupParameters.getG();
        this.digest = digest2;
    }
}
