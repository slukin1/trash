package nn;

import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58580b;

    public /* synthetic */ d0(LoginPresenter loginPresenter) {
        this.f58580b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58580b.b1((Throwable) obj);
    }
}
