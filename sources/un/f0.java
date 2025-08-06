package un;

import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class f0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60878b;

    public /* synthetic */ f0(UserLoginPresenter userLoginPresenter) {
        this.f60878b = userLoginPresenter;
    }

    public final void call(Object obj) {
        this.f60878b.k1((LoginInfoData) obj);
    }
}
