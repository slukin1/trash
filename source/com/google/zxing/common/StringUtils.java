package com.google.zxing.common;

import com.google.common.primitives.SignedBytes;
import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String name = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = name;
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(name) || EUC_JP.equalsIgnoreCase(name);
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte[] bArr2 = bArr;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map2.containsKey(decodeHintType)) {
                return map2.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z11 = true;
        int i11 = 0;
        boolean z12 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        boolean z13 = true;
        boolean z14 = true;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i13 < length && (z11 || z13 || z14)) {
            byte b11 = bArr2[i13] & 255;
            if (z14) {
                if (i14 > 0) {
                    if ((b11 & 128) != 0) {
                        i14--;
                    }
                } else if ((b11 & 128) != 0) {
                    if ((b11 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
                        i14++;
                        if ((b11 & 32) == 0) {
                            i16++;
                        } else {
                            i14++;
                            if ((b11 & 16) == 0) {
                                i17++;
                            } else {
                                i14++;
                                if ((b11 & 8) == 0) {
                                    i18++;
                                }
                            }
                        }
                    }
                }
                z14 = false;
            }
            if (z11) {
                if (b11 > Byte.MAX_VALUE && b11 < 160) {
                    z11 = false;
                } else if (b11 > 159 && (b11 < 192 || b11 == 215 || b11 == 247)) {
                    i21++;
                }
            }
            if (z13) {
                if (i15 > 0) {
                    if (b11 >= 64 && b11 != Byte.MAX_VALUE && b11 <= 252) {
                        i15--;
                    }
                } else if (!(b11 == 128 || b11 == 160 || b11 > 239)) {
                    if (b11 <= 160 || b11 >= 224) {
                        if (b11 > Byte.MAX_VALUE) {
                            i15++;
                            int i24 = i22 + 1;
                            if (i24 > i11) {
                                i11 = i24;
                                i22 = i11;
                            } else {
                                i22 = i24;
                            }
                        } else {
                            i22 = 0;
                        }
                        i23 = 0;
                    } else {
                        i12++;
                        int i25 = i23 + 1;
                        if (i25 > i19) {
                            i19 = i25;
                            i23 = i19;
                        } else {
                            i23 = i25;
                        }
                        i22 = 0;
                    }
                }
                z13 = false;
            }
            i13++;
            bArr2 = bArr;
        }
        if (z14 && i14 > 0) {
            z14 = false;
        }
        if (z13 && i15 > 0) {
            z13 = false;
        }
        if (z14 && (z12 || i16 + i17 + i18 > 0)) {
            return "UTF8";
        }
        if (z13 && (ASSUME_SHIFT_JIS || i19 >= 3 || i11 >= 3)) {
            return SHIFT_JIS;
        }
        if (!z11 || !z13) {
            if (z11) {
                return ISO88591;
            }
            if (z13) {
                return SHIFT_JIS;
            }
            if (z14) {
                return "UTF8";
            }
            return PLATFORM_DEFAULT_ENCODING;
        } else if ((i19 != 2 || i12 != 2) && i21 * 10 < length) {
            return ISO88591;
        } else {
            return SHIFT_JIS;
        }
    }
}
