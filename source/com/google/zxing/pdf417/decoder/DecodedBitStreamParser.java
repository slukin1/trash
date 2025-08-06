package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_ADDRESSEE = 4;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_CHECKSUM = 6;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_NAME = 0;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_FILE_SIZE = 5;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SEGMENT_COUNT = 1;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_SENDER = 3;
    private static final int MACRO_PDF417_OPTIONAL_FIELD_TIME_STAMP = 2;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = r0
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        bigIntegerArr[1] = valueOf;
        int i11 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i11 < bigIntegerArr2.length) {
                bigIntegerArr2[i11] = bigIntegerArr2[i11 - 1].multiply(valueOf);
                i11++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i11, int[] iArr, Charset charset, int i12, StringBuilder sb2) {
        int i13;
        int i14;
        int i15;
        long j11;
        int i16;
        int i17 = i11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j12 = 900;
        int i18 = 6;
        if (i17 == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i19 = i12 + 1;
            int i21 = iArr[i12];
            boolean z11 = false;
            int i22 = 0;
            while (true) {
                long j13 = 0;
                while (i16 < iArr[0] && !z11) {
                    int i23 = i14 + 1;
                    iArr2[i14] = i15;
                    j13 = (j13 * j11) + ((long) i15);
                    int i24 = i16 + 1;
                    i21 = iArr[i16];
                    if (i21 != 928) {
                        switch (i21) {
                            case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            case BYTE_COMPACTION_MODE_LATCH /*901*/:
                            case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                                break;
                            default:
                                switch (i21) {
                                    case MACRO_PDF417_TERMINATOR /*922*/:
                                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                    case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                        break;
                                    default:
                                        if (i23 % 5 != 0 || i23 <= 0) {
                                            i15 = i21;
                                            i16 = i24;
                                            i14 = i23;
                                            j11 = 900;
                                            i18 = 6;
                                            break;
                                        } else {
                                            int i25 = 0;
                                            while (i25 < i18) {
                                                byteArrayOutputStream.write((byte) ((int) (j13 >> ((5 - i25) * 8))));
                                                i25++;
                                                i21 = i21;
                                                i18 = 6;
                                            }
                                            int i26 = i21;
                                            i19 = i24;
                                            i22 = 0;
                                            j12 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i16 = i24 - 1;
                    i15 = i21;
                    i14 = i23;
                    j11 = 900;
                    i18 = 6;
                    z11 = true;
                }
            }
            if (i16 == iArr[0] && i15 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i14] = i15;
                i14++;
            }
            for (int i27 = 0; i27 < i14; i27++) {
                byteArrayOutputStream.write((byte) iArr2[i27]);
            }
            i13 = i16;
        } else if (i17 != BYTE_COMPACTION_MODE_LATCH_6) {
            i13 = i12;
        } else {
            i13 = i12;
            boolean z12 = false;
            int i28 = 0;
            while (true) {
                long j14 = 0;
                while (i13 < iArr[0] && !z12) {
                    int i29 = i13 + 1;
                    int i30 = iArr[i13];
                    if (i30 < TEXT_COMPACTION_MODE_LATCH) {
                        i28++;
                        j14 = (j14 * 900) + ((long) i30);
                    } else {
                        if (i30 != 928) {
                            switch (i30) {
                                case TEXT_COMPACTION_MODE_LATCH /*900*/:
                                case BYTE_COMPACTION_MODE_LATCH /*901*/:
                                case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                                    break;
                                default:
                                    switch (i30) {
                                        case MACRO_PDF417_TERMINATOR /*922*/:
                                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                        case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                            break;
                                    }
                            }
                        }
                        i13 = i29 - 1;
                        z12 = true;
                        if (i28 % 5 != 0 && i28 > 0) {
                            for (int i31 = 0; i31 < 6; i31++) {
                                byteArrayOutputStream.write((byte) ((int) (j14 >> ((5 - i31) * 8))));
                            }
                            i28 = 0;
                        }
                    }
                    i13 = i29;
                    if (i28 % 5 != 0) {
                    }
                }
            }
        }
        sb2.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i13;
    }

    public static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i11;
        StringBuilder sb2 = new StringBuilder(iArr.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i12 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i13 = 2;
        while (i13 < iArr[0]) {
            if (i12 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i12) {
                    case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        i11 = textCompaction(iArr, i13, sb2);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        i11 = byteCompaction(i12, iArr, charset, i13, sb2);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                        i11 = numericCompaction(iArr, i13, sb2);
                        break;
                    default:
                        switch (i12) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                break;
                            case ECI_USER_DEFINED /*925*/:
                                i11 = i13 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /*926*/:
                                i11 = i13 + 2;
                                break;
                            case ECI_CHARSET /*927*/:
                                i11 = i13 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i13]).name());
                                break;
                            case 928:
                                i11 = decodeMacroBlock(iArr, i13, pDF417ResultMetadata);
                                break;
                            default:
                                i11 = textCompaction(iArr, i13 - 1, sb2);
                                break;
                        }
                        i11 = byteCompaction(i12, iArr, charset, i13, sb2);
                        break;
                }
            } else {
                i11 = i13 + 1;
                sb2.append((char) iArr[i13]);
            }
            if (i11 < iArr.length) {
                i13 = i11 + 1;
                i12 = iArr[i11];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb2.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb2.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    private static String decodeBase900toBase10(int[] iArr, int i11) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i12 = 0; i12 < i11; i12++) {
            bigInteger = bigInteger.add(EXP900[(i11 - i12) - 1].multiply(BigInteger.valueOf((long) iArr[i12])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int decodeMacroBlock(int[] iArr, int i11, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i11 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i12 = 0;
            while (i12 < 2) {
                iArr2[i12] = iArr[i11];
                i12++;
                i11++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb2 = new StringBuilder();
            int textCompaction = textCompaction(iArr, i11, sb2);
            pDF417ResultMetadata.setFileId(sb2.toString());
            int i13 = iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD ? textCompaction + 1 : -1;
            while (textCompaction < iArr[0]) {
                int i14 = iArr[textCompaction];
                if (i14 == MACRO_PDF417_TERMINATOR) {
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i14 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                    int i15 = textCompaction + 1;
                    switch (iArr[i15]) {
                        case 0:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i15 + 1, sb3);
                            pDF417ResultMetadata.setFileName(sb3.toString());
                            break;
                        case 1:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i15 + 1, sb4);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb4.toString()));
                            break;
                        case 2:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i15 + 1, sb5);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb5.toString()));
                            break;
                        case 3:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i15 + 1, sb6);
                            pDF417ResultMetadata.setSender(sb6.toString());
                            break;
                        case 4:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i15 + 1, sb7);
                            pDF417ResultMetadata.setAddressee(sb7.toString());
                            break;
                        case 5:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i15 + 1, sb8);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb8.toString()));
                            break;
                        case 6:
                            StringBuilder sb9 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i15 + 1, sb9);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb9.toString()));
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i13 != -1) {
                int i16 = textCompaction - i13;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i16--;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i13, i16 + i13));
            }
            return textCompaction;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c0, code lost:
        r6 = (char) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cc, code lost:
        r6 = 0;
        r11 = r2;
        r2 = r0;
        r0 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e1, code lost:
        if (r6 == 0) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e3, code lost:
        r15.append(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e6, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r1 = 0
            r2 = r0
            r3 = r1
        L_0x0005:
            if (r3 >= r14) goto L_0x00ea
            r4 = r12[r3]
            int[] r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode
            int r6 = r0.ordinal()
            r5 = r5[r6]
            r6 = 32
            r7 = 29
            r8 = 26
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            switch(r5) {
                case 1: goto L_0x00bc;
                case 2: goto L_0x009c;
                case 3: goto L_0x0071;
                case 4: goto L_0x0051;
                case 5: goto L_0x003e;
                case 6: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x00e0
        L_0x0020:
            if (r4 >= r7) goto L_0x0027
            char[] r0 = PUNCT_CHARS
            char r6 = r0[r4]
            goto L_0x0043
        L_0x0027:
            if (r4 == r7) goto L_0x003a
            if (r4 == r10) goto L_0x0036
            if (r4 == r9) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            r0 = r13[r3]
            char r0 = (char) r0
            r15.append(r0)
        L_0x0034:
            r6 = r1
            goto L_0x0043
        L_0x0036:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x003a:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x003e:
            if (r4 >= r8) goto L_0x0046
            int r4 = r4 + 65
            char r6 = (char) r4
        L_0x0043:
            r0 = r2
            goto L_0x00e1
        L_0x0046:
            if (r4 == r8) goto L_0x0043
            if (r4 == r10) goto L_0x004d
            r0 = r2
            goto L_0x00e0
        L_0x004d:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x0051:
            if (r4 >= r7) goto L_0x0059
            char[] r5 = PUNCT_CHARS
            char r6 = r5[r4]
            goto L_0x00e1
        L_0x0059:
            if (r4 == r7) goto L_0x006d
            if (r4 == r10) goto L_0x0069
            if (r4 == r9) goto L_0x0061
            goto L_0x00e0
        L_0x0061:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00e0
        L_0x0069:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x006d:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x0071:
            r5 = 25
            if (r4 >= r5) goto L_0x007b
            char[] r5 = MIXED_CHARS
            char r6 = r5[r4]
            goto L_0x00e1
        L_0x007b:
            if (r4 == r10) goto L_0x0099
            if (r4 == r9) goto L_0x0092
            switch(r4) {
                case 25: goto L_0x008f;
                case 26: goto L_0x00e1;
                case 27: goto L_0x008b;
                case 28: goto L_0x0087;
                case 29: goto L_0x0084;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x00e0
        L_0x0084:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00cc
        L_0x0087:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x008b:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00e0
        L_0x008f:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00e0
        L_0x0092:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00e0
        L_0x0099:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x009c:
            if (r4 >= r8) goto L_0x00a1
            int r4 = r4 + 97
            goto L_0x00c0
        L_0x00a1:
            if (r4 == r10) goto L_0x00b9
            if (r4 == r9) goto L_0x00b2
            switch(r4) {
                case 26: goto L_0x00e1;
                case 27: goto L_0x00af;
                case 28: goto L_0x00ac;
                case 29: goto L_0x00a9;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            goto L_0x00e0
        L_0x00a9:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00cc
        L_0x00ac:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00e0
        L_0x00af:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
            goto L_0x00cc
        L_0x00b2:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00e0
        L_0x00b9:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00e0
        L_0x00bc:
            if (r4 >= r8) goto L_0x00c2
            int r4 = r4 + 65
        L_0x00c0:
            char r6 = (char) r4
            goto L_0x00e1
        L_0x00c2:
            if (r4 == r10) goto L_0x00de
            if (r4 == r9) goto L_0x00d7
            switch(r4) {
                case 26: goto L_0x00e1;
                case 27: goto L_0x00d4;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00ca;
                default: goto L_0x00c9;
            }
        L_0x00c9:
            goto L_0x00e0
        L_0x00ca:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
        L_0x00cc:
            r6 = r1
            r11 = r2
            r2 = r0
            r0 = r11
            goto L_0x00e1
        L_0x00d1:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00e0
        L_0x00d4:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00e0
        L_0x00d7:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00e0
        L_0x00de:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x00e0:
            r6 = r1
        L_0x00e1:
            if (r6 == 0) goto L_0x00e6
            r15.append(r6)
        L_0x00e6:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int numericCompaction(int[] iArr, int i11, StringBuilder sb2) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z11 = false;
        int i12 = 0;
        while (i11 < iArr[0] && !z11) {
            int i13 = i11 + 1;
            int i14 = iArr[i11];
            if (i13 == iArr[0]) {
                z11 = true;
            }
            if (i14 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i12] = i14;
                i12++;
            } else {
                if (!(i14 == TEXT_COMPACTION_MODE_LATCH || i14 == BYTE_COMPACTION_MODE_LATCH || i14 == 928)) {
                    switch (i14) {
                        case MACRO_PDF417_TERMINATOR /*922*/:
                        case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                        case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                            break;
                    }
                }
                i13--;
                z11 = true;
            }
            if ((i12 % 15 == 0 || i14 == NUMERIC_COMPACTION_MODE_LATCH || z11) && i12 > 0) {
                sb2.append(decodeBase900toBase10(iArr2, i12));
                i12 = 0;
            }
            i11 = i13;
        }
        return i11;
    }

    private static int textCompaction(int[] iArr, int i11, StringBuilder sb2) {
        int[] iArr2 = new int[((iArr[0] - i11) << 1)];
        int[] iArr3 = new int[((iArr[0] - i11) << 1)];
        boolean z11 = false;
        int i12 = 0;
        while (i11 < iArr[0] && !z11) {
            int i13 = i11 + 1;
            int i14 = iArr[i11];
            if (i14 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i12] = i14 / 30;
                iArr2[i12 + 1] = i14 % 30;
                i12 += 2;
            } else if (i14 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i14 != 928) {
                    switch (i14) {
                        case TEXT_COMPACTION_MODE_LATCH /*900*/:
                            iArr2[i12] = TEXT_COMPACTION_MODE_LATCH;
                            i12++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                            break;
                        default:
                            switch (i14) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                    }
                }
                i11 = i13 - 1;
                z11 = true;
            } else {
                iArr2[i12] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i11 = i13 + 1;
                iArr3[i12] = iArr[i13];
                i12++;
            }
            i11 = i13;
        }
        decodeTextCompaction(iArr2, iArr3, i12, sb2);
        return i11;
    }
}
