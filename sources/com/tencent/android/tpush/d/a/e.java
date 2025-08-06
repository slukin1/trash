package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e extends c {

    /* renamed from: c  reason: collision with root package name */
    private static long f69290c;

    /* renamed from: a  reason: collision with root package name */
    public String f69291a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuffer f69292b;

    private String g(Context context) {
        if (j.b(this.f69291a)) {
            this.f69291a = SharePrefsUtil.getString(context, "xiaomi_token", "");
        }
        return this.f69291a;
    }

    public String a() {
        return "xiaomi";
    }

    public void a(Context context) {
        Class<String> cls = String.class;
        if (j.b(d.f68945a)) {
            TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null appid");
        } else if (j.b(d.f68946b)) {
            TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null miAppkey");
        } else {
            this.f69292b = new StringBuffer();
            if (Util.isMainProcess(context)) {
                Class<MiPushClient> cls2 = MiPushClient.class;
                try {
                    String str = MiPushClient.COMMAND_REGISTER;
                    Method method = cls2.getMethod("registerPush", new Class[]{Context.class, cls, cls});
                    TLogger.i("OtherPushMiImpl", "begin Mipush register!" + d.f68945a + " " + d.f68946b);
                    method.invoke(cls2, new Object[]{context, d.f68945a, d.f68946b});
                    TLogger.ii("OtherPushMiImpl", "registerPush xm push channle success");
                } catch (InvocationTargetException e11) {
                    Throwable cause = e11.getCause();
                    TLogger.ee("OtherPushMiImpl", "xm registerPush Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.f69292b;
                    stringBuffer.append("errCode : -130 , errMsg : " + e11.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                } catch (Throwable th2) {
                    TLogger.ee("OtherPushMiImpl", "xm registerPush Error ", th2);
                    StringBuffer stringBuffer2 = this.f69292b;
                    stringBuffer2.append("errCode : -131 , errMsg : " + th2.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
        }
    }

    public void b(Context context) {
        if (this.f69292b == null) {
            this.f69292b = new StringBuffer();
        }
        Class<MiPushClient> cls = MiPushClient.class;
        try {
            String str = MiPushClient.COMMAND_REGISTER;
            cls.getMethod("unregisterPush", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            TLogger.ii("OtherPushMiImpl", "unregisterPush xm push channle success");
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            TLogger.ee("OtherPushMiImpl", "unregisterPush Error for InvocationTargetException: " + cause.getMessage());
            StringBuffer stringBuffer = this.f69292b;
            stringBuffer.append("errCode : -132 , errMsg : " + e11.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
        } catch (Throwable th2) {
            TLogger.ee("OtherPushMiImpl", "unregisterPush Error, are you import otherpush package? " + th2);
            StringBuffer stringBuffer2 = this.f69292b;
            stringBuffer2.append("errCode : -133 , errMsg : " + th2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }

    public String c(Context context) {
        String str = "";
        if (j.b(d.f68945a)) {
            TLogger.ee("OtherPushMiImpl", "getToken Error for xiaomi null appid");
            return str;
        } else if (j.b(d.f68946b)) {
            TLogger.ee("OtherPushMiImpl", "getToken Error for xiaomi null miAppkey");
            return str;
        } else {
            if (this.f69292b == null) {
                this.f69292b = new StringBuffer();
            }
            Class<MiPushClient> cls = MiPushClient.class;
            try {
                String str2 = MiPushClient.COMMAND_REGISTER;
                Object invoke = cls.getMethod("getRegId", new Class[]{Context.class}).invoke(cls, new Object[]{context});
                String g11 = g(context);
                if (invoke == null || j.b(invoke.toString()) || invoke.toString().equals(g11)) {
                    str = g11;
                } else {
                    this.f69291a = invoke.toString();
                    SharePrefsUtil.setString(context, "xiaomi_token", invoke.toString());
                    str = this.f69291a;
                }
                if (invoke != null && !j.b(invoke.toString())) {
                    a(invoke.toString());
                }
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                TLogger.ee("OtherPushMiImpl", "xm getToken Error for InvocationTargetException: " + cause.getMessage());
                StringBuffer stringBuffer = this.f69292b;
                stringBuffer.append("errCode : -134 , errMsg : " + e11.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            } catch (Throwable th2) {
                TLogger.ee("OtherPushMiImpl", "xm getToken Error", th2);
                StringBuffer stringBuffer2 = this.f69292b;
                stringBuffer2.append("errCode : -135 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            }
            return str;
        }
    }

    public boolean d(Context context) {
        if (j.b(d.f68945a) || j.b(d.f68946b)) {
            j.a(context, 1);
        }
        if (j.b(d.f68945a) || j.b(d.f68946b)) {
            j.l(context);
        }
        if (!j.b(d.f68945a) && !j.b(d.f68946b)) {
            return true;
        }
        return false;
    }

    public int e(Context context) {
        return 1;
    }

    public String f(Context context) {
        Class<MiPushClient> cls = MiPushClient.class;
        try {
            String str = MiPushClient.COMMAND_REGISTER;
            Object invoke = cls.getMethod("getAppRegion", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            if (invoke == null) {
                return "";
            }
            String obj = invoke.toString();
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
            return "";
        } catch (Throwable th2) {
            TLogger.e("OtherPushMiImpl", "getRegion error: " + th2);
            return "";
        }
    }

    private void a(String str) {
        try {
            if (XGPushManager.getContext() != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f69290c > 3000) {
                    f69290c = currentTimeMillis;
                    Intent intent = new Intent(Constants.ACTION_FEEDBACK);
                    intent.putExtra(Constants.FEEDBACK_ERROR_CODE, str != null ? 0 : -1);
                    intent.putExtra(Constants.OTHER_PUSH_TOKEN, str);
                    intent.putExtra(Constants.FEEDBACK_TAG, 1);
                    intent.putExtra(Constants.PUSH_CHANNEL, 103);
                    intent.setPackage(XGPushManager.getContext().getPackageName());
                    intent.putExtra(Constants.FEEDBACK_TOKEN_KEY, "xiaomi_token");
                    intent.putExtra(Constants.FEEDBACK_NOT_UPDATE_TOKEN_KEY, 1);
                    XGPushManager.onOtherPushRegister(XGPushManager.getContext(), intent);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
