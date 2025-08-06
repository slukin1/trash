package androidx.lifecycle;

import kotlinx.coroutines.e2;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class t {
    public static final LifecycleCoroutineScope a(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.c().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, e2.b((n1) null, 1, (Object) null).plus(v0.c().G()));
        } while (!lifecycle.c().compareAndSet((Object) null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.e();
        return lifecycleCoroutineScopeImpl;
    }
}
