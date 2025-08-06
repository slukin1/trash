package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.q0;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$viewModels$2 extends Lambda implements a<ViewModelStore> {
    public final /* synthetic */ i<q0> $owner$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$2(i<? extends q0> iVar) {
        super(0);
        this.$owner$delegate = iVar;
    }

    public final ViewModelStore invoke() {
        return FragmentViewModelLazyKt.d(this.$owner$delegate).getViewModelStore();
    }
}
