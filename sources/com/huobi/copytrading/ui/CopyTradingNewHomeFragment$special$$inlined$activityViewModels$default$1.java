package com.huobi.copytrading.ui;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class CopyTradingNewHomeFragment$special$$inlined$activityViewModels$default$1 extends Lambda implements a<ViewModelStore> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyTradingNewHomeFragment$special$$inlined$activityViewModels$default$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelStore invoke() {
        return this.$this_activityViewModels.requireActivity().getViewModelStore();
    }
}
