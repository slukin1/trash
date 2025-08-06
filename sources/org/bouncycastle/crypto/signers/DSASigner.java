package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.DSAKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class DSASigner implements DSAExt {
    private final DSAKCalculator kCalculator;
    private DSAKeyParameters key;
    private SecureRandom random;

    public DSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public DSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int bitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(bArr, 0, bArr2, 0, bitLength);
        return new BigInteger(1, bArr2);
    }

    private BigInteger getRandomizer(BigInteger bigInteger, SecureRandom secureRandom) {
        return BigIntegers.createRandomBigInteger(7, CryptoServicesRegistrar.getSecureRandom(secureRandom)).add(BigInteger.valueOf(128)).multiply(bigInteger);
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger q11 = parameters.getQ();
        BigInteger calculateE = calculateE(q11, bArr);
        BigInteger x11 = ((DSAPrivateKeyParameters) this.key).getX();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(q11, x11, bArr);
        } else {
            this.kCalculator.init(q11, this.random);
        }
        BigInteger nextK = this.kCalculator.nextK();
        BigInteger mod = parameters.getG().modPow(nextK.add(getRandomizer(q11, this.random)), parameters.getP()).mod(q11);
        return new BigInteger[]{mod, BigIntegers.modOddInverse(q11, nextK).multiply(calculateE.add(x11.multiply(mod))).mod(q11)};
    }

    public BigInteger getOrder() {
        return this.key.getParameters().getQ();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r2, org.bouncycastle.crypto.CipherParameters r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0018
            boolean r0 = r3 instanceof org.bouncycastle.crypto.params.ParametersWithRandom
            if (r0 == 0) goto L_0x0015
            org.bouncycastle.crypto.params.ParametersWithRandom r3 = (org.bouncycastle.crypto.params.ParametersWithRandom) r3
            org.bouncycastle.crypto.CipherParameters r0 = r3.getParameters()
            org.bouncycastle.crypto.params.DSAPrivateKeyParameters r0 = (org.bouncycastle.crypto.params.DSAPrivateKeyParameters) r0
            r1.key = r0
            java.security.SecureRandom r3 = r3.getRandom()
            goto L_0x001d
        L_0x0015:
            org.bouncycastle.crypto.params.DSAPrivateKeyParameters r3 = (org.bouncycastle.crypto.params.DSAPrivateKeyParameters) r3
            goto L_0x001a
        L_0x0018:
            org.bouncycastle.crypto.params.DSAPublicKeyParameters r3 = (org.bouncycastle.crypto.params.DSAPublicKeyParameters) r3
        L_0x001a:
            r1.key = r3
            r3 = 0
        L_0x001d:
            if (r2 == 0) goto L_0x0029
            org.bouncycastle.crypto.signers.DSAKCalculator r2 = r1.kCalculator
            boolean r2 = r2.isDeterministic()
            if (r2 != 0) goto L_0x0029
            r2 = 1
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            java.security.SecureRandom r2 = r1.initSecureRandom(r2, r3)
            r1.random = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.signers.DSASigner.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    public SecureRandom initSecureRandom(boolean z11, SecureRandom secureRandom) {
        if (z11) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger q11 = parameters.getQ();
        BigInteger calculateE = calculateE(q11, bArr);
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) >= 0 || q11.compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || q11.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modOddInverseVar = BigIntegers.modOddInverseVar(q11, bigInteger2);
        BigInteger mod = calculateE.multiply(modOddInverseVar).mod(q11);
        BigInteger mod2 = bigInteger.multiply(modOddInverseVar).mod(q11);
        BigInteger p11 = parameters.getP();
        return parameters.getG().modPow(mod, p11).multiply(((DSAPublicKeyParameters) this.key).getY().modPow(mod2, p11)).mod(p11).mod(q11).equals(bigInteger);
    }
}
