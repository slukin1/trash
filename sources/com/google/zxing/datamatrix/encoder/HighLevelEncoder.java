package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import java.util.Arrays;

public final class HighLevelEncoder {
    public static final int ASCII_ENCODATION = 0;
    public static final int BASE256_ENCODATION = 5;
    public static final int C40_ENCODATION = 1;
    public static final char C40_UNLATCH = 'þ';
    public static final int EDIFACT_ENCODATION = 4;
    public static final char LATCH_TO_ANSIX12 = 'î';
    public static final char LATCH_TO_BASE256 = 'ç';
    public static final char LATCH_TO_C40 = 'æ';
    public static final char LATCH_TO_EDIFACT = 'ð';
    public static final char LATCH_TO_TEXT = 'ï';
    private static final char MACRO_05 = 'ì';
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = 'í';
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = '';
    public static final int TEXT_ENCODATION = 2;
    public static final char UPPER_SHIFT = 'ë';
    public static final int X12_ENCODATION = 3;
    public static final char X12_UNLATCH = 'þ';

    private HighLevelEncoder() {
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        if (i11 < length) {
            char charAt = charSequence.charAt(i11);
            while (isDigit(charAt) && i11 < length) {
                i12++;
                i11++;
                if (i11 < length) {
                    charAt = charSequence.charAt(i11);
                }
            }
        }
        return i12;
    }

    public static String encodeHighLevel(String str) {
        return encodeHighLevel(str, SymbolShapeHint.FORCE_NONE, (Dimension) null, (Dimension) null);
    }

    private static int findMinimums(float[] fArr, int[] iArr, int i11, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i12 = 0; i12 < 6; i12++) {
            iArr[i12] = (int) Math.ceil((double) fArr[i12]);
            int i13 = iArr[i12];
            if (i11 > i13) {
                Arrays.fill(bArr, (byte) 0);
                i11 = i13;
            }
            if (i11 == i13) {
                bArr[i12] = (byte) (bArr[i12] + 1);
            }
        }
        return i11;
    }

    private static int getMinimumCount(byte[] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 += bArr[i12];
        }
        return i11;
    }

    public static void illegalCharacter(char c11) {
        String hexString = Integer.toHexString(c11);
        throw new IllegalArgumentException("Illegal character: " + c11 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean isDigit(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    public static boolean isExtendedASCII(char c11) {
        return c11 >= 128 && c11 <= 255;
    }

    private static boolean isNativeC40(char c11) {
        if (c11 == ' ') {
            return true;
        }
        if (c11 < '0' || c11 > '9') {
            return c11 >= 'A' && c11 <= 'Z';
        }
        return true;
    }

    private static boolean isNativeEDIFACT(char c11) {
        return c11 >= ' ' && c11 <= '^';
    }

    private static boolean isNativeText(char c11) {
        if (c11 == ' ') {
            return true;
        }
        if (c11 < '0' || c11 > '9') {
            return c11 >= 'a' && c11 <= 'z';
        }
        return true;
    }

    private static boolean isNativeX12(char c11) {
        if (isX12TermSep(c11) || c11 == ' ') {
            return true;
        }
        if (c11 < '0' || c11 > '9') {
            return c11 >= 'A' && c11 <= 'Z';
        }
        return true;
    }

    private static boolean isSpecialB256(char c11) {
        return false;
    }

    private static boolean isX12TermSep(char c11) {
        return c11 == 13 || c11 == '*' || c11 == '>';
    }

    public static int lookAheadTest(CharSequence charSequence, int i11, int i12) {
        float[] fArr;
        char c11;
        CharSequence charSequence2 = charSequence;
        int i13 = i11;
        if (i13 >= charSequence.length()) {
            return i12;
        }
        if (i12 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i12] = 0.0f;
        }
        int i14 = 0;
        while (true) {
            int i15 = i13 + i14;
            if (i15 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int findMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                int minimumCount = getMinimumCount(bArr);
                if (iArr[0] == findMinimums) {
                    return 0;
                }
                if (minimumCount == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (minimumCount == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (minimumCount != 1 || bArr[2] <= 0) {
                    return (minimumCount != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence2.charAt(i15);
            i14++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (isExtendedASCII(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (isNativeC40(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (isNativeText(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (isNativeEDIFACT(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (isSpecialB256(charAt)) {
                c11 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c11 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i14 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                findMinimums(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int minimumCount2 = getMinimumCount(bArr2);
                if (iArr2[0] < iArr2[c11] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (minimumCount2 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (minimumCount2 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (minimumCount2 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        int i16 = i13 + i14 + 1;
                        while (i16 < charSequence.length()) {
                            char charAt2 = charSequence2.charAt(i16);
                            if (!isX12TermSep(charAt2)) {
                                if (!isNativeX12(charAt2)) {
                                    break;
                                }
                                i16++;
                            } else {
                                return 3;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static char randomize253State(char c11, int i11) {
        int i12 = c11 + ((i11 * 149) % ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR) + 1;
        if (i12 > 254) {
            i12 -= 254;
        }
        return (char) i12;
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i11 = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.setSymbolShape(symbolShapeHint);
        encoderContext.setSizeConstraints(dimension, dimension2);
        if (str.startsWith(MACRO_05_HEADER) && str.endsWith(MACRO_TRAILER)) {
            encoderContext.writeCodeword(MACRO_05);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        } else if (str.startsWith(MACRO_06_HEADER) && str.endsWith(MACRO_TRAILER)) {
            encoderContext.writeCodeword(MACRO_06);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        while (encoderContext.hasMoreCharacters()) {
            encoderArr[i11].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                i11 = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (!(codewordCount >= dataCapacity || i11 == 0 || i11 == 5 || i11 == 4)) {
            encoderContext.writeCodeword(254);
        }
        StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append(PAD);
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State(PAD, codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }
}
