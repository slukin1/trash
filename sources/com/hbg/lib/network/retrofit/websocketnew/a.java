package com.hbg.lib.network.retrofit.websocketnew;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.hbg.lib.network.retrofit.websocketnew.base.PPing;
import com.hbg.lib.network.retrofit.websocketnew.base.PPong;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsChannel;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsReceiveAction;
import com.huobi.websocket.protobuf.source.Message$Proto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

public class a extends PSocketListenerDispatcher.PWebSocketListener {

    /* renamed from: o  reason: collision with root package name */
    public static final Object f70677o = new Object();

    /* renamed from: p  reason: collision with root package name */
    public static final Random f70678p = new Random();

    /* renamed from: a  reason: collision with root package name */
    public d f70679a;

    /* renamed from: b  reason: collision with root package name */
    public PPong f70680b = new PPong();

    /* renamed from: c  reason: collision with root package name */
    public AtomicInteger f70681c = new AtomicInteger(0);

    /* renamed from: d  reason: collision with root package name */
    public boolean f70682d = false;

    /* renamed from: e  reason: collision with root package name */
    public long f70683e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final List<h> f70684f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f70685g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70686h;

    /* renamed from: i  reason: collision with root package name */
    public String f70687i;

    /* renamed from: j  reason: collision with root package name */
    public c9.b f70688j;

    /* renamed from: k  reason: collision with root package name */
    public PSocketListenerDispatcher.PWebSocketListener f70689k;

    /* renamed from: l  reason: collision with root package name */
    public int f70690l;

    /* renamed from: m  reason: collision with root package name */
    public Runnable f70691m = new C0774a();

    /* renamed from: n  reason: collision with root package name */
    public Runnable f70692n = new b();

    /* renamed from: com.hbg.lib.network.retrofit.websocketnew.a$a  reason: collision with other inner class name */
    public class C0774a implements Runnable {
        public C0774a() {
        }

