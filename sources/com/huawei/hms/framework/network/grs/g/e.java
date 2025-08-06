package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

public class e {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f38061a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f38062b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f38063c;

        public a(long j11, ArrayList arrayList, JSONArray jSONArray) {
            this.f38061a = j11;
            this.f38062b = arrayList;
            this.f38063c = jSONArray;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0038 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                com.huawei.hms.framework.network.grs.g.j.a r0 = new com.huawei.hms.framework.network.grs.g.j.a
                r0.<init>()
                long r1 = r6.f38061a
                java.lang.String r3 = "total_time"
                r0.put((java.lang.String) r3, (long) r1)
                java.util.ArrayList r1 = r6.f38062b
                java.util.Iterator r1 = r1.iterator()
            L_0x0012:
                boolean r2 = r1.hasNext()
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0038
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                boolean r5 = r2.o()
                if (r5 != 0) goto L_0x002c
                boolean r5 = r2.m()
                if (r5 == 0) goto L_0x0012
            L_0x002c:
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r2)
                r0.put(r2)
                r1.remove()
                r1 = r4
                goto L_0x0039
            L_0x0038:
                r1 = r3
            L_0x0039:
                if (r1 != 0) goto L_0x005c
                java.util.ArrayList r1 = r6.f38062b
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x005c
                java.util.ArrayList r1 = r6.f38062b
                int r2 = r1.size()
                int r2 = r2 - r4
                java.lang.Object r1 = r1.get(r2)
                com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r1)
                r0.put(r2)
                java.util.ArrayList r2 = r6.f38062b
                r2.remove(r1)
            L_0x005c:
                java.util.ArrayList r1 = r6.f38062b
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0085
                java.util.ArrayList r1 = r6.f38062b
                java.util.Iterator r1 = r1.iterator()
            L_0x006a:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0085
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                org.json.JSONObject r5 = new org.json.JSONObject
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r2)
                r5.<init>(r2)
                org.json.JSONArray r2 = r6.f38063c
                r2.put(r5)
                goto L_0x006a
            L_0x0085:
                org.json.JSONArray r1 = r6.f38063c
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0098
                org.json.JSONArray r1 = r6.f38063c
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "failed_info"
                r0.put((java.lang.String) r2, (java.lang.String) r1)
            L_0x0098:
                java.lang.Object[] r1 = new java.lang.Object[r4]
                org.json.JSONObject r2 = new org.json.JSONObject
                java.util.LinkedHashMap r4 = r0.get()
                r2.<init>(r4)
                r1[r3] = r2
                java.lang.String r2 = "HaReportHelper"
                java.lang.String r3 = "grssdk report data to aiops is: %s"
                com.huawei.hms.framework.common.Logger.d(r2, r3, r1)
                com.huawei.hms.framework.common.hianalytics.HianalyticsHelper r1 = com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance()
                java.util.LinkedHashMap r0 = r0.get()
                java.lang.String r2 = "grs_request"
                r1.onEvent(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.e.a.run():void");
        }
    }

    public static void a(ArrayList<d> arrayList, long j11, JSONArray jSONArray, Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReport(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j11, arrayList, jSONArray));
        }
    }

    /* access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d11 = dVar.d();
        if (d11 != null) {
            linkedHashMapPack.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, (long) ExceptionCode.getErrorCodeFromException(d11));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d11.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d11.getMessage()));
        } else {
            linkedHashMapPack.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, (long) dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, (long) dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e11) {
            Logger.w("HaReportHelper", "report host MalformedURLException", (Throwable) e11);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
