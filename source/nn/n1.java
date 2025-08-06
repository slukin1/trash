package nn;

import android.content.Intent;
import com.huobi.login.presenter.SetForgetPswPresenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.bean.LoginSuccBean;
import rx.functions.Action1;

public final /* synthetic */ class n1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SetForgetPswPresenter f58633b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginSuccBean f58634c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Intent f58635d;

    public /* synthetic */ n1(SetForgetPswPresenter setForgetPswPresenter, LoginSuccBean loginSuccBean, Intent intent) {
        this.f58633b = setForgetPswPresenter;
        this.f58634c = loginSuccBean;
        this.f58635d = intent;
    }

    public final void call(Object obj) {
        this.f58633b.j0(this.f58634c, this.f58635d, (UserToken) obj);
    }
}
