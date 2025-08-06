package com.jumio.sdk.views;

import android.app.Activity;
import com.jumio.core.interfaces.ActivityAttacherInterface;
import com.jumio.sdk.scanpart.JumioScanPart;

public final class JumioActivityAttacher {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f25017a;

    public JumioActivityAttacher(Activity activity) {
        this.f25017a = activity;
    }

    public final void attach(JumioScanPart jumioScanPart) {
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof ActivityAttacherInterface) {
            ((ActivityAttacherInterface) jumioScanPart.getScanPart$jumio_core_release()).setActivityAttacher(this);
        }
    }

    public final Activity getActivity() {
        return this.f25017a;
    }
}
