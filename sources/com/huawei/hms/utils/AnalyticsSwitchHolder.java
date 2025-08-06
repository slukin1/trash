package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;

public class AnalyticsSwitchHolder {
    public static final int ANALYTICS_DISABLED = 2;
    public static final int ANALYTICS_ENABLED = 1;

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f38562a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f38563b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static volatile Long f38564c = 0L;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f38565d = false;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f38566e = false;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38567a;

        public a(Context context) {
            this.f38567a = context;
        }

        public void run() {
            AnalyticsSwitchHolder.f(this.f38567a);
            HMSLog.i("AnalyticsSwitchHolder", "getStateForHmsAnalyticsProvider");
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f38568a;

        public b(Context context) {
            this.f38568a = context;
        }

        public void run() {
            HMSLog.i("AnalyticsSwitchHolder", "enter setAnalyticsStateAndTimestamp");
            AnalyticsSwitchHolder.f(this.f38568a);
            HMSLog.i("AnalyticsSwitchHolder", "quit setAnalyticsStateAndTimestamp");
        }
    }

    private static boolean b(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                    return bundle.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (RuntimeException e11) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", (Throwable) e11);
            }
        }
        HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    private static void c(Context context) {
        f38564c = Long.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        new Thread(new a(context), "Thread-getStateForHmsAnalyticsProvider").start();
    }

    private static boolean d(Context context) {
        return RegionUtils.isChinaROM(context);
    }

    private static void e(Context context) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (timestamp.getTime() - f38564c.longValue() >= Period.DAY_MILLS && f38564c.longValue() > 0) {
            f38564c = Long.valueOf(timestamp.getTime());
            new Thread(new b(context), "Thread-refreshOobeAnalyticsState").start();
        }
    }

    /* access modifiers changed from: private */
    public static void f(Context context) {
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In setAnalyticsState、, context is null.");
        } else if (HiAnalyticsUtils.getInstance().getOobeAnalyticsState(context) == 1) {
            synchronized (f38563b) {
                f38562a = 1;
            }
            if (!HiAnalyticsUtils.getInstance().getInitFlag() && !f38565d) {
                HMSBIInitializer.getInstance(context).initHaSDK();
                f38565d = true;
            }
        } else {
            synchronized (f38563b) {
                f38562a = 2;
            }
            com.huawei.hms.stats.a.c().a();
        }
    }

    public static int getAndRefreshAnalyticsState(Context context) {
        int i11;
        synchronized (f38563b) {
            isAnalyticsDisabled(context);
            i11 = f38562a;
        }
        return i11;
    }

    public static boolean getBiSetting(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                    return bundle.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (RuntimeException e11) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", (Throwable) e11);
            }
        }
        HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (f38562a == 1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isAnalyticsDisabled(android.content.Context r4) {
        /*
            java.lang.Object r0 = f38563b
            monitor-enter(r0)
            int r1 = f38562a     // Catch:{ all -> 0x0055 }
            r2 = 1
            if (r1 != 0) goto L_0x0046
            if (r4 != 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return r2
        L_0x000c:
            boolean r1 = b(r4)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x001c
            java.lang.String r4 = "AnalyticsSwitchHolder"
            java.lang.String r1 = "Builder->biReportSetting :true"
            com.huawei.hms.support.log.HMSLog.i(r4, r1)     // Catch:{ all -> 0x0055 }
            f38562a = r2     // Catch:{ all -> 0x0055 }
            goto L_0x004d
        L_0x001c:
            boolean r1 = getBiSetting(r4)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r4 = "AnalyticsSwitchHolder"
            java.lang.String r1 = "Builder->biSetting :true"
            com.huawei.hms.support.log.HMSLog.i(r4, r1)     // Catch:{ all -> 0x0055 }
            r4 = 2
            f38562a = r4     // Catch:{ all -> 0x0055 }
            goto L_0x004d
        L_0x002d:
            boolean r1 = d(r4)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0036
            f38562a = r2     // Catch:{ all -> 0x0055 }
            goto L_0x004d
        L_0x0036:
            java.lang.String r1 = "AnalyticsSwitchHolder"
            java.lang.String r3 = "not ChinaROM"
            com.huawei.hms.support.log.HMSLog.i(r1, r3)     // Catch:{ all -> 0x0055 }
            r1 = 3
            f38562a = r1     // Catch:{ all -> 0x0055 }
            f38566e = r2     // Catch:{ all -> 0x0055 }
            c(r4)     // Catch:{ all -> 0x0055 }
            goto L_0x004d
        L_0x0046:
            boolean r1 = f38566e     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x004d
            e(r4)     // Catch:{ all -> 0x0055 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            int r4 = f38562a
            if (r4 == r2) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            return r2
        L_0x0055:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.AnalyticsSwitchHolder.isAnalyticsDisabled(android.content.Context):boolean");
    }
}
