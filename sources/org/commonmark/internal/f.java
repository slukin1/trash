package org.commonmark.internal;

import b20.b;
import d20.a;
import java.util.List;
import java.util.Map;
import org.commonmark.node.LinkReferenceDefinition;

public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f59715a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, LinkReferenceDefinition> f59716b;

    public f(List<a> list, Map<String, LinkReferenceDefinition> map) {
        this.f59715a = list;
        this.f59716b = map;
    }

    public List<a> a() {
        return this.f59715a;
    }

    public LinkReferenceDefinition b(String str) {
        return this.f59716b.get(str);
    }
}
