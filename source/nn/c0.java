package nn;

import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58573b;

    public /* synthetic */ c0(LoginPresenter loginPresenter) {
        this.f58573b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58573b.w1((Throwable) obj);
    }
}
