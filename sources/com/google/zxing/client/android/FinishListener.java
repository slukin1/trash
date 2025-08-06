package com.google.zxing.client.android;

import android.app.Activity;
import android.content.DialogInterface;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class FinishListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    private final Activity activityToFinish;

    public FinishListener(Activity activity) {
        this.activityToFinish = activity;
    }

    private void run() {
        this.activityToFinish.finish();
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @SensorsDataInstrumented
    public void onClick(DialogInterface dialogInterface, int i11) {
        run();
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }
}
