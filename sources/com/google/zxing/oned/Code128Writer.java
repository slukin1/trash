package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i11, int i12) {
        CType findCType;
        CType findCType2;
        char charAt;
        CType findCType3 = findCType(charSequence, i11);
        CType cType = CType.ONE_DIGIT;
        if (findCType3 == cType) {
            return 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (findCType3 == cType2) {
            if (i11 >= charSequence.length() || ((charAt = charSequence.charAt(i11)) >= ' ' && (i12 != 101 || charAt >= '`'))) {
                return 100;
            }
            return 101;
        } else if (i12 == 99) {
            return 99;
        } else {
            if (i12 == 100) {
                CType cType3 = CType.FNC_1;
                if (findCType3 == cType3 || (findCType = findCType(charSequence, i11 + 2)) == cType2 || findCType == cType) {
                    return 100;
                }
                if (findCType != cType3) {
                    int i13 = i11 + 4;
                    while (true) {
                        findCType2 = findCType(charSequence, i13);
                        if (findCType2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i13 += 2;
                    }
                    if (findCType2 == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (findCType(charSequence, i11 + 3) == CType.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            } else {
                if (findCType3 == CType.FNC_1) {
                    findCType3 = findCType(charSequence, i11 + 1);
                }
                if (findCType3 == CType.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            }
        }
    }

    private static CType findCType(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        if (i11 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i11);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i12 = i11 + 1;
        if (i12 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i12);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i11, i12, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        while (true) {
            int i17 = 103;
            if (i13 < length) {
                int chooseCode = chooseCode(str, i13, i15);
                int i18 = 100;
                if (chooseCode == i15) {
                    switch (str.charAt(i13)) {
                        case 241:
                            i18 = 102;
                            break;
                        case 242:
                            i18 = 97;
                            break;
                        case 243:
                            i18 = 96;
                            break;
                        case TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE:
                            if (i15 == 101) {
                                i18 = 101;
                                break;
                            }
                            break;
                        default:
                            if (i15 != 100) {
                                if (i15 == 101) {
                                    i18 = str.charAt(i13) - ' ';
                                    if (i18 < 0) {
                                        i18 += 96;
                                        break;
                                    }
                                } else {
                                    i18 = Integer.parseInt(str.substring(i13, i13 + 2));
                                    i13++;
                                    break;
                                }
                            } else {
                                i18 = str.charAt(i13) - ' ';
                                break;
                            }
                            break;
                    }
                    i13++;
                } else {
                    if (i15 != 0) {
                        i17 = chooseCode;
                    } else if (chooseCode == 100) {
                        i17 = 104;
                    } else if (chooseCode != 101) {
                        i17 = 105;
                    }
                    i18 = i17;
                    i15 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i18]);
                i14 += i18 * i16;
                if (i13 != 0) {
                    i16++;
                }
            } else {
                int[][] iArr = Code128Reader.CODE_PATTERNS;
                arrayList.add(iArr[i14 % 103]);
                arrayList.add(iArr[106]);
                int i19 = 0;
                for (int[] iArr2 : arrayList) {
                    for (int i21 : (int[]) r13.next()) {
                        i19 += i21;
                    }
                }
                boolean[] zArr = new boolean[i19];
                for (int[] appendPattern : arrayList) {
                    i11 += OneDimensionalCodeWriter.appendPattern(zArr, i11, appendPattern, true);
                }
                return zArr;
            }
        }
    }
}
