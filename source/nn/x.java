package nn;

import c6.b;
import com.huobi.login.presenter.LoginPresenter;

public final /* synthetic */ class x implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58677c;

    public /* synthetic */ x(LoginPresenter loginPresenter, boolean z11) {
        this.f58676b = loginPresenter;
        this.f58677c = z11;
    }

    public final void onCallback(Object obj) {
        this.f58676b.g1(this.f58677c, obj);
    }
}
