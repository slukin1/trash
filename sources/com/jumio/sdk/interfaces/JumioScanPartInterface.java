package com.jumio.sdk.interfaces;

import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;

public interface JumioScanPartInterface {
    void onScanStep(JumioScanStep jumioScanStep, Object obj);

    void onUpdate(JumioScanUpdate jumioScanUpdate, Object obj);
}
