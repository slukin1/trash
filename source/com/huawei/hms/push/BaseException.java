package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

public class BaseException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final int f38331a;

    /* renamed from: b  reason: collision with root package name */
    private final ErrorEnum f38332b;

    public BaseException(int i11) {
        ErrorEnum fromCode = ErrorEnum.fromCode(i11);
        this.f38332b = fromCode;
        this.f38331a = fromCode.getExternalCode();
    }

    public int getErrorCode() {
        return this.f38331a;
    }

    public String getMessage() {
        return this.f38332b.getMessage();
    }
}
