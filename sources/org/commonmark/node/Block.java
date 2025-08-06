package org.commonmark.node;

public abstract class Block extends Node {
    public void j(Node node) {
        if (node instanceof Block) {
            super.j(node);
            return;
        }
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }

    /* renamed from: m */
    public Block f() {
        return (Block) super.f();
    }
}
