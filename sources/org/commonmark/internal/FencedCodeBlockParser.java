package org.commonmark.internal;

import c20.a;
import c20.d;
import c20.e;
import c20.f;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class FencedCodeBlockParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final FencedCodeBlock f59643a;

    /* renamed from: b  reason: collision with root package name */
    public String f59644b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f59645c = new StringBuilder();

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            int e11 = fVar.e();
            if (e11 >= Parsing.f59756a) {
                return d.c();
            }
            int d11 = fVar.d();
            FencedCodeBlockParser i11 = FencedCodeBlockParser.k(fVar.b(), d11, e11);
            if (i11 == null) {
                return d.c();
            }
            return d.d(i11).b(d11 + i11.f59643a.p());
        }
    }

    public FencedCodeBlockParser(char c11, int i11, int i12) {
        FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
        this.f59643a = fencedCodeBlock;
        fencedCodeBlock.s(c11);
        fencedCodeBlock.u(i11);
        fencedCodeBlock.t(i12);
    }

    public static FencedCodeBlockParser k(CharSequence charSequence, int i11, int i12) {
        int length = charSequence.length();
        int i13 = 0;
        int i14 = 0;
        for (int i15 = i11; i15 < length; i15++) {
            char charAt = charSequence.charAt(i15);
            if (charAt == '`') {
                i13++;
            } else if (charAt != '~') {
                break;
            } else {
                i14++;
            }
        }
        if (i13 < 3 || i14 != 0) {
            if (i14 < 3 || i13 != 0) {
                return null;
            }
            return new FencedCodeBlockParser('~', i14, i12);
        } else if (Parsing.b('`', charSequence, i11 + i13) != -1) {
            return null;
        } else {
            return new FencedCodeBlockParser('`', i13, i12);
        }
    }

    public Block d() {
        return this.f59643a;
    }

    public void e(CharSequence charSequence) {
        if (this.f59644b == null) {
            this.f59644b = charSequence.toString();
            return;
        }
        this.f59645c.append(charSequence);
        this.f59645c.append(10);
    }

    public a g(f fVar) {
        int d11 = fVar.d();
        int index = fVar.getIndex();
        CharSequence b11 = fVar.b();
        if (fVar.e() < Parsing.f59756a && l(b11, d11)) {
            return a.c();
        }
        int length = b11.length();
        for (int o11 = this.f59643a.o(); o11 > 0 && index < length && b11.charAt(index) == ' '; o11--) {
            index++;
        }
        return a.b(index);
    }

    public void h() {
        this.f59643a.v(Escaping.e(this.f59644b.trim()));
        this.f59643a.w(this.f59645c.toString());
    }

    public final boolean l(CharSequence charSequence, int i11) {
        char n11 = this.f59643a.n();
        int p11 = this.f59643a.p();
        int k11 = Parsing.k(n11, charSequence, i11, charSequence.length()) - i11;
        if (k11 >= p11 && Parsing.m(charSequence, i11 + k11, charSequence.length()) == charSequence.length()) {
            return true;
        }
        return false;
    }
}
