package com.tekartik.sqflite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.alibaba.verificationsdk.BuildConfig;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tekartik.sqflite.dev.Debug;
import com.tekartik.sqflite.operation.SqlErrorInfo;
import com.tencent.android.tpush.common.Constants;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqflitePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Integer> f40393d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f40394e = false;

    /* renamed from: f  reason: collision with root package name */
    public static int f40395f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f40396g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f40397h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static final Object f40398i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static String f40399j;

    /* renamed from: k  reason: collision with root package name */
    public static int f40400k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static HandlerThread f40401l;

    /* renamed from: m  reason: collision with root package name */
    public static Handler f40402m;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: n  reason: collision with root package name */
    public static final Map<Integer, xy.a> f40403n = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Context f40404b;

    /* renamed from: c  reason: collision with root package name */
    public MethodChannel f40405c;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodCall f40406b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f40407c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ xy.a f40408d;

        public a(MethodCall methodCall, i iVar, xy.a aVar) {
            this.f40406b = methodCall;
            this.f40407c = iVar;
            this.f40408d = aVar;
        }

        public void run() {
            boolean unused = SqflitePlugin.this.M(this.f40408d, new yy.c(this.f40406b, this.f40407c));
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodCall f40410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f40411c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ xy.a f40412d;

        public b(MethodCall methodCall, i iVar, xy.a aVar) {
            this.f40410b = methodCall;
            this.f40411c = iVar;
            this.f40412d = aVar;
        }

        public void run() {
            yy.c cVar = new yy.c(this.f40410b, this.f40411c);
            boolean d11 = cVar.d();
            boolean f11 = cVar.f();
            ArrayList arrayList = new ArrayList();
            for (Map aVar : (List) this.f40410b.argument("operations")) {
                yy.a aVar2 = new yy.a(aVar, d11);
                String j11 = aVar2.j();
                j11.hashCode();
                char c11 = 65535;
                switch (j11.hashCode()) {
                    case -1319569547:
                        if (j11.equals("execute")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1183792455:
                        if (j11.equals("insert")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -838846263:
                        if (j11.equals("update")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 107944136:
                        if (j11.equals("query")) {
                            c11 = 3;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        if (SqflitePlugin.this.o(this.f40412d, aVar2)) {
                            aVar2.o(arrayList);
                            break;
                        } else if (f11) {
                            aVar2.n(arrayList);
                            break;
                        } else {
                            aVar2.m(this.f40411c);
                            return;
                        }
                    case 1:
                        if (SqflitePlugin.this.w(this.f40412d, aVar2)) {
                            aVar2.o(arrayList);
                            break;
                        } else if (f11) {
                            aVar2.n(arrayList);
                            break;
                        } else {
                            aVar2.m(this.f40411c);
                            return;
                        }
                    case 2:
                        if (SqflitePlugin.this.O(this.f40412d, aVar2)) {
                            aVar2.o(arrayList);
                            break;
                        } else if (f11) {
                            aVar2.n(arrayList);
                            break;
                        } else {
                            aVar2.m(this.f40411c);
                            return;
                        }
                    case 3:
                        if (SqflitePlugin.this.M(this.f40412d, aVar2)) {
                            aVar2.o(arrayList);
                            break;
                        } else if (f11) {
                            aVar2.n(arrayList);
                            break;
                        } else {
                            aVar2.m(this.f40411c);
                            return;
                        }
                    default:
                        i iVar = this.f40411c;
                        iVar.error("bad_param", "Batch method '" + j11 + "' not supported", (Object) null);
                        return;
                }
            }
            if (d11) {
                this.f40411c.success((Object) null);
            } else {
                this.f40411c.success(arrayList);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodCall f40414b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f40415c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ xy.a f40416d;

        public c(MethodCall methodCall, i iVar, xy.a aVar) {
            this.f40414b = methodCall;
            this.f40415c = iVar;
            this.f40416d = aVar;
        }

        public void run() {
            boolean unused = SqflitePlugin.this.w(this.f40416d, new yy.c(this.f40414b, this.f40415c));
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ xy.a f40418b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodCall f40419c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f40420d;

        public d(xy.a aVar, MethodCall methodCall, i iVar) {
            this.f40418b = aVar;
            this.f40419c = methodCall;
            this.f40420d = iVar;
        }

        public void run() {
            if (SqflitePlugin.this.p(this.f40418b, this.f40419c, this.f40420d) != null) {
                this.f40420d.success((Object) null);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodCall f40422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f40423c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ xy.a f40424d;

        public e(MethodCall methodCall, i iVar, xy.a aVar) {
            this.f40422b = methodCall;
            this.f40423c = iVar;
            this.f40424d = aVar;
        }

        public void run() {
            boolean unused = SqflitePlugin.this.O(this.f40424d, new yy.c(this.f40422b, this.f40423c));
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f40426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40427c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f40428d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Boolean f40429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ xy.a f40430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ MethodCall f40431g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f40432h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f40433i;

        public f(boolean z11, String str, i iVar, Boolean bool, xy.a aVar, MethodCall methodCall, boolean z12, int i11) {
            this.f40426b = z11;
            this.f40427c = str;
            this.f40428d = iVar;
            this.f40429e = bool;
            this.f40430f = aVar;
            this.f40431g = methodCall;
            this.f40432h = z12;
            this.f40433i = i11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
            r5.f40428d.success(com.tekartik.sqflite.SqflitePlugin.y(r5.f40433i, false, false));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c7, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c8, code lost:
            com.tekartik.sqflite.SqflitePlugin.h(r5.f40434j, r1, new yy.c(r5.f40431g, r5.f40428d), r5.f40430f);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                java.lang.Object r0 = com.tekartik.sqflite.SqflitePlugin.f40398i
                monitor-enter(r0)
                boolean r1 = r5.f40426b     // Catch:{ all -> 0x00da }
                if (r1 != 0) goto L_0x0048
                java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00da }
                java.lang.String r2 = r5.f40427c     // Catch:{ all -> 0x00da }
                r1.<init>(r2)     // Catch:{ all -> 0x00da }
                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00da }
                java.lang.String r1 = r1.getParent()     // Catch:{ all -> 0x00da }
                r2.<init>(r1)     // Catch:{ all -> 0x00da }
                boolean r1 = r2.exists()     // Catch:{ all -> 0x00da }
                if (r1 != 0) goto L_0x0048
                boolean r1 = r2.mkdirs()     // Catch:{ all -> 0x00da }
                if (r1 != 0) goto L_0x0048
                boolean r1 = r2.exists()     // Catch:{ all -> 0x00da }
                if (r1 != 0) goto L_0x0048
                com.tekartik.sqflite.SqflitePlugin$i r1 = r5.f40428d     // Catch:{ all -> 0x00da }
                java.lang.String r2 = "sqlite_error"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
                r3.<init>()     // Catch:{ all -> 0x00da }
                java.lang.String r4 = "open_failed "
                r3.append(r4)     // Catch:{ all -> 0x00da }
                java.lang.String r4 = r5.f40427c     // Catch:{ all -> 0x00da }
                r3.append(r4)     // Catch:{ all -> 0x00da }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00da }
                r4 = 0
                r1.error(r2, r3, r4)     // Catch:{ all -> 0x00da }
                monitor-exit(r0)     // Catch:{ all -> 0x00da }
                return
            L_0x0048:
                java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x00c7 }
                java.lang.Boolean r2 = r5.f40429e     // Catch:{ Exception -> 0x00c7 }
                boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00c7 }
                if (r1 == 0) goto L_0x0058
                xy.a r1 = r5.f40430f     // Catch:{ Exception -> 0x00c7 }
                r1.h()     // Catch:{ Exception -> 0x00c7 }
                goto L_0x005d
            L_0x0058:
                xy.a r1 = r5.f40430f     // Catch:{ Exception -> 0x00c7 }
                r1.g()     // Catch:{ Exception -> 0x00c7 }
            L_0x005d:
                java.lang.Object r1 = com.tekartik.sqflite.SqflitePlugin.f40397h     // Catch:{ all -> 0x00da }
                monitor-enter(r1)     // Catch:{ all -> 0x00da }
                boolean r2 = r5.f40432h     // Catch:{ all -> 0x00c4 }
                if (r2 == 0) goto L_0x0073
                java.util.Map<java.lang.String, java.lang.Integer> r2 = com.tekartik.sqflite.SqflitePlugin.f40393d     // Catch:{ all -> 0x00c4 }
                java.lang.String r3 = r5.f40427c     // Catch:{ all -> 0x00c4 }
                int r4 = r5.f40433i     // Catch:{ all -> 0x00c4 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00c4 }
                r2.put(r3, r4)     // Catch:{ all -> 0x00c4 }
            L_0x0073:
                java.util.Map<java.lang.Integer, xy.a> r2 = com.tekartik.sqflite.SqflitePlugin.f40403n     // Catch:{ all -> 0x00c4 }
                int r3 = r5.f40433i     // Catch:{ all -> 0x00c4 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c4 }
                xy.a r4 = r5.f40430f     // Catch:{ all -> 0x00c4 }
                r2.put(r3, r4)     // Catch:{ all -> 0x00c4 }
                monitor-exit(r1)     // Catch:{ all -> 0x00c4 }
                xy.a r1 = r5.f40430f     // Catch:{ all -> 0x00da }
                int r1 = r1.f40660d     // Catch:{ all -> 0x00da }
                boolean r1 = com.tekartik.sqflite.LogLevel.b(r1)     // Catch:{ all -> 0x00da }
                if (r1 == 0) goto L_0x00b6
                java.lang.String r1 = "Sqflite"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
                r2.<init>()     // Catch:{ all -> 0x00da }
                xy.a r3 = r5.f40430f     // Catch:{ all -> 0x00da }
                java.lang.String r3 = r3.d()     // Catch:{ all -> 0x00da }
                r2.append(r3)     // Catch:{ all -> 0x00da }
                java.lang.String r3 = "opened "
                r2.append(r3)     // Catch:{ all -> 0x00da }
                int r3 = r5.f40433i     // Catch:{ all -> 0x00da }
                r2.append(r3)     // Catch:{ all -> 0x00da }
                java.lang.String r3 = " "
                r2.append(r3)     // Catch:{ all -> 0x00da }
                java.lang.String r3 = r5.f40427c     // Catch:{ all -> 0x00da }
                r2.append(r3)     // Catch:{ all -> 0x00da }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00da }
                android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00da }
            L_0x00b6:
                monitor-exit(r0)     // Catch:{ all -> 0x00da }
                com.tekartik.sqflite.SqflitePlugin$i r0 = r5.f40428d
                int r1 = r5.f40433i
                r2 = 0
                java.util.Map r1 = com.tekartik.sqflite.SqflitePlugin.y(r1, r2, r2)
                r0.success(r1)
                return
            L_0x00c4:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00c4 }
                throw r2     // Catch:{ all -> 0x00da }
            L_0x00c7:
                r1 = move-exception
                yy.c r2 = new yy.c     // Catch:{ all -> 0x00da }
                io.flutter.plugin.common.MethodCall r3 = r5.f40431g     // Catch:{ all -> 0x00da }
                com.tekartik.sqflite.SqflitePlugin$i r4 = r5.f40428d     // Catch:{ all -> 0x00da }
                r2.<init>(r3, r4)     // Catch:{ all -> 0x00da }
                com.tekartik.sqflite.SqflitePlugin r3 = com.tekartik.sqflite.SqflitePlugin.this     // Catch:{ all -> 0x00da }
                xy.a r4 = r5.f40430f     // Catch:{ all -> 0x00da }
                r3.v(r1, r2, r4)     // Catch:{ all -> 0x00da }
                monitor-exit(r0)     // Catch:{ all -> 0x00da }
                return
            L_0x00da:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00da }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.f.run():void");
        }
    }

    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ xy.a f40435b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f40436c;

        public g(xy.a aVar, i iVar) {
            this.f40435b = aVar;
            this.f40436c = iVar;
        }

        public void run() {
            synchronized (SqflitePlugin.f40398i) {
                SqflitePlugin.this.k(this.f40435b);
            }
            this.f40436c.success((Object) null);
        }
    }

    public class h implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ xy.a f40438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40439c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f40440d;

        public h(xy.a aVar, String str, i iVar) {
            this.f40438b = aVar;
            this.f40439c = str;
            this.f40440d = iVar;
        }

        public void run() {
            synchronized (SqflitePlugin.f40398i) {
                xy.a aVar = this.f40438b;
                if (aVar != null) {
                    SqflitePlugin.this.k(aVar);
                }
                try {
                    if (LogLevel.c(SqflitePlugin.f40396g)) {
                        Log.d("Sqflite", "delete database " + this.f40439c);
                    }
                    xy.a.b(this.f40439c);
                } catch (Exception e11) {
                    Log.e("Sqflite", "error " + e11 + " while closing database " + SqflitePlugin.f40400k);
                }
            }
            this.f40440d.success((Object) null);
        }
    }

    public class i implements MethodChannel.Result {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f40442a;

        /* renamed from: b  reason: collision with root package name */
        public final MethodChannel.Result f40443b;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f40445b;

            public a(Object obj) {
                this.f40445b = obj;
            }

            public void run() {
                i.this.f40443b.success(this.f40445b);
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f40447b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f40448c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Object f40449d;

            public b(String str, String str2, Object obj) {
                this.f40447b = str;
                this.f40448c = str2;
                this.f40449d = obj;
            }

            public void run() {
                i.this.f40443b.error(this.f40447b, this.f40448c, this.f40449d);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                i.this.f40443b.notImplemented();
            }
        }

        public /* synthetic */ i(SqflitePlugin sqflitePlugin, MethodChannel.Result result, a aVar) {
            this(result);
        }

        public void error(String str, String str2, Object obj) {
            this.f40442a.post(new b(str, str2, obj));
        }

        public void notImplemented() {
            this.f40442a.post(new c());
        }

        public void success(Object obj) {
            this.f40442a.post(new a(obj));
        }

        public i(MethodChannel.Result result) {
            this.f40442a = new Handler(Looper.getMainLooper());
            this.f40443b = result;
        }
    }

    public static String N(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return r((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    public static List<Object> l(Cursor cursor, int i11) {
        String str;
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            Object n11 = n(cursor, i12);
            if (Debug.f40454c) {
                String str2 = null;
                if (n11 != null) {
                    if (n11.getClass().isArray()) {
                        str2 = "array(" + n11.getClass().getComponentType().getName() + ")";
                    } else {
                        str2 = n11.getClass().getName();
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(i12);
                sb2.append(" ");
                sb2.append(cursor.getType(i12));
                sb2.append(l.f34627b);
                sb2.append(n11);
                if (str2 == null) {
                    str = "";
                } else {
                    str = " (" + str2 + ")";
                }
                sb2.append(str);
                Log.d("Sqflite", sb2.toString());
            }
            arrayList.add(n11);
        }
        return arrayList;
    }

    public static Map<String, Object> m(Cursor cursor) {
        HashMap hashMap = new HashMap();
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (Debug.f40454c) {
                Log.d("Sqflite", "column " + i11 + " " + cursor.getType(i11));
            }
            int type = cursor.getType(i11);
            if (type == 0) {
                hashMap.put(columnNames[i11], (Object) null);
            } else if (type == 1) {
                hashMap.put(columnNames[i11], Long.valueOf(cursor.getLong(i11)));
            } else if (type == 2) {
                hashMap.put(columnNames[i11], Double.valueOf(cursor.getDouble(i11)));
            } else if (type == 3) {
                hashMap.put(columnNames[i11], cursor.getString(i11));
            } else if (type == 4) {
                hashMap.put(columnNames[i11], cursor.getBlob(i11));
            }
        }
        return hashMap;
    }

    public static Object n(Cursor cursor, int i11) {
        int type = cursor.getType(i11);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i11));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i11));
        }
        if (type == 3) {
            return cursor.getString(i11);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i11);
    }

    public static Map<String, Object> r(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = r((Map) value);
            } else {
                obj = N(value);
            }
            hashMap.put(N(next.getKey()), obj);
        }
        return hashMap;
    }

    public static boolean x(String str) {
        return str == null || str.equals(":memory:");
    }

    public static Map y(int i11, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i11));
        if (z11) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z12) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    public final void A(MethodCall methodCall, MethodChannel.Result result) {
        xy.a t11 = t(methodCall, result);
        if (t11 != null) {
            f40402m.post(new b(methodCall, new i(this, result, (a) null), t11));
        }
    }

    public final void B(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        xy.a t11 = t(methodCall, result);
        if (t11 != null) {
            if (LogLevel.b(t11.f40660d)) {
                Log.d("Sqflite", t11.d() + "closing " + intValue + " " + t11.f40658b);
            }
            String str = t11.f40658b;
            synchronized (f40397h) {
                f40403n.remove(Integer.valueOf(intValue));
                if (t11.f40657a) {
                    f40393d.remove(str);
                }
            }
            f40402m.post(new g(t11, new i(this, result, (a) null)));
        }
    }

    public final void C(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        if ("get".equals((String) methodCall.argument(Constants.MQTT_STATISTISC_MSGTYPE_KEY))) {
            int i11 = f40396g;
            if (i11 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i11));
            }
            Map<Integer, xy.a> map = f40403n;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : map.entrySet()) {
                    xy.a aVar = (xy.a) next.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", aVar.f40658b);
                    hashMap3.put("singleInstance", Boolean.valueOf(aVar.f40657a));
                    int i12 = aVar.f40660d;
                    if (i12 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i12));
                    }
                    hashMap2.put(((Integer) next.getKey()).toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        result.success(hashMap);
    }

    public final void D(MethodCall methodCall, MethodChannel.Result result) {
        Debug.f40452a = Boolean.TRUE.equals(methodCall.arguments());
        Debug.f40454c = Debug.f40453b && Debug.f40452a;
        if (!Debug.f40452a) {
            f40396g = 0;
        } else if (Debug.f40454c) {
            f40396g = 2;
        } else if (Debug.f40452a) {
            f40396g = 1;
        }
        result.success((Object) null);
    }

    public final void E(MethodCall methodCall, MethodChannel.Result result) {
        xy.a aVar;
        Map<Integer, xy.a> map;
        String str = (String) methodCall.argument("path");
        synchronized (f40397h) {
            if (LogLevel.c(f40396g)) {
                Log.d("Sqflite", "Look for " + str + " in " + f40393d.keySet());
            }
            Map<String, Integer> map2 = f40393d;
            Integer num = map2.get(str);
            if (num == null || (aVar = map.get(num)) == null || !aVar.f40661e.isOpen()) {
                aVar = null;
            } else {
                if (LogLevel.c(f40396g)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aVar.d());
                    sb2.append("found single instance ");
                    sb2.append(aVar.f40662f ? "(in transaction) " : "");
                    sb2.append(num);
                    sb2.append(" ");
                    sb2.append(str);
                    Log.d("Sqflite", sb2.toString());
                }
                (map = f40403n).remove(num);
                map2.remove(str);
            }
        }
        h hVar = new h(aVar, str, new i(this, result, (a) null));
        Handler handler = f40402m;
        if (handler != null) {
            handler.post(hVar);
        } else {
            hVar.run();
        }
    }

    public final void F(MethodCall methodCall, MethodChannel.Result result) {
        xy.a t11 = t(methodCall, result);
        if (t11 != null) {
            f40402m.post(new d(t11, methodCall, new i(this, result, (a) null)));
        }
    }

    public void G(MethodCall methodCall, MethodChannel.Result result) {
        if (f40399j == null) {
            f40399j = this.f40404b.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(f40399j);
    }

    public final void H(MethodCall methodCall, MethodChannel.Result result) {
        xy.a t11 = t(methodCall, result);
        if (t11 != null) {
            f40402m.post(new c(methodCall, new i(this, result, (a) null), t11));
        }
    }

    public final void I(MethodCall methodCall, MethodChannel.Result result) {
        int i11;
        xy.a aVar;
        String str = (String) methodCall.argument("path");
        Boolean bool = (Boolean) methodCall.argument("readOnly");
        boolean x11 = x(str);
        boolean z11 = !Boolean.FALSE.equals(methodCall.argument("singleInstance")) && !x11;
        if (z11) {
            synchronized (f40397h) {
                if (LogLevel.c(f40396g)) {
                    Log.d("Sqflite", "Look for " + str + " in " + f40393d.keySet());
                }
                Integer num = f40393d.get(str);
                if (!(num == null || (aVar = f40403n.get(num)) == null)) {
                    if (aVar.f40661e.isOpen()) {
                        if (LogLevel.c(f40396g)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(aVar.d());
                            sb2.append("re-opened single instance ");
                            sb2.append(aVar.f40662f ? "(in transaction) " : "");
                            sb2.append(num);
                            sb2.append(" ");
                            sb2.append(str);
                            Log.d("Sqflite", sb2.toString());
                        }
                        result.success(y(num.intValue(), true, aVar.f40662f));
                        return;
                    } else if (LogLevel.c(f40396g)) {
                        Log.d("Sqflite", aVar.d() + "single instance database of " + str + " not opened");
                    }
                }
            }
        }
        Object obj = f40397h;
        synchronized (obj) {
            i11 = f40400k + 1;
            f40400k = i11;
        }
        xy.a aVar2 = new xy.a(str, i11, z11, f40396g);
        i iVar = new i(this, result, (a) null);
        synchronized (obj) {
            if (f40402m == null) {
                HandlerThread handlerThread = new HandlerThread("Sqflite", f40395f);
                f40401l = handlerThread;
                handlerThread.start();
                f40402m = new Handler(f40401l.getLooper());
                if (LogLevel.b(aVar2.f40660d)) {
                    Log.d("Sqflite", aVar2.d() + "starting thread" + f40401l + " priority " + f40395f);
                }
            }
            if (LogLevel.b(aVar2.f40660d)) {
                Log.d("Sqflite", aVar2.d() + "opened " + i11 + " " + str);
            }
            f40402m.post(new f(x11, str, iVar, bool, aVar2, methodCall, z11, i11));
        }
    }

    public void J(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("queryAsMapList");
        if (argument != null) {
            f40394e = Boolean.TRUE.equals(argument);
        }
        Object argument2 = methodCall.argument("androidThreadPriority");
        if (argument2 != null) {
            f40395f = ((Integer) argument2).intValue();
        }
        Integer a11 = LogLevel.a(methodCall);
        if (a11 != null) {
            f40396g = a11.intValue();
        }
        result.success((Object) null);
    }

    public final void K(MethodCall methodCall, MethodChannel.Result result) {
        xy.a t11 = t(methodCall, result);
        if (t11 != null) {
            f40402m.post(new a(methodCall, new i(this, result, (a) null), t11));
        }
    }

    public final void L(MethodCall methodCall, MethodChannel.Result result) {
        xy.a t11 = t(methodCall, result);
        if (t11 != null) {
            f40402m.post(new e(methodCall, new i(this, result, (a) null), t11));
        }
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [java.util.Map, java.util.HashMap] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0075, code lost:
        if (r5 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        r5 = new java.util.ArrayList();
        r6 = new java.util.HashMap();
        r7 = r0.getColumnCount();
        r6.put("columns", java.util.Arrays.asList(r0.getColumnNames()));
        r6.put("rows", r5);
        r11 = r6;
        r6 = r5;
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009a, code lost:
        r6.add(l(r0, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a8, code lost:
        if (r5 != null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00aa, code lost:
        r5 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00af, code lost:
        r14.success(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0043, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean M(xy.a r13, yy.d r14) {
        /*
            r12 = this;
            xy.b r0 = r14.b()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r13.f40660d
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)
            java.lang.String r3 = "Sqflite"
            if (r2 == 0) goto L_0x0029
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r13.d()
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r3, r2)
        L_0x0029:
            boolean r2 = f40394e
            r4 = 0
            r5 = 0
            xy.b r0 = r0.i()     // Catch:{ Exception -> 0x00bf }
            android.database.sqlite.SQLiteDatabase r6 = r13.c()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r7 = r0.e()     // Catch:{ Exception -> 0x00bf }
            java.lang.String[] r0 = r0.b()     // Catch:{ Exception -> 0x00bf }
            android.database.Cursor r0 = r6.rawQuery(r7, r0)     // Catch:{ Exception -> 0x00bf }
            r7 = r4
            r6 = r5
        L_0x0043:
            boolean r8 = r0.moveToNext()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r8 == 0) goto L_0x00a2
            if (r2 == 0) goto L_0x0075
            java.util.Map r8 = m(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            int r9 = r13.f40660d     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            boolean r9 = com.tekartik.sqflite.LogLevel.b(r9)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r9 == 0) goto L_0x0071
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r9.<init>()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r10 = r13.d()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r9.append(r10)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r10 = N(r8)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r9.append(r10)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            android.util.Log.d(r3, r9)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        L_0x0071:
            r1.add(r8)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            goto L_0x0043
        L_0x0075:
            if (r5 != 0) goto L_0x009a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r5.<init>()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r6.<init>()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            int r7 = r0.getColumnCount()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r8 = "columns"
            java.lang.String[] r9 = r0.getColumnNames()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.util.List r9 = java.util.Arrays.asList(r9)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r6.put(r8, r9)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            java.lang.String r8 = "rows"
            r6.put(r8, r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r11 = r6
            r6 = r5
            r5 = r11
        L_0x009a:
            java.util.List r8 = l(r0, r7)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r6.add(r8)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            goto L_0x0043
        L_0x00a2:
            if (r2 == 0) goto L_0x00a8
            r14.success(r1)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            goto L_0x00b2
        L_0x00a8:
            if (r5 != 0) goto L_0x00af
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r5.<init>()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        L_0x00af:
            r14.success(r5)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        L_0x00b2:
            r13 = 1
            r0.close()
            return r13
        L_0x00b7:
            r13 = move-exception
            r5 = r0
            goto L_0x00c9
        L_0x00ba:
            r1 = move-exception
            r5 = r0
            goto L_0x00c0
        L_0x00bd:
            r13 = move-exception
            goto L_0x00c9
        L_0x00bf:
            r1 = move-exception
        L_0x00c0:
            r12.v(r1, r14, r13)     // Catch:{ all -> 0x00bd }
            if (r5 == 0) goto L_0x00c8
            r5.close()
        L_0x00c8:
            return r4
        L_0x00c9:
            if (r5 == 0) goto L_0x00ce
            r5.close()
        L_0x00ce:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.M(xy.a, yy.d):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean O(xy.a r8, yy.d r9) {
        /*
            r7 = this;
            boolean r0 = r7.q(r8, r9)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r9.d()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r9.success(r3)
            return r2
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r0 = r8.f()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "SELECT changes()"
            android.database.Cursor r0 = r0.rawQuery(r4, r3)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x0066
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r5 <= 0) goto L_0x0066
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r5 == 0) goto L_0x0066
            int r3 = r0.getInt(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            int r5 = r8.f40660d     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            boolean r5 = com.tekartik.sqflite.LogLevel.b(r5)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r5 == 0) goto L_0x0055
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.<init>()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = r8.d()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = "changed "
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.append(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
        L_0x0055:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r9.success(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r0.close()
            return r2
        L_0x0060:
            r8 = move-exception
            r3 = r0
            goto L_0x0093
        L_0x0063:
            r2 = move-exception
            r3 = r0
            goto L_0x008a
        L_0x0066:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.<init>()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = r8.d()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r6 = "fail to read changes for Update/Delete"
            r5.append(r6)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r9.success(r3)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r0 == 0) goto L_0x0086
            r0.close()
        L_0x0086:
            return r2
        L_0x0087:
            r8 = move-exception
            goto L_0x0093
        L_0x0089:
            r2 = move-exception
        L_0x008a:
            r7.v(r2, r9, r8)     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0092
            r3.close()
        L_0x0092:
            return r1
        L_0x0093:
            if (r3 == 0) goto L_0x0098
            r3.close()
        L_0x0098:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.O(xy.a, yy.d):boolean");
    }

    public final void k(xy.a aVar) {
        try {
            if (LogLevel.b(aVar.f40660d)) {
                Log.d("Sqflite", aVar.d() + "closing database " + f40401l);
            }
            aVar.a();
        } catch (Exception e11) {
            Log.e("Sqflite", "error " + e11 + " while closing database " + f40400k);
        }
        synchronized (f40397h) {
            if (f40403n.isEmpty() && f40402m != null) {
                if (LogLevel.b(aVar.f40660d)) {
                    Log.d("Sqflite", aVar.d() + "stopping thread" + f40401l);
                }
                f40401l.quit();
                f40401l = null;
                f40402m = null;
            }
        }
    }

    public final boolean o(xy.a aVar, yy.d dVar) {
        if (!q(aVar, dVar)) {
            return false;
        }
        dVar.success((Object) null);
        return true;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        z(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f40404b = null;
        this.f40405c.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f40405c = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1319569547:
                if (str.equals("execute")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1253581933:
                if (str.equals("closeDatabase")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1249474914:
                if (str.equals("options")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c11 = 3;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c11 = 4;
                    break;
                }
                break;
            case -263511994:
                if (str.equals("deleteDatabase")) {
                    c11 = 5;
                    break;
                }
                break;
            case -198450538:
                if (str.equals("debugMode")) {
                    c11 = 6;
                    break;
                }
                break;
            case -17190427:
                if (str.equals("openDatabase")) {
                    c11 = 7;
                    break;
                }
                break;
            case 93509434:
                if (str.equals("batch")) {
                    c11 = 8;
                    break;
                }
                break;
            case 95458899:
                if (str.equals(BuildConfig.BUILD_TYPE)) {
                    c11 = 9;
                    break;
                }
                break;
            case 107944136:
                if (str.equals("query")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1863829223:
                if (str.equals("getDatabasesPath")) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                F(methodCall, result);
                return;
            case 1:
                B(methodCall, result);
                return;
            case 2:
                J(methodCall, result);
                return;
            case 3:
                H(methodCall, result);
                return;
            case 4:
                L(methodCall, result);
                return;
            case 5:
                E(methodCall, result);
                return;
            case 6:
                D(methodCall, result);
                return;
            case 7:
                I(methodCall, result);
                return;
            case 8:
                A(methodCall, result);
                return;
            case 9:
                C(methodCall, result);
                return;
            case 10:
                K(methodCall, result);
                return;
            case 11:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 12:
                G(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public final xy.a p(xy.a aVar, MethodCall methodCall, MethodChannel.Result result) {
        if (q(aVar, new yy.b(result, u(methodCall), (Boolean) methodCall.argument("inTransaction")))) {
            return aVar;
        }
        return null;
    }

    public final boolean q(xy.a aVar, yy.d dVar) {
        xy.b b11 = dVar.b();
        if (LogLevel.b(aVar.f40660d)) {
            Log.d("Sqflite", aVar.d() + b11);
        }
        Boolean c11 = dVar.c();
        try {
            aVar.f().execSQL(b11.e(), b11.f());
            if (Boolean.TRUE.equals(c11)) {
                aVar.f40662f = true;
            }
            if (Boolean.FALSE.equals(c11)) {
                aVar.f40662f = false;
            }
            return true;
        } catch (Exception e11) {
            v(e11, dVar, aVar);
            if (Boolean.FALSE.equals(c11)) {
                aVar.f40662f = false;
            }
            return false;
        } catch (Throwable th2) {
            if (Boolean.FALSE.equals(c11)) {
                aVar.f40662f = false;
            }
            throw th2;
        }
    }

    public final xy.a s(int i11) {
        return f40403n.get(Integer.valueOf(i11));
    }

    public final xy.a t(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        xy.a s11 = s(intValue);
        if (s11 != null) {
            return s11;
        }
        result.error("sqlite_error", "database_closed " + intValue, (Object) null);
        return null;
    }

    public final xy.b u(MethodCall methodCall) {
        return new xy.b((String) methodCall.argument("sql"), (List) methodCall.argument("arguments"));
    }

    public final void v(Exception exc, yy.d dVar, xy.a aVar) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            dVar.error("sqlite_error", "open_failed " + aVar.f40658b, (Object) null);
        } else if (exc instanceof SQLException) {
            dVar.error("sqlite_error", exc.getMessage(), SqlErrorInfo.a(dVar));
        } else {
            dVar.error("sqlite_error", exc.getMessage(), SqlErrorInfo.a(dVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(xy.a r10, yy.d r11) {
        /*
            r9 = this;
            boolean r0 = r9.q(r10, r11)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r11.d()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            r11.success(r2)
            return r3
        L_0x0014:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r10.f()     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch:{ Exception -> 0x00be, all -> 0x00bc }
            java.lang.String r4 = "Sqflite"
            if (r0 == 0) goto L_0x009b
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0099 }
            if (r5 <= 0) goto L_0x009b
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0099 }
            if (r5 == 0) goto L_0x009b
            int r5 = r0.getInt(r1)     // Catch:{ Exception -> 0x0099 }
            if (r5 != 0) goto L_0x0067
            int r5 = r10.f40660d     // Catch:{ Exception -> 0x0099 }
            boolean r5 = com.tekartik.sqflite.LogLevel.b(r5)     // Catch:{ Exception -> 0x0099 }
            if (r5 == 0) goto L_0x0060
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r5.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = r10.d()     // Catch:{ Exception -> 0x0099 }
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = "no changes (id was "
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            long r6 = r0.getLong(r3)     // Catch:{ Exception -> 0x0099 }
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0099 }
            android.util.Log.d(r4, r5)     // Catch:{ Exception -> 0x0099 }
        L_0x0060:
            r11.success(r2)     // Catch:{ Exception -> 0x0099 }
            r0.close()
            return r3
        L_0x0067:
            long r5 = r0.getLong(r3)     // Catch:{ Exception -> 0x0099 }
            int r2 = r10.f40660d     // Catch:{ Exception -> 0x0099 }
            boolean r2 = com.tekartik.sqflite.LogLevel.b(r2)     // Catch:{ Exception -> 0x0099 }
            if (r2 == 0) goto L_0x008e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r2.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r7 = r10.d()     // Catch:{ Exception -> 0x0099 }
            r2.append(r7)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r7 = "inserted "
            r2.append(r7)     // Catch:{ Exception -> 0x0099 }
            r2.append(r5)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0099 }
            android.util.Log.d(r4, r2)     // Catch:{ Exception -> 0x0099 }
        L_0x008e:
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0099 }
            r11.success(r2)     // Catch:{ Exception -> 0x0099 }
            r0.close()
            return r3
        L_0x0099:
            r2 = move-exception
            goto L_0x00c2
        L_0x009b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r5.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = r10.d()     // Catch:{ Exception -> 0x0099 }
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = "fail to read changes for Insert"
            r5.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0099 }
            android.util.Log.e(r4, r5)     // Catch:{ Exception -> 0x0099 }
            r11.success(r2)     // Catch:{ Exception -> 0x0099 }
            if (r0 == 0) goto L_0x00bb
            r0.close()
        L_0x00bb:
            return r3
        L_0x00bc:
            r10 = move-exception
            goto L_0x00cd
        L_0x00be:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        L_0x00c2:
            r9.v(r2, r11, r10)     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00ca
            r0.close()
        L_0x00ca:
            return r1
        L_0x00cb:
            r10 = move-exception
            r2 = r0
        L_0x00cd:
            if (r2 == 0) goto L_0x00d2
            r2.close()
        L_0x00d2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tekartik.sqflite.SqflitePlugin.w(xy.a, yy.d):boolean");
    }

    public final void z(Context context, BinaryMessenger binaryMessenger) {
        this.f40404b = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite");
        this.f40405c = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }
}
