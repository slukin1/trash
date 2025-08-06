package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class RSAKeyEncapsulation implements KeyEncapsulation {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private DerivationFunction kdf;
    private RSAKeyParameters key;
    private SecureRandom rnd;

    public RSAKeyEncapsulation(DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
    }

    public CipherParameters decrypt(byte[] bArr, int i11) {
        return decrypt(bArr, 0, bArr.length, i11);
    }

    public CipherParameters decrypt(byte[] bArr, int i11, int i12, int i13) throws IllegalArgumentException {
        if (this.key.isPrivate()) {
            BigInteger modulus = this.key.getModulus();
            BigInteger exponent = this.key.getExponent();
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            return generateKey(modulus, new BigInteger(1, bArr2).modPow(exponent, modulus), i13);
        }
        throw new IllegalArgumentException("Private key required for decryption");
    }

    public CipherParameters encrypt(byte[] bArr, int i11) {
        return encrypt(bArr, 0, i11);
    }

    public CipherParameters encrypt(byte[] bArr, int i11, int i12) throws IllegalArgumentException {
        if (!this.key.isPrivate()) {
            BigInteger modulus = this.key.getModulus();
            BigInteger exponent = this.key.getExponent();
            BigInteger createRandomInRange = BigIntegers.createRandomInRange(ZERO, modulus.subtract(ONE), this.rnd);
            byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray((modulus.bitLength() + 7) / 8, createRandomInRange.modPow(exponent, modulus));
            System.arraycopy(asUnsignedByteArray, 0, bArr, i11, asUnsignedByteArray.length);
            return generateKey(modulus, createRandomInRange, i12);
        }
        throw new IllegalArgumentException("Public key required for encryption");
    }

    public KeyParameter generateKey(BigInteger bigInteger, BigInteger bigInteger2, int i11) {
        this.kdf.init(new KDFParameters(BigIntegers.asUnsignedByteArray((bigInteger.bitLength() + 7) / 8, bigInteger2), (byte[]) null));
        byte[] bArr = new byte[i11];
        this.kdf.generateBytes(bArr, 0, i11);
        return new KeyParameter(bArr);
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof RSAKeyParameters) {
            this.key = (RSAKeyParameters) cipherParameters;
            return;
        }
        throw new IllegalArgumentException("RSA key required");
    }
}
