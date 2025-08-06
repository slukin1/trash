package com.huobi.index.ui;

import android.view.View;
import com.huobi.index.viewhandler.RankDynamicItemHandler;

public final /* synthetic */ class c1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexRankingFragment f73873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RankDynamicItemHandler f73874c;

    public /* synthetic */ c1(IndexRankingFragment indexRankingFragment, RankDynamicItemHandler rankDynamicItemHandler) {
        this.f73873b = indexRankingFragment;
        this.f73874c = rankDynamicItemHandler;
    }

    public final void onClick(View view) {
        this.f73873b.Jh(this.f73874c, view);
    }
}
