package io.noties.markwon.core;

import io.noties.markwon.g;
import org.commonmark.node.Node;

public class SimpleBlockNodeVisitor implements g.c<Node> {
    public void a(g gVar, Node node) {
        gVar.f(node);
        int length = gVar.length();
        gVar.c(node);
        gVar.h(node, length);
        gVar.D(node);
    }
}
