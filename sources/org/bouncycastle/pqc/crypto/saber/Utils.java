package org.bouncycastle.pqc.crypto.saber;

import com.google.common.base.Ascii;
import okio.Utf8;

class Utils {
    private final int SABER_EP;
    private final int SABER_ET;
    private final int SABER_KEYBYTES;
    private final int SABER_L;
    private final int SABER_N;
    private final int SABER_POLYBYTES;

    public Utils(SABEREngine sABEREngine) {
        this.SABER_N = sABEREngine.getSABER_N();
        this.SABER_L = sABEREngine.getSABER_L();
        this.SABER_ET = sABEREngine.getSABER_ET();
        this.SABER_POLYBYTES = sABEREngine.getSABER_POLYBYTES();
        this.SABER_EP = sABEREngine.getSABER_EP();
        this.SABER_KEYBYTES = sABEREngine.getSABER_KEYBYTES();
    }

    private void BS2POLq(byte[] bArr, int i11, short[] sArr) {
        for (short s11 = 0; s11 < this.SABER_N / 8; s11 = (short) (s11 + 1)) {
            short s12 = (short) (s11 * 8);
            int i12 = ((short) (s11 * 13)) + i11;
            int i13 = i12 + 1;
            sArr[s12 + 0] = (short) ((bArr[i12 + 0] & 255) | ((bArr[i13] & Ascii.US) << 8));
            int i14 = ((bArr[i13] >> 5) & 7) | ((bArr[i12 + 2] & 255) << 3);
            int i15 = i12 + 3;
            sArr[s12 + 1] = (short) (i14 | ((bArr[i15] & 3) << 11));
            int i16 = i12 + 4;
            sArr[s12 + 2] = (short) (((bArr[i15] >> 2) & 63) | ((bArr[i16] & Ascii.DEL) << 6));
            int i17 = ((bArr[i16] >> 7) & 1) | ((bArr[i12 + 5] & 255) << 1);
            int i18 = i12 + 6;
            sArr[s12 + 3] = (short) (i17 | ((bArr[i18] & 15) << 9));
            int i19 = ((bArr[i18] >> 4) & 15) | ((bArr[i12 + 7] & 255) << 4);
            int i21 = i12 + 8;
            sArr[s12 + 4] = (short) (i19 | ((bArr[i21] & 1) << 12));
            int i22 = i12 + 9;
            sArr[s12 + 5] = (short) (((bArr[i21] >> 1) & 127) | ((bArr[i22] & Utf8.REPLACEMENT_BYTE) << 7));
            int i23 = ((bArr[i22] >> 6) & 3) | ((bArr[i12 + 10] & 255) << 2);
            int i24 = i12 + 11;
            sArr[s12 + 6] = (short) (i23 | ((bArr[i24] & 7) << 10));
            sArr[s12 + 7] = (short) (((bArr[i12 + 12] & 255) << 5) | ((bArr[i24] >> 3) & 31));
        }
    }

    private void POLp2BS(byte[] bArr, int i11, short[] sArr) {
        for (short s11 = 0; s11 < this.SABER_N / 4; s11 = (short) (s11 + 1)) {
            short s12 = (short) (s11 * 4);
            int i12 = ((short) (s11 * 5)) + i11;
            int i13 = s12 + 0;
            bArr[i12 + 0] = (byte) (sArr[i13] & 255);
            int i14 = s12 + 1;
            bArr[i12 + 1] = (byte) (((sArr[i13] >> 8) & 3) | ((sArr[i14] & 63) << 2));
            int i15 = s12 + 2;
            bArr[i12 + 2] = (byte) (((sArr[i14] >> 6) & 15) | ((sArr[i15] & 15) << 4));
            int i16 = s12 + 3;
            bArr[i12 + 3] = (byte) (((sArr[i15] >> 4) & 63) | ((sArr[i16] & 3) << 6));
            bArr[i12 + 4] = (byte) ((sArr[i16] >> 2) & 255);
        }
    }

