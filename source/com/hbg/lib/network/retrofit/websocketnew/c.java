package com.hbg.lib.network.retrofit.websocketnew;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import com.hbg.lib.network.retrofit.websocketnew.PSocketListenerDispatcher;
import com.hbg.lib.network.retrofit.websocketnew.base.IPSocketSend;
import com.hbg.lib.network.retrofit.websocketnew.base.PPing;
import com.hbg.lib.network.retrofit.websocketnew.base.PPong;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsChannel;
import com.hbg.lib.network.retrofit.websocketnew.enums.POtcWsReceiveAction;
import com.huobi.websocket.protobuf.source.Message$Proto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

public class c extends PSocketListenerDispatcher.PWebSocketListener {

    /* renamed from: a  reason: collision with root package name */
    public a f70724a;

    /* renamed from: b  reason: collision with root package name */
    public WebSocket f70725b;

    /* renamed from: c  reason: collision with root package name */
    public final List<IPSocketSend> f70726c = new ArrayList(14);

    /* renamed from: d  reason: collision with root package name */
    public final List<IPSocketSend> f70727d = new ArrayList(14);

    /* renamed from: e  reason: collision with root package name */
    public String f70728e;

    /* renamed from: f  reason: collision with root package name */
    public f9.b f70729f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f70730g = new a();

    /* renamed from: h  reason: collision with root package name */
    public boolean f70731h;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RetrofitLogger.a(c.this.f70728e + "PSocketProducer-->sendRunnable-->messageList:" + c.this.f70726c);
            if (!c.this.f70726c.isEmpty() && c.this.f70724a.r() && c.this.f70725b != null) {
                for (IPSocketSend iPSocketSend : c.this.f70726c) {
                    if (c.this.f70725b != null) {
                        RetrofitLogger.a(c.this.f70728e + "PSocketProducer-->Socket-->send " + iPSocketSend.toString());
                        c.this.f70725b.send(iPSocketSend.getByteString());
                    }
                }
                c.this.f70726c.clear();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebSocket f70733b;

        public b(WebSocket webSocket) {
            this.f70733b = webSocket;
        }

        public void run() {
            WebSocket unused = c.this.f70725b = this.f70733b;
            try {
                for (IPSocketSend h11 : c.this.f70726c) {
                    c.this.n(h11);
                }
            } catch (Exception e11) {
                RetrofitLogger.a(c.this.f70728e + "-->PSocketProducer-->onOpen addMessage exception:" + e11);
            }
            c.this.f70726c.addAll(c.this.f70727d);
            RetrofitLogger.a(c.this.f70728e + "-->PSocketProducer-->onOpen addMessage " + c.this.f70726c.toString());
        }
    }

    /* renamed from: com.hbg.lib.network.retrofit.websocketnew.c$c  reason: collision with other inner class name */
    public class C0776c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Message$Proto f70735b;

        public C0776c(Message$Proto message$Proto) {
            this.f70735b = message$Proto;
        }

        public void run() {
            if (this.f70735b.getChannel() == Integer.parseInt(POtcWsChannel.wps.getValue()) && this.f70735b.getAction() == POtcWsReceiveAction.Action_200.getValue()) {
                RetrofitLogger.a(c.this.f70728e + "PSocketProducer 鉴权成功 发送消息");
                boolean unused = c.this.f70731h = true;
                c.this.f70730g.run();
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IPSocketSend f70737b;

        public d(IPSocketSend iPSocketSend) {
            this.f70737b = iPSocketSend;
        }

        public void run() {
            IPSocketSend iPSocketSend = this.f70737b;
            if (!(iPSocketSend instanceof PPing) && !(iPSocketSend instanceof PPong)) {
                c.this.f70724a.p();
                IPSocketSend iPSocketSend2 = null;
                Iterator it2 = c.this.f70726c.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    IPSocketSend iPSocketSend3 = (IPSocketSend) it2.next();
                    if (iPSocketSend3.isSame(this.f70737b)) {
                        iPSocketSend2 = iPSocketSend3;
                        break;
                    }
                }
                if (iPSocketSend2 != null) {
                    c.this.f70726c.remove(iPSocketSend2);
                }
                c.this.f70726c.add(this.f70737b);
                try {
                    c.this.n(this.f70737b);
                    IPSocketSend iPSocketSend4 = this.f70737b;
                    if (!(iPSocketSend4 instanceof BaseSocketSub)) {
                        c.this.f70727d.add(this.f70737b);
                    } else if (!((BaseSocketSub) iPSocketSend4).isSubscribe()) {
                        Iterator it3 = c.this.f70727d.iterator();
                        while (it3.hasNext()) {
                            IPSocketSend iPSocketSend5 = (IPSocketSend) it3.next();
                            if (!TextUtils.isEmpty(iPSocketSend5.getChannel()) && iPSocketSend5.getChannel().equals(this.f70737b.getChannel())) {
                                it3.remove();
                            }
                        }
                    } else {
                        c.this.f70727d.add(this.f70737b);
                    }
                } catch (Exception e11) {
                    RetrofitLogger.g(c.this.f70728e + "PSocketProducer-->addMessage exception:" + e11);
                }
                RetrofitLogger.g(c.this.f70728e + "PSocketProducer-->addMessage message:" + this.f70737b.toString());
                RetrofitLogger.g(c.this.f70728e + "PSocketProducer-->addMessage temp:" + c.this.f70727d.toString());
                if (c.this.f70731h) {
                    c.this.f70730g.run();
                }
            } else if (c.this.f70725b != null) {
                RetrofitLogger.a(c.this.f70728e + "PSocketProducer-->send-->" + this.f70737b.toString());
                c.this.f70725b.send(this.f70737b.getByteString());
            }
        }
    }

    public c(String str, a aVar) {
        this.f70728e = str;
        this.f70724a = aVar;
        this.f70729f = f9.b.a();
    }

    public boolean a() {
        return false;
    }

    public void b(Message$Proto message$Proto) {
        f9.b.a().b(new C0776c(message$Proto));
    }

    public void m(IPSocketSend iPSocketSend) {
        this.f70729f.b(new d(iPSocketSend));
    }

    public final void n(IPSocketSend iPSocketSend) {
        IPSocketSend iPSocketSend2;
        Iterator<IPSocketSend> it2 = this.f70727d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                iPSocketSend2 = null;
                break;
            }
            iPSocketSend2 = it2.next();
            if (iPSocketSend2.isSame(iPSocketSend)) {
                break;
            }
        }
        if (iPSocketSend2 != null) {
            this.f70727d.remove(iPSocketSend2);
        }
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        f9.b.a().b(new b(webSocket));
    }
}
