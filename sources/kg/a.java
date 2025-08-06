package kg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f40541a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40542b;

    /* renamed from: c  reason: collision with root package name */
    public int f40543c;

    /* renamed from: d  reason: collision with root package name */
    public int f40544d;

    /* renamed from: e  reason: collision with root package name */
    public int f40545e;

    /* renamed from: f  reason: collision with root package name */
    public int f40546f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f40547g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f40541a = name;
        this.f40542b = name.length();
    }

    public final int a(int i11) {
        int i12;
        int i13;
        int i14 = i11 + 1;
        if (i14 < this.f40542b) {
            char[] cArr = this.f40547g;
            char c11 = cArr[i11];
            if (c11 >= '0' && c11 <= '9') {
                i12 = c11 - '0';
            } else if (c11 >= 'a' && c11 <= 'f') {
                i12 = c11 - 'W';
            } else if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f40541a);
            } else {
                i12 = c11 - '7';
            }
            char c12 = cArr[i14];
            if (c12 >= '0' && c12 <= '9') {
                i13 = c12 - '0';
            } else if (c12 >= 'a' && c12 <= 'f') {
                i13 = c12 - 'W';
            } else if (c12 < 'A' || c12 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f40541a);
            } else {
                i13 = c12 - '7';
            }
            return (i12 << 4) + i13;
        }
        throw new IllegalStateException("Malformed DN: " + this.f40541a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        r1 = r8.f40547g;
        r2 = r8.f40544d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.f40546f - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b() {
        /*
            r8 = this;
            int r0 = r8.f40543c
            r8.f40544d = r0
            r8.f40545e = r0
        L_0x0006:
            int r0 = r8.f40543c
            int r1 = r8.f40542b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f40547g
            int r2 = r8.f40544d
            int r3 = r8.f40545e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f40547g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x005e
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.f40545e
            int r3 = r2 + 1
            r8.f40545e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f40543c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.f40545e
            int r2 = r0 + 1
            r8.f40545e = r2
            char r2 = r8.c()
            r1[r0] = r2
            int r0 = r8.f40543c
            int r0 = r0 + 1
            r8.f40543c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f40544d
            int r3 = r8.f40545e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x005e:
            int r2 = r8.f40545e
            r8.f40546f = r2
            int r0 = r0 + 1
            r8.f40543c = r0
            int r0 = r2 + 1
            r8.f40545e = r0
            r1[r2] = r6
        L_0x006c:
            int r0 = r8.f40543c
            int r1 = r8.f40542b
            if (r0 >= r1) goto L_0x0085
            char[] r2 = r8.f40547g
            char r7 = r2[r0]
            if (r7 != r6) goto L_0x0085
            int r1 = r8.f40545e
            int r7 = r1 + 1
            r8.f40545e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f40543c = r0
            goto L_0x006c
        L_0x0085:
            if (r0 == r1) goto L_0x0095
            char[] r1 = r8.f40547g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x0095
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x0095
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x0095:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f40547g
            int r2 = r8.f40544d
            int r3 = r8.f40546f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.a.b():java.lang.String");
    }

    public final char c() {
        int i11 = this.f40543c + 1;
        this.f40543c = i11;
        if (i11 != this.f40542b) {
            char[] cArr = this.f40547g;
            char c11 = cArr[i11];
            if (!(c11 == ' ' || c11 == '%' || c11 == '\\' || c11 == '_' || c11 == '\"' || c11 == '#')) {
                switch (c11) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c11) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return e();
                        }
                }
            }
            return cArr[i11];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f40541a);
    }

    public List<String> d(String str) {
        String str2;
        this.f40543c = 0;
        this.f40544d = 0;
        this.f40545e = 0;
        this.f40546f = 0;
        this.f40547g = this.f40541a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String g11 = g();
        if (g11 == null) {
            return emptyList;
        }
        do {
            int i11 = this.f40543c;
            if (i11 < this.f40542b) {
                char c11 = this.f40547g[i11];
                if (c11 == '\"') {
                    str2 = h();
                } else if (c11 != '#') {
                    str2 = (c11 == '+' || c11 == ',' || c11 == ';') ? "" : b();
                } else {
                    str2 = f();
                }
                if (str.equalsIgnoreCase(g11)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i12 = this.f40543c;
                if (i12 < this.f40542b) {
                    char[] cArr = this.f40547g;
                    if (cArr[i12] == ',' || cArr[i12] == ';' || cArr[i12] == '+') {
                        this.f40543c = i12 + 1;
                        g11 = g();
                    } else {
                        throw new IllegalStateException("Malformed DN: " + this.f40541a);
                    }
                }
            }
            return emptyList;
        } while (g11 != null);
        throw new IllegalStateException("Malformed DN: " + this.f40541a);
    }

    public final char e() {
        int i11;
        int i12;
        int a11 = a(this.f40543c);
        this.f40543c++;
        if (a11 < 128) {
            return (char) a11;
        }
        if (a11 < 192 || a11 > 247) {
            return '?';
        }
        if (a11 <= 223) {
            i12 = a11 & 31;
            i11 = 1;
        } else if (a11 <= 239) {
            i11 = 2;
            i12 = a11 & 15;
        } else {
            i11 = 3;
            i12 = a11 & 7;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.f40543c + 1;
            this.f40543c = i14;
            if (i14 == this.f40542b || this.f40547g[i14] != '\\') {
                return '?';
            }
            int i15 = i14 + 1;
            this.f40543c = i15;
            int a12 = a(i15);
            this.f40543c++;
            if ((a12 & 192) != 128) {
                return '?';
            }
            i12 = (i12 << 6) + (a12 & 63);
        }
        return (char) i12;
    }

    public final String f() {
        int i11;
        int i12 = this.f40543c;
        if (i12 + 4 < this.f40542b) {
            this.f40544d = i12;
            this.f40543c = i12 + 1;
            while (true) {
                i11 = this.f40543c;
                if (i11 == this.f40542b) {
                    break;
                }
                char[] cArr = this.f40547g;
                if (cArr[i11] == '+' || cArr[i11] == ',' || cArr[i11] == ';') {
                    break;
                } else if (cArr[i11] == ' ') {
                    this.f40545e = i11;
                    this.f40543c = i11 + 1;
                    while (true) {
                        int i13 = this.f40543c;
                        if (i13 >= this.f40542b || this.f40547g[i13] != ' ') {
                            break;
                        }
                        this.f40543c = i13 + 1;
                    }
                } else {
                    if (cArr[i11] >= 'A' && cArr[i11] <= 'F') {
                        cArr[i11] = (char) (cArr[i11] + ' ');
                    }
                    this.f40543c = i11 + 1;
                }
            }
            this.f40545e = i11;
            int i14 = this.f40545e;
            int i15 = this.f40544d;
            int i16 = i14 - i15;
            if (i16 < 5 || (i16 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f40541a);
            }
            int i17 = i16 / 2;
            byte[] bArr = new byte[i17];
            int i18 = i15 + 1;
            for (int i19 = 0; i19 < i17; i19++) {
                bArr[i19] = (byte) a(i18);
                i18 += 2;
            }
            return new String(this.f40547g, this.f40544d, i16);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f40541a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String g() {
        /*
            r7 = this;
        L_0x0000:
            int r0 = r7.f40543c
            int r1 = r7.f40542b
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r7.f40547g
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r7.f40543c = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r7.f40544d = r0
            int r0 = r0 + 1
            r7.f40543c = r0
        L_0x001d:
            int r0 = r7.f40543c
            int r1 = r7.f40542b
            r3 = 61
            if (r0 >= r1) goto L_0x0034
            char[] r4 = r7.f40547g
            char r5 = r4[r0]
            if (r5 == r3) goto L_0x0034
            char r4 = r4[r0]
            if (r4 == r2) goto L_0x0034
            int r0 = r0 + 1
            r7.f40543c = r0
            goto L_0x001d
        L_0x0034:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00d5
            r7.f40545e = r0
            char[] r1 = r7.f40547g
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x0075
        L_0x0040:
            int r0 = r7.f40543c
            int r1 = r7.f40542b
            if (r0 >= r1) goto L_0x0055
            char[] r5 = r7.f40547g
            char r6 = r5[r0]
            if (r6 == r3) goto L_0x0055
            char r5 = r5[r0]
            if (r5 != r2) goto L_0x0055
            int r0 = r0 + 1
            r7.f40543c = r0
            goto L_0x0040
        L_0x0055:
            char[] r5 = r7.f40547g
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x005e
            if (r0 == r1) goto L_0x005e
            goto L_0x0075
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r7.f40541a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0075:
            int r0 = r7.f40543c
            int r0 = r0 + 1
            r7.f40543c = r0
        L_0x007b:
            int r0 = r7.f40543c
            int r1 = r7.f40542b
            if (r0 >= r1) goto L_0x008c
            char[] r1 = r7.f40547g
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x008c
            int r0 = r0 + 1
            r7.f40543c = r0
            goto L_0x007b
        L_0x008c:
            int r0 = r7.f40545e
            int r1 = r7.f40544d
            int r2 = r0 - r1
            r3 = 4
            if (r2 <= r3) goto L_0x00ca
            char[] r2 = r7.f40547g
            int r4 = r1 + 3
            char r4 = r2[r4]
            r5 = 46
            if (r4 != r5) goto L_0x00ca
            char r4 = r2[r1]
            r5 = 79
            if (r4 == r5) goto L_0x00ab
            char r4 = r2[r1]
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 != r5) goto L_0x00ca
        L_0x00ab:
            int r4 = r1 + 1
            char r5 = r2[r4]
            r6 = 73
            if (r5 == r6) goto L_0x00b9
            char r4 = r2[r4]
            r5 = 105(0x69, float:1.47E-43)
            if (r4 != r5) goto L_0x00ca
        L_0x00b9:
            int r4 = r1 + 2
            char r5 = r2[r4]
            r6 = 68
            if (r5 == r6) goto L_0x00c7
            char r2 = r2[r4]
            r4 = 100
            if (r2 != r4) goto L_0x00ca
        L_0x00c7:
            int r1 = r1 + r3
            r7.f40544d = r1
        L_0x00ca:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r7.f40547g
            int r3 = r7.f40544d
            int r0 = r0 - r3
            r1.<init>(r2, r3, r0)
            return r1
        L_0x00d5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r7.f40541a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.a.g():java.lang.String");
    }

    public final String h() {
        int i11 = this.f40543c + 1;
        this.f40543c = i11;
        this.f40544d = i11;
        this.f40545e = i11;
        while (true) {
            int i12 = this.f40543c;
            if (i12 != this.f40542b) {
                char[] cArr = this.f40547g;
                if (cArr[i12] == '\"') {
                    this.f40543c = i12 + 1;
                    while (true) {
                        int i13 = this.f40543c;
                        if (i13 >= this.f40542b || this.f40547g[i13] != ' ') {
                            char[] cArr2 = this.f40547g;
                            int i14 = this.f40544d;
                        } else {
                            this.f40543c = i13 + 1;
                        }
                    }
                    char[] cArr22 = this.f40547g;
                    int i142 = this.f40544d;
                    return new String(cArr22, i142, this.f40545e - i142);
                }
                if (cArr[i12] == '\\') {
                    cArr[this.f40545e] = c();
                } else {
                    cArr[this.f40545e] = cArr[i12];
                }
                this.f40543c++;
                this.f40545e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f40541a);
            }
        }
    }
}
