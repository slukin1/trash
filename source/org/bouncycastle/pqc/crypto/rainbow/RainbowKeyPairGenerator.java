package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private short[][] A1;
    private short[][] A1inv;
    private short[][] A2;
    private short[][] A2inv;

    /* renamed from: b1  reason: collision with root package name */
    private short[] f59592b1;

    /* renamed from: b2  reason: collision with root package name */
    private short[] f59593b2;
    private boolean initialized = false;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;

    /* renamed from: sr  reason: collision with root package name */
    private SecureRandom f59594sr;

    /* renamed from: vi  reason: collision with root package name */
    private int[] f59595vi;

    private void compactPublicKey(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = ((length2 + 1) * length2) / 2;
        iArr[0] = length;
        this.pub_quadratic = (short[][]) Array.newInstance(short.class, iArr);
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = 0;
            for (int i13 = 0; i13 < length2; i13++) {
                for (int i14 = i13; i14 < length2; i14++) {
                    short[][] sArr2 = this.pub_quadratic;
                    if (i14 == i13) {
                        sArr2[i11][i12] = sArr[i11][i13][i14];
                    } else {
                        sArr2[i11][i12] = GF2Field.addElem(sArr[i11][i13][i14], sArr[i11][i14][i13]);
                    }
                    i12++;
                }
            }
        }
    }

    private void computePublicKey() {
        Class<short> cls;
        Class<short> cls2 = short.class;
        ComputeInField computeInField = new ComputeInField();
        int[] iArr = this.f59595vi;
        int i11 = 0;
        int i12 = iArr[iArr.length - 1] - iArr[0];
        int i13 = iArr[iArr.length - 1];
        int i14 = 3;
        int[] iArr2 = new int[3];
        iArr2[2] = i13;
        iArr2[1] = i13;
        iArr2[0] = i12;
        short[][][] sArr = (short[][][]) Array.newInstance(cls2, iArr2);
        int[] iArr3 = new int[2];
        iArr3[1] = i13;
        iArr3[0] = i12;
        this.pub_singular = (short[][]) Array.newInstance(cls2, iArr3);
        this.pub_scalar = new short[i12];
        short[] sArr2 = new short[i13];
        int i15 = 0;
        int i16 = 0;
        while (true) {
            Layer[] layerArr = this.layers;
            if (i15 >= layerArr.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr[i15].getCoeffAlpha();
            short[][][] coeffBeta = this.layers[i15].getCoeffBeta();
            short[][] coeffGamma = this.layers[i15].getCoeffGamma();
            short[] coeffEta = this.layers[i15].getCoeffEta();
            int length = coeffAlpha[i11].length;
            int length2 = coeffBeta[i11].length;
            while (i11 < length) {
                int i17 = 0;
                while (true) {
                    cls = cls2;
                    if (i17 >= length) {
                        break;
                    }
                    int i18 = 0;
                    while (i18 < length2) {
                        int i19 = i12;
                        int i21 = i13;
                        int i22 = i17 + length2;
                        short[] multVect = computeInField.multVect(coeffAlpha[i11][i17][i18], this.A2[i22]);
                        int i23 = i16 + i11;
                        int i24 = i15;
                        sArr[i23] = computeInField.addSquareMatrix(sArr[i23], computeInField.multVects(multVect, this.A2[i18]));
                        short[] multVect2 = computeInField.multVect(this.f59593b2[i18], multVect);
                        short[][] sArr3 = this.pub_singular;
                        sArr3[i23] = computeInField.addVect(multVect2, sArr3[i23]);
                        short[] multVect3 = computeInField.multVect(this.f59593b2[i22], computeInField.multVect(coeffAlpha[i11][i17][i18], this.A2[i18]));
                        short[][] sArr4 = this.pub_singular;
                        sArr4[i23] = computeInField.addVect(multVect3, sArr4[i23]);
                        short multElem = GF2Field.multElem(coeffAlpha[i11][i17][i18], this.f59593b2[i22]);
                        short[] sArr5 = this.pub_scalar;
                        sArr5[i23] = GF2Field.addElem(sArr5[i23], GF2Field.multElem(multElem, this.f59593b2[i18]));
                        i18++;
                        i13 = i21;
                        i12 = i19;
                        coeffAlpha = coeffAlpha;
                        i15 = i24;
                        coeffEta = coeffEta;
                    }
                    int i25 = i13;
                    int i26 = i12;
                    int i27 = i15;
                    short[][][] sArr6 = coeffAlpha;
                    short[] sArr7 = coeffEta;
                    i17++;
                    cls2 = cls;
                }
                int i28 = i13;
                int i29 = i12;
                int i30 = i15;
                short[][][] sArr8 = coeffAlpha;
                short[] sArr9 = coeffEta;
                for (int i31 = 0; i31 < length2; i31++) {
                    for (int i32 = 0; i32 < length2; i32++) {
                        short[] multVect4 = computeInField.multVect(coeffBeta[i11][i31][i32], this.A2[i31]);
                        int i33 = i16 + i11;
                        sArr[i33] = computeInField.addSquareMatrix(sArr[i33], computeInField.multVects(multVect4, this.A2[i32]));
                        short[] multVect5 = computeInField.multVect(this.f59593b2[i32], multVect4);
                        short[][] sArr10 = this.pub_singular;
                        sArr10[i33] = computeInField.addVect(multVect5, sArr10[i33]);
                        short[] multVect6 = computeInField.multVect(this.f59593b2[i31], computeInField.multVect(coeffBeta[i11][i31][i32], this.A2[i32]));
                        short[][] sArr11 = this.pub_singular;
                        sArr11[i33] = computeInField.addVect(multVect6, sArr11[i33]);
                        short multElem2 = GF2Field.multElem(coeffBeta[i11][i31][i32], this.f59593b2[i31]);
                        short[] sArr12 = this.pub_scalar;
                        sArr12[i33] = GF2Field.addElem(sArr12[i33], GF2Field.multElem(multElem2, this.f59593b2[i32]));
                    }
                }
                for (int i34 = 0; i34 < length2 + length; i34++) {
                    short[] multVect7 = computeInField.multVect(coeffGamma[i11][i34], this.A2[i34]);
                    short[][] sArr13 = this.pub_singular;
                    int i35 = i16 + i11;
                    sArr13[i35] = computeInField.addVect(multVect7, sArr13[i35]);
                    short[] sArr14 = this.pub_scalar;
                    sArr14[i35] = GF2Field.addElem(sArr14[i35], GF2Field.multElem(coeffGamma[i11][i34], this.f59593b2[i34]));
                }
                short[] sArr15 = this.pub_scalar;
                int i36 = i16 + i11;
                sArr15[i36] = GF2Field.addElem(sArr15[i36], sArr9[i11]);
                i11++;
                cls2 = cls;
                i13 = i28;
                i12 = i29;
                coeffAlpha = sArr8;
                i15 = i30;
                coeffEta = sArr9;
            }
            Class<short> cls3 = cls2;
            int i37 = i13;
            int i38 = i12;
            i16 += length;
            i15++;
            i11 = 0;
            i14 = 3;
        }
        Class<short> cls4 = cls2;
        int i39 = i13;
        int i40 = i12;
        int[] iArr4 = new int[i14];
        iArr4[2] = i39;
        iArr4[1] = i39;
        iArr4[0] = i40;
        Class<short> cls5 = cls4;
        short[][][] sArr16 = (short[][][]) Array.newInstance(cls5, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = i39;
        iArr5[0] = i40;
        short[][] sArr17 = (short[][]) Array.newInstance(cls5, iArr5);
        int i41 = i40;
        short[] sArr18 = new short[i41];
        for (int i42 = 0; i42 < i41; i42++) {
            int i43 = 0;
            while (true) {
                short[][] sArr19 = this.A1;
                if (i43 >= sArr19.length) {
                    break;
                }
                sArr16[i42] = computeInField.addSquareMatrix(sArr16[i42], computeInField.multMatrix(sArr19[i42][i43], sArr[i43]));
                sArr17[i42] = computeInField.addVect(sArr17[i42], computeInField.multVect(this.A1[i42][i43], this.pub_singular[i43]));
                sArr18[i42] = GF2Field.addElem(sArr18[i42], GF2Field.multElem(this.A1[i42][i43], this.pub_scalar[i43]));
                i43++;
            }
            sArr18[i42] = GF2Field.addElem(sArr18[i42], this.f59592b1[i42]);
        }
        this.pub_singular = sArr17;
        this.pub_scalar = sArr18;
        compactPublicKey(sArr16);
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int i11 = 0;
        while (i11 < this.numOfLayers) {
            Layer[] layerArr = this.layers;
            int[] iArr = this.f59595vi;
            int i12 = i11 + 1;
            layerArr[i11] = new Layer(iArr[i11], iArr[i12], this.f59594sr);
            i11 = i12;
        }
    }

    private void generateL1() {
        int[] iArr = this.f59595vi;
        int i11 = iArr[iArr.length - 1] - iArr[0];
        int[] iArr2 = new int[2];
        iArr2[1] = i11;
        iArr2[0] = i11;
        this.A1 = (short[][]) Array.newInstance(short.class, iArr2);
        this.A1inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A1inv == null) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < i11; i13++) {
                    this.A1[i12][i13] = (short) (this.f59594sr.nextInt() & 255);
                }
            }
            this.A1inv = computeInField.inverse(this.A1);
        }
        this.f59592b1 = new short[i11];
        for (int i14 = 0; i14 < i11; i14++) {
            this.f59592b1[i14] = (short) (this.f59594sr.nextInt() & 255);
        }
    }

    private void generateL2() {
        int[] iArr = this.f59595vi;
        int i11 = iArr[iArr.length - 1];
        int[] iArr2 = new int[2];
        iArr2[1] = i11;
        iArr2[0] = i11;
        this.A2 = (short[][]) Array.newInstance(short.class, iArr2);
        this.A2inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A2inv == null) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < i11; i13++) {
                    this.A2[i12][i13] = (short) (this.f59594sr.nextInt() & 255);
                }
            }
            this.A2inv = computeInField.inverse(this.A2);
        }
        this.f59593b2 = new short[i11];
        for (int i14 = 0; i14 < i11; i14++) {
            this.f59593b2[i14] = (short) (this.f59594sr.nextInt() & 255);
        }
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.initialized) {
            initializeDefault();
        }
        keygen();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.f59592b1, this.A2inv, this.f59593b2, this.f59595vi, this.layers);
        int[] iArr = this.f59595vi;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr[iArr.length - 1] - iArr[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.rainbowParams = rainbowKeyGenerationParameters;
        this.f59594sr = rainbowKeyGenerationParameters.getRandom();
        this.f59595vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }
}
