package com.hbg.module.community.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.MedalHomePageShare;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MedalHomePageShare.ShowMedalsBean f17179b;

    public /* synthetic */ a(MedalHomePageShare.ShowMedalsBean showMedalsBean) {
        this.f17179b = showMedalsBean;
    }

    public final void onClick(View view) {
        AchievementItemBinder.s(this.f17179b, view);
    }
}
