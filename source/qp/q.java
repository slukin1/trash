package qp;

import com.huobi.otc.persenter.OtcLiteChatPresenter;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatPresenter.f f60096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60097c;

    public /* synthetic */ q(OtcLiteChatPresenter.f fVar, int i11) {
        this.f60096b = fVar;
        this.f60097c = i11;
    }

    public final void run() {
        this.f60096b.k(this.f60097c);
    }
}
