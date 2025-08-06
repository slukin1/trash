package org.commonmark.internal;

import b20.a;
import c20.f;
import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;

public class ParagraphParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final Paragraph f59672a = new Paragraph();

    /* renamed from: b  reason: collision with root package name */
    public LinkReferenceDefinitionParser f59673b = new LinkReferenceDefinitionParser();

    public boolean b() {
        return true;
    }

    public void c(a aVar) {
        CharSequence d11 = this.f59673b.d();
        if (d11.length() > 0) {
            aVar.a(d11.toString(), this.f59672a);
        }
    }

    public Block d() {
        return this.f59672a;
    }

    public void e(CharSequence charSequence) {
        this.f59673b.f(charSequence);
    }

    public c20.a g(f fVar) {
        if (!fVar.a()) {
            return c20.a.b(fVar.getIndex());
        }
        return c20.a.d();
    }

    public void h() {
        if (this.f59673b.d().length() == 0) {
            this.f59672a.l();
        }
    }

    public CharSequence i() {
        return this.f59673b.d();
    }

    public List<LinkReferenceDefinition> j() {
        return this.f59673b.c();
    }
}
