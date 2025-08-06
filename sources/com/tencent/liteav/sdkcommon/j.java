package com.tencent.liteav.sdkcommon;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final g f21669a;

    /* renamed from: b  reason: collision with root package name */
    private final Button f21670b;

    private j(g gVar, Button button) {
        this.f21669a = gVar;
        this.f21670b = button;
    }

    public static View.OnClickListener a(g gVar, Button button) {
        return new j(gVar, button);
    }

    @SensorsDataInstrumented
    public final void onClick(View view) {
        g gVar = this.f21669a;
        boolean z11 = gVar.f21658m;
        if (!z11) {
            gVar.f21647b.height = gVar.f21659n / 2;
        } else {
            WindowManager.LayoutParams layoutParams = gVar.f21647b;
            int i11 = gVar.f21659n;
            layoutParams.height = i11;
            int i12 = layoutParams.y;
            int i13 = i11 + i12;
            int i14 = gVar.f21646a.heightPixels;
            if (i13 > i14) {
                layoutParams.height = i14 - i12;
            }
        }
        gVar.f21658m = !z11;
        gVar.f21651f.updateViewLayout(gVar.f21652g, gVar.f21647b);
        ViewGroup.LayoutParams layoutParams2 = gVar.f21656k.getLayoutParams();
        layoutParams2.height = gVar.b();
        gVar.f21656k.setLayoutParams(layoutParams2);
        gVar.f21649d.post(l.a(gVar));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
