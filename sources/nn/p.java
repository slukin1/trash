package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.ForgetPasswordPresenter;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgetPasswordPresenter f58641b;

    public /* synthetic */ p(ForgetPasswordPresenter forgetPasswordPresenter) {
        this.f58641b = forgetPasswordPresenter;
    }

    public final void call(Object obj) {
        this.f58641b.j0((APIStatusErrorException) obj);
    }
}
