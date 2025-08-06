package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageEncryptor;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.Vector;

public class McElieceCipher implements MessageEncryptor {
    public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
    public int cipherTextSize;
    private boolean forEncryption;

    /* renamed from: k  reason: collision with root package name */
    private int f59560k;
    private McElieceKeyParameters key;
    public int maxPlainTextSize;

    /* renamed from: n  reason: collision with root package name */
    private int f59561n;

    /* renamed from: sr  reason: collision with root package name */
    private SecureRandom f59562sr;

    /* renamed from: t  reason: collision with root package name */
    private int f59563t;

    private byte[] computeMessage(GF2Vector gF2Vector) throws InvalidCipherTextException {
        byte[] encoded = gF2Vector.getEncoded();
        int length = encoded.length - 1;
        while (length >= 0 && encoded[length] == 0) {
            length--;
        }
        if (length < 0 || encoded[length] != 1) {
            throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
        }
        byte[] bArr = new byte[length];
        System.arraycopy(encoded, 0, bArr, 0, length);
        return bArr;
    }

    private GF2Vector computeMessageRepresentative(byte[] bArr) {
        byte[] bArr2 = new byte[(this.maxPlainTextSize + ((this.f59560k & 7) != 0 ? 1 : 0))];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[bArr.length] = 1;
        return GF2Vector.OS2VP(this.f59560k, bArr2);
    }

    private void initCipherDecrypt(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.f59561n = mcEliecePrivateKeyParameters.getN();
        int k11 = mcEliecePrivateKeyParameters.getK();
        this.f59560k = k11;
        this.maxPlainTextSize = k11 >> 3;
        this.cipherTextSize = this.f59561n >> 3;
    }

    private void initCipherEncrypt(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this.f59561n = mcEliecePublicKeyParameters.getN();
        this.f59560k = mcEliecePublicKeyParameters.getK();
        this.f59563t = mcEliecePublicKeyParameters.getT();
        this.cipherTextSize = this.f59561n >> 3;
        this.maxPlainTextSize = this.f59560k >> 3;
    }

    public int getKeySize(McElieceKeyParameters mcElieceKeyParameters) {
        if (mcElieceKeyParameters instanceof McEliecePublicKeyParameters) {
            return ((McEliecePublicKeyParameters) mcElieceKeyParameters).getN();
        }
        if (mcElieceKeyParameters instanceof McEliecePrivateKeyParameters) {
            return ((McEliecePrivateKeyParameters) mcElieceKeyParameters).getN();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.forEncryption = z11;
        if (!z11) {
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) cipherParameters;
            this.key = mcEliecePrivateKeyParameters;
            initCipherDecrypt(mcEliecePrivateKeyParameters);
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f59562sr = parametersWithRandom.getRandom();
            McEliecePublicKeyParameters mcEliecePublicKeyParameters = (McEliecePublicKeyParameters) parametersWithRandom.getParameters();
            this.key = mcEliecePublicKeyParameters;
            initCipherEncrypt(mcEliecePublicKeyParameters);
        } else {
            this.f59562sr = CryptoServicesRegistrar.getSecureRandom();
            McEliecePublicKeyParameters mcEliecePublicKeyParameters2 = (McEliecePublicKeyParameters) cipherParameters;
            this.key = mcEliecePublicKeyParameters2;
            initCipherEncrypt(mcEliecePublicKeyParameters2);
        }
    }

    public byte[] messageDecrypt(byte[] bArr) throws InvalidCipherTextException {
        if (!this.forEncryption) {
            GF2Vector OS2VP = GF2Vector.OS2VP(this.f59561n, bArr);
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = (McEliecePrivateKeyParameters) this.key;
            GF2mField field = mcEliecePrivateKeyParameters.getField();
            PolynomialGF2mSmallM goppaPoly = mcEliecePrivateKeyParameters.getGoppaPoly();
            GF2Matrix sInv = mcEliecePrivateKeyParameters.getSInv();
            Permutation p12 = mcEliecePrivateKeyParameters.getP1();
            Permutation p22 = mcEliecePrivateKeyParameters.getP2();
            GF2Matrix h11 = mcEliecePrivateKeyParameters.getH();
            PolynomialGF2mSmallM[] qInv = mcEliecePrivateKeyParameters.getQInv();
            Permutation rightMultiply = p12.rightMultiply(p22);
            GF2Vector gF2Vector = (GF2Vector) OS2VP.multiply(rightMultiply.computeInverse());
            GF2Vector syndromeDecode = GoppaCode.syndromeDecode((GF2Vector) h11.rightMultiply((Vector) gF2Vector), field, goppaPoly, qInv);
            GF2Vector gF2Vector2 = (GF2Vector) syndromeDecode.multiply(rightMultiply);
            return computeMessage((GF2Vector) sInv.leftMultiply((Vector) ((GF2Vector) ((GF2Vector) gF2Vector.add(syndromeDecode)).multiply(p12)).extractRightVector(this.f59560k)));
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }

    public byte[] messageEncrypt(byte[] bArr) {
        if (this.forEncryption) {
            GF2Vector computeMessageRepresentative = computeMessageRepresentative(bArr);
            return ((GF2Vector) ((McEliecePublicKeyParameters) this.key).getG().leftMultiply((Vector) computeMessageRepresentative).add(new GF2Vector(this.f59561n, this.f59563t, this.f59562sr))).getEncoded();
        }
        throw new IllegalStateException("cipher initialised for decryption");
    }
}
