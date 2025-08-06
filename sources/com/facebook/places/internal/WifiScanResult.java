package com.facebook.places.internal;

public class WifiScanResult {
    public String bssid;
    public int frequency;
    public int rssi;
    public String ssid;
    public long timestampMs;

    public WifiScanResult() {
    }

    public WifiScanResult(String str, String str2, int i11, int i12, long j11) {
        this.ssid = str;
        this.bssid = str2;
        this.rssi = i11;
        this.frequency = i12;
        this.timestampMs = j11;
    }
}
