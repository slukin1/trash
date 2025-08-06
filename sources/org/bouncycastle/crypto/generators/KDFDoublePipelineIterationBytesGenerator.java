package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.MacDerivationFunction;
import org.bouncycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f59195a;
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h  reason: collision with root package name */
    private final int f59196h;
    private byte[] ios;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f59197k;
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    public KDFDoublePipelineIterationBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f59196h = macSize;
        this.f59195a = new byte[macSize];
        this.f59197k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            Mac mac = this.prf;
            byte[] bArr = this.fixedInputData;
            mac.update(bArr, 0, bArr.length);
            this.prf.doFinal(this.f59195a, 0);
        } else {
            Mac mac2 = this.prf;
            byte[] bArr2 = this.f59195a;
            mac2.update(bArr2, 0, bArr2.length);
            this.prf.doFinal(this.f59195a, 0);
        }
        Mac mac3 = this.prf;
        byte[] bArr3 = this.f59195a;
        mac3.update(bArr3, 0, bArr3.length);
        if (this.useCounter) {
            int i11 = (this.generatedBytes / this.f59196h) + 1;
            byte[] bArr4 = this.ios;
            int length = bArr4.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length == 4) {
                            bArr4[0] = (byte) (i11 >>> 24);
                        } else {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                    }
                    bArr4[bArr4.length - 3] = (byte) (i11 >>> 16);
                }
                bArr4[bArr4.length - 2] = (byte) (i11 >>> 8);
            }
            bArr4[bArr4.length - 1] = (byte) i11;
            this.prf.update(bArr4, 0, bArr4.length);
        }
        Mac mac4 = this.prf;
        byte[] bArr5 = this.fixedInputData;
        mac4.update(bArr5, 0, bArr5.length);
        this.prf.doFinal(this.f59197k, 0);
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        int i13 = this.generatedBytes;
        int i14 = i13 + i12;
        if (i14 < 0 || i14 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i13 % this.f59196h == 0) {
            generateNext();
        }
        int i15 = this.generatedBytes;
        int i16 = this.f59196h;
        int i17 = i15 % i16;
        int min = Math.min(i16 - (i15 % i16), i12);
        System.arraycopy(this.f59197k, i17, bArr, i11, min);
        this.generatedBytes += min;
        int i18 = i12 - min;
        while (true) {
            i11 += min;
            if (i18 <= 0) {
                return i12;
            }
            generateNext();
            min = Math.min(this.f59196h, i18);
            System.arraycopy(this.f59197k, 0, bArr, i11, min);
            this.generatedBytes += min;
            i18 -= min;
        }
    }

    public Mac getMac() {
        return this.prf;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFDoublePipelineIterationParameters) {
            KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFDoublePipelineIterationParameters.getKI()));
            this.fixedInputData = kDFDoublePipelineIterationParameters.getFixedInputData();
            int r11 = kDFDoublePipelineIterationParameters.getR();
            this.ios = new byte[(r11 / 8)];
            int i11 = Integer.MAX_VALUE;
            if (kDFDoublePipelineIterationParameters.useCounter()) {
                BigInteger multiply = TWO.pow(r11).multiply(BigInteger.valueOf((long) this.f59196h));
                if (multiply.compareTo(INTEGER_MAX) != 1) {
                    i11 = multiply.intValue();
                }
            }
            this.maxSizeExcl = i11;
            this.useCounter = kDFDoublePipelineIterationParameters.useCounter();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}
