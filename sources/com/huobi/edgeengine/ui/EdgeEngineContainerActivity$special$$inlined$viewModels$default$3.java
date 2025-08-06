package com.huobi.edgeengine.ui;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class EdgeEngineContainerActivity$special$$inlined$viewModels$default$3 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ a $extrasProducer;
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EdgeEngineContainerActivity$special$$inlined$viewModels$default$3(a aVar, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = aVar;
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.viewmodel.CreationExtras invoke() {
        /*
            r1 = this;
            d10.a r0 = r1.$extrasProducer
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            androidx.lifecycle.viewmodel.CreationExtras r0 = (androidx.lifecycle.viewmodel.CreationExtras) r0
            if (r0 != 0) goto L_0x0012
        L_0x000c:
            androidx.activity.ComponentActivity r0 = r1.$this_viewModels
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ui.EdgeEngineContainerActivity$special$$inlined$viewModels$default$3.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
