package org.bouncycastle.pqc.math.linearalgebra;

import android.support.v4.media.session.PlaybackStateCompat;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.sumsub.sns.prooface.network.d;
import java.math.BigInteger;
import java.security.SecureRandom;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bouncycastle.util.Arrays;

public class GF2nONBElement extends GF2nElement {
    private static final int MAXLONG = 64;
    private static final long[] mBitmask = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, DoubleUtils.IMPLICIT_BIT, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
    private static final int[] mIBY64;
    private static final long[] mMaxmask = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, WebSocketProtocol.PAYLOAD_SHORT_MAX, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647L, 4294967295L, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, d.f40278e, 562949953421311L, 1125899906842623L, 2251799813685247L, DoubleUtils.SIGNIFICAND_MASK, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, 4611686018427387903L, Long.MAX_VALUE, -1};
    private int mBit;
    private int mLength;
    private long[] mPol;

    static {
        int[] iArr = new int[b.f34945b];
        // fill-array-data instruction
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
        iArr[8] = 0;
        iArr[9] = 0;
        iArr[10] = 0;
        iArr[11] = 0;
        iArr[12] = 0;
        iArr[13] = 0;
        iArr[14] = 0;
        iArr[15] = 0;
        iArr[16] = 0;
        iArr[17] = 0;
        iArr[18] = 0;
        iArr[19] = 0;
        iArr[20] = 0;
        iArr[21] = 0;
        iArr[22] = 0;
        iArr[23] = 0;
        iArr[24] = 0;
        iArr[25] = 0;
        iArr[26] = 0;
        iArr[27] = 0;
        iArr[28] = 0;
        iArr[29] = 0;
        iArr[30] = 0;
        iArr[31] = 0;
        iArr[32] = 0;
        iArr[33] = 0;
        iArr[34] = 0;
        iArr[35] = 0;
        iArr[36] = 0;
        iArr[37] = 0;
        iArr[38] = 0;
        iArr[39] = 0;
        iArr[40] = 0;
        iArr[41] = 0;
        iArr[42] = 0;
        iArr[43] = 0;
        iArr[44] = 0;
        iArr[45] = 0;
        iArr[46] = 0;
        iArr[47] = 0;
        iArr[48] = 0;
        iArr[49] = 0;
        iArr[50] = 0;
        iArr[51] = 0;
        iArr[52] = 0;
        iArr[53] = 0;
        iArr[54] = 0;
        iArr[55] = 0;
        iArr[56] = 0;
        iArr[57] = 0;
        iArr[58] = 0;
        iArr[59] = 0;
        iArr[60] = 0;
        iArr[61] = 0;
        iArr[62] = 0;
        iArr[63] = 0;
        iArr[64] = 1;
        iArr[65] = 1;
        iArr[66] = 1;
        iArr[67] = 1;
        iArr[68] = 1;
        iArr[69] = 1;
        iArr[70] = 1;
        iArr[71] = 1;
        iArr[72] = 1;
        iArr[73] = 1;
        iArr[74] = 1;
        iArr[75] = 1;
        iArr[76] = 1;
        iArr[77] = 1;
        iArr[78] = 1;
        iArr[79] = 1;
        iArr[80] = 1;
        iArr[81] = 1;
        iArr[82] = 1;
        iArr[83] = 1;
        iArr[84] = 1;
        iArr[85] = 1;
        iArr[86] = 1;
        iArr[87] = 1;
        iArr[88] = 1;
        iArr[89] = 1;
        iArr[90] = 1;
        iArr[91] = 1;
        iArr[92] = 1;
        iArr[93] = 1;
        iArr[94] = 1;
        iArr[95] = 1;
        iArr[96] = 1;
        iArr[97] = 1;
        iArr[98] = 1;
        iArr[99] = 1;
        iArr[100] = 1;
        iArr[101] = 1;
        iArr[102] = 1;
        iArr[103] = 1;
        iArr[104] = 1;
        iArr[105] = 1;
        iArr[106] = 1;
        iArr[107] = 1;
        iArr[108] = 1;
        iArr[109] = 1;
        iArr[110] = 1;
        iArr[111] = 1;
        iArr[112] = 1;
        iArr[113] = 1;
        iArr[114] = 1;
        iArr[115] = 1;
        iArr[116] = 1;
        iArr[117] = 1;
        iArr[118] = 1;
        iArr[119] = 1;
        iArr[120] = 1;
        iArr[121] = 1;
        iArr[122] = 1;
        iArr[123] = 1;
        iArr[124] = 1;
        iArr[125] = 1;
        iArr[126] = 1;
        iArr[127] = 1;
        iArr[128] = 2;
        iArr[129] = 2;
        iArr[130] = 2;
        iArr[131] = 2;
        iArr[132] = 2;
        iArr[133] = 2;
        iArr[134] = 2;
        iArr[135] = 2;
        iArr[136] = 2;
        iArr[137] = 2;
        iArr[138] = 2;
        iArr[139] = 2;
        iArr[140] = 2;
        iArr[141] = 2;
        iArr[142] = 2;
        iArr[143] = 2;
        iArr[144] = 2;
        iArr[145] = 2;
        iArr[146] = 2;
        iArr[147] = 2;
        iArr[148] = 2;
        iArr[149] = 2;
        iArr[150] = 2;
        iArr[151] = 2;
        iArr[152] = 2;
        iArr[153] = 2;
        iArr[154] = 2;
        iArr[155] = 2;
        iArr[156] = 2;
        iArr[157] = 2;
        iArr[158] = 2;
        iArr[159] = 2;
        iArr[160] = 2;
        iArr[161] = 2;
        iArr[162] = 2;
        iArr[163] = 2;
        iArr[164] = 2;
        iArr[165] = 2;
        iArr[166] = 2;
        iArr[167] = 2;
        iArr[168] = 2;
        iArr[169] = 2;
        iArr[170] = 2;
        iArr[171] = 2;
        iArr[172] = 2;
        iArr[173] = 2;
        iArr[174] = 2;
        iArr[175] = 2;
        iArr[176] = 2;
        iArr[177] = 2;
        iArr[178] = 2;
        iArr[179] = 2;
        iArr[180] = 2;
        iArr[181] = 2;
        iArr[182] = 2;
        iArr[183] = 2;
        iArr[184] = 2;
        iArr[185] = 2;
        iArr[186] = 2;
        iArr[187] = 2;
        iArr[188] = 2;
        iArr[189] = 2;
        iArr[190] = 2;
        iArr[191] = 2;
        iArr[192] = 3;
        iArr[193] = 3;
        iArr[194] = 3;
        iArr[195] = 3;
        iArr[196] = 3;
        iArr[197] = 3;
        iArr[198] = 3;
        iArr[199] = 3;
        iArr[200] = 3;
        iArr[201] = 3;
        iArr[202] = 3;
        iArr[203] = 3;
        iArr[204] = 3;
        iArr[205] = 3;
        iArr[206] = 3;
        iArr[207] = 3;
        iArr[208] = 3;
        iArr[209] = 3;
        iArr[210] = 3;
        iArr[211] = 3;
        iArr[212] = 3;
        iArr[213] = 3;
        iArr[214] = 3;
        iArr[215] = 3;
        iArr[216] = 3;
        iArr[217] = 3;
        iArr[218] = 3;
        iArr[219] = 3;
        iArr[220] = 3;
        iArr[221] = 3;
        iArr[222] = 3;
        iArr[223] = 3;
        iArr[224] = 3;
        iArr[225] = 3;
        iArr[226] = 3;
        iArr[227] = 3;
        iArr[228] = 3;
        iArr[229] = 3;
        iArr[230] = 3;
        iArr[231] = 3;
        iArr[232] = 3;
        iArr[233] = 3;
        iArr[234] = 3;
        iArr[235] = 3;
        iArr[236] = 3;
        iArr[237] = 3;
        iArr[238] = 3;
        iArr[239] = 3;
        iArr[240] = 3;
        iArr[241] = 3;
        iArr[242] = 3;
        iArr[243] = 3;
        iArr[244] = 3;
        iArr[245] = 3;
        iArr[246] = 3;
        iArr[247] = 3;
        iArr[248] = 3;
        iArr[249] = 3;
        iArr[250] = 3;
        iArr[251] = 3;
        iArr[252] = 3;
        iArr[253] = 3;
        iArr[254] = 3;
        iArr[255] = 3;
        iArr[256] = 4;
        iArr[257] = 4;
        iArr[258] = 4;
        iArr[259] = 4;
        iArr[260] = 4;
        iArr[261] = 4;
        iArr[262] = 4;
        iArr[263] = 4;
        iArr[264] = 4;
        iArr[265] = 4;
        iArr[266] = 4;
        iArr[267] = 4;
        iArr[268] = 4;
        iArr[269] = 4;
        iArr[270] = 4;
        iArr[271] = 4;
        iArr[272] = 4;
        iArr[273] = 4;
        iArr[274] = 4;
        iArr[275] = 4;
        iArr[276] = 4;
        iArr[277] = 4;
        iArr[278] = 4;
        iArr[279] = 4;
        iArr[280] = 4;
        iArr[281] = 4;
        iArr[282] = 4;
        iArr[283] = 4;
        iArr[284] = 4;
        iArr[285] = 4;
        iArr[286] = 4;
        iArr[287] = 4;
        iArr[288] = 4;
        iArr[289] = 4;
        iArr[290] = 4;
        iArr[291] = 4;
        iArr[292] = 4;
        iArr[293] = 4;
        iArr[294] = 4;
        iArr[295] = 4;
        iArr[296] = 4;
        iArr[297] = 4;
        iArr[298] = 4;
        iArr[299] = 4;
        iArr[300] = 4;
        iArr[301] = 4;
        iArr[302] = 4;
        iArr[303] = 4;
        iArr[304] = 4;
        iArr[305] = 4;
        iArr[306] = 4;
        iArr[307] = 4;
        iArr[308] = 4;
        iArr[309] = 4;
        iArr[310] = 4;
        iArr[311] = 4;
        iArr[312] = 4;
        iArr[313] = 4;
        iArr[314] = 4;
        iArr[315] = 4;
        iArr[316] = 4;
        iArr[317] = 4;
        iArr[318] = 4;
        iArr[319] = 4;
        iArr[320] = 5;
        iArr[321] = 5;
        iArr[322] = 5;
        iArr[323] = 5;
        iArr[324] = 5;
        iArr[325] = 5;
        iArr[326] = 5;
        iArr[327] = 5;
        iArr[328] = 5;
        iArr[329] = 5;
        iArr[330] = 5;
        iArr[331] = 5;
        iArr[332] = 5;
        iArr[333] = 5;
        iArr[334] = 5;
        iArr[335] = 5;
        iArr[336] = 5;
        iArr[337] = 5;
        iArr[338] = 5;
        iArr[339] = 5;
        iArr[340] = 5;
        iArr[341] = 5;
        iArr[342] = 5;
        iArr[343] = 5;
        iArr[344] = 5;
        iArr[345] = 5;
        iArr[346] = 5;
        iArr[347] = 5;
        iArr[348] = 5;
        iArr[349] = 5;
        iArr[350] = 5;
        iArr[351] = 5;
        iArr[352] = 5;
        iArr[353] = 5;
        iArr[354] = 5;
        iArr[355] = 5;
        iArr[356] = 5;
        iArr[357] = 5;
        iArr[358] = 5;
        iArr[359] = 5;
        iArr[360] = 5;
        iArr[361] = 5;
        iArr[362] = 5;
        iArr[363] = 5;
        iArr[364] = 5;
        iArr[365] = 5;
        iArr[366] = 5;
        iArr[367] = 5;
        iArr[368] = 5;
        iArr[369] = 5;
        iArr[370] = 5;
        iArr[371] = 5;
        iArr[372] = 5;
        iArr[373] = 5;
        iArr[374] = 5;
        iArr[375] = 5;
        iArr[376] = 5;
        iArr[377] = 5;
        iArr[378] = 5;
        iArr[379] = 5;
        iArr[380] = 5;
        iArr[381] = 5;
        iArr[382] = 5;
        iArr[383] = 5;
        mIBY64 = iArr;
    }

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        GF2nField gF2nField = gF2nONBElement.mField;
        this.mField = gF2nField;
        this.mDegree = gF2nField.getDegree();
        this.mLength = ((GF2nONBField) this.mField).getONBLength();
        this.mBit = ((GF2nONBField) this.mField).getONBBit();
        this.mPol = new long[this.mLength];
        assign(gF2nONBElement.getElement());
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, BigInteger bigInteger) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bigInteger);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, SecureRandom secureRandom) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        int i11 = this.mLength;
        long[] jArr = new long[i11];
        this.mPol = jArr;
        if (i11 > 1) {
            for (int i12 = 0; i12 < this.mLength - 1; i12++) {
                this.mPol[i12] = secureRandom.nextLong();
            }
            this.mPol[this.mLength - 1] = secureRandom.nextLong() >>> (64 - this.mBit);
            return;
        }
        jArr[0] = secureRandom.nextLong();
        long[] jArr2 = this.mPol;
        jArr2[0] = jArr2[0] >>> (64 - this.mBit);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, byte[] bArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bArr);
    }

    private GF2nONBElement(GF2nONBField gF2nONBField, long[] jArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = jArr;
    }

    public static GF2nONBElement ONE(GF2nONBField gF2nONBField) {
        int oNBLength = gF2nONBField.getONBLength();
        long[] jArr = new long[oNBLength];
        int i11 = 0;
        while (true) {
            int i12 = oNBLength - 1;
            if (i11 < i12) {
                jArr[i11] = -1;
                i11++;
            } else {
                jArr[i12] = mMaxmask[gF2nONBField.getONBBit() - 1];
                return new GF2nONBElement(gF2nONBField, jArr);
            }
        }
    }

    public static GF2nONBElement ZERO(GF2nONBField gF2nONBField) {
        return new GF2nONBElement(gF2nONBField, new long[gF2nONBField.getONBLength()]);
    }

    private void assign(BigInteger bigInteger) {
        assign(bigInteger.toByteArray());
    }

    private void assign(byte[] bArr) {
        this.mPol = new long[this.mLength];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            long[] jArr = this.mPol;
            int i12 = i11 >>> 3;
            jArr[i12] = jArr[i12] | ((((long) bArr[(bArr.length - 1) - i11]) & 255) << ((i11 & 7) << 3));
        }
    }

    private void assign(long[] jArr) {
        System.arraycopy(jArr, 0, this.mPol, 0, this.mLength);
    }

    private long[] getElement() {
        long[] jArr = this.mPol;
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    private long[] getElementReverseOrder() {
        long[] jArr = new long[this.mPol.length];
        int i11 = 0;
        while (true) {
            int i12 = this.mDegree;
            if (i11 >= i12) {
                return jArr;
            }
            if (testBit((i12 - i11) - 1)) {
                int i13 = i11 >>> 6;
                jArr[i13] = jArr[i13] | mBitmask[i11 & 63];
            }
            i11++;
        }
    }

    public GFElement add(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.addToThis(gFElement);
        return gF2nONBElement;
    }

    public void addToThis(GFElement gFElement) throws RuntimeException {
        if (gFElement instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
            if (this.mField.equals(gF2nONBElement.mField)) {
                for (int i11 = 0; i11 < this.mLength; i11++) {
                    long[] jArr = this.mPol;
                    jArr[i11] = jArr[i11] ^ gF2nONBElement.mPol[i11];
                }
                return;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    public void assignOne() {
        int i11 = 0;
        while (true) {
            int i12 = this.mLength;
            if (i11 < i12 - 1) {
                this.mPol[i11] = -1;
                i11++;
            } else {
                this.mPol[i12 - 1] = mMaxmask[this.mBit - 1];
                return;
            }
        }
    }

    public void assignZero() {
        this.mPol = new long[this.mLength];
    }

    public Object clone() {
        return new GF2nONBElement(this);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nONBElement)) {
            return false;
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
        for (int i11 = 0; i11 < this.mLength; i11++) {
            if (this.mPol[i11] != gF2nONBElement.mPol[i11]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mPol);
    }

    public GF2nElement increase() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.increaseThis();
        return gF2nONBElement;
    }

    public void increaseThis() {
        addToThis(ONE((GF2nONBField) this.mField));
    }

    public GFElement invert() throws ArithmeticException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.invertThis();
        return gF2nONBElement;
    }

    public void invertThis() throws ArithmeticException {
        if (!isZero()) {
            int i11 = 31;
            boolean z11 = false;
            while (!z11 && i11 >= 0) {
                if ((((long) (this.mDegree - 1)) & mBitmask[i11]) != 0) {
                    z11 = true;
                }
                i11--;
            }
            ZERO((GF2nONBField) this.mField);
            GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
            int i12 = 1;
            for (int i13 = (i11 + 1) - 1; i13 >= 0; i13--) {
                GF2nElement gF2nElement = (GF2nElement) gF2nONBElement.clone();
                for (int i14 = 1; i14 <= i12; i14++) {
                    gF2nElement.squareThis();
                }
                gF2nONBElement.multiplyThisBy(gF2nElement);
                i12 <<= 1;
                if ((((long) (this.mDegree - 1)) & mBitmask[i13]) != 0) {
                    gF2nONBElement.squareThis();
                    gF2nONBElement.multiplyThisBy(this);
                    i12++;
                }
            }
            gF2nONBElement.squareThis();
            return;
        }
        throw new ArithmeticException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isOne() {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            r2 = r0
            r3 = r1
        L_0x0004:
            int r4 = r8.mLength
            int r5 = r4 + -1
            if (r2 >= r5) goto L_0x0020
            if (r3 == 0) goto L_0x0020
            if (r3 == 0) goto L_0x001c
            long[] r3 = r8.mPol
            r4 = r3[r2]
            r6 = -1
            long r3 = r4 & r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x001c
            r3 = r1
            goto L_0x001d
        L_0x001c:
            r3 = r0
        L_0x001d:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0020:
            if (r3 == 0) goto L_0x003b
            if (r3 == 0) goto L_0x003a
            long[] r2 = r8.mPol
            int r4 = r4 - r1
            r3 = r2[r4]
            long[] r2 = mMaxmask
            int r5 = r8.mBit
            int r6 = r5 + -1
            r6 = r2[r6]
            long r3 = r3 & r6
            int r5 = r5 - r1
            r5 = r2[r5]
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x003a
            r0 = r1
        L_0x003a:
            r3 = r0
        L_0x003b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.math.linearalgebra.GF2nONBElement.isOne():boolean");
    }

    public boolean isZero() {
        boolean z11 = true;
        for (int i11 = 0; i11 < this.mLength && z11; i11++) {
            z11 = z11 && (this.mPol[i11] & -1) == 0;
        }
        return z11;
    }

    public GFElement multiply(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.multiplyThisBy(gFElement);
        return gF2nONBElement;
    }

    public void multiplyThisBy(GFElement gFElement) throws RuntimeException {
        boolean z11;
        int i11;
        char c11;
        GFElement gFElement2 = gFElement;
        if (gFElement2 instanceof GF2nONBElement) {
            GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement2;
            if (!this.mField.equals(gF2nONBElement.mField)) {
                throw new RuntimeException();
            } else if (equals(gFElement)) {
                squareThis();
            } else {
                long[] jArr = this.mPol;
                long[] jArr2 = gF2nONBElement.mPol;
                int i12 = this.mLength;
                long[] jArr3 = new long[i12];
                int[][] iArr = ((GF2nONBField) this.mField).mMult;
                int i13 = i12 - 1;
                long[] jArr4 = mBitmask;
                char c12 = '?';
                long j11 = jArr4[63];
                long j12 = jArr4[this.mBit - 1];
                int i14 = 0;
                int i15 = 0;
                while (i15 < this.mDegree) {
                    int i16 = i14;
                    int i17 = i16;
                    while (i16 < this.mDegree) {
                        int[] iArr2 = mIBY64;
                        int i18 = iArr2[i16];
                        int i19 = iArr2[iArr[i16][i14]];
                        int i21 = iArr[i16][i14] & 63;
                        long j13 = jArr[i18];
                        long[] jArr5 = mBitmask;
                        if ((j13 & jArr5[i16 & 63]) != 0) {
                            if ((jArr2[i19] & jArr5[i21]) != 0) {
                                i17 ^= 1;
                            }
                            if (iArr[i16][1] != -1) {
                                c11 = '?';
                                if ((jArr2[iArr2[iArr[i16][1]]] & jArr5[iArr[i16][1] & 63]) != 0) {
                                    i17 ^= 1;
                                }
                            } else {
                                c11 = '?';
                            }
                        } else {
                            c11 = c12;
                        }
                        i16++;
                        c12 = c11;
                        i14 = 0;
                    }
                    char c13 = c12;
                    int i22 = mIBY64[i15];
                    int i23 = i15 & 63;
                    if (i17 != 0) {
                        jArr3[i22] = jArr3[i22] ^ mBitmask[i23];
                    }
                    if (this.mLength > 1) {
                        boolean z12 = (jArr[i13] & 1) == 1;
                        int i24 = i13 - 1;
                        int i25 = i24;
                        while (i25 >= 0) {
                            boolean z13 = (jArr[i25] & 1) != 0;
                            jArr[i25] = jArr[i25] >>> 1;
                            if (z12) {
                                jArr[i25] = jArr[i25] ^ j11;
                            }
                            i25--;
                            z12 = z13;
                        }
                        jArr[i13] = jArr[i13] >>> 1;
                        if (z12) {
                            jArr[i13] = jArr[i13] ^ j12;
                        }
                        boolean z14 = (jArr2[i13] & 1) == 1;
                        while (i24 >= 0) {
                            boolean z15 = (jArr2[i24] & 1) != 0;
                            jArr2[i24] = jArr2[i24] >>> 1;
                            if (z14) {
                                jArr2[i24] = jArr2[i24] ^ j11;
                            }
                            i24--;
                            z14 = z15;
                        }
                        jArr2[i13] = jArr2[i13] >>> 1;
                        if (z14) {
                            jArr2[i13] = jArr2[i13] ^ j12;
                        }
                        i11 = 0;
                        z11 = true;
                    } else {
                        i11 = 0;
                        boolean z16 = (jArr[0] & 1) == 1;
                        jArr[0] = jArr[0] >>> 1;
                        if (z16) {
                            jArr[0] = jArr[0] ^ j12;
                        }
                        boolean z17 = (jArr2[0] & 1) == 1;
                        z11 = true;
                        jArr2[0] = jArr2[0] >>> 1;
                        if (z17) {
                            jArr2[0] = jArr2[0] ^ j12;
                        }
                    }
                    i15++;
                    char c14 = c13;
                    i14 = i11;
                    boolean z18 = z11;
                    c12 = c14;
                }
                assign(jArr3);
            }
        } else {
            throw new RuntimeException("The elements have different representation: not yet implemented");
        }
    }

    public void reverseOrder() {
        this.mPol = getElementReverseOrder();
    }

    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        int i11;
        int i12 = 1;
        if (trace() != 1) {
            long j11 = mBitmask[63];
            long[] jArr = new long[this.mLength];
            int i13 = 0;
            long j12 = 0;
            while (true) {
                i11 = this.mLength;
                if (i13 >= i11 - 1) {
                    break;
                }
                for (int i14 = i12; i14 < 64; i14++) {
                    long[] jArr2 = mBitmask;
                    long j13 = jArr2[i14];
                    long[] jArr3 = this.mPol;
                    if (((j13 & jArr3[i13]) == 0 || (jArr2[i14 - 1] & j12) == 0) && !((jArr3[i13] & jArr2[i14]) == 0 && (jArr2[i14 - 1] & j12) == 0)) {
                        j12 ^= jArr2[i14];
                    }
                }
                jArr[i13] = j12;
                int i15 = ((j12 & j11) > 0 ? 1 : ((j12 & j11) == 0 ? 0 : -1));
                j12 = ((i15 == 0 || (1 & this.mPol[i13 + 1]) != 1) && !(i15 == 0 && (this.mPol[i13 + 1] & 1) == 0)) ? 1 : 0;
                i13++;
                i12 = 1;
            }
            int i16 = this.mDegree & 63;
            long j14 = this.mPol[i11 - 1];
            for (int i17 = 1; i17 < i16; i17++) {
                long[] jArr4 = mBitmask;
                if (((jArr4[i17] & j14) == 0 || (jArr4[i17 - 1] & j12) == 0) && !((jArr4[i17] & j14) == 0 && (jArr4[i17 - 1] & j12) == 0)) {
                    j12 ^= jArr4[i17];
                }
            }
            jArr[this.mLength - 1] = j12;
            return new GF2nONBElement((GF2nONBField) this.mField, jArr);
        }
        throw new RuntimeException();
    }

    public GF2nElement square() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareThis();
        return gF2nONBElement;
    }

    public GF2nElement squareRoot() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareRootThis();
        return gF2nONBElement;
    }

    public void squareRootThis() {
        long[] element = getElement();
        int i11 = this.mLength - 1;
        int i12 = this.mBit - 1;
        long j11 = mBitmask[63];
        boolean z11 = (element[0] & 1) != 0;
        int i13 = i11;
        while (i13 >= 0) {
            boolean z12 = (element[i13] & 1) != 0;
            element[i13] = element[i13] >>> 1;
            if (z11) {
                if (i13 == i11) {
                    element[i13] = element[i13] ^ mBitmask[i12];
                } else {
                    element[i13] = element[i13] ^ j11;
                }
            }
            i13--;
            z11 = z12;
        }
        assign(element);
    }

    public void squareThis() {
        long[] element = getElement();
        int i11 = this.mLength - 1;
        int i12 = this.mBit - 1;
        long[] jArr = mBitmask;
        long j11 = jArr[63];
        boolean z11 = false;
        boolean z12 = (element[i11] & jArr[i12]) != 0;
        int i13 = 0;
        while (i13 < i11) {
            boolean z13 = (element[i13] & j11) != 0;
            element[i13] = element[i13] << 1;
            if (z12) {
                element[i13] = 1 ^ element[i13];
            }
            i13++;
            z12 = z13;
        }
        long j12 = element[i11];
        long[] jArr2 = mBitmask;
        if ((j12 & jArr2[i12]) != 0) {
            z11 = true;
        }
        element[i11] = element[i11] << 1;
        if (z12) {
            element[i11] = element[i11] ^ 1;
        }
        if (z11) {
            element[i11] = jArr2[i12 + 1] ^ element[i11];
        }
        assign(element);
    }

    public boolean testBit(int i11) {
        return i11 >= 0 && i11 <= this.mDegree && (this.mPol[i11 >>> 6] & mBitmask[i11 & 63]) != 0;
    }

    public boolean testRightmostBit() {
        return (this.mPol[this.mLength - 1] & mBitmask[this.mBit - 1]) != 0;
    }

    public byte[] toByteArray() {
        int i11 = ((this.mDegree - 1) >> 3) + 1;
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = (i12 & 7) << 3;
            bArr[(i11 - i12) - 1] = (byte) ((int) ((this.mPol[i12 >>> 3] & (255 << i13)) >>> i13));
        }
        return bArr;
    }

    public BigInteger toFlexiBigInt() {
        return new BigInteger(1, toByteArray());
    }

    public String toString() {
        return toString(16);
    }

    public String toString(int i11) {
        StringBuilder sb2;
        String str;
        long[] element = getElement();
        int i12 = this.mBit;
        String str2 = "";
        if (i11 == 2) {
            while (true) {
                i12--;
                if (i12 < 0) {
                    break;
                }
                if ((element[element.length - 1] & (1 << i12)) == 0) {
                    str = str2 + "0";
                } else {
                    str = str2 + "1";
                }
                str2 = str;
            }
            for (int length = element.length - 2; length >= 0; length--) {
                for (int i13 = 63; i13 >= 0; i13--) {
                    if ((element[length] & mBitmask[i13]) == 0) {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append("0");
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append("1");
                    }
                    str2 = sb2.toString();
                }
            }
        } else if (i11 == 16) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int length2 = element.length - 1; length2 >= 0; length2--) {
                str2 = ((((((((((((((((str2 + cArr[((int) (element[length2] >>> 60)) & 15]) + cArr[((int) (element[length2] >>> 56)) & 15]) + cArr[((int) (element[length2] >>> 52)) & 15]) + cArr[((int) (element[length2] >>> 48)) & 15]) + cArr[((int) (element[length2] >>> 44)) & 15]) + cArr[((int) (element[length2] >>> 40)) & 15]) + cArr[((int) (element[length2] >>> 36)) & 15]) + cArr[((int) (element[length2] >>> 32)) & 15]) + cArr[((int) (element[length2] >>> 28)) & 15]) + cArr[((int) (element[length2] >>> 24)) & 15]) + cArr[((int) (element[length2] >>> 20)) & 15]) + cArr[((int) (element[length2] >>> 16)) & 15]) + cArr[((int) (element[length2] >>> 12)) & 15]) + cArr[((int) (element[length2] >>> 8)) & 15]) + cArr[((int) (element[length2] >>> 4)) & 15]) + cArr[((int) element[length2]) & 15]) + " ";
            }
        }
        return str2;
    }

    public int trace() {
        int i11 = this.mLength - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            for (int i14 = 0; i14 < 64; i14++) {
                if ((this.mPol[i13] & mBitmask[i14]) != 0) {
                    i12 ^= 1;
                }
            }
        }
        int i15 = this.mBit;
        for (int i16 = 0; i16 < i15; i16++) {
            if ((this.mPol[i11] & mBitmask[i16]) != 0) {
                i12 ^= 1;
            }
        }
        return i12;
    }
}
