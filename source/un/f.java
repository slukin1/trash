package un;

import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60874c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60875d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f60876e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f60877f;

    public /* synthetic */ f(UserLoginPresenter userLoginPresenter, String str, String str2, boolean z11, String str3) {
        this.f60873b = userLoginPresenter;
        this.f60874c = str;
        this.f60875d = str2;
        this.f60876e = z11;
        this.f60877f = str3;
    }

    public final void call(Object obj) {
        this.f60873b.q1(this.f60874c, this.f60875d, this.f60876e, this.f60877f, (RiskControl) obj);
    }
}
