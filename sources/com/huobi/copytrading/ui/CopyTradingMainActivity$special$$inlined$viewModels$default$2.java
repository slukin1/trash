package com.huobi.copytrading.ui;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class CopyTradingMainActivity$special$$inlined$viewModels$default$2 extends Lambda implements a<ViewModelStore> {
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyTradingMainActivity$special$$inlined$viewModels$default$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final ViewModelStore invoke() {
        return this.$this_viewModels.getViewModelStore();
    }
}
