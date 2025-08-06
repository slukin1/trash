package iq;

import com.huobi.points.presenter.MyTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyTransferPresenter f55801b;

    public /* synthetic */ e(MyTransferPresenter myTransferPresenter) {
        this.f55801b = myTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55801b.Y((Throwable) obj);
    }
}
