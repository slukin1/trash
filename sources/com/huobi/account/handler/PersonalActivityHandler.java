package com.huobi.account.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.huobi.index.bean.IndexFeatureItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import gs.g;
import i6.r;
import java.util.HashMap;
import pg.a;
import pro.huobi.R;
import s9.c;
import yl.o;

public class PersonalActivityHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, View view) {
        IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
        indexFeatureItem.setJumpMode(1);
        indexFeatureItem.setJumpUrl(aVar.d());
        o.p((FragmentActivity) oa.a.g().b(), indexFeatureItem);
        HashMap hashMap = new HashMap();
        hashMap.put("type", aVar.g());
        g.i("Activity_View_Me_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        b.c().h((ImageView) e11.b(R.id.image_view_personal_footprint_activity_item_logo), aVar.e());
        ((TextView) e11.b(R.id.text_view_personal_footprint_activity_item_title)).setText(aVar.g());
        ViewUtil.m((TextView) e11.b(R.id.text_view_personal_footprint_activity_item_participation), aVar.c());
        cVar.itemView.setOnClickListener(new sg.b(aVar));
    }

    public int getResId() {
        return R.layout.item_personal_footprint_activity;
    }
}
