package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult {

    /* renamed from: a  reason: collision with root package name */
    private int f38483a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f38484b;

    public BundleResult(int i11, Bundle bundle) {
        this.f38483a = i11;
        this.f38484b = bundle;
    }

    public int getResultCode() {
        return this.f38483a;
    }

    public Bundle getRspBody() {
        return this.f38484b;
    }

    public void setResultCode(int i11) {
        this.f38483a = i11;
    }

    public void setRspBody(Bundle bundle) {
        this.f38484b = bundle;
    }
}
