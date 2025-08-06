package com.kakao.sdk.common.model;

import com.tencent.tpns.baseapi.base.util.ErrCode;
import kotlin.Metadata;
import org.opencv.core.Core;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b#\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/kakao/sdk/common/model/ApiErrorCause;", "", "errorCode", "", "(Ljava/lang/String;II)V", "getErrorCode", "()I", "InternalError", "IllegalParams", "UnsupportedApi", "BlockedAction", "PermissionDenied", "DeprecatedApi", "ApiLimitExceeded", "NotRegisteredUser", "AlreadyRegisteredUser", "AccountDoesNotExist", "PropertyKeyDoesNotExist", "AppDoesNotExist", "InvalidToken", "InsufficientScope", "RequiredAgeVerification", "UnderAgeLimit", "SigningIsNotCompleted", "InvalidTransaction", "TransactionHasExpired", "NotTalkUser", "NotFriend", "UserDeviceUnsupported", "TalkMessageDisabled", "TalkSendMessageMonthlyLimitExceed", "TalkSendMessageDailyLimitExceed", "ImageUploadSizeExceeded", "ServerTimeOut", "ImageMaxUploadCountExceed", "DeveloperDoesNotExist", "UnderMaintenance", "Unknown", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ApiErrorCause {
    InternalError(-1),
    IllegalParams(-2),
    UnsupportedApi(-3),
    BlockedAction(-4),
    PermissionDenied(-5),
    DeprecatedApi(-9),
    ApiLimitExceeded(-10),
    NotRegisteredUser(ErrCode.INNER_ERROR_JSON),
    AlreadyRegisteredUser(ErrCode.INNER_ERROR_TOKEN_NULL),
    AccountDoesNotExist(ErrCode.INNER_ERROR_RECV_PKG_NULL),
    PropertyKeyDoesNotExist(Core.StsBadSize),
    AppDoesNotExist(-301),
    InvalidToken(-401),
    InsufficientScope(-402),
    RequiredAgeVerification(-405),
    UnderAgeLimit(-406),
    SigningIsNotCompleted(-421),
    InvalidTransaction(-422),
    TransactionHasExpired(-423),
    NotTalkUser(ErrCode.GUID_ACCESS_IDKEY_ERROR),
    NotFriend(ErrCode.GUID_RESULT_FORMAT_ERROR),
    UserDeviceUnsupported(ErrCode.GUID_REQ_FAIL),
    TalkMessageDisabled(-530),
    TalkSendMessageMonthlyLimitExceed(-531),
    TalkSendMessageDailyLimitExceed(-532),
    ImageUploadSizeExceeded(ErrCode.MQTT_DISCONNECT_FAIL_NULL),
    ServerTimeOut(-603),
    ImageMaxUploadCountExceed(-606),
    DeveloperDoesNotExist(-903),
    UnderMaintenance(-9798),
    Unknown(Integer.MAX_VALUE);
    
    private final int errorCode;

    private ApiErrorCause(int i11) {
        this.errorCode = i11;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
