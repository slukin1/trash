package g9;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketReq;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSub;
import com.hbg.lib.network.retrofit.websocket.bean.SocketReportBean;
import com.hbg.lib.network.retrofit.websocket.bean.SocketTimeBean;
import g9.a;
import h9.b;
import h9.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

public class i implements b {

    /* renamed from: m  reason: collision with root package name */
    public static final Set<String> f70888m;

    /* renamed from: a  reason: collision with root package name */
    public b f70889a;

    /* renamed from: b  reason: collision with root package name */
    public String f70890b;

    /* renamed from: c  reason: collision with root package name */
    public String f70891c;

    /* renamed from: d  reason: collision with root package name */
    public OkHttpClient f70892d;

    /* renamed from: e  reason: collision with root package name */
    public WebSocket f70893e;

    /* renamed from: f  reason: collision with root package name */
    public h f70894f;

    /* renamed from: g  reason: collision with root package name */
    public e f70895g;

    /* renamed from: h  reason: collision with root package name */
    public a f70896h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70897i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, SocketTimeBean> f70898j = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, SocketTimeBean> f70899k = new ConcurrentHashMap();

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, SocketTimeBean> f70900l = new ConcurrentHashMap();

    static {
        HashSet hashSet = new HashSet();
        f70888m = hashSet;
        hashSet.add("btcusdt");
        hashSet.add("ethusdt");
        hashSet.add("htxusdt");
    }

