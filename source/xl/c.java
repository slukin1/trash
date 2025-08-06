package xl;

import com.huobi.index.countdown.IndexCountDownManager;
import it.a;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexCountDownManager f61652b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f61653c;

    public /* synthetic */ c(IndexCountDownManager indexCountDownManager, a aVar) {
        this.f61652b = indexCountDownManager;
        this.f61653c = aVar;
    }

    public final void run() {
        this.f61652b.n(this.f61653c);
    }
}
