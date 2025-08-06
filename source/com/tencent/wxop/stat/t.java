package com.tencent.wxop.stat;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class t {
    /* access modifiers changed from: private */
    public static b bZ = l.av();

    /* renamed from: ca  reason: collision with root package name */
    private static Context f51086ca = null;

    /* renamed from: cb  reason: collision with root package name */
    private static t f51087cb = null;
    public volatile int aI = 0;

    /* renamed from: ab  reason: collision with root package name */
    private String f51088ab = "";
    private ac bW = null;
    private ac bX = null;
    public c bY = null;

    /* renamed from: be  reason: collision with root package name */
    private f f51089be = null;

    /* renamed from: bq  reason: collision with root package name */
    private String f51090bq = "";

    /* renamed from: cc  reason: collision with root package name */
    private int f51091cc = 0;

    /* renamed from: cd  reason: collision with root package name */
    private ConcurrentHashMap<d, String> f51092cd = null;

    /* renamed from: ce  reason: collision with root package name */
    private boolean f51093ce = false;

    /* renamed from: cf  reason: collision with root package name */
    private HashMap<String, String> f51094cf = new HashMap<>();

    private t(Context context) {
        try {
            this.f51089be = new f();
            f51086ca = context.getApplicationContext();
            this.f51092cd = new ConcurrentHashMap<>();
            this.f51088ab = l.J(context);
            this.f51090bq = "pri_" + l.J(context);
            this.bW = new ac(f51086ca, this.f51088ab);
            this.bX = new ac(f51086ca, this.f51090bq);
            b(true);
            b(false);
            aj();
            t(f51086ca);
            I();
            an();
        } catch (Throwable th2) {
            bZ.b(th2);
        }
    }

    private void I() {
        Cursor cursor = null;
        try {
            Cursor query = this.bW.getReadableDatabase().query(TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                int i11 = query.getInt(0);
                String string = query.getString(1);
                String string2 = query.getString(2);
                int i12 = query.getInt(3);
                ah ahVar = new ah(i11);
                ahVar.aI = i11;
                ahVar.f50967df = new JSONObject(string);
                ahVar.f50966c = string2;
                ahVar.L = i12;
                c.a(f51086ca, ahVar);
            }
            query.close();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(int r4, boolean r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r3.aI     // Catch:{ all -> 0x0074 }
            if (r0 <= 0) goto L_0x0072
            if (r4 <= 0) goto L_0x0072
            boolean r0 = com.tencent.wxop.stat.e.a()     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x000e
            goto L_0x0072
        L_0x000e:
            boolean r0 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x002e
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Load "
            r1.<init>(r2)     // Catch:{ all -> 0x0074 }
            int r2 = r3.aI     // Catch:{ all -> 0x0074 }
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = " unsent events"
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            r0.b((java.lang.Object) r1)     // Catch:{ all -> 0x0074 }
        L_0x002e:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0074 }
            r0.<init>(r4)     // Catch:{ all -> 0x0074 }
            r3.b(r0, r4, r5)     // Catch:{ all -> 0x0074 }
            int r4 = r0.size()     // Catch:{ all -> 0x0074 }
            if (r4 <= 0) goto L_0x0070
            boolean r4 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x0074 }
            if (r4 == 0) goto L_0x005e
            com.tencent.wxop.stat.b.b r4 = bZ     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Peek "
            r1.<init>(r2)     // Catch:{ all -> 0x0074 }
            int r2 = r0.size()     // Catch:{ all -> 0x0074 }
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = " unsent events."
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            r4.b((java.lang.Object) r1)     // Catch:{ all -> 0x0074 }
        L_0x005e:
            r4 = 2
            r3.a((java.util.List<com.tencent.wxop.stat.ad>) r0, (int) r4, (boolean) r5)     // Catch:{ all -> 0x0074 }
            android.content.Context r4 = f51086ca     // Catch:{ all -> 0x0074 }
            com.tencent.wxop.stat.ak r4 = com.tencent.wxop.stat.ak.Z(r4)     // Catch:{ all -> 0x0074 }
            com.tencent.wxop.stat.aa r1 = new com.tencent.wxop.stat.aa     // Catch:{ all -> 0x0074 }
            r1.<init>(r3, r0, r5)     // Catch:{ all -> 0x0074 }
            r4.b(r0, r1)     // Catch:{ all -> 0x0074 }
        L_0x0070:
            monitor-exit(r3)
            return
        L_0x0072:
            monitor-exit(r3)
            return
        L_0x0074:
            r4 = move-exception
            com.tencent.wxop.stat.b.b r5 = bZ     // Catch:{ all -> 0x007c }
            r5.b((java.lang.Throwable) r4)     // Catch:{ all -> 0x007c }
            monitor-exit(r3)
            return
        L_0x007c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0104, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0 = bZ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0168, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0169, code lost:
        if (r0 != null) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        bZ.b(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0177, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:34:0x0100, B:44:0x0111, B:67:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0118 A[SYNTHETIC, Splitter:B:47:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0126 A[Catch:{ all -> 0x0168, all -> 0x016f, all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014f A[SYNTHETIC, Splitter:B:61:0x014f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.tencent.wxop.stat.a.d r7, com.tencent.wxop.stat.aj r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = com.tencent.wxop.stat.c.s()     // Catch:{ all -> 0x0178 }
            if (r0 <= 0) goto L_0x0176
            int r0 = com.tencent.wxop.stat.c.f51055ay     // Catch:{ all -> 0x0178 }
            if (r0 <= 0) goto L_0x0082
            if (r9 != 0) goto L_0x0082
            if (r10 == 0) goto L_0x0010
            goto L_0x0082
        L_0x0010:
            if (r0 <= 0) goto L_0x0176
            boolean r9 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x0178 }
            if (r9 == 0) goto L_0x005c
            com.tencent.wxop.stat.b.b r9 = bZ     // Catch:{ all -> 0x0178 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            java.lang.String r0 = "cacheEventsInMemory.size():"
            r10.<init>(r0)     // Catch:{ all -> 0x0178 }
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r0 = r6.f51092cd     // Catch:{ all -> 0x0178 }
            int r0 = r0.size()     // Catch:{ all -> 0x0178 }
            r10.append(r0)     // Catch:{ all -> 0x0178 }
            java.lang.String r0 = ",numEventsCachedInMemory:"
            r10.append(r0)     // Catch:{ all -> 0x0178 }
            int r0 = com.tencent.wxop.stat.c.f51055ay     // Catch:{ all -> 0x0178 }
            r10.append(r0)     // Catch:{ all -> 0x0178 }
            java.lang.String r0 = ",numStoredEvents:"
            r10.append(r0)     // Catch:{ all -> 0x0178 }
            int r0 = r6.aI     // Catch:{ all -> 0x0178 }
            r10.append(r0)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0178 }
            r9.b((java.lang.Object) r10)     // Catch:{ all -> 0x0178 }
            com.tencent.wxop.stat.b.b r9 = bZ     // Catch:{ all -> 0x0178 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            java.lang.String r0 = "cache event:"
            r10.<init>(r0)     // Catch:{ all -> 0x0178 }
            java.lang.String r0 = r7.af()     // Catch:{ all -> 0x0178 }
            r10.append(r0)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0178 }
            r9.b((java.lang.Object) r10)     // Catch:{ all -> 0x0178 }
        L_0x005c:
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r9 = r6.f51092cd     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = ""
            r9.put(r7, r10)     // Catch:{ all -> 0x0178 }
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r7 = r6.f51092cd     // Catch:{ all -> 0x0178 }
            int r7 = r7.size()     // Catch:{ all -> 0x0178 }
            int r9 = com.tencent.wxop.stat.c.f51055ay     // Catch:{ all -> 0x0178 }
            if (r7 < r9) goto L_0x0070
            r6.am()     // Catch:{ all -> 0x0178 }
        L_0x0070:
            if (r8 == 0) goto L_0x0176
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r7 = r6.f51092cd     // Catch:{ all -> 0x0178 }
            int r7 = r7.size()     // Catch:{ all -> 0x0178 }
            if (r7 <= 0) goto L_0x007d
            r6.am()     // Catch:{ all -> 0x0178 }
        L_0x007d:
            r8.ah()     // Catch:{ all -> 0x0178 }
            goto L_0x0176
        L_0x0082:
            r10 = 1
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r6.c(r9)     // Catch:{ all -> 0x010e }
            r1.beginTransaction()     // Catch:{ all -> 0x010b }
            if (r9 != 0) goto L_0x00af
            int r9 = r6.aI     // Catch:{ all -> 0x010b }
            int r2 = com.tencent.wxop.stat.c.s()     // Catch:{ all -> 0x010b }
            if (r9 <= r2) goto L_0x00af
            com.tencent.wxop.stat.b.b r9 = bZ     // Catch:{ all -> 0x010b }
            java.lang.String r2 = "Too many events stored in db."
            r9.warn(r2)     // Catch:{ all -> 0x010b }
            int r9 = r6.aI     // Catch:{ all -> 0x010b }
            com.tencent.wxop.stat.ac r2 = r6.bW     // Catch:{ all -> 0x010b }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "events"
            java.lang.String r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)"
            int r2 = r2.delete(r3, r4, r0)     // Catch:{ all -> 0x010b }
            int r9 = r9 - r2
            r6.aI = r9     // Catch:{ all -> 0x010b }
        L_0x00af:
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x010b }
            r9.<init>()     // Catch:{ all -> 0x010b }
            java.lang.String r2 = r7.af()     // Catch:{ all -> 0x010b }
            boolean r3 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x010b }
            if (r3 == 0) goto L_0x00d1
            com.tencent.wxop.stat.b.b r3 = bZ     // Catch:{ all -> 0x010b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x010b }
            java.lang.String r5 = "insert 1 event, content:"
            r4.<init>(r5)     // Catch:{ all -> 0x010b }
            r4.append(r2)     // Catch:{ all -> 0x010b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x010b }
            r3.b((java.lang.Object) r4)     // Catch:{ all -> 0x010b }
        L_0x00d1:
            java.lang.String r2 = com.tencent.wxop.stat.b.r.q(r2)     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "content"
            r9.put(r3, r2)     // Catch:{ all -> 0x010b }
            java.lang.String r2 = "send_count"
            java.lang.String r3 = "0"
            r9.put(r2, r3)     // Catch:{ all -> 0x010b }
            java.lang.String r2 = "status"
            java.lang.String r3 = java.lang.Integer.toString(r10)     // Catch:{ all -> 0x010b }
            r9.put(r2, r3)     // Catch:{ all -> 0x010b }
            java.lang.String r2 = "timestamp"
            long r3 = r7.ad()     // Catch:{ all -> 0x010b }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x010b }
            r9.put(r2, r3)     // Catch:{ all -> 0x010b }
            java.lang.String r2 = "events"
            long r2 = r1.insert(r2, r0, r9)     // Catch:{ all -> 0x010b }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x010b }
            r1.endTransaction()     // Catch:{ all -> 0x0104 }
            goto L_0x0120
        L_0x0104:
            r9 = move-exception
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x0178 }
        L_0x0107:
            r0.b((java.lang.Throwable) r9)     // Catch:{ all -> 0x0178 }
            goto L_0x0120
        L_0x010b:
            r9 = move-exception
            r0 = r1
            goto L_0x010f
        L_0x010e:
            r9 = move-exception
        L_0x010f:
            r2 = -1
            com.tencent.wxop.stat.b.b r1 = bZ     // Catch:{ all -> 0x0168 }
            r1.b((java.lang.Throwable) r9)     // Catch:{ all -> 0x0168 }
            if (r0 == 0) goto L_0x0120
            r0.endTransaction()     // Catch:{ all -> 0x011c }
            goto L_0x0120
        L_0x011c:
            r9 = move-exception
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x0178 }
            goto L_0x0107
        L_0x0120:
            r0 = 0
            int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r9 <= 0) goto L_0x014f
            int r9 = r6.aI     // Catch:{ all -> 0x0178 }
            int r9 = r9 + r10
            r6.aI = r9     // Catch:{ all -> 0x0178 }
            boolean r9 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x0178 }
            if (r9 == 0) goto L_0x0148
            com.tencent.wxop.stat.b.b r9 = bZ     // Catch:{ all -> 0x0178 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            java.lang.String r0 = "directStoreEvent insert event to db, event:"
            r10.<init>(r0)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r7.af()     // Catch:{ all -> 0x0178 }
            r10.append(r7)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x0178 }
            r9.e(r7)     // Catch:{ all -> 0x0178 }
        L_0x0148:
            if (r8 == 0) goto L_0x0166
            r8.ah()     // Catch:{ all -> 0x0178 }
            monitor-exit(r6)
            return
        L_0x014f:
            com.tencent.wxop.stat.b.b r8 = bZ     // Catch:{ all -> 0x0178 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "Failed to store event:"
            r9.<init>(r10)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r7.af()     // Catch:{ all -> 0x0178 }
            r9.append(r7)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x0178 }
            r8.error(r7)     // Catch:{ all -> 0x0178 }
        L_0x0166:
            monitor-exit(r6)
            return
        L_0x0168:
            r7 = move-exception
            if (r0 == 0) goto L_0x0175
            r0.endTransaction()     // Catch:{ all -> 0x016f }
            goto L_0x0175
        L_0x016f:
            r8 = move-exception
            com.tencent.wxop.stat.b.b r9 = bZ     // Catch:{ all -> 0x0178 }
            r9.b((java.lang.Throwable) r8)     // Catch:{ all -> 0x0178 }
        L_0x0175:
            throw r7     // Catch:{ all -> 0x0178 }
        L_0x0176:
            monitor-exit(r6)
            return
        L_0x0178:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(com.tencent.wxop.stat.a.d, com.tencent.wxop.stat.aj, boolean, boolean):void");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:44|(2:46|47)|48|49|51|52) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0102 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e0 A[SYNTHETIC, Splitter:B:35:0x00e0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.tencent.wxop.stat.ah r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            org.json.JSONObject r1 = r13.f50967df     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = com.tencent.wxop.stat.b.l.t(r1)     // Catch:{ all -> 0x00d8 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x00d8 }
            r3.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "content"
            org.json.JSONObject r5 = r13.f50967df     // Catch:{ all -> 0x00d8 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00d8 }
            r3.put(r4, r5)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "md5sum"
            r3.put(r4, r2)     // Catch:{ all -> 0x00d8 }
            r13.f50966c = r2     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "version"
            int r4 = r13.L     // Catch:{ all -> 0x00d8 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00d8 }
            r3.put(r2, r4)     // Catch:{ all -> 0x00d8 }
            com.tencent.wxop.stat.ac r2 = r12.bW     // Catch:{ all -> 0x00d8 }
            android.database.sqlite.SQLiteDatabase r4 = r2.getReadableDatabase()     // Catch:{ all -> 0x00d8 }
            java.lang.String r5 = "config"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00d8 }
        L_0x0040:
            boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x00d5 }
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0052
            int r4 = r2.getInt(r6)     // Catch:{ all -> 0x00d5 }
            int r7 = r13.aI     // Catch:{ all -> 0x00d5 }
            if (r4 != r7) goto L_0x0040
            r4 = r5
            goto L_0x0053
        L_0x0052:
            r4 = r6
        L_0x0053:
            com.tencent.wxop.stat.ac r7 = r12.bW     // Catch:{ all -> 0x00d5 }
            android.database.sqlite.SQLiteDatabase r7 = r7.getWritableDatabase()     // Catch:{ all -> 0x00d5 }
            r7.beginTransaction()     // Catch:{ all -> 0x00d5 }
            if (r5 != r4) goto L_0x0078
            com.tencent.wxop.stat.ac r0 = r12.bW     // Catch:{ all -> 0x00d5 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = "config"
            java.lang.String r7 = "type=?"
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x00d5 }
            int r13 = r13.aI     // Catch:{ all -> 0x00d5 }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x00d5 }
            r5[r6] = r13     // Catch:{ all -> 0x00d5 }
            int r13 = r0.update(r4, r3, r7, r5)     // Catch:{ all -> 0x00d5 }
            long r3 = (long) r13     // Catch:{ all -> 0x00d5 }
            goto L_0x008f
        L_0x0078:
            java.lang.String r4 = "type"
            int r13 = r13.aI     // Catch:{ all -> 0x00d5 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x00d5 }
            r3.put(r4, r13)     // Catch:{ all -> 0x00d5 }
            com.tencent.wxop.stat.ac r13 = r12.bW     // Catch:{ all -> 0x00d5 }
            android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = "config"
            long r3 = r13.insert(r4, r0, r3)     // Catch:{ all -> 0x00d5 }
        L_0x008f:
            r5 = -1
            int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x00a9
            com.tencent.wxop.stat.b.b r13 = bZ     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Failed to store cfg:"
            r0.<init>(r3)     // Catch:{ all -> 0x00d5 }
            r0.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d5 }
            r13.d(r0)     // Catch:{ all -> 0x00d5 }
            goto L_0x00bc
        L_0x00a9:
            com.tencent.wxop.stat.b.b r13 = bZ     // Catch:{ all -> 0x00d5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Sucessed to store cfg:"
            r0.<init>(r3)     // Catch:{ all -> 0x00d5 }
            r0.append(r1)     // Catch:{ all -> 0x00d5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d5 }
            r13.e(r0)     // Catch:{ all -> 0x00d5 }
        L_0x00bc:
            com.tencent.wxop.stat.ac r13 = r12.bW     // Catch:{ all -> 0x00d5 }
            android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ all -> 0x00d5 }
            r13.setTransactionSuccessful()     // Catch:{ all -> 0x00d5 }
            r2.close()     // Catch:{ all -> 0x0100 }
            com.tencent.wxop.stat.ac r13 = r12.bW     // Catch:{ Exception -> 0x00d3 }
            android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ Exception -> 0x00d3 }
            r13.endTransaction()     // Catch:{ Exception -> 0x00d3 }
            monitor-exit(r12)
            return
        L_0x00d3:
            monitor-exit(r12)
            return
        L_0x00d5:
            r13 = move-exception
            r0 = r2
            goto L_0x00d9
        L_0x00d8:
            r13 = move-exception
        L_0x00d9:
            com.tencent.wxop.stat.b.b r1 = bZ     // Catch:{ all -> 0x00f0 }
            r1.b((java.lang.Throwable) r13)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00e3
            r0.close()     // Catch:{ all -> 0x0100 }
        L_0x00e3:
            com.tencent.wxop.stat.ac r13 = r12.bW     // Catch:{ Exception -> 0x00ee }
            android.database.sqlite.SQLiteDatabase r13 = r13.getWritableDatabase()     // Catch:{ Exception -> 0x00ee }
            r13.endTransaction()     // Catch:{ Exception -> 0x00ee }
            monitor-exit(r12)
            return
        L_0x00ee:
            monitor-exit(r12)
            return
        L_0x00f0:
            r13 = move-exception
            if (r0 == 0) goto L_0x00f6
            r0.close()     // Catch:{ all -> 0x0100 }
        L_0x00f6:
            com.tencent.wxop.stat.ac r0 = r12.bW     // Catch:{ Exception -> 0x0102 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x0102 }
            r0.endTransaction()     // Catch:{ Exception -> 0x0102 }
            goto L_0x0102
        L_0x0100:
            r13 = move-exception
            goto L_0x0103
        L_0x0102:
            throw r13     // Catch:{ all -> 0x0100 }
        L_0x0103:
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(com.tencent.wxop.stat.ah):void");
    }

    public static /* synthetic */ void a(t tVar, int i11, boolean z11) {
        if (i11 == -1) {
            i11 = !z11 ? tVar.ak() : tVar.al();
        }
        if (i11 > 0) {
            int u11 = c.u() * 60 * c.q();
            if (i11 > u11 && u11 > 0) {
                i11 = u11;
            }
            int r11 = c.r();
            int i12 = i11 / r11;
            int i13 = i11 % r11;
            if (c.k()) {
                b bVar = bZ;
                bVar.b((Object) "sentStoreEventsByDb sendNumbers=" + i11 + ",important=" + z11 + ",maxSendNumPerFor1Period=" + u11 + ",maxCount=" + i12 + ",restNumbers=" + i13);
            }
            for (int i14 = 0; i14 < i12; i14++) {
                tVar.a(r11, z11);
            }
            if (i13 > 0) {
                tVar.a(i13, z11);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        bZ.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cf, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d0, code lost:
        if (r1 != 0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        bZ.b(r6);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:28:0x00a8, B:40:0x00b9, B:56:0x00d2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0 A[SYNTHETIC, Splitter:B:43:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cd A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List<com.tencent.wxop.stat.ad> r5, int r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r5.size()     // Catch:{ all -> 0x00dd }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            if (r7 != 0) goto L_0x0010
            int r0 = com.tencent.wxop.stat.c.p()     // Catch:{ all -> 0x00dd }
            goto L_0x0014
        L_0x0010:
            int r0 = com.tencent.wxop.stat.c.n()     // Catch:{ all -> 0x00dd }
        L_0x0014:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r7 = r4.c(r7)     // Catch:{ all -> 0x00b8 }
            r2 = 2
            if (r6 != r2) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "update events set status="
            r0.<init>(r2)     // Catch:{ all -> 0x00b5 }
            r0.append(r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = ", send_count=send_count+1  where "
            r0.append(r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = b((java.util.List<com.tencent.wxop.stat.ad>) r5)     // Catch:{ all -> 0x00b5 }
            r0.append(r5)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00b5 }
            goto L_0x006b
        L_0x0037:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "update events set status="
            r2.<init>(r3)     // Catch:{ all -> 0x00b5 }
            r2.append(r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = " where "
            r2.append(r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = b((java.util.List<com.tencent.wxop.stat.ad>) r5)     // Catch:{ all -> 0x00b5 }
            r2.append(r5)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00b5 }
            int r6 = r4.f51091cc     // Catch:{ all -> 0x00b5 }
            int r6 = r6 % 3
            if (r6 != 0) goto L_0x0065
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = "delete from events where send_count>"
            r6.<init>(r1)     // Catch:{ all -> 0x00b5 }
            r6.append(r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x00b5 }
        L_0x0065:
            int r6 = r4.f51091cc     // Catch:{ all -> 0x00b5 }
            int r6 = r6 + 1
            r4.f51091cc = r6     // Catch:{ all -> 0x00b5 }
        L_0x006b:
            boolean r6 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x00b5 }
            if (r6 == 0) goto L_0x0084
            com.tencent.wxop.stat.b.b r6 = bZ     // Catch:{ all -> 0x00b5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "update sql:"
            r0.<init>(r2)     // Catch:{ all -> 0x00b5 }
            r0.append(r5)     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b5 }
            r6.b((java.lang.Object) r0)     // Catch:{ all -> 0x00b5 }
        L_0x0084:
            r7.beginTransaction()     // Catch:{ all -> 0x00b5 }
            r7.execSQL(r5)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00a5
            com.tencent.wxop.stat.b.b r5 = bZ     // Catch:{ all -> 0x00b5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = "update for delete sql:"
            r6.<init>(r0)     // Catch:{ all -> 0x00b5 }
            r6.append(r1)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b5 }
            r5.b((java.lang.Object) r6)     // Catch:{ all -> 0x00b5 }
            r7.execSQL(r1)     // Catch:{ all -> 0x00b5 }
            r4.aj()     // Catch:{ all -> 0x00b5 }
        L_0x00a5:
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x00b5 }
            r7.endTransaction()     // Catch:{ all -> 0x00ad }
            monitor-exit(r4)
            return
        L_0x00ad:
            r5 = move-exception
            com.tencent.wxop.stat.b.b r6 = bZ     // Catch:{ all -> 0x00dd }
            r6.b((java.lang.Throwable) r5)     // Catch:{ all -> 0x00dd }
            monitor-exit(r4)
            return
        L_0x00b5:
            r5 = move-exception
            r1 = r7
            goto L_0x00b9
        L_0x00b8:
            r5 = move-exception
        L_0x00b9:
            com.tencent.wxop.stat.b.b r6 = bZ     // Catch:{ all -> 0x00cf }
            r6.b((java.lang.Throwable) r5)     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x00cd
            r1.endTransaction()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r4)
            return
        L_0x00c5:
            r5 = move-exception
            com.tencent.wxop.stat.b.b r6 = bZ     // Catch:{ all -> 0x00dd }
            r6.b((java.lang.Throwable) r5)     // Catch:{ all -> 0x00dd }
            monitor-exit(r4)
            return
        L_0x00cd:
            monitor-exit(r4)
            return
        L_0x00cf:
            r5 = move-exception
            if (r1 == 0) goto L_0x00dc
            r1.endTransaction()     // Catch:{ all -> 0x00d6 }
            goto L_0x00dc
        L_0x00d6:
            r6 = move-exception
            com.tencent.wxop.stat.b.b r7 = bZ     // Catch:{ all -> 0x00dd }
            r7.b((java.lang.Throwable) r6)     // Catch:{ all -> 0x00dd }
        L_0x00dc:
            throw r5     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(java.util.List, int, boolean):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        bZ.b(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bf, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dc, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        if (r8 != null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e3, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        bZ.b(r8);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:26:0x00b3, B:38:0x00c6, B:54:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cd A[SYNTHETIC, Splitter:B:41:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00da A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List<com.tencent.wxop.stat.ad> r7, boolean r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r7.size()     // Catch:{ all -> 0x00ea }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r6)
            return
        L_0x0009:
            boolean r0 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x00ea }
            if (r0 == 0) goto L_0x002e
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x00ea }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = "Delete "
            r1.<init>(r2)     // Catch:{ all -> 0x00ea }
            int r2 = r7.size()     // Catch:{ all -> 0x00ea }
            r1.append(r2)     // Catch:{ all -> 0x00ea }
            java.lang.String r2 = " events, important:"
            r1.append(r2)     // Catch:{ all -> 0x00ea }
            r1.append(r8)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ea }
            r0.b((java.lang.Object) r1)     // Catch:{ all -> 0x00ea }
        L_0x002e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            int r1 = r7.size()     // Catch:{ all -> 0x00ea }
            int r1 = r1 * 3
            r0.<init>(r1)     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = "event_id in ("
            r0.append(r1)     // Catch:{ all -> 0x00ea }
            r1 = 0
            int r2 = r7.size()     // Catch:{ all -> 0x00ea }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00ea }
        L_0x0047:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x0064
            java.lang.Object r3 = r7.next()     // Catch:{ all -> 0x00ea }
            com.tencent.wxop.stat.ad r3 = (com.tencent.wxop.stat.ad) r3     // Catch:{ all -> 0x00ea }
            long r3 = r3.K     // Catch:{ all -> 0x00ea }
            r0.append(r3)     // Catch:{ all -> 0x00ea }
            int r3 = r2 + -1
            if (r1 == r3) goto L_0x0061
            java.lang.String r3 = ","
            r0.append(r3)     // Catch:{ all -> 0x00ea }
        L_0x0061:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x0064:
            java.lang.String r7 = ")"
            r0.append(r7)     // Catch:{ all -> 0x00ea }
            r7 = 0
            android.database.sqlite.SQLiteDatabase r8 = r6.c(r8)     // Catch:{ all -> 0x00c2 }
            r8.beginTransaction()     // Catch:{ all -> 0x00c0 }
            java.lang.String r1 = "events"
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x00c0 }
            int r7 = r8.delete(r1, r3, r7)     // Catch:{ all -> 0x00c0 }
            boolean r1 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x00a8
            com.tencent.wxop.stat.b.b r1 = bZ     // Catch:{ all -> 0x00c0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = "delete "
            r3.<init>(r4)     // Catch:{ all -> 0x00c0 }
            r3.append(r2)     // Catch:{ all -> 0x00c0 }
            java.lang.String r2 = " event "
            r3.append(r2)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c0 }
            r3.append(r0)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = ", success delete:"
            r3.append(r0)     // Catch:{ all -> 0x00c0 }
            r3.append(r7)     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00c0 }
            r1.b((java.lang.Object) r0)     // Catch:{ all -> 0x00c0 }
        L_0x00a8:
            int r0 = r6.aI     // Catch:{ all -> 0x00c0 }
            int r0 = r0 - r7
            r6.aI = r0     // Catch:{ all -> 0x00c0 }
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x00c0 }
            r6.aj()     // Catch:{ all -> 0x00c0 }
            r8.endTransaction()     // Catch:{ all -> 0x00b8 }
            monitor-exit(r6)
            return
        L_0x00b8:
            r7 = move-exception
            com.tencent.wxop.stat.b.b r8 = bZ     // Catch:{ all -> 0x00ea }
            r8.b((java.lang.Throwable) r7)     // Catch:{ all -> 0x00ea }
            monitor-exit(r6)
            return
        L_0x00c0:
            r7 = move-exception
            goto L_0x00c6
        L_0x00c2:
            r8 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x00c6:
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x00dc }
            r0.b((java.lang.Throwable) r7)     // Catch:{ all -> 0x00dc }
            if (r8 == 0) goto L_0x00da
            r8.endTransaction()     // Catch:{ all -> 0x00d2 }
            monitor-exit(r6)
            return
        L_0x00d2:
            r7 = move-exception
            com.tencent.wxop.stat.b.b r8 = bZ     // Catch:{ all -> 0x00ea }
            r8.b((java.lang.Throwable) r7)     // Catch:{ all -> 0x00ea }
            monitor-exit(r6)
            return
        L_0x00da:
            monitor-exit(r6)
            return
        L_0x00dc:
            r7 = move-exception
            if (r8 == 0) goto L_0x00e9
            r8.endTransaction()     // Catch:{ all -> 0x00e3 }
            goto L_0x00e9
        L_0x00e3:
            r8 = move-exception
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x00ea }
            r0.b((java.lang.Throwable) r8)     // Catch:{ all -> 0x00ea }
        L_0x00e9:
            throw r7     // Catch:{ all -> 0x00ea }
        L_0x00ea:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.a(java.util.List, boolean):void");
    }

    public static t ai() {
        return f51087cb;
    }

    private void aj() {
        this.aI = ak() + al();
    }

    private int ak() {
        return (int) DatabaseUtils.queryNumEntries(this.bW.getReadableDatabase(), DbParams.TABLE_EVENTS);
    }

    private int al() {
        return (int) DatabaseUtils.queryNumEntries(this.bX.getReadableDatabase(), DbParams.TABLE_EVENTS);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c9, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2 = bZ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011f, code lost:
        if (r2 != null) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r2.endTransaction();
        aj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0128, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        bZ.b(r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:25:0x00c2, B:34:0x00d4, B:49:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00db A[SYNTHETIC, Splitter:B:37:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ef A[Catch:{ all -> 0x011e, all -> 0x0128, all -> 0x00c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void am() {
        /*
            r11 = this;
            boolean r0 = r11.f51093ce
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r0 = r11.f51092cd
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r1 = r11.f51092cd     // Catch:{ all -> 0x012f }
            int r1 = r1.size()     // Catch:{ all -> 0x012f }
            if (r1 != 0) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x012f }
            return
        L_0x0012:
            r1 = 1
            r11.f51093ce = r1     // Catch:{ all -> 0x012f }
            boolean r2 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x012f }
            if (r2 == 0) goto L_0x0048
            com.tencent.wxop.stat.b.b r2 = bZ     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            java.lang.String r4 = "insert "
            r3.<init>(r4)     // Catch:{ all -> 0x012f }
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r4 = r11.f51092cd     // Catch:{ all -> 0x012f }
            int r4 = r4.size()     // Catch:{ all -> 0x012f }
            r3.append(r4)     // Catch:{ all -> 0x012f }
            java.lang.String r4 = " events ,numEventsCachedInMemory:"
            r3.append(r4)     // Catch:{ all -> 0x012f }
            int r4 = com.tencent.wxop.stat.c.f51055ay     // Catch:{ all -> 0x012f }
            r3.append(r4)     // Catch:{ all -> 0x012f }
            java.lang.String r4 = ",numStoredEvents:"
            r3.append(r4)     // Catch:{ all -> 0x012f }
            int r4 = r11.aI     // Catch:{ all -> 0x012f }
            r3.append(r4)     // Catch:{ all -> 0x012f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x012f }
            r2.b((java.lang.Object) r3)     // Catch:{ all -> 0x012f }
        L_0x0048:
            r2 = 0
            com.tencent.wxop.stat.ac r3 = r11.bW     // Catch:{ all -> 0x00d3 }
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch:{ all -> 0x00d3 }
            r3.beginTransaction()     // Catch:{ all -> 0x00d0 }
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r4 = r11.f51092cd     // Catch:{ all -> 0x00d0 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x00d0 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00d0 }
        L_0x005c:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00d0 }
            if (r5 == 0) goto L_0x00bf
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00d0 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00d0 }
            java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x00d0 }
            com.tencent.wxop.stat.a.d r5 = (com.tencent.wxop.stat.a.d) r5     // Catch:{ all -> 0x00d0 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x00d0 }
            r6.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r7 = r5.af()     // Catch:{ all -> 0x00d0 }
            boolean r8 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x00d0 }
            if (r8 == 0) goto L_0x0090
            com.tencent.wxop.stat.b.b r8 = bZ     // Catch:{ all -> 0x00d0 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            java.lang.String r10 = "insert content:"
            r9.<init>(r10)     // Catch:{ all -> 0x00d0 }
            r9.append(r7)     // Catch:{ all -> 0x00d0 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00d0 }
            r8.b((java.lang.Object) r9)     // Catch:{ all -> 0x00d0 }
        L_0x0090:
            java.lang.String r7 = com.tencent.wxop.stat.b.r.q(r7)     // Catch:{ all -> 0x00d0 }
            java.lang.String r8 = "content"
            r6.put(r8, r7)     // Catch:{ all -> 0x00d0 }
            java.lang.String r7 = "send_count"
            java.lang.String r8 = "0"
            r6.put(r7, r8)     // Catch:{ all -> 0x00d0 }
            java.lang.String r7 = "status"
            java.lang.String r8 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x00d0 }
            r6.put(r7, r8)     // Catch:{ all -> 0x00d0 }
            java.lang.String r7 = "timestamp"
            long r8 = r5.ad()     // Catch:{ all -> 0x00d0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00d0 }
            r6.put(r7, r5)     // Catch:{ all -> 0x00d0 }
            java.lang.String r5 = "events"
            r3.insert(r5, r2, r6)     // Catch:{ all -> 0x00d0 }
            r4.remove()     // Catch:{ all -> 0x00d0 }
            goto L_0x005c
        L_0x00bf:
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x00d0 }
            r3.endTransaction()     // Catch:{ all -> 0x00c9 }
            r11.aj()     // Catch:{ all -> 0x00c9 }
            goto L_0x00e6
        L_0x00c9:
            r1 = move-exception
            com.tencent.wxop.stat.b.b r2 = bZ     // Catch:{ all -> 0x012f }
        L_0x00cc:
            r2.b((java.lang.Throwable) r1)     // Catch:{ all -> 0x012f }
            goto L_0x00e6
        L_0x00d0:
            r1 = move-exception
            r2 = r3
            goto L_0x00d4
        L_0x00d3:
            r1 = move-exception
        L_0x00d4:
            com.tencent.wxop.stat.b.b r3 = bZ     // Catch:{ all -> 0x011e }
            r3.b((java.lang.Throwable) r1)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00e6
            r2.endTransaction()     // Catch:{ all -> 0x00e2 }
            r11.aj()     // Catch:{ all -> 0x00e2 }
            goto L_0x00e6
        L_0x00e2:
            r1 = move-exception
            com.tencent.wxop.stat.b.b r2 = bZ     // Catch:{ all -> 0x012f }
            goto L_0x00cc
        L_0x00e6:
            r1 = 0
            r11.f51093ce = r1     // Catch:{ all -> 0x012f }
            boolean r1 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x012f }
            if (r1 == 0) goto L_0x011c
            com.tencent.wxop.stat.b.b r1 = bZ     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            java.lang.String r3 = "after insert, cacheEventsInMemory.size():"
            r2.<init>(r3)     // Catch:{ all -> 0x012f }
            java.util.concurrent.ConcurrentHashMap<com.tencent.wxop.stat.a.d, java.lang.String> r3 = r11.f51092cd     // Catch:{ all -> 0x012f }
            int r3 = r3.size()     // Catch:{ all -> 0x012f }
            r2.append(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r3 = ",numEventsCachedInMemory:"
            r2.append(r3)     // Catch:{ all -> 0x012f }
            int r3 = com.tencent.wxop.stat.c.f51055ay     // Catch:{ all -> 0x012f }
            r2.append(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r3 = ",numStoredEvents:"
            r2.append(r3)     // Catch:{ all -> 0x012f }
            int r3 = r11.aI     // Catch:{ all -> 0x012f }
            r2.append(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x012f }
            r1.b((java.lang.Object) r2)     // Catch:{ all -> 0x012f }
        L_0x011c:
            monitor-exit(r0)     // Catch:{ all -> 0x012f }
            return
        L_0x011e:
            r1 = move-exception
            if (r2 == 0) goto L_0x012e
            r2.endTransaction()     // Catch:{ all -> 0x0128 }
            r11.aj()     // Catch:{ all -> 0x0128 }
            goto L_0x012e
        L_0x0128:
            r2 = move-exception
            com.tencent.wxop.stat.b.b r3 = bZ     // Catch:{ all -> 0x012f }
            r3.b((java.lang.Throwable) r2)     // Catch:{ all -> 0x012f }
        L_0x012e:
            throw r1     // Catch:{ all -> 0x012f }
        L_0x012f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.am():void");
    }

    private void an() {
        Cursor cursor = null;
        try {
            Cursor query = this.bW.getReadableDatabase().query("keyvalues", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                this.f51094cf.put(query.getString(0), query.getString(1));
            }
            query.close();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private static String b(List<ad> list) {
        StringBuilder sb2 = new StringBuilder(list.size() * 3);
        sb2.append("event_id in (");
        int size = list.size();
        int i11 = 0;
        for (ad adVar : list) {
            sb2.append(adVar.K);
            if (i11 != size - 1) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i11++;
        }
        sb2.append(")");
        return sb2.toString();
    }

    private void b(List<ad> list, int i11, boolean z11) {
        ac acVar;
        Cursor cursor = null;
        if (!z11) {
            try {
                acVar = this.bW;
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } else {
            acVar = this.bX;
        }
        Cursor query = acVar.getReadableDatabase().query(DbParams.TABLE_EVENTS, (String[]) null, "status=?", new String[]{Integer.toString(1)}, (String) null, (String) null, (String) null, Integer.toString(i11));
        while (query.moveToNext()) {
            long j11 = query.getLong(0);
            String string = query.getString(1);
            if (!c.f51034ad) {
                string = r.t(string);
            }
            String str = string;
            int i12 = query.getInt(2);
            int i13 = query.getInt(3);
            ad adVar = new ad(j11, str, i12, i13);
            if (c.k()) {
                b bVar = bZ;
                bVar.b((Object) "peek event, id=" + j11 + ",send_count=" + i13 + ",timestamp=" + query.getLong(4));
            }
            list.add(adVar);
        }
        query.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060 A[SYNTHETIC, Splitter:B:19:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(boolean r8) {
        /*
            r7 = this;
            android.database.sqlite.SQLiteDatabase r8 = r7.c(r8)     // Catch:{ all -> 0x0057 }
            r8.beginTransaction()     // Catch:{ all -> 0x0055 }
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "status"
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0055 }
            r0.put(r1, r3)     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "events"
            java.lang.String r3 = "status=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ all -> 0x0055 }
            r4 = 0
            r5 = 2
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ all -> 0x0055 }
            r2[r4] = r5     // Catch:{ all -> 0x0055 }
            int r0 = r8.update(r1, r0, r3, r2)     // Catch:{ all -> 0x0055 }
            boolean r1 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0047
            com.tencent.wxop.stat.b.b r1 = bZ     // Catch:{ all -> 0x0055 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = "update "
            r2.<init>(r3)     // Catch:{ all -> 0x0055 }
            r2.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = " unsent events."
            r2.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0055 }
            r1.b((java.lang.Object) r0)     // Catch:{ all -> 0x0055 }
        L_0x0047:
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x0055 }
            r8.endTransaction()     // Catch:{ all -> 0x004e }
            return
        L_0x004e:
            r8 = move-exception
            com.tencent.wxop.stat.b.b r0 = bZ
            r0.b((java.lang.Throwable) r8)
            return
        L_0x0055:
            r0 = move-exception
            goto L_0x0059
        L_0x0057:
            r0 = move-exception
            r8 = 0
        L_0x0059:
            com.tencent.wxop.stat.b.b r1 = bZ     // Catch:{ all -> 0x0064 }
            r1.b((java.lang.Throwable) r0)     // Catch:{ all -> 0x0064 }
            if (r8 == 0) goto L_0x0063
            r8.endTransaction()     // Catch:{ all -> 0x004e }
        L_0x0063:
            return
        L_0x0064:
            r0 = move-exception
            if (r8 == 0) goto L_0x0071
            r8.endTransaction()     // Catch:{ all -> 0x006b }
            goto L_0x0071
        L_0x006b:
            r8 = move-exception
            com.tencent.wxop.stat.b.b r1 = bZ
            r1.b((java.lang.Throwable) r8)
        L_0x0071:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.b(boolean):void");
    }

    private SQLiteDatabase c(boolean z11) {
        return (!z11 ? this.bW : this.bX).getWritableDatabase();
    }

    public static t s(Context context) {
        if (f51087cb == null) {
            synchronized (t.class) {
                if (f51087cb == null) {
                    f51087cb = new t(context);
                }
            }
        }
        return f51087cb;
    }

    public final void H() {
        if (c.l()) {
            try {
                this.f51089be.a(new w(this));
            } catch (Throwable th2) {
                bZ.b(th2);
            }
        }
    }

    public final void b(int i11) {
        this.f51089be.a(new ab(this, i11));
    }

    public final void b(d dVar, aj ajVar, boolean z11, boolean z12) {
        f fVar = this.f51089be;
        if (fVar != null) {
            fVar.a(new x(this, dVar, ajVar, z11, z12));
        }
    }

    public final void b(ah ahVar) {
        if (ahVar != null) {
            this.f51089be.a(new y(this, ahVar));
        }
    }

    public final void b(List<ad> list, boolean z11) {
        f fVar = this.f51089be;
        if (fVar != null) {
            fVar.a(new u(this, list, z11));
        }
    }

    public final void c(List<ad> list, boolean z11) {
        f fVar = this.f51089be;
        if (fVar != null) {
            fVar.a(new v(this, list, z11));
        }
    }

    public final int r() {
        return this.aI;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r2 = bZ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ea, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01eb, code lost:
        if (r2 != null) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f0, code lost:
        r1.bW.getWritableDatabase().endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        bZ.b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0200, code lost:
        throw r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:68:0x01b3, B:78:0x01cd, B:93:0x01ed] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d4 A[SYNTHETIC, Splitter:B:81:0x01d4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.tencent.wxop.stat.b.c t(android.content.Context r19) {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            com.tencent.wxop.stat.b.c r0 = r1.bY     // Catch:{ all -> 0x0201 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r18)
            return r0
        L_0x0009:
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01ca }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x01ca }
            r0.beginTransaction()     // Catch:{ all -> 0x01ca }
            boolean r0 = com.tencent.wxop.stat.c.k()     // Catch:{ all -> 0x01ca }
            if (r0 == 0) goto L_0x0024
            com.tencent.wxop.stat.b.b r0 = bZ     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "try to load user info from db."
            r0.b((java.lang.Object) r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r0 = move-exception
            r2 = 0
            goto L_0x01cd
        L_0x0024:
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01ca }
            android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase()     // Catch:{ all -> 0x01ca }
            java.lang.String r4 = "user"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01ca }
            boolean r0 = r3.moveToNext()     // Catch:{ all -> 0x01c7 }
            r4 = 1000(0x3e8, double:4.94E-321)
            r6 = 0
            r7 = 1
            if (r0 == 0) goto L_0x013e
            java.lang.String r0 = r3.getString(r6)     // Catch:{ all -> 0x01c7 }
            java.lang.String r8 = com.tencent.wxop.stat.b.r.t(r0)     // Catch:{ all -> 0x01c7 }
            int r9 = r3.getInt(r7)     // Catch:{ all -> 0x01c7 }
            r10 = 2
            java.lang.String r11 = r3.getString(r10)     // Catch:{ all -> 0x01c7 }
            r12 = 3
            long r12 = r3.getLong(r12)     // Catch:{ all -> 0x01c7 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01c7 }
            long r14 = r14 / r4
            if (r9 == r7) goto L_0x0071
            long r12 = r12 * r4
            java.lang.String r12 = com.tencent.wxop.stat.b.l.d(r12)     // Catch:{ all -> 0x01c7 }
            long r16 = r14 * r4
            java.lang.String r13 = com.tencent.wxop.stat.b.l.d(r16)     // Catch:{ all -> 0x01c7 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x01c7 }
            if (r12 != 0) goto L_0x0071
            r12 = r7
            goto L_0x0072
        L_0x0071:
            r12 = r9
        L_0x0072:
            java.lang.String r13 = com.tencent.wxop.stat.b.l.G(r19)     // Catch:{ all -> 0x01c7 }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x01c7 }
            if (r11 != 0) goto L_0x007e
            r12 = r12 | 2
        L_0x007e:
            java.lang.String r11 = ","
            java.lang.String[] r11 = r8.split(r11)     // Catch:{ all -> 0x01c7 }
            if (r11 == 0) goto L_0x00a9
            int r13 = r11.length     // Catch:{ all -> 0x01c7 }
            if (r13 <= 0) goto L_0x00a9
            r13 = r11[r6]     // Catch:{ all -> 0x01c7 }
            if (r13 == 0) goto L_0x0098
            int r4 = r13.length()     // Catch:{ all -> 0x01c7 }
            r5 = 11
            if (r4 >= r5) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r2 = r6
            goto L_0x00af
        L_0x0098:
            java.lang.String r4 = com.tencent.wxop.stat.b.r.b(r19)     // Catch:{ all -> 0x01c7 }
            if (r4 == 0) goto L_0x0096
            int r5 = r4.length()     // Catch:{ all -> 0x01c7 }
            r2 = 10
            if (r5 <= r2) goto L_0x0096
            r13 = r4
            r2 = r7
            goto L_0x00af
        L_0x00a9:
            java.lang.String r8 = com.tencent.wxop.stat.b.l.c(r19)     // Catch:{ all -> 0x01c7 }
            r2 = r7
            r13 = r8
        L_0x00af:
            if (r11 == 0) goto L_0x00cb
            int r4 = r11.length     // Catch:{ all -> 0x01c7 }
            if (r4 < r10) goto L_0x00cb
            r4 = r11[r7]     // Catch:{ all -> 0x01c7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r5.<init>()     // Catch:{ all -> 0x01c7 }
            r5.append(r13)     // Catch:{ all -> 0x01c7 }
            java.lang.String r8 = ","
            r5.append(r8)     // Catch:{ all -> 0x01c7 }
            r5.append(r4)     // Catch:{ all -> 0x01c7 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x01c7 }
            goto L_0x00ec
        L_0x00cb:
            java.lang.String r4 = com.tencent.wxop.stat.b.l.w(r19)     // Catch:{ all -> 0x01c7 }
            if (r4 == 0) goto L_0x00ec
            int r5 = r4.length()     // Catch:{ all -> 0x01c7 }
            if (r5 <= 0) goto L_0x00ec
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r2.<init>()     // Catch:{ all -> 0x01c7 }
            r2.append(r13)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = ","
            r2.append(r5)     // Catch:{ all -> 0x01c7 }
            r2.append(r4)     // Catch:{ all -> 0x01c7 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x01c7 }
            r2 = r7
        L_0x00ec:
            com.tencent.wxop.stat.b.c r5 = new com.tencent.wxop.stat.b.c     // Catch:{ all -> 0x01c7 }
            r5.<init>(r13, r4, r12)     // Catch:{ all -> 0x01c7 }
            r1.bY = r5     // Catch:{ all -> 0x01c7 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x01c7 }
            r4.<init>()     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = com.tencent.wxop.stat.b.r.q(r8)     // Catch:{ all -> 0x01c7 }
            java.lang.String r8 = "uid"
            r4.put(r8, r5)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = "user_type"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x01c7 }
            r4.put(r5, r8)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = "app_ver"
            java.lang.String r8 = com.tencent.wxop.stat.b.l.G(r19)     // Catch:{ all -> 0x01c7 }
            r4.put(r5, r8)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = "ts"
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x01c7 }
            r4.put(r5, r8)     // Catch:{ all -> 0x01c7 }
            if (r2 == 0) goto L_0x012f
            com.tencent.wxop.stat.ac r2 = r1.bW     // Catch:{ all -> 0x01c7 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = "user"
            java.lang.String r8 = "uid=?"
            java.lang.String[] r10 = new java.lang.String[r7]     // Catch:{ all -> 0x01c7 }
            r10[r6] = r0     // Catch:{ all -> 0x01c7 }
            r2.update(r5, r4, r8, r10)     // Catch:{ all -> 0x01c7 }
        L_0x012f:
            if (r12 == r9) goto L_0x013f
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01c7 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x01c7 }
            java.lang.String r2 = "user"
            r5 = 0
            r0.replace(r2, r5, r4)     // Catch:{ all -> 0x01c7 }
            goto L_0x013f
        L_0x013e:
            r7 = r6
        L_0x013f:
            if (r7 != 0) goto L_0x01aa
            java.lang.String r0 = com.tencent.wxop.stat.b.l.c(r19)     // Catch:{ all -> 0x01c7 }
            java.lang.String r2 = com.tencent.wxop.stat.b.l.w(r19)     // Catch:{ all -> 0x01c7 }
            if (r2 == 0) goto L_0x0166
            int r4 = r2.length()     // Catch:{ all -> 0x01c7 }
            if (r4 <= 0) goto L_0x0166
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c7 }
            r4.<init>()     // Catch:{ all -> 0x01c7 }
            r4.append(r0)     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = ","
            r4.append(r5)     // Catch:{ all -> 0x01c7 }
            r4.append(r2)     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01c7 }
            goto L_0x0167
        L_0x0166:
            r4 = r0
        L_0x0167:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01c7 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r9
            java.lang.String r5 = com.tencent.wxop.stat.b.l.G(r19)     // Catch:{ all -> 0x01c7 }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x01c7 }
            r9.<init>()     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = com.tencent.wxop.stat.b.r.q(r4)     // Catch:{ all -> 0x01c7 }
            java.lang.String r10 = "uid"
            r9.put(r10, r4)     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = "user_type"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01c7 }
            r9.put(r4, r10)     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = "app_ver"
            r9.put(r4, r5)     // Catch:{ all -> 0x01c7 }
            java.lang.String r4 = "ts"
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01c7 }
            r9.put(r4, r5)     // Catch:{ all -> 0x01c7 }
            com.tencent.wxop.stat.ac r4 = r1.bW     // Catch:{ all -> 0x01c7 }
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch:{ all -> 0x01c7 }
            java.lang.String r5 = "user"
            r7 = 0
            r4.insert(r5, r7, r9)     // Catch:{ all -> 0x01c7 }
            com.tencent.wxop.stat.b.c r4 = new com.tencent.wxop.stat.b.c     // Catch:{ all -> 0x01c7 }
            r4.<init>(r0, r2, r6)     // Catch:{ all -> 0x01c7 }
            r1.bY = r4     // Catch:{ all -> 0x01c7 }
        L_0x01aa:
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01c7 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x01c7 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x01c7 }
            r3.close()     // Catch:{ all -> 0x01c0 }
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01c0 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x01c0 }
            r0.endTransaction()     // Catch:{ all -> 0x01c0 }
            goto L_0x01e5
        L_0x01c0:
            r0 = move-exception
            com.tencent.wxop.stat.b.b r2 = bZ     // Catch:{ all -> 0x0201 }
        L_0x01c3:
            r2.b((java.lang.Throwable) r0)     // Catch:{ all -> 0x0201 }
            goto L_0x01e5
        L_0x01c7:
            r0 = move-exception
            r2 = r3
            goto L_0x01cd
        L_0x01ca:
            r0 = move-exception
            r7 = 0
            r2 = r7
        L_0x01cd:
            com.tencent.wxop.stat.b.b r3 = bZ     // Catch:{ all -> 0x01e9 }
            r3.b((java.lang.Throwable) r0)     // Catch:{ all -> 0x01e9 }
            if (r2 == 0) goto L_0x01d7
            r2.close()     // Catch:{ all -> 0x01e1 }
        L_0x01d7:
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01e1 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x01e1 }
            r0.endTransaction()     // Catch:{ all -> 0x01e1 }
            goto L_0x01e5
        L_0x01e1:
            r0 = move-exception
            com.tencent.wxop.stat.b.b r2 = bZ     // Catch:{ all -> 0x0201 }
            goto L_0x01c3
        L_0x01e5:
            com.tencent.wxop.stat.b.c r0 = r1.bY     // Catch:{ all -> 0x0201 }
            monitor-exit(r18)
            return r0
        L_0x01e9:
            r0 = move-exception
            r3 = r0
            if (r2 == 0) goto L_0x01f0
            r2.close()     // Catch:{ all -> 0x01fa }
        L_0x01f0:
            com.tencent.wxop.stat.ac r0 = r1.bW     // Catch:{ all -> 0x01fa }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x01fa }
            r0.endTransaction()     // Catch:{ all -> 0x01fa }
            goto L_0x0200
        L_0x01fa:
            r0 = move-exception
            com.tencent.wxop.stat.b.b r2 = bZ     // Catch:{ all -> 0x0201 }
            r2.b((java.lang.Throwable) r0)     // Catch:{ all -> 0x0201 }
        L_0x0200:
            throw r3     // Catch:{ all -> 0x0201 }
        L_0x0201:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.t.t(android.content.Context):com.tencent.wxop.stat.b.c");
    }
}
