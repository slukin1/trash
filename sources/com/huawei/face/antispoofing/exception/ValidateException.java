package com.huawei.face.antispoofing.exception;

import com.huawei.face.antispoofing.http.ValidateCodeEnum;

public class ValidateException extends RuntimeException {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private ValidateCodeEnum f37553a;

    /* renamed from: b  reason: collision with root package name */
    private String f37554b;

    public ValidateException(ValidateCodeEnum validateCodeEnum) {
        this.f37553a = validateCodeEnum;
        this.f37554b = validateCodeEnum.getMessage();
    }

    public ValidateCodeEnum getCode() {
        return this.f37553a;
    }

    public String getMessage() {
        return this.f37554b;
    }

    public ValidateException(String str) {
        this.f37553a = ValidateCodeEnum.UNEXPECTED_ERROR;
        this.f37554b = str;
    }

    public ValidateException(ValidateCodeEnum validateCodeEnum, String str) {
        this.f37553a = validateCodeEnum;
        this.f37554b = str;
    }

    public ValidateException(ValidateCodeEnum validateCodeEnum, Throwable th2) {
        super(th2);
        this.f37553a = validateCodeEnum;
        this.f37554b = validateCodeEnum.getMessage();
    }

    public ValidateException(ValidateCodeEnum validateCodeEnum, String str, Throwable th2) {
        super(th2);
        this.f37553a = validateCodeEnum;
        this.f37554b = str;
    }
}
