package vh;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ s f61055b = new s();

    public final void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
