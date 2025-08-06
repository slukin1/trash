package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.CountryAreaSelectPresenter;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CountryAreaSelectPresenter f58565b;

    public /* synthetic */ b(CountryAreaSelectPresenter countryAreaSelectPresenter) {
        this.f58565b = countryAreaSelectPresenter;
    }

    public final void call(Object obj) {
        this.f58565b.d0((APIStatusErrorException) obj);
    }
}
