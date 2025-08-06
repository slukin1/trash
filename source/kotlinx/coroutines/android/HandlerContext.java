package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w1;
import kotlinx.coroutines.x0;

public final class HandlerContext extends b {
    private volatile HandlerContext _immediate;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f56979c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56980d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f56981e;

    /* renamed from: f  reason: collision with root package name */
    public final HandlerContext f56982f;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f56983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HandlerContext f56984c;

        public a(k kVar, HandlerContext handlerContext) {
            this.f56983b = kVar;
            this.f56984c = handlerContext;
        }

        public final void run() {
            this.f56983b.I(this.f56984c, Unit.f56620a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerContext(Handler handler, String str, boolean z11) {
        super((r) null);
        HandlerContext handlerContext = null;
        this.f56979c = handler;
        this.f56980d = str;
        this.f56981e = z11;
        this._immediate = z11 ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(handler, str, true);
            this._immediate = handlerContext2;
        }
        this.f56982f = handlerContext2;
    }

    public static final void O(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f56979c.removeCallbacks(runnable);
    }

    public boolean B(CoroutineContext coroutineContext) {
        return !this.f56981e || !x.b(Looper.myLooper(), this.f56979c.getLooper());
    }

    public final void K(CoroutineContext coroutineContext, Runnable runnable) {
        p1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        v0.b().w(coroutineContext, runnable);
    }

    /* renamed from: N */
    public HandlerContext G() {
        return this.f56982f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f56979c == this.f56979c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f56979c);
    }

    public void t(long j11, k<? super Unit> kVar) {
        a aVar = new a(kVar, this);
        if (this.f56979c.postDelayed(aVar, RangesKt___RangesKt.h(j11, 4611686018427387903L))) {
            kVar.x(new HandlerContext$scheduleResumeAfterDelay$1(this, aVar));
        } else {
            K(kVar.getContext(), aVar);
        }
    }

    public String toString() {
        String H = H();
        if (H != null) {
            return H;
        }
        String str = this.f56980d;
        if (str == null) {
            str = this.f56979c.toString();
        }
        if (!this.f56981e) {
            return str;
        }
        return str + ".immediate";
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f56979c.postDelayed(runnable, RangesKt___RangesKt.h(j11, 4611686018427387903L))) {
            return new a(this, runnable);
        }
        K(coroutineContext, runnable);
        return w1.f57576b;
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f56979c.post(runnable)) {
            K(coroutineContext, runnable);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i11, r rVar) {
        this(handler, (i11 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
