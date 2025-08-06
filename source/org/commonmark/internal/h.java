package org.commonmark.internal;

import c20.a;
import c20.f;
import org.commonmark.node.Block;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;

public class h extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final ListItem f59740a = new ListItem();

    /* renamed from: b  reason: collision with root package name */
    public int f59741b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59742c;

    public h(int i11) {
        this.f59741b = i11;
    }

    public boolean a() {
        return true;
    }

    public Block d() {
        return this.f59740a;
    }

    public boolean f(Block block) {
        if (!this.f59742c) {
            return true;
        }
        Block m11 = this.f59740a.f();
        if (!(m11 instanceof ListBlock)) {
            return true;
        }
        ((ListBlock) m11).o(false);
        return true;
    }

    public a g(f fVar) {
        if (fVar.a()) {
            if (this.f59740a.c() == null) {
                return a.d();
            }
            Block d11 = fVar.f().d();
            this.f59742c = (d11 instanceof Paragraph) || (d11 instanceof ListItem);
            return a.b(fVar.d());
        } else if (fVar.e() >= this.f59741b) {
            return a.a(fVar.c() + this.f59741b);
        } else {
            return a.d();
        }
    }
}
