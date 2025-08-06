package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
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
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import hg.a;

public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final String f38343c = "HmsProfile";

    /* renamed from: a  reason: collision with root package name */
    private Context f38344a = null;

    /* renamed from: b  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f38345b;

    private HmsProfile(Context context) {
        Preconditions.checkNotNull(context);
        this.f38344a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f38345b = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f38345b = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f38345b.setKitSdkVersion(61200300);
    }

    private Task<Void> a(int i11, String str, int i12, String str2) {
        if (!isSupportProfile()) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.c(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return taskCompletionSource.b();
        }
        if (!TextUtils.isEmpty(str)) {
            String a11 = a(this.f38344a);
            if (TextUtils.isEmpty(a11)) {
                HMSLog.i(f38343c, "agc connect services config missing project id.");
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.c(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return taskCompletionSource2.b();
            } else if (str.equals(a11)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i11 == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i12);
        } else {
            profileReq.setOperation(1);
        }
        String reportEntry = PushBiUtil.reportEntry(this.f38344a, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(a.b(str2));
            profileReq.setPkgName(this.f38344a.getPackageName());
            return this.f38345b.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), reportEntry));
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                TaskCompletionSource taskCompletionSource3 = new TaskCompletionSource();
                ApiException apiException = (ApiException) e11.getCause();
                taskCompletionSource3.c(apiException);
                PushBiUtil.reportExit(this.f38344a, PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
                return taskCompletionSource3.b();
            }
            TaskCompletionSource taskCompletionSource4 = new TaskCompletionSource();
            Context context = this.f38344a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit(context, PushNaming.PUSH_PROFILE, reportEntry, errorEnum);
            taskCompletionSource4.c(errorEnum.toApiException());
            return taskCompletionSource4.b();
        }
    }

    private boolean b(Context context) {
        return d.b(context) >= 110001400;
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    public Task<Void> addProfile(int i11, String str) {
        return addProfile("", i11, str);
    }

    public Task<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (!d.d(this.f38344a)) {
            return true;
        }
        if (d.c()) {
            HMSLog.i(f38343c, "current EMUI version below 9.1, not support profile operation.");
            return false;
        } else if (b(this.f38344a)) {
            return true;
        } else {
            HMSLog.i(f38343c, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
            return false;
        }
    }

    public Task<Void> addProfile(String str, int i11, String str2) {
        if (i11 != 1 && i11 != 2) {
            HMSLog.i(f38343c, "add profile type undefined.");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource.b();
        } else if (!TextUtils.isEmpty(str2)) {
            return a(0, str, i11, str2);
        } else {
            HMSLog.i(f38343c, "add profile params is empty.");
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource2.b();
        }
    }

    public Task<Void> deleteProfile(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return a(1, str, -1, str2);
        }
        HMSLog.e(f38343c, "del profile params is empty.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.c(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource.b();
    }

    private static String a(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }
}
