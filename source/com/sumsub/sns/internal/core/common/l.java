package com.sumsub.sns.internal.core.common;

import android.os.SystemClock;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.a;
import kotlin.Unit;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final int f32095a = 400;

    /* renamed from: b  reason: collision with root package name */
    public static long f32096b;

    public static final void a(View view, a<Unit> aVar) {
        view.setOnClickListener(new l1(aVar));
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, View view) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f32096b >= 400) {
            f32096b = elapsedRealtime;
            aVar.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
