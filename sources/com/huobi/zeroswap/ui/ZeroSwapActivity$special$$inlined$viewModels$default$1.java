package com.huobi.zeroswap.ui;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class ZeroSwapActivity$special$$inlined$viewModels$default$1 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZeroSwapActivity$special$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    }
}