    public i(String str, OkHttpClient okHttpClient, c9.b bVar) {
        this.f70890b = str;
        this.f70889a = new b(str);
        a aVar = new a(this.f70890b, this, bVar);
        this.f70896h = aVar;
        this.f70889a.a(aVar);
        h hVar = new h(this.f70890b, this.f70896h);
        this.f70894f = hVar;
        this.f70889a.a(hVar);
        e eVar = new e(this.f70890b, this);
        this.f70895g = eVar;
        this.f70889a.a(eVar);
        this.f70892d = okHttpClient;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f70899k.remove(str);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f70898j.remove(str);
        }
    }

    public void c(String str) {
        SocketTimeBean socketTimeBean;
        try {
            synchronized (this.f70900l) {
                if (!this.f70900l.isEmpty() && (socketTimeBean = this.f70900l.get(str)) != null) {
                    if (socketTimeBean.getTime() == 0) {
                        socketTimeBean.setTime(System.currentTimeMillis());
                    } else if (System.currentTimeMillis() - socketTimeBean.getTime() >= 60000) {
                        RetrofitLogger.e(new SocketReportBean(this.f70890b, str, this.f70891c, SocketReportBean.SUB_RESPONSE_ERROR));
                        socketTimeBean.setTime(0);
                        RetrofitLogger.h("Socket_error_report", "socket_report-->WebSocketAgent-->onMsgReturn-->超过1分钟未收到消息，上报。然后时间归零");
                    } else {
                        socketTimeBean.setTime(System.currentTimeMillis());
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public ISocketSend d(String str) {
        SocketTimeBean socketTimeBean = this.f70899k.get(str);
        if (socketTimeBean != null) {
            return socketTimeBean.getSocketSend();
        }
        return null;
    }

    public void e() {
        if (!this.f70898j.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Map.Entry next : this.f70898j.entrySet()) {
                SocketTimeBean socketTimeBean = (SocketTimeBean) next.getValue();
                if (System.currentTimeMillis() - socketTimeBean.getTime() >= 3000 && socketTimeBean.getResendTimes() < 3) {
                    socketTimeBean.setTime(System.currentTimeMillis());
                    socketTimeBean.setResendTimes(socketTimeBean.getResendTimes() + 1);
                    this.f70894f.g(socketTimeBean.getSocketSend());
                    RetrofitLogger.g(this.f70890b + " Socket-->request resendMsg " + socketTimeBean);
                }
                if (socketTimeBean.getResendTimes() >= 3) {
                    arrayList.add((String) next.getKey());
                    try {
                        RetrofitLogger.e(new SocketReportBean(this.f70890b, (String) next.getKey(), this.f70891c, SocketReportBean.REQ_REQUEST_ERROR));
                        RetrofitLogger.h("Socket_error_report", "WebSocketAgent-->resendMsg-->重发消息超过次数，上报");
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }
            for (String remove : arrayList) {
                this.f70898j.remove(remove);
            }
        }
        if (!this.f70899k.isEmpty()) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (Map.Entry next2 : this.f70899k.entrySet()) {
                SocketTimeBean socketTimeBean2 = (SocketTimeBean) next2.getValue();
                if (System.currentTimeMillis() - socketTimeBean2.getTime() >= 3000 && socketTimeBean2.getResendTimes() < 3) {
                    socketTimeBean2.setTime(System.currentTimeMillis());
                    socketTimeBean2.setResendTimes(socketTimeBean2.getResendTimes() + 1);
                    this.f70894f.g(socketTimeBean2.getSocketSend());
                    RetrofitLogger.g(this.f70890b + "Socket-->sub resendMsg " + socketTimeBean2);
                }
                if (socketTimeBean2.getResendTimes() >= 3) {
                    arrayList2.add((String) next2.getKey());
                    try {
                        RetrofitLogger.e(new SocketReportBean(this.f70890b, (String) next2.getKey(), this.f70891c, SocketReportBean.SUB_REQUEST_ERROR));
                        RetrofitLogger.h("Socket_error_report", "WebSocketAgent-->resendMsg-->重发消息超过次数，上报");
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
            for (String remove2 : arrayList2) {
                this.f70899k.remove(remove2);
            }
        }
    }

    public ISocketSend f(String str) {
        SocketTimeBean socketTimeBean = this.f70898j.get(str);
        if (socketTimeBean != null) {
            return socketTimeBean.getSocketSend();
        }
        return null;
    }

    public void g(String str) {
        SocketTimeBean socketTimeBean;
        synchronized (this.f70900l) {
            try {
                if (!this.f70900l.isEmpty() && (socketTimeBean = this.f70900l.get(str)) != null) {
                    socketTimeBean.setTime(System.currentTimeMillis());
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void h(a.d dVar) {
        a aVar = this.f70896h;
        if (aVar != null) {
            aVar.m(dVar);
        }
    }

    public final void i(String str, ISocketSend iSocketSend) {
        if (!TextUtils.isEmpty(str)) {
            RetrofitLogger.g(this.f70890b + " Socket-->addReqMsgToResend " + iSocketSend);
            SocketTimeBean socketTimeBean = new SocketTimeBean();
            socketTimeBean.setSocketSend(iSocketSend);
            socketTimeBean.setTime(System.currentTimeMillis());
            this.f70898j.put(str, socketTimeBean);
        }
    }

    public final void j(String str, ISocketSend iSocketSend) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (this.f70900l) {
                    if (!"contract".equals(this.f70890b) && !"swap".equals(this.f70890b)) {
                        if (!"index".equals(this.f70890b)) {
                            for (String contains : f70888m) {
                                if (str.toLowerCase().contains(contains)) {
                                    SocketTimeBean socketTimeBean = new SocketTimeBean();
                                    socketTimeBean.setSocketSend(iSocketSend);
                                    this.f70900l.put(str, socketTimeBean);
                                }
                            }
                        }
                    }
                    SocketTimeBean socketTimeBean2 = new SocketTimeBean();
                    socketTimeBean2.setSocketSend(iSocketSend);
                    this.f70900l.put(str, socketTimeBean2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void k(String str, ISocketSend iSocketSend) {
        if (!TextUtils.isEmpty(str)) {
            RetrofitLogger.g(this.f70890b + " Socket-->addSubMsgToResend " + iSocketSend);
            SocketTimeBean socketTimeBean = new SocketTimeBean();
            socketTimeBean.setSocketSend(iSocketSend);
            socketTimeBean.setTime(System.currentTimeMillis());
            this.f70899k.put(str, socketTimeBean);
        }
    }

    public void l() {
        m(this.f70891c);
    }

    public void m(String str) {
        this.f70891c = str;
        RetrofitLogger.a(this.f70890b + "-->new WebSocketAgent-->url:" + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f70890b);
        sb2.append("-->Socket-->connect");
        RetrofitLogger.g(sb2.toString());
        this.f70895g.i(str);
        n();
        this.f70897i = true;
        this.f70893e = this.f70892d.newWebSocket(new Request.Builder().url(this.f70891c).build(), this.f70889a);
        a aVar = this.f70896h;
        aVar.f70857d = true;
        aVar.u();
    }

    public void n() {
        RetrofitLogger.g(this.f70890b + "-->Socket-->disConnect");
        a aVar = this.f70896h;
        aVar.f70857d = false;
        aVar.v();
        WebSocket webSocket = this.f70893e;
        if (webSocket != null) {
            webSocket.close(1000, "shutdown by client");
        }
        try {
            synchronized (this.f70900l) {
                this.f70900l.clear();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f70897i = false;
    }

    public String o() {
        return this.f70891c;
    }

    public boolean p() {
        return this.f70896h.r();
    }

    public boolean q() {
        return this.f70897i;
    }

    public void r(a.d dVar) {
        a aVar = this.f70896h;
        if (aVar != null) {
            aVar.t(dVar);
        }
    }

    public final void s(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                synchronized (this.f70900l) {
                    this.f70900l.remove(str);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void t(ISocketSend iSocketSend) {
        u(iSocketSend, (c) null);
    }

    public void u(ISocketSend iSocketSend, c cVar) {
        String channel = iSocketSend.getChannel();
        if (iSocketSend instanceof ISocketSub) {
            ISocketSub iSocketSub = (ISocketSub) iSocketSend;
            this.f70895g.d(channel, cVar, iSocketSub.isSubscribe(), true);
            if (iSocketSub.isSubscribe()) {
                this.f70894f.g(iSocketSend);
                k(channel, iSocketSend);
                j(channel, iSocketSend);
            } else if (!this.f70895g.f(channel)) {
                this.f70894f.g(iSocketSend);
                a(channel);
                s(channel);
            }
        } else if (iSocketSend instanceof ISocketReq) {
            this.f70895g.d(channel, cVar, true, false);
            this.f70894f.g(iSocketSend);
            i(channel, iSocketSend);
        } else {
            this.f70894f.g(iSocketSend);
        }
    }
}
