package qp;

import com.huobi.otc.persenter.OtcLiteChatPresenter;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatPresenter.f f60098b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f60099c;

    public /* synthetic */ r(OtcLiteChatPresenter.f fVar, Throwable th2) {
        this.f60098b = fVar;
        this.f60099c = th2;
    }

    public final void run() {
        this.f60098b.l(this.f60099c);
    }
}
