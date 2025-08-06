package g9;

import com.hbg.lib.network.retrofit.websocket.bean.ISocketSend;
import java.lang.ref.SoftReference;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f54794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SoftReference f54795c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ISocketSend f54796d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f54797e;

    public /* synthetic */ c(e eVar, SoftReference softReference, ISocketSend iSocketSend, Object obj) {
        this.f54794b = eVar;
        this.f54795c = softReference;
        this.f54796d = iSocketSend;
        this.f54797e = obj;
    }

    public final void run() {
        this.f54794b.g(this.f54795c, this.f54796d, this.f54797e);
    }
}
