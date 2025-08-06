package com.huobi.index.ui;

import com.huobi.index.bean.RankingListData;
import com.huobi.index.ui.RankingBridgeAbility;

public final /* synthetic */ class t1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f73984b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RankingListData f73985c;

    public /* synthetic */ t1(String str, RankingListData rankingListData) {
        this.f73984b = str;
        this.f73985c = rankingListData;
    }

    public final void run() {
        RankingBridgeAbility.a.b(this.f73984b, this.f73985c);
    }
}
