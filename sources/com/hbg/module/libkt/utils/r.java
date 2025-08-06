package com.hbg.module.libkt.utils;

import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.huobi.view.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f24939a = new r();

    @SensorsDataInstrumented
    public static final void h(View view, long j11, View.OnClickListener onClickListener, View view2) {
        long currentTimeMillis = System.currentTimeMillis();
        r rVar = f24939a;
        if (currentTimeMillis - rVar.b(view) > j11 || (view instanceof Checkable)) {
            rVar.e(view, currentTimeMillis);
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    public final <T extends View> long b(T t11) {
        Object tag = t11.getTag(1766613352);
        Long l11 = tag instanceof Long ? (Long) tag : null;
        if (l11 != null) {
            return l11.longValue();
        }
        return 0;
    }

    public final void c(View view, int i11) {
        view.setBackgroundColor(view.getContext().getResources().getColor(i11));
    }

    public final void d(RoundViewDelegate roundViewDelegate, int i11) {
        roundViewDelegate.setBackgroundColor(roundViewDelegate.getView().getResources().getColor(i11));
    }

    public final <T extends View> void e(T t11, long j11) {
        t11.setTag(1766613352, Long.valueOf(j11));
    }

    public final void f(TextView textView, int i11) {
        textView.setTextColor(textView.getContext().getResources().getColor(i11));
    }

    public final <T extends View> void g(T t11, View.OnClickListener onClickListener, long j11) {
        t11.setOnClickListener(new q(t11, j11, onClickListener));
    }
}
