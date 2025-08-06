package com.business.common.airdrop.view;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f64318b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f64319c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AirdropView f64320d;

    public /* synthetic */ a(int i11, String str, AirdropView airdropView) {
        this.f64318b = i11;
        this.f64319c = str;
        this.f64320d = airdropView;
    }

    public final void onClick(View view) {
        AirdropView.L(this.f64318b, this.f64319c, this.f64320d, view);
    }
}
