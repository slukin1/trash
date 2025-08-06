package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private static int f69266a = 6;

    /* renamed from: b  reason: collision with root package name */
    private static int f69267b = 7;

    /* renamed from: d  reason: collision with root package name */
    private static int f69268d;

    /* renamed from: e  reason: collision with root package name */
    private static Class<?> f69269e;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f69270c;

    /* renamed from: f  reason: collision with root package name */
    private Object f69271f;

    /* renamed from: g  reason: collision with root package name */
    private Object f69272g;

    public class a implements InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        private Context f69274b;

        public a(Context context) {
            this.f69274b = context;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onSuccess")) {
                if (objArr != null && objArr.length >= 1) {
                    String str = objArr[0];
                    if (!TextUtils.isEmpty(str)) {
                        TLogger.ii("OtherPushHonorImpl", "HonorPush Register success, token: " + str);
                        if (!j.b(str) && !str.equals(b.this.c(this.f69274b))) {
                            String unused = b.this.f69270c = str;
                            SharePrefsUtil.setString(this.f69274b, "honor_token", b.this.f69270c);
                        }
                        b.this.a(str);
                        d.a(this.f69274b, "OtherPushHonorImpl", "errCode: 0, errMsg: success");
                    } else {
                        TLogger.ww("OtherPushHonorImpl", "HonorPush Register failed, empty token");
                        SharePrefsUtil.setString(this.f69274b, Constants.OTHER_PUSH_ERROR_CODE, "HonorPush Register failed, errMsg : empty token");
                    }
                }
            } else if (method.getName().equals("onFailure") && objArr != null && objArr.length >= 2) {
                int intValue = objArr[0].intValue();
                String str2 = objArr[1];
                TLogger.ww("OtherPushHonorImpl", "HonorPush Register failed, errCode: " + intValue + ", errMeg: " + str2);
                Context context = this.f69274b;
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, "errCode: " + intValue + ", errMeg: " + str2);
            }
            return method;
        }
    }

    /* renamed from: com.tencent.android.tpush.d.a.b$b  reason: collision with other inner class name */
    public class C0748b implements InvocationHandler {
        private C0748b() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onSuccess")) {
                TLogger.ii("OtherPushHonorImpl", "HonorPush Unregister success");
            } else if (method.getName().equals("onFailure") && objArr != null && objArr.length >= 2) {
                int intValue = objArr[0].intValue();
                TLogger.ww("OtherPushHonorImpl", "HonorPush Unregister failed, errCode: " + intValue + ", errMeg: " + objArr[1]);
            }
            return method;
        }
    }

    public String a() {
        return MTPushConstants.Manufacturer.HONOR;
    }

    public String c(Context context) {
        if (j.b(this.f69270c)) {
            this.f69270c = SharePrefsUtil.getString(context, "honor_token", "");
        }
        return this.f69270c;
    }

    public boolean d(Context context) {
        if (f69268d == 0) {
            b();
        }
        int i11 = f69268d;
        if (i11 == f69267b) {
            try {
                Object invoke = f69269e.getDeclaredMethod("getInstance", new Class[0]).invoke(f69269e, new Object[0]);
                Object invoke2 = f69269e.getDeclaredMethod("checkSupportHonorPush", new Class[]{Context.class}).invoke(invoke, new Object[]{context});
                if (invoke2 != null) {
                    return ((Boolean) invoke2).booleanValue();
                }
                return false;
            } catch (Throwable th2) {
                TLogger.ww("OtherPushHonorImpl", "isConfig honor push error: " + th2);
            }
        } else {
            if (i11 == f69266a) {
                try {
                    Class<?> cls = Class.forName("com.hihonor.push.sdk.ipc.HonorApiAvailability");
                    Object invoke3 = cls.getDeclaredMethod("isHonorMobileServicesAvailable", new Class[]{Context.class}).invoke(cls, new Object[]{context});
                    if (invoke3 != null) {
                        int intValue = ((Integer) invoke3).intValue();
                        if (intValue == 0) {
                            return true;
                        }
                        TLogger.ee("OtherPushHonorImpl", "isConfig honor push isHonorMobileServicesAvailable = " + intValue + ", not support!");
                        return false;
                    }
                } catch (Throwable th3) {
                    TLogger.ww("OtherPushHonorImpl", "isConfig honor push error: " + th3.toString());
                }
            } else {
                TLogger.ee("OtherPushHonorImpl", "Missing Honor Push SDK");
            }
            return false;
        }
    }

    public int e(Context context) {
        return 9;
    }

    public String f(Context context) {
        return "";
    }

    public static int b() {
        try {
            f69269e = Class.forName("com.hihonor.push.sdk.HonorPushClient");
            f69268d = f69267b;
            TLogger.i("OtherPushHonorImpl", "checkHonorSDK v7");
            return f69268d;
        } catch (ClassNotFoundException unused) {
            TLogger.ww("OtherPushHonorImpl", "unexpected for checkHonorSdk V7");
            try {
                f69269e = Class.forName("com.hihonor.push.sdk.HonorInstanceId");
                f69268d = f69266a;
                TLogger.i("OtherPushHonorImpl", "checkHonorSDK v6");
                return f69268d;
            } catch (ClassNotFoundException unused2) {
                TLogger.ww("OtherPushHonorImpl", "unexpected for checkHonorSdk V6");
                f69268d = -1;
                return -1;
            }
        }
    }

    public void a(Context context) {
        if (f69268d == 0) {
            b();
        }
        TLogger.i("OtherPushHonorImpl", "other push honor registerPush");
        int i11 = f69268d;
        if (i11 == f69267b) {
            try {
                Object invoke = f69269e.getDeclaredMethod("getInstance", new Class[0]).invoke(f69269e, new Object[0]);
                f69269e.getDeclaredMethod(ZendeskBlipsProvider.ACTION_CORE_INIT, new Class[]{Context.class, Boolean.TYPE}).invoke(invoke, new Object[]{context, Boolean.FALSE});
                Class<?> cls = Class.forName("com.hihonor.push.sdk.HonorPushCallback");
                if (this.f69271f == null) {
                    a aVar = new a(context);
                    this.f69271f = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, aVar);
                }
                f69269e.getDeclaredMethod("getPushToken", new Class[]{cls}).invoke(invoke, new Object[]{this.f69271f});
            } catch (Throwable th2) {
                TLogger.ww("OtherPushHonorImpl", "register honor push error: " + th2, th2);
            }
        } else if (i11 == f69266a) {
            try {
                Object invoke2 = f69269e.getDeclaredMethod("getPushToken", new Class[0]).invoke(f69269e.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(f69269e, new Object[]{context}), new Object[0]);
                if (invoke2 == null || TextUtils.isEmpty(invoke2.toString())) {
                    TLogger.ww("OtherPushHonorImpl", "Get Honor token null or empty");
                    return;
                }
                TLogger.i("OtherPushHonorImpl", "Get Honor token: " + invoke2.toString());
                if (!invoke2.toString().equals(c(context))) {
                    String obj = invoke2.toString();
                    this.f69270c = obj;
                    SharePrefsUtil.setString(context, "honor_token", obj);
                }
                a(invoke2.toString());
                d.a(context, "OtherPushHonorImpl", "errCode : 0 , errMsg : success");
            } catch (Throwable th3) {
                TLogger.ww("OtherPushHonorImpl", "register honor push error: " + th3.toString(), th3);
            }
        } else {
            TLogger.ee("OtherPushHonorImpl", "Missing Honor Push SDK");
        }
    }

    public void b(Context context) {
        if (f69268d == 0) {
            b();
        }
        TLogger.i("OtherPushHonorImpl", "other push honor unregisterPush");
        int i11 = f69268d;
        if (i11 == f69267b) {
            try {
                Object invoke = f69269e.getDeclaredMethod("getInstance", new Class[0]).invoke(f69269e, new Object[0]);
                f69269e.getDeclaredMethod(ZendeskBlipsProvider.ACTION_CORE_INIT, new Class[]{Context.class, Boolean.TYPE}).invoke(invoke, new Object[]{context, Boolean.FALSE});
                Class<?> cls = Class.forName("com.hihonor.push.sdk.HonorPushCallback");
                if (this.f69272g == null) {
                    C0748b bVar = new C0748b();
                    this.f69272g = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
                }
                f69269e.getDeclaredMethod("deletePushToken", new Class[]{cls}).invoke(invoke, new Object[]{this.f69272g});
            } catch (Throwable th2) {
                TLogger.ww("OtherPushHonorImpl", "unregister honor push error: " + th2, th2);
            }
        } else if (i11 == f69266a) {
            try {
                f69269e.getDeclaredMethod("deletePushToken", new Class[0]).invoke(f69269e.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(f69269e, new Object[]{context}), new Object[0]);
            } catch (Throwable th3) {
                TLogger.ww("OtherPushHonorImpl", "unregister honor push error: " + th3.toString());
            }
        } else {
            TLogger.ee("OtherPushHonorImpl", "Missing Honor Push SDK");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            if (XGPushManager.getContext() != null) {
                Intent intent = new Intent(Constants.ACTION_FEEDBACK);
                intent.putExtra(Constants.FEEDBACK_ERROR_CODE, str != null ? 0 : -1);
                intent.putExtra(Constants.OTHER_PUSH_TOKEN, str);
                intent.putExtra(Constants.FEEDBACK_TAG, 1);
                intent.putExtra(Constants.PUSH_CHANNEL, 107);
                intent.setPackage(XGPushManager.getContext().getPackageName());
                intent.putExtra(Constants.FEEDBACK_TOKEN_KEY, "honor_token");
                intent.putExtra(Constants.FEEDBACK_NOT_UPDATE_TOKEN_KEY, 1);
                XGPushManager.onOtherPushRegister(XGPushManager.getContext(), intent);
            }
        } catch (Throwable unused) {
        }
    }
}
