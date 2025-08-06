package com.sumsub.sns.internal.core.domain.model;

import d10.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class a<L, R> {

    /* renamed from: com.sumsub.sns.internal.core.domain.model.a$a  reason: collision with other inner class name */
    public static final class C0372a<L> extends a {

        /* renamed from: a  reason: collision with root package name */
        public final L f33637a;

        public C0372a(L l11) {
            super((r) null);
            this.f33637a = l11;
        }

        public static /* synthetic */ C0372a a(C0372a aVar, L l11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                l11 = aVar.f33637a;
            }
            return aVar.c(l11);
        }

        public final L c() {
            return this.f33637a;
        }

        public final L d() {
            return this.f33637a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0372a) && x.b(this.f33637a, ((C0372a) obj).f33637a);
        }

        public int hashCode() {
            L l11 = this.f33637a;
            if (l11 == null) {
                return 0;
            }
            return l11.hashCode();
        }

        public String toString() {
            return "Left(a=" + this.f33637a + ')';
        }

        public final C0372a<L> c(L l11) {
            return new C0372a<>(l11);
        }
    }

    public static final class b<R> extends a {

        /* renamed from: a  reason: collision with root package name */
        public final R f33638a;

        public b(R r11) {
            super((r) null);
            this.f33638a = r11;
        }

        public static /* synthetic */ b a(b bVar, R r11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                r11 = bVar.f33638a;
            }
            return bVar.c(r11);
        }

        public final R c() {
            return this.f33638a;
        }

        public final R d() {
            return this.f33638a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && x.b(this.f33638a, ((b) obj).f33638a);
        }

        public int hashCode() {
            R r11 = this.f33638a;
            if (r11 == null) {
                return 0;
            }
            return r11.hashCode();
        }

        public String toString() {
            return "Right(b=" + this.f33638a + ')';
        }

        public final b<R> c(R r11) {
            return new b<>(r11);
        }
    }

    public /* synthetic */ a(r rVar) {
        this();
    }

    public final boolean a() {
        return this instanceof C0372a;
    }

    public final boolean b() {
        return this instanceof b;
    }

    public a() {
    }

    public final <L> C0372a<L> a(L l11) {
        return new C0372a<>(l11);
    }

    public final <R> b<R> b(R r11) {
        return new b<>(r11);
    }

    public final Object a(l<? super L, ? extends Object> lVar, l<? super R, ? extends Object> lVar2) {
        if (this instanceof C0372a) {
            return lVar.invoke(((C0372a) this).d());
        }
        if (this instanceof b) {
            return lVar2.invoke(((b) this).d());
        }
        throw new NoWhenBranchMatchedException();
    }
}
