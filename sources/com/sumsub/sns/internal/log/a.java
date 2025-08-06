package com.sumsub.sns.internal.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sumsub.log.logger.Logger;
import com.sumsub.sns.internal.log.logger.b;
import com.sumsub.sns.internal.log.logger.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.r;

public final class a implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34862a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f34863b;

    /* renamed from: c  reason: collision with root package name */
    public static final C0401a f34864c = new C0401a();

    /* renamed from: d  reason: collision with root package name */
    public static final e f34865d = new e();

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentHashMap<LoggerType, Logger> f34866e = new ConcurrentHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f34867f = new ConcurrentHashMap<>();

    /* renamed from: com.sumsub.sns.internal.log.a$a  reason: collision with other inner class name */
    public static final class C0401a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public static final C0402a f34868a = new C0402a((r) null);
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public static final int f34869b = 0;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public static final long f34870c = 10000;

        /* renamed from: com.sumsub.sns.internal.log.a$a$a  reason: collision with other inner class name */
        public static final class C0402a {
            public /* synthetic */ C0402a(r rVar) {
                this();
            }

            public C0402a() {
            }
        }

        public C0401a() {
            super(Looper.getMainLooper());
        }

        public final void a() {
            removeMessages(0);
        }

        public final void b() {
            if (!hasMessages(0)) {
                sendMessageDelayed(obtainMessage(0), 10000);
            }
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                a.f34862a.e();
            }
        }
    }

    public final void b(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = f34867f;
        b bVar = concurrentHashMap.get(str);
        if (bVar != null) {
            bVar.clear();
        }
        concurrentHashMap.remove(str);
    }

    public final boolean c() {
        return f34863b;
    }

    public void d(String str, String str2, Throwable th2) {
        f34865d.d(str, str2, th2);
    }

    public void e(String str, String str2, Throwable th2) {
        f34865d.e(str, str2, th2);
    }

    public final void f() {
        f34864c.a();
        e();
    }

    public final void flush() {
        for (b flush : f34867f.values()) {
            flush.flush();
        }
    }

    public void i(String str, String str2, Throwable th2) {
        f34865d.i(str, str2, th2);
    }

    public void v(String str, String str2, Throwable th2) {
        f34865d.v(str, str2, th2);
    }

    public void w(String str, String str2, Throwable th2) {
        f34865d.w(str, str2, th2);
    }

    public final void a(boolean z11) {
        f34863b = z11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.sumsub.log.logger.Logger} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.log.logger.Logger c(java.util.List<? extends com.sumsub.sns.internal.log.LoggerType> r6) {
        /*
            r5 = this;
            com.sumsub.sns.internal.log.logger.e r0 = f34865d
            java.util.List r0 = r0.c()
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r0)
            java.util.List r6 = r5.b((java.util.List<? extends com.sumsub.sns.internal.log.LoggerType>) r6)
            java.util.Iterator r6 = r6.iterator()
        L_0x0012:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r6.next()
            com.sumsub.log.logger.Logger r1 = (com.sumsub.log.logger.Logger) r1
            java.util.Iterator r2 = r0.iterator()
        L_0x0022:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0037
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.sumsub.log.logger.Logger r4 = (com.sumsub.log.logger.Logger) r4
            if (r4 != r1) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            if (r4 == 0) goto L_0x0022
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            if (r3 != 0) goto L_0x0012
            r0.add(r1)
            goto L_0x0012
        L_0x003e:
            com.sumsub.sns.internal.log.logger.c r6 = new com.sumsub.sns.internal.log.logger.c
            r6.<init>(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.log.a.c(java.util.List):com.sumsub.log.logger.Logger");
    }

    public final void d() {
        f34864c.b();
    }

    public final void e() {
        for (Map.Entry<String, b> value : f34867f.entrySet()) {
            ((b) value.getValue()).clear();
        }
        f34867f.clear();
        f34866e.clear();
        f34865d.clear();
    }

    public final Logger a(LoggerType... loggerTypeArr) {
        return c(ArraysKt___ArraysKt.x0(loggerTypeArr));
    }

    public final List<Logger> b(List<? extends LoggerType> list) {
        ArrayList arrayList = new ArrayList();
        for (LoggerType loggerType : list) {
            Logger logger = f34866e.get(loggerType);
            if (logger != null) {
                arrayList.add(logger);
            } else {
                e eVar = f34865d;
                com.sumsub.log.logger.a.b(eVar, "L", "Failed to get logger for " + loggerType.name(), (Throwable) null, 4, (Object) null);
            }
        }
        return arrayList;
    }

    public final b a(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = f34867f;
        b bVar = concurrentHashMap.get(str);
        if (bVar != null) {
            return bVar;
        }
        com.sumsub.sns.internal.log.logger.a aVar = new com.sumsub.sns.internal.log.logger.a(str, f34865d);
        concurrentHashMap.put(str, aVar);
        return aVar;
    }

    public final void a(String str, b bVar) {
        f34867f.put(str, bVar);
    }

    public final void a(Logger logger) {
        f34865d.a(logger);
    }

    public static /* synthetic */ void a(a aVar, LoggerType loggerType, Logger logger, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        aVar.a(loggerType, logger, z11);
    }

    public final void a(LoggerType loggerType, Logger logger, boolean z11) {
        f34866e.put(loggerType, logger);
        if (z11) {
            f34865d.a(logger);
        }
    }
}
