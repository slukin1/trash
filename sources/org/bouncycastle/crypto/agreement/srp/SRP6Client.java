package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

public class SRP6Client {
    public BigInteger A;
    public BigInteger B;
    public BigInteger Key;
    public BigInteger M1;
    public BigInteger M2;
    public BigInteger N;
    public BigInteger S;

    /* renamed from: a  reason: collision with root package name */
    public BigInteger f59115a;
    public Digest digest;

    /* renamed from: g  reason: collision with root package name */
    public BigInteger f59116g;
    public SecureRandom random;

    /* renamed from: u  reason: collision with root package name */
    public BigInteger f59117u;

    /* renamed from: x  reason: collision with root package name */
    public BigInteger f59118x;

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.N, this.f59116g);
        return this.B.subtract(this.f59116g.modPow(this.f59118x, this.N).multiply(calculateK).mod(this.N)).mod(this.N).modPow(this.f59117u.multiply(this.f59118x).add(this.f59115a), this.N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.A;
        if (bigInteger3 == null || (bigInteger = this.B) == null || (bigInteger2 = this.S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger calculateM1 = SRP6Util.calculateM1(this.digest, this.N, bigInteger3, bigInteger, bigInteger2);
        this.M1 = calculateM1;
        return calculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger validatePublicValue = SRP6Util.validatePublicValue(this.N, bigInteger);
        this.B = validatePublicValue;
        this.f59117u = SRP6Util.calculateU(this.digest, this.N, this.A, validatePublicValue);
        BigInteger calculateS = calculateS();
        this.S = calculateS;
        return calculateS;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.S;
        if (bigInteger == null || this.M1 == null || this.M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger calculateKey = SRP6Util.calculateKey(this.digest, this.N, bigInteger);
        this.Key = calculateKey;
        return calculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f59118x = SRP6Util.calculateX(this.digest, this.N, bArr, bArr2, bArr3);
        BigInteger selectPrivateValue = selectPrivateValue();
        this.f59115a = selectPrivateValue;
        BigInteger modPow = this.f59116g.modPow(selectPrivateValue, this.N);
        this.A = modPow;
        return modPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.N = bigInteger;
        this.f59116g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest2, secureRandom);
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.f59116g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.A;
        if (bigInteger4 == null || (bigInteger2 = this.M1) == null || (bigInteger3 = this.S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        } else if (!SRP6Util.calculateM2(this.digest, this.N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.M2 = bigInteger;
            return true;
        }
    }
}
