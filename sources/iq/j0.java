package iq;

import com.huobi.points.entity.Points;
import com.huobi.points.presenter.TransferToMePresenter;
import rx.functions.Action1;

public final /* synthetic */ class j0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransferToMePresenter f55812b;

    public /* synthetic */ j0(TransferToMePresenter transferToMePresenter) {
        this.f55812b = transferToMePresenter;
    }

    public final void call(Object obj) {
        this.f55812b.l0((Points) obj);
    }
}
