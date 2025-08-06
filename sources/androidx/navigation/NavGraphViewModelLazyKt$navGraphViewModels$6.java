package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class NavGraphViewModelLazyKt$navGraphViewModels$6 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$6(i<NavBackStackEntry> iVar) {
        super(0);
        this.$backStackEntry$delegate = iVar;
    }

    public final ViewModelProvider.Factory invoke() {
        return g.g(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory();
    }
}
