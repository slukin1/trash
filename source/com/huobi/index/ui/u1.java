package com.huobi.index.ui;

import com.huobi.index.ui.RankingNewSymbolView;
import v9.a;

public final /* synthetic */ class u1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RankingNewSymbolView.RankingWaitNewSymbolView f73988b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f73989c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f73990d;

    public /* synthetic */ u1(RankingNewSymbolView.RankingWaitNewSymbolView rankingWaitNewSymbolView, int i11, a aVar) {
        this.f73988b = rankingWaitNewSymbolView;
        this.f73989c = i11;
        this.f73990d = aVar;
    }

    public final void run() {
        this.f73988b.d(this.f73989c, this.f73990d);
    }
}
