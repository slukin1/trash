package com.tencent.android.tpush.d.a;

import android.content.Context;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private String f69265a;

    private String g(Context context) {
        if (j.b(this.f69265a)) {
            this.f69265a = SharePrefsUtil.getString(context, "fcm_token", "");
        }
        return this.f69265a;
    }

    public String a() {
        return "fcm";
    }

    public void a(Context context) {
        Class<OtherPushImpl> cls = OtherPushImpl.class;
        try {
            String str = OtherPushImpl.TPUSH_FCM_TOKEN;
            cls.getMethod("registerPush", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
        } catch (Throwable th2) {
            TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error, are you import otherpush package? " + th2);
        }
    }

    public void b(Context context) {
        Class<OtherPushImpl> cls = OtherPushImpl.class;
        try {
            String str = OtherPushImpl.TPUSH_FCM_TOKEN;
            cls.getMethod("unregisterPush", new Class[]{Context.class}).invoke(cls, new Object[]{context});
        } catch (Throwable th2) {
            TLogger.ee("OtherPushFcmImpl", "unregisterPush FCM Error, are you import otherpush package? " + th2);
        }
    }

    public String c(Context context) {
        String str = "";
        Class<OtherPushImpl> cls = OtherPushImpl.class;
        try {
            String str2 = OtherPushImpl.TPUSH_FCM_TOKEN;
            Object invoke = cls.getMethod("getToken", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            String g11 = g(context);
            if (invoke == null || j.b(invoke.toString())) {
                return g11;
            }
            str = invoke.toString();
            if (!invoke.toString().equals(g11)) {
                this.f69265a = invoke.toString();
                SharePrefsUtil.setString(context, "fcm_token", invoke.toString());
            }
            d.a(context, "OtherPushFcmImpl", "errCode : 0 , errMsg : success");
            return str;
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            TLogger.ee("OtherPushFcmImpl", "getToken Error for InvocationTargetException: " + cause.getMessage());
        } catch (Throwable th2) {
            TLogger.ee("OtherPushFcmImpl", "getToken Error", th2);
        }
    }

    public boolean d(Context context) {
        try {
            return com.tencent.android.tpush.d.a.a(context, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
        } catch (Throwable th2) {
            TLogger.ee("OtherPushFcmImpl", "isConfig :" + th2);
            return false;
        }
    }

    public int e(Context context) {
        return 4;
    }

    public String f(Context context) {
        return "";
    }
}
