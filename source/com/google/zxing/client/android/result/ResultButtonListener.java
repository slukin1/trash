package com.google.zxing.client.android.result;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class ResultButtonListener implements View.OnClickListener {
    private final int index;
    private final ResultHandler resultHandler;

    public ResultButtonListener(ResultHandler resultHandler2, int i11) {
        this.resultHandler = resultHandler2;
        this.index = i11;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.resultHandler.handleButtonPress(this.index);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
