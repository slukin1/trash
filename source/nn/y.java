package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import rx.functions.Action1;

public final /* synthetic */ class y implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58681b;

    public /* synthetic */ y(LoginPresenter loginPresenter) {
        this.f58681b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58681b.l1((LoginInfoData) obj);
    }
}
