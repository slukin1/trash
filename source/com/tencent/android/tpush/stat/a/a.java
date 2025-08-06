package com.tencent.android.tpush.stat.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.android.tpush.InnerTpnsActivity;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.c;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Set;

public class a extends TTask {

    /* renamed from: a  reason: collision with root package name */
    private static long f69926a;

    /* renamed from: b  reason: collision with root package name */
    private static long f69927b;

    /* renamed from: g  reason: collision with root package name */
    private static String f69928g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f69929h;

    /* renamed from: i  reason: collision with root package name */
    private static a f69930i;

    /* renamed from: c  reason: collision with root package name */
    private Intent f69931c;

    /* renamed from: d  reason: collision with root package name */
    private String f69932d;

    /* renamed from: e  reason: collision with root package name */
    private Context f69933e;

    /* renamed from: f  reason: collision with root package name */
    private int f69934f;

    public a(Context context, Intent intent, String str, int i11) {
        super("AppLaunchTask");
        this.f69931c = intent;
        this.f69932d = str;
        this.f69933e = context;
        this.f69934f = i11;
    }

    private void a() {
        Context context = this.f69933e;
        if (j.c(context, context.getPackageName()) && PushPreferences.getBoolean(this.f69933e, "app_first_launch", true)) {
            ServiceStat.reportCustomData4FirstLaunch(this.f69933e);
            PushPreferences.putBoolean(this.f69933e, "app_first_launch", false);
        }
    }

    private void b() {
        if (!CloudManager.getInstance(this.f69933e).disableRepLanuEv()) {
            int i11 = 4;
            long j11 = 0;
            if (TextUtils.equals(this.f69932d, TpnsActivity.class.getCanonicalName()) || TextUtils.equals(this.f69932d, InnerTpnsActivity.class.getCanonicalName())) {
                i11 = 3;
                j11 = TpnsActivity.getMsgIdWithIntent(this.f69931c);
            } else {
                Intent intent = this.f69931c;
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data == null || j.b(data.getHost())) {
                        String action = this.f69931c.getAction();
                        Set<String> categories = this.f69931c.getCategories();
                        boolean z11 = categories != null && categories.contains("android.intent.category.LAUNCHER");
                        if (TextUtils.equals(action, "android.intent.action.MAIN") && z11) {
                            i11 = 1;
                        }
                    } else {
                        i11 = 2;
                    }
                }
            }
            ServiceStat.reportLaunchEvent(this.f69933e, i11, b(this.f69933e), j11);
            return;
        }
        TLogger.d("AppLaunchTask", "disabled report launch event");
    }

    private static synchronized int c() {
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis() - f69926a;
            long j11 = f69927b;
            if (j11 == 0 && currentTimeMillis > 30000) {
                return 2;
            }
            if (j11 != 0 || currentTimeMillis <= 8000) {
                return -1;
            }
            return 1;
        }
    }

    public void TRun() {
        Context context = this.f69933e;
        if (context == null) {
            TLogger.d("AppLaunchTask", "context was null");
        } else if (j.a(context) > 0) {
            TLogger.d("AppLaunchTask", "TPNS init failed!");
        } else {
            if (this.f69934f == 2) {
                a();
                b();
            }
            c.a(this.f69933e, true);
        }
    }

    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!j.b(f69928g) || !j.b(f69928g)) {
            return true;
        }
        return false;
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (j.b(str)) {
                TLogger.d("AppLaunchTask", "token was null");
            } else if (context == null) {
                TLogger.d("AppLaunchTask", "context was null");
            } else if (!Util.isMainProcess(context)) {
                TLogger.d("AppLaunchTask", "must run at main process");
            } else {
                f69928g = str;
                if (f69929h && f69930i != null) {
                    CommonWorkingThread.getInstance().execute(f69930i);
                    f69929h = false;
                    f69930i = null;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Activity activity, String str) {
        if (activity == null) {
            try {
                TLogger.w("AppLaunchTask", "onActivityEntry - activity was null, reason:" + str);
            } catch (Throwable unused) {
            }
        } else {
            int c11 = c();
            if (a(activity)) {
                if (c11 > 0) {
                    b(activity, str, c11);
                }
                if (f69927b == 0) {
                    f69927b = System.currentTimeMillis();
                }
            } else if (c11 == 2) {
                f69929h = true;
                f69930i = a(activity, str, c11);
            }
        }
    }

    public static void a(Activity activity, String str) {
        if (activity == null) {
            try {
                TLogger.w("AppLaunchTask", "onActivityExits - activity was null, reason:" + str);
            } catch (Throwable unused) {
            }
        } else {
            f69926a = System.currentTimeMillis();
            if (f69927b != 0) {
                f69927b = 0;
            }
        }
    }

    private static a a(Activity activity, String str, int i11) {
        if (activity == null) {
            TLogger.d("AppLaunchTask", "runAppLaunch - activity was null");
            return null;
        }
        String className = activity.getComponentName().getClassName();
        return new a(activity.getApplicationContext(), activity.getIntent(), className, i11);
    }

    private static void b(Activity activity, String str, int i11) {
        try {
            a a11 = a(activity, str, i11);
            if (a11 != null) {
                CommonWorkingThread.getInstance().execute(a11);
            }
            f69930i = null;
            f69929h = false;
        } catch (Throwable th2) {
            TLogger.d("AppLaunchTask", "unexpected for runAppLaunch:" + th2.getMessage());
        }
    }

    private int b(Context context) {
        long j11 = PushPreferences.getLong(context, "fisrt.launch.of.the.day", 0);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a11 = j.a(currentTimeMillis, j11);
        if (!a11) {
            PushPreferences.putLong(context, "fisrt.launch.of.the.day", currentTimeMillis);
        }
        return a11 ^ true ? 1 : 0;
    }
}