    private void POLq2BS(byte[] bArr, int i11, short[] sArr) {
        for (short s11 = 0; s11 < this.SABER_N / 8; s11 = (short) (s11 + 1)) {
            short s12 = (short) (s11 * 8);
            int i12 = ((short) (s11 * 13)) + i11;
            int i13 = s12 + 0;
            bArr[i12 + 0] = (byte) (sArr[i13] & 255);
            int i14 = s12 + 1;
            bArr[i12 + 1] = (byte) (((sArr[i13] >> 8) & 31) | ((sArr[i14] & 7) << 5));
            bArr[i12 + 2] = (byte) ((sArr[i14] >> 3) & 255);
            int i15 = s12 + 2;
            bArr[i12 + 3] = (byte) (((sArr[i14] >> 11) & 3) | ((sArr[i15] & 63) << 2));
            int i16 = s12 + 3;
            bArr[i12 + 4] = (byte) (((sArr[i15] >> 6) & 127) | ((sArr[i16] & 1) << 7));
            bArr[i12 + 5] = (byte) ((sArr[i16] >> 1) & 255);
            int i17 = s12 + 4;
            bArr[i12 + 6] = (byte) (((sArr[i16] >> 9) & 15) | ((sArr[i17] & 15) << 4));
            bArr[i12 + 7] = (byte) ((sArr[i17] >> 4) & 255);
            int i18 = s12 + 5;
            bArr[i12 + 8] = (byte) (((sArr[i17] >> 12) & 1) | ((sArr[i18] & 127) << 1));
            int i19 = s12 + 6;
            bArr[i12 + 9] = (byte) (((sArr[i18] >> 7) & 63) | ((sArr[i19] & 3) << 6));
            bArr[i12 + 10] = (byte) ((sArr[i19] >> 2) & 255);
            int i21 = s12 + 7;
            bArr[i12 + 11] = (byte) (((sArr[i19] >> 10) & 7) | ((sArr[i21] & 31) << 3));
            bArr[i12 + 12] = (byte) ((sArr[i21] >> 5) & 255);
        }
    }

    public void BS2POLT(byte[] bArr, int i11, short[] sArr) {
        int i12 = this.SABER_ET;
        short s11 = 0;
        if (i12 == 3) {
            while (s11 < this.SABER_N / 8) {
                short s12 = (short) (s11 * 8);
                int i13 = ((short) (s11 * 3)) + i11;
                int i14 = i13 + 0;
                sArr[s12 + 0] = (short) (bArr[i14] & 7);
                sArr[s12 + 1] = (short) ((bArr[i14] >> 3) & 7);
                int i15 = i13 + 1;
                sArr[s12 + 2] = (short) (((bArr[i14] >> 6) & 3) | ((bArr[i15] & 1) << 2));
                sArr[s12 + 3] = (short) ((bArr[i15] >> 1) & 7);
                sArr[s12 + 4] = (short) ((bArr[i15] >> 4) & 7);
                int i16 = i13 + 2;
                sArr[s12 + 5] = (short) (((bArr[i15] >> 7) & 1) | ((bArr[i16] & 3) << 1));
                sArr[s12 + 6] = (short) ((bArr[i16] >> 2) & 7);
                sArr[s12 + 7] = (short) ((bArr[i16] >> 5) & 7);
                s11 = (short) (s11 + 1);
            }
        } else if (i12 == 4) {
            while (s11 < this.SABER_N / 2) {
                short s13 = (short) (s11 * 2);
                int i17 = i11 + s11;
                sArr[s13] = (short) (bArr[i17] & 15);
                sArr[s13 + 1] = (short) ((bArr[i17] >> 4) & 15);
                s11 = (short) (s11 + 1);
            }
        } else if (i12 == 6) {
            while (s11 < this.SABER_N / 4) {
                short s14 = (short) (s11 * 4);
                int i18 = ((short) (s11 * 3)) + i11;
                int i19 = i18 + 0;
                sArr[s14 + 0] = (short) (bArr[i19] & Utf8.REPLACEMENT_BYTE);
                int i21 = i18 + 1;
                sArr[s14 + 1] = (short) (((bArr[i19] >> 6) & 3) | ((bArr[i21] & 15) << 2));
                int i22 = i18 + 2;
                sArr[s14 + 2] = (short) (((bArr[i21] & 255) >> 4) | ((bArr[i22] & 3) << 4));
                sArr[s14 + 3] = (short) ((bArr[i22] & 255) >> 2);
                s11 = (short) (s11 + 1);
            }
        }
    }

    public void BS2POLVECp(byte[] bArr, short[][] sArr) {
        for (byte b11 = 0; b11 < this.SABER_L; b11 = (byte) (b11 + 1)) {
            BS2POLp(bArr, ((this.SABER_EP * this.SABER_N) / 8) * b11, sArr[b11]);
        }
    }

    public void BS2POLVECq(byte[] bArr, int i11, short[][] sArr) {
        for (byte b11 = 0; b11 < this.SABER_L; b11 = (byte) (b11 + 1)) {
            BS2POLq(bArr, (this.SABER_POLYBYTES * b11) + i11, sArr[b11]);
        }
    }

