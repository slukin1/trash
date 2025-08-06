package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.points.presenter.TransferOrderListPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d0 f55800b = new d0();

    public final void call(Object obj) {
        TransferOrderListPresenter.Z((APIStatusErrorException) obj);
    }
}
