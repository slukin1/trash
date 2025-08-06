package un;

import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60864b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60865c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f60866d;

    public /* synthetic */ d(UserLoginPresenter userLoginPresenter, String str, int i11) {
        this.f60864b = userLoginPresenter;
        this.f60865c = str;
        this.f60866d = i11;
    }

    public final void call(Object obj) {
        this.f60864b.H1(this.f60865c, this.f60866d, (RiskControl) obj);
    }
}
