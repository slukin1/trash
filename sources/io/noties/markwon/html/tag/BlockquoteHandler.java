package io.noties.markwon.html.tag;

import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.g;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.TagHandler;
import io.noties.markwon.html.b;
import java.util.Collection;
import java.util.Collections;
import org.commonmark.node.BlockQuote;
import rz.e;

public class BlockquoteHandler extends TagHandler {
    public void a(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, b bVar) {
        if (bVar.e()) {
            TagHandler.c(gVar, markwonHtmlRenderer, bVar.a());
        }
        io.noties.markwon.b configuration = gVar.configuration();
        e eVar = configuration.e().get(BlockQuote.class);
        if (eVar != null) {
            SpannableBuilder.j(gVar.builder(), eVar.a(configuration, gVar.g()), bVar.start(), bVar.c());
        }
    }

    public Collection<String> b() {
        return Collections.singleton("blockquote");
    }
}
