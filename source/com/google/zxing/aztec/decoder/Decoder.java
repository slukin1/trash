package com.google.zxing.aztec.decoder;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.secure.android.common.ssl.util.f;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.jumio.commons.log.LogUtils;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import e7.s;
import fv.g;
import java.util.Arrays;
import java.util.List;

public final class Decoder {
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, "8", "9", Constants.ACCEPT_TIME_SEPARATOR_SP, InstructionFileId.DOT, "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", f.f38658a, g.f22793a, "h", "i", "j", "k", "l", "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", TtmlNode.TAG_P, "q", "r", s.f70071a, "t", "u", com.sumsub.sns.internal.fingerprint.signalproviders.f.f34662a, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", TIMMentionEditText.TIM_MENTION_TAG, "\\", "^", "_", "`", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, Constants.WAVE_SEPARATOR, "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", LogUtils.NEW_LINE, ". ", ", ", l.f34627b, TopicOperation.OPERATION_PAIR_DIVIDER, "\"", "#", "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", "*", "+", Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER, InstructionFileId.DOT, "/", ":", ";", "<", ContainerUtils.KEY_VALUE_DELIMITER, ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", KvStore.N, "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", KvStore.Y, "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

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
                com.google.zxing.aztec.decoder.Decoder$Table[] r0 = com.google.zxing.aztec.decoder.Decoder.Table.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = r0
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = readByte(zArr, i11 << 3);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i11 = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i11 = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i11 = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i11 = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i11;
        if (length >= nbDatablocks) {
            int length2 = zArr.length % i11;
            int[] iArr = new int[length];
            int i12 = 0;
            while (i12 < length) {
                iArr[i12] = readCode(zArr, length2, i11);
                i12++;
                length2 += i11;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                int i13 = (1 << i11) - 1;
                int i14 = 0;
                for (int i15 = 0; i15 < nbDatablocks; i15++) {
                    int i16 = iArr[i15];
                    if (i16 == 0 || i16 == i13) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i16 == 1 || i16 == i13 - 1) {
                        i14++;
                    }
                }
                boolean[] zArr2 = new boolean[((nbDatablocks * i11) - i14)];
                int i17 = 0;
                for (int i18 = 0; i18 < nbDatablocks; i18++) {
                    int i19 = iArr[i18];
                    if (i19 == 1 || i19 == i13 - 1) {
                        Arrays.fill(zArr2, i17, (i17 + i11) - 1, i19 > 1);
                        i17 += i11 - 1;
                    } else {
                        int i21 = i11 - 1;
                        while (i21 >= 0) {
                            int i22 = i17 + 1;
                            zArr2[i17] = ((1 << i21) & i19) != 0;
                            i21--;
                            i17 = i22;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e11) {
                throw FormatException.getFormatInstance(e11);
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        BitMatrix bitMatrix2 = bitMatrix;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i11 = (isCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i11];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i12 = 2;
        if (isCompact) {
            for (int i13 = 0; i13 < i11; i13++) {
                iArr[i13] = i13;
            }
        } else {
            int i14 = i11 / 2;
            int i15 = ((i11 + 1) + (((i14 - 1) / 15) * 2)) / 2;
            for (int i16 = 0; i16 < i14; i16++) {
                int i17 = (i16 / 15) + i16;
                iArr[(i14 - i16) - 1] = (i15 - i17) - 1;
                iArr[i14 + i16] = i17 + i15 + 1;
            }
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < nbLayers) {
            int i21 = ((nbLayers - i18) << i12) + (isCompact ? 9 : 12);
            int i22 = i18 << 1;
            int i23 = (i11 - 1) - i22;
            int i24 = 0;
            while (i24 < i21) {
                int i25 = i24 << 1;
                int i26 = 0;
                while (i26 < i12) {
                    int i27 = i22 + i26;
                    int i28 = i22 + i24;
                    zArr[i19 + i25 + i26] = bitMatrix2.get(iArr[i27], iArr[i28]);
                    int i29 = iArr[i28];
                    int i30 = i23 - i26;
                    zArr[(i21 * 2) + i19 + i25 + i26] = bitMatrix2.get(i29, iArr[i30]);
                    int i31 = i23 - i24;
                    zArr[(i21 * 4) + i19 + i25 + i26] = bitMatrix2.get(iArr[i30], iArr[i31]);
                    zArr[(i21 * 6) + i19 + i25 + i26] = bitMatrix2.get(iArr[i31], iArr[i27]);
                    i26++;
                    nbLayers = nbLayers;
                    isCompact = isCompact;
                    i12 = 2;
                }
                boolean z11 = isCompact;
                int i32 = nbLayers;
                i24++;
                i12 = 2;
            }
            boolean z12 = isCompact;
            int i33 = nbLayers;
            i19 += i21 << 3;
            i18++;
            i12 = 2;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i11) {
        int i12 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i12 == 1) {
            return UPPER_TABLE[i11];
        }
        if (i12 == 2) {
            return LOWER_TABLE[i11];
        }
        if (i12 == 3) {
            return MIXED_TABLE[i11];
        }
        if (i12 == 4) {
            return PUNCT_TABLE[i11];
        }
        if (i12 == 5) {
            return DIGIT_TABLE[i11];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb2 = new StringBuilder(20);
        Table table2 = table;
        int i11 = 0;
        while (i11 < length) {
            if (table == Table.BINARY) {
                if (length - i11 < 5) {
                    break;
                }
                int readCode = readCode(zArr, i11, 5);
                i11 += 5;
                if (readCode == 0) {
                    if (length - i11 < 11) {
                        break;
                    }
                    readCode = readCode(zArr, i11, 11) + 31;
                    i11 += 11;
                }
                int i12 = 0;
                while (true) {
                    if (i12 >= readCode) {
                        break;
                    } else if (length - i11 < 8) {
                        i11 = length;
                        break;
                    } else {
                        sb2.append((char) readCode(zArr, i11, 8));
                        i11 += 8;
                        i12++;
                    }
                }
            } else {
                int i13 = table == Table.DIGIT ? 4 : 5;
                if (length - i11 < i13) {
                    break;
                }
                int readCode2 = readCode(zArr, i11, i13);
                i11 += i13;
                String character = getCharacter(table, readCode2);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        Table table3 = table2;
                        table2 = table;
                        table = table3;
                    }
                } else {
                    sb2.append(character);
                }
            }
            table = table2;
        }
        return sb2.toString();
    }

    private static Table getTable(char c11) {
        if (c11 == 'B') {
            return Table.BINARY;
        }
        if (c11 == 'D') {
            return Table.DIGIT;
        }
        if (c11 == 'P') {
            return Table.PUNCT;
        }
        if (c11 == 'L') {
            return Table.LOWER;
        }
        if (c11 != 'M') {
            return Table.UPPER;
        }
        return Table.MIXED;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i11) {
        int readCode;
        int length = zArr.length - i11;
        if (length >= 8) {
            readCode = readCode(zArr, i11, 8);
        } else {
            readCode = readCode(zArr, i11, length) << (8 - length);
        }
        return (byte) readCode;
    }

    private static int readCode(boolean[] zArr, int i11, int i12) {
        int i13 = 0;
        for (int i14 = i11; i14 < i11 + i12; i14++) {
            i13 <<= 1;
            if (zArr[i14]) {
                i13 |= 1;
            }
        }
        return i13;
    }

    private static int totalBitsInLayer(int i11, boolean z11) {
        return ((z11 ? 88 : 112) + (i11 << 4)) * i11;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), (List<byte[]>) null, (String) null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
