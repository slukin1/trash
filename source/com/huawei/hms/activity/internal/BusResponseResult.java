package com.huawei.hms.activity.internal;

import android.content.Intent;

public class BusResponseResult {

    /* renamed from: a  reason: collision with root package name */
    private Intent f37682a;

    /* renamed from: b  reason: collision with root package name */
    private int f37683b;

    public int getCode() {
        return this.f37683b;
    }

    public Intent getIntent() {
        return this.f37682a;
    }

    public void setCode(int i11) {
        this.f37683b = i11;
    }

    public void setIntent(Intent intent) {
        this.f37682a = intent;
    }
}
