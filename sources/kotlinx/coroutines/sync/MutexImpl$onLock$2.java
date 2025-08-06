package kotlinx.coroutines.sync;

import d10.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

final /* synthetic */ class MutexImpl$onLock$2 extends FunctionReferenceImpl implements q<MutexImpl, Object, Object, Object> {
    public static final MutexImpl$onLock$2 INSTANCE = new MutexImpl$onLock$2();

    public MutexImpl$onLock$2() {
        super(3, MutexImpl.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(MutexImpl mutexImpl, Object obj, Object obj2) {
        return mutexImpl.w(obj, obj2);
    }
}
