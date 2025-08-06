package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.TraderRank;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f17943b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17944c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TraderRank.TraderInfo f17945d;

    public /* synthetic */ u(v vVar, int i11, TraderRank.TraderInfo traderInfo) {
        this.f17943b = vVar;
        this.f17944c = i11;
        this.f17945d = traderInfo;
    }

    public final void onClick(View view) {
        v.n(this.f17943b, this.f17944c, this.f17945d, view);
    }
}
