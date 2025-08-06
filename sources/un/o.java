package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class o implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60890b;

    public /* synthetic */ o(UserLoginPresenter userLoginPresenter) {
        this.f60890b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60890b.j1((UserToken) obj);
    }
}
