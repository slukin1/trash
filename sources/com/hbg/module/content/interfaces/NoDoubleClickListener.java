package com.hbg.module.content.interfaces;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Calendar;

public abstract class NoDoubleClickListener implements View.OnClickListener {
    private long lastClickTime;
    private final int minClickDelayTime = 1000;

    @SensorsDataInstrumented
    public void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.lastClickTime > ((long) this.minClickDelayTime)) {
            this.lastClickTime = timeInMillis;
            onViewClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public abstract void onViewClick(View view);
}
