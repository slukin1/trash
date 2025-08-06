package io.noties.markwon.html.tag;

import io.noties.markwon.b;
import io.noties.markwon.html.span.SuperScriptSpan;
import java.util.Collection;
import java.util.Collections;
import rz.c;

public class SuperScriptHandler extends SimpleTagHandler {
    public Collection<String> b() {
        return Collections.singleton("sup");
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        return new SuperScriptSpan();
    }
}
