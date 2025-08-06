package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.a;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.d;
import com.huochat.community.network.domain.DomainTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

public class c {

    /* renamed from: l  reason: collision with root package name */
    private static final String f38034l = "c";

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f38035a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f38036b;

    /* renamed from: c  reason: collision with root package name */
    private final a f38037c;

    /* renamed from: d  reason: collision with root package name */
    private d f38038d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Future<d>> f38039e = new ConcurrentHashMap(16);

    /* renamed from: f  reason: collision with root package name */
    private final List<d> f38040f = new CopyOnWriteArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final JSONArray f38041g = new JSONArray();

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f38042h = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.j.c f38043i;

    /* renamed from: j  reason: collision with root package name */
    private String f38044j = "";

    /* renamed from: k  reason: collision with root package name */
    private long f38045k = 1;

    public c(com.huawei.hms.framework.network.grs.g.j.c cVar, a aVar) {
        this.f38043i = cVar;
        this.f38035a = cVar.b();
        this.f38036b = cVar.a();
        this.f38037c = aVar;
        b();
        c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099 A[LOOP:0: B:1:0x0006->B:37:0x0099, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.framework.network.grs.g.d a(java.util.concurrent.ExecutorService r17, java.util.List<java.lang.String> r18, java.lang.String r19, com.huawei.hms.framework.network.grs.e.c r20) {
        /*
            r16 = this;
            r9 = r16
            r10 = 0
            r0 = 0
            r11 = r0
            r12 = r10
        L_0x0006:
            int r0 = r18.size()
            if (r12 >= r0) goto L_0x009d
            r13 = r18
            java.lang.Object r0 = r13.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r14 = 1
            if (r1 != 0) goto L_0x008c
            com.huawei.hms.framework.network.grs.g.a r15 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.f38036b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.f38035a
            r1 = r15
            r2 = r0
            r3 = r12
            r4 = r16
            r6 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r15.g()
            r2 = r17
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.f38039e
            r3.put(r0, r1)
            long r3 = r9.f38045k     // Catch:{ CancellationException -> 0x0084, ExecutionException -> 0x007b, InterruptedException -> 0x0072, TimeoutException -> 0x006a }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x0084, ExecutionException -> 0x007b, InterruptedException -> 0x0072, TimeoutException -> 0x006a }
            java.lang.Object r0 = r1.get(r3, r0)     // Catch:{ CancellationException -> 0x0084, ExecutionException -> 0x007b, InterruptedException -> 0x0072, TimeoutException -> 0x006a }
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1     // Catch:{ CancellationException -> 0x0084, ExecutionException -> 0x007b, InterruptedException -> 0x0072, TimeoutException -> 0x006a }
            if (r1 == 0) goto L_0x0068
            boolean r0 = r1.o()     // Catch:{ CancellationException -> 0x0066, ExecutionException -> 0x0063, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            if (r0 != 0) goto L_0x0055
            boolean r0 = r1.m()     // Catch:{ CancellationException -> 0x0066, ExecutionException -> 0x0063, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            if (r0 == 0) goto L_0x0068
        L_0x0055:
            java.lang.String r0 = f38034l     // Catch:{ CancellationException -> 0x0066, ExecutionException -> 0x0063, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r3)     // Catch:{ CancellationException -> 0x0066, ExecutionException -> 0x0063, InterruptedException -> 0x0060, TimeoutException -> 0x005e }
            r11 = r1
            goto L_0x008f
        L_0x005e:
            r11 = r1
            goto L_0x006a
        L_0x0060:
            r0 = move-exception
            r11 = r1
            goto L_0x0073
        L_0x0063:
            r0 = move-exception
            r11 = r1
            goto L_0x007c
        L_0x0066:
            r11 = r1
            goto L_0x0084
        L_0x0068:
            r11 = r1
            goto L_0x008e
        L_0x006a:
            java.lang.String r0 = f38034l
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r0, r1)
            goto L_0x008e
        L_0x0072:
            r0 = move-exception
        L_0x0073:
            java.lang.String r1 = f38034l
            java.lang.String r3 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r0)
            goto L_0x008f
        L_0x007b:
            r0 = move-exception
        L_0x007c:
            java.lang.String r1 = f38034l
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r0)
            goto L_0x008e
        L_0x0084:
            java.lang.String r0 = f38034l
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            goto L_0x008f
        L_0x008c:
            r2 = r17
        L_0x008e:
            r14 = r10
        L_0x008f:
            if (r14 == 0) goto L_0x0099
            java.lang.String r0 = f38034l
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r0, r1)
            goto L_0x009d
        L_0x0099:
            int r12 = r12 + 1
            goto L_0x0006
        L_0x009d:
            com.huawei.hms.framework.network.grs.g.d r0 = r9.b(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.c.a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    private void a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str);
        String grsReqParamJoint = this.f38035a.getGrsReqParamJoint(false, false, d(), this.f38036b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb2.append("?");
            sb2.append(grsReqParamJoint);
        }
        this.f38042h.add(sb2.toString());
    }

    private d b(d dVar) {
        String str;
        String str2;
        for (Map.Entry next : this.f38039e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = (d) ((Future) next.getValue()).get(40000, TimeUnit.MILLISECONDS);
            } catch (CancellationException unused) {
                Logger.i(f38034l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e11) {
                e = e11;
                str2 = f38034l;
                str = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str2, str, e);
            } catch (InterruptedException e12) {
                e = e12;
                str2 = f38034l;
                str = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str2, str, e);
            } catch (TimeoutException unused2) {
                Logger.w(f38034l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!((Future) next.getValue()).isCancelled()) {
                    ((Future) next.getValue()).cancel(true);
                }
            }
        }
        return dVar;
    }

    private void b() {
        d a11 = com.huawei.hms.framework.network.grs.g.i.a.a(this.f38036b);
        if (a11 == null) {
            Logger.w(f38034l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a11);
        List<String> a12 = a11.a();
        if (a12 == null || a12.size() <= 0) {
            Logger.v(f38034l, "maybe grs_base_url config with [],please check.");
        } else if (a12.size() <= 10) {
            String b11 = a11.b();
            if (a12.size() > 0) {
                for (String next : a12) {
                    if (!next.startsWith(DomainTool.DOMAIN_PREFIX)) {
                        Logger.w(f38034l, "grs server just support https scheme url,please check.");
                    } else {
                        a(b11, next);
                    }
                }
            }
            Logger.v(f38034l, "request to GRS server url is {%s}", this.f38042h);
        } else {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
    }

    private void c() {
        String grsParasKey = this.f38035a.getGrsParasKey(true, true, this.f38036b);
        com.huawei.hms.framework.network.grs.e.c a11 = this.f38037c.a();
        this.f38044j = a11.a(grsParasKey + HttpHeaders.ETAG, "");
    }

    private String d() {
        b a11 = b.a(this.f38036b.getPackageName());
        com.huawei.hms.framework.network.grs.local.model.a a12 = a11 != null ? a11.a() : null;
        if (a12 == null) {
            return "";
        }
        String a13 = a12.a();
        Logger.v(f38034l, "get appName from local assets is{%s}", a13);
        return a13;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        if (this.f38042h.isEmpty()) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d a11 = a(executorService, this.f38042h, str, cVar);
        Logger.i(f38034l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(a11 == null ? 0 : a11.b()));
        e.a(new ArrayList(this.f38040f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f38041g, this.f38036b);
        this.f38040f.clear();
        return a11;
    }

    public String a() {
        return this.f38044j;
    }

    public synchronized void a(d dVar) {
        this.f38040f.add(dVar);
        d dVar2 = this.f38038d;
        if (dVar2 != null && (dVar2.o() || this.f38038d.m())) {
            Logger.v(f38034l, "grsResponseResult is ok");
        } else if (dVar.n()) {
            Logger.i(f38034l, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.f38035a.getGrsParasKey(true, true, this.f38036b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
        } else {
            if (dVar.m()) {
                Logger.i(f38034l, "GRS server open 304 Not Modified.");
            }
            if (dVar.o() || dVar.m()) {
                this.f38038d = dVar;
                this.f38037c.a(this.f38035a, dVar, this.f38036b, this.f38043i);
                for (Map.Entry next : this.f38039e.entrySet()) {
                    if (!((String) next.getKey()).equals(dVar.l()) && !((Future) next.getValue()).isCancelled()) {
                        Logger.i(f38034l, "future cancel");
                        ((Future) next.getValue()).cancel(true);
                    }
                }
                return;
            }
            Logger.v(f38034l, "grsResponseResult has exception so need return");
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d dVar) {
    }
}
