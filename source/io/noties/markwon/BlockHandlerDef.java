package io.noties.markwon;

import io.noties.markwon.g;
import org.commonmark.node.Node;

public class BlockHandlerDef implements g.a {
    public void a(g gVar, Node node) {
        gVar.l();
    }

    public void b(g gVar, Node node) {
        if (gVar.t(node)) {
            gVar.l();
            gVar.F();
        }
    }
}
