package com.google.zxing.datamatrix.decoder;

import com.google.common.base.Ascii;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.sumsub.sns.internal.core.common.n0;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO};
    private static final char[] C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, '{', '|', '}', '~', Ascii.MAX};

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode = r0
                com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.C40_ENCODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.TEXT_ENCODE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ANSIX12_ENCODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.EDIFACT_ENCODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.BASE256_ENCODE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', n0.h.f32179b, DecodedChar.FNC1, '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        C40_SHIFT2_SET_CHARS = cArr;
        TEXT_SHIFT2_SET_CHARS = cArr;
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.common.DecoderResult decode(byte[] r8) throws com.google.zxing.FormatException {
        /*
            com.google.zxing.common.BitSource r0 = new com.google.zxing.common.BitSource
            r0.<init>(r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 0
            r2.<init>(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 1
            r3.<init>(r4)
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
        L_0x001a:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.ASCII_ENCODE
            if (r5 != r6) goto L_0x0023
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r5 = decodeAsciiSegment(r0, r1, r2)
            goto L_0x0052
        L_0x0023:
            int[] r7 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$datamatrix$decoder$DecodedBitStreamParser$Mode
            int r5 = r5.ordinal()
            r5 = r7[r5]
            if (r5 == r4) goto L_0x004e
            r7 = 2
            if (r5 == r7) goto L_0x004a
            r7 = 3
            if (r5 == r7) goto L_0x0046
            r7 = 4
            if (r5 == r7) goto L_0x0042
            r7 = 5
            if (r5 != r7) goto L_0x003d
            decodeBase256Segment(r0, r1, r3)
            goto L_0x0051
        L_0x003d:
            com.google.zxing.FormatException r8 = com.google.zxing.FormatException.getFormatInstance()
            throw r8
        L_0x0042:
            decodeEdifactSegment(r0, r1)
            goto L_0x0051
        L_0x0046:
            decodeAnsiX12Segment(r0, r1)
            goto L_0x0051
        L_0x004a:
            decodeTextSegment(r0, r1)
            goto L_0x0051
        L_0x004e:
            decodeC40Segment(r0, r1)
        L_0x0051:
            r5 = r6
        L_0x0052:
            com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$Mode r6 = com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.Mode.PAD_ENCODE
            if (r5 == r6) goto L_0x005c
            int r6 = r0.available()
            if (r6 > 0) goto L_0x001a
        L_0x005c:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0065
            r1.append(r2)
        L_0x0065:
            com.google.zxing.common.DecoderResult r0 = new com.google.zxing.common.DecoderResult
            java.lang.String r1 = r1.toString()
            boolean r2 = r3.isEmpty()
            r4 = 0
            if (r2 == 0) goto L_0x0073
            r3 = r4
        L_0x0073:
            r0.<init>(r8, r1, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.decode(byte[]):com.google.zxing.common.DecoderResult");
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb2) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i12 == 0) {
                    sb2.append(13);
                } else if (i12 == 1) {
                    sb2.append('*');
                } else if (i12 == 2) {
                    sb2.append('>');
                } else if (i12 == 3) {
                    sb2.append(' ');
                } else if (i12 < 14) {
                    sb2.append((char) (i12 + 44));
                } else if (i12 < 40) {
                    sb2.append((char) (i12 + 51));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb2, StringBuilder sb3) throws FormatException {
        boolean z11 = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            } else if (readBits <= 128) {
                if (z11) {
                    readBits += 128;
                }
                sb2.append((char) (readBits - 1));
                return Mode.ASCII_ENCODE;
            } else if (readBits == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (readBits <= 229) {
                    int i11 = readBits - 130;
                    if (i11 < 10) {
                        sb2.append('0');
                    }
                    sb2.append(i11);
                } else {
                    switch (readBits) {
                        case 230:
                            return Mode.C40_ENCODE;
                        case 231:
                            return Mode.BASE256_ENCODE;
                        case 232:
                            sb2.append(29);
                            break;
                        case 233:
                        case 234:
                        case 241:
                            break;
                        case 235:
                            z11 = true;
                            break;
                        case 236:
                            sb2.append("[)>\u001e05\u001d");
                            sb3.insert(0, "\u001e\u0004");
                            break;
                        case 237:
                            sb2.append("[)>\u001e06\u001d");
                            sb3.insert(0, "\u001e\u0004");
                            break;
                        case 238:
                            return Mode.ANSIX12_ENCODE;
                        case TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE:
                            return Mode.TEXT_ENCODE;
                        case 240:
                            return Mode.EDIFACT_ENCODE;
                        default:
                            if (!(readBits == 254 && bitSource.available() == 0)) {
                                throw FormatException.getFormatInstance();
                            }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder sb2, Collection<byte[]> collection) throws FormatException {
        int byteOffset = bitSource.getByteOffset() + 1;
        int i11 = byteOffset + 1;
        int unrandomize255State = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State >= 250) {
            unrandomize255State = ((unrandomize255State - 249) * 250) + unrandomize255State(bitSource.readBits(8), i11);
            i11++;
        }
        if (unrandomize255State >= 0) {
            byte[] bArr = new byte[unrandomize255State];
            int i12 = 0;
            while (i12 < unrandomize255State) {
                if (bitSource.available() >= 8) {
                    bArr[i12] = (byte) unrandomize255State(bitSource.readBits(8), i11);
                    i12++;
                    i11++;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb2.append(new String(bArr, "ISO8859_1"));
            } catch (UnsupportedEncodingException e11) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e11)));
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuilder sb2) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        boolean z11 = false;
        int i11 = 0;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = iArr[i12];
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            char[] cArr = C40_SHIFT2_SET_CHARS;
                            if (i13 < cArr.length) {
                                char c11 = cArr[i13];
                                if (z11) {
                                    sb2.append((char) (c11 + 128));
                                } else {
                                    sb2.append(c11);
                                }
                            } else if (i13 == 27) {
                                sb2.append(29);
                            } else if (i13 == 30) {
                                z11 = true;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i11 = 0;
                        } else if (i11 != 3) {
                            throw FormatException.getFormatInstance();
                        } else if (z11) {
                            sb2.append((char) (i13 + 224));
                        } else {
                            sb2.append((char) (i13 + 96));
                            i11 = 0;
                        }
                    } else if (z11) {
                        sb2.append((char) (i13 + 128));
                    } else {
                        sb2.append((char) i13);
                        i11 = 0;
                    }
                    z11 = false;
                    i11 = 0;
                } else if (i13 < 3) {
                    i11 = i13 + 1;
                } else {
                    char[] cArr2 = C40_BASIC_SET_CHARS;
                    if (i13 < cArr2.length) {
                        char c12 = cArr2[i13];
                        if (z11) {
                            sb2.append((char) (c12 + 128));
                            z11 = false;
                        } else {
                            sb2.append(c12);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeEdifactSegment(BitSource bitSource, StringBuilder sb2) {
        while (bitSource.available() > 16) {
            for (int i11 = 0; i11 < 4; i11++) {
                int readBits = bitSource.readBits(6);
                if (readBits == 31) {
                    int bitOffset = 8 - bitSource.getBitOffset();
                    if (bitOffset != 8) {
                        bitSource.readBits(bitOffset);
                        return;
                    }
                    return;
                }
                if ((readBits & 32) == 0) {
                    readBits |= 64;
                }
                sb2.append((char) readBits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuilder sb2) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        boolean z11 = false;
        int i11 = 0;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = iArr[i12];
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 == 2) {
                            char[] cArr = TEXT_SHIFT2_SET_CHARS;
                            if (i13 < cArr.length) {
                                char c11 = cArr[i13];
                                if (z11) {
                                    sb2.append((char) (c11 + 128));
                                } else {
                                    sb2.append(c11);
                                }
                            } else if (i13 == 27) {
                                sb2.append(29);
                            } else if (i13 == 30) {
                                z11 = true;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i11 = 0;
                        } else if (i11 == 3) {
                            char[] cArr2 = TEXT_SHIFT3_SET_CHARS;
                            if (i13 < cArr2.length) {
                                char c12 = cArr2[i13];
                                if (z11) {
                                    sb2.append((char) (c12 + 128));
                                } else {
                                    sb2.append(c12);
                                    i11 = 0;
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (z11) {
                        sb2.append((char) (i13 + 128));
                    } else {
                        sb2.append((char) i13);
                        i11 = 0;
                    }
                    z11 = false;
                    i11 = 0;
                } else if (i13 < 3) {
                    i11 = i13 + 1;
                } else {
                    char[] cArr3 = TEXT_BASIC_SET_CHARS;
                    if (i13 < cArr3.length) {
                        char c13 = cArr3[i13];
                        if (z11) {
                            sb2.append((char) (c13 + 128));
                            z11 = false;
                        } else {
                            sb2.append(c13);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i11, int i12, int[] iArr) {
        int i13 = ((i11 << 8) + i12) - 1;
        int i14 = i13 / 1600;
        iArr[0] = i14;
        int i15 = i13 - (i14 * 1600);
        int i16 = i15 / 40;
        iArr[1] = i16;
        iArr[2] = i15 - (i16 * 40);
    }

    private static int unrandomize255State(int i11, int i12) {
        int i13 = i11 - (((i12 * 149) % 255) + 1);
        return i13 >= 0 ? i13 : i13 + 256;
    }
}
