package un;

import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60869c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60870d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f60871e;

    public /* synthetic */ e(UserLoginPresenter userLoginPresenter, String str, String str2, int i11) {
        this.f60868b = userLoginPresenter;
        this.f60869c = str;
        this.f60870d = str2;
        this.f60871e = i11;
    }

    public final void call(Object obj) {
        this.f60868b.t1(this.f60869c, this.f60870d, this.f60871e, (RiskControl) obj);
    }
}
