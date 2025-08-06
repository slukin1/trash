package g9;

import android.text.TextUtils;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.HeartBeatInfo;
import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import f9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class h extends WebSocketListener {

    /* renamed from: a  reason: collision with root package name */
    public a f70880a;

    /* renamed from: b  reason: collision with root package name */
    public WebSocket f70881b;

    /* renamed from: c  reason: collision with root package name */
    public final List<ISocketSend> f70882c = new ArrayList(14);

    /* renamed from: d  reason: collision with root package name */
    public final List<ISocketSend> f70883d = new ArrayList(14);

    /* renamed from: e  reason: collision with root package name */
    public String f70884e;

    /* renamed from: f  reason: collision with root package name */
    public f9.a f70885f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f70886g = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RetrofitLogger.a(h.this.f70884e + "-->sendRunnable-->messageList:" + h.this.f70882c);
            if (!h.this.f70882c.isEmpty() && h.this.f70880a.r() && h.this.f70881b != null) {
                for (Object next : h.this.f70882c) {
                    if (h.this.f70881b != null) {
                        if (!(next instanceof HeartBeatInfo.Ping) && !(next instanceof HeartBeatInfo.Pong)) {
                            RetrofitLogger.g(h.this.f70884e + "-->Socket-->send " + next.toString());
                        }
                        h.this.f70881b.send(next.toString());
                    }
                }
                h.this.f70882c.clear();
            }
        }
    }

    public h(String str, a aVar) {
        this.f70884e = str;
        this.f70880a = aVar;
        this.f70885f = new f9.a(this.f70884e, (a.C0777a) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(ISocketSend iSocketSend) {
        ISocketSend iSocketSend2;
        Iterator<ISocketSend> it2 = this.f70882c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                iSocketSend2 = null;
                break;
            }
            iSocketSend2 = it2.next();
            if (iSocketSend2.isSame(iSocketSend)) {
                break;
            }
        }
        if (iSocketSend2 != null) {
            this.f70882c.remove(iSocketSend2);
        }
        this.f70882c.add(iSocketSend);
        try {
            j(iSocketSend);
            if (!(iSocketSend instanceof BaseSocketSub)) {
                this.f70883d.add(iSocketSend);
            } else if (!((BaseSocketSub) iSocketSend).isSubscribe()) {
                Iterator<ISocketSend> it3 = this.f70883d.iterator();
                while (it3.hasNext()) {
                    ISocketSend next = it3.next();
                    if (!TextUtils.isEmpty(next.getChannel()) && next.getChannel().equals(iSocketSend.getChannel())) {
                        it3.remove();
                    }
                }
            } else {
                this.f70883d.add(iSocketSend);
            }
        } catch (Exception e11) {
            RetrofitLogger.g(this.f70884e + "-->Socket-->addMessage exception:" + e11);
        }
        RetrofitLogger.g(this.f70884e + "-->Socket-->addMessage message:" + iSocketSend.toString());
        RetrofitLogger.g(this.f70884e + "-->Socket-->addMessage temp:" + this.f70883d.toString());
        this.f70885f.post(this.f70886g);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        try {
            for (ISocketSend j11 : this.f70882c) {
                j(j11);
            }
        } catch (Exception e11) {
            RetrofitLogger.g(this.f70884e + "-->Socket-->onOpen addMessage exception:" + e11);
        }
        this.f70882c.addAll(this.f70883d);
        RetrofitLogger.g(this.f70884e + "-->Socket-->onOpen addMessage " + this.f70882c.toString());
    }

    public void g(ISocketSend iSocketSend) {
        if (!(iSocketSend instanceof HeartBeatInfo)) {
            this.f70880a.o();
            this.f70885f.post(new g(this, iSocketSend));
        } else if (this.f70881b != null) {
            RetrofitLogger.a(this.f70884e + "-->send-->" + iSocketSend.toString());
            this.f70881b.send(iSocketSend.toString());
        }
    }

    public final void j(ISocketSend iSocketSend) {
        ISocketSend iSocketSend2;
        Iterator<ISocketSend> it2 = this.f70883d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                iSocketSend2 = null;
                break;
            }
            iSocketSend2 = it2.next();
            if (iSocketSend2.isSame(iSocketSend)) {
                break;
            }
        }
        if (iSocketSend2 != null) {
            this.f70883d.remove(iSocketSend2);
        }
    }

    public void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        this.f70885f.post(this.f70886g);
    }

    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        this.f70881b = webSocket;
        this.f70885f.post(new f(this));
        this.f70885f.post(this.f70886g);
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        super.onMessage(webSocket, byteString);
        this.f70885f.post(this.f70886g);
    }
}
