package com.huobi.zeroswap.ui;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;

public final /* synthetic */ class c implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f21225a;

    public /* synthetic */ c(ArrayList arrayList) {
        this.f21225a = arrayList;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        ZeroSwapActivity.Mh(this.f21225a, tab, i11);
    }
}
