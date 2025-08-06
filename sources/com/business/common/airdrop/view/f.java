package com.business.common.airdrop.view;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class f implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AirdropDetailBean f64334a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f64335b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f64336c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AirdropView f64337d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f64338e;

    public /* synthetic */ f(AirdropDetailBean airdropDetailBean, int i11, String str, AirdropView airdropView, FragmentActivity fragmentActivity) {
        this.f64334a = airdropDetailBean;
        this.f64335b = i11;
        this.f64336c = str;
        this.f64337d = airdropView;
        this.f64338e = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        AirdropView.G(this.f64334a, this.f64335b, this.f64336c, this.f64337d, this.f64338e, hBDialogFragment);
    }
}
