package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class g0 extends kotlin.coroutines.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f57275c = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final String f57276b;

    public static final class a implements CoroutineContext.b<g0> {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public g0(String str) {
        super(f57275c);
        this.f57276b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g0) && x.b(this.f57276b, ((g0) obj).f57276b);
    }

    public int hashCode() {
        return this.f57276b.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f57276b + ')';
    }

    public final String w() {
        return this.f57276b;
    }
}
