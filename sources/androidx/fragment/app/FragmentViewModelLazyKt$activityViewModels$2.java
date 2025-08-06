package androidx.fragment.app;

import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$activityViewModels$2 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final CreationExtras invoke() {
        return this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
    }
}
