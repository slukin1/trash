package com.huawei.hms.push.task;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.r;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public class SendUpStreamTask extends TaskApiCall<PushClient, BaseVoidTask> {

    /* renamed from: a  reason: collision with root package name */
    private String f38442a;

    /* renamed from: b  reason: collision with root package name */
    private String f38443b;

    public SendUpStreamTask(String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3);
        this.f38442a = str4;
        this.f38443b = str5;
    }

    private void a(PushClient pushClient, ResponseErrorCode responseErrorCode) {
        HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.f38443b + " , packageName = " + this.f38442a + " , errorCode = " + responseErrorCode.getErrorCode());
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.f38442a);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, this.f38443b);
        bundle.putInt("error", responseErrorCode.getErrorCode());
        if (ErrorEnum.SUCCESS.getInternalCode() == responseErrorCode.getErrorCode()) {
            bundle.putString("message_type", "sent_message");
        } else {
            bundle.putString("message_type", Constants.MessageTypes.SEND_ERROR);
        }
        if (new r().a(pushClient.getContext(), bundle, intent)) {
            HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
            PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
            return;
        }
        HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
        PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode.getTransactionId(), ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
    }

    public int getMinApkVersion() {
        return 40003000;
    }

    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<BaseVoidTask> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
            taskCompletionSource.d(null);
        } else {
            HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + responseErrorCode.getErrorCode());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.c(fromCode.toApiException());
            } else {
                taskCompletionSource.c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        a(pushClient, responseErrorCode);
    }
}
