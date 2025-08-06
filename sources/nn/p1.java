package nn;

import com.huobi.login.presenter.SetForgetPswPresenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class p1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SetForgetPswPresenter f58643b;

    public /* synthetic */ p1(SetForgetPswPresenter setForgetPswPresenter) {
        this.f58643b = setForgetPswPresenter;
    }

    public final Object call(Object obj) {
        return this.f58643b.f0((UserToken) obj);
    }
}
