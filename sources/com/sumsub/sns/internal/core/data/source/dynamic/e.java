package com.sumsub.sns.internal.core.data.source.dynamic;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class e<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33474a = new a((r) null);

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final <T> d<T> a(T t11) {
            return new d<>(t11);
        }

        public a() {
        }

        public final <T> c<T> a(T t11, Throwable th2) {
            return new c<>(th2, t11);
        }
    }

    public static final class b<T> extends e<T> {
        public b() {
            super((r) null);
        }
    }

    public static final class c<T> extends e<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f33475b;

        /* renamed from: c  reason: collision with root package name */
        public final T f33476c;

        public c(Throwable th2, T t11) {
            super((r) null);
            this.f33475b = th2;
            this.f33476c = t11;
        }

        public final c<T> a(Throwable th2, T t11) {
            return new c<>(th2, t11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f33475b, cVar.f33475b) && x.b(this.f33476c, cVar.f33476c);
        }

        public final Throwable f() {
            return this.f33475b;
        }

        public final T g() {
            return this.f33476c;
        }

        public final T h() {
            return this.f33476c;
        }

        public int hashCode() {
            int hashCode = this.f33475b.hashCode() * 31;
            T t11 = this.f33476c;
            return hashCode + (t11 == null ? 0 : t11.hashCode());
        }

        public final Throwable i() {
            return this.f33475b;
        }

        public String toString() {
            return "Failure(throwable=" + this.f33475b + ", lastValue=" + this.f33476c + ')';
        }

        public static /* synthetic */ c a(c cVar, Throwable th2, T t11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                th2 = cVar.f33475b;
            }
            if ((i11 & 2) != 0) {
                t11 = cVar.f33476c;
            }
            return cVar.a(th2, t11);
        }
    }

    public static final class d<T> extends e<T> {

        /* renamed from: b  reason: collision with root package name */
        public final T f33477b;

        public d(T t11) {
            super((r) null);
            this.f33477b = t11;
        }

        public final d<T> a(T t11) {
            return new d<>(t11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && x.b(this.f33477b, ((d) obj).f33477b);
        }

        public final T f() {
            return this.f33477b;
        }

        public final T g() {
            return this.f33477b;
        }

        public int hashCode() {
            T t11 = this.f33477b;
            if (t11 == null) {
                return 0;
            }
            return t11.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f33477b + ')';
        }

        public static /* synthetic */ d a(d dVar, T t11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                t11 = dVar.f33477b;
            }
            return dVar.a(t11);
        }
    }

    public /* synthetic */ e(r rVar) {
        this();
    }

    public final Throwable a() {
        c cVar = this instanceof c ? (c) this : null;
        if (cVar != null) {
            return cVar.i();
        }
        return null;
    }

    public final boolean b() {
        return c() != null;
    }

    public final T c() {
        if (this instanceof d) {
            return ((d) this).g();
        }
        if (this instanceof c) {
            return ((c) this).h();
        }
        if (this instanceof b) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final T d() {
        d dVar = this instanceof d ? (d) this : null;
        if (dVar != null) {
            return dVar.g();
        }
        return null;
    }

    public final T e() {
        if (!(this instanceof c)) {
            T c11 = c();
            if (c11 != null) {
                return c11;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw ((c) this).i();
    }

    public e() {
    }
}
