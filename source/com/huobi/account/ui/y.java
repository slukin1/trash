package com.huobi.account.ui;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.account.ui.HuobiZopimChatActivity;

public final /* synthetic */ class y implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HuobiZopimChatActivity.d f41855b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f41856c;

    public /* synthetic */ y(HuobiZopimChatActivity.d dVar, RecyclerView recyclerView) {
        this.f41855b = dVar;
        this.f41856c = recyclerView;
    }

    public final boolean onPreDraw() {
        return this.f41855b.h(this.f41856c);
    }
}
