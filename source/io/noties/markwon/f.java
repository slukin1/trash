package io.noties.markwon;

import io.noties.markwon.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.Node;
import rz.e;

public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends Node>, e> f55301a;

    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<? extends Node>, rz.e> f55302a = new HashMap(3);

        public <N extends Node> e.a a(Class<N> cls, rz.e eVar) {
            if (eVar == null) {
                this.f55302a.remove(cls);
            } else {
                this.f55302a.put(cls, eVar);
            }
            return this;
        }

        public e build() {
            return new f(Collections.unmodifiableMap(this.f55302a));
        }
    }

    public f(Map<Class<? extends Node>, rz.e> map) {
        this.f55301a = map;
    }

    public <N extends Node> rz.e get(Class<N> cls) {
        return this.f55301a.get(cls);
    }
}
