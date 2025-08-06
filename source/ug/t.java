package ug;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.account.presenter.DominicaKycPagePresenter;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DominicaKycPagePresenter f60645b;

    public /* synthetic */ t(DominicaKycPagePresenter dominicaKycPagePresenter) {
        this.f60645b = dominicaKycPagePresenter;
    }

    public final void call(Object obj) {
        this.f60645b.W((APIStatusErrorException) obj);
    }
}