    public void BS2POLmsg(byte[] bArr, short[] sArr) {
        for (byte b11 = 0; b11 < this.SABER_KEYBYTES; b11 = (byte) (b11 + 1)) {
            for (byte b12 = 0; b12 < 8; b12 = (byte) (b12 + 1)) {
                sArr[(b11 * 8) + b12] = (short) ((bArr[b11] >> b12) & 1);
            }
        }
    }

    public void BS2POLp(byte[] bArr, int i11, short[] sArr) {
        for (short s11 = 0; s11 < this.SABER_N / 4; s11 = (short) (s11 + 1)) {
            short s12 = (short) (s11 * 4);
            int i12 = ((short) (s11 * 5)) + i11;
            int i13 = i12 + 1;
            sArr[s12 + 0] = (short) ((bArr[i12 + 0] & 255) | ((bArr[i13] & 3) << 8));
            int i14 = i12 + 2;
            sArr[s12 + 1] = (short) (((bArr[i13] >> 2) & 63) | ((bArr[i14] & 15) << 6));
            int i15 = i12 + 3;
            sArr[s12 + 2] = (short) (((bArr[i14] >> 4) & 15) | ((bArr[i15] & Utf8.REPLACEMENT_BYTE) << 4));
            sArr[s12 + 3] = (short) (((bArr[i12 + 4] & 255) << 2) | ((bArr[i15] >> 6) & 3));
        }
    }

    public void POLT2BS(byte[] bArr, int i11, short[] sArr) {
        int i12 = this.SABER_ET;
        short s11 = 0;
        if (i12 == 3) {
            while (s11 < this.SABER_N / 8) {
                short s12 = (short) (s11 * 8);
                int i13 = ((short) (s11 * 3)) + i11;
                int i14 = s12 + 2;
                bArr[i13 + 0] = (byte) ((sArr[s12 + 0] & 7) | ((sArr[s12 + 1] & 7) << 3) | ((sArr[i14] & 3) << 6));
                int i15 = ((sArr[i14] >> 2) & 1) | ((sArr[s12 + 3] & 7) << 1) | ((sArr[s12 + 4] & 7) << 4);
                int i16 = s12 + 5;
                bArr[i13 + 1] = (byte) (i15 | ((sArr[i16] & 1) << 7));
                bArr[i13 + 2] = (byte) (((sArr[s12 + 7] & 7) << 5) | ((sArr[i16] >> 1) & 3) | ((sArr[s12 + 6] & 7) << 2));
                s11 = (short) (s11 + 1);
            }
        } else if (i12 == 4) {
            while (s11 < this.SABER_N / 2) {
                short s13 = (short) (s11 * 2);
                bArr[i11 + s11] = (byte) (((sArr[s13 + 1] & 15) << 4) | (sArr[s13] & 15));
                s11 = (short) (s11 + 1);
            }
        } else if (i12 == 6) {
            while (s11 < this.SABER_N / 4) {
                short s14 = (short) (s11 * 4);
                int i17 = ((short) (s11 * 3)) + i11;
                int i18 = s14 + 1;
                bArr[i17 + 0] = (byte) ((sArr[s14 + 0] & 63) | ((sArr[i18] & 3) << 6));
                int i19 = s14 + 2;
                bArr[i17 + 1] = (byte) (((sArr[i18] >> 2) & 15) | ((sArr[i19] & 15) << 4));
                bArr[i17 + 2] = (byte) (((sArr[s14 + 3] & 63) << 2) | ((sArr[i19] >> 4) & 3));
                s11 = (short) (s11 + 1);
            }
        }
    }

    public void POLVECp2BS(byte[] bArr, short[][] sArr) {
        for (byte b11 = 0; b11 < this.SABER_L; b11 = (byte) (b11 + 1)) {
            POLp2BS(bArr, ((this.SABER_EP * this.SABER_N) / 8) * b11, sArr[b11]);
        }
    }

    public void POLVECq2BS(byte[] bArr, short[][] sArr) {
        for (byte b11 = 0; b11 < this.SABER_L; b11 = (byte) (b11 + 1)) {
            POLq2BS(bArr, this.SABER_POLYBYTES * b11, sArr[b11]);
        }
    }

    public void POLmsg2BS(byte[] bArr, short[] sArr) {
        for (byte b11 = 0; b11 < this.SABER_KEYBYTES; b11 = (byte) (b11 + 1)) {
            for (byte b12 = 0; b12 < 8; b12 = (byte) (b12 + 1)) {
                bArr[b11] = (byte) (bArr[b11] | ((sArr[(b11 * 8) + b12] & 1) << b12));
            }
        }
    }
}
