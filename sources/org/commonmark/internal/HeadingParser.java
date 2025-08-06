package org.commonmark.internal;

import b20.a;
import c20.d;
import c20.e;
import c20.f;
import com.sumsub.sns.internal.core.common.n0;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class HeadingParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final Heading f59646a;

    /* renamed from: b  reason: collision with root package name */
    public final String f59647b;

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            CharSequence b11;
            if (fVar.e() >= Parsing.f59756a) {
                return d.c();
            }
            CharSequence b12 = fVar.b();
            int d11 = fVar.d();
            HeadingParser i11 = HeadingParser.k(b12, d11);
            if (i11 != null) {
                return d.d(i11).b(b12.length());
            }
            int j11 = HeadingParser.l(b12, d11);
            if (j11 <= 0 || (b11 = eVar.b()) == null) {
                return d.c();
            }
            return d.d(new HeadingParser(j11, b11.toString())).b(b12.length()).e();
        }
    }

    public HeadingParser(int i11, String str) {
        Heading heading = new Heading();
        this.f59646a = heading;
        heading.o(i11);
        this.f59647b = str;
    }

    public static HeadingParser k(CharSequence charSequence, int i11) {
        int k11 = Parsing.k(n0.h.f32179b, charSequence, i11, charSequence.length()) - i11;
        if (k11 == 0 || k11 > 6) {
            return null;
        }
        int i12 = i11 + k11;
        if (i12 >= charSequence.length()) {
            return new HeadingParser(k11, "");
        }
        char charAt = charSequence.charAt(i12);
        if (charAt != ' ' && charAt != 9) {
            return null;
        }
        int n11 = Parsing.n(charSequence, charSequence.length() - 1, i12);
        int l11 = Parsing.l(n0.h.f32179b, charSequence, n11, i12);
        int n12 = Parsing.n(charSequence, l11, i12);
        if (n12 != l11) {
            return new HeadingParser(k11, charSequence.subSequence(i12, n12 + 1).toString());
        }
        return new HeadingParser(k11, charSequence.subSequence(i12, n11 + 1).toString());
    }

    public static int l(CharSequence charSequence, int i11) {
        char charAt = charSequence.charAt(i11);
        if (charAt != '-') {
            if (charAt != '=') {
                return 0;
            }
            if (m(charSequence, i11 + 1, '=')) {
                return 1;
            }
        }
        return m(charSequence, i11 + 1, '-') ? 2 : 0;
    }

    public static boolean m(CharSequence charSequence, int i11, char c11) {
        return Parsing.m(charSequence, Parsing.k(c11, charSequence, i11, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    public void c(a aVar) {
        aVar.a(this.f59647b, this.f59646a);
    }

    public Block d() {
        return this.f59646a;
    }

    public c20.a g(f fVar) {
        return c20.a.d();
    }
}
