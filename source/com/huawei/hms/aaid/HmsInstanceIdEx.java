package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

@Deprecated
public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";

    /* renamed from: a  reason: collision with root package name */
    private Context f37657a;

    /* renamed from: b  reason: collision with root package name */
    private PushPreferences f37658b = null;

    /* renamed from: c  reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f37659c;

    private HmsInstanceIdEx(Context context) {
        this.f37657a = context;
        this.f37658b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f37659c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f37659c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f37659c.setKitSdkVersion(61200300);
    }

    private String a(String str) {
        return "creationTime" + str;
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    public void deleteAAID(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f37658b.containsKey(str)) {
                    this.f37658b.removeKey(str);
                    this.f37658b.removeKey(a(str));
                }
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getAAId(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f37658b.containsKey(str)) {
                    return this.f37658b.getString(str);
                }
                String uuid = UUID.randomUUID().toString();
                this.f37658b.saveString(str, uuid);
                this.f37658b.saveLong(a(str), Long.valueOf(System.currentTimeMillis()));
                return uuid;
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public long getCreationTime(String str) throws ApiException {
        if (str != null) {
            try {
                if (!this.f37658b.containsKey(a(str))) {
                    getAAId(str);
                }
                return this.f37658b.getLong(a(str));
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getProxy() != null) {
            try {
                HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.f37657a, (String) null, (String) null);
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.d(new TokenResult());
                return taskCompletionSource.b();
            } catch (ApiException e11) {
                return a((Exception) e11);
            } catch (Exception unused) {
                return a((Exception) ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        } else {
            String a11 = h.a(this.f37657a, "push.gettoken");
            try {
                TokenReq b11 = b.b(this.f37657a, (String) null, (String) null);
                b11.setAaid(HmsInstanceId.getInstance(this.f37657a).getId());
                return this.f37659c.doWrite(new g("push.gettoken", b11, this.f37657a, a11));
            } catch (RuntimeException unused2) {
                Context context = this.f37657a;
                ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
                h.a(context, "push.gettoken", a11, errorEnum);
                return a((Exception) errorEnum.toApiException());
            } catch (Exception unused3) {
                Context context2 = this.f37657a;
                ErrorEnum errorEnum2 = ErrorEnum.ERROR_INTERNAL_ERROR;
                h.a(context2, "push.gettoken", a11, errorEnum2);
                return a((Exception) errorEnum2.toApiException());
            }
        }
    }

    private Task<TokenResult> a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.c(exc);
        return taskCompletionSource.b();
    }
}
