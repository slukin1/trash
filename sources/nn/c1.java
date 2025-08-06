package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58574b;

    public /* synthetic */ c1(LoginPresenter loginPresenter) {
        this.f58574b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58574b.d1((APIStatusErrorException) obj);
    }
}
