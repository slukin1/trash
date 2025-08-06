package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;

public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a  reason: collision with root package name */
    private Context f37654a;

    /* renamed from: b  reason: collision with root package name */
    private PushPreferences f37655b;

    /* renamed from: c  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f37656c;

    private HmsInstanceId(Context context) {
        this.f37654a = context.getApplicationContext();
        this.f37655b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f37656c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f37656c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f37656c.setKitSdkVersion(61200300);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (e.e(this.f37654a)) {
                String string = i.a(this.f37654a).getString("subjectId");
                if (TextUtils.isEmpty(string)) {
                    i.a(this.f37654a).saveString("subjectId", str);
                } else if (!string.contains(str)) {
                    i a11 = i.a(this.f37654a);
                    a11.saveString("subjectId", string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                }
            } else {
                i.a(this.f37654a).removeKey("subjectId");
            }
        }
    }

    private void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        l.c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.f37655b.containsKey("aaid")) {
                this.f37655b.removeKey("aaid");
                this.f37655b.removeKey("creationTime");
                if (b.d(this.f37654a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f37654a);
                        return;
                    }
                    DeleteTokenReq a11 = b.a(this.f37654a);
                    a11.setDeleteType(1);
                    a11.setMultiSender(false);
                    a(a11, 1);
                    BaseUtils.deleteAllTokenCache(this.f37654a);
                }
            }
        } catch (ApiException e11) {
            throw e11;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq a11 = b.a(this.f37654a, str, str2);
        a11.setMultiSender(false);
        a(a11, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.b(new a(this.f37654a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.c(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.b();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f37655b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f37655b.getLong("creationTime");
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getId() {
        return b.b(this.f37654a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken((String) null, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq b11 = b.b(this.f37654a, (String) null, str2);
        b11.setAaid(getId());
        b11.setMultiSender(false);
        i.a(this.f37654a).saveString(this.f37654a.getPackageName(), "1");
        return a(b11, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String c11 = b.c(this.f37654a);
            if (TextUtils.isEmpty(c11)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(c11)) {
                deleteToken((String) null, (String) null);
            } else {
                DeleteTokenReq a11 = b.a(this.f37654a, str);
                a11.setMultiSender(true);
                a(a11, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String c11 = b.c(this.f37654a);
            if (TextUtils.isEmpty(c11)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(c11)) {
                return getToken((String) null, (String) null);
            } else {
                TokenReq b11 = b.b(this.f37654a, str);
                b11.setAaid(getId());
                b11.setMultiSender(true);
                return a(b11, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    private String a(TokenReq tokenReq, int i11) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f37654a, tokenReq.getSubjectId(), (String) null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String a11 = h.a(this.f37654a, "push.gettoken");
        try {
            String str = TAG;
            HMSLog.d(str, "getToken req :" + tokenReq.toString());
            g gVar = new g("push.gettoken", tokenReq, this.f37654a, a11);
            gVar.setApiLevel(i11);
            return ((TokenResult) Tasks.a(this.f37656c.doWrite(gVar))).getToken();
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e11.getCause();
                h.a(this.f37654a, "push.gettoken", a11, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f37654a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.gettoken", a11, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a(DeleteTokenReq deleteTokenReq, int i11) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f37654a, subjectId, (String) null);
            return;
        }
        String a11 = h.a(this.f37654a, "push.deletetoken");
        try {
            String b11 = i.a(this.f37654a).b(subjectId);
            if (!deleteTokenReq.isMultiSender() || (!TextUtils.isEmpty(b11) && !b11.equals(i.a(this.f37654a).b((String) null)))) {
                deleteTokenReq.setToken(b11);
                f fVar = new f("push.deletetoken", deleteTokenReq, a11);
                fVar.setApiLevel(i11);
                Tasks.a(this.f37656c.doWrite(fVar));
                i.a(this.f37654a).c(subjectId);
                return;
            }
            i.a(this.f37654a).removeKey(subjectId);
            HMSLog.i(TAG, "The local subject token is null");
        } catch (Exception e11) {
            if (e11.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e11.getCause();
                h.a(this.f37654a, "push.deletetoken", a11, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f37654a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.deletetoken", a11, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f37654a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f37654a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
