package com.hbg.module.kline.handler;

import ae.b;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.lib.core.util.CommonFunc;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.SocialMediaItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;

public class SocialMediaHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(v9.c cVar, SocialMediaItem socialMediaItem, View view) {
        Context context = cVar.itemView.getContext();
        if (context != null) {
            CommonFunc.a(context, socialMediaItem.getUrl());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, SocialMediaItem socialMediaItem, ViewGroup viewGroup) {
        ((ImageView) cVar.e().b(R$id.ivSocialMedialIcon)).setImageResource(socialMediaItem.getImageResId());
        if (!TextUtils.isEmpty(socialMediaItem.getUrl())) {
            cVar.itemView.setOnClickListener(new b(cVar, socialMediaItem));
        }
    }

    public int getResId() {
        return R$layout.item_social_media;
    }
}
