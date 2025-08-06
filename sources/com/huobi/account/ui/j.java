package com.huobi.account.ui;

import androidx.recyclerview.widget.RecyclerView;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseCityFragment f41715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f41716c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f41717d;

    public /* synthetic */ j(ChooseCityFragment chooseCityFragment, RecyclerView recyclerView, int i11) {
        this.f41715b = chooseCityFragment;
        this.f41716c = recyclerView;
        this.f41717d = i11;
    }

    public final void run() {
        this.f41715b.Fh(this.f41716c, this.f41717d);
    }
}
