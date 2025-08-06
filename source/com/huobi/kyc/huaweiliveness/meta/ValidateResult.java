package com.huobi.kyc.huaweiliveness.meta;

import com.huawei.face.antispoofing.http.ValidateCodeEnum;
import com.huawei.face.antispoofing.meta.DetectResult;

public class ValidateResult extends DetectResult {
    private ValidateCodeEnum validateCode;

    private ValidateResult(ValidateCodeEnum validateCodeEnum) {
        this.validateCode = validateCodeEnum;
    }

    public static ValidateResult validate(ValidateCodeEnum validateCodeEnum) {
        return new ValidateResult(validateCodeEnum);
    }

    public ValidateCodeEnum getValidateResult() {
        return this.validateCode;
    }
}
