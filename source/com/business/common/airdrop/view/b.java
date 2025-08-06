package com.business.common.airdrop.view;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f64321b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AirdropDetailBean f64322c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f64323d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f64324e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ AirdropView f64325f;

    public /* synthetic */ b(long j11, AirdropDetailBean airdropDetailBean, int i11, String str, AirdropView airdropView) {
        this.f64321b = j11;
        this.f64322c = airdropDetailBean;
        this.f64323d = i11;
        this.f64324e = str;
        this.f64325f = airdropView;
    }

    public final void onClick(View view) {
        AirdropView.K(this.f64321b, this.f64322c, this.f64323d, this.f64324e, this.f64325f, view);
    }
}
