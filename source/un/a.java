package un;

import c6.b;
import com.huobi.login.v3.presenter.UserLoginPresenter;

public final /* synthetic */ class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60857c;

    public /* synthetic */ a(UserLoginPresenter userLoginPresenter, boolean z11) {
        this.f60856b = userLoginPresenter;
        this.f60857c = z11;
    }

    public final void onCallback(Object obj) {
        this.f60856b.d1(this.f60857c, obj);
    }
}
