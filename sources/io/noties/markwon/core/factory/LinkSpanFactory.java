package io.noties.markwon.core.factory;

import io.noties.markwon.b;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.LinkSpan;
import rz.c;
import rz.e;

public class LinkSpanFactory implements e {
    public Object a(b bVar, c cVar) {
        return new LinkSpan(bVar.g(), CoreProps.f55295e.d(cVar), bVar.d());
    }
}
