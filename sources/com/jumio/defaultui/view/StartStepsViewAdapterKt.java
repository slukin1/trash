package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class StartStepsViewAdapterKt {
    /* access modifiers changed from: private */
    public static final View inflate(ViewGroup viewGroup, int i11, boolean z11) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, z11);
    }

    public static /* synthetic */ View inflate$default(ViewGroup viewGroup, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return inflate(viewGroup, i11, z11);
    }
}
