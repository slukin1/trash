package kotlinx.coroutines.rx3;

import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f57449b;

    public /* synthetic */ c(Ref$ObjectRef ref$ObjectRef) {
        this.f57449b = ref$ObjectRef;
    }

    public final void run() {
        RxSchedulerKt.f(this.f57449b);
    }
}
