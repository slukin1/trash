package xl;

import com.huobi.index.countdown.IndexCountDownManager;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexCountDownManager f61650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61651c;

    public /* synthetic */ b(IndexCountDownManager indexCountDownManager, int i11) {
        this.f61650b = indexCountDownManager;
        this.f61651c = i11;
    }

    public final void run() {
        this.f61650b.l(this.f61651c);
    }
}
