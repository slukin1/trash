package io.noties.markwon.html.tag;

import io.noties.markwon.b;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.StrongEmphasis;
import rz.c;
import rz.e;

public class StrongEmphasisHandler extends SimpleTagHandler {
    public Collection<String> b() {
        return Arrays.asList(new String[]{"b", "strong"});
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        e eVar = bVar.e().get(StrongEmphasis.class);
        if (eVar == null) {
            return null;
        }
        return eVar.a(bVar, cVar);
    }
}
