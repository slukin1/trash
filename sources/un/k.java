package un;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class k implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60886b;

    public /* synthetic */ k(UserLoginPresenter userLoginPresenter) {
        this.f60886b = userLoginPresenter;
    }

    public final Object call(Object obj) {
        return this.f60886b.w1((UcIntCodeResponse) obj);
    }
}
