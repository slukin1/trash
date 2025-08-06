package io.noties.markwon.html.tag;

import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.g;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.TagHandler;
import io.noties.markwon.html.b;
import rz.c;

public abstract class SimpleTagHandler extends TagHandler {
    public void a(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, b bVar) {
        if (bVar.e()) {
            TagHandler.c(gVar, markwonHtmlRenderer, bVar.a());
        }
        Object d11 = d(gVar.configuration(), gVar.g(), bVar);
        if (d11 != null) {
            SpannableBuilder.j(gVar.builder(), d11, bVar.start(), bVar.c());
        }
    }

    public abstract Object d(io.noties.markwon.b bVar, c cVar, b bVar2);
}
