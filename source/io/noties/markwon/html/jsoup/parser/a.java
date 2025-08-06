package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.UncheckedIOException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f55369a;

    /* renamed from: b  reason: collision with root package name */
    public final Reader f55370b;

    /* renamed from: c  reason: collision with root package name */
    public int f55371c;

    /* renamed from: d  reason: collision with root package name */
    public int f55372d;

    /* renamed from: e  reason: collision with root package name */
    public int f55373e;

    /* renamed from: f  reason: collision with root package name */
    public int f55374f;

    /* renamed from: g  reason: collision with root package name */
    public int f55375g;

    /* renamed from: h  reason: collision with root package name */
    public final String[] f55376h;

    public a(Reader reader, int i11) {
        this.f55376h = new String[128];
        vz.a.f(reader);
        vz.a.d(reader.markSupported());
        this.f55370b = reader;
        this.f55369a = new char[4096];
        b();
    }

    public static boolean G(char[] cArr, int i11, int i12, String str) {
        if (i12 != str.length()) {
            return false;
        }
        int i13 = 0;
        while (true) {
            int i14 = i12 - 1;
            if (i12 == 0) {
                return true;
            }
            int i15 = i11 + 1;
            int i16 = i13 + 1;
            if (cArr[i11] != str.charAt(i13)) {
                return false;
            }
            i11 = i15;
            i12 = i14;
            i13 = i16;
        }
    }

    public static String c(char[] cArr, String[] strArr, int i11, int i12) {
        if (i12 > 12) {
            return new String(cArr, i11, i12);
        }
        if (i12 < 1) {
            return "";
        }
        int i13 = 0;
        int i14 = i11;
        int i15 = 0;
        while (i13 < i12) {
            i15 = (i15 * 31) + cArr[i14];
            i13++;
            i14++;
        }
        int length = i15 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i11, i12);
            strArr[length] = str2;
            return str2;
        } else if (G(cArr, i11, i12, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i11, i12);
            strArr[length] = str3;
            return str3;
        }
    }

    public boolean A() {
        char c11;
        if (!r() && (c11 = this.f55369a[this.f55373e]) >= '0' && c11 <= '9') {
            return true;
        }
        return false;
    }

    public boolean B(String str) {
        b();
        int length = str.length();
        if (length > this.f55371c - this.f55373e) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (Character.toUpperCase(str.charAt(i11)) != Character.toUpperCase(this.f55369a[this.f55373e + i11])) {
                return false;
            }
        }
        return true;
    }

    public boolean C() {
        if (r()) {
            return false;
        }
        char c11 = this.f55369a[this.f55373e];
        if ((c11 < 'A' || c11 > 'Z') && ((c11 < 'a' || c11 > 'z') && !Character.isLetter(c11))) {
            return false;
        }
        return true;
    }

    public int D(char c11) {
        b();
        for (int i11 = this.f55373e; i11 < this.f55371c; i11++) {
            if (c11 == this.f55369a[i11]) {
                return i11 - this.f55373e;
            }
        }
        return -1;
    }

    public int E(CharSequence charSequence) {
        b();
        char charAt = charSequence.charAt(0);
        int i11 = this.f55373e;
        while (i11 < this.f55371c) {
            int i12 = 1;
            if (charAt != this.f55369a[i11]) {
                do {
                    i11++;
                    if (i11 >= this.f55371c) {
                        break;
                    }
                } while (charAt == this.f55369a[i11]);
            }
            int i13 = i11 + 1;
            int length = (charSequence.length() + i13) - 1;
            int i14 = this.f55371c;
            if (i11 < i14 && length <= i14) {
                int i15 = i13;
                while (i15 < length && charSequence.charAt(i12) == this.f55369a[i15]) {
                    i15++;
                    i12++;
                }
                if (i15 == length) {
                    return i11 - this.f55373e;
                }
            }
            i11 = i13;
        }
        return -1;
    }

    public int F() {
        return this.f55374f + this.f55373e;
    }

    public void H() {
        this.f55373e = this.f55375g;
    }

    public void I() {
        this.f55373e--;
    }

    public void a() {
        this.f55373e++;
    }

    public final void b() {
        int i11 = this.f55373e;
        if (i11 >= this.f55372d) {
            try {
                this.f55370b.skip((long) i11);
                this.f55370b.mark(4096);
                int read = this.f55370b.read(this.f55369a);
                this.f55370b.reset();
                if (read != -1) {
                    this.f55371c = read;
                    this.f55374f += this.f55373e;
                    this.f55373e = 0;
                    this.f55375g = 0;
                    if (read > 3072) {
                        read = 3072;
                    }
                    this.f55372d = read;
                }
            } catch (IOException e11) {
                throw new UncheckedIOException(e11);
            }
        }
    }

    public char d() {
        b();
        char c11 = s() ? 65535 : this.f55369a[this.f55373e];
        this.f55373e++;
        return c11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e() {
        /*
            r6 = this;
            r6.b()
            int r0 = r6.f55373e
            int r1 = r6.f55371c
            char[] r2 = r6.f55369a
        L_0x0009:
            int r3 = r6.f55373e
            if (r3 >= r1) goto L_0x001f
            char r4 = r2[r3]
            r5 = 38
            if (r4 == r5) goto L_0x001f
            r5 = 60
            if (r4 == r5) goto L_0x001f
            if (r4 != 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            int r3 = r3 + 1
            r6.f55373e = r3
            goto L_0x0009
        L_0x001f:
            if (r3 <= r0) goto L_0x002b
            char[] r1 = r6.f55369a
            java.lang.String[] r2 = r6.f55376h
            int r3 = r3 - r0
            java.lang.String r0 = c(r1, r2, r0, r3)
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = ""
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.noties.markwon.html.jsoup.parser.a.e():java.lang.String");
    }

    public String f() {
        int i11;
        char c11;
        b();
        int i12 = this.f55373e;
        while (true) {
            i11 = this.f55373e;
            if (i11 < this.f55371c && (c11 = this.f55369a[i11]) >= '0' && c11 <= '9') {
                this.f55373e = i11 + 1;
            }
        }
        return c(this.f55369a, this.f55376h, i12, i11 - i12);
    }

    public String g() {
        int i11;
        char c11;
        b();
        int i12 = this.f55373e;
        while (true) {
            i11 = this.f55373e;
            if (i11 < this.f55371c && (((c11 = this.f55369a[i11]) >= '0' && c11 <= '9') || ((c11 >= 'A' && c11 <= 'F') || (c11 >= 'a' && c11 <= 'f')))) {
                this.f55373e = i11 + 1;
            }
        }
        return c(this.f55369a, this.f55376h, i12, i11 - i12);
    }

    public String h() {
        char c11;
        b();
        int i11 = this.f55373e;
        while (true) {
            int i12 = this.f55373e;
            if (i12 < this.f55371c && (((c11 = this.f55369a[i12]) >= 'A' && c11 <= 'Z') || ((c11 >= 'a' && c11 <= 'z') || Character.isLetter(c11)))) {
                this.f55373e++;
            }
        }
        return c(this.f55369a, this.f55376h, i11, this.f55373e - i11);
    }

    public String i() {
        char c11;
        b();
        int i11 = this.f55373e;
        while (true) {
            int i12 = this.f55373e;
            if (i12 < this.f55371c && (((c11 = this.f55369a[i12]) >= 'A' && c11 <= 'Z') || ((c11 >= 'a' && c11 <= 'z') || Character.isLetter(c11)))) {
                this.f55373e++;
            }
        }
        while (!s() && (r1 = this.f55369a[r2]) >= '0' && r1 <= '9') {
            this.f55373e = (r2 = this.f55373e) + 1;
        }
        return c(this.f55369a, this.f55376h, i11, this.f55373e - i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String j() {
        /*
            r6 = this;
            r6.b()
            int r0 = r6.f55373e
            int r1 = r6.f55371c
            char[] r2 = r6.f55369a
        L_0x0009:
            int r3 = r6.f55373e
            if (r3 >= r1) goto L_0x0033
            char r4 = r2[r3]
            r5 = 9
            if (r4 == r5) goto L_0x0033
            r5 = 10
            if (r4 == r5) goto L_0x0033
            r5 = 13
            if (r4 == r5) goto L_0x0033
            r5 = 12
            if (r4 == r5) goto L_0x0033
            r5 = 32
            if (r4 == r5) goto L_0x0033
            r5 = 47
            if (r4 == r5) goto L_0x0033
            r5 = 62
            if (r4 == r5) goto L_0x0033
            if (r4 != 0) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            int r3 = r3 + 1
            r6.f55373e = r3
            goto L_0x0009
        L_0x0033:
            if (r3 <= r0) goto L_0x003f
            char[] r1 = r6.f55369a
            java.lang.String[] r2 = r6.f55376h
            int r3 = r3 - r0
            java.lang.String r0 = c(r1, r2, r0, r3)
            goto L_0x0041
        L_0x003f:
            java.lang.String r0 = ""
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.noties.markwon.html.jsoup.parser.a.j():java.lang.String");
    }

    public String k(char c11) {
        int D = D(c11);
        if (D == -1) {
            return o();
        }
        String c12 = c(this.f55369a, this.f55376h, this.f55373e, D);
        this.f55373e += D;
        return c12;
    }

    public String l(String str) {
        int E = E(str);
        if (E == -1) {
            return o();
        }
        String c11 = c(this.f55369a, this.f55376h, this.f55373e, E);
        this.f55373e += E;
        return c11;
    }

    public String m(char... cArr) {
        b();
        int i11 = this.f55373e;
        int i12 = this.f55371c;
        char[] cArr2 = this.f55369a;
        loop0:
        while (this.f55373e < i12) {
            for (char c11 : cArr) {
                if (cArr2[this.f55373e] == c11) {
                    break loop0;
                }
            }
            this.f55373e++;
        }
        int i13 = this.f55373e;
        return i13 > i11 ? c(this.f55369a, this.f55376h, i11, i13 - i11) : "";
    }

    public String n(char... cArr) {
        b();
        int i11 = this.f55373e;
        int i12 = this.f55371c;
        char[] cArr2 = this.f55369a;
        while (true) {
            int i13 = this.f55373e;
            if (i13 >= i12 || Arrays.binarySearch(cArr, cArr2[i13]) >= 0) {
                int i14 = this.f55373e;
            } else {
                this.f55373e++;
            }
        }
        int i142 = this.f55373e;
        return i142 > i11 ? c(this.f55369a, this.f55376h, i11, i142 - i11) : "";
    }

    public String o() {
        b();
        char[] cArr = this.f55369a;
        String[] strArr = this.f55376h;
        int i11 = this.f55373e;
        String c11 = c(cArr, strArr, i11, this.f55371c - i11);
        this.f55373e = this.f55371c;
        return c11;
    }

    public boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return E(str.toLowerCase(locale)) > -1 || E(str.toUpperCase(locale)) > -1;
    }

    public char q() {
        b();
        if (s()) {
            return 65535;
        }
        return this.f55369a[this.f55373e];
    }

    public boolean r() {
        b();
        return this.f55373e >= this.f55371c;
    }

    public final boolean s() {
        return this.f55373e >= this.f55371c;
    }

    public void t() {
        this.f55375g = this.f55373e;
    }

    public String toString() {
        char[] cArr = this.f55369a;
        int i11 = this.f55373e;
        return new String(cArr, i11, this.f55371c - i11);
    }

    public boolean u(String str) {
        b();
        if (!x(str)) {
            return false;
        }
        this.f55373e += str.length();
        return true;
    }

    public boolean v(String str) {
        if (!B(str)) {
            return false;
        }
        this.f55373e += str.length();
        return true;
    }

    public boolean w(char c11) {
        return !r() && this.f55369a[this.f55373e] == c11;
    }

    public boolean x(String str) {
        b();
        int length = str.length();
        if (length > this.f55371c - this.f55373e) {
            return false;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (str.charAt(i11) != this.f55369a[this.f55373e + i11]) {
                return false;
            }
        }
        return true;
    }

    public boolean y(char... cArr) {
        if (r()) {
            return false;
        }
        b();
        char c11 = this.f55369a[this.f55373e];
        for (char c12 : cArr) {
            if (c12 == c11) {
                return true;
            }
        }
        return false;
    }

    public boolean z(char[] cArr) {
        b();
        return !r() && Arrays.binarySearch(cArr, this.f55369a[this.f55373e]) >= 0;
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }
}
