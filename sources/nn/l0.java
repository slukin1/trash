package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class l0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58622b;

    public /* synthetic */ l0(LoginPresenter loginPresenter) {
        this.f58622b = loginPresenter;
    }

    public final Object call(Object obj) {
        return this.f58622b.s1((UserToken) obj);
    }
}
