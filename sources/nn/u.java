package nn;

import com.huobi.login.presenter.ForgetPasswordPresenter;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgetPasswordPresenter f58663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58664c;

    public /* synthetic */ u(ForgetPasswordPresenter forgetPasswordPresenter, String str) {
        this.f58663b = forgetPasswordPresenter;
        this.f58664c = str;
    }

    public final void call(Object obj) {
        this.f58663b.i0(this.f58664c, (RiskControl) obj);
    }
}
