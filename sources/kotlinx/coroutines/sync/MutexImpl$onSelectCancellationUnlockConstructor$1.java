package kotlinx.coroutines.sync;

import d10.l;
import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.selects.k;

public final class MutexImpl$onSelectCancellationUnlockConstructor$1 extends Lambda implements q<k<?>, Object, Object, l<? super Throwable, ? extends Unit>> {
    public final /* synthetic */ MutexImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutexImpl$onSelectCancellationUnlockConstructor$1(MutexImpl mutexImpl) {
        super(3);
        this.this$0 = mutexImpl;
    }

    public final l<Throwable, Unit> invoke(k<?> kVar, final Object obj, Object obj2) {
        final MutexImpl mutexImpl = this.this$0;
        return new l<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f56620a;
            }

            public final void invoke(Throwable th2) {
                mutexImpl.e(obj);
            }
        };
    }
}
