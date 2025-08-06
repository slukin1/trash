package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader {
    public static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};
    public static final int[][] L_AND_G_PATTERNS;
    public static final int[][] L_PATTERNS;
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    public static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    public static final int[] START_END_PATTERN = {1, 1, 1};
    private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20][];
        L_AND_G_PATTERNS = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i11 = 10; i11 < 20; i11++) {
            int[] iArr3 = L_PATTERNS[i11 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i12 = 0; i12 < iArr3.length; i12++) {
                iArr4[i12] = iArr3[(iArr3.length - i12) - 1];
            }
            L_AND_G_PATTERNS[i11] = iArr4;
        }
    }

    public static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i11 = length - 1;
        return getStandardUPCEANChecksum(charSequence.subSequence(0, i11)) == Character.digit(charSequence.charAt(i11), 10);
    }

    public static int decodeDigit(BitArray bitArray, int[] iArr, int i11, int[][] iArr2) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i11, iArr);
        int length = iArr2.length;
        float f11 = MAX_AVG_VARIANCE;
        int i12 = -1;
        for (int i13 = 0; i13 < length; i13++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i13], 0.7f);
            if (patternMatchVariance < f11) {
                i12 = i13;
                f11 = patternMatchVariance;
            }
        }
        if (i12 >= 0) {
            return i12;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] findGuardPattern(BitArray bitArray, int i11, boolean z11, int[] iArr) throws NotFoundException {
        return findGuardPattern(bitArray, i11, z11, iArr, new int[iArr.length]);
    }

    public static int[] findStartGuardPattern(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int[] iArr2 = null;
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            int[] iArr3 = START_END_PATTERN;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = findGuardPattern(bitArray, i11, false, iArr3, iArr);
            int i12 = iArr2[0];
            int i13 = iArr2[1];
            int i14 = i12 - (i13 - i12);
            if (i14 >= 0) {
                z11 = bitArray.isRange(i14, i12, false);
            }
            i11 = i13;
        }
        return iArr2;
    }

    public static int getStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i11 = 0;
        for (int i12 = length - 1; i12 >= 0; i12 -= 2) {
            int charAt = charSequence.charAt(i12) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i11 += charAt;
        }
        int i13 = i11 * 3;
        for (int i14 = length - 2; i14 >= 0; i14 -= 2) {
            int charAt2 = charSequence.charAt(i14) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i13 += charAt2;
        }
        return (1000 - i13) % 10;
    }

    public boolean checkChecksum(String str) throws FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    public int[] decodeEnd(BitArray bitArray, int i11) throws NotFoundException {
        return findGuardPattern(bitArray, i11, false, START_END_PATTERN);
    }

    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb2) throws NotFoundException;

    public Result decodeRow(int i11, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return decodeRow(i11, bitArray, findStartGuardPattern(bitArray), map);
    }

    public abstract BarcodeFormat getBarcodeFormat();

    private static int[] findGuardPattern(BitArray bitArray, int i11, boolean z11, int[] iArr, int[] iArr2) throws NotFoundException {
        int size = bitArray.getSize();
        int nextUnset = z11 ? bitArray.getNextUnset(i11) : bitArray.getNextSet(i11);
        int length = iArr.length;
        boolean z12 = z11;
        int i12 = 0;
        int i13 = nextUnset;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) != z12) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.7f) < MAX_AVG_VARIANCE) {
                    return new int[]{i13, nextUnset};
                } else {
                    i13 += iArr2[0] + iArr2[1];
                    int i14 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z12 = !z12;
            }
            nextUnset++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i11, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPointCallback resultPointCallback;
        int i12;
        String lookupCountryIdentifier;
        int[] iArr2 = null;
        if (map == null) {
            resultPointCallback = null;
        } else {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        boolean z11 = true;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i11));
        }
        StringBuilder sb2 = this.decodeRowStringBuffer;
        sb2.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb2);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((float) decodeMiddle, (float) i11));
        }
        int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (decodeEnd[0] + decodeEnd[1])) / 2.0f, (float) i11));
        }
        int i13 = decodeEnd[1];
        int i14 = (i13 - decodeEnd[0]) + i13;
        if (i14 >= bitArray.getSize() || !bitArray.isRange(i13, i14, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String sb3 = sb2.toString();
        if (sb3.length() < 8) {
            throw FormatException.getFormatInstance();
        } else if (checkChecksum(sb3)) {
            BarcodeFormat barcodeFormat = getBarcodeFormat();
            float f11 = (float) i11;
            Result result = new Result(sb3, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (iArr[1] + iArr[0])) / 2.0f, f11), new ResultPoint(((float) (decodeEnd[1] + decodeEnd[0])) / 2.0f, f11)}, barcodeFormat);
            try {
                Result decodeRow = this.extensionReader.decodeRow(i11, bitArray, decodeEnd[1]);
                result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                result.putAllMetadata(decodeRow.getResultMetadata());
                result.addResultPoints(decodeRow.getResultPoints());
                i12 = decodeRow.getText().length();
            } catch (ReaderException unused) {
                i12 = 0;
            }
            if (map != null) {
                iArr2 = (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length) {
                        z11 = false;
                        break;
                    } else if (i12 == iArr2[i15]) {
                        break;
                    } else {
                        i15++;
                    }
                }
                if (!z11) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if ((barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) && (lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(sb3)) != null) {
                result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
            }
            return result;
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
