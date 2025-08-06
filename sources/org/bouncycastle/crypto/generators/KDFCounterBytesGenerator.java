package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFCounterParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* renamed from: h  reason: collision with root package name */
    private final int f59193h;
    private byte[] ios;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f59194k;
    private int maxSizeExcl;
    private final Mac prf;

    public KDFCounterBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f59193h = macSize;
        this.f59194k = new byte[macSize];
    }

    private void generateNext() {
        int i11 = (this.generatedBytes / this.f59193h) + 1;
        byte[] bArr = this.ios;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length == 4) {
                        bArr[0] = (byte) (i11 >>> 24);
                    } else {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                }
                bArr[bArr.length - 3] = (byte) (i11 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i11 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i11;
        Mac mac = this.prf;
        byte[] bArr2 = this.fixedInputDataCtrPrefix;
        mac.update(bArr2, 0, bArr2.length);
        Mac mac2 = this.prf;
        byte[] bArr3 = this.ios;
        mac2.update(bArr3, 0, bArr3.length);
        Mac mac3 = this.prf;
        byte[] bArr4 = this.fixedInputData_afterCtr;
        mac3.update(bArr4, 0, bArr4.length);
        this.prf.doFinal(this.f59194k, 0);
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        int i13 = this.generatedBytes;
        int i14 = i13 + i12;
        if (i14 < 0 || i14 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i13 % this.f59193h == 0) {
            generateNext();
        }
        int i15 = this.generatedBytes;
        int i16 = this.f59193h;
        int i17 = i15 % i16;
        int min = Math.min(i16 - (i15 % i16), i12);
        System.arraycopy(this.f59194k, i17, bArr, i11, min);
        this.generatedBytes += min;
        int i18 = i12 - min;
        while (true) {
            i11 += min;
            if (i18 <= 0) {
                return i12;
            }
            generateNext();
            min = Math.min(this.f59193h, i18);
            System.arraycopy(this.f59194k, 0, bArr, i11, min);
            this.generatedBytes += min;
            i18 -= min;
        }
    }

    public Mac getMac() {
        return this.prf;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFCounterParameters) {
            KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFCounterParameters.getKI()));
            this.fixedInputDataCtrPrefix = kDFCounterParameters.getFixedInputDataCounterPrefix();
            this.fixedInputData_afterCtr = kDFCounterParameters.getFixedInputDataCounterSuffix();
            int r11 = kDFCounterParameters.getR();
            this.ios = new byte[(r11 / 8)];
            BigInteger multiply = TWO.pow(r11).multiply(BigInteger.valueOf((long) this.f59193h));
            this.maxSizeExcl = multiply.compareTo(INTEGER_MAX) == 1 ? Integer.MAX_VALUE : multiply.intValue();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
