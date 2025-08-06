package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60891b;

    public /* synthetic */ p(UserLoginPresenter userLoginPresenter) {
        this.f60891b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60891b.B1((UserToken) obj);
    }
}
