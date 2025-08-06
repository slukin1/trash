package androidx.lifecycle;

import d10.a;
import kotlin.jvm.internal.Lambda;

public final class SavedStateHandlesProvider$viewModel$2 extends Lambda implements a<SavedStateHandlesVM> {
    public final /* synthetic */ q0 $viewModelStoreOwner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SavedStateHandlesProvider$viewModel$2(q0 q0Var) {
        super(0);
        this.$viewModelStoreOwner = q0Var;
    }

    public final SavedStateHandlesVM invoke() {
        return h0.e(this.$viewModelStoreOwner);
    }
}
