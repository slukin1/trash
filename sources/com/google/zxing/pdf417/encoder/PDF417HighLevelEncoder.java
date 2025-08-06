package com.google.zxing.pdf417.encoder;

import com.google.common.primitives.SignedBytes;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;

final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final byte[] PUNCTUATION = new byte[128];
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 38, 13, 9, ISO7816.INS_UNBLOCK_CHV, 58, 35, Framer.STDIN_FRAME_PREFIX, 46, ISO7816.INS_CHANGE_CHV, 47, 43, 37, ISO7816.INS_PSO, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 93, 95, 96, 126, Framer.ENTER_FRAME_PREFIX, 13, 9, ISO7816.INS_UNBLOCK_CHV, 58, 10, Framer.STDIN_FRAME_PREFIX, 46, ISO7816.INS_CHANGE_CHV, 47, ISO7816.INS_MSE, 124, ISO7816.INS_PSO, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    /* renamed from: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$encoder$Compaction;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.zxing.pdf417.encoder.Compaction[] r0 = com.google.zxing.pdf417.encoder.Compaction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$pdf417$encoder$Compaction = r0
                com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.TEXT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$encoder$Compaction     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.BYTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$encoder$Compaction     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        byte[] bArr = new byte[128];
        MIXED = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            byte[] bArr2 = TEXT_MIXED_RAW;
            if (i12 >= bArr2.length) {
                break;
            }
            byte b11 = bArr2[i12];
            if (b11 > 0) {
                MIXED[b11] = (byte) i12;
            }
            i12++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr3 = TEXT_PUNCTUATION_RAW;
            if (i11 < bArr3.length) {
                byte b12 = bArr3[i11];
                if (b12 > 0) {
                    PUNCTUATION[b12] = (byte) i11;
                }
                i11++;
            } else {
                return;
            }
        }
    }

    private PDF417HighLevelEncoder() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int determineConsecutiveBinaryCount(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.google.zxing.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L_0x0009:
            if (r1 >= r0) goto L_0x0057
            char r2 = r5.charAt(r1)
            r3 = 0
        L_0x0010:
            r4 = 13
            if (r3 >= r4) goto L_0x0025
            boolean r2 = isDigit(r2)
            if (r2 == 0) goto L_0x0025
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 >= r0) goto L_0x0025
            char r2 = r5.charAt(r2)
            goto L_0x0010
        L_0x0025:
            if (r3 < r4) goto L_0x0029
            int r1 = r1 - r6
            return r1
        L_0x0029:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L_0x0036
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0036:
            com.google.zxing.WriterException r5 = new com.google.zxing.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0057:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.determineConsecutiveBinaryCount(java.lang.String, int, java.nio.charset.Charset):int");
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i11) {
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

    private static int determineConsecutiveTextCount(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = i11;
        while (i12 < length) {
            char charAt = charSequence.charAt(i12);
            int i13 = 0;
            while (i13 < 13 && isDigit(charAt) && i12 < length) {
                i13++;
                i12++;
                if (i12 < length) {
                    charAt = charSequence.charAt(i12);
                }
            }
            if (i13 < 13) {
                if (i13 <= 0) {
                    if (!isText(charSequence.charAt(i12))) {
                        break;
                    }
                    i12++;
                }
            } else {
                return (i12 - i11) - i13;
            }
        }
        return i12 - i11;
    }

    private static void encodeBinary(byte[] bArr, int i11, int i12, int i13, StringBuilder sb2) {
        int i14;
        if (i12 == 1 && i13 == 0) {
            sb2.append(913);
        } else if (i12 % 6 == 0) {
            sb2.append(924);
        } else {
            sb2.append(901);
        }
        if (i12 >= 6) {
            char[] cArr = new char[5];
            i14 = i11;
            while ((i11 + i12) - i14 >= 6) {
                long j11 = 0;
                for (int i15 = 0; i15 < 6; i15++) {
                    j11 = (j11 << 8) + ((long) (bArr[i14 + i15] & 255));
                }
                for (int i16 = 0; i16 < 5; i16++) {
                    cArr[i16] = (char) ((int) (j11 % 900));
                    j11 /= 900;
                }
                for (int i17 = 4; i17 >= 0; i17--) {
                    sb2.append(cArr[i17]);
                }
                i14 += 6;
            }
        } else {
            i14 = i11;
        }
        while (i14 < i11 + i12) {
            sb2.append((char) (bArr[i14] & 255));
            i14++;
        }
    }

    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb2 = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb2);
        }
        int length = str.length();
        int i11 = AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$encoder$Compaction[compaction.ordinal()];
        if (i11 == 1) {
            encodeText(str, 0, length, sb2, 0);
        } else if (i11 == 2) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb2);
        } else if (i11 != 3) {
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i12 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i12);
                if (determineConsecutiveDigitCount >= 13) {
                    sb2.append(902);
                    encodeNumeric(str, i12, determineConsecutiveDigitCount, sb2);
                    i12 += determineConsecutiveDigitCount;
                    i13 = 0;
                    i14 = 2;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i12);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        if (i14 != 0) {
                            sb2.append(900);
                            i13 = 0;
                            i14 = 0;
                        }
                        i13 = encodeText(str, i12, determineConsecutiveTextCount, sb2, i13);
                        i12 += determineConsecutiveTextCount;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i12, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        int i15 = determineConsecutiveBinaryCount + i12;
                        byte[] bytes2 = str.substring(i12, i15).getBytes(charset);
                        if (bytes2.length == 1 && i14 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb2);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i14, sb2);
                            i14 = 1;
                            i13 = 0;
                        }
                        i12 = i15;
                    }
                }
            }
        } else {
            sb2.append(902);
            encodeNumeric(str, 0, length, sb2);
        }
        return sb2.toString();
    }

    private static void encodeNumeric(String str, int i11, int i12, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i12 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i13 = 0;
        while (i13 < i12) {
            sb3.setLength(0);
            int min = Math.min(44, i12 - i13);
            StringBuilder sb4 = new StringBuilder("1");
            int i14 = i11 + i13;
            sb4.append(str.substring(i14, i14 + min));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i13 += min;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f6 A[EDGE_INSN: B:68:0x00f6->B:53:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0011 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = r20
            r8 = r5
        L_0x0011:
            int r9 = r17 + r8
            char r10 = r0.charAt(r9)
            r11 = 26
            r12 = 32
            r13 = 28
            r14 = 27
            r15 = 29
            if (r7 == 0) goto L_0x00bc
            if (r7 == r6) goto L_0x0083
            if (r7 == r4) goto L_0x003c
            boolean r9 = isPunctuation(r10)
            if (r9 == 0) goto L_0x0037
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x0037:
            r3.append(r15)
        L_0x003a:
            r7 = r5
            goto L_0x0011
        L_0x003c:
            boolean r11 = isMixed(r10)
            if (r11 == 0) goto L_0x004c
            byte[] r9 = MIXED
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x004c:
            boolean r11 = isAlphaUpper(r10)
            if (r11 == 0) goto L_0x0056
            r3.append(r13)
            goto L_0x003a
        L_0x0056:
            boolean r11 = isAlphaLower(r10)
            if (r11 == 0) goto L_0x0061
            r3.append(r14)
            goto L_0x00d8
        L_0x0061:
            int r9 = r9 + 1
            if (r9 >= r1) goto L_0x0076
            char r9 = r0.charAt(r9)
            boolean r9 = isPunctuation(r9)
            if (r9 == 0) goto L_0x0076
            r7 = 3
            r9 = 25
            r3.append(r9)
            goto L_0x0011
        L_0x0076:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x0083:
            boolean r9 = isAlphaLower(r10)
            if (r9 == 0) goto L_0x0096
            if (r10 != r12) goto L_0x008f
            r3.append(r11)
            goto L_0x00f2
        L_0x008f:
            int r10 = r10 + -97
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00f2
        L_0x0096:
            boolean r9 = isAlphaUpper(r10)
            if (r9 == 0) goto L_0x00a6
            r3.append(r14)
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00f2
        L_0x00a6:
            boolean r9 = isMixed(r10)
            if (r9 == 0) goto L_0x00b0
            r3.append(r13)
            goto L_0x00e4
        L_0x00b0:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x00f2
        L_0x00bc:
            boolean r9 = isAlphaUpper(r10)
            if (r9 == 0) goto L_0x00cf
            if (r10 != r12) goto L_0x00c8
            r3.append(r11)
            goto L_0x00f2
        L_0x00c8:
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x00f2
        L_0x00cf:
            boolean r9 = isAlphaLower(r10)
            if (r9 == 0) goto L_0x00db
            r3.append(r14)
        L_0x00d8:
            r7 = r6
            goto L_0x0011
        L_0x00db:
            boolean r9 = isMixed(r10)
            if (r9 == 0) goto L_0x00e7
            r3.append(r13)
        L_0x00e4:
            r7 = r4
            goto L_0x0011
        L_0x00e7:
            r3.append(r15)
            byte[] r9 = PUNCTUATION
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
        L_0x00f2:
            int r8 = r8 + 1
            if (r8 < r1) goto L_0x0011
            int r0 = r3.length()
            r1 = r5
            r8 = r1
        L_0x00fc:
            if (r1 >= r0) goto L_0x011a
            int r9 = r1 % 2
            if (r9 == 0) goto L_0x0104
            r9 = r6
            goto L_0x0105
        L_0x0104:
            r9 = r5
        L_0x0105:
            if (r9 == 0) goto L_0x0113
            int r8 = r8 * 30
            char r9 = r3.charAt(r1)
            int r8 = r8 + r9
            char r8 = (char) r8
            r2.append(r8)
            goto L_0x0117
        L_0x0113:
            char r8 = r3.charAt(r1)
        L_0x0117:
            int r1 = r1 + 1
            goto L_0x00fc
        L_0x011a:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x0124
            int r8 = r8 * 30
            int r8 = r8 + r15
            char r0 = (char) r8
            r2.append(r0)
        L_0x0124:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodingECI(int i11, StringBuilder sb2) throws WriterException {
        if (i11 >= 0 && i11 < LATCH_TO_TEXT) {
            sb2.append(927);
            sb2.append((char) i11);
        } else if (i11 < 810900) {
            sb2.append(926);
            sb2.append((char) ((i11 / LATCH_TO_TEXT) - 1));
            sb2.append((char) (i11 % LATCH_TO_TEXT));
        } else if (i11 < 811800) {
            sb2.append(925);
            sb2.append((char) (810900 - i11));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i11)));
        }
    }

    private static boolean isAlphaLower(char c11) {
        if (c11 != ' ') {
            return c11 >= 'a' && c11 <= 'z';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c11) {
        if (c11 != ' ') {
            return c11 >= 'A' && c11 <= 'Z';
        }
        return true;
    }

    private static boolean isDigit(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    private static boolean isMixed(char c11) {
        return MIXED[c11] != -1;
    }

    private static boolean isPunctuation(char c11) {
        return PUNCTUATION[c11] != -1;
    }

    private static boolean isText(char c11) {
        if (c11 == 9 || c11 == 10 || c11 == 13) {
            return true;
        }
        return c11 >= ' ' && c11 <= '~';
    }
}
