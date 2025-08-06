package com.google.zxing.qrcode.encoder;

import com.google.common.math.DoubleMath;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import org.jmrtd.cbeff.ISO781611;

final class MatrixUtil {
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_IGNORE_VIDEO_STREAM_IN_COMMON_AUDIO_FORMATS, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, ISO781611.SMT_DO_DS}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, DoubleMath.MAX_FACTORIAL}};
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;

    private MatrixUtil() {
    }

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i11, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i11, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i11, byteMatrix);
    }

    public static int calculateBCHCode(int i11, int i12) {
        if (i12 != 0) {
            int findMSBSet = findMSBSet(i12);
            int i13 = i11 << (findMSBSet - 1);
            while (findMSBSet(i13) >= findMSBSet) {
                i13 ^= i12 << (findMSBSet(i13) - findMSBSet);
            }
            return i13;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    public static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
            byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    public static void embedDataBits(BitArray bitArray, int i11, ByteMatrix byteMatrix) throws WriterException {
        boolean z11;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i12 = -1;
        int i13 = 0;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = width - i14;
                    if (isEmpty(byteMatrix.get(i15, height))) {
                        if (i13 < bitArray.getSize()) {
                            z11 = bitArray.get(i13);
                            i13++;
                        } else {
                            z11 = false;
                        }
                        if (i11 != -1 && MaskUtil.getDataMaskBit(i11, i15, height)) {
                            z11 = !z11;
                        }
                        byteMatrix.set(i15, height, z11);
                    }
                }
                height += i12;
            }
            i12 = -i12;
            height += i12;
            width -= 2;
        }
        if (i13 != bitArray.getSize()) {
            throw new WriterException("Not all bits consumed: " + i13 + '/' + bitArray.getSize());
        }
    }

    private static void embedHorizontalSeparationPattern(int i11, int i12, ByteMatrix byteMatrix) throws WriterException {
        int i13 = 0;
        while (i13 < 8) {
            int i14 = i11 + i13;
            if (isEmpty(byteMatrix.get(i14, i12))) {
                byteMatrix.set(i14, i12, 0);
                i13++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedPositionAdjustmentPattern(int i11, int i12, ByteMatrix byteMatrix) {
        for (int i13 = 0; i13 < 5; i13++) {
            int[] iArr = POSITION_ADJUSTMENT_PATTERN[i13];
            for (int i14 = 0; i14 < 5; i14++) {
                byteMatrix.set(i11 + i14, i12 + i13, iArr[i14]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int i11, int i12, ByteMatrix byteMatrix) {
        for (int i13 = 0; i13 < 7; i13++) {
            int[] iArr = POSITION_DETECTION_PATTERN[i13];
            for (int i14 = 0; i14 < 7; i14++) {
                byteMatrix.set(i11 + i14, i12 + i13, iArr[i14]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) {
        int i11 = 8;
        while (i11 < byteMatrix.getWidth() - 8) {
            int i12 = i11 + 1;
            int i13 = i12 % 2;
            if (isEmpty(byteMatrix.get(i11, 6))) {
                byteMatrix.set(i11, 6, i13);
            }
            if (isEmpty(byteMatrix.get(6, i11))) {
                byteMatrix.set(6, i11, i13);
            }
            i11 = i12;
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i11, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i11, bitArray);
        for (int i12 = 0; i12 < bitArray.getSize(); i12++) {
            boolean z11 = bitArray.get((bitArray.getSize() - 1) - i12);
            int[] iArr = TYPE_INFO_COORDINATES[i12];
            byteMatrix.set(iArr[0], iArr[1], z11);
            if (i12 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i12) - 1, 8, z11);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i12 - 8), z11);
            }
        }
    }

    private static void embedVerticalSeparationPattern(int i11, int i12, ByteMatrix byteMatrix) throws WriterException {
        int i13 = 0;
        while (i13 < 7) {
            int i14 = i12 + i13;
            if (isEmpty(byteMatrix.get(i11, i14))) {
                byteMatrix.set(i11, i14, 0);
                i13++;
            } else {
                throw new WriterException();
            }
        }
    }

    public static int findMSBSet(int i11) {
        return 32 - Integer.numberOfLeadingZeros(i11);
    }

    private static boolean isEmpty(int i11) {
        return i11 == -1;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i11, BitArray bitArray) throws WriterException {
        if (QRCode.isValidMaskPattern(i11)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i11;
            bitArray.appendBits(bits, 5);
            bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
            BitArray bitArray2 = new BitArray();
            bitArray2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
            bitArray.xor(bitArray2);
            if (bitArray.getSize() != 15) {
                throw new WriterException("should not happen but we got: " + bitArray.getSize());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void makeVersionInfoBits(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bitArray.getSize() != 18) {
            throw new WriterException("should not happen but we got: " + bitArray.getSize());
        }
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() >= 2) {
            int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
            for (int i11 : iArr) {
                if (i11 >= 0) {
                    for (int i12 : iArr) {
                        if (i12 >= 0 && isEmpty(byteMatrix.get(i12, i11))) {
                            embedPositionAdjustmentPattern(i12 - 2, i11 - 2, byteMatrix);
                        }
                    }
                }
            }
        }
    }

    public static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() >= 7) {
            BitArray bitArray = new BitArray();
            makeVersionInfoBits(version, bitArray);
            int i11 = 17;
            for (int i12 = 0; i12 < 6; i12++) {
                for (int i13 = 0; i13 < 3; i13++) {
                    boolean z11 = bitArray.get(i11);
                    i11--;
                    byteMatrix.set(i12, (byteMatrix.getHeight() - 11) + i13, z11);
                    byteMatrix.set((byteMatrix.getHeight() - 11) + i13, i12, z11);
                }
            }
        }
    }
}
