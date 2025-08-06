package vh;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t f61056b = new t();

    public final void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
