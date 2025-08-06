package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final Object f57577a;

    /* renamed from: b  reason: collision with root package name */
    public final CancelHandler f57578b;

    /* renamed from: c  reason: collision with root package name */
    public final l<Throwable, Unit> f57579c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f57580d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f57581e;

    public x(Object obj, CancelHandler cancelHandler, l<? super Throwable, Unit> lVar, Object obj2, Throwable th2) {
        this.f57577a = obj;
        this.f57578b = cancelHandler;
        this.f57579c = lVar;
        this.f57580d = obj2;
        this.f57581e = th2;
    }

    public static /* synthetic */ x b(x xVar, Object obj, CancelHandler cancelHandler, l<Throwable, Unit> lVar, Object obj2, Throwable th2, int i11, Object obj3) {
        if ((i11 & 1) != 0) {
            obj = xVar.f57577a;
        }
        if ((i11 & 2) != 0) {
            cancelHandler = xVar.f57578b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i11 & 4) != 0) {
            lVar = xVar.f57579c;
        }
        l<Throwable, Unit> lVar2 = lVar;
        if ((i11 & 8) != 0) {
            obj2 = xVar.f57580d;
        }
        Object obj4 = obj2;
        if ((i11 & 16) != 0) {
            th2 = xVar.f57581e;
        }
        return xVar.a(obj, cancelHandler2, lVar2, obj4, th2);
    }

    public final x a(Object obj, CancelHandler cancelHandler, l<? super Throwable, Unit> lVar, Object obj2, Throwable th2) {
        return new x(obj, cancelHandler, lVar, obj2, th2);
    }

    public final boolean c() {
        return this.f57581e != null;
    }

    public final void d(l<?> lVar, Throwable th2) {
        CancelHandler cancelHandler = this.f57578b;
        if (cancelHandler != null) {
            lVar.l(cancelHandler, th2);
        }
        l<Throwable, Unit> lVar2 = this.f57579c;
        if (lVar2 != null) {
            lVar.n(lVar2, th2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.x.b(this.f57577a, xVar.f57577a) && kotlin.jvm.internal.x.b(this.f57578b, xVar.f57578b) && kotlin.jvm.internal.x.b(this.f57579c, xVar.f57579c) && kotlin.jvm.internal.x.b(this.f57580d, xVar.f57580d) && kotlin.jvm.internal.x.b(this.f57581e, xVar.f57581e);
    }

    public int hashCode() {
        Object obj = this.f57577a;
        int i11 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f57578b;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        l<Throwable, Unit> lVar = this.f57579c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f57580d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f57581e;
        if (th2 != null) {
            i11 = th2.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f57577a + ", cancelHandler=" + this.f57578b + ", onCancellation=" + this.f57579c + ", idempotentResume=" + this.f57580d + ", cancelCause=" + this.f57581e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(Object obj, CancelHandler cancelHandler, l lVar, Object obj2, Throwable th2, int i11, r rVar) {
        this(obj, (i11 & 2) != 0 ? null : cancelHandler, (i11 & 4) != 0 ? null : lVar, (i11 & 8) != 0 ? null : obj2, (i11 & 16) != 0 ? null : th2);
    }
}
