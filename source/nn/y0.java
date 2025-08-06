package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class y0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58682b;

    public /* synthetic */ y0(LoginPresenter loginPresenter) {
        this.f58682b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58682b.v1((APIStatusErrorException) obj);
    }
}
