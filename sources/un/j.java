package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class j implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f60885b;

    public /* synthetic */ j(UserToken userToken) {
        this.f60885b = userToken;
    }

    public final Object call(Object obj) {
        return UserLoginPresenter.i1(this.f60885b, obj);
    }
}
