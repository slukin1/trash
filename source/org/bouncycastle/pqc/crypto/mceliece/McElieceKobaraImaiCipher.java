package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.bouncycastle.pqc.crypto.MessageEncryptor;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

public class McElieceKobaraImaiCipher implements MessageEncryptor {
    private static final String DEFAULT_PRNG_NAME = "SHA1PRNG";
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.3";
    public static final byte[] PUBLIC_CONSTANT = "a predetermined public constant".getBytes();
    private boolean forEncryption;

    /* renamed from: k  reason: collision with root package name */
    private int f59571k;
    public McElieceCCA2KeyParameters key;
    private Digest messDigest;

    /* renamed from: n  reason: collision with root package name */
    private int f59572n;

    /* renamed from: sr  reason: collision with root package name */
    private SecureRandom f59573sr;

    /* renamed from: t  reason: collision with root package name */
    private int f59574t;

    private void initCipherDecrypt(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.messDigest = Utils.getDigest(mcElieceCCA2PrivateKeyParameters.getDigest());
        this.f59572n = mcElieceCCA2PrivateKeyParameters.getN();
        this.f59571k = mcElieceCCA2PrivateKeyParameters.getK();
        this.f59574t = mcElieceCCA2PrivateKeyParameters.getT();
    }

    private void initCipherEncrypt(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.messDigest = Utils.getDigest(mcElieceCCA2PublicKeyParameters.getDigest());
        this.f59572n = mcElieceCCA2PublicKeyParameters.getN();
        this.f59571k = mcElieceCCA2PublicKeyParameters.getK();
        this.f59574t = mcElieceCCA2PublicKeyParameters.getT();
    }

