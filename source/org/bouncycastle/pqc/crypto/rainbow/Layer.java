package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.bouncycastle.util.Arrays;

public class Layer {
    private short[][][] coeff_alpha;
    private short[][][] coeff_beta;
    private short[] coeff_eta;
    private short[][] coeff_gamma;

    /* renamed from: oi  reason: collision with root package name */
    private int f59590oi;

    /* renamed from: vi  reason: collision with root package name */
    private int f59591vi;
    private int viNext;

    public Layer(byte b11, byte b12, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        byte b13 = b11 & 255;
        this.f59591vi = b13;
        byte b14 = b12 & 255;
        this.viNext = b14;
        this.f59590oi = b14 - b13;
        this.coeff_alpha = sArr;
        this.coeff_beta = sArr2;
        this.coeff_gamma = sArr3;
        this.coeff_eta = sArr4;
    }

    public Layer(int i11, int i12, SecureRandom secureRandom) {
        Class<short> cls = short.class;
        this.f59591vi = i11;
        this.viNext = i12;
        int i13 = i12 - i11;
        this.f59590oi = i13;
        int[] iArr = new int[3];
        iArr[2] = i11;
        iArr[1] = i13;
        iArr[0] = i13;
        this.coeff_alpha = (short[][][]) Array.newInstance(cls, iArr);
        int i14 = this.f59590oi;
        int i15 = this.f59591vi;
        int[] iArr2 = new int[3];
        iArr2[2] = i15;
        iArr2[1] = i15;
        iArr2[0] = i14;
        this.coeff_beta = (short[][][]) Array.newInstance(cls, iArr2);
        int i16 = this.f59590oi;
        int[] iArr3 = new int[2];
        iArr3[1] = this.viNext;
        iArr3[0] = i16;
        this.coeff_gamma = (short[][]) Array.newInstance(cls, iArr3);
        int i17 = this.f59590oi;
        this.coeff_eta = new short[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            for (int i19 = 0; i19 < this.f59590oi; i19++) {
                for (int i21 = 0; i21 < this.f59591vi; i21++) {
                    this.coeff_alpha[i18][i19][i21] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i22 = 0; i22 < i17; i22++) {
            for (int i23 = 0; i23 < this.f59591vi; i23++) {
                for (int i24 = 0; i24 < this.f59591vi; i24++) {
                    this.coeff_beta[i22][i23][i24] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i25 = 0; i25 < i17; i25++) {
            for (int i26 = 0; i26 < this.viNext; i26++) {
                this.coeff_gamma[i25][i26] = (short) (secureRandom.nextInt() & 255);
            }
        }
        for (int i27 = 0; i27 < i17; i27++) {
            this.coeff_eta[i27] = (short) (secureRandom.nextInt() & 255);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Layer)) {
            return false;
        }
        Layer layer = (Layer) obj;
        return this.f59591vi == layer.getVi() && this.viNext == layer.getViNext() && this.f59590oi == layer.getOi() && RainbowUtil.equals(this.coeff_alpha, layer.getCoeffAlpha()) && RainbowUtil.equals(this.coeff_beta, layer.getCoeffBeta()) && RainbowUtil.equals(this.coeff_gamma, layer.getCoeffGamma()) && RainbowUtil.equals(this.coeff_eta, layer.getCoeffEta());
    }

    public short[][][] getCoeffAlpha() {
        return this.coeff_alpha;
    }

    public short[][][] getCoeffBeta() {
        return this.coeff_beta;
    }

    public short[] getCoeffEta() {
        return this.coeff_eta;
    }

    public short[][] getCoeffGamma() {
        return this.coeff_gamma;
    }

    public int getOi() {
        return this.f59590oi;
    }

    public int getVi() {
        return this.f59591vi;
    }

    public int getViNext() {
        return this.viNext;
    }

    public int hashCode() {
        return (((((((((((this.f59591vi * 37) + this.viNext) * 37) + this.f59590oi) * 37) + Arrays.hashCode(this.coeff_alpha)) * 37) + Arrays.hashCode(this.coeff_beta)) * 37) + Arrays.hashCode(this.coeff_gamma)) * 37) + Arrays.hashCode(this.coeff_eta);
    }

    public short[][] plugInVinegars(short[] sArr) {
        int i11 = this.f59590oi;
        int[] iArr = new int[2];
        iArr[1] = i11 + 1;
        int i12 = 0;
        iArr[0] = i11;
        short[][] sArr2 = (short[][]) Array.newInstance(short.class, iArr);
        short[] sArr3 = new short[this.f59590oi];
        for (int i13 = 0; i13 < this.f59590oi; i13++) {
            for (int i14 = 0; i14 < this.f59591vi; i14++) {
                for (int i15 = 0; i15 < this.f59591vi; i15++) {
                    sArr3[i13] = GF2Field.addElem(sArr3[i13], GF2Field.multElem(GF2Field.multElem(this.coeff_beta[i13][i14][i15], sArr[i14]), sArr[i15]));
                }
            }
        }
        for (int i16 = 0; i16 < this.f59590oi; i16++) {
            for (int i17 = 0; i17 < this.f59590oi; i17++) {
                for (int i18 = 0; i18 < this.f59591vi; i18++) {
                    sArr2[i16][i17] = GF2Field.addElem(sArr2[i16][i17], GF2Field.multElem(this.coeff_alpha[i16][i17][i18], sArr[i18]));
                }
            }
        }
        for (int i19 = 0; i19 < this.f59590oi; i19++) {
            for (int i21 = 0; i21 < this.f59591vi; i21++) {
                sArr3[i19] = GF2Field.addElem(sArr3[i19], GF2Field.multElem(this.coeff_gamma[i19][i21], sArr[i21]));
            }
        }
        for (int i22 = 0; i22 < this.f59590oi; i22++) {
            for (int i23 = this.f59591vi; i23 < this.viNext; i23++) {
                short[] sArr4 = sArr2[i22];
                int i24 = this.f59591vi;
                sArr4[i23 - i24] = GF2Field.addElem(this.coeff_gamma[i22][i23], sArr2[i22][i23 - i24]);
            }
        }
        for (int i25 = 0; i25 < this.f59590oi; i25++) {
            sArr3[i25] = GF2Field.addElem(sArr3[i25], this.coeff_eta[i25]);
        }
        while (true) {
            int i26 = this.f59590oi;
            if (i12 >= i26) {
                return sArr2;
            }
            sArr2[i12][i26] = sArr3[i12];
            i12++;
        }
    }
}
