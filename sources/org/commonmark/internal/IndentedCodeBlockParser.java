package org.commonmark.internal;

import c20.a;
import c20.d;
import c20.e;
import c20.f;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class IndentedCodeBlockParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final IndentedCodeBlock f59653a = new IndentedCodeBlock();

    /* renamed from: b  reason: collision with root package name */
    public final List<CharSequence> f59654b = new ArrayList();

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            if (fVar.e() < Parsing.f59756a || fVar.a() || (fVar.f().d() instanceof Paragraph)) {
                return d.c();
            }
            return d.d(new IndentedCodeBlockParser()).a(fVar.c() + Parsing.f59756a);
        }
    }

    public Block d() {
        return this.f59653a;
    }

    public void e(CharSequence charSequence) {
        this.f59654b.add(charSequence);
    }

    public a g(f fVar) {
        if (fVar.e() >= Parsing.f59756a) {
            return a.a(fVar.c() + Parsing.f59756a);
        }
        if (fVar.a()) {
            return a.b(fVar.d());
        }
        return a.d();
    }

    public void h() {
        int size = this.f59654b.size() - 1;
        while (size >= 0 && Parsing.f(this.f59654b.get(size))) {
            size--;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < size + 1; i11++) {
            sb2.append(this.f59654b.get(i11));
            sb2.append(10);
        }
        this.f59653a.o(sb2.toString());
    }
}
