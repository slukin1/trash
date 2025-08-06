package butterknife.internal;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static final Runnable ENABLE_AGAIN = a.f12993b;
    public static boolean enabled = true;

    public abstract void doClick(View view);

    @SensorsDataInstrumented
    public final void onClick(View view) {
        if (enabled) {
            enabled = false;
            view.post(ENABLE_AGAIN);
            doClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
