package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class FragmentViewModelLazyKt$activityViewModels$6 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$6(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        return this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
    }
}
