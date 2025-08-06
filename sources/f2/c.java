package f2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.util.IOUtils;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import okio.internal.Buffer;

public abstract class c implements b, Closeable {

    /* renamed from: q  reason: collision with root package name */
    public static final ThreadLocal<char[]> f15715q = new ThreadLocal<>();

    /* renamed from: r  reason: collision with root package name */
    public static final char[] f15716r = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f15717s = new int[103];

    /* renamed from: b  reason: collision with root package name */
    public int f15718b;

    /* renamed from: c  reason: collision with root package name */
    public int f15719c;

    /* renamed from: d  reason: collision with root package name */
    public int f15720d;

    /* renamed from: e  reason: collision with root package name */
    public char f15721e;

    /* renamed from: f  reason: collision with root package name */
    public int f15722f;

    /* renamed from: g  reason: collision with root package name */
    public int f15723g;

    /* renamed from: h  reason: collision with root package name */
    public char[] f15724h;

    /* renamed from: i  reason: collision with root package name */
    public int f15725i;

    /* renamed from: j  reason: collision with root package name */
    public int f15726j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f15727k;

    /* renamed from: l  reason: collision with root package name */
    public Calendar f15728l = null;

    /* renamed from: m  reason: collision with root package name */
    public TimeZone f15729m = JSON.defaultTimeZone;

    /* renamed from: n  reason: collision with root package name */
    public Locale f15730n = JSON.defaultLocale;

    /* renamed from: o  reason: collision with root package name */
    public int f15731o = 0;

    /* renamed from: p  reason: collision with root package name */
    public String f15732p = null;

    static {
        for (int i11 = 48; i11 <= 57; i11++) {
            f15717s[i11] = i11 - 48;
        }
        for (int i12 = 97; i12 <= 102; i12++) {
            f15717s[i12] = (i12 - 97) + 10;
        }
        for (int i13 = 65; i13 <= 70; i13++) {
            f15717s[i13] = (i13 - 65) + 10;
        }
    }

