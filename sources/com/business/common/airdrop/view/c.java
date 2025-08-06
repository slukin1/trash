package com.business.common.airdrop.view;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AirdropDetailBean f64326b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AirdropView f64327c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f64328d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f64329e;

    public /* synthetic */ c(AirdropDetailBean airdropDetailBean, AirdropView airdropView, int i11, String str) {
        this.f64326b = airdropDetailBean;
        this.f64327c = airdropView;
        this.f64328d = i11;
        this.f64329e = str;
    }

    public final void onClick(View view) {
        AirdropView.F(this.f64326b, this.f64327c, this.f64328d, this.f64329e, view);
    }
}
