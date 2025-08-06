package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;

public class IOUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Properties f14401a = new Properties();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f14402b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f14403c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d  reason: collision with root package name */
    public static final boolean[] f14404d = new boolean[256];

    /* renamed from: e  reason: collision with root package name */
    public static final boolean[] f14405e = new boolean[256];

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f14406f;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f14407g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean[] f14408h = new boolean[161];

    /* renamed from: i  reason: collision with root package name */
    public static final boolean[] f14409i = new boolean[161];

    /* renamed from: j  reason: collision with root package name */
    public static final char[] f14410j = new char[93];

    /* renamed from: k  reason: collision with root package name */
    public static final char[] f14411k = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};

    /* renamed from: l  reason: collision with root package name */
    public static final char[] f14412l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: m  reason: collision with root package name */
    public static final char[] f14413m = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};

    /* renamed from: n  reason: collision with root package name */
    public static final char[] f14414n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: o  reason: collision with root package name */
    public static final int[] f14415o = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    /* renamed from: p  reason: collision with root package name */
    public static final char[] f14416p;

    /* renamed from: q  reason: collision with root package name */
    public static final int[] f14417q;

    public static class a implements PrivilegedAction<InputStream> {
        /* renamed from: a */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.getResourceAsStream("fastjson.properties");
            }
            return ClassLoader.getSystemResourceAsStream("fastjson.properties");
        }
    }

    static {
        char c11 = 0;
        while (true) {
            boolean[] zArr = f14404d;
            if (c11 >= zArr.length) {
                break;
            }
            if (c11 >= 'A' && c11 <= 'Z') {
                zArr[c11] = true;
            } else if (c11 >= 'a' && c11 <= 'z') {
                zArr[c11] = true;
            } else if (c11 == '_') {
                zArr[c11] = true;
            }
            c11 = (char) (c11 + 1);
        }
        char c12 = 0;
        while (true) {
            boolean[] zArr2 = f14405e;
            if (c12 < zArr2.length) {
                if (c12 >= 'A' && c12 <= 'Z') {
                    zArr2[c12] = true;
                } else if (c12 >= 'a' && c12 <= 'z') {
                    zArr2[c12] = true;
                } else if (c12 == '_') {
                    zArr2[c12] = true;
                } else if (c12 >= '0' && c12 <= '9') {
                    zArr2[c12] = true;
                }
                c12 = (char) (c12 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        m();
        byte[] bArr = new byte[161];
        f14406f = bArr;
        byte[] bArr2 = new byte[161];
        f14407g = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i11 = 14; i11 <= 31; i11++) {
            f14406f[i11] = 4;
            f14407g[i11] = 4;
        }
        for (int i12 = 127; i12 < 160; i12++) {
            f14406f[i12] = 4;
            f14407g[i12] = 4;
        }
        for (int i13 = 0; i13 < 161; i13++) {
            f14408h[i13] = f14406f[i13] != 0;
            f14409i[i13] = f14407g[i13] != 0;
        }
        char[] cArr = f14410j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f14416p = charArray;
        int[] iArr = new int[256];
        f14417q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i14 = 0; i14 < length; i14++) {
            f14417q[f14416p[i14]] = i14;
        }
        f14417q[61] = 0;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
        } catch (CharacterCodingException e11) {
            throw new JSONException("utf8 decode error, " + e11.getMessage(), e11);
        }
    }

    public static byte[] c(String str) {
        int i11;
        int length = str.length();
        int i12 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i13 = length - 1;
        int i14 = 0;
        while (i14 < i13 && f14417q[str.charAt(i14) & 255] < 0) {
            i14++;
        }
        while (i13 > 0 && f14417q[str.charAt(i13) & 255] < 0) {
            i13--;
        }
        int i15 = str.charAt(i13) == '=' ? str.charAt(i13 + -1) == '=' ? 2 : 1 : 0;
        int i16 = (i13 - i14) + 1;
        if (length > 76) {
            i11 = (str.charAt(76) == 13 ? i16 / 78 : 0) << 1;
        } else {
            i11 = 0;
        }
        int i17 = (((i16 - i11) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i21 = 0;
        while (i19 < i18) {
            int[] iArr = f14417q;
            int i22 = i14 + 1;
            int i23 = i22 + 1;
            int i24 = (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i22)] << 12);
            int i25 = i23 + 1;
            int i26 = i24 | (iArr[str.charAt(i23)] << 6);
            int i27 = i25 + 1;
            int i28 = i26 | iArr[str.charAt(i25)];
            int i29 = i19 + 1;
            bArr[i19] = (byte) (i28 >> 16);
            int i30 = i29 + 1;
            bArr[i29] = (byte) (i28 >> 8);
            int i31 = i30 + 1;
            bArr[i30] = (byte) i28;
            if (i11 > 0 && (i21 = i21 + 1) == 19) {
                i27 += 2;
                i21 = 0;
            }
            i14 = i27;
            i19 = i31;
        }
        if (i19 < i17) {
            int i32 = 0;
            while (i14 <= i13 - i15) {
                i12 |= f14417q[str.charAt(i14)] << (18 - (i32 * 6));
                i32++;
                i14++;
            }
            int i33 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i12 >> i33);
                i33 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    public static byte[] d(String str, int i11, int i12) {
        int i13;
        int i14 = 0;
        if (i12 == 0) {
            return new byte[0];
        }
        int i15 = (i11 + i12) - 1;
        while (i11 < i15 && f14417q[str.charAt(i11)] < 0) {
            i11++;
        }
        while (i15 > 0 && f14417q[str.charAt(i15)] < 0) {
            i15--;
        }
        int i16 = str.charAt(i15) == '=' ? str.charAt(i15 + -1) == '=' ? 2 : 1 : 0;
        int i17 = (i15 - i11) + 1;
        if (i12 > 76) {
            i13 = (str.charAt(76) == 13 ? i17 / 78 : 0) << 1;
        } else {
            i13 = 0;
        }
        int i18 = (((i17 - i13) * 6) >> 3) - i16;
        byte[] bArr = new byte[i18];
        int i19 = (i18 / 3) * 3;
        int i21 = 0;
        int i22 = 0;
        while (i21 < i19) {
            int[] iArr = f14417q;
            int i23 = i11 + 1;
            int i24 = i23 + 1;
            int i25 = (iArr[str.charAt(i11)] << 18) | (iArr[str.charAt(i23)] << 12);
            int i26 = i24 + 1;
            int i27 = i25 | (iArr[str.charAt(i24)] << 6);
            int i28 = i26 + 1;
            int i29 = i27 | iArr[str.charAt(i26)];
            int i30 = i21 + 1;
            bArr[i21] = (byte) (i29 >> 16);
            int i31 = i30 + 1;
            bArr[i30] = (byte) (i29 >> 8);
            int i32 = i31 + 1;
            bArr[i31] = (byte) i29;
            if (i13 > 0 && (i22 = i22 + 1) == 19) {
                i28 += 2;
                i22 = 0;
            }
            i11 = i28;
            i21 = i32;
        }
        if (i21 < i18) {
            int i33 = 0;
            while (i11 <= i15 - i16) {
                i14 |= f14417q[str.charAt(i11)] << (18 - (i33 * 6));
                i33++;
                i11++;
            }
            int i34 = 16;
            while (i21 < i18) {
                bArr[i21] = (byte) (i14 >> i34);
                i34 -= 8;
                i21++;
            }
        }
        return bArr;
    }

    public static byte[] e(char[] cArr, int i11, int i12) {
        int i13;
        int i14 = 0;
        if (i12 == 0) {
            return new byte[0];
        }
        int i15 = (i11 + i12) - 1;
        while (i11 < i15 && f14417q[cArr[i11]] < 0) {
            i11++;
        }
        while (i15 > 0 && f14417q[cArr[i15]] < 0) {
            i15--;
        }
        int i16 = cArr[i15] == '=' ? cArr[i15 + -1] == '=' ? 2 : 1 : 0;
        int i17 = (i15 - i11) + 1;
        if (i12 > 76) {
            i13 = (cArr[76] == 13 ? i17 / 78 : 0) << 1;
        } else {
            i13 = 0;
        }
        int i18 = (((i17 - i13) * 6) >> 3) - i16;
        byte[] bArr = new byte[i18];
        int i19 = (i18 / 3) * 3;
        int i21 = 0;
        int i22 = 0;
        while (i21 < i19) {
            int[] iArr = f14417q;
            int i23 = i11 + 1;
            int i24 = i23 + 1;
            int i25 = (iArr[cArr[i11]] << 18) | (iArr[cArr[i23]] << 12);
            int i26 = i24 + 1;
            int i27 = i25 | (iArr[cArr[i24]] << 6);
            int i28 = i26 + 1;
            int i29 = i27 | iArr[cArr[i26]];
            int i30 = i21 + 1;
            bArr[i21] = (byte) (i29 >> 16);
            int i31 = i30 + 1;
            bArr[i30] = (byte) (i29 >> 8);
            int i32 = i31 + 1;
            bArr[i31] = (byte) i29;
            if (i13 > 0 && (i22 = i22 + 1) == 19) {
                i28 += 2;
                i22 = 0;
            }
            i11 = i28;
            i21 = i32;
        }
        if (i21 < i18) {
            int i33 = 0;
            while (i11 <= i15 - i16) {
                i14 |= f14417q[cArr[i11]] << (18 - (i33 * 6));
                i33++;
                i11++;
            }
            int i34 = 16;
            while (i21 < i18) {
                bArr[i21] = (byte) (i14 >> i34);
                i34 -= 8;
                i21++;
            }
        }
        return bArr;
    }

    public static int f(byte[] bArr, int i11, int i12, char[] cArr) {
        int i13;
        int i14 = i11 + i12;
        int min = Math.min(i12, cArr.length);
        int i15 = 0;
        while (i13 < min && bArr[r10] >= 0) {
            cArr[i13] = (char) bArr[r10];
            i15 = i13 + 1;
            i11 = r10 + 1;
        }
        while (r10 < i14) {
            int i16 = r10 + 1;
            byte b11 = bArr[r10];
            if (b11 >= 0) {
                cArr[i13] = (char) b11;
                r10 = i16;
                i13++;
            } else if ((b11 >> 5) != -2 || (b11 & 30) == 0) {
                if ((b11 >> 4) == -2) {
                    int i17 = i16 + 1;
                    if (i17 < i14) {
                        byte b12 = bArr[i16];
                        int i18 = i17 + 1;
                        byte b13 = bArr[i17];
                        if (!(b11 == -32 && (b12 & ISO7816.INS_CREATE_FILE) == 128) && (b12 & ISO7816.INS_GET_RESPONSE) == 128 && (b13 & ISO7816.INS_GET_RESPONSE) == 128) {
                            char c11 = (char) (((b11 << 12) ^ (b12 << 6)) ^ (-123008 ^ b13));
                            if (c11 >= 55296 && c11 < 57344) {
                                return -1;
                            }
                            cArr[i13] = c11;
                            i13++;
                            r10 = i18;
                        }
                    }
                    return -1;
                }
                if ((b11 >> 3) == -2 && i16 + 2 < i14) {
                    int i19 = i16 + 1;
                    byte b14 = bArr[i16];
                    int i21 = i19 + 1;
                    byte b15 = bArr[i19];
                    int i22 = i21 + 1;
                    byte b16 = bArr[i21];
                    byte b17 = (((b11 << 18) ^ (b14 << 12)) ^ (b15 << 6)) ^ (3678080 ^ b16);
                    if ((b14 & ISO7816.INS_GET_RESPONSE) == 128 && (b15 & ISO7816.INS_GET_RESPONSE) == 128 && (b16 & ISO7816.INS_GET_RESPONSE) == 128 && Character.isSupplementaryCodePoint(b17)) {
                        int i23 = i13 + 1;
                        cArr[i13] = (char) ((b17 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                        i13 = i23 + 1;
                        cArr[i23] = (char) ((b17 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                        r10 = i22;
                    }
                }
                return -1;
            } else if (i16 >= i14) {
                return -1;
            } else {
                int i24 = i16 + 1;
                byte b18 = bArr[i16];
                if ((b18 & ISO7816.INS_GET_RESPONSE) != 128) {
                    return -1;
                }
                cArr[i13] = (char) (((b11 << 6) ^ b18) ^ 3968);
                r10 = i24;
                i13++;
            }
        }
        return i13;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int g(char[] r9, int r10, int r11, byte[] r12) {
        /*
            int r0 = r10 + r11
            int r1 = r12.length
            int r11 = java.lang.Math.min(r11, r1)
            r1 = 0
            int r11 = r11 + r1
        L_0x0009:
            r2 = 128(0x80, float:1.794E-43)
            if (r1 >= r11) goto L_0x001d
            char r3 = r9[r10]
            if (r3 >= r2) goto L_0x001d
            int r2 = r1 + 1
            int r3 = r10 + 1
            char r10 = r9[r10]
            byte r10 = (byte) r10
            r12[r1] = r10
            r1 = r2
            r10 = r3
            goto L_0x0009
        L_0x001d:
            if (r10 >= r0) goto L_0x00d8
            int r11 = r10 + 1
            char r10 = r9[r10]
            if (r10 >= r2) goto L_0x002d
            int r3 = r1 + 1
            byte r10 = (byte) r10
            r12[r1] = r10
        L_0x002a:
            r10 = r11
            r1 = r3
            goto L_0x001d
        L_0x002d:
            r3 = 2048(0x800, float:2.87E-42)
            if (r10 >= r3) goto L_0x0044
            int r3 = r1 + 1
            int r4 = r10 >> 6
            r4 = r4 | 192(0xc0, float:2.69E-43)
            byte r4 = (byte) r4
            r12[r1] = r4
            int r1 = r3 + 1
            r10 = r10 & 63
            r10 = r10 | r2
            byte r10 = (byte) r10
            r12[r3] = r10
        L_0x0042:
            r10 = r11
            goto L_0x001d
        L_0x0044:
            r3 = 55296(0xd800, float:7.7486E-41)
            r4 = 63
            if (r10 < r3) goto L_0x00bc
            r3 = 57344(0xe000, float:8.0356E-41)
            if (r10 >= r3) goto L_0x00bc
            int r3 = r11 + -1
            boolean r5 = java.lang.Character.isHighSurrogate(r10)
            java.lang.String r6 = "encodeUTF8 error"
            r7 = 1
            if (r5 == 0) goto L_0x007c
            int r5 = r0 - r3
            r8 = 2
            if (r5 >= r8) goto L_0x0062
            r10 = -1
            goto L_0x0082
        L_0x0062:
            int r3 = r3 + 1
            char r3 = r9[r3]
            boolean r5 = java.lang.Character.isLowSurrogate(r3)
            if (r5 == 0) goto L_0x0071
            int r10 = java.lang.Character.toCodePoint(r10, r3)
            goto L_0x0082
        L_0x0071:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.nio.charset.MalformedInputException r10 = new java.nio.charset.MalformedInputException
            r10.<init>(r7)
            r9.<init>(r6, r10)
            throw r9
        L_0x007c:
            boolean r3 = java.lang.Character.isLowSurrogate(r10)
            if (r3 != 0) goto L_0x00b1
        L_0x0082:
            if (r10 >= 0) goto L_0x0089
            int r10 = r1 + 1
            r12[r1] = r4
            goto L_0x00af
        L_0x0089:
            int r3 = r1 + 1
            int r5 = r10 >> 18
            r5 = r5 | 240(0xf0, float:3.36E-43)
            byte r5 = (byte) r5
            r12[r1] = r5
            int r1 = r3 + 1
            int r5 = r10 >> 12
            r5 = r5 & r4
            r5 = r5 | r2
            byte r5 = (byte) r5
            r12[r3] = r5
            int r3 = r1 + 1
            int r5 = r10 >> 6
            r4 = r4 & r5
            r4 = r4 | r2
            byte r4 = (byte) r4
            r12[r1] = r4
            int r1 = r3 + 1
            r10 = r10 & 63
            r10 = r10 | r2
            byte r10 = (byte) r10
            r12[r3] = r10
            int r11 = r11 + 1
            r10 = r1
        L_0x00af:
            r1 = r10
            goto L_0x0042
        L_0x00b1:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.nio.charset.MalformedInputException r10 = new java.nio.charset.MalformedInputException
            r10.<init>(r7)
            r9.<init>(r6, r10)
            throw r9
        L_0x00bc:
            int r3 = r1 + 1
            int r5 = r10 >> 12
            r5 = r5 | 224(0xe0, float:3.14E-43)
            byte r5 = (byte) r5
            r12[r1] = r5
            int r1 = r3 + 1
            int r5 = r10 >> 6
            r4 = r4 & r5
            r4 = r4 | r2
            byte r4 = (byte) r4
            r12[r3] = r4
            int r3 = r1 + 1
            r10 = r10 & 63
            r10 = r10 | r2
            byte r10 = (byte) r10
            r12[r1] = r10
            goto L_0x002a
        L_0x00d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.IOUtils.g(char[], int, int, byte[]):int");
    }

    public static boolean h(char c11) {
        boolean[] zArr = f14404d;
        return c11 < zArr.length && zArr[c11];
    }

    public static void i(int i11, int i12, char[] cArr) {
        char c11;
        if (i11 < 0) {
            c11 = '-';
            i11 = -i11;
        } else {
            c11 = 0;
        }
        while (i11 >= 65536) {
            int i13 = i11 / 100;
            int i14 = i11 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            int i15 = i12 - 1;
            cArr[i15] = f14414n[i14];
            i12 = i15 - 1;
            cArr[i12] = f14413m[i14];
            i11 = i13;
        }
        while (true) {
            int i16 = (52429 * i11) >>> 19;
            i12--;
            cArr[i12] = f14412l[i11 - ((i16 << 3) + (i16 << 1))];
            if (i16 == 0) {
                break;
            }
            i11 = i16;
        }
        if (c11 != 0) {
            cArr[i12 - 1] = c11;
        }
    }

    public static void j(long j11, int i11, char[] cArr) {
        char c11;
        if (j11 < 0) {
            c11 = '-';
            j11 = -j11;
        } else {
            c11 = 0;
        }
        while (j11 > 2147483647L) {
            long j12 = j11 / 100;
            int i12 = (int) (j11 - (((j12 << 6) + (j12 << 5)) + (j12 << 2)));
            int i13 = i11 - 1;
            cArr[i13] = f14414n[i12];
            i11 = i13 - 1;
            cArr[i11] = f14413m[i12];
            j11 = j12;
        }
        int i14 = (int) j11;
        while (i14 >= 65536) {
            int i15 = i14 / 100;
            int i16 = i14 - (((i15 << 6) + (i15 << 5)) + (i15 << 2));
            int i17 = i11 - 1;
            cArr[i17] = f14414n[i16];
            i11 = i17 - 1;
            cArr[i11] = f14413m[i16];
            i14 = i15;
        }
        while (true) {
            int i18 = (52429 * i14) >>> 19;
            i11--;
            cArr[i11] = f14412l[i14 - ((i18 << 3) + (i18 << 1))];
            if (i18 == 0) {
                break;
            }
            i14 = i18;
        }
        if (c11 != 0) {
            cArr[i11 - 1] = c11;
        }
    }

    public static String k(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? f14401a.getProperty(str) : str2;
    }

    public static boolean l(char c11) {
        boolean[] zArr = f14405e;
        return c11 < zArr.length && zArr[c11];
    }

    public static void m() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                f14401a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int n(int i11) {
        int i12 = 0;
        while (i11 > f14415o[i12]) {
            i12++;
        }
        return i12 + 1;
    }

    public static int o(long j11) {
        long j12 = 10;
        for (int i11 = 1; i11 < 19; i11++) {
            if (j11 < j12) {
                return i11;
            }
            j12 *= 10;
        }
        return 19;
    }
}
