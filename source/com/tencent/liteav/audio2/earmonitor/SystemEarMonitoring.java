package com.tencent.liteav.audio2.earmonitor;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;

@JNINamespace("liteav::audio")
public abstract class SystemEarMonitoring {
    private final long mNativeSystemEarMonitoring;

    public SystemEarMonitoring(long j11) {
        this.mNativeSystemEarMonitoring = j11;
    }

    public static SystemEarMonitoring create(long j11) {
        String manufacturer = LiteavSystemInfo.getManufacturer();
        if (TextUtils.isEmpty(manufacturer)) {
            return null;
        }
        String lowerCase = manufacturer.toLowerCase();
        lowerCase.hashCode();
        if (lowerCase.equals(MTPushConstants.Manufacturer.HUAWEI)) {
            return new a(j11, ContextUtils.getApplicationContext());
        }
        if (!lowerCase.equals("vivo")) {
            return null;
        }
        return new h(j11, ContextUtils.getApplicationContext());
    }

    private static native void nativeNotifySystemEarMonitoringError(long j11, SystemEarMonitoring systemEarMonitoring);

    private static native void nativeNotifySystemEarMonitoringInitialized(long j11, SystemEarMonitoring systemEarMonitoring, boolean z11);

    public abstract void initialize();

    public void notifySystemEarMonitoringError(SystemEarMonitoring systemEarMonitoring) {
        nativeNotifySystemEarMonitoringError(this.mNativeSystemEarMonitoring, systemEarMonitoring);
    }

    public void notifySystemEarMonitoringInitialized(SystemEarMonitoring systemEarMonitoring, boolean z11) {
        nativeNotifySystemEarMonitoringInitialized(this.mNativeSystemEarMonitoring, systemEarMonitoring, z11);
    }

    public abstract void setEarMonitoringVolume(int i11);

    public abstract void startEarMonitoring();

    public abstract void stopEarMonitoring();

    public abstract void terminate();
}
