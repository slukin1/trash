package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

public abstract class PBEParametersGenerator {
    public int iterationCount;
    public byte[] password;
    public byte[] salt;

    public static byte[] PKCS12PasswordToBytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[((cArr.length + 1) * 2)];
        for (int i11 = 0; i11 != cArr.length; i11++) {
            int i12 = i11 * 2;
            bArr[i12] = (byte) (cArr[i11] >>> 8);
            bArr[i12 + 1] = (byte) cArr[i11];
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToBytes(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            bArr[i11] = (byte) cArr[i11];
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] cArr) {
        return cArr != null ? Strings.toUTF8ByteArray(cArr) : new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int i11);

    public abstract CipherParameters generateDerivedParameters(int i11);

    public abstract CipherParameters generateDerivedParameters(int i11, int i12);

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void init(byte[] bArr, byte[] bArr2, int i11) {
        this.password = bArr;
        this.salt = bArr2;
        this.iterationCount = i11;
    }
}
