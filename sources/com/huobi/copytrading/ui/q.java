package com.huobi.copytrading.ui;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;

public final /* synthetic */ class q implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f43701a;

    public /* synthetic */ q(ArrayList arrayList) {
        this.f43701a = arrayList;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        CopyTradingTradeFragment.Oh(this.f43701a, tab, i11);
    }
}
