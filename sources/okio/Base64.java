package okio;

import java.util.Arrays;
import okio.ByteString;

/* renamed from: okio.-Base64  reason: invalid class name */
public final class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i11;
        String str2 = str;
        int length = str.length();
        while (length > 0 && ((r6 = str2.charAt(length - 1)) == '=' || r6 == 10 || r6 == 13 || r6 == ' ' || r6 == 9)) {
            length--;
        }
        int i12 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i12];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            boolean z11 = true;
            if (i13 < length) {
                char charAt = str2.charAt(i13);
                if ('A' <= charAt && charAt < '[') {
                    i11 = charAt - 'A';
                } else {
                    if ('a' <= charAt && charAt < '{') {
                        i11 = charAt - 'G';
                    } else {
                        if ('0' > charAt || charAt >= ':') {
                            z11 = false;
                        }
                        if (z11) {
                            i11 = charAt + 4;
                        } else if (charAt == '+' || charAt == '-') {
                            i11 = 62;
                        } else if (charAt == '/' || charAt == '_') {
                            i11 = 63;
                        } else {
                            if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                                return null;
                            }
                            i13++;
                        }
                    }
                }
                i15 = (i15 << 6) | i11;
                i14++;
                if (i14 % 4 == 0) {
                    int i17 = i16 + 1;
                    bArr[i16] = (byte) (i15 >> 16);
                    int i18 = i17 + 1;
                    bArr[i17] = (byte) (i15 >> 8);
                    bArr[i18] = (byte) i15;
                    i16 = i18 + 1;
                }
                i13++;
            } else {
                int i19 = i14 % 4;
                if (i19 == 1) {
                    return null;
                }
                if (i19 == 2) {
                    bArr[i16] = (byte) ((i15 << 12) >> 16);
                    i16++;
                } else if (i19 == 3) {
                    int i21 = i15 << 6;
                    int i22 = i16 + 1;
                    bArr[i16] = (byte) (i21 >> 16);
                    i16 = i22 + 1;
                    bArr[i22] = (byte) (i21 >> 8);
                }
                if (i16 == i12) {
                    return bArr;
                }
                return Arrays.copyOf(bArr, i16);
            }
        }
    }

    public static final String encodeBase64(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            int i14 = i13 + 1;
            byte b12 = bArr[i13];
            int i15 = i14 + 1;
            byte b13 = bArr[i14];
            int i16 = i12 + 1;
            bArr3[i12] = bArr2[(b11 & 255) >> 2];
            int i17 = i16 + 1;
            bArr3[i16] = bArr2[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
            int i18 = i17 + 1;
            bArr3[i17] = bArr2[((b12 & 15) << 2) | ((b13 & 255) >> 6)];
            i12 = i18 + 1;
            bArr3[i18] = bArr2[b13 & Utf8.REPLACEMENT_BYTE];
            i11 = i15;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b14 = bArr[i11];
            int i19 = i12 + 1;
            bArr3[i12] = bArr2[(b14 & 255) >> 2];
            int i21 = i19 + 1;
            bArr3[i19] = bArr2[(b14 & 3) << 4];
            bArr3[i21] = 61;
            bArr3[i21 + 1] = 61;
        } else if (length2 == 2) {
            int i22 = i11 + 1;
            byte b15 = bArr[i11];
            byte b16 = bArr[i22];
            int i23 = i12 + 1;
            bArr3[i12] = bArr2[(b15 & 255) >> 2];
            int i24 = i23 + 1;
            bArr3[i23] = bArr2[((b15 & 3) << 4) | ((b16 & 255) >> 4)];
            bArr3[i24] = bArr2[(b16 & 15) << 2];
            bArr3[i24 + 1] = 61;
        }
        return _JvmPlatformKt.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
