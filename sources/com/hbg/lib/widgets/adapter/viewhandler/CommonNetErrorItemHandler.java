package com.hbg.lib.widgets.adapter.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.adapter.bean.CommonNetErrorItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import w9.b;

public class CommonNetErrorItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(CommonNetErrorItem commonNetErrorItem, View view) {
        if (commonNetErrorItem.c() != null) {
            commonNetErrorItem.c().a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, CommonNetErrorItem commonNetErrorItem, ViewGroup viewGroup) {
        cVar.e().b(R$id.viewErrorRetry).setOnClickListener(new b(commonNetErrorItem));
    }

    public int getResId() {
        return R$layout.common_error_view;
    }
}
