package io.noties.markwon;

import io.noties.markwon.b;
import io.noties.markwon.e;
import io.noties.markwon.g;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import sz.a;

public interface d {

    public interface a<P extends d> {
        void a(P p11);
    }

    public interface b {
        <P extends d> void a(Class<P> cls, a<? super P> aVar);
    }

    void afterRender(Node node, g gVar);

    void beforeRender(Node node);

    void configure(b bVar);

    void configureConfiguration(b.C0649b bVar);

    void configureParser(Parser.Builder builder);

    void configureSpansFactory(e.a aVar);

    void configureTheme(a.C0676a aVar);

    void configureVisitor(g.b bVar);

    String processMarkdown(String str);
}
