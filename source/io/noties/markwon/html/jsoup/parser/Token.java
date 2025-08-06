package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.helper.Normalizer;
import io.noties.markwon.html.jsoup.nodes.Attributes;

public abstract class Token {

    /* renamed from: a  reason: collision with root package name */
    public final TokenType f55351a;

    public static final class StartTag extends g {
        public StartTag() {
            super(TokenType.StartTag);
            this.f55368j = new Attributes();
        }

        /* renamed from: o */
        public g a() {
            super.a();
            this.f55368j = new Attributes();
            return this;
        }

        public String toString() {
            Attributes attributes = this.f55368j;
            if (attributes == null || attributes.size() <= 0) {
                return "<" + m() + ">";
            }
            return "<" + m() + " " + this.f55368j.toString() + ">";
        }
    }

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public static final class a extends b {
        public a(String str) {
            c(str);
        }

        public String toString() {
            return "<![CDATA[" + d() + "]]>";
        }
    }

    public static class b extends Token {

        /* renamed from: b  reason: collision with root package name */
        public String f55352b;

        public b() {
            super(TokenType.Character);
        }

        public Token a() {
            this.f55352b = null;
            return this;
        }

        public b c(String str) {
            this.f55352b = str;
            return this;
        }

        public String d() {
            return this.f55352b;
        }

        public String toString() {
            return d();
        }
    }

    public static final class c extends Token {

        /* renamed from: b  reason: collision with root package name */
        public final StringBuilder f55353b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public boolean f55354c = false;

        public c() {
            super(TokenType.Comment);
        }

        public Token a() {
            Token.b(this.f55353b);
            this.f55354c = false;
            return this;
        }

        public String c() {
            return this.f55353b.toString();
        }

        public String toString() {
            return "<!--" + c() + "-->";
        }
    }

    public static final class d extends Token {

        /* renamed from: b  reason: collision with root package name */
        public final StringBuilder f55355b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public String f55356c = null;

        /* renamed from: d  reason: collision with root package name */
        public final StringBuilder f55357d = new StringBuilder();

        /* renamed from: e  reason: collision with root package name */
        public final StringBuilder f55358e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        public boolean f55359f = false;

        public d() {
            super(TokenType.Doctype);
        }

        public Token a() {
            Token.b(this.f55355b);
            this.f55356c = null;
            Token.b(this.f55357d);
            Token.b(this.f55358e);
            this.f55359f = false;
            return this;
        }
    }

    public static final class e extends Token {
        public e() {
            super(TokenType.EOF);
        }

        public Token a() {
            return this;
        }
    }

    public static final class f extends g {
        public f() {
            super(TokenType.EndTag);
        }

        public String toString() {
            return "</" + m() + ">";
        }
    }

    public static abstract class g extends Token {

        /* renamed from: b  reason: collision with root package name */
        public String f55360b;

        /* renamed from: c  reason: collision with root package name */
        public String f55361c;

        /* renamed from: d  reason: collision with root package name */
        public String f55362d;

        /* renamed from: e  reason: collision with root package name */
        public StringBuilder f55363e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        public String f55364f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f55365g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f55366h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f55367i = false;

        /* renamed from: j  reason: collision with root package name */
        public Attributes f55368j;

        public g(TokenType tokenType) {
            super(tokenType);
        }

        public final void c(char c11) {
            d(String.valueOf(c11));
        }

        public final void d(String str) {
            String str2 = this.f55362d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f55362d = str;
        }

        public final void e(char c11) {
            j();
            this.f55363e.append(c11);
        }

        public final void f(String str) {
            j();
            if (this.f55363e.length() == 0) {
                this.f55364f = str;
            } else {
                this.f55363e.append(str);
            }
        }

        public final void g(int[] iArr) {
            j();
            for (int appendCodePoint : iArr) {
                this.f55363e.appendCodePoint(appendCodePoint);
            }
        }

        public final void h(char c11) {
            i(String.valueOf(c11));
        }

        public final void i(String str) {
            String str2 = this.f55360b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f55360b = str;
            this.f55361c = Normalizer.a(str);
        }

        public final void j() {
            this.f55366h = true;
            String str = this.f55364f;
            if (str != null) {
                this.f55363e.append(str);
                this.f55364f = null;
            }
        }

        public final void k() {
            if (this.f55362d != null) {
                n();
            }
        }

        public final g l(String str) {
            this.f55360b = str;
            this.f55361c = Normalizer.a(str);
            return this;
        }

        public final String m() {
            String str = this.f55360b;
            vz.a.b(str == null || str.length() == 0);
            return this.f55360b;
        }

        public final void n() {
            String str;
            if (this.f55368j == null) {
                this.f55368j = new Attributes();
            }
            String str2 = this.f55362d;
            if (str2 != null) {
                String trim = str2.trim();
                this.f55362d = trim;
                if (trim.length() > 0) {
                    if (this.f55366h) {
                        str = this.f55363e.length() > 0 ? this.f55363e.toString() : this.f55364f;
                    } else {
                        str = this.f55365g ? "" : null;
                    }
                    this.f55368j.l(this.f55362d, str);
                }
            }
            this.f55362d = null;
            this.f55365g = false;
            this.f55366h = false;
            Token.b(this.f55363e);
            this.f55364f = null;
        }

        /* renamed from: o */
        public g a() {
            this.f55360b = null;
            this.f55361c = null;
            this.f55362d = null;
            Token.b(this.f55363e);
            this.f55364f = null;
            this.f55365g = false;
            this.f55366h = false;
            this.f55367i = false;
            this.f55368j = null;
            return this;
        }

        public final void p() {
            this.f55365g = true;
        }
    }

    public Token(TokenType tokenType) {
        this.f55351a = tokenType;
    }

    public static void b(StringBuilder sb2) {
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
    }

    public abstract Token a();
}
