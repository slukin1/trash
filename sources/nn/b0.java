package nn;

import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class b0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58566b;

    public /* synthetic */ b0(LoginPresenter loginPresenter) {
        this.f58566b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58566b.e1((Throwable) obj);
    }
}
