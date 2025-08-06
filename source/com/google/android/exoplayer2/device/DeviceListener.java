package com.google.android.exoplayer2.device;

@Deprecated
public interface DeviceListener {
    void onDeviceInfoChanged(DeviceInfo deviceInfo);

    void onDeviceVolumeChanged(int i11, boolean z11);
}
