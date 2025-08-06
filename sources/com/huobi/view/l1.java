package com.huobi.view;

import android.view.View;
import com.huobi.view.PriceTypeLabelsView;

public final /* synthetic */ class l1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PriceTypeLabelsView f19068b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PriceTypeLabelsView.PriceTypeLabel f19069c;

    public /* synthetic */ l1(PriceTypeLabelsView priceTypeLabelsView, PriceTypeLabelsView.PriceTypeLabel priceTypeLabel) {
        this.f19068b = priceTypeLabelsView;
        this.f19069c = priceTypeLabel;
    }

    public final void onClick(View view) {
        this.f19068b.lambda$bindItemData$0(this.f19069c, view);
    }
}
