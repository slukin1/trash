package com.huobi.copytrading.ui;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;

public final /* synthetic */ class m implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f43696a;

    public /* synthetic */ m(ArrayList arrayList) {
        this.f43696a = arrayList;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        CopyTradingMeFragment.Dh(this.f43696a, tab, i11);
    }
}
