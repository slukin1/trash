package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.content.Intent;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class d extends c {

    /* renamed from: c  reason: collision with root package name */
    private static long f69287c;

    /* renamed from: a  reason: collision with root package name */
    public String f69288a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuffer f69289b;

    private String g(Context context) {
        if (j.b(this.f69288a)) {
            this.f69288a = SharePrefsUtil.getString(context, "meizu_token", "");
        }
        return this.f69288a;
    }

    public String a() {
        return MTPushConstants.Manufacturer.MEIZU;
    }

    public void a(Context context) {
        Class<String> cls = String.class;
        if (j.b(com.tencent.android.tpush.d.d.f68947c)) {
            TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null appid");
        } else if (j.b(com.tencent.android.tpush.d.d.f68948d)) {
            TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null mzAppkey");
        } else {
            this.f69289b = new StringBuffer();
            if (Util.isMainProcess(context)) {
                TLogger.ii("OtherPushMZImpl", "begin Mzpush register!" + com.tencent.android.tpush.d.d.f68947c + " " + com.tencent.android.tpush.d.d.f68948d);
                try {
                    Class<?> cls2 = Class.forName("com.meizu.cloud.pushsdk.PushManager");
                    cls2.getMethod(MiPushClient.COMMAND_REGISTER, new Class[]{Context.class, cls, cls}).invoke(cls2, new Object[]{context, com.tencent.android.tpush.d.d.f68947c, com.tencent.android.tpush.d.d.f68948d});
                    TLogger.ii("OtherPushMZImpl", "creat meizu push channle success");
                } catch (InvocationTargetException e11) {
                    Throwable cause = e11.getCause();
                    TLogger.ee("OtherPushMZImpl", "meizu registerPush Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.f69289b;
                    stringBuffer.append("errCode : -160 , errMsg : " + e11.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                } catch (Throwable th2) {
                    TLogger.ee("OtherPushMZImpl", "meizu registerPush Error ", th2);
                    StringBuffer stringBuffer2 = this.f69289b;
                    stringBuffer2.append("errCode : -161 , errMsg : " + th2.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
        }
    }

    public void b(Context context) {
        Class<String> cls = String.class;
        if (this.f69289b == null) {
            this.f69289b = new StringBuffer();
        }
        try {
            Class<?> cls2 = Class.forName("com.meizu.cloud.pushsdk.PushManager");
            Method method = cls2.getMethod("unRegister", new Class[]{Context.class, cls, cls});
            TLogger.i("OtherPushMZImpl", "begin Mzpush unregister!" + com.tencent.android.tpush.d.d.f68947c + " " + com.tencent.android.tpush.d.d.f68948d);
            method.invoke(cls2, new Object[]{context, com.tencent.android.tpush.d.d.f68947c, com.tencent.android.tpush.d.d.f68948d});
            TLogger.ii("OtherPushMZImpl", "unregisterPush meizu push channle success");
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.f69289b;
            stringBuffer.append("errCode : -162 , errMsg : " + e11.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
        } catch (Throwable th2) {
            TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error, are you import otherpush package? " + th2);
            StringBuffer stringBuffer2 = this.f69289b;
            stringBuffer2.append("errCode : -163 , errMsg : " + th2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }

    public String c(Context context) {
        String str = "";
        if (j.b(com.tencent.android.tpush.d.d.f68947c)) {
            TLogger.ee("OtherPushMZImpl", "getToken Error for mz null appid");
            return str;
        } else if (j.b(com.tencent.android.tpush.d.d.f68948d)) {
            TLogger.ee("OtherPushMZImpl", "getToken Error for mz null mzAppkey");
            return str;
        } else {
            if (this.f69289b == null) {
                this.f69289b = new StringBuffer();
            }
            try {
                Class<?> cls = Class.forName("com.meizu.cloud.pushsdk.PushManager");
                Object invoke = cls.getMethod("getPushId", new Class[]{Context.class}).invoke(cls, new Object[]{context});
                String g11 = g(context);
                if (invoke == null || j.b(invoke.toString()) || invoke.toString().equals(g11)) {
                    str = g11;
                } else {
                    this.f69288a = invoke.toString();
                    SharePrefsUtil.setString(context, "meizu_token", invoke.toString());
                    str = this.f69288a;
                }
                if (invoke != null && !j.b(invoke.toString())) {
                    a(invoke.toString());
                }
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                TLogger.ee("OtherPushMZImpl", "meizu getToken Error for InvocationTargetException: " + cause.getMessage());
                StringBuffer stringBuffer = this.f69289b;
                stringBuffer.append("errCode : -164 , errMsg : " + e11.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            } catch (Throwable th2) {
                TLogger.ee("OtherPushMZImpl", "meizu getToken Error", th2);
                StringBuffer stringBuffer2 = this.f69289b;
                stringBuffer2.append("errCode : -165 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            }
            return str;
        }
    }

    public boolean d(Context context) {
        if (j.b(com.tencent.android.tpush.d.d.f68947c) || j.b(com.tencent.android.tpush.d.d.f68948d)) {
            j.a(context, 2);
        }
        if (j.b(com.tencent.android.tpush.d.d.f68947c) || j.b(com.tencent.android.tpush.d.d.f68948d)) {
            j.l(context);
        }
        if (!j.b(com.tencent.android.tpush.d.d.f68947c) && !j.b(com.tencent.android.tpush.d.d.f68948d)) {
            return true;
        }
        return false;
    }

    public int e(Context context) {
        return 2;
    }

    public String f(Context context) {
        return "";
    }

    private void a(String str) {
        try {
            if (XGPushManager.getContext() != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f69287c > 5000) {
                    f69287c = currentTimeMillis;
                    Intent intent = new Intent(Constants.ACTION_FEEDBACK);
                    intent.putExtra(Constants.FEEDBACK_ERROR_CODE, str != null ? 200 : -1);
                    intent.putExtra(Constants.OTHER_PUSH_TOKEN, str);
                    intent.putExtra(Constants.FEEDBACK_TAG, 1);
                    intent.putExtra(Constants.PUSH_CHANNEL, 106);
                    intent.setPackage(XGPushManager.getContext().getPackageName());
                    intent.putExtra(Constants.FEEDBACK_TOKEN_KEY, "meizu_token");
                    intent.putExtra(Constants.FEEDBACK_NOT_UPDATE_TOKEN_KEY, 1);
                    XGPushManager.onOtherPushRegister(XGPushManager.getContext(), intent);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
