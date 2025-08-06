package io.noties.markwon.html.tag;

import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.g;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.TagHandler;
import io.noties.markwon.html.b;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.ListItem;
import rz.c;
import rz.e;

public class ListHandler extends TagHandler {
    public static int d(b.a aVar) {
        int i11 = 0;
        while (true) {
            aVar = aVar.d();
            if (aVar == null) {
                return i11;
            }
            if ("ul".equals(aVar.name()) || "ol".equals(aVar.name())) {
                i11++;
            }
        }
    }

    public void a(g gVar, MarkwonHtmlRenderer markwonHtmlRenderer, b bVar) {
        if (bVar.e()) {
            b.a a11 = bVar.a();
            boolean equals = "ol".equals(a11.name());
            boolean equals2 = "ul".equals(a11.name());
            if (equals || equals2) {
                io.noties.markwon.b configuration = gVar.configuration();
                c g11 = gVar.g();
                e eVar = configuration.e().get(ListItem.class);
                int d11 = d(a11);
                int i11 = 1;
                for (b.a next : a11.f()) {
                    TagHandler.c(gVar, markwonHtmlRenderer, next);
                    if (eVar != null && "li".equals(next.name())) {
                        if (equals) {
                            CoreProps.f55291a.e(g11, CoreProps.ListItemType.ORDERED);
                            CoreProps.f55293c.e(g11, Integer.valueOf(i11));
                            i11++;
                        } else {
                            CoreProps.f55291a.e(g11, CoreProps.ListItemType.BULLET);
                            CoreProps.f55292b.e(g11, Integer.valueOf(d11));
                        }
                        SpannableBuilder.j(gVar.builder(), eVar.a(configuration, g11), next.start(), next.c());
                    }
                }
            }
        }
    }

    public Collection<String> b() {
        return Arrays.asList(new String[]{"ol", "ul"});
    }
}
