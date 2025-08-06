package androidx.fragment.app;

import androidx.lifecycle.q0;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$viewModels$owner$2 extends Lambda implements a<q0> {
    public final /* synthetic */ a<q0> $ownerProducer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$owner$2(a<? extends q0> aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    public final q0 invoke() {
        return this.$ownerProducer.invoke();
    }
}
