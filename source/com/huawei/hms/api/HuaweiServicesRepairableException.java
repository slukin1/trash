package com.huawei.hms.api;

import android.content.Intent;

public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i11, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i11;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
