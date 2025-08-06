package com.huobi.zeroswap.ui;

import androidx.lifecycle.ViewModelProvider;
import com.huobi.zeroswap.vm.b;
import d10.a;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Lambda;

public final class ZeroSwapActivity$viewModel$2 extends Lambda implements a<ViewModelProvider.Factory> {
    public final /* synthetic */ ZeroSwapActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZeroSwapActivity$viewModel$2(ZeroSwapActivity zeroSwapActivity) {
        super(0);
        this.this$0 = zeroSwapActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        return new b(new WeakReference(this.this$0), this.this$0.getApplication());
    }
}
