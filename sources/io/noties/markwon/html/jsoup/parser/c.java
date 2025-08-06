package io.noties.markwon.html.jsoup.parser;

import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import io.noties.markwon.html.jsoup.parser.Token;
import java.util.Arrays;
import vz.a;
import wz.b;

public final class c {

    /* renamed from: r  reason: collision with root package name */
    public static final char[] f55379r;

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f55380s = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 381, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* renamed from: a  reason: collision with root package name */
    public final a f55381a;

    /* renamed from: b  reason: collision with root package name */
    public final ParseErrorList f55382b;

    /* renamed from: c  reason: collision with root package name */
    public TokeniserState f55383c = TokeniserState.Data;

    /* renamed from: d  reason: collision with root package name */
    public Token f55384d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55385e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f55386f = null;

    /* renamed from: g  reason: collision with root package name */
    public StringBuilder f55387g = new StringBuilder(1024);

    /* renamed from: h  reason: collision with root package name */
    public StringBuilder f55388h = new StringBuilder(1024);

    /* renamed from: i  reason: collision with root package name */
    public Token.g f55389i;

    /* renamed from: j  reason: collision with root package name */
    public Token.StartTag f55390j = new Token.StartTag();

    /* renamed from: k  reason: collision with root package name */
    public Token.f f55391k = new Token.f();

    /* renamed from: l  reason: collision with root package name */
    public Token.b f55392l = new Token.b();

    /* renamed from: m  reason: collision with root package name */
    public Token.d f55393m = new Token.d();

    /* renamed from: n  reason: collision with root package name */
    public Token.c f55394n = new Token.c();

    /* renamed from: o  reason: collision with root package name */
    public String f55395o;

    /* renamed from: p  reason: collision with root package name */
    public final int[] f55396p = new int[1];

    /* renamed from: q  reason: collision with root package name */
    public final int[] f55397q = new int[2];

    static {
        char[] cArr = {9, 10, 13, 12, ' ', '<', '&'};
        f55379r = cArr;
        Arrays.sort(cArr);
    }

    public c(a aVar, ParseErrorList parseErrorList) {
        this.f55381a = aVar;
        this.f55382b = parseErrorList;
    }

    public void a(TokeniserState tokeniserState) {
        this.f55381a.a();
        this.f55383c = tokeniserState;
    }

    public String b() {
        return this.f55395o;
    }

    public final void c(String str) {
        if (this.f55382b.canAddError()) {
            this.f55382b.add(new b(this.f55381a.F(), "Invalid character reference: %s", str));
        }
    }

    public int[] d(Character ch2, boolean z11) {
        int i11;
        if (this.f55381a.r()) {
            return null;
        }
        if ((ch2 != null && ch2.charValue() == this.f55381a.q()) || this.f55381a.z(f55379r)) {
            return null;
        }
        int[] iArr = this.f55396p;
        this.f55381a.t();
        if (this.f55381a.u("#")) {
            boolean v11 = this.f55381a.v("X");
            a aVar = this.f55381a;
            String g11 = v11 ? aVar.g() : aVar.f();
            if (g11.length() == 0) {
                c("numeric reference with no numerals");
                this.f55381a.H();
                return null;
            }
            if (!this.f55381a.u(";")) {
                c("missing semicolon");
            }
            try {
                i11 = Integer.valueOf(g11, v11 ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                i11 = -1;
            }
            if (i11 == -1 || ((i11 >= 55296 && i11 <= 57343) || i11 > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (i11 >= 128) {
                int[] iArr2 = f55380s;
                if (i11 < iArr2.length + 128) {
                    c("character is not a valid unicode code point");
                    i11 = iArr2[i11 - 128];
                }
            }
            iArr[0] = i11;
            return iArr;
        }
        String i12 = this.f55381a.i();
        boolean w11 = this.f55381a.w(';');
        if (!(b.b(i12) && w11)) {
            this.f55381a.H();
            if (w11) {
                c(String.format("invalid named referenece '%s'", new Object[]{i12}));
            }
            return null;
        } else if (!z11 || (!this.f55381a.C() && !this.f55381a.A() && !this.f55381a.y('=', '-', '_'))) {
            if (!this.f55381a.u(";")) {
                c("missing semicolon");
            }
            int a11 = b.a(i12, this.f55397q);
            if (a11 == 1) {
                iArr[0] = this.f55397q[0];
                return iArr;
            } else if (a11 == 2) {
                return this.f55397q;
            } else {
                a.a("Unexpected characters returned for " + i12);
                return this.f55397q;
            }
        } else {
            this.f55381a.H();
            return null;
        }
    }

    public void e() {
        this.f55394n.a();
    }

    public void f() {
        this.f55393m.a();
    }

    public Token.g g(boolean z11) {
        Token.g o11 = z11 ? this.f55390j.a() : this.f55391k.a();
        this.f55389i = o11;
        return o11;
    }

    public void h() {
        Token.b(this.f55388h);
    }

    public void i(char c11) {
        k(String.valueOf(c11));
    }

    public void j(Token token) {
        a.c(this.f55385e, "There is an unread token pending!");
        this.f55384d = token;
        this.f55385e = true;
        Token.TokenType tokenType = token.f55351a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f55395o = ((Token.StartTag) token).f55360b;
        } else if (tokenType == Token.TokenType.EndTag && ((Token.f) token).f55368j != null) {
            r("Attributes incorrectly present on end tag");
        }
    }

    public void k(String str) {
        if (this.f55386f == null) {
            this.f55386f = str;
            return;
        }
        if (this.f55387g.length() == 0) {
            this.f55387g.append(this.f55386f);
        }
        this.f55387g.append(str);
    }

    public void l(int[] iArr) {
        k(new String(iArr, 0, iArr.length));
    }

    public void m() {
        j(this.f55394n);
    }

    public void n() {
        j(this.f55393m);
    }

    public void o() {
        this.f55389i.k();
        j(this.f55389i);
    }

    public void p(TokeniserState tokeniserState) {
        if (this.f55382b.canAddError()) {
            this.f55382b.add(new b(this.f55381a.F(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void q(TokeniserState tokeniserState) {
        if (this.f55382b.canAddError()) {
            this.f55382b.add(new b(this.f55381a.F(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f55381a.q()), tokeniserState));
        }
    }

    public void r(String str) {
        if (this.f55382b.canAddError()) {
            this.f55382b.add(new b(this.f55381a.F(), str));
        }
    }

    public boolean s() {
        return this.f55395o != null && this.f55389i.m().equalsIgnoreCase(this.f55395o);
    }

    public Token t() {
        while (!this.f55385e) {
            this.f55383c.read(this, this.f55381a);
        }
        if (this.f55387g.length() > 0) {
            String sb2 = this.f55387g.toString();
            StringBuilder sb3 = this.f55387g;
            sb3.delete(0, sb3.length());
            this.f55386f = null;
            return this.f55392l.c(sb2);
        }
        String str = this.f55386f;
        if (str != null) {
            Token.b c11 = this.f55392l.c(str);
            this.f55386f = null;
            return c11;
        }
        this.f55385e = false;
        return this.f55384d;
    }

    public void u(TokeniserState tokeniserState) {
        this.f55383c = tokeniserState;
    }
}
