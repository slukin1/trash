package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class ECIESKeyEncapsulation implements KeyEncapsulation {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;
    private DerivationFunction kdf;
    private ECKeyParameters key;
    private SecureRandom rnd;

    public ECIESKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    public ECIESKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom, boolean z11, boolean z12, boolean z13) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
        this.CofactorMode = z11;
        if (z11) {
            this.OldCofactorMode = false;
        } else {
            this.OldCofactorMode = z12;
        }
        this.SingleHashMode = z13;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public CipherParameters decrypt(byte[] bArr, int i11) {
        return decrypt(bArr, 0, bArr.length, i11);
    }

    public CipherParameters decrypt(byte[] bArr, int i11, int i12, int i13) throws IllegalArgumentException {
        ECKeyParameters eCKeyParameters = this.key;
        if (eCKeyParameters instanceof ECPrivateKeyParameters) {
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) eCKeyParameters;
            ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
            ECCurve curve = parameters.getCurve();
            BigInteger n11 = parameters.getN();
            BigInteger h11 = parameters.getH();
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            ECPoint decodePoint = curve.decodePoint(bArr2);
            if (this.CofactorMode || this.OldCofactorMode) {
                decodePoint = decodePoint.multiply(h11);
            }
            BigInteger d11 = eCPrivateKeyParameters.getD();
            if (this.CofactorMode) {
                d11 = d11.multiply(parameters.getHInv()).mod(n11);
            }
            return deriveKey(i13, bArr2, decodePoint.multiply(d11).normalize().getAffineXCoord().getEncoded());
        }
        throw new IllegalArgumentException("Private key required for encryption");
    }

    public KeyParameter deriveKey(int i11, byte[] bArr, byte[] bArr2) {
        if (!this.SingleHashMode) {
            byte[] concatenate = Arrays.concatenate(bArr, bArr2);
            Arrays.fill(bArr2, (byte) 0);
            bArr2 = concatenate;
        }
        try {
            this.kdf.init(new KDFParameters(bArr2, (byte[]) null));
            byte[] bArr3 = new byte[i11];
            this.kdf.generateBytes(bArr3, 0, i11);
            return new KeyParameter(bArr3);
        } finally {
            Arrays.fill(bArr2, (byte) 0);
        }
    }

    public CipherParameters encrypt(byte[] bArr, int i11) {
        return encrypt(bArr, 0, i11);
    }

    public CipherParameters encrypt(byte[] bArr, int i11, int i12) throws IllegalArgumentException {
        ECKeyParameters eCKeyParameters = this.key;
        if (eCKeyParameters instanceof ECPublicKeyParameters) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) eCKeyParameters;
            ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
            ECCurve curve = parameters.getCurve();
            BigInteger n11 = parameters.getN();
            BigInteger h11 = parameters.getH();
            BigInteger createRandomInRange = BigIntegers.createRandomInRange(ONE, n11, this.rnd);
            ECPoint[] eCPointArr = {createBasePointMultiplier().multiply(parameters.getG(), createRandomInRange), eCPublicKeyParameters.getQ().multiply(this.OldCofactorMode ? createRandomInRange.multiply(h11).mod(n11) : createRandomInRange)};
            curve.normalizeAll(eCPointArr);
            ECPoint eCPoint = eCPointArr[0];
            ECPoint eCPoint2 = eCPointArr[1];
            byte[] encoded = eCPoint.getEncoded(false);
            System.arraycopy(encoded, 0, bArr, i11, encoded.length);
            return deriveKey(i12, encoded, eCPoint2.getAffineXCoord().getEncoded());
        }
        throw new IllegalArgumentException("Public key required for encryption");
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ECKeyParameters) {
            this.key = (ECKeyParameters) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("EC key required");
    }
}
