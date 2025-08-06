package com.huobi.index.ui;

import com.huobi.index.bean.RankingListData;

public final /* synthetic */ class s1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RankingListData f73980b;

    public /* synthetic */ s1(RankingListData rankingListData) {
        this.f73980b = rankingListData;
    }

    public final void run() {
        RankingBridgeAbility.d(this.f73980b);
    }
}
