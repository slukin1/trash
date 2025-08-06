package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.CountryAreaSelectPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountryAreaSelectPresenter f58579b;

    public /* synthetic */ d(CountryAreaSelectPresenter countryAreaSelectPresenter) {
        this.f58579b = countryAreaSelectPresenter;
    }

    public final void call(Object obj) {
        this.f58579b.a0((APIStatusErrorException) obj);
    }
}
