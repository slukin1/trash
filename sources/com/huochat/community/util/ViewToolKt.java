package com.huochat.community.util;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import kotlin.Unit;

public final class ViewToolKt {
    public static final void setOnClickListener(View[] viewArr, l<? super View, Unit> lVar) {
        c cVar = new c(lVar);
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(cVar);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void setOnClickListener$lambda$0(l lVar, View view) {
        lVar.invoke(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void setOnClickListener(View[] viewArr, View.OnClickListener onClickListener) {
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }
}
