package com.hbg.module.kline.ui;

import android.view.View;
import androidx.fragment.app.DialogFragment;

public final /* synthetic */ class q2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogFragment f24258c;

    public /* synthetic */ q2(MarketInfoFragment marketInfoFragment, DialogFragment dialogFragment) {
        this.f24257b = marketInfoFragment;
        this.f24258c = dialogFragment;
    }

    public final void onClick(View view) {
        this.f24257b.Ml(this.f24258c, view);
    }
}
