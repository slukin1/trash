package kotlinx.serialization.json.internal;

import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.x;

public abstract class AbstractJsonLexer {

    /* renamed from: a  reason: collision with root package name */
    public int f57852a;

    /* renamed from: b  reason: collision with root package name */
    public final JsonPath f57853b = new JsonPath();

    /* renamed from: c  reason: collision with root package name */
    public String f57854c;

    /* renamed from: d  reason: collision with root package name */
    public StringBuilder f57855d = new StringBuilder();

    public static /* synthetic */ boolean N(AbstractJsonLexer abstractJsonLexer, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = true;
            }
            return abstractJsonLexer.M(z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
    }

    public static /* synthetic */ Void y(AbstractJsonLexer abstractJsonLexer, String str, int i11, String str2, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = abstractJsonLexer.f57852a;
            }
            if ((i12 & 4) != 0) {
                str2 = "";
            }
            return abstractJsonLexer.x(str, i11, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
    }

    public final void A(String str) {
        int m02 = StringsKt__StringsKt.m0(J(0, this.f57852a), str, 0, false, 6, (Object) null);
        x("Encountered an unknown key '" + str + '\'', m02, "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    public final int B(CharSequence charSequence, int i11) {
        char charAt = charSequence.charAt(i11);
        boolean z11 = true;
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        char c11 = 'a';
        if (!('a' <= charAt && charAt < 'g')) {
            c11 = 'A';
            if ('A' > charAt || charAt >= 'G') {
                z11 = false;
            }
            if (!z11) {
                y(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c11) + 10;
    }

    public abstract CharSequence C();

    public final boolean D(char c11) {
        boolean z11 = false;
        if (((c11 == '}' || c11 == ']') || c11 == ':') || c11 == ',') {
            z11 = true;
        }
        return !z11;
    }

    public final byte E() {
        CharSequence C = C();
        int i11 = this.f57852a;
        while (true) {
            int G = G(i11);
            if (G != -1) {
                char charAt = C.charAt(G);
                if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                    i11 = G + 1;
                } else {
                    this.f57852a = G;
                    return a.a(charAt);
                }
            } else {
                this.f57852a = G;
                return 10;
            }
        }
    }

    public final String F(boolean z11) {
        String str;
        byte E = E();
        if (z11) {
            if (E != 1 && E != 0) {
                return null;
            }
            str = s();
        } else if (E != 1) {
            return null;
        } else {
            str = q();
        }
        this.f57854c = str;
        return str;
    }

    public abstract int G(int i11);

    public final void H(boolean z11) {
        ArrayList arrayList = new ArrayList();
        byte E = E();
        if (E == 8 || E == 6) {
            while (true) {
                byte E2 = E();
                boolean z12 = true;
                if (E2 != 1) {
                    if (!(E2 == 8 || E2 == 6)) {
                        z12 = false;
                    }
                    if (z12) {
                        arrayList.add(Byte.valueOf(E2));
                    } else if (E2 == 9) {
                        if (((Number) CollectionsKt___CollectionsKt.m0(arrayList)).byteValue() == 8) {
                            Object unused = CollectionsKt__MutableCollectionsKt.H(arrayList);
                        } else {
                            int i11 = this.f57852a;
                            throw w.f(i11, "found ] instead of } at path: " + this.f57853b, C());
                        }
                    } else if (E2 == 7) {
                        if (((Number) CollectionsKt___CollectionsKt.m0(arrayList)).byteValue() == 6) {
                            Object unused2 = CollectionsKt__MutableCollectionsKt.H(arrayList);
                        } else {
                            int i12 = this.f57852a;
                            throw w.f(i12, "found } instead of ] at path: " + this.f57853b, C());
                        }
                    } else if (E2 == 10) {
                        y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                    m();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z11) {
                    s();
                } else {
                    k();
                }
            }
        } else {
            s();
        }
    }

    public int I() {
        int G;
        char charAt;
        int i11 = this.f57852a;
        while (true) {
            G = G(i11);
            if (G == -1 || !((charAt = C().charAt(G)) == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                this.f57852a = G;
            } else {
                i11 = G + 1;
            }
        }
        this.f57852a = G;
        return G;
    }

    public String J(int i11, int i12) {
        return C().subSequence(i11, i12).toString();
    }

    public final String K() {
        String str = this.f57854c;
        this.f57854c = null;
        return str;
    }

    public abstract boolean L();

    public final boolean M(boolean z11) {
        int G = G(I());
        int length = C().length() - G;
        if (length < 4 || G == -1) {
            return false;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            if (OptionsBridge.NULL_VALUE.charAt(i11) != C().charAt(G + i11)) {
                return false;
            }
        }
        if (length > 4 && a.a(C().charAt(G + 4)) == 0) {
            return false;
        }
        if (!z11) {
            return true;
        }
        this.f57852a = G + 4;
        return true;
    }

    public final void O(char c11) {
        int i11 = this.f57852a - 1;
        this.f57852a = i11;
        if (i11 < 0 || c11 != '\"' || !x.b(s(), OptionsBridge.NULL_VALUE)) {
            z(a.a(c11));
            throw new KotlinNothingValueException();
        } else {
            x("Expected string literal but 'null' literal was found", this.f57852a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new KotlinNothingValueException();
        }
    }

    public final boolean P() {
        return C().charAt(this.f57852a - 1) != '\"';
    }

    public final int b(int i11) {
        int G = G(i11);
        if (G != -1) {
            int i12 = G + 1;
            char charAt = C().charAt(G);
            if (charAt == 'u') {
                return d(C(), i12);
            }
            char b11 = a.b(charAt);
            if (b11 != 0) {
                this.f57855d.append(b11);
                return i12;
            }
            y(this, "Invalid escaped char '" + charAt + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        y(this, "Expected escape sequence to continue, got EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final int c(int i11, int i12) {
        e(i11, i12);
        return b(i12 + 1);
    }

    public final int d(CharSequence charSequence, int i11) {
        int i12 = i11 + 4;
        if (i12 >= charSequence.length()) {
            this.f57852a = i11;
            v();
            if (this.f57852a + 4 < charSequence.length()) {
                return d(charSequence, this.f57852a);
            }
            y(this, "Unexpected EOF during unicode escape", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        this.f57855d.append((char) ((B(charSequence, i11) << 12) + (B(charSequence, i11 + 1) << 8) + (B(charSequence, i11 + 2) << 4) + B(charSequence, i11 + 3)));
        return i12;
    }

    public void e(int i11, int i12) {
        this.f57855d.append(C(), i11, i12);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean h(int i11) {
        int G = G(i11);
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        int i12 = G + 1;
        char charAt = C().charAt(G) | ' ';
        if (charAt == 'f') {
            j("alse", i12);
            return false;
        } else if (charAt == 't') {
            j("rue", i12);
            return true;
        } else {
            y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean i() {
        boolean z11;
        int I = I();
        if (I != C().length()) {
            if (C().charAt(I) == '\"') {
                I++;
                z11 = true;
            } else {
                z11 = false;
            }
            boolean h11 = h(I);
            if (z11) {
                if (this.f57852a == C().length()) {
                    y(this, "EOF", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (C().charAt(this.f57852a) == '\"') {
                    this.f57852a++;
                } else {
                    y(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return h11;
        }
        y(this, "EOF", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final void j(String str, int i11) {
        if (C().length() - i11 >= str.length()) {
            int i12 = 0;
            int length = str.length();
            while (i12 < length) {
                if (str.charAt(i12) == (C().charAt(i11 + i12) | ' ')) {
                    i12++;
                } else {
                    y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            this.f57852a = i11 + str.length();
            return;
        }
        y(this, "Unexpected end of boolean literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public abstract String k();

    public abstract String l(String str, boolean z11);

    public abstract byte m();

    public final byte n(byte b11) {
        byte m11 = m();
        if (m11 == b11) {
            return m11;
        }
        z(b11);
        throw new KotlinNothingValueException();
    }

    public void o(char c11) {
        v();
        CharSequence C = C();
        int i11 = this.f57852a;
        while (true) {
            int G = G(i11);
            if (G != -1) {
                int i12 = G + 1;
                char charAt = C.charAt(G);
                if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                    this.f57852a = i12;
                    if (charAt != c11) {
                        O(c11);
                    } else {
                        return;
                    }
                }
                i11 = i12;
            } else {
                this.f57852a = G;
                O(c11);
                return;
            }
        }
    }

    public final long p() {
        boolean z11;
        int G = G(I());
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(G) == '\"') {
            G++;
            if (G != C().length()) {
                z11 = true;
            } else {
                y(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else {
            z11 = false;
        }
        int i11 = G;
        long j11 = 0;
        boolean z12 = true;
        boolean z13 = false;
        while (z12) {
            char charAt = C().charAt(i11);
            if (charAt != '-') {
                if (a.a(charAt) != 0) {
                    break;
                }
                i11++;
                z12 = i11 != C().length();
                int i12 = charAt - '0';
                if (i12 >= 0 && i12 < 10) {
                    j11 = (j11 * ((long) 10)) - ((long) i12);
                    if (j11 > 0) {
                        y(this, "Numeric value overflow", 0, (String) null, 6, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    y(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, (String) null, 6, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else if (i11 == G) {
                i11++;
                z13 = true;
            } else {
                y(this, "Unexpected symbol '-' in numeric literal", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        if (G == i11 || (z13 && G == i11 - 1)) {
            y(this, "Expected numeric literal", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
        if (z11) {
            if (!z12) {
                y(this, "EOF", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            } else if (C().charAt(i11) == '\"') {
                i11++;
            } else {
                y(this, "Expected closing quotation mark", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        this.f57852a = i11;
        if (z13) {
            return j11;
        }
        if (j11 != Long.MIN_VALUE) {
            return -j11;
        }
        y(this, "Numeric value overflow", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String q() {
        if (this.f57854c != null) {
            return K();
        }
        return k();
    }

    public final String r(CharSequence charSequence, int i11, int i12) {
        String str;
        int G;
        char charAt = charSequence.charAt(i12);
        boolean z11 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                G = G(c(i11, i12));
                if (G == -1) {
                    y(this, "EOF", G, (String) null, 4, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i12++;
                if (i12 >= charSequence.length()) {
                    e(i11, i12);
                    G = G(i12);
                    if (G == -1) {
                        y(this, "EOF", G, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = charSequence.charAt(i12);
                }
            }
            z11 = true;
            i11 = G;
            i12 = i11;
            charAt = charSequence.charAt(i12);
        }
        if (!z11) {
            str = J(i11, i12);
        } else {
            str = u(i11, i12);
        }
        this.f57852a = i12 + 1;
        return str;
    }

    public final String s() {
        String str;
        if (this.f57854c != null) {
            return K();
        }
        int I = I();
        if (I >= C().length() || I == -1) {
            y(this, "EOF", I, (String) null, 4, (Object) null);
            throw new KotlinNothingValueException();
        }
        byte a11 = a.a(C().charAt(I));
        if (a11 == 1) {
            return q();
        }
        if (a11 == 0) {
            boolean z11 = false;
            while (a.a(C().charAt(I)) == 0) {
                I++;
                if (I >= C().length()) {
                    e(this.f57852a, I);
                    int G = G(I);
                    if (G == -1) {
                        this.f57852a = I;
                        return u(0, 0);
                    }
                    I = G;
                    z11 = true;
                }
            }
            if (!z11) {
                str = J(this.f57852a, I);
            } else {
                str = u(this.f57852a, I);
            }
            this.f57852a = I;
            return str;
        }
        y(this, "Expected beginning of the string, but got " + C().charAt(I), 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String t() {
        String s11 = s();
        if (!x.b(s11, OptionsBridge.NULL_VALUE) || !P()) {
            return s11;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "JsonReader(source='" + C() + "', currentPosition=" + this.f57852a + ')';
    }

    public final String u(int i11, int i12) {
        e(i11, i12);
        String sb2 = this.f57855d.toString();
        this.f57855d.setLength(0);
        return sb2;
    }

    public void v() {
    }

    public final void w() {
        if (m() != 10) {
            y(this, "Expected EOF after parsing, but had " + C().charAt(this.f57852a - 1) + " instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final Void x(String str, int i11, String str2) {
        String str3;
        if (str2.length() == 0) {
            str3 = "";
        } else {
            str3 = 10 + str2;
        }
        throw w.f(i11, str + " at path: " + this.f57853b.a() + str3, C());
    }

    public final Void z(byte b11) {
        String str = b11 == 1 ? "quotation mark '\"'" : b11 == 4 ? "comma ','" : b11 == 5 ? "colon ':'" : b11 == 6 ? "start of the object '{'" : b11 == 7 ? "end of the object '}'" : b11 == 8 ? "start of the array '['" : b11 == 9 ? "end of the array ']'" : "valid token";
        String valueOf = (this.f57852a == C().length() || this.f57852a <= 0) ? "EOF" : String.valueOf(C().charAt(this.f57852a - 1));
        y(this, "Expected " + str + ", but had '" + valueOf + "' instead", this.f57852a - 1, (String) null, 4, (Object) null);
        throw new KotlinNothingValueException();
    }
}
