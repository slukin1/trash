package org.commonmark.internal;

import c20.a;
import c20.f;
import org.commonmark.node.Block;
import org.commonmark.node.Document;
import org.commonmark.parser.block.AbstractBlockParser;

public class DocumentBlockParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final Document f59642a = new Document();

    public boolean a() {
        return true;
    }

    public void e(CharSequence charSequence) {
    }

    public boolean f(Block block) {
        return true;
    }

    public a g(f fVar) {
        return a.b(fVar.getIndex());
    }

    /* renamed from: i */
    public Document d() {
        return this.f59642a;
    }
}
