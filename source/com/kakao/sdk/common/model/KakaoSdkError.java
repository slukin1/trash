package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/kakao/sdk/common/model/KakaoSdkError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "isInvalidTokenError", "", "Lcom/kakao/sdk/common/model/ApiError;", "Lcom/kakao/sdk/common/model/AppsError;", "Lcom/kakao/sdk/common/model/AuthError;", "Lcom/kakao/sdk/common/model/ClientError;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class KakaoSdkError extends RuntimeException {
    private final String msg;

    private KakaoSdkError(String str) {
        super(str);
        this.msg = str;
    }

    public /* synthetic */ KakaoSdkError(String str, r rVar) {
        this(str);
    }

    public String getMsg() {
        return this.msg;
    }

    public final boolean isInvalidTokenError() {
        if (!(this instanceof AuthError)) {
            return (this instanceof ApiError) && ((ApiError) this).getReason() == ApiErrorCause.InvalidToken;
        }
        if (((AuthError) this).getReason() == AuthErrorCause.InvalidGrant) {
            return true;
        }
    }
}
