package un;

import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60862c;

    public /* synthetic */ c(UserLoginPresenter userLoginPresenter, String str) {
        this.f60861b = userLoginPresenter;
        this.f60862c = str;
    }

    public final void call(Object obj) {
        this.f60861b.G1(this.f60862c, (RiskControl) obj);
    }
}