        public void run() {
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.reConnect--> state = " + a.this.f70681c.get() + " canReconnect = " + a.this.f70686h);
            if (a.this.f70681c.get() != 1 && a.this.f70681c.get() != 2 && a.this.f70686h && a.this.f70685g) {
                f9.b.a().d(this);
                RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.reConnect-->state = " + a.this.f70681c.get());
                String str = null;
                if (a.this.f70688j != null) {
                    String webSocketHost = a.this.f70688j.getWebSocketHost();
                    String h11 = a.this.f70679a.h();
                    if (webSocketHost != null && !webSocketHost.contains(h11)) {
                        str = webSocketHost;
                    }
                }
                if (str != null) {
                    a.this.f70679a.e(str);
                } else {
                    a.this.f70679a.d();
                }
                a.this.f70681c.set(1);
                a.this.t();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->mLoopRunnable-->" + a.this.f70685g);
            f9.b.a().b(a.this.f70691m);
            if (!a.this.f70685g) {
                return;
            }
            if (a.this.f70689k == null || a.this.f70689k.a()) {
                f9.b.a().c(a.this.f70692n, a.this.q());
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebSocket f70695b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Response f70696c;

        public c(WebSocket webSocket, Response response) {
            this.f70695b = webSocket;
            this.f70696c = response;
        }

        public void run() {
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.onOpen-->");
            a.this.f70689k.onOpen(this.f70695b, this.f70696c);
            a.this.o();
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Message$Proto f70698b;

        public d(Message$Proto message$Proto) {
            this.f70698b = message$Proto;
        }

        public void run() {
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.onMsgArrived-->");
            if (a.this.s(this.f70698b)) {
                a.this.o();
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebSocket f70700b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f70701c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f70702d;

        public e(WebSocket webSocket, int i11, String str) {
            this.f70700b = webSocket;
            this.f70701c = i11;
            this.f70702d = str;
        }

        public void run() {
            a.this.f70681c.set(0);
            a.this.f70689k.onClosed(this.f70700b, this.f70701c, this.f70702d);
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.onClosing-->reason = " + this.f70702d + " code=" + this.f70701c);
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebSocket f70704b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f70705c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f70706d;

        public f(WebSocket webSocket, int i11, String str) {
            this.f70704b = webSocket;
            this.f70705c = i11;
            this.f70706d = str;
        }

        public void run() {
            a.this.f70681c.set(0);
            a.this.f70689k.onClosed(this.f70704b, this.f70705c, this.f70706d);
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.onClosed-->reason = " + this.f70706d + " code=" + this.f70705c);
        }
    }

    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebSocket f70708b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Throwable f70709c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Response f70710d;

        public g(WebSocket webSocket, Throwable th2, Response response) {
            this.f70708b = webSocket;
            this.f70709c = th2;
            this.f70710d = response;
        }

        public void run() {
            boolean unused = a.this.f70686h = true;
            a.this.f70681c.set(0);
            a.this.f70689k.onFailure(this.f70708b, this.f70709c, this.f70710d);
            RetrofitLogger.a(a.this.f70687i + "PSocketKeeper-->keeper.onFailure-->Throwable = " + this.f70709c.getMessage());
        }
    }

    public interface h {
        void a();
    }

    public a(String str, d dVar, c9.b bVar, PSocketListenerDispatcher.PWebSocketListener pWebSocketListener) {
        this.f70687i = str;
        this.f70679a = dVar;
        this.f70688j = bVar;
        this.f70689k = pWebSocketListener;
    }

    public boolean a() {
        PSocketListenerDispatcher.PWebSocketListener pWebSocketListener = this.f70689k;
        if (pWebSocketListener != null) {
            return pWebSocketListener.a();
        }
        return true;
    }

    public void b(Message$Proto message$Proto) {
        f9.b.a().b(new d(message$Proto));
    }

    public final void o() {
        this.f70690l = 0;
        this.f70686h = true;
        this.f70681c.set(2);
        f9.b.a().d(this.f70691m);
    }

    public void onClosed(WebSocket webSocket, int i11, String str) {
        super.onClosed(webSocket, i11, str);
        f9.b.a().b(new f(webSocket, i11, str));
    }

    public void onClosing(WebSocket webSocket, int i11, String str) {
        super.onClosing(webSocket, i11, str);
        f9.b.a().b(new e(webSocket, i11, str));
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
        super.onFailure(webSocket, th2, response);
        f9.b.a().b(new g(webSocket, th2, response));
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        f9.b.a().b(new c(webSocket, response));
    }

    public void p() {
        if (System.currentTimeMillis() - this.f70683e >= 3000) {
            this.f70683e = System.currentTimeMillis();
            this.f70679a.m(new PPing());
            if (this.f70682d) {
                f9.b.a().c(this.f70691m, 3000);
            }
        }
    }

    public final int q() {
        int nextInt = f70678p.nextInt(5000) + 5000;
        RetrofitLogger.a(this.f70687i + "PSocketKeeper-->keeper-->getDelayTime-->" + nextInt);
        return nextInt;
    }

    public boolean r() {
        return this.f70681c.get() == 2;
    }

    public final boolean s(Message$Proto message$Proto) {
        try {
            if (!TextUtils.equals(String.valueOf(message$Proto.getChannel()), POtcWsChannel.wps.getValue()) || message$Proto.getAction() != POtcWsReceiveAction.Action_1000.getValue()) {
                return false;
            }
            RetrofitLogger.b(this.f70687i + "PSocketKeeper----收到心跳请求");
            this.f70679a.m(new PPong());
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public void t() {
        synchronized (f70677o) {
            for (h next : this.f70684f) {
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void u() {
        RetrofitLogger.a(this.f70687i + "PSocketKeeper-->keeper.startLoop-->");
        this.f70685g = true;
        f9.b.a().d(this.f70692n);
        f9.b.a().c(this.f70692n, q());
    }

    public void v() {
        RetrofitLogger.a(this.f70687i + "PSocketKeeper-->keeper.stopLoop-->");
        this.f70685g = false;
        f9.b.a().d(this.f70691m);
        f9.b.a().d(this.f70692n);
    }
}
