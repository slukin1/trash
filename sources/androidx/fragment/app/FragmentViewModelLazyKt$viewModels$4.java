package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$viewModels$4 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ i<q0> $owner$delegate;
    public final /* synthetic */ Fragment $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$4(Fragment fragment, i<? extends q0> iVar) {
        super(0);
        this.$this_viewModels = fragment;
        this.$owner$delegate = iVar;
    }

    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory;
        q0 a11 = FragmentViewModelLazyKt.d(this.$owner$delegate);
        o oVar = a11 instanceof o ? (o) a11 : null;
        return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.$this_viewModels.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
    }
}
