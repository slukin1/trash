package com.jumio.defaultui.view;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.jvm.internal.Lambda;

public final class JumioBottomSheet$special$$inlined$activityViewModels$default$2 extends Lambda implements a<CreationExtras> {
    public final /* synthetic */ a $extrasProducer;
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioBottomSheet$special$$inlined$activityViewModels$default$2(a aVar, Fragment fragment) {
        super(0);
        this.$extrasProducer = aVar;
        this.$this_activityViewModels = fragment;
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
            if (r0 != 0) goto L_0x0016
        L_0x000c:
            androidx.fragment.app.Fragment r0 = r1.$this_activityViewModels
            androidx.fragment.app.FragmentActivity r0 = r0.requireActivity()
            androidx.lifecycle.viewmodel.CreationExtras r0 = r0.getDefaultViewModelCreationExtras()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.JumioBottomSheet$special$$inlined$activityViewModels$default$2.invoke():androidx.lifecycle.viewmodel.CreationExtras");
    }
}
