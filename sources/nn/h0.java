package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import com.huobi.login.usercenter.data.source.bean.ThirdState;
import rx.functions.Action1;

public final /* synthetic */ class h0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58603b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThirdData f58604c;

    public /* synthetic */ h0(LoginPresenter loginPresenter, ThirdData thirdData) {
        this.f58603b = loginPresenter;
        this.f58604c = thirdData;
    }

    public final void call(Object obj) {
        this.f58603b.B1(this.f58604c, (ThirdState) obj);
    }
}
