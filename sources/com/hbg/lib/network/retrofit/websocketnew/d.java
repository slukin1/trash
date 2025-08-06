package com.hbg.lib.network.retrofit.websocketnew;

import android.text.TextUtils;
import android.util.Log;
import c9.b;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketReq;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSub;
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.hbg.lib.network.retrofit.websocketnew.base.IPSocketSend;
import com.hbg.lib.network.retrofit.websocketnew.base.PSocketTimeBean;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k9.a;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

public class d implements a {

    /* renamed from: n  reason: collision with root package name */
    public static final Set<String> f70739n;

    /* renamed from: a  reason: collision with root package name */
    public PSocketListenerDispatcher f70740a;

    /* renamed from: b  reason: collision with root package name */
    public String f70741b;

    /* renamed from: c  reason: collision with root package name */
    public String f70742c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f70743d;

    /* renamed from: e  reason: collision with root package name */
    public OkHttpClient f70744e;

    /* renamed from: f  reason: collision with root package name */
    public WebSocket f70745f;

    /* renamed from: g  reason: collision with root package name */
    public c f70746g;

    /* renamed from: h  reason: collision with root package name */
    public b f70747h;

    /* renamed from: i  reason: collision with root package name */
    public a f70748i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f70749j;

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, PSocketTimeBean> f70750k = new ConcurrentHashMap();

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, PSocketTimeBean> f70751l = new ConcurrentHashMap();

    /* renamed from: m  reason: collision with root package name */
    public final Map<String, PSocketTimeBean> f70752m = new ConcurrentHashMap();

    static {
        HashSet hashSet = new HashSet();
        f70739n = hashSet;
        hashSet.add("btcusdt");
        hashSet.add("ethusdt");
        hashSet.add("htusdt");
    }

    public d(String str, OkHttpClient okHttpClient, b bVar, PSocketListenerDispatcher.PWebSocketListener pWebSocketListener) {
        this.f70741b = str;
        this.f70740a = new PSocketListenerDispatcher(str);
        a aVar = new a(this.f70741b, this, bVar, pWebSocketListener);
        this.f70748i = aVar;
        this.f70740a.a(aVar);
        c cVar = new c(this.f70741b, this.f70748i);
        this.f70746g = cVar;
        this.f70740a.a(cVar);
        i(pWebSocketListener);
        this.f70740a.a(this.f70747h);
        this.f70744e = okHttpClient;
    }

    public final void a(String str, IPSocketSend iPSocketSend) {
        if (!TextUtils.isEmpty(str)) {
            RetrofitLogger.g(this.f70741b + " Socket-->addReqMsgToResend " + iPSocketSend);
            PSocketTimeBean pSocketTimeBean = new PSocketTimeBean();
            pSocketTimeBean.setSocketSend(iPSocketSend);
            pSocketTimeBean.setTime(System.currentTimeMillis());
            this.f70750k.put(str, pSocketTimeBean);
        }
    }

    public final void b(String str, IPSocketSend iPSocketSend) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (this.f70752m) {
                    if (!"contract".equals(this.f70741b) && !"swap".equals(this.f70741b)) {
                        if (!"index".equals(this.f70741b)) {
                            for (String contains : f70739n) {
                                if (str.toLowerCase().contains(contains)) {
                                    PSocketTimeBean pSocketTimeBean = new PSocketTimeBean();
                                    pSocketTimeBean.setSocketSend(iPSocketSend);
                                    this.f70752m.put(str, pSocketTimeBean);
                                }
                            }
                        }
                    }
                    PSocketTimeBean pSocketTimeBean2 = new PSocketTimeBean();
                    pSocketTimeBean2.setSocketSend(iPSocketSend);
                    this.f70752m.put(str, pSocketTimeBean2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void c(String str, IPSocketSend iPSocketSend) {
        if (!TextUtils.isEmpty(str)) {
            RetrofitLogger.g(this.f70741b + " Socket-->addSubMsgToResend " + iPSocketSend);
            PSocketTimeBean pSocketTimeBean = new PSocketTimeBean();
            pSocketTimeBean.setSocketSend(iPSocketSend);
            pSocketTimeBean.setTime(System.currentTimeMillis());
            this.f70751l.put(str, pSocketTimeBean);
        }
    }

    public void d() {
        f(this.f70742c, this.f70743d);
    }

    public void e(String str) {
        this.f70742c = str;
        f(str, this.f70743d);
    }

    public void f(String str, Map<String, String> map) {
        this.f70742c = str;
        this.f70743d = map;
        RetrofitLogger.a(this.f70741b + "PWebSocketAgentChat--connect>url:" + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f70741b);
        sb2.append("PWebSocketAgentChat-->connect");
        RetrofitLogger.g(sb2.toString());
        this.f70747h.h(str);
        g();
        this.f70749j = true;
        Request.Builder url = new Request.Builder().url(this.f70742c);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                url.header((String) next.getKey(), (String) next.getValue());
            }
        }
        this.f70745f = this.f70744e.newWebSocket(url.build(), this.f70740a);
        a aVar = this.f70748i;
        aVar.f70682d = true;
        aVar.u();
    }

    public void g() {
        RetrofitLogger.g(this.f70741b + "-->Socket-->disConnect");
        a aVar = this.f70748i;
        aVar.f70682d = false;
        aVar.v();
        WebSocket webSocket = this.f70745f;
        if (webSocket != null) {
            webSocket.close(1000, "shutdown by client");
        }
        try {
            synchronized (this.f70752m) {
                this.f70752m.clear();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f70749j = false;
    }

    public String h() {
        return this.f70742c;
    }

    public void i(PSocketListenerDispatcher.PWebSocketListener pWebSocketListener) {
        this.f70747h = new b(this.f70741b, this, pWebSocketListener);
    }

    public boolean j() {
        return this.f70748i.r();
    }

    public final void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (this.f70752m) {
                    this.f70752m.remove(str);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void l(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f70751l.remove(str);
        }
    }

    public void m(IPSocketSend iPSocketSend) {
        Log.e("send---ws", iPSocketSend.getByteString().toString() + "");
        Log.e("send---ws", iPSocketSend.getClass().getName() + "");
        n(iPSocketSend, (k9.b) null);
    }

    public void n(IPSocketSend iPSocketSend, k9.b bVar) {
        String channel = iPSocketSend.getChannel();
        if (iPSocketSend instanceof ISocketSub) {
            ISocketSub iSocketSub = (ISocketSub) iPSocketSend;
            this.f70747h.f(channel, bVar, iSocketSub.isSubscribe(), true);
            if (iSocketSub.isSubscribe()) {
                this.f70746g.m(iPSocketSend);
                c(channel, iPSocketSend);
                b(channel, iPSocketSend);
            } else if (!this.f70747h.g(channel)) {
                this.f70746g.m(iPSocketSend);
                l(channel);
                k(channel);
            }
        } else if (iPSocketSend instanceof ISocketReq) {
            this.f70747h.f(channel, bVar, true, false);
            this.f70746g.m(iPSocketSend);
            a(channel, iPSocketSend);
        } else {
            this.f70746g.m(iPSocketSend);
        }
    }
}
