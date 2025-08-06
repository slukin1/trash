package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.HttpUrl;
import okio.Utf8;

public final class SerializeWriter extends Writer {

    /* renamed from: r  reason: collision with root package name */
    public static final Charset f14316r = Charset.forName("UTF-8");

    /* renamed from: s  reason: collision with root package name */
    public static final ThreadLocal<char[]> f14317s = new ThreadLocal<>();

    /* renamed from: t  reason: collision with root package name */
    public static final ThreadLocal<byte[]> f14318t = new ThreadLocal<>();

    /* renamed from: u  reason: collision with root package name */
    public static final int f14319u = ((((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserSecure.mask) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask);

    /* renamed from: b  reason: collision with root package name */
    public char[] f14320b;

    /* renamed from: c  reason: collision with root package name */
    public int f14321c;

    /* renamed from: d  reason: collision with root package name */
    public int f14322d;

    /* renamed from: e  reason: collision with root package name */
    public final Writer f14323e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14324f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14325g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14326h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14327i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f14328j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f14329k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14330l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f14331m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f14332n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f14333o;

    /* renamed from: p  reason: collision with root package name */
    public char f14334p;

    /* renamed from: q  reason: collision with root package name */
    public int f14335q;

    public SerializeWriter() {
        this((Writer) null);
    }

    public static boolean o(char c11, int i11) {
        if (c11 == ' ') {
            return false;
        }
        if (c11 == '/') {
            return (SerializerFeature.WriteSlashAsSpecial.mask & i11) != 0;
        }
        if (c11 <= '#' || c11 == '\\') {
            return c11 <= 31 || c11 == '\\' || c11 == '\"';
        }
        return false;
    }

    public void A(char c11, String str, String str2) {
        if (!this.f14325g) {
            write((int) c11);
            v(str);
            if (str2 == null) {
                H();
            } else {
                K(str2);
            }
        } else if (this.f14324f) {
            write((int) c11);
            v(str);
            if (str2 == null) {
                H();
            } else {
                K(str2);
            }
        } else if (n(SerializerFeature.BrowserSecure)) {
            write((int) c11);
            L(str, ':');
            L(str2, 0);
        } else if (n(SerializerFeature.BrowserCompatible)) {
            write((int) c11);
            L(str, ':');
            L(str2, 0);
        } else {
            B(c11, str, str2);
        }
    }

    public void B(char c11, String str, String str2) {
        int i11;
        int i12;
        int i13;
        String str3 = str;
        String str4 = str2;
        int length = str.length();
        int i14 = this.f14321c;
        if (str4 == null) {
            i12 = i14 + length + 8;
            i11 = 4;
        } else {
            i11 = str2.length();
            i12 = i14 + length + i11 + 6;
        }
        int i15 = 0;
        if (i12 > this.f14320b.length) {
            if (this.f14323e != null) {
                write((int) c11);
                L(str3, ':');
                L(str4, 0);
                return;
            }
            l(i12);
        }
        char[] cArr = this.f14320b;
        int i16 = this.f14321c;
        cArr[i16] = c11;
        int i17 = i16 + 2;
        int i18 = i17 + length;
        cArr[i16 + 1] = '\"';
        str3.getChars(0, length, cArr, i17);
        this.f14321c = i12;
        char[] cArr2 = this.f14320b;
        cArr2[i18] = '\"';
        int i19 = i18 + 1;
        int i21 = i19 + 1;
        cArr2[i19] = ':';
        if (str4 == null) {
            int i22 = i21 + 1;
            cArr2[i21] = 'n';
            int i23 = i22 + 1;
            cArr2[i22] = 'u';
            cArr2[i23] = 'l';
            cArr2[i23 + 1] = 'l';
            return;
        }
        int i24 = i21 + 1;
        cArr2[i21] = '\"';
        int i25 = i24 + i11;
        str4.getChars(0, i11, cArr2, i24);
        int i26 = -1;
        int i27 = -1;
        char c12 = 0;
        for (int i28 = i24; i28 < i25; i28++) {
            char c13 = this.f14320b[i28];
            if (c13 >= ']') {
                if (c13 >= 127 && (c13 == 8232 || c13 == 8233 || c13 < 160)) {
                    if (i26 == -1) {
                        i26 = i28;
                    }
                    i15++;
                    i12 += 4;
                    c12 = c13;
                }
            } else {
                if (o(c13, this.f14322d)) {
                    i15++;
                    byte[] bArr = IOUtils.f14406f;
                    if (c13 < bArr.length && bArr[c13] == 4) {
                        i12 += 4;
                    }
                    c12 = c13;
                    if (i26 == -1) {
                        i26 = i28;
                        i27 = i26;
                    }
                }
            }
            i27 = i28;
        }
        if (i15 > 0) {
            int i29 = i12 + i15;
            if (i29 > this.f14320b.length) {
                l(i29);
            }
            this.f14321c = i29;
            if (i15 == 1) {
                if (c12 == 8232) {
                    int i30 = i27 + 1;
                    char[] cArr3 = this.f14320b;
                    System.arraycopy(cArr3, i30, cArr3, i27 + 6, (i25 - i27) - 1);
                    char[] cArr4 = this.f14320b;
                    cArr4[i27] = '\\';
                    cArr4[i30] = 'u';
                    int i31 = i30 + 1;
                    cArr4[i31] = '2';
                    int i32 = i31 + 1;
                    cArr4[i32] = '0';
                    int i33 = i32 + 1;
                    cArr4[i33] = '2';
                    cArr4[i33 + 1] = '8';
                } else if (c12 == 8233) {
                    int i34 = i27 + 1;
                    char[] cArr5 = this.f14320b;
                    System.arraycopy(cArr5, i34, cArr5, i27 + 6, (i25 - i27) - 1);
                    char[] cArr6 = this.f14320b;
                    cArr6[i27] = '\\';
                    cArr6[i34] = 'u';
                    int i35 = i34 + 1;
                    cArr6[i35] = '2';
                    int i36 = i35 + 1;
                    cArr6[i36] = '0';
                    int i37 = i36 + 1;
                    cArr6[i37] = '2';
                    cArr6[i37 + 1] = '9';
                } else {
                    byte[] bArr2 = IOUtils.f14406f;
                    if (c12 >= bArr2.length || bArr2[c12] != 4) {
                        int i38 = i27 + 1;
                        char[] cArr7 = this.f14320b;
                        System.arraycopy(cArr7, i38, cArr7, i27 + 2, (i25 - i27) - 1);
                        char[] cArr8 = this.f14320b;
                        cArr8[i27] = '\\';
                        cArr8[i38] = IOUtils.f14410j[c12];
                    } else {
                        int i39 = i27 + 1;
                        char[] cArr9 = this.f14320b;
                        System.arraycopy(cArr9, i39, cArr9, i27 + 6, (i25 - i27) - 1);
                        char[] cArr10 = this.f14320b;
                        cArr10[i27] = '\\';
                        int i40 = i39 + 1;
                        cArr10[i39] = 'u';
                        int i41 = i40 + 1;
                        char[] cArr11 = IOUtils.f14403c;
                        cArr10[i40] = cArr11[(c12 >>> 12) & 15];
                        int i42 = i41 + 1;
                        cArr10[i41] = cArr11[(c12 >>> 8) & 15];
                        cArr10[i42] = cArr11[(c12 >>> 4) & 15];
                        cArr10[i42 + 1] = cArr11[c12 & 15];
                    }
                }
            } else if (i15 > 1) {
                for (int i43 = i26 - i24; i43 < str2.length(); i43++) {
                    char charAt = str4.charAt(i43);
                    byte[] bArr3 = IOUtils.f14406f;
                    if ((charAt < bArr3.length && bArr3[charAt] != 0) || (charAt == '/' && n(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr12 = this.f14320b;
                        int i44 = i26 + 1;
                        cArr12[i26] = '\\';
                        if (bArr3[charAt] == 4) {
                            int i45 = i44 + 1;
                            cArr12[i44] = 'u';
                            int i46 = i45 + 1;
                            char[] cArr13 = IOUtils.f14403c;
                            cArr12[i45] = cArr13[(charAt >>> 12) & 15];
                            int i47 = i46 + 1;
                            cArr12[i46] = cArr13[(charAt >>> 8) & 15];
                            int i48 = i47 + 1;
                            cArr12[i47] = cArr13[(charAt >>> 4) & 15];
                            i13 = i48 + 1;
                            cArr12[i48] = cArr13[charAt & 15];
                        } else {
                            i13 = i44 + 1;
                            cArr12[i44] = IOUtils.f14410j[charAt];
                        }
                        i26 = i13;
                    } else if (charAt == 8232 || charAt == 8233) {
                        char[] cArr14 = this.f14320b;
                        int i49 = i26 + 1;
                        cArr14[i26] = '\\';
                        int i50 = i49 + 1;
                        cArr14[i49] = 'u';
                        int i51 = i50 + 1;
                        char[] cArr15 = IOUtils.f14403c;
                        cArr14[i50] = cArr15[(charAt >>> 12) & 15];
                        int i52 = i51 + 1;
                        cArr14[i51] = cArr15[(charAt >>> 8) & 15];
                        int i53 = i52 + 1;
                        cArr14[i52] = cArr15[(charAt >>> 4) & 15];
                        cArr14[i53] = cArr15[charAt & 15];
                        i26 = i53 + 1;
                    } else {
                        this.f14320b[i26] = charAt;
                        i26++;
                    }
                }
            }
        }
        this.f14320b[this.f14321c - 1] = '\"';
    }

    public void C(float f11, boolean z11) {
        if (Float.isNaN(f11) || Float.isInfinite(f11)) {
            H();
            return;
        }
        String f12 = Float.toString(f11);
        if (n(SerializerFeature.WriteNullNumberAsZero) && f12.endsWith(".0")) {
            f12 = f12.substring(0, f12.length() - 2);
        }
        write(f12);
        if (z11 && n(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void D(byte[] bArr) {
        int i11 = 2;
        int length = this.f14321c + (bArr.length * 2) + 3;
        int i12 = 0;
        if (length > this.f14320b.length) {
            if (this.f14323e != null) {
                char[] cArr = new char[(bArr.length + 3)];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i12 < bArr.length) {
                    byte b11 = bArr[i12] & 255;
                    int i13 = b11 >> 4;
                    byte b12 = b11 & 15;
                    int i14 = i11 + 1;
                    cArr[i11] = (char) (i13 + (i13 < 10 ? 48 : 55));
                    i11 = i14 + 1;
                    cArr[i14] = (char) (b12 + (b12 < 10 ? (byte) 48 : 55));
                    i12++;
                }
                cArr[i11] = '\'';
                try {
                    this.f14323e.write(cArr);
                    return;
                } catch (IOException e11) {
                    throw new JSONException("writeBytes error.", e11);
                }
            } else {
                l(length);
            }
        }
        char[] cArr2 = this.f14320b;
        int i15 = this.f14321c;
        int i16 = i15 + 1;
        this.f14321c = i16;
        cArr2[i15] = 'x';
        this.f14321c = i16 + 1;
        cArr2[i16] = '\'';
        while (i12 < bArr.length) {
            byte b13 = bArr[i12] & 255;
            int i17 = b13 >> 4;
            byte b14 = b13 & 15;
            char[] cArr3 = this.f14320b;
            int i18 = this.f14321c;
            int i19 = i18 + 1;
            this.f14321c = i19;
            cArr3[i18] = (char) (i17 + (i17 < 10 ? 48 : 55));
            this.f14321c = i19 + 1;
            cArr3[i19] = (char) (b14 + (b14 < 10 ? (byte) 48 : 55));
            i12++;
        }
        char[] cArr4 = this.f14320b;
        int i21 = this.f14321c;
        this.f14321c = i21 + 1;
        cArr4[i21] = '\'';
    }

    public void E(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int n11 = i11 < 0 ? IOUtils.n(-i11) + 1 : IOUtils.n(i11);
        int i12 = this.f14321c + n11;
        if (i12 > this.f14320b.length) {
            if (this.f14323e == null) {
                l(i12);
            } else {
                char[] cArr = new char[n11];
                IOUtils.i(i11, n11, cArr);
                write(cArr, 0, n11);
                return;
            }
        }
        IOUtils.i(i11, i12, this.f14320b);
        this.f14321c = i12;
    }

    public final void F(String str) {
        String str2 = str;
        byte[] bArr = IOUtils.f14407g;
        int length = str.length();
        boolean z11 = true;
        int i11 = this.f14321c + length + 1;
        int i12 = 0;
        if (i11 > this.f14320b.length) {
            if (this.f14323e == null) {
                l(i11);
            } else if (length == 0) {
                write(39);
                write(39);
                write(58);
                return;
            } else {
                int i13 = 0;
                while (true) {
                    if (i13 < length) {
                        char charAt = str2.charAt(i13);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i13++;
                    } else {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    write(39);
                }
                while (i12 < length) {
                    char charAt2 = str2.charAt(i12);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write((int) charAt2);
                    } else {
                        write(92);
                        write((int) IOUtils.f14410j[charAt2]);
                    }
                    i12++;
                }
                if (z11) {
                    write(39);
                }
                write(58);
                return;
            }
        }
        if (length == 0) {
            int i14 = this.f14321c;
            if (i14 + 3 > this.f14320b.length) {
                l(i14 + 3);
            }
            char[] cArr = this.f14320b;
            int i15 = this.f14321c;
            int i16 = i15 + 1;
            this.f14321c = i16;
            cArr[i15] = '\'';
            int i17 = i16 + 1;
            this.f14321c = i17;
            cArr[i16] = '\'';
            this.f14321c = i17 + 1;
            cArr[i17] = ':';
            return;
        }
        int i18 = this.f14321c;
        int i19 = i18 + length;
        str2.getChars(0, length, this.f14320b, i18);
        this.f14321c = i11;
        int i21 = i18;
        boolean z12 = false;
        while (i21 < i19) {
            char[] cArr2 = this.f14320b;
            char c11 = cArr2[i21];
            if (c11 < bArr.length && bArr[c11] != 0) {
                if (!z12) {
                    i11 += 3;
                    if (i11 > cArr2.length) {
                        l(i11);
                    }
                    this.f14321c = i11;
                    char[] cArr3 = this.f14320b;
                    int i22 = i21 + 1;
                    System.arraycopy(cArr3, i22, cArr3, i21 + 3, (i19 - i21) - 1);
                    char[] cArr4 = this.f14320b;
                    System.arraycopy(cArr4, i12, cArr4, 1, i21);
                    char[] cArr5 = this.f14320b;
                    cArr5[i18] = '\'';
                    cArr5[i22] = '\\';
                    int i23 = i22 + 1;
                    cArr5[i23] = IOUtils.f14410j[c11];
                    i19 += 2;
                    cArr5[this.f14321c - 2] = '\'';
                    i21 = i23;
                    z12 = true;
                } else {
                    i11++;
                    if (i11 > cArr2.length) {
                        l(i11);
                    }
                    this.f14321c = i11;
                    char[] cArr6 = this.f14320b;
                    int i24 = i21 + 1;
                    System.arraycopy(cArr6, i24, cArr6, i21 + 2, i19 - i21);
                    char[] cArr7 = this.f14320b;
                    cArr7[i21] = '\\';
                    cArr7[i24] = IOUtils.f14410j[c11];
                    i19++;
                    i21 = i24;
                }
            }
            i21++;
            i12 = 0;
        }
        this.f14320b[i11 - 1] = ':';
    }

    public void G(long j11) {
        boolean z11 = n(SerializerFeature.BrowserCompatible) && !n(SerializerFeature.WriteClassName) && (j11 > 9007199254740991L || j11 < -9007199254740991L);
        if (j11 != Long.MIN_VALUE) {
            int o11 = j11 < 0 ? IOUtils.o(-j11) + 1 : IOUtils.o(j11);
            int i11 = this.f14321c + o11;
            if (z11) {
                i11 += 2;
            }
            if (i11 > this.f14320b.length) {
                if (this.f14323e == null) {
                    l(i11);
                } else {
                    char[] cArr = new char[o11];
                    IOUtils.j(j11, o11, cArr);
                    if (z11) {
                        write(34);
                        write(cArr, 0, o11);
                        write(34);
                        return;
                    }
                    write(cArr, 0, o11);
                    return;
                }
            }
            if (z11) {
                char[] cArr2 = this.f14320b;
                cArr2[this.f14321c] = '\"';
                int i12 = i11 - 1;
                IOUtils.j(j11, i12, cArr2);
                this.f14320b[i12] = '\"';
            } else {
                IOUtils.j(j11, i11, this.f14320b);
            }
            this.f14321c = i11;
        } else if (z11) {
            write("\"-9223372036854775808\"");
        } else {
            write("-9223372036854775808");
        }
    }

    public void H() {
        write(OptionsBridge.NULL_VALUE);
    }

    public void I(int i11, int i12) {
        if ((i11 & i12) == 0 && (this.f14322d & i12) == 0) {
            H();
        } else if (i12 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else if (i12 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            K("");
        } else if (i12 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write(d.f31895b);
        } else if (i12 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            H();
        }
    }

    public void J(SerializerFeature serializerFeature) {
        I(0, serializerFeature.mask);
    }

    public void K(String str) {
        if (this.f14324f) {
            M(str);
        } else {
            L(str, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0409, code lost:
        if (r10 == -1) goto L_0x0412;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0410, code lost:
        if (r10 == -1) goto L_0x0412;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void L(java.lang.String r19, char r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            if (r1 != 0) goto L_0x0011
            r18.H()
            if (r2 == 0) goto L_0x0010
            r0.write((int) r2)
        L_0x0010:
            return
        L_0x0011:
            int r3 = r19.length()
            int r4 = r0.f14321c
            int r4 = r4 + r3
            int r4 = r4 + 2
            if (r2 == 0) goto L_0x001e
            int r4 = r4 + 1
        L_0x001e:
            char[] r5 = r0.f14320b
            int r5 = r5.length
            r6 = 60
            r7 = 97
            r9 = 57
            r12 = 48
            r13 = 12
            r14 = 8
            r15 = 117(0x75, float:1.64E-43)
            r10 = 34
            r8 = 92
            r11 = 1
            if (r4 <= r5) goto L_0x018c
            java.io.Writer r5 = r0.f14323e
            if (r5 == 0) goto L_0x0189
            r0.write((int) r10)
            r3 = 0
        L_0x003e:
            int r4 = r19.length()
            if (r3 >= r4) goto L_0x0180
            char r4 = r1.charAt(r3)
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r5 = r0.n(r5)
            if (r5 == 0) goto L_0x00ae
            if (r4 != r6) goto L_0x0059
            java.lang.String r4 = "&lt;"
            r0.write((java.lang.String) r4)
            goto L_0x017a
        L_0x0059:
            r5 = 62
            if (r4 != r5) goto L_0x0064
            java.lang.String r4 = "&gt;"
            r0.write((java.lang.String) r4)
            goto L_0x017a
        L_0x0064:
            if (r4 < r12) goto L_0x0068
            if (r4 <= r9) goto L_0x0177
        L_0x0068:
            if (r4 < r7) goto L_0x006e
            r5 = 122(0x7a, float:1.71E-43)
            if (r4 <= r5) goto L_0x0177
        L_0x006e:
            r5 = 65
            if (r4 < r5) goto L_0x0076
            r5 = 90
            if (r4 <= r5) goto L_0x0177
        L_0x0076:
            r5 = 44
            if (r4 == r5) goto L_0x0177
            r5 = 46
            if (r4 == r5) goto L_0x0177
            r5 = 95
            if (r4 == r5) goto L_0x0177
            r0.write((int) r8)
            r0.write((int) r15)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r16 = r4 >>> 12
            r16 = r16 & 15
            char r6 = r5[r16]
            r0.write((int) r6)
            int r6 = r4 >>> 8
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            int r6 = r4 >>> 4
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x017a
        L_0x00ae:
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r5 = r0.n(r5)
            if (r5 == 0) goto L_0x012a
            if (r4 == r14) goto L_0x011f
            if (r4 == r13) goto L_0x011f
            r5 = 10
            if (r4 == r5) goto L_0x011f
            r5 = 13
            if (r4 == r5) goto L_0x011f
            r5 = 9
            if (r4 == r5) goto L_0x011f
            if (r4 == r10) goto L_0x011f
            r5 = 47
            if (r4 == r5) goto L_0x011f
            if (r4 != r8) goto L_0x00cf
            goto L_0x011f
        L_0x00cf:
            r5 = 32
            if (r4 >= r5) goto L_0x00f0
            r0.write((int) r8)
            r0.write((int) r15)
            r0.write((int) r12)
            r0.write((int) r12)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14411k
            int r4 = r4 * 2
            char r6 = r5[r4]
            r0.write((int) r6)
            int r4 = r4 + r11
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x017a
        L_0x00f0:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 < r5) goto L_0x0177
            r0.write((int) r8)
            r0.write((int) r15)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r6 = r4 >>> 12
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            int r6 = r4 >>> 8
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            int r6 = r4 >>> 4
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x017a
        L_0x011f:
            r0.write((int) r8)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14410j
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x017a
        L_0x012a:
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.f14406f
            int r6 = r5.length
            if (r4 >= r6) goto L_0x0133
            byte r6 = r5[r4]
            if (r6 != 0) goto L_0x013f
        L_0x0133:
            r6 = 47
            if (r4 != r6) goto L_0x0177
            com.alibaba.fastjson.serializer.SerializerFeature r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r6 = r0.n(r6)
            if (r6 == 0) goto L_0x0177
        L_0x013f:
            r0.write((int) r8)
            byte r5 = r5[r4]
            r6 = 4
            if (r5 != r6) goto L_0x016f
            r0.write((int) r15)
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r6 = r4 >>> 12
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            int r6 = r4 >>> 8
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            int r6 = r4 >>> 4
            r6 = r6 & 15
            char r6 = r5[r6]
            r0.write((int) r6)
            r4 = r4 & 15
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x017a
        L_0x016f:
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14410j
            char r4 = r5[r4]
            r0.write((int) r4)
            goto L_0x017a
        L_0x0177:
            r0.write((int) r4)
        L_0x017a:
            int r3 = r3 + 1
            r6 = 60
            goto L_0x003e
        L_0x0180:
            r0.write((int) r10)
            if (r2 == 0) goto L_0x0188
            r0.write((int) r2)
        L_0x0188:
            return
        L_0x0189:
            r0.l(r4)
        L_0x018c:
            int r5 = r0.f14321c
            int r6 = r5 + 1
            int r13 = r6 + r3
            char[] r14 = r0.f14320b
            r14[r5] = r10
            r5 = 0
            r1.getChars(r5, r3, r14, r6)
            r0.f14321c = r4
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure
            boolean r3 = r0.n(r3)
            r14 = -1
            if (r3 == 0) goto L_0x02ae
            r1 = r6
        L_0x01a6:
            if (r1 >= r13) goto L_0x01dc
            char[] r3 = r0.f14320b
            char r3 = r3[r1]
            if (r3 < r12) goto L_0x01b0
            if (r3 <= r9) goto L_0x01d9
        L_0x01b0:
            if (r3 < r7) goto L_0x01b6
            r5 = 122(0x7a, float:1.71E-43)
            if (r3 <= r5) goto L_0x01d9
        L_0x01b6:
            r5 = 65
            if (r3 < r5) goto L_0x01be
            r5 = 90
            if (r3 <= r5) goto L_0x01d9
        L_0x01be:
            r5 = 44
            if (r3 == r5) goto L_0x01d9
            r5 = 46
            if (r3 == r5) goto L_0x01d9
            r5 = 95
            if (r3 == r5) goto L_0x01d9
            r5 = 60
            if (r3 == r5) goto L_0x01d6
            r5 = 62
            if (r3 != r5) goto L_0x01d3
            goto L_0x01d6
        L_0x01d3:
            int r4 = r4 + 5
            goto L_0x01d8
        L_0x01d6:
            int r4 = r4 + 3
        L_0x01d8:
            r14 = r1
        L_0x01d9:
            int r1 = r1 + 1
            goto L_0x01a6
        L_0x01dc:
            char[] r1 = r0.f14320b
            int r1 = r1.length
            if (r4 <= r1) goto L_0x01e4
            r0.l(r4)
        L_0x01e4:
            r0.f14321c = r4
        L_0x01e6:
            if (r14 < r6) goto L_0x0298
            char[] r1 = r0.f14320b
            char r3 = r1[r14]
            if (r3 < r12) goto L_0x01f0
            if (r3 <= r9) goto L_0x0292
        L_0x01f0:
            if (r3 < r7) goto L_0x01f6
            r4 = 122(0x7a, float:1.71E-43)
            if (r3 <= r4) goto L_0x0292
        L_0x01f6:
            r4 = 65
            if (r3 < r4) goto L_0x01fe
            r4 = 90
            if (r3 <= r4) goto L_0x0292
        L_0x01fe:
            r4 = 44
            if (r3 == r4) goto L_0x0292
            r4 = 46
            if (r3 == r4) goto L_0x0292
            r4 = 95
            if (r3 == r4) goto L_0x0292
            r4 = 60
            if (r3 != r4) goto L_0x0232
            int r3 = r14 + 1
            int r5 = r14 + 4
            int r16 = r13 - r14
            int r4 = r16 + -1
            java.lang.System.arraycopy(r1, r3, r1, r5, r4)
            char[] r1 = r0.f14320b
            r4 = 38
            r1[r14] = r4
            r4 = 108(0x6c, float:1.51E-43)
            r1[r3] = r4
            int r3 = r14 + 2
            r4 = 116(0x74, float:1.63E-43)
            r1[r3] = r4
            int r3 = r14 + 3
            r4 = 59
            r1[r3] = r4
        L_0x022f:
            int r13 = r13 + 3
            goto L_0x0292
        L_0x0232:
            r4 = 62
            if (r3 != r4) goto L_0x0257
            int r3 = r14 + 1
            int r4 = r14 + 4
            int r5 = r13 - r14
            int r5 = r5 - r11
            java.lang.System.arraycopy(r1, r3, r1, r4, r5)
            char[] r1 = r0.f14320b
            r4 = 38
            r1[r14] = r4
            r4 = 103(0x67, float:1.44E-43)
            r1[r3] = r4
            int r3 = r14 + 2
            r4 = 116(0x74, float:1.63E-43)
            r1[r3] = r4
            int r3 = r14 + 3
            r4 = 59
            r1[r3] = r4
            goto L_0x022f
        L_0x0257:
            int r4 = r14 + 1
            int r5 = r14 + 6
            int r16 = r13 - r14
            int r7 = r16 + -1
            java.lang.System.arraycopy(r1, r4, r1, r5, r7)
            char[] r1 = r0.f14320b
            r1[r14] = r8
            r1[r4] = r15
            int r4 = r14 + 2
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r7 = r3 >>> 12
            r7 = r7 & 15
            char r7 = r5[r7]
            r1[r4] = r7
            int r4 = r14 + 3
            int r7 = r3 >>> 8
            r7 = r7 & 15
            char r7 = r5[r7]
            r1[r4] = r7
            int r4 = r14 + 4
            int r7 = r3 >>> 4
            r7 = r7 & 15
            char r7 = r5[r7]
            r1[r4] = r7
            int r4 = r14 + 5
            r3 = r3 & 15
            char r3 = r5[r3]
            r1[r4] = r3
            int r13 = r13 + 5
        L_0x0292:
            int r14 = r14 + -1
            r7 = 97
            goto L_0x01e6
        L_0x0298:
            if (r2 == 0) goto L_0x02a6
            char[] r1 = r0.f14320b
            int r3 = r0.f14321c
            int r4 = r3 + -2
            r1[r4] = r10
            int r3 = r3 - r11
            r1[r3] = r2
            goto L_0x02ad
        L_0x02a6:
            char[] r1 = r0.f14320b
            int r2 = r0.f14321c
            int r2 = r2 - r11
            r1[r2] = r10
        L_0x02ad:
            return
        L_0x02ae:
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            boolean r3 = r0.n(r3)
            if (r3 == 0) goto L_0x03cb
            r1 = r6
        L_0x02b7:
            if (r1 >= r13) goto L_0x02ed
            char[] r3 = r0.f14320b
            char r3 = r3[r1]
            if (r3 == r10) goto L_0x02e7
            r5 = 47
            if (r3 == r5) goto L_0x02e7
            if (r3 != r8) goto L_0x02c6
            goto L_0x02e7
        L_0x02c6:
            r5 = 8
            if (r3 == r5) goto L_0x02e7
            r5 = 12
            if (r3 == r5) goto L_0x02e7
            r5 = 10
            if (r3 == r5) goto L_0x02e7
            r5 = 13
            if (r3 == r5) goto L_0x02e7
            r5 = 9
            if (r3 != r5) goto L_0x02db
            goto L_0x02e7
        L_0x02db:
            r5 = 32
            if (r3 >= r5) goto L_0x02e2
        L_0x02df:
            int r4 = r4 + 5
            goto L_0x02e9
        L_0x02e2:
            r5 = 127(0x7f, float:1.78E-43)
            if (r3 < r5) goto L_0x02ea
            goto L_0x02df
        L_0x02e7:
            int r4 = r4 + 1
        L_0x02e9:
            r14 = r1
        L_0x02ea:
            int r1 = r1 + 1
            goto L_0x02b7
        L_0x02ed:
            char[] r1 = r0.f14320b
            int r1 = r1.length
            if (r4 <= r1) goto L_0x02f5
            r0.l(r4)
        L_0x02f5:
            r0.f14321c = r4
        L_0x02f7:
            if (r14 < r6) goto L_0x03b5
            char[] r1 = r0.f14320b
            char r3 = r1[r14]
            r4 = 8
            r5 = 12
            if (r3 == r4) goto L_0x039b
            if (r3 == r5) goto L_0x039b
            r7 = 10
            if (r3 == r7) goto L_0x039b
            r7 = 13
            if (r3 == r7) goto L_0x039b
            r7 = 9
            if (r3 != r7) goto L_0x0313
            goto L_0x039b
        L_0x0313:
            if (r3 == r10) goto L_0x038a
            r7 = 47
            if (r3 == r7) goto L_0x038a
            if (r3 != r8) goto L_0x031c
            goto L_0x038a
        L_0x031c:
            r7 = 32
            if (r3 >= r7) goto L_0x034d
            int r7 = r14 + 1
            int r9 = r14 + 6
            int r16 = r13 - r14
            int r4 = r16 + -1
            java.lang.System.arraycopy(r1, r7, r1, r9, r4)
            char[] r1 = r0.f14320b
            r1[r14] = r8
            r1[r7] = r15
            int r4 = r14 + 2
            r1[r4] = r12
            int r4 = r14 + 3
            r1[r4] = r12
            int r4 = r14 + 4
            char[] r7 = com.alibaba.fastjson.util.IOUtils.f14411k
            int r3 = r3 * 2
            char r9 = r7[r3]
            r1[r4] = r9
            int r4 = r14 + 5
            int r3 = r3 + r11
            char r3 = r7[r3]
            r1[r4] = r3
        L_0x034a:
            int r13 = r13 + 5
            goto L_0x03b1
        L_0x034d:
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 < r4) goto L_0x03b1
            int r4 = r14 + 1
            int r7 = r14 + 6
            int r9 = r13 - r14
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r7, r9)
            char[] r1 = r0.f14320b
            r1[r14] = r8
            r1[r4] = r15
            int r4 = r14 + 2
            char[] r7 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r9 = r3 >>> 12
            r9 = r9 & 15
            char r9 = r7[r9]
            r1[r4] = r9
            int r4 = r14 + 3
            int r9 = r3 >>> 8
            r9 = r9 & 15
            char r9 = r7[r9]
            r1[r4] = r9
            int r4 = r14 + 4
            int r9 = r3 >>> 4
            r9 = r9 & 15
            char r9 = r7[r9]
            r1[r4] = r9
            int r4 = r14 + 5
            r3 = r3 & 15
            char r3 = r7[r3]
            r1[r4] = r3
            goto L_0x034a
        L_0x038a:
            int r4 = r14 + 1
            int r7 = r14 + 2
            int r9 = r13 - r14
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r7, r9)
            char[] r1 = r0.f14320b
            r1[r14] = r8
            r1[r4] = r3
            goto L_0x03af
        L_0x039b:
            int r4 = r14 + 1
            int r7 = r14 + 2
            int r9 = r13 - r14
            int r9 = r9 - r11
            java.lang.System.arraycopy(r1, r4, r1, r7, r9)
            char[] r1 = r0.f14320b
            r1[r14] = r8
            char[] r7 = com.alibaba.fastjson.util.IOUtils.f14410j
            char r3 = r7[r3]
            r1[r4] = r3
        L_0x03af:
            int r13 = r13 + 1
        L_0x03b1:
            int r14 = r14 + -1
            goto L_0x02f7
        L_0x03b5:
            if (r2 == 0) goto L_0x03c3
            char[] r1 = r0.f14320b
            int r3 = r0.f14321c
            int r4 = r3 + -2
            r1[r4] = r10
            int r3 = r3 - r11
            r1[r3] = r2
            goto L_0x03ca
        L_0x03c3:
            char[] r1 = r0.f14320b
            int r2 = r0.f14321c
            int r2 = r2 - r11
            r1[r2] = r10
        L_0x03ca:
            return
        L_0x03cb:
            r3 = r5
            r7 = r6
            r10 = r14
            r17 = r10
        L_0x03d0:
            r9 = 8232(0x2028, float:1.1535E-41)
            if (r7 >= r13) goto L_0x041e
            char[] r12 = r0.f14320b
            char r12 = r12[r7]
            if (r12 == r9) goto L_0x040c
            r9 = 8233(0x2029, float:1.1537E-41)
            if (r12 != r9) goto L_0x03df
            goto L_0x040c
        L_0x03df:
            r9 = 93
            if (r12 < r9) goto L_0x03f3
            r9 = 127(0x7f, float:1.78E-43)
            if (r12 < r9) goto L_0x0419
            r9 = 160(0xa0, float:2.24E-43)
            if (r12 >= r9) goto L_0x0419
            if (r10 != r14) goto L_0x03ee
            r10 = r7
        L_0x03ee:
            int r5 = r5 + 1
            int r4 = r4 + 4
            goto L_0x0416
        L_0x03f3:
            int r9 = r0.f14322d
            boolean r9 = o(r12, r9)
            if (r9 == 0) goto L_0x0419
            int r5 = r5 + 1
            byte[] r3 = com.alibaba.fastjson.util.IOUtils.f14406f
            int r9 = r3.length
            if (r12 >= r9) goto L_0x0409
            byte r3 = r3[r12]
            r9 = 4
            if (r3 != r9) goto L_0x0409
            int r4 = r4 + 4
        L_0x0409:
            if (r10 != r14) goto L_0x0416
            goto L_0x0412
        L_0x040c:
            int r5 = r5 + 1
            int r4 = r4 + 4
            if (r10 != r14) goto L_0x0416
        L_0x0412:
            r10 = r7
            r17 = r10
            goto L_0x0418
        L_0x0416:
            r17 = r7
        L_0x0418:
            r3 = r12
        L_0x0419:
            int r7 = r7 + 1
            r12 = 48
            goto L_0x03d0
        L_0x041e:
            if (r5 <= 0) goto L_0x058a
            int r4 = r4 + r5
            char[] r7 = r0.f14320b
            int r7 = r7.length
            if (r4 <= r7) goto L_0x0429
            r0.l(r4)
        L_0x0429:
            r0.f14321c = r4
            if (r5 != r11) goto L_0x04db
            r1 = 50
            if (r3 != r9) goto L_0x0455
            int r3 = r17 + 1
            int r4 = r17 + 6
            int r13 = r13 - r17
            int r13 = r13 - r11
            char[] r5 = r0.f14320b
            java.lang.System.arraycopy(r5, r3, r5, r4, r13)
            char[] r4 = r0.f14320b
            r4[r17] = r8
            r4[r3] = r15
            int r3 = r3 + r11
            r4[r3] = r1
            int r3 = r3 + r11
            r5 = 48
            r4[r3] = r5
            int r3 = r3 + r11
            r4[r3] = r1
            int r3 = r3 + r11
            r1 = 56
            r4[r3] = r1
            goto L_0x058a
        L_0x0455:
            r4 = 8233(0x2029, float:1.1537E-41)
            if (r3 != r4) goto L_0x047d
            int r3 = r17 + 1
            int r4 = r17 + 6
            int r13 = r13 - r17
            int r13 = r13 - r11
            char[] r5 = r0.f14320b
            java.lang.System.arraycopy(r5, r3, r5, r4, r13)
            char[] r4 = r0.f14320b
            r4[r17] = r8
            r4[r3] = r15
            int r3 = r3 + r11
            r4[r3] = r1
            int r3 = r3 + r11
            r5 = 48
            r4[r3] = r5
            int r3 = r3 + r11
            r4[r3] = r1
            int r3 = r3 + r11
            r1 = 57
            r4[r3] = r1
            goto L_0x058a
        L_0x047d:
            byte[] r1 = com.alibaba.fastjson.util.IOUtils.f14406f
            int r4 = r1.length
            if (r3 >= r4) goto L_0x04c3
            byte r1 = r1[r3]
            r4 = 4
            if (r1 != r4) goto L_0x04c3
            int r1 = r17 + 1
            int r4 = r17 + 6
            int r13 = r13 - r17
            int r13 = r13 - r11
            char[] r5 = r0.f14320b
            java.lang.System.arraycopy(r5, r1, r5, r4, r13)
            char[] r4 = r0.f14320b
            r4[r17] = r8
            int r5 = r1 + 1
            r4[r1] = r15
            int r1 = r5 + 1
            char[] r6 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r7 = r3 >>> 12
            r7 = r7 & 15
            char r7 = r6[r7]
            r4[r5] = r7
            int r5 = r1 + 1
            int r7 = r3 >>> 8
            r7 = r7 & 15
            char r7 = r6[r7]
            r4[r1] = r7
            int r1 = r5 + 1
            int r7 = r3 >>> 4
            r7 = r7 & 15
            char r7 = r6[r7]
            r4[r5] = r7
            r3 = r3 & 15
            char r3 = r6[r3]
            r4[r1] = r3
            goto L_0x058a
        L_0x04c3:
            int r1 = r17 + 1
            int r4 = r17 + 2
            int r13 = r13 - r17
            int r13 = r13 - r11
            char[] r5 = r0.f14320b
            java.lang.System.arraycopy(r5, r1, r5, r4, r13)
            char[] r4 = r0.f14320b
            r4[r17] = r8
            char[] r5 = com.alibaba.fastjson.util.IOUtils.f14410j
            char r3 = r5[r3]
            r4[r1] = r3
            goto L_0x058a
        L_0x04db:
            if (r5 <= r11) goto L_0x058a
            int r3 = r10 - r6
        L_0x04df:
            int r4 = r19.length()
            if (r3 >= r4) goto L_0x058a
            char r4 = r1.charAt(r3)
            byte[] r5 = com.alibaba.fastjson.util.IOUtils.f14406f
            int r6 = r5.length
            if (r4 >= r6) goto L_0x04f6
            byte r6 = r5[r4]
            if (r6 != 0) goto L_0x04f3
            goto L_0x04f6
        L_0x04f3:
            r6 = 47
            goto L_0x0502
        L_0x04f6:
            r6 = 47
            if (r4 != r6) goto L_0x0544
            com.alibaba.fastjson.serializer.SerializerFeature r7 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial
            boolean r7 = r0.n(r7)
            if (r7 == 0) goto L_0x0544
        L_0x0502:
            char[] r7 = r0.f14320b
            int r12 = r10 + 1
            r7[r10] = r8
            byte r5 = r5[r4]
            r13 = 4
            if (r5 != r13) goto L_0x053a
            int r5 = r12 + 1
            r7[r12] = r15
            int r10 = r5 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r14 = r4 >>> 12
            r14 = r14 & 15
            char r14 = r12[r14]
            r7[r5] = r14
            int r5 = r10 + 1
            int r14 = r4 >>> 8
            r14 = r14 & 15
            char r14 = r12[r14]
            r7[r10] = r14
            int r10 = r5 + 1
            int r14 = r4 >>> 4
            r14 = r14 & 15
            char r14 = r12[r14]
            r7[r5] = r14
            int r5 = r10 + 1
            r4 = r4 & 15
            char r4 = r12[r4]
            r7[r10] = r4
            goto L_0x0542
        L_0x053a:
            int r5 = r12 + 1
            char[] r10 = com.alibaba.fastjson.util.IOUtils.f14410j
            char r4 = r10[r4]
            r7[r12] = r4
        L_0x0542:
            r10 = r5
            goto L_0x0586
        L_0x0544:
            r13 = 4
            if (r4 == r9) goto L_0x0554
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r4 != r5) goto L_0x054c
            goto L_0x0554
        L_0x054c:
            char[] r5 = r0.f14320b
            int r7 = r10 + 1
            r5[r10] = r4
            r10 = r7
            goto L_0x0586
        L_0x0554:
            char[] r5 = r0.f14320b
            int r7 = r10 + 1
            r5[r10] = r8
            int r10 = r7 + 1
            r5[r7] = r15
            int r7 = r10 + 1
            char[] r12 = com.alibaba.fastjson.util.IOUtils.f14403c
            int r14 = r4 >>> 12
            r14 = r14 & 15
            char r14 = r12[r14]
            r5[r10] = r14
            int r10 = r7 + 1
            int r14 = r4 >>> 8
            r14 = r14 & 15
            char r14 = r12[r14]
            r5[r7] = r14
            int r7 = r10 + 1
            int r14 = r4 >>> 4
            r14 = r14 & 15
            char r14 = r12[r14]
            r5[r10] = r14
            int r10 = r7 + 1
            r4 = r4 & 15
            char r4 = r12[r4]
            r5[r7] = r4
        L_0x0586:
            int r3 = r3 + 1
            goto L_0x04df
        L_0x058a:
            if (r2 == 0) goto L_0x059a
            char[] r1 = r0.f14320b
            int r3 = r0.f14321c
            int r4 = r3 + -2
            r5 = 34
            r1[r4] = r5
            int r3 = r3 - r11
            r1[r3] = r2
            goto L_0x05a3
        L_0x059a:
            r5 = 34
            char[] r1 = r0.f14320b
            int r2 = r0.f14321c
            int r2 = r2 - r11
            r1[r2] = r5
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.L(java.lang.String, char):void");
    }

    public void M(String str) {
        int i11 = 0;
        if (str == null) {
            int i12 = this.f14321c + 4;
            if (i12 > this.f14320b.length) {
                l(i12);
            }
            OptionsBridge.NULL_VALUE.getChars(0, 4, this.f14320b, this.f14321c);
            this.f14321c = i12;
            return;
        }
        int length = str.length();
        int i13 = this.f14321c + length + 2;
        if (i13 > this.f14320b.length) {
            if (this.f14323e != null) {
                write(39);
                while (i11 < str.length()) {
                    char charAt = str.charAt(i11);
                    if (charAt <= 13 || charAt == '\\' || charAt == '\'' || (charAt == '/' && n(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write((int) IOUtils.f14410j[charAt]);
                    } else {
                        write((int) charAt);
                    }
                    i11++;
                }
                write(39);
                return;
            }
            l(i13);
        }
        int i14 = this.f14321c;
        int i15 = i14 + 1;
        int i16 = i15 + length;
        char[] cArr = this.f14320b;
        cArr[i14] = '\'';
        str.getChars(0, length, cArr, i15);
        this.f14321c = i13;
        int i17 = -1;
        char c11 = 0;
        for (int i18 = i15; i18 < i16; i18++) {
            char c12 = this.f14320b[i18];
            if (c12 <= 13 || c12 == '\\' || c12 == '\'' || (c12 == '/' && n(SerializerFeature.WriteSlashAsSpecial))) {
                i11++;
                i17 = i18;
                c11 = c12;
            }
        }
        int i19 = i13 + i11;
        if (i19 > this.f14320b.length) {
            l(i19);
        }
        this.f14321c = i19;
        if (i11 == 1) {
            char[] cArr2 = this.f14320b;
            int i21 = i17 + 1;
            System.arraycopy(cArr2, i21, cArr2, i17 + 2, (i16 - i17) - 1);
            char[] cArr3 = this.f14320b;
            cArr3[i17] = '\\';
            cArr3[i21] = IOUtils.f14410j[c11];
        } else if (i11 > 1) {
            char[] cArr4 = this.f14320b;
            int i22 = i17 + 1;
            System.arraycopy(cArr4, i22, cArr4, i17 + 2, (i16 - i17) - 1);
            char[] cArr5 = this.f14320b;
            cArr5[i17] = '\\';
            cArr5[i22] = IOUtils.f14410j[c11];
            int i23 = i16 + 1;
            for (int i24 = i22 - 2; i24 >= i15; i24--) {
                char c13 = this.f14320b[i24];
                if (c13 <= 13 || c13 == '\\' || c13 == '\'' || (c13 == '/' && n(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f14320b;
                    int i25 = i24 + 1;
                    System.arraycopy(cArr6, i25, cArr6, i24 + 2, (i23 - i24) - 1);
                    char[] cArr7 = this.f14320b;
                    cArr7[i24] = '\\';
                    cArr7[i25] = IOUtils.f14410j[c13];
                    i23++;
                }
            }
        }
        this.f14320b[this.f14321c - 1] = '\'';
    }

    public int N(OutputStream outputStream, Charset charset) throws IOException {
        if (this.f14323e != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == f14316r) {
            return j(outputStream);
        } else {
            byte[] bytes = new String(this.f14320b, 0, this.f14321c).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
    }

    /* renamed from: a */
    public SerializeWriter append(char c11) {
        write((int) c11);
        return this;
    }

    /* renamed from: b */
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? OptionsBridge.NULL_VALUE : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void close() {
        if (this.f14323e != null && this.f14321c > 0) {
            flush();
        }
        char[] cArr = this.f14320b;
        if (cArr.length <= 65536) {
            f14317s.set(cArr);
        }
        this.f14320b = null;
    }

    /* renamed from: e */
    public SerializeWriter append(CharSequence charSequence, int i11, int i12) {
        if (charSequence == null) {
            charSequence = OptionsBridge.NULL_VALUE;
        }
        String charSequence2 = charSequence.subSequence(i11, i12).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void f() {
        int i11 = this.f14322d;
        boolean z11 = true;
        boolean z12 = (SerializerFeature.QuoteFieldNames.mask & i11) != 0;
        this.f14325g = z12;
        boolean z13 = (SerializerFeature.UseSingleQuotes.mask & i11) != 0;
        this.f14324f = z13;
        this.f14326h = (SerializerFeature.SortField.mask & i11) != 0;
        this.f14327i = (SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0;
        boolean z14 = (SerializerFeature.BeanToArray.mask & i11) != 0;
        this.f14328j = z14;
        this.f14329k = (SerializerFeature.WriteNonStringValueAsString.mask & i11) != 0;
        this.f14330l = (SerializerFeature.NotWriteDefaultValue.mask & i11) != 0;
        boolean z15 = (SerializerFeature.WriteEnumUsingName.mask & i11) != 0;
        this.f14331m = z15;
        this.f14332n = (SerializerFeature.WriteEnumUsingToString.mask & i11) != 0;
        if (!z12 || (i11 & f14319u) != 0 || (!z14 && !z15)) {
            z11 = false;
        }
        this.f14333o = z11;
        this.f14334p = z13 ? '\'' : '\"';
    }

    public void flush() {
        Writer writer = this.f14323e;
        if (writer != null) {
            try {
                writer.write(this.f14320b, 0, this.f14321c);
                this.f14323e.flush();
                this.f14321c = 0;
            } catch (IOException e11) {
                throw new JSONException(e11.getMessage(), e11);
            }
        }
    }

    public void g(SerializerFeature serializerFeature, boolean z11) {
        if (z11) {
            int mask = this.f14322d | serializerFeature.getMask();
            this.f14322d = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.f14322d = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.f14322d = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.f14322d = (~serializerFeature.getMask()) & this.f14322d;
        }
        f();
    }

    public final int j(OutputStream outputStream) throws IOException {
        int i11 = (int) (((double) this.f14321c) * 3.0d);
        ThreadLocal<byte[]> threadLocal = f14318t;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i11) {
            bArr = new byte[i11];
        }
        int g11 = IOUtils.g(this.f14320b, 0, this.f14321c, bArr);
        outputStream.write(bArr, 0, g11);
        return g11;
    }

    public final byte[] k() {
        int i11 = (int) (((double) this.f14321c) * 3.0d);
        ThreadLocal<byte[]> threadLocal = f14318t;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i11) {
            bArr = new byte[i11];
        }
        int g11 = IOUtils.g(this.f14320b, 0, this.f14321c, bArr);
        byte[] bArr2 = new byte[g11];
        System.arraycopy(bArr, 0, bArr2, 0, g11);
        return bArr2;
    }

    public void l(int i11) {
        int i12 = this.f14335q;
        if (i12 == -1 || i11 < i12) {
            char[] cArr = this.f14320b;
            int length = ((cArr.length * 3) / 2) + 1;
            if (length >= i11) {
                i11 = length;
            }
            char[] cArr2 = new char[i11];
            System.arraycopy(cArr, 0, cArr2, 0, this.f14321c);
            this.f14320b = cArr2;
            return;
        }
        throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.f14335q + ", minimumCapacity=" + i11);
    }

    public boolean m(int i11) {
        return (i11 & this.f14322d) != 0;
    }

    public boolean n(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.f14322d) != 0;
    }

    public byte[] p(Charset charset) {
        if (this.f14323e != null) {
            throw new UnsupportedOperationException("writer not null");
        } else if (charset == f14316r) {
            return k();
        } else {
            return new String(this.f14320b, 0, this.f14321c).getBytes(charset);
        }
    }

    public void r(boolean z11) {
        if (z11) {
            write("true");
        } else {
            write(d.f31895b);
        }
    }

    public void s(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (m(SerializerFeature.WriteClassName.mask)) {
            D(bArr);
            return;
        }
        int length = bArr2.length;
        boolean z11 = this.f14324f;
        char c11 = z11 ? '\'' : '\"';
        if (length == 0) {
            write(z11 ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.f14416p;
        int i11 = (length / 3) * 3;
        int i12 = length - 1;
        int i13 = this.f14321c;
        int i14 = (((i12 / 3) + 1) << 2) + i13 + 2;
        int i15 = 0;
        if (i14 > this.f14320b.length) {
            if (this.f14323e != null) {
                write((int) c11);
                int i16 = 0;
                while (i16 < i11) {
                    int i17 = i16 + 1;
                    int i18 = i17 + 1;
                    byte b11 = ((bArr2[i16] & 255) << 16) | ((bArr2[i17] & 255) << 8) | (bArr2[i18] & 255);
                    write((int) cArr[(b11 >>> 18) & 63]);
                    write((int) cArr[(b11 >>> 12) & 63]);
                    write((int) cArr[(b11 >>> 6) & 63]);
                    write((int) cArr[b11 & Utf8.REPLACEMENT_BYTE]);
                    i16 = i18 + 1;
                }
                int i19 = length - i11;
                if (i19 > 0) {
                    int i21 = (bArr2[i11] & 255) << 10;
                    if (i19 == 2) {
                        i15 = (bArr2[i12] & 255) << 2;
                    }
                    int i22 = i21 | i15;
                    write((int) cArr[i22 >> 12]);
                    write((int) cArr[(i22 >>> 6) & 63]);
                    write((int) i19 == 2 ? cArr[i22 & 63] : '=');
                    write(61);
                }
                write((int) c11);
                return;
            }
            l(i14);
        }
        this.f14321c = i14;
        int i23 = i13 + 1;
        this.f14320b[i13] = c11;
        int i24 = 0;
        while (i24 < i11) {
            int i25 = i24 + 1;
            int i26 = i25 + 1;
            byte b12 = ((bArr2[i24] & 255) << 16) | ((bArr2[i25] & 255) << 8);
            int i27 = i26 + 1;
            byte b13 = b12 | (bArr2[i26] & 255);
            char[] cArr2 = this.f14320b;
            int i28 = i23 + 1;
            cArr2[i23] = cArr[(b13 >>> 18) & 63];
            int i29 = i28 + 1;
            cArr2[i28] = cArr[(b13 >>> 12) & 63];
            int i30 = i29 + 1;
            cArr2[i29] = cArr[(b13 >>> 6) & 63];
            i23 = i30 + 1;
            cArr2[i30] = cArr[b13 & Utf8.REPLACEMENT_BYTE];
            i24 = i27;
        }
        int i31 = length - i11;
        if (i31 > 0) {
            int i32 = (bArr2[i11] & 255) << 10;
            if (i31 == 2) {
                i15 = (bArr2[i12] & 255) << 2;
            }
            int i33 = i32 | i15;
            char[] cArr3 = this.f14320b;
            cArr3[i14 - 5] = cArr[i33 >> 12];
            cArr3[i14 - 4] = cArr[(i33 >>> 6) & 63];
            cArr3[i14 - 3] = i31 == 2 ? cArr[i33 & 63] : '=';
            cArr3[i14 - 2] = '=';
        }
        this.f14320b[i14 - 1] = c11;
    }

    public void t(double d11, boolean z11) {
        if (Double.isNaN(d11) || Double.isInfinite(d11)) {
            H();
            return;
        }
        String d12 = Double.toString(d11);
        if (n(SerializerFeature.WriteNullNumberAsZero) && d12.endsWith(".0")) {
            d12 = d12.substring(0, d12.length() - 2);
        }
        write(d12);
        if (z11 && n(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public String toString() {
        return new String(this.f14320b, 0, this.f14321c);
    }

    public void u(Enum<?> enumR) {
        if (enumR == null) {
            H();
            return;
        }
        String str = null;
        if (this.f14331m && !this.f14332n) {
            str = enumR.name();
        } else if (this.f14332n) {
            str = enumR.toString();
        }
        if (str != null) {
            int i11 = n(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i11);
            write(str);
            write(i11);
            return;
        }
        E(enumR.ordinal());
    }

    public void v(String str) {
        w(str, false);
    }

    public void w(String str, boolean z11) {
        if (str == null) {
            write("null:");
        } else if (this.f14324f) {
            if (this.f14325g) {
                M(str);
                write(58);
                return;
            }
            F(str);
        } else if (this.f14325g) {
            L(str, ':');
        } else {
            boolean z12 = true;
            boolean z13 = str.length() == 0;
            int i11 = 0;
            while (true) {
                if (i11 >= str.length()) {
                    z12 = z13;
                    break;
                } else if (o(str.charAt(i11), 0)) {
                    break;
                } else {
                    i11++;
                }
            }
            if (z12) {
                L(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    public void write(int i11) {
        int i12 = 1;
        int i13 = this.f14321c + 1;
        if (i13 > this.f14320b.length) {
            if (this.f14323e == null) {
                l(i13);
            } else {
                flush();
                this.f14320b[this.f14321c] = (char) i11;
                this.f14321c = i12;
            }
        }
        i12 = i13;
        this.f14320b[this.f14321c] = (char) i11;
        this.f14321c = i12;
    }

    public void x(char c11, String str, double d11) {
        write((int) c11);
        v(str);
        t(d11, false);
    }

    public void y(char c11, String str, int i11) {
        if (i11 == Integer.MIN_VALUE || !this.f14325g) {
            write((int) c11);
            v(str);
            E(i11);
            return;
        }
        int n11 = i11 < 0 ? IOUtils.n(-i11) + 1 : IOUtils.n(i11);
        int length = str.length();
        int i12 = this.f14321c + length + 4 + n11;
        if (i12 > this.f14320b.length) {
            if (this.f14323e != null) {
                write((int) c11);
                v(str);
                E(i11);
                return;
            }
            l(i12);
        }
        int i13 = this.f14321c;
        this.f14321c = i12;
        char[] cArr = this.f14320b;
        cArr[i13] = c11;
        int i14 = i13 + length + 1;
        cArr[i13 + 1] = this.f14334p;
        str.getChars(0, length, cArr, i13 + 2);
        char[] cArr2 = this.f14320b;
        cArr2[i14 + 1] = this.f14334p;
        cArr2[i14 + 2] = ':';
        IOUtils.i(i11, this.f14321c, cArr2);
    }

    public void z(char c11, String str, long j11) {
        if (j11 == Long.MIN_VALUE || !this.f14325g) {
            write((int) c11);
            v(str);
            G(j11);
            return;
        }
        int o11 = j11 < 0 ? IOUtils.o(-j11) + 1 : IOUtils.o(j11);
        int length = str.length();
        int i11 = this.f14321c + length + 4 + o11;
        if (i11 > this.f14320b.length) {
            if (this.f14323e != null) {
                write((int) c11);
                v(str);
                G(j11);
                return;
            }
            l(i11);
        }
        int i12 = this.f14321c;
        this.f14321c = i11;
        char[] cArr = this.f14320b;
        cArr[i12] = c11;
        int i13 = i12 + length + 1;
        cArr[i12 + 1] = this.f14334p;
        str.getChars(0, length, cArr, i12 + 2);
        char[] cArr2 = this.f14320b;
        cArr2[i13 + 1] = this.f14334p;
        cArr2[i13 + 2] = ':';
        IOUtils.j(j11, this.f14321c, cArr2);
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public SerializeWriter(Writer writer, int i11, SerializerFeature... serializerFeatureArr) {
        this.f14335q = -1;
        this.f14323e = writer;
        ThreadLocal<char[]> threadLocal = f14317s;
        char[] cArr = threadLocal.get();
        this.f14320b = cArr;
        if (cArr != null) {
            threadLocal.set((Object) null);
        } else {
            this.f14320b = new char[2048];
        }
        for (SerializerFeature mask : serializerFeatureArr) {
            i11 |= mask.getMask();
        }
        this.f14322d = i11;
        f();
    }

    public void write(char[] cArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > cArr.length || i12 < 0 || (i13 = i11 + i12) > cArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i12 != 0) {
            int i14 = this.f14321c + i12;
            if (i14 > this.f14320b.length) {
                if (this.f14323e == null) {
                    l(i14);
                } else {
                    do {
                        char[] cArr2 = this.f14320b;
                        int length = cArr2.length;
                        int i15 = this.f14321c;
                        int i16 = length - i15;
                        System.arraycopy(cArr, i11, cArr2, i15, i16);
                        this.f14321c = this.f14320b.length;
                        flush();
                        i12 -= i16;
                        i11 += i16;
                    } while (i12 > this.f14320b.length);
                    i14 = i12;
                }
            }
            System.arraycopy(cArr, i11, this.f14320b, this.f14321c, i12);
            this.f14321c = i14;
        }
    }

    public void write(String str, int i11, int i12) {
        int i13;
        int i14 = this.f14321c + i12;
        if (i14 > this.f14320b.length) {
            if (this.f14323e == null) {
                l(i14);
            } else {
                while (true) {
                    char[] cArr = this.f14320b;
                    int length = cArr.length;
                    int i15 = this.f14321c;
                    int i16 = length - i15;
                    i13 = i11 + i16;
                    str.getChars(i11, i13, cArr, i15);
                    this.f14321c = this.f14320b.length;
                    flush();
                    i12 -= i16;
                    if (i12 <= this.f14320b.length) {
                        break;
                    }
                    i11 = i13;
                }
                i14 = i12;
                i11 = i13;
            }
        }
        str.getChars(i11, i12 + i11, this.f14320b, this.f14321c);
        this.f14321c = i14;
    }

    public void write(String str) {
        if (str == null) {
            H();
        } else {
            write(str, 0, str.length());
        }
    }
}
