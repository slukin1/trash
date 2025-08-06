package com.huobi.copytrading.ui;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huobi.copytrading.ui.CopyTradingTraderInfoActivity;
import java.util.ArrayList;

public final /* synthetic */ class a0 implements TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f43684a;

    public /* synthetic */ a0(ArrayList arrayList) {
        this.f43684a = arrayList;
    }

    public final void onConfigureTab(TabLayout.Tab tab, int i11) {
        CopyTradingTraderInfoActivity.b.d(this.f43684a, tab, i11);
    }
}
