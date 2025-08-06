package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class HKDFBytesGenerator implements DerivationFunction {
    private byte[] currentT;
    private int generatedBytes;
    private HMac hMacHash;
    private int hashLen;
    private byte[] info;

    public HKDFBytesGenerator(Digest digest) {
        this.hMacHash = new HMac(digest);
        this.hashLen = digest.getDigestSize();
    }

    private void expandNext() throws DataLengthException {
        int i11 = this.generatedBytes;
        int i12 = this.hashLen;
        int i13 = (i11 / i12) + 1;
        if (i13 < 256) {
            if (i11 != 0) {
                this.hMacHash.update(this.currentT, 0, i12);
            }
            HMac hMac = this.hMacHash;
            byte[] bArr = this.info;
            hMac.update(bArr, 0, bArr.length);
            this.hMacHash.update((byte) i13);
            this.hMacHash.doFinal(this.currentT, 0);
            return;
        }
        throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
    }

    private KeyParameter extract(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            this.hMacHash.init(new KeyParameter(new byte[this.hashLen]));
        } else {
            this.hMacHash.init(new KeyParameter(bArr));
        }
        this.hMacHash.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.hashLen];
        this.hMacHash.doFinal(bArr3, 0);
        return new KeyParameter(bArr3);
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        int i13 = this.generatedBytes;
        int i14 = i13 + i12;
        int i15 = this.hashLen;
        if (i14 <= i15 * 255) {
            if (i13 % i15 == 0) {
                expandNext();
            }
            int i16 = this.generatedBytes;
            int i17 = this.hashLen;
            int i18 = i16 % i17;
            int min = Math.min(i17 - (i16 % i17), i12);
            System.arraycopy(this.currentT, i18, bArr, i11, min);
            this.generatedBytes += min;
            int i19 = i12 - min;
            while (true) {
                i11 += min;
                if (i19 <= 0) {
                    return i12;
                }
                expandNext();
                min = Math.min(this.hashLen, i19);
                System.arraycopy(this.currentT, 0, bArr, i11, min);
                this.generatedBytes += min;
                i19 -= min;
            }
        } else {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
    }

    public Digest getDigest() {
        return this.hMacHash.getUnderlyingDigest();
    }

    public void init(DerivationParameters derivationParameters) {
        KeyParameter keyParameter;
        HMac hMac;
        if (derivationParameters instanceof HKDFParameters) {
            HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
            if (hKDFParameters.skipExtract()) {
                hMac = this.hMacHash;
                keyParameter = new KeyParameter(hKDFParameters.getIKM());
            } else {
                hMac = this.hMacHash;
                keyParameter = extract(hKDFParameters.getSalt(), hKDFParameters.getIKM());
            }
            hMac.init(keyParameter);
            this.info = hKDFParameters.getInfo();
            this.generatedBytes = 0;
            this.currentT = new byte[this.hashLen];
            return;
        }
        throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
    }
}
