package com.google.android.exoplayer2.util;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class CodecSpecificDataUtil {
    private static final String[] HEVC_GENERAL_PROFILE_SPACE_STRINGS = {"", "A", "B", "C"};
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};

    private CodecSpecificDataUtil() {
    }

    public static String buildAvcCodecString(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
    }

    public static List<byte[]> buildCea708InitializationData(boolean z11) {
        return Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
    }

    public static String buildHevcCodecStringFromSps(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(24);
        int readBits = parsableNalUnitBitArray.readBits(2);
        boolean readBit = parsableNalUnitBitArray.readBit();
        int readBits2 = parsableNalUnitBitArray.readBits(5);
        int i11 = 0;
        for (int i12 = 0; i12 < 32; i12++) {
            if (parsableNalUnitBitArray.readBit()) {
                i11 |= 1 << i12;
            }
        }
        int i13 = 6;
        int[] iArr = new int[6];
        for (int i14 = 0; i14 < 6; i14++) {
            iArr[i14] = parsableNalUnitBitArray.readBits(8);
        }
        int readBits3 = parsableNalUnitBitArray.readBits(8);
        Object[] objArr = new Object[5];
        objArr[0] = HEVC_GENERAL_PROFILE_SPACE_STRINGS[readBits];
        objArr[1] = Integer.valueOf(readBits2);
        objArr[2] = Integer.valueOf(i11);
        objArr[3] = Character.valueOf(readBit ? 'H' : Matrix.MATRIX_TYPE_RANDOM_LT);
        objArr[4] = Integer.valueOf(readBits3);
        StringBuilder sb2 = new StringBuilder(Util.formatInvariant("hvc1.%s%d.%X.%c%d", objArr));
        while (i13 > 0 && iArr[i13 - 1] == 0) {
            i13--;
        }
        for (int i15 = 0; i15 < i13; i15++) {
            sb2.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i15])}));
        }
        return sb2.toString();
    }

    public static byte[] buildNalUnit(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[(bArr2.length + i12)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i11, bArr3, bArr2.length, i12);
        return bArr3;
    }

    private static int findNalStartCode(byte[] bArr, int i11) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i11 <= length) {
            if (isNalStartCode(bArr, i11)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    private static boolean isNalStartCode(byte[] bArr, int i11) {
        if (bArr.length - i11 <= NAL_START_CODE.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i12 >= bArr2.length) {
                return true;
            }
            if (bArr[i11 + i12] != bArr2[i12]) {
                return false;
            }
            i12++;
        }
    }

    public static Pair<Integer, Integer> parseAlacAudioSpecificConfig(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.setPosition(9);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(readUnsignedByte));
    }

    public static boolean parseCea708InitializationData(List<byte[]> list) {
        if (list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1) {
            return true;
        }
        return false;
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        do {
            arrayList.add(Integer.valueOf(i11));
            i11 = findNalStartCode(bArr, i11 + NAL_START_CODE.length);
        } while (i11 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i12 = 0;
        while (i12 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i12)).intValue();
            int intValue2 = (i12 < arrayList.size() + -1 ? ((Integer) arrayList.get(i12 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i12] = bArr3;
            i12++;
        }
        return bArr2;
    }
}
