package xl;

import com.huobi.index.countdown.IndexCountDownManager;
import it.a;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexCountDownManager f61654b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f61655c;

    public /* synthetic */ d(IndexCountDownManager indexCountDownManager, a aVar) {
        this.f61654b = indexCountDownManager;
        this.f61655c = aVar;
    }

    public final void run() {
        this.f61654b.m(this.f61655c);
    }
}
