package bl;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ h f12599b = new h();

    public final void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
