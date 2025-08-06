package nn;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.presenter.LoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class k0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58618b;

    public /* synthetic */ k0(LoginPresenter loginPresenter) {
        this.f58618b = loginPresenter;
    }

    public final Object call(Object obj) {
        return this.f58618b.p1((UcIntCodeResponse) obj);
    }
}
