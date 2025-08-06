package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class i implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f60883b;

    public /* synthetic */ i(UserToken userToken) {
        this.f60883b = userToken;
    }

    public final Object call(Object obj) {
        return UserLoginPresenter.m1(this.f60883b, obj);
    }
}
