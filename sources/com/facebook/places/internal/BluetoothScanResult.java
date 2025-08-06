package com.facebook.places.internal;

public class BluetoothScanResult {
    public String payload;
    public int rssi;
    public long timestampNanos;

    public BluetoothScanResult(String str, int i11, long j11) {
        this.payload = str;
        this.rssi = i11;
        this.timestampNanos = j11;
    }
}
