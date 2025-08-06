package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

public class f extends TaskApiCall<PushClient, Void> {

    /* renamed from: a  reason: collision with root package name */
    private DeleteTokenReq f38310a;

    public f(String str, DeleteTokenReq deleteTokenReq, String str2) {
        super(str, JsonUtil.createJsonString(deleteTokenReq), str2);
        this.f38310a = deleteTokenReq;
    }

    /* renamed from: a */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            String str2 = HmsInstanceId.TAG;
            HMSLog.e(str2, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.c(fromCode.toApiException());
            } else {
                taskCompletionSource.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        } else {
            ErrorEnum fromCode2 = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
            if (fromCode2 != ErrorEnum.SUCCESS) {
                taskCompletionSource.c(fromCode2.toApiException());
                return;
            }
            taskCompletionSource.d(null);
            h.a(pushClient.getContext(), getUri(), responseErrorCode);
        }
    }

    public int getMinApkVersion() {
        return this.f38310a.isMultiSender() ? 50004300 : 30000000;
    }
}
