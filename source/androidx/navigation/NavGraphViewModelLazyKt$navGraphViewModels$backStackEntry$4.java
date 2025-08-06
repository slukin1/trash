package androidx.navigation;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.c;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4 extends Lambda implements a<NavBackStackEntry> {
    public final /* synthetic */ int $navGraphId;
    public final /* synthetic */ Fragment $this_navGraphViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$4(Fragment fragment, int i11) {
        super(0);
        this.$this_navGraphViewModels = fragment;
        this.$navGraphId = i11;
    }

    public final NavBackStackEntry invoke() {
        return c.a(this.$this_navGraphViewModels).z(this.$navGraphId);
    }
}
