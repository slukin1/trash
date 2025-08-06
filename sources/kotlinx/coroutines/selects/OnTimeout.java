package kotlinx.coroutines.selects;

import d10.q;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.DelayKt;

public final class OnTimeout {

    /* renamed from: a  reason: collision with root package name */
    public final long f57500a;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f57501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OnTimeout f57502c;

        public a(k kVar, OnTimeout onTimeout) {
            this.f57501b = kVar;
            this.f57502c = onTimeout;
        }

        public final void run() {
            this.f57501b.f(this.f57502c, Unit.f56620a);
        }
    }

    public OnTimeout(long j11) {
        this.f57500a = j11;
    }

    public final d b() {
        return new e(this, (q) TypeIntrinsics.e(OnTimeout$selectClause$1.INSTANCE, 3), (q) null, 4, (r) null);
    }

    public final void c(k<?> kVar, Object obj) {
        if (this.f57500a <= 0) {
            kVar.d(Unit.f56620a);
            return;
        }
        a aVar = new a(kVar, this);
        SelectImplementation selectImplementation = (SelectImplementation) kVar;
        CoroutineContext context = kVar.getContext();
        kVar.e(DelayKt.c(context).u(this.f57500a, aVar, context));
    }
}
