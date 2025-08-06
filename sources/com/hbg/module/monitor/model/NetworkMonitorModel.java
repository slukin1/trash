package com.hbg.module.monitor.model;

import androidx.annotation.Keep;

@Keep
public class NetworkMonitorModel {
    private final String path;
    private int requestFailed;
    private int requestSuccess;
    private int requestTotal;

    public NetworkMonitorModel(String str, int i11, int i12, int i13) {
        this.path = str;
        this.requestTotal = i11;
        this.requestSuccess = i12;
        this.requestFailed = i13;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getRequestFailed() {
        return this.requestFailed;
    }

    public final int getRequestSuccess() {
        return this.requestSuccess;
    }

    public final int getRequestTotal() {
        return this.requestTotal;
    }

    public final void setRequestFailed(int i11) {
        this.requestFailed = i11;
    }

    public final void setRequestSuccess(int i11) {
        this.requestSuccess = i11;
    }

    public final void setRequestTotal(int i11) {
        this.requestTotal = i11;
    }
}
