package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f60881b;

    public /* synthetic */ h(UserToken userToken) {
        this.f60881b = userToken;
    }

    public final Object call(Object obj) {
        return UserLoginPresenter.A1(this.f60881b, obj);
    }
}
