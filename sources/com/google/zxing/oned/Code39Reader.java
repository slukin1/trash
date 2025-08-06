package com.google.zxing.oned;

import com.google.common.base.Ascii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import java.util.Arrays;
import java.util.Map;

public final class Code39Reader extends OneDReader {
    public static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    public static final int ASTERISK_ENCODING = 148;
    public static final int[] CHARACTER_ENCODINGS = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, TUIMessageBean.MSG_STATUS_DELETE, 82, 7, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, 162, 138, 42};
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    public Code39Reader() {
        this(false);
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        char c11;
        int i11;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = 0;
        while (i12 < length) {
            char charAt = charSequence.charAt(i12);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i12++;
                char charAt2 = charSequence.charAt(i12);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i11 = charAt2 - ' ';
                                } else if (charAt2 == 'Z') {
                                    c11 = ':';
                                    sb2.append(c11);
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            }
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i11 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i11 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i11 = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i11 = charAt2 + 16;
                    } else if (charAt2 >= 'P' && charAt2 <= 'T') {
                        i11 = charAt2 + '+';
                    } else if (charAt2 != 'U') {
                        if (charAt2 == 'V') {
                            c11 = '@';
                        } else if (charAt2 == 'W') {
                            c11 = '`';
                        } else if (charAt2 == 'X' || charAt2 == 'Y' || charAt2 == 'Z') {
                            c11 = Ascii.MAX;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        sb2.append(c11);
                    }
                    c11 = 0;
                    sb2.append(c11);
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.getFormatInstance();
                } else {
                    i11 = charAt2 - '@';
                }
                c11 = (char) i11;
                sb2.append(c11);
            } else {
                sb2.append(charAt);
            }
            i12++;
        }
        return sb2.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        boolean z11 = false;
        int i11 = 0;
        int i12 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z11) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 != length - 1) {
                    i11++;
                } else if (toNarrowWidePattern(iArr) != 148 || !bitArray.isRange(Math.max(0, i12 - ((nextSet - i12) / 2)), i12, false)) {
                    i12 += iArr[0] + iArr[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    return new int[]{i12, nextSet};
                }
                iArr[i11] = 1;
                z11 = !z11;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i11) throws NotFoundException {
        int i12 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i12 < iArr.length) {
                if (iArr[i12] == i11) {
                    return ALPHABET_STRING.charAt(i12);
                }
                i12++;
            } else if (i11 == 148) {
                return '*';
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            int i12 = Integer.MAX_VALUE;
            for (int i13 : iArr) {
                if (i13 < i12 && i13 > i11) {
                    i12 = i13;
                }
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                int i18 = iArr[i17];
                if (i18 > i12) {
                    i15 |= 1 << ((length - 1) - i17);
                    i14++;
                    i16 += i18;
                }
            }
            if (i14 == 3) {
                for (int i19 = 0; i19 < length && i14 > 0; i19++) {
                    int i21 = iArr[i19];
                    if (i21 > i12) {
                        i14--;
                        if ((i21 << 1) >= i16) {
                            return -1;
                        }
                    }
                }
                return i15;
            } else if (i14 <= 3) {
                return -1;
            } else {
                i11 = i12;
            }
        }
    }

    public Result decodeRow(int i11, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        String str;
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.decodeRowResult;
        sb2.setLength(0);
        int[] findAsteriskPattern = findAsteriskPattern(bitArray, iArr);
        int nextSet = bitArray.getNextSet(findAsteriskPattern[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern >= 0) {
                char patternToChar = patternToChar(narrowWidePattern);
                sb2.append(patternToChar);
                int i12 = nextSet;
                for (int i13 : iArr) {
                    i12 += i13;
                }
                int nextSet2 = bitArray.getNextSet(i12);
                if (patternToChar == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i14 = 0;
                    for (int i15 : iArr) {
                        i14 += i15;
                    }
                    int i16 = (nextSet2 - nextSet) - i14;
                    if (nextSet2 == size || (i16 << 1) >= i14) {
                        if (this.usingCheckDigit) {
                            int length = sb2.length() - 1;
                            int i17 = 0;
                            for (int i18 = 0; i18 < length; i18++) {
                                i17 += ALPHABET_STRING.indexOf(this.decodeRowResult.charAt(i18));
                            }
                            if (sb2.charAt(length) == ALPHABET_STRING.charAt(i17 % 43)) {
                                sb2.setLength(length);
                            } else {
                                throw ChecksumException.getChecksumInstance();
                            }
                        }
                        if (sb2.length() != 0) {
                            if (this.extendedMode) {
                                str = decodeExtended(sb2);
                            } else {
                                str = sb2.toString();
                            }
                            float f11 = (float) i11;
                            return new Result(str, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (findAsteriskPattern[1] + findAsteriskPattern[0])) / 2.0f, f11), new ResultPoint(((float) nextSet) + (((float) i14) / 2.0f), f11)}, BarcodeFormat.CODE_39);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                nextSet = nextSet2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public Code39Reader(boolean z11) {
        this(z11, false);
    }

    public Code39Reader(boolean z11, boolean z12) {
        this.usingCheckDigit = z11;
        this.extendedMode = z12;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }
}
