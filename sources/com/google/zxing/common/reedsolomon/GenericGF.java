package com.google.zxing.common.reedsolomon;

import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

public final class GenericGF {
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM = new GenericGF(19, 16, 1);
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL, 256, 0);
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final GenericGFPoly zero;

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        GenericGF genericGF2 = new GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int i11, int i12, int i13) {
        this.primitive = i11;
        this.size = i12;
        this.generatorBase = i13;
        this.expTable = new int[i12];
        this.logTable = new int[i12];
        int i14 = 1;
        for (int i15 = 0; i15 < i12; i15++) {
            this.expTable[i15] = i14;
            i14 <<= 1;
            if (i14 >= i12) {
                i14 = (i14 ^ i11) & (i12 - 1);
            }
        }
        for (int i16 = 0; i16 < i12 - 1; i16++) {
            this.logTable[this.expTable[i16]] = i16;
        }
        this.zero = new GenericGFPoly(this, new int[]{0});
        this.one = new GenericGFPoly(this, new int[]{1});
    }

    public static int addOrSubtract(int i11, int i12) {
        return i11 ^ i12;
    }

    public GenericGFPoly buildMonomial(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        } else if (i12 == 0) {
            return this.zero;
        } else {
            int[] iArr = new int[(i11 + 1)];
            iArr[0] = i12;
            return new GenericGFPoly(this, iArr);
        }
    }

    public int exp(int i11) {
        return this.expTable[i11];
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public GenericGFPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.size;
    }

    public GenericGFPoly getZero() {
        return this.zero;
    }

    public int inverse(int i11) {
        if (i11 != 0) {
            return this.expTable[(this.size - this.logTable[i11]) - 1];
        }
        throw new ArithmeticException();
    }

    public int log(int i11) {
        if (i11 != 0) {
            return this.logTable[i11];
        }
        throw new IllegalArgumentException();
    }

    public int multiply(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i11] + iArr2[i12]) % (this.size - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
