package com.tencent.android.tpush.d.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class f extends c {

    /* renamed from: a  reason: collision with root package name */
    public StringBuffer f69293a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f69294b;

    /* renamed from: c  reason: collision with root package name */
    private Object f69295c = null;

    /* renamed from: d  reason: collision with root package name */
    private Object f69296d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f69297e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f69298f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f69299g = null;

    /* renamed from: h  reason: collision with root package name */
    private Class<?> f69300h = null;

    public class a implements InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        private Context f69302b;

        public a(Context context) {
            this.f69302b = context;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            if (method.getName().equals("onRegister")) {
                if (objArr != null && objArr.length >= 2) {
                    int intValue = objArr[0].intValue();
                    String str = objArr[1];
                    if (intValue == 0) {
                        TLogger.ii("OtherPushOppoImpl", "OppoPush Register success, registerId:" + str);
                        if (!j.b(str) && !str.equals(f.this.c(this.f69302b))) {
                            String unused = f.this.f69294b = str;
                            SharePrefsUtil.setString(this.f69302b, "oppo_token", f.this.f69294b);
                        }
                        d.a(this.f69302b, "OtherPushOppoImpl", "errCode : " + intValue + " , errMsg : success");
                    } else {
                        TLogger.ww("OtherPushOppoImpl", "OppoPush Register failed, code=" + intValue + ", msg=" + str);
                        Context context = this.f69302b;
                        StringBuffer stringBuffer = f.this.f69293a;
                        stringBuffer.append("errCode : " + intValue + " , errMsg : unknown");
                        SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                    }
                    try {
                        Intent intent = new Intent(Constants.ACTION_FEEDBACK);
                        intent.putExtra(Constants.FEEDBACK_ERROR_CODE, intValue);
                        intent.putExtra(Constants.OTHER_PUSH_TOKEN, str);
                        intent.putExtra(Constants.FEEDBACK_TAG, 1);
                        intent.putExtra(Constants.PUSH_CHANNEL, 105);
                        intent.setPackage(this.f69302b.getPackageName());
                        BroadcastAgent.sendBroadcast(this.f69302b, intent);
                    } catch (Throwable th2) {
                        TLogger.w("OtherPushOppoImpl", "OppoPush Register callback broadcast error: " + th2.getMessage());
                    }
                }
            } else if (method.getName().equals("onUnRegister") && objArr != null && objArr.length >= 1) {
                int intValue2 = objArr[0].intValue();
                if (intValue2 == 0) {
                    TLogger.ii("OtherPushOppoImpl", "OppoPush UnRegister success");
                } else {
                    TLogger.ww("OtherPushOppoImpl", "OppoPush UnRegister failed, code=" + intValue2);
                    Context context2 = this.f69302b;
                    StringBuffer stringBuffer2 = f.this.f69293a;
                    stringBuffer2.append("errCode : " + intValue2 + " , errMsg : unknown");
                    SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
            return method;
        }
    }

    private int b() {
        try {
            return d();
        } catch (Throwable unused) {
            TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS210");
            try {
                return c();
            } catch (Throwable unused2) {
                TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_colorOS");
                this.f69299g = null;
                this.f69300h = null;
                TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: -1");
                return -1;
            }
        }
    }

    private int c() {
        this.f69299g = Class.forName("com.coloros.mcssdk.PushManager");
        this.f69300h = Class.forName("com.coloros.mcssdk.callback.PushCallback");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 1");
        return 1;
    }

    private int d() {
        this.f69299g = Class.forName("com.heytap.mcssdk.PushManager");
        this.f69300h = Class.forName("com.heytap.mcssdk.callback.PushCallback");
        TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 2");
        return 2;
    }

    private int e() {
        this.f69299g = Class.forName("com.heytap.msp.push.HeytapPushManager");
        this.f69300h = Class.forName("com.heytap.msp.push.callback.ICallBackResultService");
        try {
            String str = (String) this.f69299g.getDeclaredMethod("getSDKVersionName", new Class[0]).invoke(this.f69299g, new Object[0]);
            TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: " + str);
            if (str == null || "3.0.0".compareTo(str.toLowerCase()) > 0) {
                return 210;
            }
            return 300;
        } catch (Throwable th2) {
            TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS210:" + th2.getMessage());
            return 210;
        }
    }

    private Object g(Context context) {
        if (this.f69298f == 0) {
            this.f69298f = b();
        }
        int i11 = this.f69298f;
        if (i11 == -1) {
            TLogger.ww("OtherPushOppoImpl", "Missing oppo push sdk");
            return null;
        }
        if (this.f69296d == null) {
            if (i11 == 210 || i11 == 300) {
                this.f69296d = this.f69299g.getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f69299g.getDeclaredMethod(ZendeskBlipsProvider.ACTION_CORE_INIT, new Class[]{Context.class, Boolean.TYPE}).invoke(this.f69299g, new Object[]{context, Boolean.TRUE});
            } else {
                try {
                    this.f69296d = this.f69299g.getDeclaredMethod("getInstance", new Class[0]).invoke(this.f69299g, new Object[0]);
                } catch (InvocationTargetException e11) {
                    Throwable cause = e11.getCause();
                    TLogger.ee("OtherPushOppoImpl", "getImplInstance Error for InvocationTargetException: " + cause.getMessage());
                    StringBuffer stringBuffer = this.f69293a;
                    stringBuffer.append("errCode : -155 , errMsg : " + e11.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                    this.f69296d = null;
                    return this.f69296d;
                } catch (Throwable th2) {
                    TLogger.ee("OtherPushOppoImpl", "getImplInstance Error ", th2);
                    this.f69296d = null;
                    return this.f69296d;
                }
            }
            TLogger.i("OtherPushOppoImpl", "Get oppo pushManager instance:" + this.f69296d);
            return this.f69296d;
        }
        return this.f69296d;
    }

    public String a() {
        return MTPushConstants.Manufacturer.OPPO;
    }

    public int e(Context context) {
        return 6;
    }

    public String f(Context context) {
        return "";
    }

    public void a(Context context) {
        Class<String> cls = String.class;
        this.f69293a = new StringBuffer();
        if (!this.f69297e && Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                NotificationChannel notificationChannel = new NotificationChannel("default_message", "默认通知", 4);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                    this.f69297e = true;
                    TLogger.ii("OtherPushOppoImpl", "create oppo push channle success");
                }
            } catch (Throwable th2) {
                TLogger.ee("OtherPushOppoImpl", "create oppo push channle error: ", th2);
                StringBuffer stringBuffer = this.f69293a;
                stringBuffer.append("errCode : -150 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
        if (j.b(d.f68949e)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppKey");
        } else if (j.b(d.f68950f)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppSecret");
        } else {
            Object g11 = g(context);
            if (g11 != null) {
                try {
                    TLogger.ii("OtherPushOppoImpl", "begin oppo register!" + d.f68949e + " " + d.f68950f);
                    if (this.f69295c == null) {
                        a aVar = new a(context);
                        this.f69295c = Proxy.newProxyInstance(this.f69300h.getClassLoader(), new Class[]{this.f69300h}, aVar);
                    }
                    this.f69299g.getDeclaredMethod(MiPushClient.COMMAND_REGISTER, new Class[]{Context.class, cls, cls, this.f69300h}).invoke(g11, new Object[]{context, d.f68949e, d.f68950f, this.f69295c});
                    TLogger.ii("OtherPushOppoImpl", "registerPush oppo push channel success");
                    if (this.f69298f >= 2 && d.f68951g.booleanValue()) {
                        this.f69299g.getDeclaredMethod("requestNotificationPermission", new Class[0]).invoke(g11, new Object[0]);
                    }
                } catch (Throwable th3) {
                    TLogger.ee("OtherPushOppoImpl", "registerPush Throwable e: " + th3.getMessage());
                    StringBuffer stringBuffer2 = this.f69293a;
                    stringBuffer2.append("errCode : -151 , errMsg : " + th3.getLocalizedMessage());
                    SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                }
            }
        }
    }

    public String c(Context context) {
        if (j.b(this.f69294b)) {
            this.f69294b = SharePrefsUtil.getString(context, "oppo_token", "");
        }
        return this.f69294b;
    }

    public boolean d(Context context) {
        boolean z11;
        if (j.b(d.f68949e) || j.b(d.f68950f)) {
            j.a(context, 6);
        }
        if (j.b(d.f68949e)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null appid");
            return false;
        } else if (j.b(d.f68950f)) {
            TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null miAppkey");
            return false;
        } else {
            Object g11 = g(context);
            if (g11 != null) {
                try {
                    if (this.f69298f == 210) {
                        z11 = ((Boolean) this.f69299g.getDeclaredMethod("isSupportPush", new Class[0]).invoke(g11, new Object[0])).booleanValue();
                    } else {
                        z11 = ((Boolean) this.f69299g.getDeclaredMethod("isSupportPush", new Class[]{Context.class}).invoke(g11, new Object[]{context})).booleanValue();
                    }
                    if (!z11) {
                        TLogger.ee("OtherPushOppoImpl", "OPPO push api isSupportPush() returns false, the device not support for OPPO push!");
                    }
                    return z11;
                } catch (InvocationTargetException e11) {
                    Throwable cause = e11.getCause();
                    TLogger.ee("OtherPushOppoImpl", "isConfig Error for InvocationTargetException: " + cause.getMessage());
                } catch (Throwable th2) {
                    TLogger.ee("OtherPushOppoImpl", "isConfig Error ", th2);
                }
            }
            return false;
        }
    }

    public void b(Context context) {
        if (this.f69293a == null) {
            this.f69293a = new StringBuffer();
        }
        Object g11 = g(context);
        if (g11 != null) {
            try {
                this.f69299g.getDeclaredMethod("unRegister", new Class[0]).invoke(g11, new Object[0]);
                TLogger.ii("OtherPushOppoImpl", "unregisterPush oppo push channel success");
            } catch (Throwable th2) {
                TLogger.ee("OtherPushOppoImpl", "unregisterPush Throwable e: " + th2.getMessage());
                StringBuffer stringBuffer = this.f69293a;
                stringBuffer.append("errCode : -152 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
    }
}
