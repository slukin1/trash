package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public final class Ed448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private Ed448PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed448PrivateKeyParameters(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[57];
        this.data = bArr;
        if (57 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 private key");
        }
    }

    public Ed448PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[57];
        this.data = bArr;
        Ed448.generatePrivateKey(secureRandom, bArr);
    }

    public Ed448PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed448PrivateKeyParameters(byte[] bArr, int i11) {
        super(true);
        byte[] bArr2 = new byte[57];
        this.data = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, 57);
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public void encode(byte[] bArr, int i11) {
        System.arraycopy(this.data, 0, bArr, i11, 57);
    }

    public Ed448PublicKeyParameters generatePublicKey() {
        Ed448PublicKeyParameters ed448PublicKeyParameters;
        synchronized (this.data) {
            if (this.cachedPublicKey == null) {
                byte[] bArr = new byte[57];
                Ed448.generatePublicKey(this.data, 0, bArr, 0);
                this.cachedPublicKey = new Ed448PublicKeyParameters(bArr, 0);
            }
            ed448PublicKeyParameters = this.cachedPublicKey;
        }
        return ed448PublicKeyParameters;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public void sign(int i11, Ed448PublicKeyParameters ed448PublicKeyParameters, byte[] bArr, byte[] bArr2, int i12, int i13, byte[] bArr3, int i14) {
        sign(i11, bArr, bArr2, i12, i13, bArr3, i14);
    }

    public void sign(int i11, byte[] bArr, byte[] bArr2, int i12, int i13, byte[] bArr3, int i14) {
        int i15 = i11;
        byte[] bArr4 = new byte[57];
        generatePublicKey().encode(bArr4, 0);
        if (i15 == 0) {
            int i16 = i13;
            Ed448.sign(this.data, 0, bArr4, 0, bArr, bArr2, i12, i13, bArr3, i14);
        } else if (i15 != 1) {
            throw new IllegalArgumentException("algorithm");
        } else if (64 == i13) {
            Ed448.signPrehash(this.data, 0, bArr4, 0, bArr, bArr2, i12, bArr3, i14);
        } else {
            throw new IllegalArgumentException("msgLen");
        }
    }
}
