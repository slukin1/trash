package androidx.navigation;

import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.i;
import kotlin.jvm.internal.Lambda;

public final class NavGraphViewModelLazyKt$navGraphViewModels$5 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ i<NavBackStackEntry> $backStackEntry$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$5(i<NavBackStackEntry> iVar) {
        super(0);
        this.$backStackEntry$delegate = iVar;
    }

    public final CreationExtras invoke() {
        return g.g(this.$backStackEntry$delegate).getDefaultViewModelCreationExtras();
    }
}
