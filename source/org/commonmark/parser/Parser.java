package org.commonmark.parser;

import b20.b;
import b20.d;
import c20.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.commonmark.internal.e;
import org.commonmark.internal.f;
import org.commonmark.internal.g;
import org.commonmark.node.Block;
import org.commonmark.node.Node;

public class Parser {

    /* renamed from: a  reason: collision with root package name */
    public final List<c> f59786a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d20.a> f59787b;

    /* renamed from: c  reason: collision with root package name */
    public final b20.c f59788c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f59789d;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final List<c> f59790a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List<d20.a> f59791b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final List<d> f59792c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public Set<Class<? extends Block>> f59793d = e.s();

        /* renamed from: e  reason: collision with root package name */
        public b20.c f59794e;

        public class a implements b20.c {
            public a() {
            }

            public b20.a a(b bVar) {
                return new g(bVar);
            }
        }

        public Parser f() {
            return new Parser(this);
        }

        public Builder g(d20.a aVar) {
            Objects.requireNonNull(aVar, "delimiterProcessor must not be null");
            this.f59791b.add(aVar);
            return this;
        }

        public final b20.c h() {
            b20.c cVar = this.f59794e;
            if (cVar != null) {
                return cVar;
            }
            return new a();
        }
    }

    public final e a() {
        return new e(this.f59786a, this.f59788c, this.f59787b);
    }

    public Node b(String str) {
        Objects.requireNonNull(str, "input must not be null");
        return c(a().u(str));
    }

    public final Node c(Node node) {
        for (d a11 : this.f59789d) {
            node = a11.a(node);
        }
        return node;
    }

    public Parser(Builder builder) {
        this.f59786a = e.l(builder.f59790a, builder.f59793d);
        b20.c c11 = builder.h();
        this.f59788c = c11;
        this.f59789d = builder.f59792c;
        List<d20.a> e11 = builder.f59791b;
        this.f59787b = e11;
        c11.a(new f(e11, Collections.emptyMap()));
    }
}
