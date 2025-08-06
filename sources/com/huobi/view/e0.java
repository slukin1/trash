package com.huobi.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final /* synthetic */ class e0 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HIndicator f19025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f19026c;

    public /* synthetic */ e0(HIndicator hIndicator, RecyclerView recyclerView) {
        this.f19025b = hIndicator;
        this.f19026c = recyclerView;
    }

    public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f19025b.lambda$bindRecyclerView$0(this.f19026c, view, i11, i12, i13, i14, i15, i16, i17, i18);
    }
}
