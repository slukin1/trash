package com.huawei.hms.api;

public final class HuaweiServicesNotAvailableException extends Exception {
    public final int errorCode;

    public HuaweiServicesNotAvailableException(int i11) {
        this.errorCode = i11;
    }
}
