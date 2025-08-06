package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    public static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode = r0
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.AnonymousClass1.<clinit>():void");
        }
    }

    private Encoder() {
    }

    public static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte appendBits : str.getBytes(str2)) {
                bitArray.appendBits(appendBits, 8);
            }
        } catch (UnsupportedEncodingException e11) {
            throw new WriterException((Throwable) e11);
        }
    }

    public static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i11));
            if (alphanumericCode != -1) {
                int i12 = i11 + 1;
                if (i12 < length) {
                    int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i12));
                    if (alphanumericCode2 != -1) {
                        bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                        i11 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    bitArray.appendBits(alphanumericCode, 6);
                    i11 = i12;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i11 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i11 == 1) {
            appendNumericBytes(str, bitArray);
        } else if (i11 == 2) {
            appendAlphanumericBytes(str, bitArray);
        } else if (i11 == 3) {
            append8BitBytes(str, bitArray, str2);
        } else if (i11 == 4) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void appendKanjiBytes(java.lang.String r6, com.google.zxing.common.BitArray r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = r4
        L_0x0033:
            if (r2 == r4) goto L_0x0044
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.appendBits(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x0044:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.appendKanjiBytes(java.lang.String, com.google.zxing.common.BitArray):void");
    }

    public static void appendLengthInfo(int i11, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i12 = 1 << characterCountBits;
        if (i11 < i12) {
            bitArray.appendBits(i11, characterCountBits);
            return;
        }
        throw new WriterException(i11 + " is bigger than " + (i12 - 1));
    }

    public static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            int charAt = charSequence.charAt(i11) - '0';
            int i12 = i11 + 2;
            if (i12 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i11 + 1) - '0') * 10) + (charSequence.charAt(i12) - '0'), 10);
                i11 += 3;
            } else {
                i11++;
                if (i11 < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i11) - '0'), 7);
                    i11 = i12;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i11 = Integer.MAX_VALUE;
        int i12 = -1;
        for (int i13 = 0; i13 < 8; i13++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i13, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i11) {
                i12 = i13;
                i11 = calculateMaskPenalty;
            }
        }
        return i12;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, (String) null);
    }

    private static Version chooseVersion(int i11, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i12 = 1; i12 <= 40; i12++) {
            Version versionForNumber = Version.getVersionForNumber(i12);
            if (willFit(i11, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, (Map<EncodeHintType, ?>) null);
    }

    public static byte[] generateECBytes(byte[] bArr, int i11) {
        int length = bArr.length;
        int[] iArr = new int[(length + i11)];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i11);
        byte[] bArr2 = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr2[i13] = (byte) iArr[length + i13];
        }
        return bArr2;
    }

    public static int getAlphanumericCode(int i11) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i11 < iArr.length) {
            return iArr[i11];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i11, int i12, int i13, int i14, int[] iArr, int[] iArr2) throws WriterException {
        if (i14 < i13) {
            int i15 = i11 % i13;
            int i16 = i13 - i15;
            int i17 = i11 / i13;
            int i18 = i17 + 1;
            int i19 = i12 / i13;
            int i21 = i19 + 1;
            int i22 = i17 - i19;
            int i23 = i18 - i21;
            if (i22 != i23) {
                throw new WriterException("EC bytes mismatch");
            } else if (i13 != i16 + i15) {
                throw new WriterException("RS blocks mismatch");
            } else if (i11 != ((i19 + i22) * i16) + ((i21 + i23) * i15)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i14 < i16) {
                iArr[0] = i19;
                iArr2[0] = i22;
            } else {
                iArr[0] = i21;
                iArr2[0] = i23;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    public static BitArray interleaveWithECBytes(BitArray bitArray, int i11, int i12, int i13) throws WriterException {
        int i14 = i11;
        int i15 = i12;
        int i16 = i13;
        if (bitArray.getSizeInBytes() == i15) {
            ArrayList<BlockPair> arrayList = new ArrayList<>(i16);
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            for (int i21 = 0; i21 < i16; i21++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                getNumDataBytesAndNumECBytesForBlockID(i11, i12, i13, i21, iArr, iArr2);
                int i22 = iArr[0];
                byte[] bArr = new byte[i22];
                bitArray.toBytes(i17 << 3, bArr, 0, i22);
                byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
                arrayList.add(new BlockPair(bArr, generateECBytes));
                i18 = Math.max(i18, i22);
                i19 = Math.max(i19, generateECBytes.length);
                i17 += iArr[0];
            }
            if (i15 == i17) {
                BitArray bitArray2 = new BitArray();
                for (int i23 = 0; i23 < i18; i23++) {
                    for (BlockPair dataBytes : arrayList) {
                        byte[] dataBytes2 = dataBytes.getDataBytes();
                        if (i23 < dataBytes2.length) {
                            bitArray2.appendBits(dataBytes2[i23], 8);
                        }
                    }
                }
                for (int i24 = 0; i24 < i19; i24++) {
                    for (BlockPair errorCorrectionBytes : arrayList) {
                        byte[] errorCorrectionBytes2 = errorCorrectionBytes.getErrorCorrectionBytes();
                        if (i24 < errorCorrectionBytes2.length) {
                            bitArray2.appendBits(errorCorrectionBytes2[i24], 8);
                        }
                    }
                }
                if (i14 == bitArray2.getSizeInBytes()) {
                    return bitArray2;
                }
                throw new WriterException("Interleaving error: " + i14 + " and " + bitArray2.getSizeInBytes() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i11 = 0; i11 < length; i11 += 2) {
                byte b11 = bytes[i11] & 255;
                if ((b11 < 129 || b11 > 159) && (b11 < 224 || b11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void terminateBits(int i11, BitArray bitArray) throws WriterException {
        int i12 = i11 << 3;
        if (bitArray.getSize() <= i12) {
            for (int i13 = 0; i13 < 4 && bitArray.getSize() < i12; i13++) {
                bitArray.appendBit(false);
            }
            int size = bitArray.getSize() & 7;
            if (size > 0) {
                while (size < 8) {
                    bitArray.appendBit(false);
                    size++;
                }
            }
            int sizeInBytes = i11 - bitArray.getSizeInBytes();
            for (int i14 = 0; i14 < sizeInBytes; i14++) {
                bitArray.appendBits((i14 & 1) == 0 ? 236 : 17, 8);
            }
            if (bitArray.getSize() != i12) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i12);
    }

    private static boolean willFit(int i11, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i11 + 7) / 8;
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt >= '0' && charAt <= '9') {
                z12 = true;
            } else if (getAlphanumericCode(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z11 = true;
            }
        }
        if (z11) {
            return Mode.ALPHANUMERIC;
        }
        if (z12) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String r7, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r8, java.util.Map<com.google.zxing.EncodeHintType, ?> r9) throws com.google.zxing.WriterException {
        /*
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x000e
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto L_0x000e
            r2 = r0
            goto L_0x000f
        L_0x000e:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x001c
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r3 = r9.get(r3)
            java.lang.String r3 = r3.toString()
            goto L_0x001e
        L_0x001c:
            java.lang.String r3 = "ISO-8859-1"
        L_0x001e:
            com.google.zxing.qrcode.decoder.Mode r4 = chooseMode(r7, r3)
            com.google.zxing.common.BitArray r5 = new com.google.zxing.common.BitArray
            r5.<init>()
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r4 != r6) goto L_0x0036
            if (r2 == 0) goto L_0x0036
            com.google.zxing.common.CharacterSetECI r2 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r3)
            if (r2 == 0) goto L_0x0036
            appendECI(r2, r5)
        L_0x0036:
            if (r9 == 0) goto L_0x0041
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r0 = r1
        L_0x0042:
            if (r0 == 0) goto L_0x005d
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.GS1_FORMAT
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005d
            com.google.zxing.qrcode.decoder.Mode r0 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            appendModeInfo(r0, r5)
        L_0x005d:
            appendModeInfo(r4, r5)
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            appendBytes(r7, r4, r0, r3)
            if (r9 == 0) goto L_0x0095
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r2 = r9.containsKey(r1)
            if (r2 == 0) goto L_0x0095
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = r9.toString()
            int r9 = java.lang.Integer.parseInt(r9)
            com.google.zxing.qrcode.decoder.Version r9 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r9)
            int r1 = calculateBitsNeeded(r4, r5, r0, r9)
            boolean r1 = willFit(r1, r9, r8)
            if (r1 == 0) goto L_0x008d
            goto L_0x0099
        L_0x008d:
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            java.lang.String r8 = "Data too big for requested version"
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0095:
            com.google.zxing.qrcode.decoder.Version r9 = recommendVersion(r8, r4, r5, r0)
        L_0x0099:
            com.google.zxing.common.BitArray r1 = new com.google.zxing.common.BitArray
            r1.<init>()
            r1.appendBitArray(r5)
            if (r4 != r6) goto L_0x00a8
            int r7 = r0.getSizeInBytes()
            goto L_0x00ac
        L_0x00a8:
            int r7 = r7.length()
        L_0x00ac:
            appendLengthInfo(r7, r9, r4, r1)
            r1.appendBitArray(r0)
            com.google.zxing.qrcode.decoder.Version$ECBlocks r7 = r9.getECBlocksForLevel(r8)
            int r0 = r9.getTotalCodewords()
            int r2 = r7.getTotalECCodewords()
            int r0 = r0 - r2
            terminateBits(r0, r1)
            int r2 = r9.getTotalCodewords()
            int r7 = r7.getNumBlocks()
            com.google.zxing.common.BitArray r7 = interleaveWithECBytes(r1, r2, r0, r7)
            com.google.zxing.qrcode.encoder.QRCode r0 = new com.google.zxing.qrcode.encoder.QRCode
            r0.<init>()
            r0.setECLevel(r8)
            r0.setMode(r4)
            r0.setVersion(r9)
            int r1 = r9.getDimensionForVersion()
            com.google.zxing.qrcode.encoder.ByteMatrix r2 = new com.google.zxing.qrcode.encoder.ByteMatrix
            r2.<init>(r1, r1)
            int r1 = chooseMaskPattern(r7, r8, r9, r2)
            r0.setMaskPattern(r1)
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r7, r8, r9, r1, r2)
            r0.setMatrix(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.encode(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.QRCode");
    }
}
