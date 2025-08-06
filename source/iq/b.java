package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.points.presenter.MyTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyTransferPresenter f55795b;

    public /* synthetic */ b(MyTransferPresenter myTransferPresenter) {
        this.f55795b = myTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55795b.X((APIStatusErrorException) obj);
    }
}
