package un;

import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60889b;

    public /* synthetic */ n(UserLoginPresenter userLoginPresenter) {
        this.f60889b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60889b.l1((LoginInfoData) obj);
    }
}
