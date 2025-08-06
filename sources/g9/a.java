package g9;

import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.HeartBeatInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jumio.core.cdn.CDNDownload;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class a extends WebSocketListener {

    /* renamed from: o  reason: collision with root package name */
    public static final Object f70852o = new Object();

    /* renamed from: p  reason: collision with root package name */
    public static final Random f70853p = new Random();

    /* renamed from: a  reason: collision with root package name */
    public i f70854a;

    /* renamed from: b  reason: collision with root package name */
    public HeartBeatInfo.Pong f70855b = new HeartBeatInfo.Pong();

    /* renamed from: c  reason: collision with root package name */
    public AtomicInteger f70856c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public boolean f70857d = false;

    /* renamed from: e  reason: collision with root package name */
    public long f70858e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f70859f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f70860g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70861h;

    /* renamed from: i  reason: collision with root package name */
    public String f70862i;

    /* renamed from: j  reason: collision with root package name */
    public c9.b f70863j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f70864k = new C0778a();

    /* renamed from: l  reason: collision with root package name */
    public int f70865l;

    /* renamed from: m  reason: collision with root package name */
    public Runnable f70866m = new b();

    /* renamed from: n  reason: collision with root package name */
    public Runnable f70867n = new c();

    /* renamed from: g9.a$a  reason: collision with other inner class name */
    public class C0778a implements Runnable {
        public C0778a() {
        }

        public void run() {
            f9.b.a().d(this);
            a.this.f70856c.set(0);
            boolean unused = a.this.f70861h = true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00fa A[SYNTHETIC, Splitter:B:21:0x00fa] */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                g9.a r1 = g9.a.this
                java.lang.String r1 = r1.f70862i
                r0.append(r1)
                java.lang.String r1 = "-->cxj, keeper.reConnect--> state = "
                r0.append(r1)
                g9.a r1 = g9.a.this
                java.util.concurrent.atomic.AtomicInteger r1 = r1.f70856c
                int r1 = r1.get()
                r0.append(r1)
                java.lang.String r1 = " canReconnect = "
                r0.append(r1)
                g9.a r1 = g9.a.this
                boolean r1 = r1.f70861h
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.hbg.lib.network.retrofit.util.RetrofitLogger.a(r0)
                g9.a r0 = g9.a.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f70856c
                int r0 = r0.get()
                r1 = 1
                if (r0 == r1) goto L_0x0126
                g9.a r0 = g9.a.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f70856c
                int r0 = r0.get()
                r2 = 2
                if (r0 == r2) goto L_0x0126
                g9.a r0 = g9.a.this
                boolean r0 = r0.f70861h
                if (r0 == 0) goto L_0x0126
                g9.a r0 = g9.a.this
                boolean r0 = r0.f70860g
                if (r0 != 0) goto L_0x005b
                goto L_0x0126
            L_0x005b:
                f9.b r0 = f9.b.a()
                r0.d(r6)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                g9.a r2 = g9.a.this
                java.lang.String r2 = r2.f70862i
                r0.append(r2)
                java.lang.String r2 = "-->cxj, keeper.reConnect-->state = "
                r0.append(r2)
                g9.a r2 = g9.a.this
                java.util.concurrent.atomic.AtomicInteger r2 = r2.f70856c
                int r2 = r2.get()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                com.hbg.lib.network.retrofit.util.RetrofitLogger.a(r0)
                g9.a r0 = g9.a.this
                c9.b r0 = r0.f70863j
                r2 = 0
                if (r0 == 0) goto L_0x00c9
                g9.a r0 = g9.a.this
                c9.b r0 = r0.f70863j
                java.lang.String r0 = r0.getWebSocketHost()
                g9.a r3 = g9.a.this
                g9.i r3 = r3.f70854a
                java.lang.String r3 = r3.o()
                if (r0 == 0) goto L_0x00c9
                boolean r4 = r0.contains(r3)
                if (r4 != 0) goto L_0x00c9
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "cxj, newHost:"
                r4.append(r5)
                r4.append(r0)
                java.lang.String r5 = ", oldHost:"
                r4.append(r5)
                r4.append(r3)
                java.lang.String r3 = r4.toString()
                com.hbg.lib.network.retrofit.util.RetrofitLogger.a(r3)
                goto L_0x00ca
            L_0x00c9:
                r0 = r2
            L_0x00ca:
                if (r0 == 0) goto L_0x00d6
                g9.a r3 = g9.a.this
                g9.i r3 = r3.f70854a
                r3.m(r0)
                goto L_0x00df
            L_0x00d6:
                g9.a r0 = g9.a.this
                g9.i r0 = r0.f70854a
                r0.l()
            L_0x00df:
                g9.a r0 = g9.a.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.f70856c
                r0.set(r1)
                g9.a r0 = g9.a.this
                r0.s()
                g9.a r0 = g9.a.this
                g9.a.i(r0)
                g9.a r0 = g9.a.this
                int r0 = r0.f70865l
                r1 = 10
                if (r0 < r1) goto L_0x0126
                com.hbg.lib.network.retrofit.websocket.bean.SocketReportBean r0 = new com.hbg.lib.network.retrofit.websocket.bean.SocketReportBean     // Catch:{ Exception -> 0x011c }
                g9.a r1 = g9.a.this     // Catch:{ Exception -> 0x011c }
                java.lang.String r1 = r1.f70862i     // Catch:{ Exception -> 0x011c }
                g9.a r3 = g9.a.this     // Catch:{ Exception -> 0x011c }
                g9.i r3 = r3.f70854a     // Catch:{ Exception -> 0x011c }
                java.lang.String r3 = r3.o()     // Catch:{ Exception -> 0x011c }
                java.lang.String r4 = "connectError"
                r0.<init>(r1, r2, r3, r4)     // Catch:{ Exception -> 0x011c }
                com.hbg.lib.network.retrofit.util.RetrofitLogger.e(r0)     // Catch:{ Exception -> 0x011c }
                java.lang.String r0 = "Socket_error_report"
                java.lang.String r1 = "socket_report-->reConnect-->重连超过10次，上报。"
                com.hbg.lib.network.retrofit.util.RetrofitLogger.h(r0, r1)     // Catch:{ Exception -> 0x011c }
                goto L_0x0120
            L_0x011c:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0120:
                g9.a r0 = g9.a.this
                r1 = 0
                int unused = r0.f70865l = r1
            L_0x0126:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g9.a.b.run():void");
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            RetrofitLogger.a(a.this.f70862i + "-->cxj, keeper.Looping-->" + a.this.f70860g);
            f9.b.a().b(a.this.f70866m);
            if (a.this.f70860g) {
                f9.b.a().c(a.this.f70867n, a.this.p());
            }
        }
    }

    public interface d {
        void a();
    }

    public a(String str, i iVar, c9.b bVar) {
        this.f70862i = str;
        this.f70854a = iVar;
        this.f70863j = bVar;
    }

    public static /* synthetic */ int i(a aVar) {
        int i11 = aVar.f70865l;
        aVar.f70865l = i11 + 1;
        return i11;
    }

    public void m(d dVar) {
        synchronized (f70852o) {
            if (!this.f70859f.contains(dVar)) {
                this.f70859f.add(dVar);
            }
        }
    }

    public final void n() {
        this.f70865l = 0;
        this.f70861h = true;
        this.f70856c.set(2);
        f9.b.a().d(this.f70866m);
        f9.b.a().d(this.f70864k);
        f9.b.a().c(this.f70864k, CDNDownload.DEFAULT_TIMEOUT);
    }

    public void o() {
        if (System.currentTimeMillis() - this.f70858e >= 3000) {
            this.f70858e = System.currentTimeMillis();
            i iVar = this.f70854a;
            String str = this.f70862i;
            iVar.t(new HeartBeatInfo.Ping(str != null && str.contains(RemoteMessageConst.NOTIFICATION)));
            if (this.f70857d) {
                f9.b.a().c(this.f70866m, 3000);
            }
        }
    }

    public void onClosed(WebSocket webSocket, int i11, String str) {
        super.onClosed(webSocket, i11, str);
        this.f70856c.set(0);
        RetrofitLogger.a(this.f70862i + "-->cxj, keeper.onClosed-->state = " + this.f70856c.get());
    }

    public void onClosing(WebSocket webSocket, int i11, String str) {
        super.onClosing(webSocket, i11, str);
        this.f70856c.set(0);
        RetrofitLogger.a(this.f70862i + "-->cxj, keeper.onClosing-->state = " + this.f70856c.get());
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        this.f70861h = true;
        this.f70856c.set(0);
        RetrofitLogger.a(this.f70862i + "-->cxj, keeper.onFailure-->state = " + this.f70856c.get());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0097 A[SYNTHETIC, Splitter:B:51:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1 A[SYNTHETIC, Splitter:B:56:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ab A[SYNTHETIC, Splitter:B:61:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b5 A[SYNTHETIC, Splitter:B:66:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00c4 A[SYNTHETIC, Splitter:B:74:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ce A[SYNTHETIC, Splitter:B:79:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00d8 A[SYNTHETIC, Splitter:B:84:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00e2 A[SYNTHETIC, Splitter:B:89:0x00e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(okhttp3.WebSocket r7, okio.ByteString r8) {
        /*
            r6 = this;
            super.onMessage((okhttp3.WebSocket) r7, (okio.ByteString) r8)
            r7 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0076, all -> 0x006f }
            byte[] r8 = r8.toByteArray()     // Catch:{ IOException -> 0x0076, all -> 0x006f }
            r0.<init>(r8)     // Catch:{ IOException -> 0x0076, all -> 0x006f }
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r8.<init>(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0064, all -> 0x005e }
            java.lang.String r2 = "UTF-8"
            r1.<init>(r8, r2)     // Catch:{ IOException -> 0x0064, all -> 0x005e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0059, all -> 0x0053 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0059, all -> 0x0053 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x0051 }
            r7.<init>()     // Catch:{ IOException -> 0x0051 }
        L_0x0023:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0051 }
            if (r3 == 0) goto L_0x002d
            r7.append(r3)     // Catch:{ IOException -> 0x0051 }
            goto L_0x0023
        L_0x002d:
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0051 }
            r6.q(r7)     // Catch:{ IOException -> 0x0051 }
            r2.close()     // Catch:{ Exception -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r7 = move-exception
            r7.printStackTrace()
        L_0x003c:
            r1.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0044:
            r8.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r7 = move-exception
            r7.printStackTrace()
        L_0x004c:
            r0.close()     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00bd
        L_0x0051:
            r7 = move-exception
            goto L_0x007c
        L_0x0053:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
            goto L_0x00c2
        L_0x0059:
            r2 = move-exception
            r5 = r2
            r2 = r7
            r7 = r5
            goto L_0x007c
        L_0x005e:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r1 = r2
            goto L_0x00c2
        L_0x0064:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r1 = r2
            goto L_0x007c
        L_0x0069:
            r8 = move-exception
            r1 = r7
            goto L_0x0072
        L_0x006c:
            r8 = move-exception
            r1 = r7
            goto L_0x0079
        L_0x006f:
            r8 = move-exception
            r0 = r7
            r1 = r0
        L_0x0072:
            r2 = r1
            r7 = r8
            r8 = r2
            goto L_0x00c2
        L_0x0076:
            r8 = move-exception
            r0 = r7
            r1 = r0
        L_0x0079:
            r2 = r1
            r7 = r8
            r8 = r2
        L_0x007c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r3.<init>()     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = r6.f70862i     // Catch:{ all -> 0x00c1 }
            r3.append(r4)     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "-->keeper-->onMessage-->"
            r3.append(r4)     // Catch:{ all -> 0x00c1 }
            r3.append(r7)     // Catch:{ all -> 0x00c1 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x00c1 }
            com.hbg.lib.network.retrofit.util.RetrofitLogger.b(r7)     // Catch:{ all -> 0x00c1 }
            if (r2 == 0) goto L_0x009f
            r2.close()     // Catch:{ Exception -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x009f:
            if (r1 == 0) goto L_0x00a9
            r1.close()     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00a9:
            if (r8 == 0) goto L_0x00b3
            r8.close()     // Catch:{ Exception -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00b3:
            if (r0 == 0) goto L_0x00bd
            r0.close()     // Catch:{ Exception -> 0x00b9 }
            goto L_0x00bd
        L_0x00b9:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00bd:
            r6.n()
            return
        L_0x00c1:
            r7 = move-exception
        L_0x00c2:
            if (r2 == 0) goto L_0x00cc
            r2.close()     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00cc
        L_0x00c8:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00cc:
            if (r1 == 0) goto L_0x00d6
            r1.close()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00d6:
            if (r8 == 0) goto L_0x00e0
            r8.close()     // Catch:{ Exception -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00e0:
            if (r0 == 0) goto L_0x00ea
            r0.close()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00ea:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.a.onMessage(okhttp3.WebSocket, okio.ByteString):void");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        n();
    }

    public final int p() {
        int nextInt = f70853p.nextInt(5000) + 5000;
        RetrofitLogger.a(this.f70862i + "-->cxj, keeper-->getDelayTime-->" + nextInt);
        return nextInt;
    }

    public final void q(String str) {
        if (str.startsWith("{\"ping\":") || str.contains("\"op\":\"ping\"")) {
            this.f70855b.setPing(str);
            this.f70854a.t(this.f70855b);
        }
    }

    public boolean r() {
        return this.f70856c.get() == 2;
    }

    public void s() {
        synchronized (f70852o) {
            for (d next : this.f70859f) {
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void t(d dVar) {
        synchronized (f70852o) {
            this.f70859f.remove(dVar);
        }
    }

    public void u() {
        RetrofitLogger.a(this.f70862i + "-->cxj, keeper.startLoop-->");
        this.f70860g = true;
        f9.b.a().d(this.f70867n);
        f9.b.a().c(this.f70867n, p());
    }

    public void v() {
        RetrofitLogger.a(this.f70862i + "-->cxj, keeper.stopLoop-->");
        this.f70860g = false;
        f9.b.a().d(this.f70866m);
        f9.b.a().d(this.f70867n);
    }

    public void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        q(str);
        n();
    }
}
