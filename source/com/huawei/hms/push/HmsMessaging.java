package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;

public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f38340c = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private Context f38341a;

    /* renamed from: b  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f38342b;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f38341a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f38342b = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f38342b = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f38342b.setKitSdkVersion(61200300);
    }

    private Task<Void> a(String str, String str2) {
        String reportEntry = PushBiUtil.reportEntry(this.f38341a, PushNaming.SUBSCRIBE);
        if (str == null || !f38340c.matcher(str).matches()) {
            PushBiUtil.reportExit(this.f38341a, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        } else if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "use proxy subscribe.");
            if (TextUtils.equals(str2, "Sub")) {
                return ProxyCenter.getProxy().subscribe(this.f38341a, str, reportEntry);
            }
            return ProxyCenter.getProxy().unsubscribe(this.f38341a, str, reportEntry);
        } else {
            try {
                ErrorEnum a11 = v.a(this.f38341a);
                if (a11 != ErrorEnum.SUCCESS) {
                    throw a11.toApiException();
                } else if (NetWorkUtil.getNetworkType(this.f38341a) != 0) {
                    SubscribeReq subscribeReq = new SubscribeReq(this.f38341a, str2, str);
                    subscribeReq.setToken(BaseUtils.getLocalToken(this.f38341a, (String) null));
                    if (d.b()) {
                        return this.f38342b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                    }
                    return this.f38342b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                } else {
                    HMSLog.e("HmsMessaging", "no network");
                    throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
                }
            } catch (ApiException e11) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.c(e11);
                PushBiUtil.reportExit(this.f38341a, PushNaming.SUBSCRIBE, reportEntry, e11.getStatusCode());
                return taskCompletionSource.b();
            } catch (Exception unused) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
                taskCompletionSource2.c(errorEnum.toApiException());
                PushBiUtil.reportExit(this.f38341a, PushNaming.SUBSCRIBE, reportEntry, errorEnum);
                return taskCompletionSource2.b();
            }
        }
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f38341a);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() == null) {
            HMSLog.i("HmsMessaging", "send upstream message");
            a(remoteMessage);
            return;
        }
        HMSLog.e("HmsMessaging", "Operation(send) unsupported");
        throw new UnsupportedOperationException("Operation(send) unsupported");
    }

    public void setAutoInitEnabled(boolean z11) {
        AutoInitHelper.setAutoInitEnabled(this.f38341a, z11);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f38341a, (String) null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f38341a, (String) null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(str, "UnSub");
    }

    private void a(RemoteMessage remoteMessage) {
        String reportEntry = PushBiUtil.reportEntry(this.f38341a, PushNaming.UPSEND_MSG);
        ErrorEnum a11 = v.a(this.f38341a);
        if (a11 != ErrorEnum.SUCCESS) {
            HMSLog.e("HmsMessaging", "Message sent failed:" + a11.getExternalCode() + ':' + a11.getMessage());
            PushBiUtil.reportExit(this.f38341a, PushNaming.UPSEND_MSG, reportEntry, a11);
            throw new UnsupportedOperationException(a11.getMessage());
        } else if (TextUtils.isEmpty(remoteMessage.getTo())) {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f38341a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        } else if (TextUtils.isEmpty(remoteMessage.getMessageId())) {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
            PushBiUtil.reportExit(this.f38341a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
        } else if (!TextUtils.isEmpty(remoteMessage.getData())) {
            UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
            upSendMsgReq.setPackageName(this.f38341a.getPackageName());
            upSendMsgReq.setMessageId(remoteMessage.getMessageId());
            upSendMsgReq.setTo(remoteMessage.getTo());
            upSendMsgReq.setData(remoteMessage.getData());
            upSendMsgReq.setMessageType(remoteMessage.getMessageType());
            upSendMsgReq.setTtl(remoteMessage.getTtl());
            upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
            upSendMsgReq.setSendMode(remoteMessage.getSendMode());
            upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
            if (d.b()) {
                this.f38342b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
            } else {
                a(upSendMsgReq, reportEntry);
            }
        } else {
            HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
            PushBiUtil.reportExit(this.f38341a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'data' missing");
        }
    }

    private Task<Void> a(boolean z11) {
        String reportEntry = PushBiUtil.reportEntry(this.f38341a, PushNaming.SET_NOTIFY_FLAG);
        if (!d.d(this.f38341a) || d.b()) {
            HMSLog.i("HmsMessaging", "turn on/off with AIDL");
            EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
            enableNotifyReq.setPackageName(this.f38341a.getPackageName());
            enableNotifyReq.setEnable(z11);
            return this.f38342b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
        } else if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
            HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ErrorEnum errorEnum = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
            taskCompletionSource.c(errorEnum.toApiException());
            PushBiUtil.reportExit(this.f38341a, PushNaming.SET_NOTIFY_FLAG, reportEntry, errorEnum);
            return taskCompletionSource.b();
        } else if (d.b(this.f38341a) < 90101310) {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
            Context context = this.f38341a;
            Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(context, this.f38341a.getPackageName() + "#" + z11));
            putExtra.setPackage("android");
            return Tasks.b(new IntentCallable(this.f38341a, putExtra, reportEntry));
        } else if (d.b(this.f38341a) < 110118300) {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
            new PushPreferences(this.f38341a, "push_notify_flag").saveBoolean("notify_msg_enable", !z11);
            Uri parse = Uri.parse("content://" + this.f38341a.getPackageName() + ".huawei.push.provider/" + "push_notify_flag" + ".xml");
            Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
            intent.putExtra("type", "enalbeFlag");
            intent.putExtra("pkgName", this.f38341a.getPackageName());
            intent.putExtra("url", parse);
            intent.setPackage("android");
            return Tasks.b(new IntentCallable(this.f38341a, intent, reportEntry));
        } else {
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v3");
            if (TextUtils.isEmpty(BaseUtils.getLocalToken(this.f38341a, (String) null))) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.c(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                return taskCompletionSource2.b();
            }
            new PushPreferences(this.f38341a, "push_notify_flag").saveBoolean("notify_msg_enable", !z11);
            Intent intent2 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
            intent2.putExtra("enalbeFlag", z11);
            intent2.putExtra(RemoteMessageConst.DEVICE_TOKEN, BaseUtils.getLocalToken(this.f38341a, (String) null));
            intent2.putExtra("pkgName", this.f38341a.getPackageName());
            intent2.putExtra("uid", this.f38341a.getApplicationInfo().uid);
            intent2.setPackage("android");
            return Tasks.b(new IntentCallable(this.f38341a, intent2, reportEntry));
        }
    }

    private void a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f38341a, (String) null));
        try {
            this.f38342b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f38341a, PushNaming.UPSEND_MSG, str, ((ApiException) e11.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f38341a, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
