package un;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60867b;

    public /* synthetic */ d0(UserLoginPresenter userLoginPresenter) {
        this.f60867b = userLoginPresenter;
    }

    public final void call(Object obj) {
        this.f60867b.u1((APIStatusErrorException) obj);
    }
}
