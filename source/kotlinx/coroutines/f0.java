package kotlinx.coroutines;

import com.sumsub.sns.internal.core.common.n0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;

public final class f0 extends kotlin.coroutines.a implements f2<String> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f57119c = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final long f57120b;

    public static final class a implements CoroutineContext.b<f0> {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public f0(long j11) {
        super(f57119c);
        this.f57120b = j11;
    }

    /* renamed from: B */
    public String M(CoroutineContext coroutineContext) {
        String str;
        g0 g0Var = (g0) coroutineContext.get(g0.f57275c);
        if (g0Var == null || (str = g0Var.w()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int m02 = StringsKt__StringsKt.m0(name, " @", 0, false, 6, (Object) null);
        if (m02 < 0) {
            m02 = name.length();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + m02 + 10);
        sb2.append(name.substring(0, m02));
        sb2.append(" @");
        sb2.append(str);
        sb2.append(n0.h.f32179b);
        sb2.append(this.f57120b);
        currentThread.setName(sb2.toString());
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && this.f57120b == ((f0) obj).f57120b;
    }

    public int hashCode() {
        return com.fluttercandies.photo_manager.core.entity.a.a(this.f57120b);
    }

    public String toString() {
        return "CoroutineId(" + this.f57120b + ')';
    }

    public final long w() {
        return this.f57120b;
    }

    /* renamed from: x */
    public void n(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }
}
