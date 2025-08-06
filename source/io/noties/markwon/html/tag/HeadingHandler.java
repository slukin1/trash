package io.noties.markwon.html.tag;

import io.noties.markwon.b;
import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.Heading;
import rz.c;
import rz.e;

public class HeadingHandler extends SimpleTagHandler {
    public Collection<String> b() {
        return Arrays.asList(new String[]{"h1", "h2", "h3", "h4", "h5", "h6"});
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        int i11;
        e eVar = bVar.e().get(Heading.class);
        if (eVar == null) {
            return null;
        }
        try {
            i11 = Integer.parseInt(bVar2.name().substring(1));
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            i11 = 0;
        }
        if (i11 < 1 || i11 > 6) {
            return null;
        }
        CoreProps.f55294d.e(cVar, Integer.valueOf(i11));
        return eVar.a(bVar, cVar);
    }
}
