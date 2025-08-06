package io.noties.markwon;

import io.noties.markwon.g;
import org.commonmark.node.SoftLineBreak;

public class SoftBreakAddsNewLinePlugin extends AbstractMarkwonPlugin {

    public class a implements g.c<SoftLineBreak> {
        public a() {
        }

        /* renamed from: b */
        public void a(g gVar, SoftLineBreak softLineBreak) {
            gVar.l();
        }
    }

    public void configureVisitor(g.b bVar) {
        bVar.a(SoftLineBreak.class, new a());
    }
}
