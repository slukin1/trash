package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class s implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60894b;

    public /* synthetic */ s(UserLoginPresenter userLoginPresenter) {
        this.f60894b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60894b.p1((UserToken) obj);
    }
}
