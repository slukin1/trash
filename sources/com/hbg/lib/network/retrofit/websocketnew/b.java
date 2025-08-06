package com.hbg.lib.network.retrofit.websocketnew;

import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsChannel;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsReceiveAction;
import com.huobi.websocket.protobuf.source.Message$Proto;
import f9.a;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

public class b extends PSocketListenerDispatcher.PWebSocketListener {

    /* renamed from: h  reason: collision with root package name */
    public static final Object f70712h = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<SoftReference<k9.b>>> f70713a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Set<SoftReference<k9.b>>> f70714b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public k9.a f70715c;

    /* renamed from: d  reason: collision with root package name */
    public f9.a f70716d;

    /* renamed from: e  reason: collision with root package name */
    public String f70717e;

    /* renamed from: f  reason: collision with root package name */
    public String f70718f;

    /* renamed from: g  reason: collision with root package name */
    public PSocketListenerDispatcher.PWebSocketListener f70719g;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Throwable f70720b;

        public a(Throwable th2) {
            this.f70720b = th2;
        }

        public static /* synthetic */ void b(SoftReference softReference, Throwable th2) {
            if (softReference.get() != null) {
                ((k9.b) softReference.get()).onFailed(th2);
            }
        }

        public void run() {
            if (b.this.f70713a != null) {
                for (Set<SoftReference> it2 : b.this.f70713a.values()) {
                    for (SoftReference softReference : it2) {
                        if (softReference.get() != null) {
                            f9.b.a().b(new j9.a(softReference, this.f70720b));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.hbg.lib.network.retrofit.websocketnew.b$b  reason: collision with other inner class name */
    public class C0775b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Message$Proto f70722b;

        public C0775b(Message$Proto message$Proto) {
            this.f70722b = message$Proto;
        }

        public void run() {
            RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher Message---->" + this.f70722b);
            Message$Proto message$Proto = this.f70722b;
            if (message$Proto != null) {
                if (message$Proto.getChannel() == Integer.parseInt(POtcWsChannel.wps.getValue())) {
                    if (this.f70722b.getAction() == POtcWsReceiveAction.Action_200.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 鉴权成功");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_401.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher TOKEN无效");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_429.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 该用户连接数超限");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_1001.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 用户退出登录");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_1002.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 设置语言成功");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_1003.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 订阅主题成功");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_1004.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 取消订阅主题成功");
                    } else if (this.f70722b.getAction() == POtcWsReceiveAction.Action_1005.getValue()) {
                        RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher 发起获取离线消息请求成功");
                    }
                } else if (this.f70722b.getChannel() == Integer.parseInt(POtcWsChannel.order.getValue())) {
                    RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher order收到业务数据" + this.f70722b.getContent());
                    if (b.this.f70719g != null) {
                        b.this.f70719g.b(this.f70722b);
                    }
                } else if (this.f70722b.getChannel() == Integer.parseInt(POtcWsChannel.chat.getValue())) {
                    RetrofitLogger.a(b.this.f70717e + "PSocketMsgDispatcher chat收到业务数据" + this.f70722b.getContent());
                    if (b.this.f70719g != null) {
                        b.this.f70719g.b(this.f70722b);
                    }
                }
            }
        }
    }

    public b(String str, k9.a aVar, PSocketListenerDispatcher.PWebSocketListener pWebSocketListener) {
        this.f70717e = str;
        this.f70715c = aVar;
        this.f70719g = pWebSocketListener;
        this.f70716d = new f9.a(this.f70717e, (a.C0777a) null);
    }

    public boolean a() {
        return false;
    }

    public void b(Message$Proto message$Proto) {
        f9.b.a().b(new C0775b(message$Proto));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.lang.String r3, k9.b r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Object r0 = f70712h
            monitor-enter(r0)
            if (r6 == 0) goto L_0x000f
            java.util.Map<java.lang.String, java.util.Set<java.lang.ref.SoftReference<k9.b>>> r6 = r2.f70713a     // Catch:{ all -> 0x006c }
            goto L_0x0011
        L_0x000f:
            java.util.Map<java.lang.String, java.util.Set<java.lang.ref.SoftReference<k9.b>>> r6 = r2.f70714b     // Catch:{ all -> 0x006c }
        L_0x0011:
            boolean r1 = r6.containsKey(r3)     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0023
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x006c }
            r1.<init>()     // Catch:{ all -> 0x006c }
            java.util.Set r1 = java.util.Collections.newSetFromMap(r1)     // Catch:{ all -> 0x006c }
            r6.put(r3, r1)     // Catch:{ all -> 0x006c }
        L_0x0023:
            java.lang.Object r3 = r6.get(r3)     // Catch:{ all -> 0x006c }
            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x006c }
            java.util.Iterator r6 = r3.iterator()     // Catch:{ all -> 0x006c }
        L_0x002d:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0043
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x006c }
            java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x002d
            r6.remove()     // Catch:{ all -> 0x006c }
            goto L_0x002d
        L_0x0043:
            java.util.Iterator r6 = r3.iterator()     // Catch:{ all -> 0x006c }
        L_0x0047:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x006c }
            java.lang.ref.SoftReference r1 = (java.lang.ref.SoftReference) r1     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x006c }
            if (r1 != r4) goto L_0x0047
            if (r5 == 0) goto L_0x005d
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x005d:
            r6.remove()     // Catch:{ all -> 0x006c }
        L_0x0060:
            if (r5 == 0) goto L_0x006a
            java.lang.ref.SoftReference r5 = new java.lang.ref.SoftReference     // Catch:{ all -> 0x006c }
            r5.<init>(r4)     // Catch:{ all -> 0x006c }
            r3.add(r5)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x006c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.retrofit.websocketnew.b.f(java.lang.String, k9.b, boolean, boolean):void");
    }

    public boolean g(String str) {
        boolean z11;
        synchronized (f70712h) {
            Set set = this.f70713a.get(str);
            z11 = set != null && !set.isEmpty();
        }
        return z11;
    }

    public void h(String str) {
        this.f70718f = str;
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        f9.b.a().b(new a(th2));
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
    }
}
