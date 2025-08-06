package com.hbg.module.huobi.im.utils;

import android.os.Parcel;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import rd.o;

public class ClickableForegroundColorSpan extends ForegroundColorSpan {
    private o mOnClickListener;

    public ClickableForegroundColorSpan(int i11) {
        super(i11);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        o oVar = this.mOnClickListener;
        if (oVar != null) {
            oVar.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setOnClickListener(o oVar) {
        this.mOnClickListener = oVar;
    }

    public ClickableForegroundColorSpan(Parcel parcel) {
        super(parcel);
    }
}
