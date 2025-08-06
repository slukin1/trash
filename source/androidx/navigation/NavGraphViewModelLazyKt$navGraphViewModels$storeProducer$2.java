package androidx.navigation;

import androidx.lifecycle.ViewModelStore;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2 extends Lambda implements a<ViewModelStore> {
    public final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$2(i<NavBackStackEntry> iVar) {
        super(0);
        this.$backStackEntry$delegate = iVar;
    }

    public final ViewModelStore invoke() {
        return g.f(this.$backStackEntry$delegate).getViewModelStore();
    }
}
