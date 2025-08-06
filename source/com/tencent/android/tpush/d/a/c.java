package com.tencent.android.tpush.d.a;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class c extends com.tencent.android.tpush.d.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f69276a;

    /* renamed from: b  reason: collision with root package name */
    public BroadcastReceiver f69277b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f69278c;

    /* renamed from: d  reason: collision with root package name */
    public StringBuffer f69279d;

    /* renamed from: e  reason: collision with root package name */
    private int f69280e = 0;

    /* renamed from: f  reason: collision with root package name */
    private Class<?> f69281f = null;

    public class a implements InvocationHandler {
        public a() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            TLogger.d("OtherPushHuaWeiImpl", "invoke, method:" + method);
            try {
                if (method.getName().equals("onConnect")) {
                    if (objArr != null && objArr.length > 0) {
                        Integer num = objArr[0];
                        TLogger.i("OtherPushHuaWeiImpl", "other push huawei onConnect code:" + num);
                        if (num.intValue() == 0) {
                            c.this.b();
                        } else {
                            c cVar = c.this;
                            Context context = cVar.f69276a;
                            StringBuffer stringBuffer = cVar.f69279d;
                            stringBuffer.append("errCode : " + num + " ,  errMsg : unkonwn");
                            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                        }
                    }
                    return null;
                }
                if (method.getName().equals("onResult") && objArr != null && objArr.length > 0) {
                    try {
                        Integer num2 = objArr[0];
                        TLogger.i("OtherPushHuaWeiImpl", "other push huawei onResult code:" + num2);
                        num2.intValue();
                    } catch (Throwable th2) {
                        c cVar2 = c.this;
                        Context context2 = cVar2.f69276a;
                        StringBuffer stringBuffer2 = cVar2.f69279d;
                        stringBuffer2.append("errCode : -125 , errMsg :" + th2.getLocalizedMessage());
                        SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
                    }
                }
                return null;
            } catch (Throwable th3) {
                TLogger.e("OtherPushHuaWeiImpl", "onConnectionFailed", th3);
                c cVar3 = c.this;
                Context context3 = cVar3.f69276a;
                StringBuffer stringBuffer3 = cVar3.f69279d;
                stringBuffer3.append("errCode : -126 , errMsg :" + th3.getLocalizedMessage());
                SharePrefsUtil.setString(context3, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer3.toString());
            }
        }
    }

    private int c() {
        Class<HmsInstanceId> cls = HmsInstanceId.class;
        try {
            String str = HmsInstanceId.TAG;
            this.f69281f = cls;
            return 3;
        } catch (Throwable th2) {
            this.f69281f = null;
            Context context = this.f69276a;
            StringBuffer stringBuffer = this.f69279d;
            stringBuffer.append("errCode : -121 , errMsg : " + th2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            return -1;
        }
    }

    private void h(Context context) {
        if (this.f69277b == null) {
            this.f69277b = new BroadcastReceiver() {
                public void onReceive(Context context, final Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    final Context applicationContext = context.getApplicationContext();
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            try {
                                Intent intent = intent;
                                if (intent != null) {
                                    String action = intent.getAction();
                                    if (!j.b(action)) {
                                        TLogger.i("OtherPushHuaWeiImpl", "Receive broadcast action: " + action);
                                        if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                                            byte[] byteArrayExtra = intent.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                                            if (byteArrayExtra != null) {
                                                String str = new String(byteArrayExtra, "UTF-8");
                                                TLogger.i("OtherPushHuaWeiImpl", "Get token from broadcast: " + str);
                                                if (!j.b(str)) {
                                                    if (!str.equals(c.this.c(applicationContext))) {
                                                        c.this.f69278c = str;
                                                        SharePrefsUtil.setString(applicationContext, "huawei_token", str);
                                                    }
                                                    c.this.a(str);
                                                    d.a(c.this.f69276a, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
                                                }
                                            }
                                        } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                                            TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.android.push.intent.RECEIVE");
                                        } else if ("com.huawei.intent.action.PUSH_STATE".equals(action)) {
                                            TLogger.d("OtherPushHuaWeiImpl", "reciver action com.huawei.intent.action.PUSH_STATEE");
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                TLogger.e("OtherPushHuaWeiImpl", "registerHuaweiRecevier ", th2);
                                Context context = applicationContext;
                                StringBuffer stringBuffer = c.this.f69279d;
                                stringBuffer.append("errCode : -120 , errMsg : " + th2.getLocalizedMessage());
                                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                            }
                        }
                    });
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
                intentFilter.addAction("com.huawei.android.push.intent.RECEIVE");
                intentFilter.addAction("com.huawei.intent.action.PUSH_STATE");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(this.f69277b, intentFilter, 2);
                } else {
                    context.registerReceiver(this.f69277b, intentFilter);
                }
            } catch (Throwable th2) {
                TLogger.e("OtherPushHuaWeiImpl", "registerReceiver error", th2);
                StringBuffer stringBuffer = this.f69279d;
                stringBuffer.append("errCode : -129 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
    }

    public String a() {
        return MTPushConstants.Manufacturer.HUAWEI;
    }

    public void b() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
            Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.push.handler.GetTokenHandler");
            a aVar = new a();
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls2}, aVar);
            cls.getDeclaredMethod("getToken", new Class[]{cls2}).invoke(cls, new Object[]{newProxyInstance});
        } catch (Throwable th2) {
            TLogger.e("OtherPushHuaWeiImpl", "getTokenAsyn error", th2);
            Context context = this.f69276a;
            StringBuffer stringBuffer = this.f69279d;
            stringBuffer.append("errCode : -127 , errMsg :" + th2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
        }
    }

    public boolean d(Context context) {
        return true;
    }

    public int e(Context context) {
        return 5;
    }

    public String f(Context context) {
        return "";
    }

    public String g(Context context) {
        Object invoke;
        if (this.f69280e == 0) {
            this.f69280e = c();
        }
        String str = "";
        if (this.f69280e != 3) {
            return str;
        }
        try {
            if (!TextUtils.isEmpty(d.f68952h)) {
                return d.f68952h;
            }
            Class<AGConnectServicesConfig> cls = AGConnectServicesConfig.class;
            int i11 = AGConnectServicesConfig.f37472i;
            Object invoke2 = cls.getDeclaredMethod("fromContext", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            if (invoke2 == null || (invoke = cls.getDeclaredMethod("getString", new Class[]{String.class}).invoke(invoke2, new Object[]{"client/app_id"})) == null) {
                return str;
            }
            String obj = invoke.toString();
            try {
                d.f68952h = obj;
                return obj;
            } catch (Throwable unused) {
                str = obj;
                TLogger.ww("OtherPushHuaWeiImpl", "Not found AGConnectServicesConfig");
                return str;
            }
        } catch (Throwable unused2) {
            TLogger.ww("OtherPushHuaWeiImpl", "Not found AGConnectServicesConfig");
            return str;
        }
    }

    public void a(Context context) {
        Class<String> cls = String.class;
        this.f69276a = context;
        this.f69279d = new StringBuffer();
        TLogger.i("OtherPushHuaWeiImpl", "other push huawei registerPush");
        h(context);
        if (this.f69280e == 0) {
            this.f69280e = c();
        }
        TLogger.ii("OtherPushHuaWeiImpl", "Get HW SDK version: " + this.f69280e);
        try {
            int i11 = this.f69280e;
            if (i11 == 3) {
                Object invoke = this.f69281f.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(this.f69281f, new Object[]{context});
                Method declaredMethod = this.f69281f.getDeclaredMethod("getToken", new Class[]{cls, cls});
                String g11 = g(context);
                TLogger.i("OtherPushHuaWeiImpl", "Get HW appId from agcp: " + g11);
                Object invoke2 = declaredMethod.invoke(invoke, new Object[]{g11, HmsMessaging.DEFAULT_TOKEN_SCOPE});
                if (invoke2 == null || TextUtils.isEmpty(invoke2.toString())) {
                    TLogger.i("OtherPushHuaWeiImpl", "Get HW token from HWS.getToken null or empty, get it from receiver");
                    return;
                }
                TLogger.i("OtherPushHuaWeiImpl", "Get HW token: " + invoke2.toString());
                if (!invoke2.toString().equals(c(context))) {
                    String obj = invoke2.toString();
                    this.f69278c = obj;
                    SharePrefsUtil.setString(context, "huawei_token", obj);
                }
                a(invoke2.toString());
                d.a(context, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
            } else if (i11 == 2) {
                this.f69281f.getDeclaredMethod(ZendeskBlipsProvider.ACTION_CORE_INIT, new Class[]{Application.class}).invoke(this.f69281f, new Object[]{context.getApplicationContext()});
                Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.common.handler.ConnectHandler");
                a aVar = new a();
                Object newProxyInstance = Proxy.newProxyInstance(this.f69281f.getClassLoader(), new Class[]{cls2}, aVar);
                this.f69281f.getDeclaredMethod("connect", new Class[]{Activity.class, cls2}).invoke(this.f69281f, new Object[]{null, newProxyInstance});
            } else if (i11 == -1) {
                StringBuffer stringBuffer = this.f69279d;
                stringBuffer.append("errCode : -122 , errMsg : Missing HWPush Service SDK");
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                TLogger.ww("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                throw new Exception();
            }
        } catch (Throwable th2) {
            TLogger.e("OtherPushHuaWeiImpl", "" + th2.getCause(), th2);
            StringBuffer stringBuffer2 = this.f69279d;
            stringBuffer2.append("errCode : -123 , errMsg :" + th2.getLocalizedMessage());
            SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
        }
    }

    public String c(Context context) {
        if (j.b(this.f69278c)) {
            this.f69278c = SharePrefsUtil.getString(context, "huawei_token", "");
        }
        return this.f69278c;
    }

    public void b(Context context) {
        Class<String> cls = String.class;
        if (!j.b(this.f69278c)) {
            if (this.f69279d == null) {
                this.f69279d = new StringBuffer();
            }
            TLogger.i("OtherPushHuaWeiImpl", "other push huawei unregisterPush");
            if (this.f69280e == 0) {
                this.f69280e = c();
            }
            try {
                int i11 = this.f69280e;
                if (i11 == 3) {
                    Object invoke = this.f69281f.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(this.f69281f, new Object[]{this.f69276a});
                    this.f69281f.getDeclaredMethod("deleteToken", new Class[]{cls, cls}).invoke(invoke, new Object[]{"100167977", HmsMessaging.DEFAULT_TOKEN_SCOPE});
                } else if (i11 == 2) {
                    Class<?> cls2 = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
                    Class<?> cls3 = Class.forName("com.huawei.android.hms.agent.push.handler.DeleteTokenHandler");
                    a aVar = new a();
                    Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls3}, aVar);
                    cls2.getDeclaredMethod("deleteToken", new Class[]{cls, cls3}).invoke(cls2, new Object[]{this.f69278c, newProxyInstance});
                } else if (i11 == -1) {
                    TLogger.w("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
                    Context context2 = this.f69276a;
                    StringBuffer stringBuffer = this.f69279d;
                    stringBuffer.append("errCode : -122 , errMsg : Missing HWPush Service SDK");
                    SharePrefsUtil.setString(context2, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                    throw new Exception();
                }
            } catch (Throwable th2) {
                TLogger.e("OtherPushHuaWeiImpl", "unregisterPush error", th2);
                Context context3 = this.f69276a;
                StringBuffer stringBuffer2 = this.f69279d;
                stringBuffer2.append("errCode : -128 , errMsg :" + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context3, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer2.toString());
            }
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
                intent.putExtra(Constants.PUSH_CHANNEL, 102);
                intent.setPackage(XGPushManager.getContext().getPackageName());
                intent.putExtra(Constants.FEEDBACK_TOKEN_KEY, "huawei_token");
                intent.putExtra(Constants.FEEDBACK_NOT_UPDATE_TOKEN_KEY, 1);
                XGPushManager.onOtherPushRegister(XGPushManager.getContext(), intent);
            }
        } catch (Throwable unused) {
        }
    }
}
