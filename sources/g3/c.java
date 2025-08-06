package g3;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import com.bbc876219.lib.hook.CrashUtils;
import com.bbc876219.lib.zlog.Log;
import java.lang.reflect.UndeclaredThrowableException;

public class c implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    public static int f15829c = 100;

    /* renamed from: d  reason: collision with root package name */
    public static int f15830d = 109;

    /* renamed from: e  reason: collision with root package name */
    public static int f15831e = 134;

    /* renamed from: f  reason: collision with root package name */
    public static int f15832f = 113;

    /* renamed from: g  reason: collision with root package name */
    public static int f15833g = 152;

    /* renamed from: h  reason: collision with root package name */
    public static int f15834h = 103;

    /* renamed from: i  reason: collision with root package name */
    public static int f15835i = 104;

    /* renamed from: j  reason: collision with root package name */
    public static int f15836j = 114;

    /* renamed from: b  reason: collision with root package name */
    public Handler f15837b;

    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00bd */
    static {
        /*
            java.lang.String r0 = "static initializer: "
            java.lang.String r1 = "HandlerCallback"
            java.lang.reflect.Method r2 = com.bbc876219.lib.utils.reflection.ReflectionUtils.f63248a     // Catch:{ all -> 0x00dc }
            r3 = 0
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00dc }
            r5 = 0
            java.lang.String r6 = "android.app.ActivityThread$H"
            r4[r5] = r6     // Catch:{ all -> 0x00dc }
            java.lang.Object r2 = r2.invoke(r3, r4)     // Catch:{ all -> 0x00dc }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = "LAUNCH_ACTIVITY"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x002d, IllegalAccessException -> 0x0029 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x002d, IllegalAccessException -> 0x0029 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x002d, IllegalAccessException -> 0x0029 }
            if (r3 < 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r3 = 100
        L_0x0026:
            f15829c = r3     // Catch:{ NoSuchFieldException -> 0x002d, IllegalAccessException -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x002d:
            java.lang.String r3 = "DESTROY_ACTIVITY"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x0045, IllegalAccessException -> 0x0041 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x0045, IllegalAccessException -> 0x0041 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x0045, IllegalAccessException -> 0x0041 }
            if (r3 < 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r3 = 109(0x6d, float:1.53E-43)
        L_0x003e:
            f15830d = r3     // Catch:{ NoSuchFieldException -> 0x0045, IllegalAccessException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x0045:
            java.lang.String r3 = "RECEIVER"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x005d, IllegalAccessException -> 0x0059 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x005d, IllegalAccessException -> 0x0059 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x005d, IllegalAccessException -> 0x0059 }
            if (r3 < 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r3 = 113(0x71, float:1.58E-43)
        L_0x0056:
            f15832f = r3     // Catch:{ NoSuchFieldException -> 0x005d, IllegalAccessException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x005d:
            java.lang.String r3 = "SCHEDULE_CRASH"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x0075, IllegalAccessException -> 0x0071 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x0075, IllegalAccessException -> 0x0071 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x0075, IllegalAccessException -> 0x0071 }
            if (r3 < 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r3 = 134(0x86, float:1.88E-43)
        L_0x006e:
            f15831e = r3     // Catch:{ NoSuchFieldException -> 0x0075, IllegalAccessException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x0075:
            java.lang.String r3 = "CREATE_SERVICE"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x008d, IllegalAccessException -> 0x0089 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x008d, IllegalAccessException -> 0x0089 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x008d, IllegalAccessException -> 0x0089 }
            if (r3 < 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r3 = 114(0x72, float:1.6E-43)
        L_0x0086:
            f15836j = r3     // Catch:{ NoSuchFieldException -> 0x008d, IllegalAccessException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x008d:
            java.lang.String r3 = "STOP_ACTIVITY_SHOW"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x00a5, IllegalAccessException -> 0x00a1 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x00a5, IllegalAccessException -> 0x00a1 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x00a5, IllegalAccessException -> 0x00a1 }
            if (r3 < 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r3 = 103(0x67, float:1.44E-43)
        L_0x009e:
            f15834h = r3     // Catch:{ NoSuchFieldException -> 0x00a5, IllegalAccessException -> 0x00a1 }
            goto L_0x00a5
        L_0x00a1:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x00a5:
            java.lang.String r3 = "STOP_ACTIVITY_HIDE"
            java.lang.Object r3 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x00bd, IllegalAccessException -> 0x00b9 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ NoSuchFieldException -> 0x00bd, IllegalAccessException -> 0x00b9 }
            int r3 = r3.intValue()     // Catch:{ NoSuchFieldException -> 0x00bd, IllegalAccessException -> 0x00b9 }
            if (r3 < 0) goto L_0x00b4
            goto L_0x00b6
        L_0x00b4:
            r3 = 104(0x68, float:1.46E-43)
        L_0x00b6:
            f15835i = r3     // Catch:{ NoSuchFieldException -> 0x00bd, IllegalAccessException -> 0x00b9 }
            goto L_0x00bd
        L_0x00b9:
            r3 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r3)     // Catch:{ all -> 0x00dc }
        L_0x00bd:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchFieldException -> 0x00e0, IllegalAccessException -> 0x00d7 }
            r4 = 24
            if (r3 < r4) goto L_0x00e0
            java.lang.String r3 = "MULTI_WINDOW_MODE_CHANGED"
            java.lang.Object r2 = com.bbc876219.lib.utils.reflection.ReflectionUtils.g(r2, r3)     // Catch:{ NoSuchFieldException -> 0x00e0, IllegalAccessException -> 0x00d7 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ NoSuchFieldException -> 0x00e0, IllegalAccessException -> 0x00d7 }
            int r2 = r2.intValue()     // Catch:{ NoSuchFieldException -> 0x00e0, IllegalAccessException -> 0x00d7 }
            if (r2 < 0) goto L_0x00d2
            goto L_0x00d4
        L_0x00d2:
            r2 = 152(0x98, float:2.13E-43)
        L_0x00d4:
            f15833g = r2     // Catch:{ NoSuchFieldException -> 0x00e0, IllegalAccessException -> 0x00d7 }
            goto L_0x00e0
        L_0x00d7:
            r2 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r2)     // Catch:{ all -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r2 = move-exception
            com.bbc876219.lib.zlog.Log.d(r1, r0, r2)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.c.<clinit>():void");
    }

    public c(Handler handler) {
        this.f15837b = handler;
    }

    public final boolean a(Throwable th2) {
        if (th2 == null) {
            return false;
        }
        String message = th2.getMessage();
        boolean z11 = (th2 instanceof WindowManager.BadTokenException) && message.startsWith("Unable to add window") && message.contains("is your activity running?");
        boolean z12 = (th2 instanceof IllegalArgumentException) && message.startsWith("reportSizeConfigurations: ActivityRecord not");
        boolean z13 = th2 instanceof UndeclaredThrowableException;
        if (z11 || z12 || z13) {
            return true;
        }
        return false;
    }

    public final boolean b(Throwable th2) {
        if (th2 == null) {
            return false;
        }
        boolean z11 = th2 instanceof ClassNotFoundException;
        boolean z12 = (th2 instanceof RuntimeException) && th2.getMessage().startsWith("Unable to instantiate receiver");
        if (z11 || z12) {
            return true;
        }
        return false;
    }

    public boolean handleMessage(Message message) {
        Log.b("HandlerCallback", "handleMessage() called with: msg = [" + message.what + "]");
        int i11 = message.what;
        if (i11 == f15831e) {
            try {
                CrashUtils.d((String) message.obj);
                this.f15837b.handleMessage(message);
            } catch (Throwable th2) {
                th2.printStackTrace();
                CrashUtils.e(th2);
            }
            return true;
        } else if (i11 == f15833g) {
            try {
                this.f15837b.handleMessage(message);
            } catch (Throwable th3) {
                th3.printStackTrace();
                CrashUtils.e(th3);
            }
            return true;
        } else if (i11 == f15829c) {
            try {
                this.f15837b.handleMessage(message);
            } catch (Throwable th4) {
                th4.printStackTrace();
                CrashUtils.e(th4);
                if (!a(th4)) {
                    throw th4;
                }
            }
            return true;
        } else if (i11 == f15836j) {
            try {
                this.f15837b.handleMessage(message);
            } catch (Throwable th5) {
                th5.printStackTrace();
                CrashUtils.e(th5);
            }
            return true;
        } else if (i11 == f15832f) {
            try {
                this.f15837b.handleMessage(message);
            } catch (Throwable th6) {
                th6.printStackTrace();
                if (!b(th6)) {
                    throw th6;
                }
            }
            return true;
        } else if (i11 == f15830d) {
            try {
                this.f15837b.handleMessage(message);
            } catch (Throwable th7) {
                th7.printStackTrace();
                CrashUtils.e(th7);
            }
            return true;
        } else if (i11 != f15834h && i11 != f15835i) {
            return false;
        } else {
            try {
                this.f15837b.handleMessage(message);
            } catch (Throwable th8) {
                th8.printStackTrace();
                CrashUtils.e(th8);
            }
            return true;
        }
    }
}
