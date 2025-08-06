package com.google.android.exoplayer2.util;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i11, int i12, boolean z11) {
            this.picParameterSetId = i11;
            this.seqParameterSetId = i12;
            this.bottomFieldPicOrderInFramePresentFlag = z11;
        }
    }

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i11, int i12, int i13, int i14, int i15, int i16, float f11, boolean z11, boolean z12, int i17, int i18, int i19, boolean z13) {
            this.profileIdc = i11;
            this.constraintsFlagsAndReservedZero2Bits = i12;
            this.levelIdc = i13;
            this.seqParameterSetId = i14;
            this.width = i15;
            this.height = i16;
            this.pixelWidthAspectRatio = f11;
            this.separateColorPlaneFlag = z11;
            this.frameMbsOnlyFlag = z12;
            this.frameNumLength = i17;
            this.picOrderCountType = i18;
            this.picOrderCntLsbLength = i19;
            this.deltaPicOrderAlwaysZeroFlag = z13;
        }
    }

    private NalUnitUtil() {
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1;
            if (i13 < position) {
                byte b11 = byteBuffer.get(i11) & 255;
                if (i12 == 3) {
                    if (b11 == 1 && (byteBuffer.get(i13) & Ascii.US) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i11 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b11 == 0) {
                    i12++;
                }
                if (b11 != 0) {
                    i12 = 0;
                }
                i11 = i13;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int findNalUnit(byte[] bArr, int i11, int i12, boolean[] zArr) {
        boolean z11;
        int i13 = i12 - i11;
        boolean z12 = false;
        Assertions.checkState(i13 >= 0);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i11 - 3;
        } else if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            clearPrefixFlags(zArr);
            return i11 - 2;
        } else if (i13 <= 2 || !zArr[2] || bArr[i11] != 0 || bArr[i11 + 1] != 1) {
            int i14 = i12 - 1;
            int i15 = i11 + 2;
            while (i15 < i14) {
                if ((bArr[i15] & 254) == 0) {
                    int i16 = i15 - 2;
                    if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && bArr[i15] == 1) {
                        clearPrefixFlags(zArr);
                        return i16;
                    }
                    i15 -= 2;
                }
                i15 += 3;
            }
            if (i13 <= 2 ? i13 != 2 ? !zArr[1] || bArr[i14] != 1 : !(zArr[2] && bArr[i12 - 2] == 0 && bArr[i14] == 1) : !(bArr[i12 - 3] == 0 && bArr[i12 - 2] == 0 && bArr[i14] == 1)) {
                z11 = false;
            } else {
                z11 = true;
            }
            zArr[0] = z11;
            zArr[1] = i13 <= 1 ? !(!zArr[2] || bArr[i14] != 0) : bArr[i12 + -2] == 0 && bArr[i14] == 0;
            if (bArr[i14] == 0) {
                z12 = true;
            }
            zArr[2] = z12;
            return i12;
        } else {
            clearPrefixFlags(zArr);
            return i11 - 1;
        }
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int getH265NalUnitType(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i11) {
        return bArr[i11 + 3] & Ascii.US;
    }

    public static boolean isNalUnitSei(String str, byte b11) {
        if ("video/avc".equals(str) && (b11 & Ascii.US) == 6) {
            return true;
        }
        if (!"video/hevc".equals(str) || ((b11 & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i11, int i12) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i11, i12);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r21, int r22, int r23) {
        /*
            com.google.android.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r21
            r2 = r22
            r3 = r23
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.skipBits(r1)
            int r3 = r0.readBits(r1)
            int r4 = r0.readBits(r1)
            int r5 = r0.readBits(r1)
            int r6 = r0.readUnsignedExpGolombCodedInt()
            r2 = 3
            r9 = 1
            r10 = 100
            if (r3 == r10) goto L_0x004e
            r10 = 110(0x6e, float:1.54E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 122(0x7a, float:1.71E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 244(0xf4, float:3.42E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 44
            if (r3 == r10) goto L_0x004e
            r10 = 83
            if (r3 == r10) goto L_0x004e
            r10 = 86
            if (r3 == r10) goto L_0x004e
            r10 = 118(0x76, float:1.65E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 128(0x80, float:1.794E-43)
            if (r3 == r10) goto L_0x004e
            r10 = 138(0x8a, float:1.93E-43)
            if (r3 != r10) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            r10 = r9
            r11 = 0
            goto L_0x0086
        L_0x004e:
            int r10 = r0.readUnsignedExpGolombCodedInt()
            if (r10 != r2) goto L_0x0059
            boolean r11 = r0.readBit()
            goto L_0x005a
        L_0x0059:
            r11 = 0
        L_0x005a:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            boolean r12 = r0.readBit()
            if (r12 == 0) goto L_0x0086
            if (r10 == r2) goto L_0x006d
            r12 = r1
            goto L_0x006f
        L_0x006d:
            r12 = 12
        L_0x006f:
            r13 = 0
        L_0x0070:
            if (r13 >= r12) goto L_0x0086
            boolean r14 = r0.readBit()
            if (r14 == 0) goto L_0x0083
            r14 = 6
            if (r13 >= r14) goto L_0x007e
            r14 = 16
            goto L_0x0080
        L_0x007e:
            r14 = 64
        L_0x0080:
            skipScalingList(r0, r14)
        L_0x0083:
            int r13 = r13 + 1
            goto L_0x0070
        L_0x0086:
            int r12 = r0.readUnsignedExpGolombCodedInt()
            int r12 = r12 + 4
            int r13 = r0.readUnsignedExpGolombCodedInt()
            if (r13 != 0) goto L_0x0099
            int r14 = r0.readUnsignedExpGolombCodedInt()
            int r14 = r14 + 4
            goto L_0x00ba
        L_0x0099:
            if (r13 != r9) goto L_0x00b9
            boolean r14 = r0.readBit()
            r0.readSignedExpGolombCodedInt()
            r0.readSignedExpGolombCodedInt()
            int r15 = r0.readUnsignedExpGolombCodedInt()
            long r1 = (long) r15
            r15 = 0
        L_0x00ab:
            long r7 = (long) r15
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x00b6
            r0.readUnsignedExpGolombCodedInt()
            int r15 = r15 + 1
            goto L_0x00ab
        L_0x00b6:
            r15 = r14
            r14 = 0
            goto L_0x00bb
        L_0x00b9:
            r14 = 0
        L_0x00ba:
            r15 = 0
        L_0x00bb:
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            int r1 = r0.readUnsignedExpGolombCodedInt()
            int r1 = r1 + r9
            int r2 = r0.readUnsignedExpGolombCodedInt()
            int r2 = r2 + r9
            boolean r16 = r0.readBit()
            int r7 = 2 - r16
            int r7 = r7 * r2
            if (r16 != 0) goto L_0x00d7
            r0.skipBit()
        L_0x00d7:
            r0.skipBit()
            r2 = 16
            int r1 = r1 * r2
            int r7 = r7 * r2
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x0117
            int r2 = r0.readUnsignedExpGolombCodedInt()
            int r8 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            int r18 = r0.readUnsignedExpGolombCodedInt()
            if (r10 != 0) goto L_0x00f9
            int r10 = 2 - r16
            goto L_0x010e
        L_0x00f9:
            r19 = 2
            r9 = 3
            if (r10 != r9) goto L_0x0102
            r9 = 1
            r20 = 1
            goto L_0x0105
        L_0x0102:
            r20 = r19
            r9 = 1
        L_0x0105:
            if (r10 != r9) goto L_0x0109
            r9 = r19
        L_0x0109:
            int r10 = 2 - r16
            int r10 = r10 * r9
            r9 = r20
        L_0x010e:
            int r2 = r2 + r8
            int r2 = r2 * r9
            int r1 = r1 - r2
            int r17 = r17 + r18
            int r17 = r17 * r10
            int r7 = r7 - r17
        L_0x0117:
            r8 = r7
            r7 = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x0164
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x0164
            r2 = 8
            int r2 = r0.readBits(r2)
            r9 = 255(0xff, float:3.57E-43)
            if (r2 != r9) goto L_0x0143
            r9 = 16
            int r2 = r0.readBits(r9)
            int r0 = r0.readBits(r9)
            if (r2 == 0) goto L_0x0164
            if (r0 == 0) goto L_0x0164
            float r1 = (float) r2
            float r0 = (float) r0
            float r1 = r1 / r0
            goto L_0x0164
        L_0x0143:
            float[] r0 = ASPECT_RATIO_IDC_VALUES
            int r9 = r0.length
            if (r2 >= r9) goto L_0x014c
            r0 = r0[r2]
            r9 = r0
            goto L_0x0165
        L_0x014c:
            r0 = 46
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r0)
            java.lang.String r0 = "Unexpected aspect_ratio_idc value: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r0 = r9.toString()
            java.lang.String r2 = "NalUnitUtil"
            com.google.android.exoplayer2.util.Log.w(r2, r0)
        L_0x0164:
            r9 = r1
        L_0x0165:
            com.google.android.exoplayer2.util.NalUnitUtil$SpsData r0 = new com.google.android.exoplayer2.util.NalUnitUtil$SpsData
            r2 = r0
            r10 = r11
            r11 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$SpsData");
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i11) {
        int i12 = 8;
        int i13 = 8;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != 0) {
                i12 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i13) + 256) % 256;
            }
            if (i12 != 0) {
                i13 = i12;
            }
        }
    }

    public static int unescapeStream(byte[] bArr, int i11) {
        int i12;
        synchronized (scratchEscapePositionsLock) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                try {
                    i13 = findNextUnescapeIndex(bArr, i13, i11);
                    if (i13 < i11) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i14) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i14] = i13;
                        i13 += 3;
                        i14++;
                    }
                } finally {
                }
            }
            i12 = i11 - i14;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                int i18 = scratchEscapePositions[i17] - i16;
                System.arraycopy(bArr, i16, bArr, i15, i18);
                int i19 = i15 + i18;
                int i21 = i19 + 1;
                bArr[i19] = 0;
                i15 = i21 + 1;
                bArr[i21] = 0;
                i16 += i18 + 3;
            }
            System.arraycopy(bArr, i16, bArr, i15, i12 - i15);
        }
        return i12;
    }
}
