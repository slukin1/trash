package com.tencent.liteav.sdkcommon;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final g f21671a;

    private k(g gVar) {
        this.f21671a = gVar;
    }

    public static View.OnClickListener a(g gVar) {
        return new k(gVar);
    }

    @SensorsDataInstrumented
    public final void onClick(View view) {
        this.f21671a.a(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
