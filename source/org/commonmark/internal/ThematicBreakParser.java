package org.commonmark.internal;

import c20.a;
import c20.d;
import c20.e;
import c20.f;
import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class ThematicBreakParser extends AbstractBlockParser {

    /* renamed from: a  reason: collision with root package name */
    public final ThematicBreak f59674a = new ThematicBreak();

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            if (fVar.e() >= 4) {
                return d.c();
            }
            int d11 = fVar.d();
            CharSequence b11 = fVar.b();
            if (!ThematicBreakParser.j(b11, d11)) {
                return d.c();
            }
            return d.d(new ThematicBreakParser()).b(b11.length());
        }
    }

    public static boolean j(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (!(charAt == 9 || charAt == ' ')) {
                if (charAt == '*') {
                    i14++;
                } else if (charAt == '-') {
                    i12++;
                } else if (charAt != '_') {
                    return false;
                } else {
                    i13++;
                }
            }
            i11++;
        }
        if ((i12 >= 3 && i13 == 0 && i14 == 0) || ((i13 >= 3 && i12 == 0 && i14 == 0) || (i14 >= 3 && i12 == 0 && i13 == 0))) {
            return true;
        }
        return false;
    }

    public Block d() {
        return this.f59674a;
    }

    public a g(f fVar) {
        return a.d();
    }
}
