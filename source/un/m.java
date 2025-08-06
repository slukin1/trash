package un;

import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class m implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60888b;

    public /* synthetic */ m(UserLoginPresenter userLoginPresenter) {
        this.f60888b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60888b.h1((LoginInfoData) obj);
    }
}
