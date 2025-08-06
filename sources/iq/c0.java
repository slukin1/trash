package iq;

import com.huobi.points.presenter.TransferOrderListPresenter;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransferOrderListPresenter f55798b;

    public /* synthetic */ c0(TransferOrderListPresenter transferOrderListPresenter) {
        this.f55798b = transferOrderListPresenter;
    }

    public final void call(Object obj) {
        this.f55798b.Y((List) obj);
    }
}
