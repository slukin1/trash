package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ThirdAuthUrl;
import rx.functions.Action1;

public final /* synthetic */ class a0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58559b;

    public /* synthetic */ a0(LoginPresenter loginPresenter) {
        this.f58559b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58559b.F1((ThirdAuthUrl) obj);
    }
}
