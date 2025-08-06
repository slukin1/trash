package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$activityViewModels$4 extends Lambda implements a<ViewModelStore> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$4(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelStore invoke() {
        return this.$this_activityViewModels.requireActivity().getViewModelStore();
    }
}
