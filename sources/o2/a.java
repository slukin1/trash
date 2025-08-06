package o2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;

public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public String f16248b;

    /* renamed from: c  reason: collision with root package name */
    public Object f16249c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public SQLiteDatabase f16250d;

    public a(Context context, String str) {
        super(context, "aliclound_httpdns_" + str + ".db", (SQLiteDatabase.CursorFactory) null, 2);
        this.f16248b = str;
    }

    public final SQLiteDatabase a() {
        if (this.f16250d == null) {
            try {
                this.f16250d = getWritableDatabase();
            } catch (Exception unused) {
            }
        }
        return this.f16250d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|(2:24|25)|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00bf, code lost:
        if (r2 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00de, code lost:
        if (r2 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00e1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00e8 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x00e1=Splitter:B:20:0x00e1, B:26:0x00e8=Splitter:B:26:0x00e8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.alibaba.sdk.android.httpdns.b.a> b(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f16249c
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00e9 }
            r1.<init>()     // Catch:{ all -> 0x00e9 }
            r2 = 0
            r2.a r3 = r2.a.f()     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = r3.m()     // Catch:{ all -> 0x00e9 }
            android.database.sqlite.SQLiteDatabase r4 = r12.a()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r5 = "host"
            r6 = 0
            java.lang.String r7 = "sp = ? AND region = ?"
            r8 = 2
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x00c7 }
            r9 = 0
            r8[r9] = r3     // Catch:{ Exception -> 0x00c7 }
            r3 = 1
            r8[r3] = r13     // Catch:{ Exception -> 0x00c7 }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00c7 }
            if (r2 == 0) goto L_0x00bf
            int r13 = r2.getCount()     // Catch:{ Exception -> 0x00c7 }
            if (r13 <= 0) goto L_0x00bf
            r2.moveToFirst()     // Catch:{ Exception -> 0x00c7 }
        L_0x0035:
            com.alibaba.sdk.android.httpdns.b.a r13 = new com.alibaba.sdk.android.httpdns.b.a     // Catch:{ Exception -> 0x00c7 }
            r13.<init>()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "id"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            long r4 = r2.getLong(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.j(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "region"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.u(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "host"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.t(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "ips"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String[] r4 = w2.a.k(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.i(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "type"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.v(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "ttl"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            int r4 = r2.getInt(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.e(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "time"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            long r4 = r2.getLong(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.f(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "extra"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.g(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "cache_key"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.k(r4)     // Catch:{ Exception -> 0x00c7 }
            r13.h(r3)     // Catch:{ Exception -> 0x00c7 }
            r1.add(r13)     // Catch:{ Exception -> 0x00c7 }
            boolean r13 = r2.moveToNext()     // Catch:{ Exception -> 0x00c7 }
            if (r13 != 0) goto L_0x0035
        L_0x00bf:
            if (r2 == 0) goto L_0x00e1
        L_0x00c1:
            r2.close()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00e1
        L_0x00c5:
            r13 = move-exception
            goto L_0x00e3
        L_0x00c7:
            r13 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
            r3.<init>()     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "read from db fail "
            r3.append(r4)     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = r12.f16248b     // Catch:{ all -> 0x00c5 }
            r3.append(r4)     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c5 }
            com.alibaba.sdk.android.httpdns.log.HttpDnsLog.j(r3, r13)     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x00e1
            goto L_0x00c1
        L_0x00e1:
            monitor-exit(r0)     // Catch:{ all -> 0x00e9 }
            return r1
        L_0x00e3:
            if (r2 == 0) goto L_0x00e8
            r2.close()     // Catch:{ Exception -> 0x00e8 }
        L_0x00e8:
            throw r13     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e9 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.a.b(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|(2:20|21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        if (r1 == null) goto L_0x0054;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005b */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0054=Splitter:B:16:0x0054, B:22:0x005b=Splitter:B:22:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(java.util.List<com.alibaba.sdk.android.httpdns.b.a> r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f16249c
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.a()     // Catch:{ Exception -> 0x003a }
            r1.beginTransaction()     // Catch:{ Exception -> 0x003a }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x003a }
        L_0x000f:
            boolean r2 = r10.hasNext()     // Catch:{ Exception -> 0x003a }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r10.next()     // Catch:{ Exception -> 0x003a }
            com.alibaba.sdk.android.httpdns.b.a r2 = (com.alibaba.sdk.android.httpdns.b.a) r2     // Catch:{ Exception -> 0x003a }
            java.lang.String r3 = "host"
            java.lang.String r4 = "id = ? "
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x003a }
            r6 = 0
            long r7 = r2.n()     // Catch:{ Exception -> 0x003a }
            java.lang.String r2 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x003a }
            r5[r6] = r2     // Catch:{ Exception -> 0x003a }
            r1.delete(r3, r4, r5)     // Catch:{ Exception -> 0x003a }
            goto L_0x000f
        L_0x0031:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x003a }
        L_0x0034:
            r1.endTransaction()     // Catch:{ Exception -> 0x0054 }
            goto L_0x0054
        L_0x0038:
            r10 = move-exception
            goto L_0x0056
        L_0x003a:
            r10 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r2.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "delete record fail "
            r2.append(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r9.f16248b     // Catch:{ all -> 0x0038 }
            r2.append(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0038 }
            com.alibaba.sdk.android.httpdns.log.HttpDnsLog.j(r2, r10)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0054
            goto L_0x0034
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.endTransaction()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            throw r10     // Catch:{ all -> 0x005c }
        L_0x005c:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.a.e(java.util.List):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|(0)|35|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|4|(3:5|6|(7:7|8|(4:11|(2:13|42)(2:14|43)|40|9)|41|15|16|17))|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00e3 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d9 A[SYNTHETIC, Splitter:B:27:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0 A[SYNTHETIC, Splitter:B:33:0x00e0] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x00e3=Splitter:B:35:0x00e3, B:29:0x00dc=Splitter:B:29:0x00dc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.List<com.alibaba.sdk.android.httpdns.b.a> r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f16249c
            monitor-enter(r0)
            r2.a r1 = r2.a.f()     // Catch:{ all -> 0x00e4 }
            java.lang.String r1 = r1.m()     // Catch:{ all -> 0x00e4 }
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.a()     // Catch:{ Exception -> 0x00c0 }
            r3.beginTransaction()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
        L_0x0017:
            boolean r4 = r13.hasNext()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r4 == 0) goto L_0x00b1
            java.lang.Object r4 = r13.next()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            com.alibaba.sdk.android.httpdns.b.a r4 = (com.alibaba.sdk.android.httpdns.b.a) r4     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "region"
            java.lang.String r7 = r4.p()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "host"
            java.lang.String r7 = r4.m()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "ips"
            java.lang.String[] r7 = r4.o()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r7 = w2.a.c(r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "cache_key"
            java.lang.String r7 = r4.d()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "extra"
            java.lang.String r7 = r4.l()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "time"
            long r7 = r4.b()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "type"
            int r7 = r4.q()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "ttl"
            int r7 = r4.a()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r6 = "sp"
            r5.put(r6, r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            long r6 = r4.n()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r8 = -1
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x00a6
            java.lang.String r6 = "host"
            java.lang.String r7 = "id = ?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r9 = 0
            long r10 = r4.n()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r4 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r8[r9] = r4     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r3.update(r6, r5, r7, r8)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            goto L_0x0017
        L_0x00a6:
            java.lang.String r6 = "host"
            long r5 = r3.insert(r6, r2, r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r4.j(r5)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            goto L_0x0017
        L_0x00b1:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r3.endTransaction()     // Catch:{ Exception -> 0x00dc }
            goto L_0x00dc
        L_0x00b8:
            r13 = move-exception
            r2 = r3
            goto L_0x00de
        L_0x00bb:
            r13 = move-exception
            r2 = r3
            goto L_0x00c1
        L_0x00be:
            r13 = move-exception
            goto L_0x00de
        L_0x00c0:
            r13 = move-exception
        L_0x00c1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r1.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "insertOrUpdate record fail "
            r1.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r12.f16248b     // Catch:{ all -> 0x00be }
            r1.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00be }
            com.alibaba.sdk.android.httpdns.log.HttpDnsLog.j(r1, r13)     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x00dc
            r2.endTransaction()     // Catch:{ Exception -> 0x00dc }
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x00e4 }
            return
        L_0x00de:
            if (r2 == 0) goto L_0x00e3
            r2.endTransaction()     // Catch:{ Exception -> 0x00e3 }
        L_0x00e3:
            throw r13     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e4 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.a.f(java.util.List):void");
    }

    public void finalize() {
        SQLiteDatabase sQLiteDatabase = this.f16250d;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            }
        }
        super.finalize();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE host (id INTEGER PRIMARY KEY,region TEXT,host TEXT,ips TEXT,type INTEGER,time INTEGER,ttl INTEGER,extra TEXT,cache_key TEXT,sp TEXT);");
        } catch (Exception e11) {
            HttpDnsLog.j("create db fail " + this.f16248b, e11);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 != i12) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS host;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Exception e11) {
                HttpDnsLog.j("upgrade db fail " + this.f16248b, e11);
            }
        }
    }
}
