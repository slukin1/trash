package io.noties.markwon.html.tag;

import io.noties.markwon.b;
import io.noties.markwon.html.span.SubScriptSpan;
import java.util.Collection;
import java.util.Collections;
import rz.c;

public class SubScriptHandler extends SimpleTagHandler {
    public Collection<String> b() {
        return Collections.singleton("sub");
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        return new SubScriptSpan();
    }
}
