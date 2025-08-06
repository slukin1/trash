package com.huobi.finance.ui;

import android.view.View;

public final /* synthetic */ class u1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetFragment f47344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47345c;

    public /* synthetic */ u1(BalanceAssetFragment balanceAssetFragment, String str) {
        this.f47344b = balanceAssetFragment;
        this.f47345c = str;
    }

    public final void onClick(View view) {
        this.f47344b.Rj(this.f47345c, view);
    }
}
