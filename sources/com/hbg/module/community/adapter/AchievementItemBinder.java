package com.hbg.module.community.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.MedalHomePageShare;
import com.hbg.module.community.multiadapter.ItemViewBinder;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import lc.m2;

public final class AchievementItemBinder extends ItemViewBinder<MedalHomePageShare.ShowMedalsBean, ItemViewBinder.a<m2>> {
    @SensorsDataInstrumented
    public static final void s(MedalHomePageShare.ShowMedalsBean showMedalsBean, View view) {
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        HBBaseWebActivity.showWebView(view.getContext(), a11.k("welfare/medal-detail/?medalCode=" + showMedalsBean.getMedalCode()), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: r */
    public void c(ItemViewBinder.a<m2> aVar, MedalHomePageShare.ShowMedalsBean showMedalsBean, boolean z11, int i11) {
        aVar.e().C.setText(showMedalsBean.getMedalName());
        c.a().e(aVar.e().B, showMedalsBean.getImageUrl());
        aVar.itemView.setOnClickListener(new a(showMedalsBean));
    }

    /* renamed from: t */
    public ItemViewBinder.a<m2> m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ItemViewBinder.a<>(m2.K(layoutInflater, viewGroup, false));
    }
}