    public c(int i11) {
        this.f15720d = i11;
        if ((i11 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.f15732p = "";
        }
        char[] cArr = f15715q.get();
        this.f15724h = cArr;
        if (cArr == null) {
            this.f15724h = new char[512];
        }
    }

    public static boolean X(char c11) {
        return c11 <= ' ' && (c11 == ' ' || c11 == 10 || c11 == 13 || c11 == 9 || c11 == 12 || c11 == 8);
    }

    public static String d0(char[] cArr, int i11) {
        int i12;
        int i13;
        char[] cArr2 = new char[i11];
        int i14 = 0;
        int i15 = 0;
        while (i12 < i11) {
            char c11 = cArr[i12];
            if (c11 != '\\') {
                cArr2[i15] = c11;
                i15++;
            } else {
                i12++;
                char c12 = cArr[i12];
                if (c12 == '\"') {
                    i13 = i15 + 1;
                    cArr2[i15] = '\"';
                } else if (c12 != '\'') {
                    if (c12 != 'F') {
                        if (c12 == '\\') {
                            i13 = i15 + 1;
                            cArr2[i15] = '\\';
                        } else if (c12 == 'b') {
                            i13 = i15 + 1;
                            cArr2[i15] = 8;
                        } else if (c12 != 'f') {
                            if (c12 == 'n') {
                                i13 = i15 + 1;
                                cArr2[i15] = 10;
                            } else if (c12 == 'r') {
                                i13 = i15 + 1;
                                cArr2[i15] = 13;
                            } else if (c12 != 'x') {
                                switch (c12) {
                                    case '/':
                                        i13 = i15 + 1;
                                        cArr2[i15] = '/';
                                        break;
                                    case '0':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 0;
                                        break;
                                    case '1':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 1;
                                        break;
                                    case '2':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 2;
                                        break;
                                    case '3':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 3;
                                        break;
                                    case '4':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 4;
                                        break;
                                    case '5':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 5;
                                        break;
                                    case '6':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 6;
                                        break;
                                    case '7':
                                        i13 = i15 + 1;
                                        cArr2[i15] = 7;
                                        break;
                                    default:
                                        switch (c12) {
                                            case 't':
                                                i13 = i15 + 1;
                                                cArr2[i15] = 9;
                                                break;
                                            case 'u':
                                                i13 = i15 + 1;
                                                int i16 = i12 + 1;
                                                int i17 = i16 + 1;
                                                int i18 = i17 + 1;
                                                i12 = i18 + 1;
                                                cArr2[i15] = (char) Integer.parseInt(new String(new char[]{cArr[i16], cArr[i17], cArr[i18], cArr[i12]}), 16);
                                                break;
                                            case 'v':
                                                i13 = i15 + 1;
                                                cArr2[i15] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i13 = i15 + 1;
                                int[] iArr = f15717s;
                                int i19 = i12 + 1;
                                i12 = i19 + 1;
                                cArr2[i15] = (char) ((iArr[cArr[i19]] * 16) + iArr[cArr[i12]]);
                            }
                        }
                    }
                    i13 = i15 + 1;
                    cArr2[i15] = 12;
                } else {
                    i13 = i15 + 1;
                    cArr2[i15] = '\'';
                }
                i15 = i13;
            }
            i14 = i12 + 1;
        }
        return new String(cArr2, 0, i15);
    }

    public final char A() {
        return this.f15721e;
    }

    public final void B() {
        b0(':');
    }

    public final String C(g gVar) {
        boolean z11 = false;
        if (this.f15718b == 1 && this.f15719c == 0 && this.f15722f == 1) {
            this.f15722f = 0;
        }
        boolean[] zArr = IOUtils.f14404d;
        int i11 = this.f15721e;
        if (i11 >= zArr.length || zArr[i11]) {
            z11 = true;
        }
        if (z11) {
            boolean[] zArr2 = IOUtils.f14405e;
            this.f15726j = this.f15722f;
            this.f15725i = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i11 = (i11 * 31) + next;
                this.f15725i++;
            }
            this.f15721e = R(this.f15722f);
            this.f15718b = 18;
            if (this.f15725i == 4 && i11 == 3392903 && R(this.f15726j) == 'n' && R(this.f15726j + 1) == 'u' && R(this.f15726j + 2) == 'l' && R(this.f15726j + 3) == 'l') {
                return null;
            }
            if (gVar == null) {
                return x0(this.f15726j, this.f15725i);
            }
            return O(this.f15726j, this.f15725i, i11, gVar);
        }
        throw new JSONException("illegal identifier : " + this.f15721e + t());
    }

    public final boolean D() {
        if (this.f15725i == 4 && R(this.f15726j + 1) == '$' && R(this.f15726j + 2) == 'r' && R(this.f15726j + 3) == 'e' && R(this.f15726j + 4) == 'f') {
            return true;
        }
        return false;
    }

    public boolean E() {
        int i11 = 0;
        while (true) {
            char R = R(i11);
            if (R == 26) {
                this.f15718b = 20;
                return true;
            } else if (!X(R)) {
                return false;
            } else {
                i11++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean F(char r10) {
        /*
            r9 = this;
            r0 = 0
            r9.f15731o = r0
            int r1 = r9.f15722f
            int r1 = r1 + r0
            char r1 = r9.R(r1)
            r2 = 3
            r3 = 5
            r4 = 101(0x65, float:1.42E-43)
            r5 = -1
            r6 = 2
            r7 = 1
            r8 = 116(0x74, float:1.63E-43)
            if (r1 != r8) goto L_0x0042
            int r1 = r9.f15722f
            int r1 = r1 + r7
            char r1 = r9.R(r1)
            r8 = 114(0x72, float:1.6E-43)
            if (r1 != r8) goto L_0x003f
            int r1 = r9.f15722f
            int r1 = r1 + r7
            int r1 = r1 + r7
            char r1 = r9.R(r1)
            r8 = 117(0x75, float:1.64E-43)
            if (r1 != r8) goto L_0x003f
            int r1 = r9.f15722f
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r9.R(r1)
            if (r1 != r4) goto L_0x003f
            int r0 = r9.f15722f
            int r0 = r0 + 4
            char r1 = r9.R(r0)
            goto L_0x008b
        L_0x003f:
            r9.f15731o = r5
            return r0
        L_0x0042:
            r8 = 102(0x66, float:1.43E-43)
            if (r1 != r8) goto L_0x007f
            int r1 = r9.f15722f
            int r1 = r1 + r7
            char r1 = r9.R(r1)
            r8 = 97
            if (r1 != r8) goto L_0x007c
            int r1 = r9.f15722f
            int r1 = r1 + r7
            int r1 = r1 + r7
            char r1 = r9.R(r1)
            r8 = 108(0x6c, float:1.51E-43)
            if (r1 != r8) goto L_0x007c
            int r1 = r9.f15722f
            int r1 = r1 + r7
            int r1 = r1 + r6
            char r1 = r9.R(r1)
            r6 = 115(0x73, float:1.61E-43)
            if (r1 != r6) goto L_0x007c
            int r1 = r9.f15722f
            int r1 = r1 + r7
            int r1 = r1 + r2
            char r1 = r9.R(r1)
            if (r1 != r4) goto L_0x007c
            int r1 = r9.f15722f
            r4 = 6
            int r1 = r1 + r3
            char r1 = r9.R(r1)
            goto L_0x00ba
        L_0x007c:
            r9.f15731o = r5
            return r0
        L_0x007f:
            r3 = 49
            if (r1 != r3) goto L_0x008d
            int r0 = r9.f15722f
            int r0 = r0 + r7
            char r1 = r9.R(r0)
            r3 = r6
        L_0x008b:
            r0 = r7
            goto L_0x009b
        L_0x008d:
            r3 = 48
            if (r1 != r3) goto L_0x009a
            int r1 = r9.f15722f
            int r1 = r1 + r7
            char r1 = r9.R(r1)
            r3 = r6
            goto L_0x009b
        L_0x009a:
            r3 = r7
        L_0x009b:
            if (r1 != r10) goto L_0x00ab
            int r10 = r9.f15722f
            int r10 = r10 + r3
            r9.f15722f = r10
            char r10 = r9.R(r10)
            r9.f15721e = r10
            r9.f15731o = r2
            return r0
        L_0x00ab:
            boolean r1 = X(r1)
            if (r1 == 0) goto L_0x00bc
            int r1 = r9.f15722f
            int r4 = r3 + 1
            int r1 = r1 + r3
            char r1 = r9.R(r1)
        L_0x00ba:
            r3 = r4
            goto L_0x009b
        L_0x00bc:
            r9.f15731o = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.F(char):boolean");
    }

    public abstract BigDecimal G();

    public abstract String H();

    public final Number I() throws NumberFormatException {
        long j11;
        long j12;
        boolean z11 = false;
        if (this.f15726j == -1) {
            this.f15726j = 0;
        }
        int i11 = this.f15726j;
        int i12 = this.f15725i + i11;
        char c11 = ' ';
        char R = R(i12 - 1);
        if (R == 'B') {
            i12--;
            c11 = 'B';
        } else if (R == 'L') {
            i12--;
            c11 = 'L';
        } else if (R == 'S') {
            i12--;
            c11 = 'S';
        }
        if (R(this.f15726j) == '-') {
            j11 = Long.MIN_VALUE;
            i11++;
            z11 = true;
        } else {
            j11 = -9223372036854775807L;
        }
        long j13 = Buffer.OVERFLOW_ZONE;
        if (i11 < i12) {
            j12 = (long) (-(R(i11) - '0'));
            i11++;
        } else {
            j12 = 0;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            int R2 = R(i11) - '0';
            if (j12 < j13) {
                return new BigInteger(N());
            }
            long j14 = j12 * 10;
            long j15 = (long) R2;
            if (j14 < j11 + j15) {
                return new BigInteger(N());
            }
            j12 = j14 - j15;
            i11 = i13;
            j13 = Buffer.OVERFLOW_ZONE;
        }
        if (!z11) {
            long j16 = -j12;
            if (j16 > 2147483647L || c11 == 'L') {
                return Long.valueOf(j16);
            }
            if (c11 == 'S') {
                return Short.valueOf((short) ((int) j16));
            }
            if (c11 == 'B') {
                return Byte.valueOf((byte) ((int) j16));
            }
            return Integer.valueOf((int) j16);
        } else if (i11 <= this.f15726j + 1) {
            throw new NumberFormatException(N());
        } else if (j12 < -2147483648L || c11 == 'L') {
            return Long.valueOf(j12);
        } else {
            if (c11 == 'S') {
                return Short.valueOf((short) ((int) j12));
            }
            if (c11 == 'B') {
                return Byte.valueOf((byte) ((int) j12));
            }
            return Integer.valueOf((int) j12);
        }
    }

    public final int J() {
        return this.f15718b;
    }

    public final void K() {
        this.f15725i = 0;
    }

    public final String L(g gVar) {
        p();
        char c11 = this.f15721e;
        if (c11 == '\"') {
            return o(gVar, '\"');
        }
        if (c11 == '\'') {
            if (a(Feature.AllowSingleQuotes)) {
                return o(gVar, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c11 == '}') {
            next();
            this.f15718b = 13;
            return null;
        } else if (c11 == ',') {
            next();
            this.f15718b = 16;
            return null;
        } else if (c11 == 26) {
            this.f15718b = 20;
            return null;
        } else if (a(Feature.AllowUnQuotedFieldNames)) {
            return C(gVar);
        } else {
            throw new JSONException("syntax error");
        }
    }

    public final Number M(boolean z11) {
        char R = R((this.f15726j + this.f15725i) - 1);
        if (R == 'F') {
            try {
                return Float.valueOf(Float.parseFloat(N()));
            } catch (NumberFormatException e11) {
                throw new JSONException(e11.getMessage() + ", " + t());
            }
        } else if (R == 'D') {
            return Double.valueOf(Double.parseDouble(N()));
        } else {
            if (z11) {
                return G();
            }
            return Double.valueOf(T());
        }
    }

    public abstract String N();

    public abstract String O(int i11, int i12, int i13, g gVar);

    public abstract void P(int i11, char[] cArr, int i12, int i13);

    public abstract boolean Q(char[] cArr);

    public abstract char R(int i11);

    public abstract void S(int i11, int i12, char[] cArr);

    public double T() {
        return Double.parseDouble(N());
    }

    public Calendar U() {
        return this.f15728l;
    }

    public abstract int V(char c11, int i11);

    public abstract boolean W();

    public void Y(String str, Object... objArr) {
        this.f15718b = 1;
    }

    public final boolean Z(char[] cArr) {
        if (!Q(cArr)) {
            return false;
        }
        int length = this.f15722f + cArr.length;
        this.f15722f = length;
        char R = R(length);
        this.f15721e = R;
        if (R == '{') {
            next();
            this.f15718b = 12;
        } else if (R == '[') {
            next();
            this.f15718b = 14;
        } else if (R == 'S' && R(this.f15722f + 1) == 'e' && R(this.f15722f + 2) == 't' && R(this.f15722f + 3) == '[') {
            int i11 = this.f15722f + 3;
            this.f15722f = i11;
            this.f15721e = R(i11);
            this.f15718b = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public final boolean a(Feature feature) {
        return isEnabled(feature.mask);
    }

    public final void a0() {
        while (X(this.f15721e)) {
            next();
        }
        char c11 = this.f15721e;
        if (c11 == '_' || Character.isLetter(c11)) {
            q0();
        } else {
            nextToken();
        }
    }

    public final String b() {
        return JSONToken.a(this.f15718b);
    }

    public final void b0(char c11) {
        this.f15725i = 0;
        while (true) {
            char c12 = this.f15721e;
            if (c12 == c11) {
                next();
                nextToken();
                return;
            } else if (c12 == ' ' || c12 == 10 || c12 == 13 || c12 == 9 || c12 == 12 || c12 == 8) {
                next();
            } else {
                throw new JSONException("not match " + c11 + " - " + this.f15721e + ", info : " + t());
            }
        }
    }

    public final void c0(char c11) {
        int i11 = this.f15725i;
        char[] cArr = this.f15724h;
        if (i11 == cArr.length) {
            char[] cArr2 = new char[(cArr.length * 2)];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.f15724h = cArr2;
        }
        char[] cArr3 = this.f15724h;
        int i12 = this.f15725i;
        this.f15725i = i12 + 1;
        cArr3[i12] = c11;
    }

    public void close() {
        char[] cArr = this.f15724h;
        if (cArr.length <= 8192) {
            f15715q.set(cArr);
        }
        this.f15724h = null;
    }

    public final void e() {
        this.f15726j = this.f15722f;
        this.f15727k = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.f15718b = 4;
                this.f15721e = next();
                return;
            } else if (next == 26) {
                if (!W()) {
                    c0(26);
                } else {
                    throw new JSONException("unclosed string : " + next);
                }
            } else if (next == '\\') {
                if (!this.f15727k) {
                    this.f15727k = true;
                    int i11 = this.f15725i;
                    char[] cArr = this.f15724h;
                    if (i11 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i11 <= length) {
                            i11 = length;
                        }
                        char[] cArr2 = new char[i11];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f15724h = cArr2;
                    }
                    S(this.f15726j + 1, this.f15725i, this.f15724h);
                }
                char next2 = next();
                if (next2 == '\"') {
                    c0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            c0('\\');
                        } else if (next2 == 'b') {
                            c0(8);
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                c0(10);
                            } else if (next2 == 'r') {
                                c0(13);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        c0('/');
                                        break;
                                    case '0':
                                        c0(0);
                                        break;
                                    case '1':
                                        c0(1);
                                        break;
                                    case '2':
                                        c0(2);
                                        break;
                                    case '3':
                                        c0(3);
                                        break;
                                    case '4':
                                        c0(4);
                                        break;
                                    case '5':
                                        c0(5);
                                        break;
                                    case '6':
                                        c0(6);
                                        break;
                                    case '7':
                                        c0(7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                c0(9);
                                                break;
                                            case 'u':
                                                c0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                c0(11);
                                                break;
                                            default:
                                                this.f15721e = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = f15717s;
                                c0((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    c0(12);
                } else {
                    c0('\'');
                }
            } else if (!this.f15727k) {
                this.f15725i++;
            } else {
                int i12 = this.f15725i;
                char[] cArr3 = this.f15724h;
                if (i12 == cArr3.length) {
                    c0(next);
                } else {
                    this.f15725i = i12 + 1;
                    cArr3[i12] = next;
                }
            }
        }
    }

    public final void e0() {
        if (this.f15721e == 'f') {
            next();
            if (this.f15721e == 'a') {
                next();
                if (this.f15721e == 'l') {
                    next();
                    if (this.f15721e == 's') {
                        next();
                        if (this.f15721e == 'e') {
                            next();
                            char c11 = this.f15721e;
                            if (c11 == ' ' || c11 == ',' || c11 == '}' || c11 == ']' || c11 == 10 || c11 == 13 || c11 == 9 || c11 == 26 || c11 == 12 || c11 == 8 || c11 == ':' || c11 == '/') {
                                this.f15718b = 7;
                                return;
                            }
                            throw new JSONException("scan false error");
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public final void f(int i11) {
        this.f15725i = 0;
        while (true) {
            if (i11 == 2) {
                char c11 = this.f15721e;
                if (c11 >= '0' && c11 <= '9') {
                    this.f15719c = this.f15722f;
                    x();
                    return;
                } else if (c11 == '\"') {
                    this.f15719c = this.f15722f;
                    e();
                    return;
                } else if (c11 == '[') {
                    this.f15718b = 14;
                    next();
                    return;
                } else if (c11 == '{') {
                    this.f15718b = 12;
                    next();
                    return;
                }
            } else if (i11 == 4) {
                char c12 = this.f15721e;
                if (c12 == '\"') {
                    this.f15719c = this.f15722f;
                    e();
                    return;
                } else if (c12 >= '0' && c12 <= '9') {
                    this.f15719c = this.f15722f;
                    x();
                    return;
                } else if (c12 == '[') {
                    this.f15718b = 14;
                    next();
                    return;
                } else if (c12 == '{') {
                    this.f15718b = 12;
                    next();
                    return;
                }
            } else if (i11 == 12) {
                char c13 = this.f15721e;
                if (c13 == '{') {
                    this.f15718b = 12;
                    next();
                    return;
                } else if (c13 == '[') {
                    this.f15718b = 14;
                    next();
                    return;
                }
            } else if (i11 != 18) {
                if (i11 != 20) {
                    switch (i11) {
                        case 14:
                            char c14 = this.f15721e;
                            if (c14 == '[') {
                                this.f15718b = 14;
                                next();
                                return;
                            } else if (c14 == '{') {
                                this.f15718b = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.f15721e == ']') {
                                this.f15718b = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c15 = this.f15721e;
                            if (c15 == ',') {
                                this.f15718b = 16;
                                next();
                                return;
                            } else if (c15 == '}') {
                                this.f15718b = 13;
                                next();
                                return;
                            } else if (c15 == ']') {
                                this.f15718b = 15;
                                next();
                                return;
                            } else if (c15 == 26) {
                                this.f15718b = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.f15721e == 26) {
                    this.f15718b = 20;
                    return;
                }
            } else {
                a0();
                return;
            }
            char c16 = this.f15721e;
            if (c16 == ' ' || c16 == 10 || c16 == 13 || c16 == 9 || c16 == 12 || c16 == 8) {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public boolean f0(char[] cArr) {
        boolean z11;
        int i11;
        this.f15731o = 0;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return false;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char R = R(this.f15722f + length);
        if (R == 't') {
            int i13 = i12 + 1;
            if (R(this.f15722f + i12) != 'r') {
                this.f15731o = -1;
                return false;
            }
            int i14 = i13 + 1;
            if (R(this.f15722f + i13) != 'u') {
                this.f15731o = -1;
                return false;
            }
            i11 = i14 + 1;
            if (R(this.f15722f + i14) != 'e') {
                this.f15731o = -1;
                return false;
            }
            z11 = true;
        } else if (R == 'f') {
            int i15 = i12 + 1;
            if (R(this.f15722f + i12) != 'a') {
                this.f15731o = -1;
                return false;
            }
            int i16 = i15 + 1;
            if (R(this.f15722f + i15) != 'l') {
                this.f15731o = -1;
                return false;
            }
            int i17 = i16 + 1;
            if (R(this.f15722f + i16) != 's') {
                this.f15731o = -1;
                return false;
            }
            int i18 = i17 + 1;
            if (R(this.f15722f + i17) != 'e') {
                this.f15731o = -1;
                return false;
            }
            z11 = false;
            i11 = i18;
        } else {
            this.f15731o = -1;
            return false;
        }
        int i19 = i11 + 1;
        char R2 = R(this.f15722f + i11);
        if (R2 == ',') {
            int i21 = this.f15722f + i19;
            this.f15722f = i21;
            this.f15721e = R(i21);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11;
        } else if (R2 == '}') {
            int i22 = i19 + 1;
            char R3 = R(this.f15722f + i19);
            if (R3 == ',') {
                this.f15718b = 16;
                int i23 = this.f15722f + i22;
                this.f15722f = i23;
                this.f15721e = R(i23);
            } else if (R3 == ']') {
                this.f15718b = 15;
                int i24 = this.f15722f + i22;
                this.f15722f = i24;
                this.f15721e = R(i24);
            } else if (R3 == '}') {
                this.f15718b = 13;
                int i25 = this.f15722f + i22;
                this.f15722f = i25;
                this.f15721e = R(i25);
            } else if (R3 == 26) {
                this.f15718b = 20;
                this.f15722f += i22 - 1;
                this.f15721e = 26;
            } else {
                this.f15731o = -1;
                return false;
            }
            this.f15731o = 4;
            return z11;
        } else {
            this.f15731o = -1;
            return false;
        }
    }

    public int g(char c11) {
        int i11;
        char R;
        this.f15731o = 0;
        char R2 = R(this.f15722f + 0);
        int i12 = 1;
        boolean z11 = R2 == '-';
        if (z11) {
            R2 = R(this.f15722f + 1);
            i12 = 2;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        int i13 = R2 - '0';
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                i13 = (i13 * 10) + (R - '0');
                i12 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if (i13 < 0) {
            this.f15731o = -1;
            return 0;
        } else {
            while (R != c11) {
                if (X(R)) {
                    i11++;
                    R = R(this.f15722f + i11);
                } else {
                    this.f15731o = -1;
                    return z11 ? -i13 : i13;
                }
            }
            int i14 = this.f15722f + i11;
            this.f15722f = i14;
            this.f15721e = R(i14);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11 ? -i13 : i13;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final double g0(char[] r11) {
        /*
            r10 = this;
            r0 = 0
            r10.f15731o = r0
            boolean r0 = r10.Q(r11)
            r1 = 0
            if (r0 != 0) goto L_0x000f
            r11 = -2
            r10.f15731o = r11
            return r1
        L_0x000f:
            int r0 = r11.length
            int r3 = r10.f15722f
            int r4 = r0 + 1
            int r3 = r3 + r0
            char r0 = r10.R(r3)
            r3 = -1
            r5 = 48
            if (r0 < r5) goto L_0x010c
            r6 = 57
            if (r0 > r6) goto L_0x010c
        L_0x0022:
            int r0 = r10.f15722f
            int r7 = r4 + 1
            int r0 = r0 + r4
            char r0 = r10.R(r0)
            if (r0 < r5) goto L_0x0031
            if (r0 > r6) goto L_0x0031
            r4 = r7
            goto L_0x0022
        L_0x0031:
            r4 = 46
            if (r0 != r4) goto L_0x0054
            int r0 = r10.f15722f
            int r4 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.R(r0)
            if (r0 < r5) goto L_0x0051
            if (r0 > r6) goto L_0x0051
        L_0x0042:
            int r0 = r10.f15722f
            int r7 = r4 + 1
            int r0 = r0 + r4
            char r0 = r10.R(r0)
            if (r0 < r5) goto L_0x0054
            if (r0 > r6) goto L_0x0054
            r4 = r7
            goto L_0x0042
        L_0x0051:
            r10.f15731o = r3
            return r1
        L_0x0054:
            r4 = 101(0x65, float:1.42E-43)
            if (r0 == r4) goto L_0x005c
            r4 = 69
            if (r0 != r4) goto L_0x0087
        L_0x005c:
            int r0 = r10.f15722f
            int r4 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.R(r0)
            r7 = 43
            if (r0 == r7) goto L_0x0070
            r7 = 45
            if (r0 != r7) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r7 = r4
            goto L_0x0079
        L_0x0070:
            int r0 = r10.f15722f
            int r7 = r4 + 1
            int r0 = r0 + r4
            char r0 = r10.R(r0)
        L_0x0079:
            if (r0 < r5) goto L_0x0087
            if (r0 > r6) goto L_0x0087
            int r0 = r10.f15722f
            int r4 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.R(r0)
            goto L_0x006e
        L_0x0087:
            int r4 = r10.f15722f
            int r11 = r11.length
            int r11 = r11 + r4
            int r4 = r4 + r7
            int r4 = r4 - r11
            int r4 = r4 + -1
            java.lang.String r11 = r10.x0(r11, r4)
            double r4 = java.lang.Double.parseDouble(r11)
            r11 = 16
            r6 = 44
            if (r0 != r6) goto L_0x00ae
            int r0 = r10.f15722f
            int r0 = r0 + r7
            r10.f15722f = r0
            char r0 = r10.R(r0)
            r10.f15721e = r0
            r0 = 3
            r10.f15731o = r0
            r10.f15718b = r11
            return r4
        L_0x00ae:
            r8 = 125(0x7d, float:1.75E-43)
            if (r0 != r8) goto L_0x0109
            int r0 = r10.f15722f
            int r9 = r7 + 1
            int r0 = r0 + r7
            char r0 = r10.R(r0)
            if (r0 != r6) goto L_0x00cb
            r10.f15718b = r11
            int r11 = r10.f15722f
            int r11 = r11 + r9
            r10.f15722f = r11
            char r11 = r10.R(r11)
            r10.f15721e = r11
            goto L_0x0102
        L_0x00cb:
            r11 = 93
            if (r0 != r11) goto L_0x00df
            r11 = 15
            r10.f15718b = r11
            int r11 = r10.f15722f
            int r11 = r11 + r9
            r10.f15722f = r11
            char r11 = r10.R(r11)
            r10.f15721e = r11
            goto L_0x0102
        L_0x00df:
            if (r0 != r8) goto L_0x00f1
            r11 = 13
            r10.f15718b = r11
            int r11 = r10.f15722f
            int r11 = r11 + r9
            r10.f15722f = r11
            char r11 = r10.R(r11)
            r10.f15721e = r11
            goto L_0x0102
        L_0x00f1:
            r11 = 26
            if (r0 != r11) goto L_0x0106
            r0 = 20
            r10.f15718b = r0
            int r0 = r10.f15722f
            int r9 = r9 + -1
            int r0 = r0 + r9
            r10.f15722f = r0
            r10.f15721e = r11
        L_0x0102:
            r11 = 4
            r10.f15731o = r11
            return r4
        L_0x0106:
            r10.f15731o = r3
            return r1
        L_0x0109:
            r10.f15731o = r3
            return r1
        L_0x010c:
            r10.f15731o = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.g0(char[]):double");
    }

    public Locale getLocale() {
        return this.f15730n;
    }

    public final float h0(char[] cArr) {
        int i11;
        char R;
        this.f15731o = 0;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return 0.0f;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char R2 = R(this.f15722f + length);
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0.0f;
        }
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                i12 = i11;
            }
        }
        if (R == '.') {
            int i13 = i11 + 1;
            char R3 = R(this.f15722f + i11);
            if (R3 >= '0' && R3 <= '9') {
                while (true) {
                    i11 = i13 + 1;
                    R = R(this.f15722f + i13);
                    if (R < '0' || R > '9') {
                        break;
                    }
                    i13 = i11;
                }
            } else {
                this.f15731o = -1;
                return 0.0f;
            }
        }
        int i14 = this.f15722f;
        int length2 = cArr.length + i14;
        float parseFloat = Float.parseFloat(x0(length2, ((i14 + i11) - length2) - 1));
        if (R == ',') {
            int i15 = this.f15722f + i11;
            this.f15722f = i15;
            this.f15721e = R(i15);
            this.f15731o = 3;
            this.f15718b = 16;
            return parseFloat;
        } else if (R == '}') {
            int i16 = i11 + 1;
            char R4 = R(this.f15722f + i11);
            if (R4 == ',') {
                this.f15718b = 16;
                int i17 = this.f15722f + i16;
                this.f15722f = i17;
                this.f15721e = R(i17);
            } else if (R4 == ']') {
                this.f15718b = 15;
                int i18 = this.f15722f + i16;
                this.f15722f = i18;
                this.f15721e = R(i18);
            } else if (R4 == '}') {
                this.f15718b = 13;
                int i19 = this.f15722f + i16;
                this.f15722f = i19;
                this.f15721e = R(i19);
            } else if (R4 == 26) {
                this.f15722f += i16 - 1;
                this.f15718b = 20;
                this.f15721e = 26;
            } else {
                this.f15731o = -1;
                return 0.0f;
            }
            this.f15731o = 4;
            return parseFloat;
        } else {
            this.f15731o = -1;
            return 0.0f;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float[] i0(char[] r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.f15731o = r1
            boolean r2 = r19.Q(r20)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r0.f15731o = r3
            return r4
        L_0x0010:
            r2 = r20
            int r2 = r2.length
            int r5 = r0.f15722f
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.R(r5)
            r5 = 91
            if (r2 == r5) goto L_0x0023
            r0.f15731o = r3
            return r4
        L_0x0023:
            int r2 = r0.f15722f
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.R(r2)
            r5 = 16
            float[] r6 = new float[r5]
            r7 = r1
        L_0x0031:
            int r8 = r0.f15722f
            int r9 = r8 + r3
            r10 = 1
            int r9 = r9 - r10
            r11 = 45
            if (r2 != r11) goto L_0x003d
            r12 = r10
            goto L_0x003e
        L_0x003d:
            r12 = r1
        L_0x003e:
            if (r12 == 0) goto L_0x004c
            int r2 = r3 + 1
            int r8 = r8 + r3
            char r3 = r0.R(r8)
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x004c:
            r8 = -1
            r13 = 48
            if (r2 < r13) goto L_0x01bb
            r14 = 57
            if (r2 > r14) goto L_0x01bb
            int r2 = r2 + -48
        L_0x0057:
            int r15 = r0.f15722f
            int r16 = r3 + 1
            int r15 = r15 + r3
            char r3 = r0.R(r15)
            if (r3 < r13) goto L_0x006c
            if (r3 > r14) goto L_0x006c
            int r2 = r2 * 10
            int r3 = r3 + -48
            int r2 = r2 + r3
            r3 = r16
            goto L_0x0057
        L_0x006c:
            r15 = 46
            if (r3 != r15) goto L_0x0072
            r15 = r10
            goto L_0x0073
        L_0x0072:
            r15 = r1
        L_0x0073:
            r5 = 10
            if (r15 == 0) goto L_0x00ab
            int r3 = r0.f15722f
            int r15 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.R(r3)
            if (r3 < r13) goto L_0x00a8
            if (r3 > r14) goto L_0x00a8
            int r2 = r2 * 10
            int r3 = r3 + -48
            int r2 = r2 + r3
            r3 = r5
        L_0x008b:
            int r1 = r0.f15722f
            int r16 = r15 + 1
            int r1 = r1 + r15
            char r1 = r0.R(r1)
            if (r1 < r13) goto L_0x00a2
            if (r1 > r14) goto L_0x00a2
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            int r3 = r3 * 10
            r15 = r16
            goto L_0x008b
        L_0x00a2:
            r18 = r3
            r3 = r1
            r1 = r18
            goto L_0x00ac
        L_0x00a8:
            r0.f15731o = r8
            return r4
        L_0x00ab:
            r1 = r10
        L_0x00ac:
            r15 = 101(0x65, float:1.42E-43)
            if (r3 == r15) goto L_0x00b7
            r15 = 69
            if (r3 != r15) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r15 = 0
            goto L_0x00b8
        L_0x00b7:
            r15 = r10
        L_0x00b8:
            if (r15 == 0) goto L_0x00e9
            int r3 = r0.f15722f
            int r17 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.R(r3)
            r4 = 43
            if (r3 == r4) goto L_0x00ce
            if (r3 != r11) goto L_0x00cb
            goto L_0x00ce
        L_0x00cb:
            r16 = r17
            goto L_0x00da
        L_0x00ce:
            int r3 = r0.f15722f
            int r4 = r17 + 1
            int r3 = r3 + r17
            char r3 = r0.R(r3)
        L_0x00d8:
            r16 = r4
        L_0x00da:
            if (r3 < r13) goto L_0x00e9
            if (r3 > r14) goto L_0x00e9
            int r3 = r0.f15722f
            int r4 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.R(r3)
            goto L_0x00d8
        L_0x00e9:
            int r4 = r0.f15722f
            int r4 = r4 + r16
            int r4 = r4 - r9
            int r4 = r4 - r10
            if (r15 != 0) goto L_0x00fa
            if (r4 >= r5) goto L_0x00fa
            float r2 = (float) r2
            float r1 = (float) r1
            float r2 = r2 / r1
            if (r12 == 0) goto L_0x0102
            float r2 = -r2
            goto L_0x0102
        L_0x00fa:
            java.lang.String r1 = r0.x0(r9, r4)
            float r2 = java.lang.Float.parseFloat(r1)
        L_0x0102:
            int r1 = r6.length
            r4 = 3
            if (r7 < r1) goto L_0x0111
            int r1 = r6.length
            int r1 = r1 * r4
            int r1 = r1 / 2
            float[] r1 = new float[r1]
            r5 = 0
            java.lang.System.arraycopy(r6, r5, r1, r5, r7)
            r6 = r1
        L_0x0111:
            int r5 = r7 + 1
            r6[r7] = r2
            r1 = 44
            if (r3 != r1) goto L_0x012b
            int r1 = r0.f15722f
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.R(r1)
            r3 = r2
            r4 = 16
            r11 = 0
            r2 = r1
            r1 = 0
            goto L_0x01b5
        L_0x012b:
            r2 = 93
            if (r3 != r2) goto L_0x01ae
            int r3 = r0.f15722f
            int r7 = r16 + 1
            int r3 = r3 + r16
            char r3 = r0.R(r3)
            int r9 = r6.length
            if (r5 == r9) goto L_0x0143
            float[] r9 = new float[r5]
            r11 = 0
            java.lang.System.arraycopy(r6, r11, r9, r11, r5)
            r6 = r9
        L_0x0143:
            if (r3 != r1) goto L_0x0155
            int r1 = r0.f15722f
            int r7 = r7 - r10
            int r1 = r1 + r7
            r0.f15722f = r1
            r19.next()
            r0.f15731o = r4
            r4 = 16
            r0.f15718b = r4
            return r6
        L_0x0155:
            r4 = 16
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x01aa
            int r3 = r0.f15722f
            int r9 = r7 + 1
            int r3 = r3 + r7
            char r3 = r0.R(r3)
            if (r3 != r1) goto L_0x0172
            r0.f15718b = r4
            int r1 = r0.f15722f
            int r9 = r9 - r10
            int r1 = r1 + r9
            r0.f15722f = r1
            r19.next()
            goto L_0x01a2
        L_0x0172:
            if (r3 != r2) goto L_0x0182
            r1 = 15
            r0.f15718b = r1
            int r1 = r0.f15722f
            int r9 = r9 - r10
            int r1 = r1 + r9
            r0.f15722f = r1
            r19.next()
            goto L_0x01a2
        L_0x0182:
            if (r3 != r5) goto L_0x0192
            r1 = 13
            r0.f15718b = r1
            int r1 = r0.f15722f
            int r9 = r9 - r10
            int r1 = r1 + r9
            r0.f15722f = r1
            r19.next()
            goto L_0x01a2
        L_0x0192:
            r1 = 26
            if (r3 != r1) goto L_0x01a6
            int r2 = r0.f15722f
            int r9 = r9 - r10
            int r2 = r2 + r9
            r0.f15722f = r2
            r2 = 20
            r0.f15718b = r2
            r0.f15721e = r1
        L_0x01a2:
            r1 = 4
            r0.f15731o = r1
            return r6
        L_0x01a6:
            r0.f15731o = r8
            r1 = 0
            return r1
        L_0x01aa:
            r1 = 0
            r0.f15731o = r8
            return r1
        L_0x01ae:
            r1 = 0
            r4 = 16
            r11 = 0
            r2 = r3
            r3 = r16
        L_0x01b5:
            r7 = r5
            r5 = r4
            r4 = r1
            r1 = r11
            goto L_0x0031
        L_0x01bb:
            r1 = r4
            r0.f15731o = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.i0(char[]):float[]");
    }

    public final boolean isEnabled(int i11) {
        return (i11 & this.f15720d) != 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final float[][] j0(char[] r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            r0.f15731o = r1
            boolean r2 = r19.Q(r20)
            r3 = -2
            r4 = 0
            if (r2 != 0) goto L_0x0010
            r0.f15731o = r3
            return r4
        L_0x0010:
            r2 = r20
            int r2 = r2.length
            int r5 = r0.f15722f
            int r6 = r2 + 1
            int r5 = r5 + r2
            char r2 = r0.R(r5)
            r5 = 91
            if (r2 == r5) goto L_0x0023
            r0.f15731o = r3
            return r4
        L_0x0023:
            int r2 = r0.f15722f
            int r3 = r6 + 1
            int r2 = r2 + r6
            char r2 = r0.R(r2)
            r6 = 16
            float[][] r7 = new float[r6][]
            r8 = r1
        L_0x0031:
            if (r2 != r5) goto L_0x0031
            int r2 = r0.f15722f
            int r9 = r3 + 1
            int r2 = r2 + r3
            char r2 = r0.R(r2)
            float[] r3 = new float[r6]
            r10 = r1
        L_0x0040:
            int r11 = r0.f15722f
            int r12 = r11 + r9
            r13 = 1
            int r12 = r12 - r13
            r14 = 45
            if (r2 != r14) goto L_0x004c
            r15 = r13
            goto L_0x004d
        L_0x004c:
            r15 = r1
        L_0x004d:
            if (r15 == 0) goto L_0x005b
            int r2 = r9 + 1
            int r11 = r11 + r9
            char r9 = r0.R(r11)
            r18 = r9
            r9 = r2
            r2 = r18
        L_0x005b:
            r11 = -1
            r5 = 48
            if (r2 < r5) goto L_0x0214
            r6 = 57
            if (r2 > r6) goto L_0x0214
            int r2 = r2 + -48
        L_0x0066:
            int r1 = r0.f15722f
            int r16 = r9 + 1
            int r1 = r1 + r9
            char r1 = r0.R(r1)
            if (r1 < r5) goto L_0x007b
            if (r1 > r6) goto L_0x007b
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r9 = r16
            goto L_0x0066
        L_0x007b:
            r9 = 46
            if (r1 != r9) goto L_0x00b4
            int r1 = r0.f15722f
            int r9 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.R(r1)
            if (r1 < r5) goto L_0x00b1
            if (r1 > r6) goto L_0x00b1
            int r2 = r2 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            r1 = 10
        L_0x0094:
            int r13 = r0.f15722f
            int r16 = r9 + 1
            int r13 = r13 + r9
            char r9 = r0.R(r13)
            if (r9 < r5) goto L_0x00ab
            if (r9 > r6) goto L_0x00ab
            int r2 = r2 * 10
            int r9 = r9 + -48
            int r2 = r2 + r9
            int r1 = r1 * 10
            r9 = r16
            goto L_0x0094
        L_0x00ab:
            r18 = r9
            r9 = r1
            r1 = r18
            goto L_0x00b5
        L_0x00b1:
            r0.f15731o = r11
            return r4
        L_0x00b4:
            r9 = 1
        L_0x00b5:
            r13 = 101(0x65, float:1.42E-43)
            if (r1 == r13) goto L_0x00c0
            r13 = 69
            if (r1 != r13) goto L_0x00be
            goto L_0x00c0
        L_0x00be:
            r13 = 0
            goto L_0x00c1
        L_0x00c0:
            r13 = 1
        L_0x00c1:
            if (r13 == 0) goto L_0x00f2
            int r1 = r0.f15722f
            int r17 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.R(r1)
            r4 = 43
            if (r1 == r4) goto L_0x00d7
            if (r1 != r14) goto L_0x00d4
            goto L_0x00d7
        L_0x00d4:
            r16 = r17
            goto L_0x00e3
        L_0x00d7:
            int r1 = r0.f15722f
            int r4 = r17 + 1
            int r1 = r1 + r17
            char r1 = r0.R(r1)
        L_0x00e1:
            r16 = r4
        L_0x00e3:
            if (r1 < r5) goto L_0x00f2
            if (r1 > r6) goto L_0x00f2
            int r1 = r0.f15722f
            int r4 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.R(r1)
            goto L_0x00e1
        L_0x00f2:
            int r4 = r0.f15722f
            int r4 = r4 + r16
            int r4 = r4 - r12
            r5 = 1
            int r4 = r4 - r5
            if (r13 != 0) goto L_0x0106
            r5 = 10
            if (r4 >= r5) goto L_0x0106
            float r2 = (float) r2
            float r4 = (float) r9
            float r2 = r2 / r4
            if (r15 == 0) goto L_0x010e
            float r2 = -r2
            goto L_0x010e
        L_0x0106:
            java.lang.String r2 = r0.x0(r12, r4)
            float r2 = java.lang.Float.parseFloat(r2)
        L_0x010e:
            int r4 = r3.length
            r5 = 3
            if (r10 < r4) goto L_0x011d
            int r4 = r3.length
            int r4 = r4 * r5
            int r4 = r4 / 2
            float[] r4 = new float[r4]
            r6 = 0
            java.lang.System.arraycopy(r3, r6, r4, r6, r10)
            r3 = r4
        L_0x011d:
            int r4 = r10 + 1
            r3[r10] = r2
            r2 = 44
            if (r1 != r2) goto L_0x0137
            int r1 = r0.f15722f
            int r2 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.R(r1)
            r9 = r2
            r5 = 16
            r6 = 0
            r10 = 0
            r2 = r1
            goto L_0x020c
        L_0x0137:
            r6 = 93
            if (r1 != r6) goto L_0x0205
            int r1 = r0.f15722f
            int r9 = r16 + 1
            int r1 = r1 + r16
            char r1 = r0.R(r1)
            int r10 = r3.length
            if (r4 == r10) goto L_0x0150
            float[] r10 = new float[r4]
            r12 = 0
            java.lang.System.arraycopy(r3, r12, r10, r12, r4)
            r3 = r10
            goto L_0x0151
        L_0x0150:
            r12 = 0
        L_0x0151:
            int r10 = r7.length
            if (r8 < r10) goto L_0x015d
            int r7 = r7.length
            int r7 = r7 * r5
            int r7 = r7 / 2
            float[][] r7 = new float[r7][]
            java.lang.System.arraycopy(r3, r12, r7, r12, r4)
        L_0x015d:
            int r4 = r8 + 1
            r7[r8] = r3
            if (r1 != r2) goto L_0x0174
            int r1 = r0.f15722f
            int r2 = r9 + 1
            int r1 = r1 + r9
            char r1 = r0.R(r1)
            r3 = r2
            r5 = 16
            r6 = 0
            r10 = 0
            r2 = r1
            goto L_0x01fd
        L_0x0174:
            if (r1 != r6) goto L_0x01f7
            int r1 = r0.f15722f
            int r3 = r9 + 1
            int r1 = r1 + r9
            char r1 = r0.R(r1)
            int r8 = r7.length
            if (r4 == r8) goto L_0x0189
            float[][] r8 = new float[r4][]
            r10 = 0
            java.lang.System.arraycopy(r7, r10, r8, r10, r4)
            r7 = r8
        L_0x0189:
            if (r1 != r2) goto L_0x019c
            int r1 = r0.f15722f
            r2 = 1
            int r3 = r3 - r2
            int r1 = r1 + r3
            r0.f15722f = r1
            r19.next()
            r0.f15731o = r5
            r5 = 16
            r0.f15718b = r5
            return r7
        L_0x019c:
            r5 = 16
            r4 = 125(0x7d, float:1.75E-43)
            if (r1 != r4) goto L_0x01f3
            int r1 = r0.f15722f
            int r8 = r3 + 1
            int r1 = r1 + r3
            char r1 = r0.R(r1)
            if (r1 != r2) goto L_0x01ba
            r0.f15718b = r5
            int r1 = r0.f15722f
            r2 = 1
            int r8 = r8 - r2
            int r1 = r1 + r8
            r0.f15722f = r1
            r19.next()
            goto L_0x01eb
        L_0x01ba:
            r2 = 1
            if (r1 != r6) goto L_0x01cb
            r1 = 15
            r0.f15718b = r1
            int r1 = r0.f15722f
            int r8 = r8 - r2
            int r1 = r1 + r8
            r0.f15722f = r1
            r19.next()
            goto L_0x01eb
        L_0x01cb:
            if (r1 != r4) goto L_0x01db
            r1 = 13
            r0.f15718b = r1
            int r1 = r0.f15722f
            int r8 = r8 - r2
            int r1 = r1 + r8
            r0.f15722f = r1
            r19.next()
            goto L_0x01eb
        L_0x01db:
            r3 = 26
            if (r1 != r3) goto L_0x01ef
            int r1 = r0.f15722f
            int r8 = r8 - r2
            int r1 = r1 + r8
            r0.f15722f = r1
            r1 = 20
            r0.f15718b = r1
            r0.f15721e = r3
        L_0x01eb:
            r1 = 4
            r0.f15731o = r1
            return r7
        L_0x01ef:
            r0.f15731o = r11
            r6 = 0
            return r6
        L_0x01f3:
            r6 = 0
            r0.f15731o = r11
            return r6
        L_0x01f7:
            r5 = 16
            r6 = 0
            r10 = 0
            r2 = r1
            r3 = r9
        L_0x01fd:
            r8 = r4
            r4 = r6
            r1 = r10
            r6 = r5
            r5 = 91
            goto L_0x0031
        L_0x0205:
            r5 = 16
            r6 = 0
            r10 = 0
            r2 = r1
            r9 = r16
        L_0x020c:
            r1 = r10
            r10 = r4
            r4 = r6
            r6 = r5
            r5 = 91
            goto L_0x0040
        L_0x0214:
            r6 = r4
            r0.f15731o = r11
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.j0(char[]):float[][]");
    }

    public TimeZone k() {
        return this.f15729m;
    }

    public int k0(char[] cArr) {
        int i11;
        char R;
        this.f15731o = 0;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return 0;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char R2 = R(this.f15722f + length);
        boolean z11 = R2 == '-';
        if (z11) {
            R2 = R(this.f15722f + i12);
            i12++;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        int i13 = R2 - '0';
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                i13 = (i13 * 10) + (R - '0');
                i12 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if ((i13 < 0 || i11 > cArr.length + 14) && !(i13 == Integer.MIN_VALUE && i11 == 17 && z11)) {
            this.f15731o = -1;
            return 0;
        } else if (R == ',') {
            int i14 = this.f15722f + i11;
            this.f15722f = i14;
            this.f15721e = R(i14);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11 ? -i13 : i13;
        } else if (R == '}') {
            int i15 = i11 + 1;
            char R3 = R(this.f15722f + i11);
            if (R3 == ',') {
                this.f15718b = 16;
                int i16 = this.f15722f + i15;
                this.f15722f = i16;
                this.f15721e = R(i16);
            } else if (R3 == ']') {
                this.f15718b = 15;
                int i17 = this.f15722f + i15;
                this.f15722f = i17;
                this.f15721e = R(i17);
            } else if (R3 == '}') {
                this.f15718b = 13;
                int i18 = this.f15722f + i15;
                this.f15722f = i18;
                this.f15721e = R(i18);
            } else if (R3 == 26) {
                this.f15718b = 20;
                this.f15722f += i15 - 1;
                this.f15721e = 26;
            } else {
                this.f15731o = -1;
                return 0;
            }
            this.f15731o = 4;
            return z11 ? -i13 : i13;
        } else {
            this.f15731o = -1;
            return 0;
        }
    }

    public float l() {
        char charAt;
        String N = N();
        float parseFloat = Float.parseFloat(N);
        if ((parseFloat != 0.0f && parseFloat != Float.POSITIVE_INFINITY) || (charAt = N.charAt(0)) <= '0' || charAt > '9') {
            return parseFloat;
        }
        throw new JSONException("float overflow : " + N);
    }

    public final int[] l0(char[] cArr) {
        int i11;
        int i12;
        char c11;
        boolean z11;
        int i13;
        char R;
        this.f15731o = 0;
        int[] iArr = null;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return null;
        }
        int length = cArr.length;
        int i14 = length + 1;
        if (R(this.f15722f + length) != '[') {
            this.f15731o = -2;
            return null;
        }
        int i15 = i14 + 1;
        char R2 = R(this.f15722f + i14);
        int[] iArr2 = new int[16];
        if (R2 == ']') {
            i11 = i15 + 1;
            c11 = R(this.f15722f + i15);
            i12 = 0;
        } else {
            int i16 = 0;
            while (true) {
                if (R2 == '-') {
                    R2 = R(this.f15722f + i15);
                    i15++;
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (R2 < '0' || R2 > '9') {
                    int[] iArr3 = iArr;
                    this.f15731o = -1;
                } else {
                    int i17 = R2 - '0';
                    while (true) {
                        i13 = i15 + 1;
                        R = R(this.f15722f + i15);
                        if (R >= '0' && R <= '9') {
                            i17 = (i17 * 10) + (R - '0');
                            i15 = i13;
                        }
                    }
                    if (i16 >= iArr2.length) {
                        int[] iArr4 = new int[((iArr2.length * 3) / 2)];
                        System.arraycopy(iArr2, 0, iArr4, 0, i16);
                        iArr2 = iArr4;
                    }
                    i12 = i16 + 1;
                    if (z11) {
                        i17 = -i17;
                    }
                    iArr2[i16] = i17;
                    if (R == ',') {
                        i13++;
                        R = R(this.f15722f + i13);
                    } else if (R == ']') {
                        i11 = i13 + 1;
                        c11 = R(this.f15722f + i13);
                        break;
                    }
                    i16 = i12;
                    iArr = null;
                    R2 = R;
                    i15 = i13;
                }
            }
            int[] iArr32 = iArr;
            this.f15731o = -1;
            return iArr32;
        }
        if (i12 != iArr2.length) {
            int[] iArr5 = new int[i12];
            System.arraycopy(iArr2, 0, iArr5, 0, i12);
            iArr2 = iArr5;
        }
        if (c11 == ',') {
            this.f15722f += i11 - 1;
            next();
            this.f15731o = 3;
            this.f15718b = 16;
            return iArr2;
        } else if (c11 == '}') {
            int i18 = i11 + 1;
            char R3 = R(this.f15722f + i11);
            if (R3 == ',') {
                this.f15718b = 16;
                this.f15722f += i18 - 1;
                next();
            } else if (R3 == ']') {
                this.f15718b = 15;
                this.f15722f += i18 - 1;
                next();
            } else if (R3 == '}') {
                this.f15718b = 13;
                this.f15722f += i18 - 1;
                next();
            } else if (R3 == 26) {
                this.f15722f += i18 - 1;
                this.f15718b = 20;
                this.f15721e = 26;
            } else {
                this.f15731o = -1;
                return null;
            }
            this.f15731o = 4;
            return iArr2;
        } else {
            this.f15731o = -1;
            return null;
        }
    }

    public String m(char c11) {
        this.f15731o = 0;
        char R = R(this.f15722f + 0);
        if (R == 'n') {
            if (R(this.f15722f + 1) != 'u' || R(this.f15722f + 1 + 1) != 'l' || R(this.f15722f + 1 + 2) != 'l') {
                this.f15731o = -1;
                return null;
            } else if (R(this.f15722f + 4) == c11) {
                int i11 = this.f15722f + 5;
                this.f15722f = i11;
                this.f15721e = R(i11);
                this.f15731o = 3;
                return null;
            } else {
                this.f15731o = -1;
                return null;
            }
        } else if (R != '\"') {
            this.f15731o = -1;
            return w0();
        } else {
            int i12 = this.f15722f + 1;
            int V = V('\"', i12);
            if (V != -1) {
                String x02 = x0(this.f15722f + 1, V - i12);
                if (x02.indexOf(92) != -1) {
                    while (true) {
                        int i13 = V - 1;
                        int i14 = 0;
                        while (i13 >= 0 && R(i13) == '\\') {
                            i14++;
                            i13--;
                        }
                        if (i14 % 2 == 0) {
                            break;
                        }
                        V = V('\"', V + 1);
                    }
                    int i15 = V - i12;
                    x02 = d0(y0(this.f15722f + 1, i15), i15);
                }
                int i16 = this.f15722f;
                int i17 = 1 + (V - (i16 + 1)) + 1;
                int i18 = i17 + 1;
                if (R(i16 + i17) == c11) {
                    int i19 = this.f15722f + i18;
                    this.f15722f = i19;
                    this.f15721e = R(i19);
                    this.f15731o = 3;
                    return x02;
                }
                this.f15731o = -1;
                return x02;
            }
            throw new JSONException("unclosed str");
        }
    }

    public long m0(char[] cArr) {
        int i11;
        char R;
        boolean z11 = false;
        this.f15731o = 0;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return 0;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char R2 = R(this.f15722f + length);
        if (R2 == '-') {
            R2 = R(this.f15722f + i12);
            i12++;
            z11 = true;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        long j11 = (long) (R2 - '0');
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                j11 = (j11 * 10) + ((long) (R - '0'));
                i12 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if (j11 < 0 || i11 > 21) {
            this.f15731o = -1;
            return 0;
        } else if (R == ',') {
            int i13 = this.f15722f + i11;
            this.f15722f = i13;
            this.f15721e = R(i13);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11 ? -j11 : j11;
        } else if (R == '}') {
            int i14 = i11 + 1;
            char R3 = R(this.f15722f + i11);
            if (R3 == ',') {
                this.f15718b = 16;
                int i15 = this.f15722f + i14;
                this.f15722f = i15;
                this.f15721e = R(i15);
            } else if (R3 == ']') {
                this.f15718b = 15;
                int i16 = this.f15722f + i14;
                this.f15722f = i16;
                this.f15721e = R(i16);
            } else if (R3 == '}') {
                this.f15718b = 13;
                int i17 = this.f15722f + i14;
                this.f15722f = i17;
                this.f15721e = R(i17);
            } else if (R3 == 26) {
                this.f15718b = 20;
                this.f15722f += i14 - 1;
                this.f15721e = 26;
            } else {
                this.f15731o = -1;
                return 0;
            }
            this.f15731o = 4;
            return z11 ? -j11 : j11;
        } else {
            this.f15731o = -1;
            return 0;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Enum<?> n(java.lang.Class<?> r1, f2.g r2, char r3) {
        /*
            r0 = this;
            java.lang.String r2 = r0.t0(r2, r3)
            if (r2 != 0) goto L_0x0008
            r1 = 0
            return r1
        L_0x0008:
            java.lang.Enum r1 = java.lang.Enum.valueOf(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.n(java.lang.Class, f2.g, char):java.lang.Enum");
    }

    public String n0(char[] cArr) {
        this.f15731o = 0;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return w0();
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (R(this.f15722f + length) != '\"') {
            this.f15731o = -1;
            return w0();
        }
        int V = V('\"', this.f15722f + cArr.length + 1);
        if (V != -1) {
            int length2 = this.f15722f + cArr.length + 1;
            String x02 = x0(length2, V - length2);
            if (x02.indexOf(92) != -1) {
                while (true) {
                    int i12 = V - 1;
                    int i13 = 0;
                    while (i12 >= 0 && R(i12) == '\\') {
                        i13++;
                        i12--;
                    }
                    if (i13 % 2 == 0) {
                        break;
                    }
                    V = V('\"', V + 1);
                }
                int i14 = this.f15722f;
                int length3 = V - ((cArr.length + i14) + 1);
                x02 = d0(y0(i14 + cArr.length + 1, length3), length3);
            }
            int i15 = this.f15722f;
            int length4 = i11 + (V - ((cArr.length + i15) + 1)) + 1;
            int i16 = length4 + 1;
            char R = R(i15 + length4);
            if (R == ',') {
                int i17 = this.f15722f + i16;
                this.f15722f = i17;
                this.f15721e = R(i17);
                this.f15731o = 3;
                return x02;
            } else if (R == '}') {
                int i18 = i16 + 1;
                char R2 = R(this.f15722f + i16);
                if (R2 == ',') {
                    this.f15718b = 16;
                    int i19 = this.f15722f + i18;
                    this.f15722f = i19;
                    this.f15721e = R(i19);
                } else if (R2 == ']') {
                    this.f15718b = 15;
                    int i21 = this.f15722f + i18;
                    this.f15722f = i21;
                    this.f15721e = R(i21);
                } else if (R2 == '}') {
                    this.f15718b = 13;
                    int i22 = this.f15722f + i18;
                    this.f15722f = i22;
                    this.f15721e = R(i22);
                } else if (R2 == 26) {
                    this.f15718b = 20;
                    this.f15722f += i18 - 1;
                    this.f15721e = 26;
                } else {
                    this.f15731o = -1;
                    return w0();
                }
                this.f15731o = 4;
                return x02;
            } else {
                this.f15731o = -1;
                return w0();
            }
        } else {
            throw new JSONException("unclosed str");
        }
    }

    public abstract char next();

    public final void nextToken() {
        this.f15725i = 0;
        while (true) {
            this.f15719c = this.f15722f;
            char c11 = this.f15721e;
            if (c11 == '/') {
                v0();
            } else if (c11 == '\"') {
                e();
                return;
            } else if (c11 == ',') {
                next();
                this.f15718b = 16;
                return;
            } else if (c11 >= '0' && c11 <= '9') {
                x();
                return;
            } else if (c11 == '-') {
                x();
                return;
            } else {
                switch (c11) {
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                        next();
                        break;
                    case '\'':
                        if (a(Feature.AllowSingleQuotes)) {
                            s0();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.f15718b = 10;
                        return;
                    case ')':
                        next();
                        this.f15718b = 11;
                        return;
                    case '+':
                        next();
                        x();
                        return;
                    case '.':
                        next();
                        this.f15718b = 25;
                        return;
                    case ':':
                        next();
                        this.f15718b = 17;
                        return;
                    case ';':
                        next();
                        this.f15718b = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        q0();
                        return;
                    case '[':
                        next();
                        this.f15718b = 14;
                        return;
                    case ']':
                        next();
                        this.f15718b = 15;
                        return;
                    case 'f':
                        e0();
                        return;
                    case 'n':
                        r0();
                        return;
                    case 't':
                        u0();
                        return;
                    case 'x':
                        p0();
                        return;
                    case '{':
                        next();
                        this.f15718b = 12;
                        return;
                    case '}':
                        next();
                        this.f15718b = 13;
                        return;
                    default:
                        if (!W()) {
                            char c12 = this.f15721e;
                            if (c12 <= 31 || c12 == 127) {
                                next();
                                break;
                            } else {
                                Y("illegal.char", String.valueOf(c12));
                                next();
                                return;
                            }
                        } else if (this.f15718b != 20) {
                            this.f15718b = 20;
                            int i11 = this.f15723g;
                            this.f15722f = i11;
                            this.f15719c = i11;
                            return;
                        } else {
                            throw new JSONException("EOF error");
                        }
                }
            }
        }
    }

    public final String o(g gVar, char c11) {
        String str;
        this.f15726j = this.f15722f;
        this.f15725i = 0;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            char next = next();
            if (next == c11) {
                this.f15718b = 4;
                if (!z11) {
                    int i12 = this.f15726j;
                    str = O(i12 == -1 ? 0 : i12 + 1, this.f15725i, i11, gVar);
                } else {
                    str = gVar.c(this.f15724h, 0, this.f15725i, i11);
                }
                this.f15725i = 0;
                next();
                return str;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else if (next == '\\') {
                if (!z11) {
                    int i13 = this.f15725i;
                    char[] cArr = this.f15724h;
                    if (i13 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i13 <= length) {
                            i13 = length;
                        }
                        char[] cArr2 = new char[i13];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f15724h = cArr2;
                    }
                    P(this.f15726j + 1, this.f15724h, 0, this.f15725i);
                    z11 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i11 = (i11 * 31) + 34;
                    c0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i11 = (i11 * 31) + 92;
                            c0('\\');
                        } else if (next2 == 'b') {
                            i11 = (i11 * 31) + 8;
                            c0(8);
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i11 = (i11 * 31) + 10;
                                c0(10);
                            } else if (next2 == 'r') {
                                i11 = (i11 * 31) + 13;
                                c0(13);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i11 = (i11 * 31) + 47;
                                        c0('/');
                                        break;
                                    case '0':
                                        i11 = (i11 * 31) + next2;
                                        c0(0);
                                        break;
                                    case '1':
                                        i11 = (i11 * 31) + next2;
                                        c0(1);
                                        break;
                                    case '2':
                                        i11 = (i11 * 31) + next2;
                                        c0(2);
                                        break;
                                    case '3':
                                        i11 = (i11 * 31) + next2;
                                        c0(3);
                                        break;
                                    case '4':
                                        i11 = (i11 * 31) + next2;
                                        c0(4);
                                        break;
                                    case '5':
                                        i11 = (i11 * 31) + next2;
                                        c0(5);
                                        break;
                                    case '6':
                                        i11 = (i11 * 31) + next2;
                                        c0(6);
                                        break;
                                    case '7':
                                        i11 = (i11 * 31) + next2;
                                        c0(7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i11 = (i11 * 31) + 9;
                                                c0(9);
                                                break;
                                            case 'u':
                                                int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i11 = (i11 * 31) + parseInt;
                                                c0((char) parseInt);
                                                break;
                                            case 'v':
                                                i11 = (i11 * 31) + 11;
                                                c0(11);
                                                break;
                                            default:
                                                this.f15721e = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.f15721e = next3;
                                char next4 = next();
                                this.f15721e = next4;
                                int[] iArr = f15717s;
                                char c12 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i11 = (i11 * 31) + c12;
                                c0(c12);
                            }
                        }
                    }
                    i11 = (i11 * 31) + 12;
                    c0(12);
                } else {
                    i11 = (i11 * 31) + 39;
                    c0('\'');
                }
            } else {
                i11 = (i11 * 31) + next;
                if (!z11) {
                    this.f15725i++;
                } else {
                    int i14 = this.f15725i;
                    char[] cArr3 = this.f15724h;
                    if (i14 == cArr3.length) {
                        c0(next);
                    } else {
                        this.f15725i = i14 + 1;
                        cArr3[i14] = next;
                    }
                }
            }
        }
    }

    public long o0(char[] cArr) {
        this.f15731o = 0;
        if (!Q(cArr)) {
            this.f15731o = -2;
            return 0;
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (R(this.f15722f + length) != '\"') {
            this.f15731o = -1;
            return 0;
        }
        long j11 = -2128831035;
        while (true) {
            int i12 = i11 + 1;
            char R = R(this.f15722f + i11);
            if (R == '\"') {
                int i13 = i12 + 1;
                char R2 = R(this.f15722f + i12);
                if (R2 == ',') {
                    int i14 = this.f15722f + i13;
                    this.f15722f = i14;
                    this.f15721e = R(i14);
                    this.f15731o = 3;
                    return j11;
                } else if (R2 == '}') {
                    int i15 = i13 + 1;
                    char R3 = R(this.f15722f + i13);
                    if (R3 == ',') {
                        this.f15718b = 16;
                        int i16 = this.f15722f + i15;
                        this.f15722f = i16;
                        this.f15721e = R(i16);
                    } else if (R3 == ']') {
                        this.f15718b = 15;
                        int i17 = this.f15722f + i15;
                        this.f15722f = i17;
                        this.f15721e = R(i17);
                    } else if (R3 == '}') {
                        this.f15718b = 13;
                        int i18 = this.f15722f + i15;
                        this.f15722f = i18;
                        this.f15721e = R(i18);
                    } else if (R3 == 26) {
                        this.f15718b = 20;
                        this.f15722f += i15 - 1;
                        this.f15721e = 26;
                    } else {
                        this.f15731o = -1;
                        return 0;
                    }
                    this.f15731o = 4;
                    return j11;
                } else {
                    this.f15731o = -1;
                    return 0;
                }
            } else {
                j11 = (j11 ^ ((long) R)) * 16777619;
                if (R == '\\') {
                    this.f15731o = -1;
                    return 0;
                }
                i11 = i12;
            }
        }
    }

    public final void p() {
        while (true) {
            char c11 = this.f15721e;
            if (c11 > '/') {
                return;
            }
            if (c11 == ' ' || c11 == 13 || c11 == 10 || c11 == 9 || c11 == 12 || c11 == 8) {
                next();
            } else if (c11 == '/') {
                v0();
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p0() {
        /*
            r4 = this;
            char r0 = r4.f15721e
            java.lang.String r1 = "illegal state. "
            r2 = 120(0x78, float:1.68E-43)
            if (r0 != r2) goto L_0x006f
            r4.next()
            char r0 = r4.f15721e
            r2 = 39
            if (r0 != r2) goto L_0x0058
            int r0 = r4.f15722f
            r4.f15726j = r0
            r4.next()
        L_0x0018:
            char r0 = r4.next()
            r3 = 48
            if (r0 < r3) goto L_0x0024
            r3 = 57
            if (r0 <= r3) goto L_0x002c
        L_0x0024:
            r3 = 65
            if (r0 < r3) goto L_0x0033
            r3 = 70
            if (r0 > r3) goto L_0x0033
        L_0x002c:
            int r0 = r4.f15725i
            int r0 = r0 + 1
            r4.f15725i = r0
            goto L_0x0018
        L_0x0033:
            if (r0 != r2) goto L_0x0043
            int r0 = r4.f15725i
            int r0 = r0 + 1
            r4.f15725i = r0
            r4.next()
            r0 = 26
            r4.f15718b = r0
            return
        L_0x0043:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0058:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            char r1 = r4.f15721e
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x006f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            char r1 = r4.f15721e
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.p0():void");
    }

    public final void q0() {
        this.f15726j = this.f15722f - 1;
        this.f15727k = false;
        do {
            this.f15725i++;
            next();
        } while (Character.isLetterOrDigit(this.f15721e));
        String H = H();
        if (OptionsBridge.NULL_VALUE.equalsIgnoreCase(H)) {
            this.f15718b = 8;
        } else if (ChainInfo.CHAIN_TYPE_NEW.equals(H)) {
            this.f15718b = 9;
        } else if ("true".equals(H)) {
            this.f15718b = 6;
        } else if (d.f31895b.equals(H)) {
            this.f15718b = 7;
        } else if ("undefined".equals(H)) {
            this.f15718b = 23;
        } else if ("Set".equals(H)) {
            this.f15718b = 21;
        } else if ("TreeSet".equals(H)) {
            this.f15718b = 22;
        } else {
            this.f15718b = 18;
        }
    }

    public long r(char c11) {
        int i11;
        char R;
        boolean z11 = false;
        this.f15731o = 0;
        char R2 = R(this.f15722f + 0);
        int i12 = 1;
        if (R2 == '-') {
            z11 = true;
        }
        if (z11) {
            R2 = R(this.f15722f + 1);
            i12 = 2;
        }
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0;
        }
        long j11 = (long) (R2 - '0');
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                j11 = (j11 * 10) + ((long) (R - '0'));
                i12 = i11;
            }
        }
        if (R == '.') {
            this.f15731o = -1;
            return 0;
        } else if (j11 < 0) {
            this.f15731o = -1;
            return 0;
        } else {
            while (R != c11) {
                if (X(R)) {
                    R = R(this.f15722f + i11);
                    i11++;
                } else {
                    this.f15731o = -1;
                    return j11;
                }
            }
            int i13 = this.f15722f + i11;
            this.f15722f = i13;
            this.f15721e = R(i13);
            this.f15731o = 3;
            this.f15718b = 16;
            return z11 ? -j11 : j11;
        }
    }

    public final void r0() {
        if (this.f15721e == 'n') {
            next();
            char c11 = this.f15721e;
            if (c11 == 'u') {
                next();
                if (this.f15721e == 'l') {
                    next();
                    if (this.f15721e == 'l') {
                        next();
                        char c12 = this.f15721e;
                        if (c12 == ' ' || c12 == ',' || c12 == '}' || c12 == ']' || c12 == 10 || c12 == 13 || c12 == 9 || c12 == 26 || c12 == 12 || c12 == 8) {
                            this.f15718b = 8;
                            return;
                        }
                        throw new JSONException("scan null error");
                    }
                    throw new JSONException("error parse null");
                }
                throw new JSONException("error parse null");
            } else if (c11 == 'e') {
                next();
                if (this.f15721e == 'w') {
                    next();
                    char c13 = this.f15721e;
                    if (c13 == ' ' || c13 == ',' || c13 == '}' || c13 == ']' || c13 == 10 || c13 == 13 || c13 == 9 || c13 == 26 || c13 == 12 || c13 == 8) {
                        this.f15718b = 9;
                        return;
                    }
                    throw new JSONException("scan new error");
                }
                throw new JSONException("error parse new");
            } else {
                throw new JSONException("error parse new");
            }
        } else {
            throw new JSONException("error parse null or new");
        }
    }

    public final int s() {
        return this.f15719c;
    }

    public final void s0() {
        this.f15726j = this.f15722f;
        this.f15727k = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.f15718b = 4;
                next();
                return;
            } else if (next == 26) {
                if (!W()) {
                    c0(26);
                } else {
                    throw new JSONException("unclosed single-quote string");
                }
            } else if (next == '\\') {
                if (!this.f15727k) {
                    this.f15727k = true;
                    int i11 = this.f15725i;
                    char[] cArr = this.f15724h;
                    if (i11 > cArr.length) {
                        char[] cArr2 = new char[(i11 * 2)];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.f15724h = cArr2;
                    }
                    S(this.f15726j + 1, this.f15725i, this.f15724h);
                }
                char next2 = next();
                if (next2 == '\"') {
                    c0('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            c0('\\');
                        } else if (next2 == 'b') {
                            c0(8);
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                c0(10);
                            } else if (next2 == 'r') {
                                c0(13);
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        c0('/');
                                        break;
                                    case '0':
                                        c0(0);
                                        break;
                                    case '1':
                                        c0(1);
                                        break;
                                    case '2':
                                        c0(2);
                                        break;
                                    case '3':
                                        c0(3);
                                        break;
                                    case '4':
                                        c0(4);
                                        break;
                                    case '5':
                                        c0(5);
                                        break;
                                    case '6':
                                        c0(6);
                                        break;
                                    case '7':
                                        c0(7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                c0(9);
                                                break;
                                            case 'u':
                                                c0((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                c0(11);
                                                break;
                                            default:
                                                this.f15721e = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                int[] iArr = f15717s;
                                c0((char) ((iArr[next()] * 16) + iArr[next()]));
                            }
                        }
                    }
                    c0(12);
                } else {
                    c0('\'');
                }
            } else if (!this.f15727k) {
                this.f15725i++;
            } else {
                int i12 = this.f15725i;
                char[] cArr3 = this.f15724h;
                if (i12 == cArr3.length) {
                    c0(next);
                } else {
                    this.f15725i = i12 + 1;
                    cArr3[i12] = next;
                }
            }
        }
    }

    public String t() {
        return "";
    }

    public String t0(g gVar, char c11) {
        int i11 = 0;
        this.f15731o = 0;
        char R = R(this.f15722f + 0);
        if (R == 'n') {
            if (R(this.f15722f + 1) != 'u' || R(this.f15722f + 1 + 1) != 'l' || R(this.f15722f + 1 + 2) != 'l') {
                this.f15731o = -1;
                return null;
            } else if (R(this.f15722f + 4) == c11) {
                int i12 = this.f15722f + 5;
                this.f15722f = i12;
                this.f15721e = R(i12);
                this.f15731o = 3;
                return null;
            } else {
                this.f15731o = -1;
                return null;
            }
        } else if (R != '\"') {
            this.f15731o = -1;
            return null;
        } else {
            int i13 = 1;
            while (true) {
                int i14 = i13 + 1;
                char R2 = R(this.f15722f + i13);
                if (R2 == '\"') {
                    int i15 = this.f15722f;
                    int i16 = i15 + 0 + 1;
                    String O = O(i16, ((i15 + i14) - i16) - 1, i11, gVar);
                    int i17 = i14 + 1;
                    char R3 = R(this.f15722f + i14);
                    while (R3 != c11) {
                        if (X(R3)) {
                            R3 = R(this.f15722f + i17);
                            i17++;
                        } else {
                            this.f15731o = -1;
                            return O;
                        }
                    }
                    int i18 = this.f15722f + i17;
                    this.f15722f = i18;
                    this.f15721e = R(i18);
                    this.f15731o = 3;
                    return O;
                }
                i11 = (i11 * 31) + R2;
                if (R2 == '\\') {
                    this.f15731o = -1;
                    return null;
                }
                i13 = i14;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long u() throws java.lang.NumberFormatException {
        /*
            r15 = this;
            int r0 = r15.f15726j
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L_0x0008
            r15.f15726j = r1
        L_0x0008:
            int r0 = r15.f15726j
            int r2 = r15.f15725i
            int r2 = r2 + r0
            char r3 = r15.R(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L_0x001c
            r3 = -9223372036854775808
            int r0 = r0 + 1
            r1 = r5
            goto L_0x0021
        L_0x001c:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0021:
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            if (r0 >= r2) goto L_0x0034
            int r8 = r0 + 1
            char r0 = r15.R(r0)
            int r0 = r0 + -48
            int r0 = -r0
            long r9 = (long) r0
        L_0x0032:
            r0 = r8
            goto L_0x0036
        L_0x0034:
            r9 = 0
        L_0x0036:
            if (r0 >= r2) goto L_0x0072
            int r8 = r0 + 1
            char r0 = r15.R(r0)
            r11 = 76
            if (r0 == r11) goto L_0x0071
            r11 = 83
            if (r0 == r11) goto L_0x0071
            r11 = 66
            if (r0 != r11) goto L_0x004b
            goto L_0x0071
        L_0x004b:
            int r0 = r0 + -48
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 < 0) goto L_0x0067
            r11 = 10
            long r9 = r9 * r11
            long r11 = (long) r0
            long r13 = r3 + r11
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x005d
            long r9 = r9 - r11
            goto L_0x0032
        L_0x005d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.N()
            r0.<init>(r1)
            throw r0
        L_0x0067:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.N()
            r0.<init>(r1)
            throw r0
        L_0x0071:
            r0 = r8
        L_0x0072:
            if (r1 == 0) goto L_0x0084
            int r1 = r15.f15726j
            int r1 = r1 + r5
            if (r0 <= r1) goto L_0x007a
            return r9
        L_0x007a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.N()
            r0.<init>(r1)
            throw r0
        L_0x0084:
            long r0 = -r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.u():long");
    }

    public final void u0() {
        if (this.f15721e == 't') {
            next();
            if (this.f15721e == 'r') {
                next();
                if (this.f15721e == 'u') {
                    next();
                    if (this.f15721e == 'e') {
                        next();
                        char c11 = this.f15721e;
                        if (c11 == ' ' || c11 == ',' || c11 == '}' || c11 == ']' || c11 == 10 || c11 == 13 || c11 == 9 || c11 == 26 || c11 == 12 || c11 == 8 || c11 == ':' || c11 == '/') {
                            this.f15718b = 6;
                            return;
                        }
                        throw new JSONException("scan true error");
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final float v(char c11) {
        int i11;
        char R;
        this.f15731o = 0;
        char R2 = R(this.f15722f + 0);
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0.0f;
        }
        int i12 = 1;
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                i12 = i11;
            }
        }
        if (R == '.') {
            int i13 = i11 + 1;
            char R3 = R(this.f15722f + i11);
            if (R3 >= '0' && R3 <= '9') {
                while (true) {
                    i11 = i13 + 1;
                    R = R(this.f15722f + i13);
                    if (R < '0' || R > '9') {
                        break;
                    }
                    i13 = i11;
                }
            } else {
                this.f15731o = -1;
                return 0.0f;
            }
        }
        int i14 = this.f15722f;
        float parseFloat = Float.parseFloat(x0(i14, ((i14 + i11) - i14) - 1));
        if (R == c11) {
            int i15 = this.f15722f + i11;
            this.f15722f = i15;
            this.f15721e = R(i15);
            this.f15731o = 3;
            this.f15718b = 16;
            return parseFloat;
        }
        this.f15731o = -1;
        return parseFloat;
    }

    public void v0() {
        char c11;
        next();
        char c12 = this.f15721e;
        if (c12 == '/') {
            do {
                next();
                c11 = this.f15721e;
                if (c11 == 10) {
                    next();
                    return;
                }
            } while (c11 != 26);
        } else if (c12 == '*') {
            next();
            while (true) {
                char c13 = this.f15721e;
                if (c13 == 26) {
                    return;
                }
                if (c13 == '*') {
                    next();
                    if (this.f15721e == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    public final int w() {
        boolean z11;
        int i11;
        int i12;
        int i13 = 0;
        if (this.f15726j == -1) {
            this.f15726j = 0;
        }
        int i14 = this.f15726j;
        int i15 = this.f15725i + i14;
        if (R(i14) == '-') {
            i11 = Integer.MIN_VALUE;
            i14++;
            z11 = true;
        } else {
            i11 = CellBase.GROUP_ID_END_USER;
            z11 = false;
        }
        if (i14 < i15) {
            i13 = -(R(i14) - '0');
            i14++;
        }
        while (true) {
            if (i14 >= i15) {
                break;
            }
            i12 = i14 + 1;
            char R = R(i14);
            if (R == 'L' || R == 'S' || R == 'B') {
                i14 = i12;
            } else {
                int i16 = R - '0';
                if (((long) i13) >= -214748364) {
                    int i17 = i13 * 10;
                    if (i17 >= i11 + i16) {
                        i13 = i17 - i16;
                        i14 = i12;
                    } else {
                        throw new NumberFormatException(N());
                    }
                } else {
                    throw new NumberFormatException(N());
                }
            }
        }
        i14 = i12;
        if (!z11) {
            return -i13;
        }
        if (i14 > this.f15726j + 1) {
            return i13;
        }
        throw new NumberFormatException(N());
    }

    public final String w0() {
        return this.f15732p;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x() {
        /*
            r9 = this;
            int r0 = r9.f15722f
            r9.f15726j = r0
            char r0 = r9.f15721e
            r1 = 45
            r2 = 1
            if (r0 != r1) goto L_0x0013
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
        L_0x0013:
            char r0 = r9.f15721e
            r3 = 57
            r4 = 48
            if (r0 < r4) goto L_0x0026
            if (r0 > r3) goto L_0x0026
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x0013
        L_0x0026:
            r5 = 0
            r6 = 46
            if (r0 != r6) goto L_0x0043
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
        L_0x0033:
            char r0 = r9.f15721e
            if (r0 < r4) goto L_0x0042
            if (r0 > r3) goto L_0x0042
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x0033
        L_0x0042:
            r5 = r2
        L_0x0043:
            char r0 = r9.f15721e
            r6 = 76
            if (r0 != r6) goto L_0x0052
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x008f
        L_0x0052:
            r6 = 83
            if (r0 != r6) goto L_0x005f
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x008f
        L_0x005f:
            r6 = 66
            if (r0 != r6) goto L_0x006c
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x008f
        L_0x006c:
            r6 = 70
            if (r0 != r6) goto L_0x0079
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x00c4
        L_0x0079:
            r7 = 68
            if (r0 != r7) goto L_0x0086
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x00c4
        L_0x0086:
            r8 = 101(0x65, float:1.42E-43)
            if (r0 == r8) goto L_0x0091
            r8 = 69
            if (r0 != r8) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r2 = r5
            goto L_0x00c4
        L_0x0091:
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            char r0 = r9.f15721e
            r5 = 43
            if (r0 == r5) goto L_0x00a1
            if (r0 != r1) goto L_0x00a9
        L_0x00a1:
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
        L_0x00a9:
            char r0 = r9.f15721e
            if (r0 < r4) goto L_0x00b8
            if (r0 > r3) goto L_0x00b8
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
            goto L_0x00a9
        L_0x00b8:
            if (r0 == r7) goto L_0x00bc
            if (r0 != r6) goto L_0x00c4
        L_0x00bc:
            int r0 = r9.f15725i
            int r0 = r0 + r2
            r9.f15725i = r0
            r9.next()
        L_0x00c4:
            if (r2 == 0) goto L_0x00ca
            r0 = 3
            r9.f15718b = r0
            goto L_0x00cd
        L_0x00ca:
            r0 = 2
            r9.f15718b = r0
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.c.x():void");
    }

    public abstract String x0(int i11, int i12);

    public final void y(int i11) {
        b0(':');
    }

    public abstract char[] y0(int i11, int i12);

    public final double z(char c11) {
        int i11;
        char R;
        this.f15731o = 0;
        char R2 = R(this.f15722f + 0);
        if (R2 < '0' || R2 > '9') {
            this.f15731o = -1;
            return 0.0d;
        }
        int i12 = 1;
        while (true) {
            i11 = i12 + 1;
            R = R(this.f15722f + i12);
            if (R >= '0' && R <= '9') {
                i12 = i11;
            }
        }
        if (R == '.') {
            int i13 = i11 + 1;
            char R3 = R(this.f15722f + i11);
            if (R3 >= '0' && R3 <= '9') {
                while (true) {
                    i11 = i13 + 1;
                    R = R(this.f15722f + i13);
                    if (R < '0' || R > '9') {
                        break;
                    }
                    i13 = i11;
                }
            } else {
                this.f15731o = -1;
                return 0.0d;
            }
        }
        int i14 = this.f15722f;
        double parseDouble = Double.parseDouble(x0(i14, ((i14 + i11) - i14) - 1));
        if (R == c11) {
            int i15 = this.f15722f + i11;
            this.f15722f = i15;
            this.f15721e = R(i15);
            this.f15731o = 3;
            this.f15718b = 16;
            return parseDouble;
        }
        this.f15731o = -1;
        return parseDouble;
    }
}
