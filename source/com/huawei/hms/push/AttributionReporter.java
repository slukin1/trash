package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.AttributionReportTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.AttributionReportReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.hms.utils.JsonUtil;

public class AttributionReporter {
    public static final String APP_VERSION = "appVersion";
    public static final String SYSTEM_PERMISSION = "permission";

    /* renamed from: a  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f38329a;

    /* renamed from: b  reason: collision with root package name */
    private Context f38330b;

    private AttributionReporter(Context context) {
        Preconditions.checkNotNull(context);
        this.f38330b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f38329a = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f38329a = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f38329a.setKitSdkVersion(61200300);
    }

    private Task<Void> a(AttributionEvent attributionEvent, Bundle bundle) {
        int i11;
        TaskCompletionSource taskCompletionSource;
        String reportEntry = PushBiUtil.reportEntry(this.f38330b, PushNaming.PUSH_ANALYSIS_REPORT);
        if (bundle == null || attributionEvent == null) {
            PushBiUtil.reportExit(this.f38330b, PushNaming.PUSH_ANALYSIS_REPORT, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.e("AttributionReporter", "Invalid argument: argument should not be null");
            throw new IllegalArgumentException("Invalid argument: argument should not be null");
        }
        try {
            if (d.d(this.f38330b)) {
                long j11 = new PushPreferences(this.f38330b, "hwpush_local_config").getLong("analysis_last_failed_time");
                if (j11 > 0) {
                    if (System.currentTimeMillis() - j11 < Period.DAY_MILLS) {
                        throw ErrorEnum.ERROR_NOT_IN_SERVICE.toApiException();
                    }
                }
                return this.f38329a.doWrite(new AttributionReportTask(PushNaming.PUSH_ANALYSIS_REPORT, JsonUtil.createJsonString(a(attributionEvent, new SafeBundle(bundle))), reportEntry));
            }
            throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
        } catch (ApiException e11) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.c(e11);
            TaskCompletionSource taskCompletionSource3 = taskCompletionSource2;
            i11 = e11.getStatusCode();
            taskCompletionSource = taskCompletionSource3;
            PushBiUtil.reportExit(this.f38330b, PushNaming.PUSH_ANALYSIS_REPORT, reportEntry, i11);
            return taskCompletionSource.b();
        } catch (Exception unused) {
            taskCompletionSource = new TaskCompletionSource();
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            taskCompletionSource.c(errorEnum.toApiException());
            i11 = errorEnum.getExternalCode();
            PushBiUtil.reportExit(this.f38330b, PushNaming.PUSH_ANALYSIS_REPORT, reportEntry, i11);
            return taskCompletionSource.b();
        }
    }

    public static AttributionReporter getInstance(Context context) {
        return new AttributionReporter(context);
    }

    public Task<Void> report(AttributionEvent attributionEvent, Bundle bundle) {
        return a(attributionEvent, bundle);
    }

    private AttributionReportReq a(AttributionEvent attributionEvent, SafeBundle safeBundle) throws ApiException {
        Bundle bundle = safeBundle.getBundle().getBundle("analysisExt");
        if (bundle == null || bundle.isEmpty()) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String string = bundle.getString("msgId");
        if (!TextUtils.isEmpty(string)) {
            String string2 = bundle.getString("hsId");
            if (!TextUtils.isEmpty(string2)) {
                AttributionReportReq attributionReportReq = new AttributionReportReq();
                attributionReportReq.setCampaignId(bundle.getString("cid"));
                attributionReportReq.setMsgId(string);
                attributionReportReq.setHaStorageId(string2);
                attributionReportReq.setEventId(attributionEvent.getEventId());
                attributionReportReq.setPkgName(this.f38330b.getPackageName());
                if (attributionEvent.equals(AttributionEvent.PERMISSION_GRANTED) || attributionEvent.equals(AttributionEvent.PERMISSION_DENIED)) {
                    String string3 = safeBundle.getString(SYSTEM_PERMISSION);
                    if (TextUtils.isEmpty(string3) || !string3.startsWith("android.permission")) {
                        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
                    }
                    attributionReportReq.setReqPermission(string3);
                }
                attributionReportReq.setTimeStamp(System.currentTimeMillis());
                attributionReportReq.setAppVersion(safeBundle.getString(APP_VERSION));
                return attributionReportReq;
            }
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
