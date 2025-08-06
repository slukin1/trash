package com.hbg.module.content.ui.activity.live;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;

public final /* synthetic */ class t1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDetailActivity f18705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveDetailBean f18706c;

    public /* synthetic */ t1(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean) {
        this.f18705b = liveDetailActivity;
        this.f18706c = liveDetailBean;
    }

    public final void onClick(View view) {
        LiveDetailActivity.Ak(this.f18705b, this.f18706c, view);
    }
}
