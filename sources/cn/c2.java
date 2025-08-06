package cn;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final /* synthetic */ class c2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c2 f13126b = new c2();

    public final void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
