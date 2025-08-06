package com.huawei.hms.push;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.push.task.SubscribeNotificationTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;
import org.json.JSONArray;

public class NotificationSubscription {
    public static final int NOTIFICATION_SUBSCRIBE_REQUEST_CODE = 1001;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38346d = "NotificationSubscription";

    /* renamed from: a  reason: collision with root package name */
    private Activity f38347a;

    /* renamed from: b  reason: collision with root package name */
    private Context f38348b;

    /* renamed from: c  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f38349c;

    private NotificationSubscription(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f38348b = activity.getApplicationContext();
        this.f38347a = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(activity, new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), null, (AbstractClientBuilder) new PushClientBuilder());
        this.f38349c = huaweiApi;
        huaweiApi.setKitSdkVersion(61200300);
    }

    private Task<SubscribeResult> a(List<String> list) {
        String reportEntry = PushBiUtil.reportEntry(this.f38348b, PushNaming.SUBSCRIBE_NOTIFICATION);
        if (list == null || list.isEmpty() || list.size() > 3) {
            Context context = this.f38348b;
            ErrorEnum errorEnum = ErrorEnum.ERROR_ARGUMENTS_INVALID;
            PushBiUtil.reportExit(context, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum);
            HMSLog.e(f38346d, "Invalid entityIds: entityId list should not be empty or more than max size");
            return a((Exception) errorEnum.toApiException());
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            Context context2 = this.f38348b;
            ErrorEnum errorEnum2 = ErrorEnum.ERROR_MAIN_THREAD;
            PushBiUtil.reportExit(context2, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum2);
            return a((Exception) errorEnum2.toApiException());
        } else if (!((NotificationManager) this.f38348b.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled()) {
            HMSLog.i(f38346d, "App disabled notification");
            Context context3 = this.f38348b;
            ErrorEnum errorEnum3 = ErrorEnum.ERROR_NOTIFICATION_DISABLED;
            PushBiUtil.reportExit(context3, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum3);
            return a((Exception) errorEnum3.toApiException());
        } else {
            try {
                if (v.a(this.f38348b) != ErrorEnum.SUCCESS) {
                    return a((Exception) ErrorEnum.ERROR_NO_TOKEN.toApiException());
                }
                if (-1 == this.f38348b.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f38348b.getPackageName()) || g.a(this.f38348b) != -1) {
                    Task<TResult> doWrite = this.f38349c.doWrite(new SubscribeNotificationTask(this.f38347a, PushNaming.SUBSCRIBE_NOTIFICATION, b(list), reportEntry));
                    Tasks.a(doWrite);
                    return doWrite;
                }
                HMSLog.e(f38346d, "no network");
                return a((Exception) ErrorEnum.ERROR_NO_NETWORK.toApiException());
            } catch (Exception e11) {
                if (e11.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e11.getCause();
                    PushBiUtil.reportExit(this.f38348b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, apiException.getStatusCode());
                    return a((Exception) apiException);
                }
                Context context4 = this.f38348b;
                ErrorEnum errorEnum4 = ErrorEnum.ERROR_INTERNAL_ERROR;
                PushBiUtil.reportExit(context4, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, errorEnum4);
                return a((Exception) errorEnum4.toApiException());
            }
        }
    }

    private SubscribeNotificationReq b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        SubscribeNotificationReq subscribeNotificationReq = new SubscribeNotificationReq();
        subscribeNotificationReq.setEntityIds(jSONArray.toString());
        subscribeNotificationReq.setToken(BaseUtils.getLocalToken(this.f38348b, (String) null));
        return subscribeNotificationReq;
    }

    public static NotificationSubscription getInstance(Activity activity) {
        return new NotificationSubscription(activity);
    }

    public static SubscribeResult getSubscribeResult(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("errorMsg");
            if (!TextUtils.isEmpty(stringExtra)) {
                SubscribeResult subscribeResult = new SubscribeResult();
                subscribeResult.setErrorMsg(stringExtra);
                String str = f38346d;
                HMSLog.e(str, "get subscribe error msg:" + stringExtra);
                return subscribeResult;
            }
            String stringExtra2 = intent.getStringExtra("subscribedItems");
            if (!TextUtils.isEmpty(stringExtra2)) {
                List<SubscribedItem> a11 = b.a(stringExtra2);
                SubscribeResult subscribeResult2 = new SubscribeResult();
                subscribeResult2.setSubscribedItems(a11);
                return subscribeResult2;
            }
            return null;
        } catch (Throwable unused) {
            HMSLog.e(f38346d, "get subscribe result occurs exception");
        }
    }

    public Task<SubscribeResult> requestSubscribeNotification(List<String> list) {
        HMSLog.i(f38346d, "invoke request subscribe notification");
        return a(list);
    }

    private Task<SubscribeResult> a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.c(exc);
        return taskCompletionSource.b();
    }
}
