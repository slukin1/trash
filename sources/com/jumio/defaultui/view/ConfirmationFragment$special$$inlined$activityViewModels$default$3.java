package com.jumio.defaultui.view;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class ConfirmationFragment$special$$inlined$activityViewModels$default$3 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmationFragment$special$$inlined$activityViewModels$default$3(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        return this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
    }
}
