package iq;

import com.huobi.points.entity.Points;
import com.huobi.points.presenter.MyTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyTransferPresenter f55797b;

    public /* synthetic */ c(MyTransferPresenter myTransferPresenter) {
        this.f55797b = myTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55797b.Z((Points) obj);
    }
}
