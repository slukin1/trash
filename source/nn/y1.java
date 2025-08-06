package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.bean.LoginSuccBean;
import rx.functions.Action1;

public final /* synthetic */ class y1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58683b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginSuccBean f58684c;

    public /* synthetic */ y1(UserRegisterV2Presenter userRegisterV2Presenter, LoginSuccBean loginSuccBean) {
        this.f58683b = userRegisterV2Presenter;
        this.f58684c = loginSuccBean;
    }

    public final void call(Object obj) {
        this.f58683b.X0(this.f58684c, (UserToken) obj);
    }
}
