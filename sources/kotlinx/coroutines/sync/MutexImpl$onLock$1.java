package kotlinx.coroutines.sync;

import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.k;

final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements q<MutexImpl, k<?>, Object, Unit> {
    public static final MutexImpl$onLock$1 INSTANCE = new MutexImpl$onLock$1();

    public MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((MutexImpl) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(MutexImpl mutexImpl, k<?> kVar, Object obj) {
        mutexImpl.x(kVar, obj);
    }
}
