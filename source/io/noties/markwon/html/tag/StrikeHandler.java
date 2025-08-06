package io.noties.markwon.html.tag;

import android.text.style.StrikethroughSpan;
import e7.s;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.b;
import io.noties.markwon.g;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.TagHandler;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import rz.e;

public class StrikeHandler extends TagHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f55398a;

    static {
        boolean z11;
        try {
            Class.forName("org.commonmark.ext.gfm.strikethrough.Strikethrough");
            z11 = true;
        } catch (Throwable unused) {
            z11 = false;
        }
        f55398a = z11;
    }

    public static Object d(g gVar) {
        b configuration = gVar.configuration();
        e eVar = configuration.e().get(Strikethrough.class);
        if (eVar == null) {
            return null;
        }
        return eVar.a(configuration, gVar.g());
    }

    public void a(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, io.noties.markwon.html.b bVar) {
        if (bVar.e()) {
            TagHandler.c(gVar, markwonHtmlRenderer, bVar.a());
        }
        SpannableBuilder.j(gVar.builder(), f55398a ? d(gVar) : new StrikethroughSpan(), bVar.start(), bVar.c());
    }

    public Collection<String> b() {
        return Arrays.asList(new String[]{s.f70071a, "del"});
    }
}
