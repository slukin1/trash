package com.huawei.face.antispoofing.http;

import com.tencent.imsdk.BaseConstants;

public enum ValidateCodeEnum {
    UNEXPECTED_ERROR(10000, "unexpected error"),
    DATA_REQUIRED(10001, "inputData can't be null"),
    TOKEN_REQUIRED(10002, "inputData.token can't be empty"),
    TOKEN_UNREASONABLE(BaseConstants.ERR_SVR_GROUP_API_NAME_ERROR, "inputData.token is not reasonable"),
    PROJECT_ID_REQUIRED(BaseConstants.ERR_SVR_GROUP_INVALID_PARAMETERS, "inputData.projectId can't be empty"),
    API_VERSION_REQUIRED(BaseConstants.ERR_SVR_GROUP_ACOUNT_COUNT_LIMIT, "inputData.apiVersion can't be empty"),
    API_ENDPOINT_REQUIRED(BaseConstants.ERR_SVR_GROUP_FREQ_LIMIT, "inputData.apiEndpoint can't be empty"),
    SDK_LICENSE_REQUIRED(BaseConstants.ERR_SVR_GROUP_PERMISSION_DENY, "inputData.sdkLicense can't be empty"),
    DETECTTIMES_POSITIVE_AND_DETECTTYPE_NOT_EMPTY(BaseConstants.ERR_SVR_GROUP_INVALID_REQ, "inputData.detectTimes must be positive, and inputData.detectTypeList can't be empty"),
    TIMEOUT_MS_MUST_POSITIVE(BaseConstants.ERR_SVR_GROUP_SUPER_NOT_ALLOW_QUIT, "inputData.timeoutMs must be positive"),
    CONFIDENCE_THREAD_MUST_POSITIVE(BaseConstants.ERR_SVR_GROUP_NOT_FOUND, "inputData.confidenceThread must be positive"),
    NO_CACHE_TASK_EXECUTOR_RUNNING(BaseConstants.ERR_SVR_MSG_PKG_PARSE_FAILED, "NoCacheTaskExecutor is running, can not start again");
    

    /* renamed from: a  reason: collision with root package name */
    private int f37557a;

    /* renamed from: b  reason: collision with root package name */
    private String f37558b;

    private ValidateCodeEnum(int i11, String str) {
        this.f37557a = i11;
        this.f37558b = str;
    }

    public int getCode() {
        return this.f37557a;
    }

    public String getMessage() {
        return this.f37558b;
    }
}
