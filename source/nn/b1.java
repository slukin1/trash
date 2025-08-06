package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class b1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58567b;

    public /* synthetic */ b1(LoginPresenter loginPresenter) {
        this.f58567b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58567b.z1((APIStatusErrorException) obj);
    }
}
