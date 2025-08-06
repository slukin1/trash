package rt;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q f25865b = new q();

    public final void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
