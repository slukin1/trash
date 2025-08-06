package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code39Writer extends OneDimensionalCodeWriter {
    private static void toIntArray(int i11, int[] iArr) {
        for (int i12 = 0; i12 < 9; i12++) {
            int i13 = 1;
            if (((1 << (8 - i12)) & i11) != 0) {
                i13 = 2;
            }
            iArr[i12] = i13;
        }
    }

    private static String tryToConvertToExtendedMode(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        sb2.append("%V");
                    } else if (charAt == '`') {
                        sb2.append("%W");
                    } else if (!(charAt == '-' || charAt == '.')) {
                        if (charAt <= 26) {
                            sb2.append(DecodedChar.FNC1);
                            sb2.append((char) ((charAt - 1) + 65));
                        } else if (charAt < ' ') {
                            sb2.append('%');
                            sb2.append((char) ((charAt - 27) + 65));
                        } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                            sb2.append('/');
                            sb2.append((char) ((charAt - '!') + 65));
                        } else if (charAt <= '9') {
                            sb2.append((char) ((charAt - '0') + 48));
                        } else if (charAt <= '?') {
                            sb2.append('%');
                            sb2.append((char) ((charAt - ';') + 70));
                        } else if (charAt <= 'Z') {
                            sb2.append((char) ((charAt - 'A') + 65));
                        } else if (charAt <= '_') {
                            sb2.append('%');
                            sb2.append((char) ((charAt - '[') + 75));
                        } else if (charAt <= 'z') {
                            sb2.append('+');
                            sb2.append((char) ((charAt - 'a') + 65));
                        } else if (charAt <= 127) {
                            sb2.append('%');
                            sb2.append((char) ((charAt - '{') + 80));
                        } else {
                            throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i11) + "'");
                        }
                    }
                }
                sb2.append(charAt);
            } else {
                sb2.append("%U");
            }
        }
        return sb2.toString();
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i11, i12, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(barcodeFormat)));
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i11)) < 0) {
                    str = tryToConvertToExtendedMode(str);
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i11++;
                }
            }
            int[] iArr = new int[9];
            int i12 = length + 25;
            for (int i13 = 0; i13 < length; i13++) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS[Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i13))], iArr);
                for (int i14 = 0; i14 < 9; i14++) {
                    i12 += iArr[i14];
                }
            }
            boolean[] zArr = new boolean[i12];
            toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
            int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int appendPattern2 = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, iArr2, false);
            for (int i15 = 0; i15 < length; i15++) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS[Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i15))], iArr);
                int appendPattern3 = appendPattern2 + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
                appendPattern2 = appendPattern3 + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern3, iArr2, false);
            }
            toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
            OneDimensionalCodeWriter.appendPattern(zArr, appendPattern2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
