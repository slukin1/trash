package org.commonmark.internal;

import c20.a;
import c20.d;
import c20.e;
import c20.f;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class BlockQuoteParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final BlockQuote f59641a = new BlockQuote();

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            int d11 = fVar.d();
            if (!BlockQuoteParser.k(fVar, d11)) {
                return d.c();
            }
            int c11 = fVar.c() + fVar.e() + 1;
            if (Parsing.i(fVar.b(), d11 + 1)) {
                c11++;
            }
            return d.d(new BlockQuoteParser()).a(c11);
        }
    }

    public static boolean k(f fVar, int i11) {
        CharSequence b11 = fVar.b();
        return fVar.e() < Parsing.f59756a && i11 < b11.length() && b11.charAt(i11) == '>';
    }

    public boolean a() {
        return true;
    }

    public boolean f(Block block) {
        return true;
    }

    public a g(f fVar) {
        int d11 = fVar.d();
        if (!k(fVar, d11)) {
            return a.d();
        }
        int c11 = fVar.c() + fVar.e() + 1;
        if (Parsing.i(fVar.b(), d11 + 1)) {
            c11++;
        }
        return a.a(c11);
    }

    /* renamed from: j */
    public BlockQuote d() {
        return this.f59641a;
    }
}
