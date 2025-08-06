package org.bouncycastle.crypto.prng.drbg;

import java.math.BigInteger;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class DualECSP800DRBG implements SP80090DRBG {
    private static final int MAX_ADDITIONAL_INPUT = 4096;
    private static final int MAX_ENTROPY_LENGTH = 4096;
    private static final int MAX_PERSONALIZATION_STRING = 4096;
    private static final long RESEED_MAX = 2147483648L;
    private static final DualECPoints[] nistPoints;
    private static final BigInteger p256_Px;
    private static final BigInteger p256_Py;
    private static final BigInteger p256_Qx;
    private static final BigInteger p256_Qy;
    private static final BigInteger p384_Px;
    private static final BigInteger p384_Py;
    private static final BigInteger p384_Qx;
    private static final BigInteger p384_Qy;
    private static final BigInteger p521_Px;
    private static final BigInteger p521_Py;
    private static final BigInteger p521_Qx;
    private static final BigInteger p521_Qy;
    private ECPoint _P;
    private ECPoint _Q;
    private ECCurve.Fp _curve;
    private Digest _digest;
    private EntropySource _entropySource;
    private ECMultiplier _fixedPointMultiplier;
    private int _outlen;
    private long _reseedCounter;
    private byte[] _s;
    private int _sLength;
    private int _securityStrength;
    private int _seedlen;

    static {
        BigInteger bigInteger = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        p256_Px = bigInteger;
        BigInteger bigInteger2 = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        p256_Py = bigInteger2;
        BigInteger bigInteger3 = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        p256_Qx = bigInteger3;
        BigInteger bigInteger4 = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        p256_Qy = bigInteger4;
        BigInteger bigInteger5 = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        p384_Px = bigInteger5;
        BigInteger bigInteger6 = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        p384_Py = bigInteger6;
        BigInteger bigInteger7 = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        p384_Qx = bigInteger7;
        BigInteger bigInteger8 = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        p384_Qy = bigInteger8;
        BigInteger bigInteger9 = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        p521_Px = bigInteger9;
        BigInteger bigInteger10 = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        p521_Py = bigInteger10;
        BigInteger bigInteger11 = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        p521_Qx = bigInteger11;
        BigInteger bigInteger12 = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        p521_Qy = bigInteger12;
        DualECPoints[] dualECPointsArr = new DualECPoints[3];
        nistPoints = dualECPointsArr;
        ECCurve.Fp fp2 = (ECCurve.Fp) NISTNamedCurves.getByNameLazy("P-256").getCurve();
        dualECPointsArr[0] = new DualECPoints(128, fp2.createPoint(bigInteger, bigInteger2), fp2.createPoint(bigInteger3, bigInteger4), 1);
        ECCurve.Fp fp3 = (ECCurve.Fp) NISTNamedCurves.getByNameLazy("P-384").getCurve();
        dualECPointsArr[1] = new DualECPoints(192, fp3.createPoint(bigInteger5, bigInteger6), fp3.createPoint(bigInteger7, bigInteger8), 1);
        ECCurve.Fp fp4 = (ECCurve.Fp) NISTNamedCurves.getByNameLazy("P-521").getCurve();
        dualECPointsArr[2] = new DualECPoints(256, fp4.createPoint(bigInteger9, bigInteger10), fp4.createPoint(bigInteger11, bigInteger12), 1);
    }

    public DualECSP800DRBG(Digest digest, int i11, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this(nistPoints, digest, i11, entropySource, bArr, bArr2);
    }

    public DualECSP800DRBG(DualECPoints[] dualECPointsArr, Digest digest, int i11, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        this._fixedPointMultiplier = new FixedPointCombMultiplier();
        this._digest = digest;
        this._entropySource = entropySource;
        this._securityStrength = i11;
        if (Utils.isTooLarge(bArr, 512)) {
            throw new IllegalArgumentException("Personalization string too large");
        } else if (entropySource.entropySize() < i11 || entropySource.entropySize() > 4096) {
            throw new IllegalArgumentException("EntropySource must provide between " + i11 + " and " + 4096 + " bits");
        } else {
            byte[] concatenate = Arrays.concatenate(getEntropy(), bArr2, bArr);
            int i12 = 0;
            while (true) {
                if (i12 == dualECPointsArr.length) {
                    break;
                } else if (i11 > dualECPointsArr[i12].getSecurityStrength()) {
                    i12++;
                } else if (Utils.getMaxSecurityStrength(digest) >= dualECPointsArr[i12].getSecurityStrength()) {
                    this._seedlen = dualECPointsArr[i12].getSeedLen();
                    this._outlen = dualECPointsArr[i12].getMaxOutlen() / 8;
                    this._P = dualECPointsArr[i12].getP();
                    this._Q = dualECPointsArr[i12].getQ();
                } else {
                    throw new IllegalArgumentException("Requested security strength is not supported by digest");
                }
            }
            if (this._P != null) {
                byte[] hash_df = Utils.hash_df(this._digest, concatenate, this._seedlen);
                this._s = hash_df;
                this._sLength = hash_df.length;
                this._reseedCounter = 0;
                return;
            }
            throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
        }
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private BigInteger getScalarMultipleXCoord(ECPoint eCPoint, BigInteger bigInteger) {
        return this._fixedPointMultiplier.multiply(eCPoint, bigInteger).normalize().getAffineXCoord().toBigInteger();
    }

    private byte[] pad8(byte[] bArr, int i11) {
        int i12 = i11 % 8;
        if (i12 == 0) {
            return bArr;
        }
        int i13 = 8 - i12;
        byte b11 = 0;
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b12 = bArr[length] & 255;
            bArr[length] = (byte) ((b11 >> (8 - i13)) | (b12 << i13));
            length--;
            b11 = b12;
        }
        return bArr;
    }

    private byte[] xor(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            return bArr;
        }
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    public int generate(byte[] bArr, byte[] bArr2, boolean z11) {
        BigInteger bigInteger;
        int length = bArr.length * 8;
        int length2 = bArr.length / this._outlen;
        if (Utils.isTooLarge(bArr2, 512)) {
            throw new IllegalArgumentException("Additional input too large");
        } else if (this._reseedCounter + ((long) length2) > RESEED_MAX) {
            return -1;
        } else {
            if (z11) {
                reseed(bArr2);
                bArr2 = null;
            }
            if (bArr2 != null) {
                bigInteger = new BigInteger(1, xor(this._s, Utils.hash_df(this._digest, bArr2, this._seedlen)));
            } else {
                bigInteger = new BigInteger(1, this._s);
            }
            int i11 = 0;
            Arrays.fill(bArr, (byte) 0);
            int i12 = 0;
            for (int i13 = 0; i13 < length2; i13++) {
                bigInteger = getScalarMultipleXCoord(this._P, bigInteger);
                byte[] byteArray = getScalarMultipleXCoord(this._Q, bigInteger).toByteArray();
                int length3 = byteArray.length;
                int i14 = this._outlen;
                if (length3 > i14) {
                    System.arraycopy(byteArray, byteArray.length - i14, bArr, i12, i14);
                } else {
                    System.arraycopy(byteArray, 0, bArr, (i14 - byteArray.length) + i12, byteArray.length);
                }
                i12 += this._outlen;
                this._reseedCounter++;
            }
            if (i12 < bArr.length) {
                bigInteger = getScalarMultipleXCoord(this._P, bigInteger);
                byte[] byteArray2 = getScalarMultipleXCoord(this._Q, bigInteger).toByteArray();
                int length4 = bArr.length - i12;
                int length5 = byteArray2.length;
                int i15 = this._outlen;
                if (length5 > i15) {
                    i11 = byteArray2.length - i15;
                } else {
                    i12 += i15 - byteArray2.length;
                }
                System.arraycopy(byteArray2, i11, bArr, i12, length4);
                this._reseedCounter++;
            }
            this._s = BigIntegers.asUnsignedByteArray(this._sLength, getScalarMultipleXCoord(this._P, bigInteger));
            return length;
        }
    }

    public int getBlockSize() {
        return this._outlen * 8;
    }

    public void reseed(byte[] bArr) {
        if (!Utils.isTooLarge(bArr, 512)) {
            this._s = Utils.hash_df(this._digest, Arrays.concatenate(pad8(this._s, this._seedlen), getEntropy(), bArr), this._seedlen);
            this._reseedCounter = 0;
            return;
        }
        throw new IllegalArgumentException("Additional input string too large");
    }
}
