package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ThirdAuth;
import rx.functions.Action1;

public final /* synthetic */ class z implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58686b;

    public /* synthetic */ z(LoginPresenter loginPresenter) {
        this.f58686b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58686b.c1((ThirdAuth) obj);
    }
}
