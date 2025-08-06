package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.CountryAreaSelectPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountryAreaSelectPresenter f58572b;

    public /* synthetic */ c(CountryAreaSelectPresenter countryAreaSelectPresenter) {
        this.f58572b = countryAreaSelectPresenter;
    }

    public final void call(Object obj) {
        this.f58572b.h0((APIStatusErrorException) obj);
    }
}
