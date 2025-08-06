package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f37987i = "c";

    /* renamed from: j  reason: collision with root package name */
    private static final ExecutorService f37988j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static long f37989k = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public GrsBaseInfo f37990a;

    /* renamed from: b  reason: collision with root package name */
    private Context f37991b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public g f37992c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.a f37993d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.c f37994e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.e.c f37995f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f37996g;

    /* renamed from: h  reason: collision with root package name */
    private FutureTask<Boolean> f37997h = null;

    public class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f37998a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GrsBaseInfo f37999b;

        public a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f37998a = context;
            this.f37999b = grsBaseInfo;
        }

        public Boolean call() {
            g unused = c.this.f37992c = new g();
            c cVar = c.this;
            Context context = this.f37998a;
            com.huawei.hms.framework.network.grs.e.c unused2 = cVar.f37994e = new com.huawei.hms.framework.network.grs.e.c(context, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            c cVar2 = c.this;
            Context context2 = this.f37998a;
            com.huawei.hms.framework.network.grs.e.c unused3 = cVar2.f37995f = new com.huawei.hms.framework.network.grs.e.c(context2, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar3 = c.this;
            com.huawei.hms.framework.network.grs.e.a unused4 = cVar3.f37993d = new com.huawei.hms.framework.network.grs.e.a(cVar3.f37994e, c.this.f37995f, c.this.f37992c);
            c cVar4 = c.this;
            a unused5 = cVar4.f37996g = new a(cVar4.f37990a, c.this.f37993d, c.this.f37992c, c.this.f37995f);
            if (b.a(this.f37998a.getPackageName()) == null) {
                new b(this.f37998a, true);
            }
            String c11 = new com.huawei.hms.framework.network.grs.g.j.c(this.f37999b, this.f37998a).c();
            String c12 = c.f37987i;
            Logger.v(c12, "scan serviceSet is: " + c11);
            String a11 = c.this.f37995f.a("services", "");
            String a12 = h.a(a11, c11);
            if (!TextUtils.isEmpty(a12)) {
                c.this.f37995f.b("services", a12);
                String c13 = c.f37987i;
                Logger.i(c13, "postList is:" + StringUtils.anonymizeMessage(a12));
                String c14 = c.f37987i;
                Logger.i(c14, "currentServices:" + StringUtils.anonymizeMessage(a11));
                if (!a12.equals(a11)) {
                    c.this.f37992c.a(c.this.f37990a.getGrsParasKey(true, true, this.f37998a));
                    c.this.f37992c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f37999b, this.f37998a), (b) null, (String) null, c.this.f37995f, c.this.f37990a.getQueryTimeout());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - c.f37989k;
            if (c.f37989k == 0 || TimeUnit.MILLISECONDS.toHours(elapsedRealtime) > 24) {
                Logger.i(c.f37987i, "Try to clear unUsed sp data.");
                long unused6 = c.f37989k = SystemClock.elapsedRealtime();
                c cVar5 = c.this;
                cVar5.a(cVar5.f37994e.a());
            }
            c.this.f37993d.b(this.f37999b, this.f37998a);
            return Boolean.TRUE;
        }
    }

    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f37991b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f37990a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f37991b, grsBaseInfo2));
        this.f37997h = futureTask;
        f37988j.execute(futureTask);
        Logger.i(f37987i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    public c(GrsBaseInfo grsBaseInfo) {
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f37990a = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e11) {
            Logger.w(f37987i, "GrsClient catch CloneNotSupportedException", (Throwable) e11);
            this.f37990a = grsBaseInfo.copy();
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f37987i, "sp's content is empty.");
            return;
        }
        Set<String> keySet = map.keySet();
        for (String next : keySet) {
            if (next.endsWith(this.f37991b.getPackageName() + CrashHianalyticsData.TIME)) {
                String a11 = this.f37994e.a(next, "");
                long j11 = 0;
                if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
                    try {
                        j11 = Long.parseLong(a11);
                    } catch (NumberFormatException e11) {
                        Logger.w(f37987i, "convert expire time from String to Long catch NumberFormatException.", (Throwable) e11);
                    }
                }
                String substring = next.substring(0, next.length() - 4);
                String str = substring + HttpHeaders.ETAG;
                if (!b(j11) || !keySet.contains(substring) || !keySet.contains(str)) {
                    Logger.i(f37987i, "init interface auto clear some invalid sp's data: " + next);
                    this.f37994e.a(substring);
                    this.f37994e.a(next);
                    this.f37994e.a(str);
                }
            }
        }
    }

    private boolean b(long j11) {
        return System.currentTimeMillis() - j11 <= Period.WEEK_MILLS;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f37997h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8, TimeUnit.SECONDS).booleanValue();
        } catch (CancellationException unused) {
            Logger.i(f37987i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e11) {
            e = e11;
            str2 = f37987i;
            str = "init compute task failed.";
            Logger.w(str2, str, e);
            return false;
        } catch (InterruptedException e12) {
            e = e12;
            str2 = f37987i;
            str = "init compute task interrupted.";
            Logger.w(str2, str, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f37987i, "init compute task timed out");
            return false;
        } catch (Exception e13) {
            e = e13;
            str2 = f37987i;
            str = "init compute task occur unknown Exception";
            Logger.w(str2, str, e);
            return false;
        }
    }

    public String a(String str, String str2, int i11) {
        if (this.f37990a == null || str == null || str2 == null) {
            Logger.w(f37987i, "invalid para!");
            return null;
        } else if (e()) {
            return this.f37996g.a(str, str2, this.f37991b, i11);
        } else {
            return null;
        }
    }

    public Map<String, String> a(String str, int i11) {
        if (this.f37990a != null && str != null) {
            return e() ? this.f37996g.a(str, this.f37991b, i11) : new HashMap();
        }
        Logger.w(f37987i, "invalid para!");
        return new HashMap();
    }

    public void a() {
        if (e()) {
            String grsParasKey = this.f37990a.getGrsParasKey(true, true, this.f37991b);
            this.f37994e.a(grsParasKey);
            com.huawei.hms.framework.network.grs.e.c cVar = this.f37994e;
            cVar.a(grsParasKey + CrashHianalyticsData.TIME);
            com.huawei.hms.framework.network.grs.e.c cVar2 = this.f37994e;
            cVar2.a(grsParasKey + HttpHeaders.ETAG);
            this.f37992c.a(grsParasKey);
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i11) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f37987i, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.f37990a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f37996g.a(str, iQueryUrlsCallBack, this.f37991b, i11);
        } else {
            Logger.i(f37987i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i11) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f37987i, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.f37990a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f37996g.a(str, str2, iQueryUrlCallBack, this.f37991b, i11);
        } else {
            Logger.i(f37987i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass() || !(obj instanceof c)) {
            return false;
        }
        return this.f37990a.compare(((c) obj).f37990a);
    }

    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.f37990a) == null || (context = this.f37991b) == null) {
            return false;
        }
        this.f37993d.a(grsBaseInfo, context);
        return true;
    }
}
