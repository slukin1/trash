package com.tencent.android.tpush.d.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class g extends c {

    /* renamed from: h  reason: collision with root package name */
    private static long f69303h;

    /* renamed from: a  reason: collision with root package name */
    public StringBuffer f69304a;

    /* renamed from: b  reason: collision with root package name */
    private Object f69305b = null;

    /* renamed from: c  reason: collision with root package name */
    private Object f69306c = null;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f69307d = null;

    /* renamed from: e  reason: collision with root package name */
    private Class<?> f69308e = null;

    /* renamed from: f  reason: collision with root package name */
    private Class<?> f69309f = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f69310g;

    public class a implements InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        private Context f69312b;

        public a(Context context) {
            this.f69312b = context;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            try {
                if (method.getName().equals("onStateChanged")) {
                    if (objArr != null) {
                        if (objArr.length > 0) {
                            int intValue = objArr[0].intValue();
                            if (intValue == 0) {
                                TLogger.ii("OtherPushVivoImpl", "vivoPush Register or UnRegister success, code = " + intValue);
                                d.a(this.f69312b, "OtherPushVivoImpl", "errCode : " + intValue + " , errMsg : success");
                            } else {
                                TLogger.ww("OtherPushVivoImpl", "vivoPush Register or UnRegister fail, code = " + intValue);
                                Context context = this.f69312b;
                                StringBuffer stringBuffer = g.this.f69304a;
                                stringBuffer.append("errCode : " + intValue + " , errMsg : unknown");
                                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                            }
                        }
                    }
                    return method;
                }
                if (method.getName().equals("onSuccess")) {
                    String str = objArr[0];
                    TLogger.i("OtherPushVivoImpl", "vivoPush MyHandler getRegId onSuccess regid:" + str);
                    String unused = g.this.f69310g = str;
                    SharePrefsUtil.setString(this.f69312b, "vivo_token", g.this.f69310g);
                    g gVar = g.this;
                    gVar.a(gVar.f69310g);
                } else if (method.getName().equals("onFail")) {
                    int intValue2 = objArr[0].intValue();
                    TLogger.ii("OtherPushVivoImpl", "vivoPush MyHandler getRegId fail, code = " + intValue2);
                    String unused2 = g.this.f69310g = "";
                    SharePrefsUtil.setString(this.f69312b, "vivo_token", g.this.f69310g);
                }
                return method;
            } catch (Throwable unused3) {
            }
        }
    }

    private Object g(Context context) {
        try {
            Class<?> cls = Class.forName("com.vivo.push.PushClient");
            this.f69307d = cls;
            return cls.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(this.f69307d, new Object[]{context.getApplicationContext()});
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            TLogger.e("OtherPushVivoImpl", "getImplInstance Error for InvocationTargetException: " + cause.getMessage());
            cause.printStackTrace();
            return null;
        } catch (Throwable th2) {
            TLogger.e("OtherPushVivoImpl", "getImplInstance Error ", th2);
            return null;
        }
    }

    private String h(Context context) {
        if (j.b(this.f69310g)) {
            this.f69310g = SharePrefsUtil.getString(context, "vivo_token", "");
        }
        return this.f69310g;
    }

    public String a() {
        return "vivo";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|(3:14|(1:16)|17)|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r13.f69306c == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r13.f69309f == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r13.f69309f = java.lang.Class.forName("com.vivo.push.listener.IPushQueryActionListener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r8 = new com.tencent.android.tpush.d.a.g.a(r13, r14);
        r13.f69306c = java.lang.reflect.Proxy.newProxyInstance(r13.f69309f.getClassLoader(), new java.lang.Class[]{r13.f69309f}, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        r5.getDeclaredMethod("getRegId", new java.lang.Class[]{r13.f69309f}).invoke(r3, new java.lang.Object[]{r13.f69306c});
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "getRegId"
            java.lang.String r1 = "other_push_error_code"
            java.lang.String r2 = "OtherPushVivoImpl"
            java.lang.StringBuffer r3 = r13.f69304a
            if (r3 != 0) goto L_0x0011
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r13.f69304a = r3
        L_0x0011:
            java.lang.Object r3 = r13.g(r14)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x00f8
            java.lang.String r5 = "com.vivo.push.PushClient"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r6 = 0
            r7 = 0
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch:{ all -> 0x002e }
            java.lang.reflect.Method r8 = r5.getDeclaredMethod(r0, r8)     // Catch:{ all -> 0x002e }
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x002e }
            java.lang.Object r6 = r8.invoke(r3, r9)     // Catch:{ all -> 0x002e }
            goto L_0x0069
        L_0x002e:
            java.lang.Object r8 = r13.f69306c     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r9 = 1
            if (r8 != 0) goto L_0x0056
            java.lang.Class<?> r8 = r13.f69309f     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            if (r8 != 0) goto L_0x003f
            java.lang.String r8 = "com.vivo.push.listener.IPushQueryActionListener"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r13.f69309f = r8     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
        L_0x003f:
            com.tencent.android.tpush.d.a.g$a r8 = new com.tencent.android.tpush.d.a.g$a     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r8.<init>(r14)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Class<?> r10 = r13.f69309f     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Class[] r11 = new java.lang.Class[r9]     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Class<?> r12 = r13.f69309f     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r11[r7] = r12     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Object r8 = java.lang.reflect.Proxy.newProxyInstance(r10, r11, r8)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r13.f69306c = r8     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
        L_0x0056:
            java.lang.Class[] r8 = new java.lang.Class[r9]     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Class<?> r10 = r13.f69309f     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r8[r7] = r10     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.reflect.Method r0 = r5.getDeclaredMethod(r0, r8)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.Object r8 = r13.f69306c     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r5[r7] = r8     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r0.invoke(r3, r5)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
        L_0x0069:
            java.lang.String r0 = r13.h(r14)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            if (r6 == 0) goto L_0x0090
            java.lang.String r3 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            boolean r3 = com.tencent.android.tpush.common.j.b((java.lang.String) r3)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            if (r3 != 0) goto L_0x0090
            java.lang.String r3 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            boolean r3 = r3.equals(r0)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            if (r3 != 0) goto L_0x0090
            java.lang.String r0 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r13.f69310g = r0     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.String r3 = "vivo_token"
            com.tencent.android.tpush.service.util.SharePrefsUtil.setString(r14, r3, r0)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            java.lang.String r0 = r13.f69310g     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
        L_0x0090:
            r4 = r0
            if (r6 == 0) goto L_0x00f8
            java.lang.String r0 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            boolean r0 = com.tencent.android.tpush.common.j.b((java.lang.String) r0)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            if (r0 != 0) goto L_0x00f8
            java.lang.String r0 = r6.toString()     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            r13.a((java.lang.String) r0)     // Catch:{ InvocationTargetException -> 0x00cd, all -> 0x00a5 }
            goto L_0x00f8
        L_0x00a5:
            r0 = move-exception
            java.lang.String r3 = "getRegId Error "
            com.tencent.android.tpush.logging.TLogger.e(r2, r3, r0)
            java.lang.StringBuffer r2 = r13.f69304a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "errCode : -142 , errMsg : "
            r3.append(r5)
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.tencent.android.tpush.service.util.SharePrefsUtil.setString(r14, r1, r0)
            goto L_0x00f8
        L_0x00cd:
            r0 = move-exception
            java.lang.Throwable r3 = r0.getCause()
            java.lang.String r5 = "getRegId Error for InvocationTargetException: "
            com.tencent.android.tpush.logging.TLogger.e(r2, r5, r3)
            java.lang.StringBuffer r2 = r13.f69304a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "errCode : -141 , errMsg : "
            r3.append(r5)
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.tencent.android.tpush.service.util.SharePrefsUtil.setString(r14, r1, r0)
        L_0x00f8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.d.a.g.c(android.content.Context):java.lang.String");
    }

    public boolean d(Context context) {
        Object g11 = g(context);
        if (g11 != null) {
            try {
                boolean booleanValue = ((Boolean) Class.forName("com.vivo.push.PushClient").getDeclaredMethod("isSupport", new Class[0]).invoke(g11, new Object[0])).booleanValue();
                if (!booleanValue) {
                    TLogger.e("OtherPushVivoImpl", "vivo push api isSupport() returns false, the device not support for vivo push!");
                }
                return booleanValue;
            } catch (InvocationTargetException e11) {
                Throwable cause = e11.getCause();
                TLogger.e("OtherPushVivoImpl", "isConfig Error for InvocationTargetException: " + cause.getMessage());
                cause.printStackTrace();
            } catch (Throwable th2) {
                TLogger.e("OtherPushVivoImpl", "isConfig Error ", th2);
            }
        }
        return false;
    }

    public int e(Context context) {
        return 7;
    }

    public String f(Context context) {
        return "";
    }

    public void b(Context context) {
        if (this.f69304a == null) {
            this.f69304a = new StringBuffer();
        }
        Object g11 = g(context);
        if (g11 != null) {
            try {
                if (this.f69305b == null) {
                    this.f69308e = Class.forName("com.vivo.push.IPushActionListener");
                    a aVar = new a(context);
                    this.f69305b = Proxy.newProxyInstance(this.f69308e.getClassLoader(), new Class[]{this.f69308e}, aVar);
                }
                if (this.f69308e == null) {
                    this.f69308e = Class.forName("com.vivo.push.IPushActionListener");
                }
                if (this.f69307d == null) {
                    this.f69307d = Class.forName("com.vivo.push.PushClient");
                }
                this.f69307d.getDeclaredMethod("turnOffPush", new Class[]{this.f69308e}).invoke(g11, new Object[]{this.f69305b});
                TLogger.ii("OtherPushVivoImpl", "unregisterPush vivo push channel success");
            } catch (Throwable th2) {
                TLogger.e("OtherPushVivoImpl", "unregisterPush Throwable e: " + th2.getMessage(), th2);
                StringBuffer stringBuffer = this.f69304a;
                stringBuffer.append("errCode : -143 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
            }
        }
    }

    public void a(Context context) {
        this.f69304a = new StringBuffer();
        Object g11 = g(context);
        if (g11 != null) {
            try {
                if (this.f69307d == null) {
                    this.f69307d = Class.forName("com.vivo.push.PushClient");
                }
                this.f69307d.getDeclaredMethod("initialize", new Class[0]).invoke(g11, new Object[0]);
            } catch (Throwable th2) {
                TLogger.e("OtherPushVivoImpl", "registerPush Throwable e: " + th2.getMessage(), th2);
                StringBuffer stringBuffer = this.f69304a;
                stringBuffer.append("errCode : -140 , errMsg : " + th2.getLocalizedMessage());
                SharePrefsUtil.setString(context, Constants.OTHER_PUSH_ERROR_CODE, stringBuffer.toString());
                return;
            }
            if (this.f69305b == null) {
                this.f69308e = Class.forName("com.vivo.push.IPushActionListener");
                a aVar = new a(context);
                this.f69305b = Proxy.newProxyInstance(this.f69308e.getClassLoader(), new Class[]{this.f69308e}, aVar);
            }
            if (this.f69308e == null) {
                this.f69308e = Class.forName("com.vivo.push.IPushActionListener");
            }
            this.f69307d.getDeclaredMethod("turnOnPush", new Class[]{this.f69308e}).invoke(g11, new Object[]{this.f69305b});
            TLogger.ii("OtherPushVivoImpl", "registerPush vivo push channel success");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            if (XGPushManager.getContext() != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f69303h > 5000) {
                    f69303h = currentTimeMillis;
                    Intent intent = new Intent(Constants.ACTION_FEEDBACK);
                    intent.putExtra(Constants.FEEDBACK_ERROR_CODE, str != null ? 0 : -1);
                    intent.putExtra(Constants.OTHER_PUSH_TOKEN, str);
                    intent.putExtra(Constants.FEEDBACK_TAG, 1);
                    intent.putExtra(Constants.PUSH_CHANNEL, 104);
                    intent.setPackage(XGPushManager.getContext().getPackageName());
                    intent.putExtra(Constants.FEEDBACK_TOKEN_KEY, "vivo_token");
                    intent.putExtra(Constants.FEEDBACK_NOT_UPDATE_TOKEN_KEY, 1);
                    XGPushManager.onOtherPushRegister(XGPushManager.getContext(), intent);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
