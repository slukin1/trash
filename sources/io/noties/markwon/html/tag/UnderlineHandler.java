package io.noties.markwon.html.tag;

import android.text.style.UnderlineSpan;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.g;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.TagHandler;
import io.noties.markwon.html.b;
import java.util.Arrays;
import java.util.Collection;

public class UnderlineHandler extends TagHandler {
    public void a(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, b bVar) {
        if (bVar.e()) {
            TagHandler.c(gVar, markwonHtmlRenderer, bVar.a());
        }
        SpannableBuilder.j(gVar.builder(), new UnderlineSpan(), bVar.start(), bVar.c());
    }

    public Collection<String> b() {
        return Arrays.asList(new String[]{"u", "ins"});
    }
}
