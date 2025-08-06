package un;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class e0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60872b;

    public /* synthetic */ e0(UserLoginPresenter userLoginPresenter) {
        this.f60872b = userLoginPresenter;
    }

    public final void call(Object obj) {
        this.f60872b.r1((APIStatusErrorException) obj);
    }
}
