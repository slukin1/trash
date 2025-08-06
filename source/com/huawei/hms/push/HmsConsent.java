package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;

public class HmsConsent {

    /* renamed from: a  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f38333a;

    /* renamed from: b  reason: collision with root package name */
    private Context f38334b;

    private HmsConsent(Context context) {
        Preconditions.checkNotNull(context);
        this.f38334b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f38333a = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f38333a = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f38333a.setKitSdkVersion(61200300);
    }

    private Task<Void> a(boolean z11) {
        TaskCompletionSource taskCompletionSource;
        int i11;
        String reportEntry = PushBiUtil.reportEntry(this.f38334b, PushNaming.PUSH_CONSENT);
        try {
            if (d.d(this.f38334b)) {
                EnableConsentReq enableConsentReq = new EnableConsentReq();
                enableConsentReq.setPackageName(this.f38334b.getPackageName());
                enableConsentReq.setEnable(z11);
                return this.f38333a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(enableConsentReq), reportEntry));
            }
            throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
        } catch (ApiException e11) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.c(e11);
            TaskCompletionSource taskCompletionSource3 = taskCompletionSource2;
            i11 = e11.getStatusCode();
            taskCompletionSource = taskCompletionSource3;
            PushBiUtil.reportExit(this.f38334b, PushNaming.PUSH_CONSENT, reportEntry, i11);
            return taskCompletionSource.b();
        } catch (Exception unused) {
            taskCompletionSource = new TaskCompletionSource();
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            taskCompletionSource.c(errorEnum.toApiException());
            i11 = errorEnum.getExternalCode();
            PushBiUtil.reportExit(this.f38334b, PushNaming.PUSH_CONSENT, reportEntry, i11);
            return taskCompletionSource.b();
        }
    }

    public static HmsConsent getInstance(Context context) {
        return new HmsConsent(context);
    }

    public Task<Void> consentOff() {
        return a(false);
    }

    public Task<Void> consentOn() {
        return a(true);
    }
}
