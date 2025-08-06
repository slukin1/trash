package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import z0.d;
import z0.e;
import z0.f;

public final class BidiFormatter {

    /* renamed from: d  reason: collision with root package name */
    public static final d f8451d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f8452e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    public static final String f8453f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    public static final BidiFormatter f8454g;

    /* renamed from: h  reason: collision with root package name */
    public static final BidiFormatter f8455h;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8456a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8457b;

    /* renamed from: c  reason: collision with root package name */
    public final d f8458c;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8459a;

        /* renamed from: b  reason: collision with root package name */
        public int f8460b;

        /* renamed from: c  reason: collision with root package name */
        public d f8461c;

        public Builder() {
            c(BidiFormatter.e(Locale.getDefault()));
        }

        public static BidiFormatter b(boolean z11) {
            return z11 ? BidiFormatter.f8455h : BidiFormatter.f8454g;
        }

        public BidiFormatter a() {
            if (this.f8460b == 2 && this.f8461c == BidiFormatter.f8451d) {
                return b(this.f8459a);
            }
            return new BidiFormatter(this.f8459a, this.f8460b, this.f8461c);
        }

        public final void c(boolean z11) {
            this.f8459a = z11;
            this.f8461c = BidiFormatter.f8451d;
            this.f8460b = 2;
        }
    }

    public static class a {

        /* renamed from: f  reason: collision with root package name */
        public static final byte[] f8462f = new byte[Params.POLY_BYTES];

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f8463a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8464b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8465c;

        /* renamed from: d  reason: collision with root package name */
        public int f8466d;

        /* renamed from: e  reason: collision with root package name */
        public char f8467e;

        static {
            for (int i11 = 0; i11 < 1792; i11++) {
                f8462f[i11] = Character.getDirectionality(i11);
            }
        }

        public a(CharSequence charSequence, boolean z11) {
            this.f8463a = charSequence;
            this.f8464b = z11;
            this.f8465c = charSequence.length();
        }

        public static byte c(char c11) {
            return c11 < 1792 ? f8462f[c11] : Character.getDirectionality(c11);
        }

        public byte a() {
            char charAt = this.f8463a.charAt(this.f8466d - 1);
            this.f8467e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f8463a, this.f8466d);
                this.f8466d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f8466d--;
            byte c11 = c(this.f8467e);
            if (!this.f8464b) {
                return c11;
            }
            char c12 = this.f8467e;
            if (c12 == '>') {
                return h();
            }
            return c12 == ';' ? f() : c11;
        }

        public byte b() {
            char charAt = this.f8463a.charAt(this.f8466d);
            this.f8467e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f8463a, this.f8466d);
                this.f8466d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f8466d++;
            byte c11 = c(this.f8467e);
            if (!this.f8464b) {
                return c11;
            }
            char c12 = this.f8467e;
            if (c12 == '<') {
                return i();
            }
            return c12 == '&' ? g() : c11;
        }

        public int d() {
            this.f8466d = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (this.f8466d < this.f8465c && i11 == 0) {
                byte b11 = b();
                if (b11 != 0) {
                    if (b11 == 1 || b11 == 2) {
                        if (i13 == 0) {
                            return 1;
                        }
                    } else if (b11 != 9) {
                        switch (b11) {
                            case 14:
                            case 15:
                                i13++;
                                i12 = -1;
                                continue;
                            case 16:
                            case 17:
                                i13++;
                                i12 = 1;
                                continue;
                            case 18:
                                i13--;
                                i12 = 0;
                                continue;
                        }
                    }
                } else if (i13 == 0) {
                    return -1;
                }
                i11 = i13;
            }
            if (i11 == 0) {
                return 0;
            }
            if (i12 != 0) {
                return i12;
            }
            while (this.f8466d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i11 == i13) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i11 == i13) {
                            return 1;
                        }
                        break;
                    case 18:
                        i13++;
                        continue;
                }
                i13--;
            }
            return 0;
        }

        public int e() {
            this.f8466d = this.f8465c;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                while (this.f8466d > 0) {
                    byte a11 = a();
                    if (a11 != 0) {
                        if (a11 == 1 || a11 == 2) {
                            if (i11 == 0) {
                                return 1;
                            }
                            if (i12 == 0) {
                            }
                        } else if (a11 != 9) {
                            switch (a11) {
                                case 14:
                                case 15:
                                    if (i12 == i11) {
                                        return -1;
                                    }
                                    break;
                                case 16:
                                case 17:
                                    if (i12 == i11) {
                                        return 1;
                                    }
                                    break;
                                case 18:
                                    i11++;
                                    break;
                                default:
                                    if (i12 != 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            i11--;
                        } else {
                            continue;
                        }
                    } else if (i11 == 0) {
                        return -1;
                    } else {
                        if (i12 == 0) {
                        }
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char charAt;
            int i11 = this.f8466d;
            do {
                int i12 = this.f8466d;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f8463a;
                int i13 = i12 - 1;
                this.f8466d = i13;
                charAt = charSequence.charAt(i13);
                this.f8467e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f8466d = i11;
            this.f8467e = ';';
            return 13;
        }

        public final byte g() {
            char charAt;
            do {
                int i11 = this.f8466d;
                if (i11 >= this.f8465c) {
                    return 12;
                }
                CharSequence charSequence = this.f8463a;
                this.f8466d = i11 + 1;
                charAt = charSequence.charAt(i11);
                this.f8467e = charAt;
            } while (charAt != ';');
            return 12;
        }

        public final byte h() {
            char charAt;
            int i11 = this.f8466d;
            while (true) {
                int i12 = this.f8466d;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f8463a;
                int i13 = i12 - 1;
                this.f8466d = i13;
                char charAt2 = charSequence.charAt(i13);
                this.f8467e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i14 = this.f8466d;
                        if (i14 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f8463a;
                        int i15 = i14 - 1;
                        this.f8466d = i15;
                        charAt = charSequence2.charAt(i15);
                        this.f8467e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f8466d = i11;
            this.f8467e = '>';
            return 13;
        }

        public final byte i() {
            char charAt;
            int i11 = this.f8466d;
            while (true) {
                int i12 = this.f8466d;
                if (i12 < this.f8465c) {
                    CharSequence charSequence = this.f8463a;
                    this.f8466d = i12 + 1;
                    char charAt2 = charSequence.charAt(i12);
                    this.f8467e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i13 = this.f8466d;
                            if (i13 >= this.f8465c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f8463a;
                            this.f8466d = i13 + 1;
                            charAt = charSequence2.charAt(i13);
                            this.f8467e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f8466d = i11;
                    this.f8467e = '<';
                    return 13;
                }
            }
        }
    }

    static {
        d dVar = e.f16900c;
        f8451d = dVar;
        f8454g = new BidiFormatter(false, 2, dVar);
        f8455h = new BidiFormatter(true, 2, dVar);
    }

    public BidiFormatter(boolean z11, int i11, d dVar) {
        this.f8456a = z11;
        this.f8457b = i11;
        this.f8458c = dVar;
    }

    public static int a(CharSequence charSequence) {
        return new a(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new a(charSequence, false).e();
    }

    public static BidiFormatter c() {
        return new Builder().a();
    }

    public static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    public boolean d() {
        return (this.f8457b & 2) != 0;
    }

    public final String f(CharSequence charSequence, d dVar) {
        boolean a11 = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f8456a && (a11 || b(charSequence) == 1)) {
            return f8452e;
        }
        if (this.f8456a) {
            return (!a11 || b(charSequence) == -1) ? f8453f : "";
        }
        return "";
    }

    public final String g(CharSequence charSequence, d dVar) {
        boolean a11 = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f8456a && (a11 || a(charSequence) == 1)) {
            return f8452e;
        }
        if (this.f8456a) {
            return (!a11 || a(charSequence) == -1) ? f8453f : "";
        }
        return "";
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f8458c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z11) {
        if (charSequence == null) {
            return null;
        }
        boolean a11 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z11) {
            spannableStringBuilder.append(g(charSequence, a11 ? e.f16899b : e.f16898a));
        }
        if (a11 != this.f8456a) {
            spannableStringBuilder.append(a11 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z11) {
            spannableStringBuilder.append(f(charSequence, a11 ? e.f16899b : e.f16898a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f8458c, true);
    }

    public String k(String str, d dVar, boolean z11) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z11).toString();
    }
}
