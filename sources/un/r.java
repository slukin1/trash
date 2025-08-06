package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class r implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60893b;

    public /* synthetic */ r(UserLoginPresenter userLoginPresenter) {
        this.f60893b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60893b.z1((UserToken) obj);
    }
}