    public int getKeySize(McElieceCCA2KeyParameters mcElieceCCA2KeyParameters) {
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters) {
            return ((McElieceCCA2PublicKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        if (mcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters) {
            return ((McElieceCCA2PrivateKeyParameters) mcElieceCCA2KeyParameters).getN();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.forEncryption = z11;
        if (!z11) {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = (McElieceCCA2PrivateKeyParameters) cipherParameters;
            this.key = mcElieceCCA2PrivateKeyParameters;
            initCipherDecrypt(mcElieceCCA2PrivateKeyParameters);
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f59573sr = parametersWithRandom.getRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = (McElieceCCA2PublicKeyParameters) parametersWithRandom.getParameters();
            this.key = mcElieceCCA2PublicKeyParameters;
            initCipherEncrypt(mcElieceCCA2PublicKeyParameters);
        } else {
            this.f59573sr = CryptoServicesRegistrar.getSecureRandom();
            McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = (McElieceCCA2PublicKeyParameters) cipherParameters;
            this.key = mcElieceCCA2PublicKeyParameters2;
            initCipherEncrypt(mcElieceCCA2PublicKeyParameters2);
        }
    }

    public byte[] messageDecrypt(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArr2;
        if (!this.forEncryption) {
            int i11 = this.f59572n >> 3;
            if (bArr.length >= i11) {
                int digestSize = this.messDigest.getDigestSize();
                int i12 = this.f59571k >> 3;
                int bitLength = (IntegerFunctions.binomial(this.f59572n, this.f59574t).bitLength() - 1) >> 3;
                int length = bArr.length - i11;
                if (length > 0) {
                    byte[][] split = ByteUtils.split(bArr, length);
                    bArr2 = split[0];
                    bArr = split[1];
                } else {
                    bArr2 = new byte[0];
                }
                GF2Vector[] decryptionPrimitive = McElieceCCA2Primitives.decryptionPrimitive((McElieceCCA2PrivateKeyParameters) this.key, GF2Vector.OS2VP(this.f59572n, bArr));
                byte[] encoded = decryptionPrimitive[0].getEncoded();
                GF2Vector gF2Vector = decryptionPrimitive[1];
                if (encoded.length > i12) {
                    encoded = ByteUtils.subArray(encoded, 0, i12);
                }
                byte[] decode = Conversions.decode(this.f59572n, this.f59574t, gF2Vector);
                if (decode.length < bitLength) {
                    byte[] bArr3 = new byte[bitLength];
                    System.arraycopy(decode, 0, bArr3, bitLength - decode.length, decode.length);
                    decode = bArr3;
                }
                byte[] concatenate = ByteUtils.concatenate(ByteUtils.concatenate(bArr2, decode), encoded);
                int length2 = concatenate.length - digestSize;
                byte[][] split2 = ByteUtils.split(concatenate, digestSize);
                byte[] bArr4 = split2[0];
                byte[] bArr5 = split2[1];
                byte[] bArr6 = new byte[this.messDigest.getDigestSize()];
                this.messDigest.update(bArr5, 0, bArr5.length);
                this.messDigest.doFinal(bArr6, 0);
                for (int i13 = digestSize - 1; i13 >= 0; i13--) {
                    bArr6[i13] = (byte) (bArr6[i13] ^ bArr4[i13]);
                }
                DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
                digestRandomGenerator.addSeedMaterial(bArr6);
                byte[] bArr7 = new byte[length2];
                digestRandomGenerator.nextBytes(bArr7);
                for (int i14 = length2 - 1; i14 >= 0; i14--) {
                    bArr7[i14] = (byte) (bArr7[i14] ^ bArr5[i14]);
                }
                byte[] bArr8 = PUBLIC_CONSTANT;
                byte[][] split3 = ByteUtils.split(bArr7, length2 - bArr8.length);
                byte[] bArr9 = split3[0];
                if (ByteUtils.equals(split3[1], bArr8)) {
                    return bArr9;
                }
                throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
            }
            throw new InvalidCipherTextException("Bad Padding: Ciphertext too short.");
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public byte[] messageEncrypt(byte[] bArr) {
        if (this.forEncryption) {
            int digestSize = this.messDigest.getDigestSize();
            int i11 = this.f59571k >> 3;
            int bitLength = (IntegerFunctions.binomial(this.f59572n, this.f59574t).bitLength() - 1) >> 3;
            byte[] bArr2 = PUBLIC_CONSTANT;
            int length = ((i11 + bitLength) - digestSize) - bArr2.length;
            if (bArr.length > length) {
                length = bArr.length;
            }
            int length2 = bArr2.length + length;
            int i12 = ((length2 + digestSize) - i11) - bitLength;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, length, bArr2.length);
            byte[] bArr4 = new byte[digestSize];
            this.f59573sr.nextBytes(bArr4);
            DigestRandomGenerator digestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
            digestRandomGenerator.addSeedMaterial(bArr4);
            byte[] bArr5 = new byte[length2];
            digestRandomGenerator.nextBytes(bArr5);
            for (int i13 = length2 - 1; i13 >= 0; i13--) {
                bArr5[i13] = (byte) (bArr5[i13] ^ bArr3[i13]);
            }
            byte[] bArr6 = new byte[this.messDigest.getDigestSize()];
            this.messDigest.update(bArr5, 0, length2);
            this.messDigest.doFinal(bArr6, 0);
            for (int i14 = digestSize - 1; i14 >= 0; i14--) {
                bArr6[i14] = (byte) (bArr6[i14] ^ bArr4[i14]);
            }
            byte[] concatenate = ByteUtils.concatenate(bArr6, bArr5);
            byte[] bArr7 = new byte[0];
            if (i12 > 0) {
                bArr7 = new byte[i12];
                System.arraycopy(concatenate, 0, bArr7, 0, i12);
            }
            byte[] bArr8 = new byte[bitLength];
            System.arraycopy(concatenate, i12, bArr8, 0, bitLength);
            byte[] bArr9 = new byte[i11];
            System.arraycopy(concatenate, bitLength + i12, bArr9, 0, i11);
            byte[] encoded = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters) this.key, GF2Vector.OS2VP(this.f59571k, bArr9), Conversions.encode(this.f59572n, this.f59574t, bArr8)).getEncoded();
            return i12 > 0 ? ByteUtils.concatenate(bArr7, encoded) : encoded;
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
