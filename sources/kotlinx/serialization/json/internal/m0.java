package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.x;

public final class m0 extends AbstractJsonLexer {

    /* renamed from: e  reason: collision with root package name */
    public final String f57932e;

    public m0(String str) {
        this.f57932e = str;
    }

    public int G(int i11) {
        if (i11 < C().length()) {
            return i11;
        }
        return -1;
    }

    public int I() {
        int i11 = this.f57852a;
        if (i11 == -1) {
            return i11;
        }
        while (i11 < C().length() && ((r1 = C().charAt(i11)) == ' ' || r1 == 10 || r1 == 13 || r1 == 9)) {
            i11++;
        }
        this.f57852a = i11;
        return i11;
    }

    public boolean L() {
        int I = I();
        if (I == C().length() || I == -1 || C().charAt(I) != ',') {
            return false;
        }
        this.f57852a++;
        return true;
    }

    /* renamed from: Q */
    public String C() {
        return this.f57932e;
    }

    public boolean f() {
        int i11 = this.f57852a;
        if (i11 == -1) {
            return false;
        }
        while (i11 < C().length()) {
            char charAt = C().charAt(i11);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i11++;
            } else {
                this.f57852a = i11;
                return D(charAt);
            }
        }
        this.f57852a = i11;
        return false;
    }

    public String k() {
        o('\"');
        int i11 = this.f57852a;
        int f02 = StringsKt__StringsKt.f0(C(), '\"', i11, false, 4, (Object) null);
        if (f02 != -1) {
            for (int i12 = i11; i12 < f02; i12++) {
                if (C().charAt(i12) == '\\') {
                    return r(C(), this.f57852a, i12);
                }
            }
            this.f57852a = f02 + 1;
            return C().substring(i11, f02);
        }
        z((byte) 1);
        throw new KotlinNothingValueException();
    }

    public String l(String str, boolean z11) {
        int i11 = this.f57852a;
        try {
            if (m() != 6) {
                return null;
            }
            if (!x.b(z11 ? k() : t(), str)) {
                this.f57852a = i11;
                return null;
            } else if (m() != 5) {
                this.f57852a = i11;
                return null;
            } else {
                String q11 = z11 ? q() : t();
                this.f57852a = i11;
                return q11;
            }
        } finally {
            this.f57852a = i11;
        }
    }

    public byte m() {
        byte a11;
        String Q = C();
        do {
            int i11 = this.f57852a;
            if (i11 == -1 || i11 >= Q.length()) {
                return 10;
            }
            int i12 = this.f57852a;
            this.f57852a = i12 + 1;
            a11 = a.a(Q.charAt(i12));
        } while (a11 == 3);
        return a11;
    }

    public void o(char c11) {
        if (this.f57852a == -1) {
            O(c11);
        }
        String Q = C();
        while (this.f57852a < Q.length()) {
            int i11 = this.f57852a;
            this.f57852a = i11 + 1;
            char charAt = Q.charAt(i11);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                if (charAt != c11) {
                    O(c11);
                } else {
                    return;
                }
            }
        }
        O(c11);
    }
}
