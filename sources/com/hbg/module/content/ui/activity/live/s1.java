package com.hbg.module.content.ui.activity.live;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;

public final /* synthetic */ class s1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiveDetailActivity f18701b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveDetailBean f18702c;

    public /* synthetic */ s1(LiveDetailActivity liveDetailActivity, LiveDetailBean liveDetailBean) {
        this.f18701b = liveDetailActivity;
        this.f18702c = liveDetailBean;
    }

    public final void onClick(View view) {
        LiveDetailActivity.sk(this.f18701b, this.f18702c, view);
    }
}
