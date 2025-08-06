package com.huobi.account.viewhandler;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.account.bean.PersonalCenterActivityData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import gs.g;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import vg.e;

public class PersonalCenterActivityHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(PersonalCenterActivityData personalCenterActivityData, Context context, int i11, View view) {
        String jumpUrl = personalCenterActivityData.getJumpUrl();
        if (!TextUtils.isEmpty(jumpUrl)) {
            Intent intent = new Intent();
            intent.putExtra("url", jumpUrl);
            intent.putExtra("title_back", context.getString(R.string.head_return));
            intent.setClass(context, HBBaseWebActivity.class);
            context.startActivity(intent);
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(i11 + 1));
            g.i("Activity_Me_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, PersonalCenterActivityData personalCenterActivityData, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View b11 = e11.b(R.id.item_activity_layout);
        ImageView imageView = (ImageView) e11.b(R.id.item_activity_image);
        ImageView imageView2 = (ImageView) e11.b(R.id.item_activity_subimage);
        ((TextView) e11.b(R.id.item_activity_title)).setText(personalCenterActivityData.getTitle());
        ((TextView) e11.b(R.id.item_activity_introduction)).setText(personalCenterActivityData.getIntroduction());
        if (!TextUtils.isEmpty(personalCenterActivityData.getImageUrl())) {
            b.c().h(imageView, personalCenterActivityData.getImageUrl());
        }
        if (!TextUtils.isEmpty(personalCenterActivityData.getSubUrl())) {
            b.c().h(imageView2, personalCenterActivityData.getSubUrl());
        }
        b11.setOnClickListener(new e(personalCenterActivityData, cVar.itemView.getContext(), i11));
    }

    public int getResId() {
        return R.layout.layout_personalcenter_activity_item;
    }
}
