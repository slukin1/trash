package io.noties.markwon.html;

import io.noties.markwon.g;
import io.noties.markwon.html.b;
import java.util.Collection;

public abstract class TagHandler {
    public static void c(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, b.a aVar) {
        for (b.a next : aVar.f()) {
            if (next.isClosed()) {
                TagHandler b11 = markwonHtmlRenderer.b(next.name());
                if (b11 != null) {
                    b11.a(gVar, markwonHtmlRenderer, next);
                } else {
                    c(gVar, markwonHtmlRenderer, next);
                }
            }
        }
    }

    public abstract void a(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, b bVar);

    public abstract Collection<String> b();
}
