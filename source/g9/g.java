package g9;

import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f54801b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ISocketSend f54802c;

    public /* synthetic */ g(h hVar, ISocketSend iSocketSend) {
        this.f54801b = hVar;
        this.f54802c = iSocketSend;
    }

    public final void run() {
        this.f54801b.h(this.f54802c);
    }
}
