package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58560b;

    public /* synthetic */ a1(LoginPresenter loginPresenter) {
        this.f58560b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58560b.C1((APIStatusErrorException) obj);
    }
}
