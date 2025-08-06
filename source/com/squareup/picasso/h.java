package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final b f30037a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f30038b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f30039c;

    /* renamed from: d  reason: collision with root package name */
    public final i f30040d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, c> f30041e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<Object, a> f30042f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map<Object, a> f30043g = new WeakHashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Set<Object> f30044h = new LinkedHashSet();

    /* renamed from: i  reason: collision with root package name */
    public final Handler f30045i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f30046j;

    /* renamed from: k  reason: collision with root package name */
    public final d f30047k;

    /* renamed from: l  reason: collision with root package name */
    public final t f30048l;

    /* renamed from: m  reason: collision with root package name */
    public final List<c> f30049m;

    /* renamed from: n  reason: collision with root package name */
    public final c f30050n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f30051o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f30052p;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final h f30053a;

        /* renamed from: com.squareup.picasso.h$a$a  reason: collision with other inner class name */
        public class C0266a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Message f30054b;

            public C0266a(Message message) {
                this.f30054b = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f30054b.what);
            }
        }

        public a(Looper looper, h hVar) {
            super(looper);
            this.f30053a = hVar;
        }

        public void handleMessage(Message message) {
            boolean z11 = false;
            switch (message.what) {
                case 1:
                    this.f30053a.v((a) message.obj);
                    return;
                case 2:
                    this.f30053a.o((a) message.obj);
                    return;
                case 4:
                    this.f30053a.p((c) message.obj);
                    return;
                case 5:
                    this.f30053a.u((c) message.obj);
                    return;
                case 6:
                    this.f30053a.q((c) message.obj, false);
                    return;
                case 7:
                    this.f30053a.n();
                    return;
                case 9:
                    this.f30053a.r((NetworkInfo) message.obj);
                    return;
                case 10:
                    h hVar = this.f30053a;
                    if (message.arg1 == 1) {
                        z11 = true;
                    }
                    hVar.m(z11);
                    return;
                case 11:
                    this.f30053a.s(message.obj);
                    return;
                case 12:
                    this.f30053a.t(message.obj);
                    return;
                default:
                    Picasso.f29949p.post(new C0266a(message));
                    return;
            }
        }
    }

    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    public static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final h f30056a;

        public c(h hVar) {
            this.f30056a = hVar;
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f30056a.f30051o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f30056a.f30038b.registerReceiver(this, intentFilter);
        }

        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f30056a.b(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f30056a.f(((ConnectivityManager) y.n(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    public h(Context context, ExecutorService executorService, Handler handler, i iVar, d dVar, t tVar) {
        b bVar = new b();
        this.f30037a = bVar;
        bVar.start();
        y.h(bVar.getLooper());
        this.f30038b = context;
        this.f30039c = executorService;
        this.f30045i = new a(bVar.getLooper(), this);
        this.f30040d = iVar;
        this.f30046j = handler;
        this.f30047k = dVar;
        this.f30048l = tVar;
        this.f30049m = new ArrayList(4);
        this.f30052p = y.p(context);
        this.f30051o = y.o(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar = new c(this);
        this.f30050n = cVar;
        cVar.a();
    }

    public final void a(c cVar) {
        if (!cVar.u()) {
            Bitmap bitmap = cVar.f30019n;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f30049m.add(cVar);
            if (!this.f30045i.hasMessages(7)) {
                this.f30045i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    public void b(boolean z11) {
        Handler handler = this.f30045i;
        handler.sendMessage(handler.obtainMessage(10, z11 ? 1 : 0, 0));
    }

    public void c(a aVar) {
        Handler handler = this.f30045i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    public void d(c cVar) {
        Handler handler = this.f30045i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    public void e(c cVar) {
        Handler handler = this.f30045i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    public void f(NetworkInfo networkInfo) {
        Handler handler = this.f30045i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    public void g(c cVar) {
        Handler handler = this.f30045i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500);
    }

    public void h(a aVar) {
        Handler handler = this.f30045i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    public final void i() {
        if (!this.f30042f.isEmpty()) {
            Iterator<a> it2 = this.f30042f.values().iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                it2.remove();
                if (next.g().f29964n) {
                    y.s("Dispatcher", "replaying", next.i().d());
                }
                w(next, false);
            }
        }
    }

    public final void j(List<c> list) {
        if (list != null && !list.isEmpty() && list.get(0).q().f29964n) {
            StringBuilder sb2 = new StringBuilder();
            for (c next : list) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(y.j(next));
            }
            y.s("Dispatcher", "delivered", sb2.toString());
        }
    }

    public final void k(a aVar) {
        Object k11 = aVar.k();
        if (k11 != null) {
            aVar.f29996k = true;
            this.f30042f.put(k11, aVar);
        }
    }

    public final void l(c cVar) {
        a h11 = cVar.h();
        if (h11 != null) {
            k(h11);
        }
        List<a> i11 = cVar.i();
        if (i11 != null) {
            int size = i11.size();
            for (int i12 = 0; i12 < size; i12++) {
                k(i11.get(i12));
            }
        }
    }

    public void m(boolean z11) {
        this.f30052p = z11;
    }

    public void n() {
        ArrayList arrayList = new ArrayList(this.f30049m);
        this.f30049m.clear();
        Handler handler = this.f30046j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    public void o(a aVar) {
        String d11 = aVar.d();
        c cVar = this.f30041e.get(d11);
        if (cVar != null) {
            cVar.f(aVar);
            if (cVar.c()) {
                this.f30041e.remove(d11);
                if (aVar.g().f29964n) {
                    y.s("Dispatcher", "canceled", aVar.i().d());
                }
            }
        }
        if (this.f30044h.contains(aVar.j())) {
            this.f30043g.remove(aVar.k());
            if (aVar.g().f29964n) {
                y.t("Dispatcher", "canceled", aVar.i().d(), "because paused request got canceled");
            }
        }
        a remove = this.f30042f.remove(aVar.k());
        if (remove != null && remove.g().f29964n) {
            y.t("Dispatcher", "canceled", remove.i().d(), "from replaying");
        }
    }

    public void p(c cVar) {
        if (MemoryPolicy.shouldWriteToMemoryCache(cVar.p())) {
            this.f30047k.b(cVar.n(), cVar.s());
        }
        this.f30041e.remove(cVar.n());
        a(cVar);
        if (cVar.q().f29964n) {
            y.t("Dispatcher", "batched", y.j(cVar), "for completion");
        }
    }

    public void q(c cVar, boolean z11) {
        if (cVar.q().f29964n) {
            String j11 = y.j(cVar);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("for error");
            sb2.append(z11 ? " (will replay)" : "");
            y.t("Dispatcher", "batched", j11, sb2.toString());
        }
        this.f30041e.remove(cVar.n());
        a(cVar);
    }

    public void r(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f30039c;
        if (executorService instanceof p) {
            ((p) executorService).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            i();
        }
    }

    public void s(Object obj) {
        if (this.f30044h.add(obj)) {
            Iterator<c> it2 = this.f30041e.values().iterator();
            while (it2.hasNext()) {
                c next = it2.next();
                boolean z11 = next.q().f29964n;
                a h11 = next.h();
                List<a> i11 = next.i();
                boolean z12 = i11 != null && !i11.isEmpty();
                if (h11 != null || z12) {
                    if (h11 != null && h11.j().equals(obj)) {
                        next.f(h11);
                        this.f30043g.put(h11.k(), h11);
                        if (z11) {
                            y.t("Dispatcher", "paused", h11.f29987b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z12) {
                        for (int size = i11.size() - 1; size >= 0; size--) {
                            a aVar = i11.get(size);
                            if (aVar.j().equals(obj)) {
                                next.f(aVar);
                                this.f30043g.put(aVar.k(), aVar);
                                if (z11) {
                                    y.t("Dispatcher", "paused", aVar.f29987b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.c()) {
                        it2.remove();
                        if (z11) {
                            y.t("Dispatcher", "canceled", y.j(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    public void t(Object obj) {
        if (this.f30044h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<a> it2 = this.f30043g.values().iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next.j().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it2.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.f30046j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public void u(c cVar) {
        if (!cVar.u()) {
            boolean z11 = false;
            if (this.f30039c.isShutdown()) {
                q(cVar, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.f30051o) {
                networkInfo = ((ConnectivityManager) y.n(this.f30038b, "connectivity")).getActiveNetworkInfo();
            }
            if (cVar.w(this.f30052p, networkInfo)) {
                if (cVar.q().f29964n) {
                    y.s("Dispatcher", "retrying", y.j(cVar));
                }
                if (cVar.k() instanceof NetworkRequestHandler.ContentLengthException) {
                    cVar.f30015j |= NetworkPolicy.NO_CACHE.index;
                }
                cVar.f30020o = this.f30039c.submit(cVar);
                return;
            }
            if (this.f30051o && cVar.x()) {
                z11 = true;
            }
            q(cVar, z11);
            if (z11) {
                l(cVar);
            }
        }
    }

    public void v(a aVar) {
        w(aVar, true);
    }

    public void w(a aVar, boolean z11) {
        if (this.f30044h.contains(aVar.j())) {
            this.f30043g.put(aVar.k(), aVar);
            if (aVar.g().f29964n) {
                String d11 = aVar.f29987b.d();
                y.t("Dispatcher", "paused", d11, "because tag '" + aVar.j() + "' is paused");
                return;
            }
            return;
        }
        c cVar = this.f30041e.get(aVar.d());
        if (cVar != null) {
            cVar.b(aVar);
        } else if (!this.f30039c.isShutdown()) {
            c g11 = c.g(aVar.g(), this, this.f30047k, this.f30048l, aVar);
            g11.f30020o = this.f30039c.submit(g11);
            this.f30041e.put(aVar.d(), g11);
            if (z11) {
                this.f30042f.remove(aVar.k());
            }
            if (aVar.g().f29964n) {
                y.s("Dispatcher", "enqueued", aVar.f29987b.d());
            }
        } else if (aVar.g().f29964n) {
            y.t("Dispatcher", "ignored", aVar.f29987b.d(), "because shut down");
        }
    }
}
