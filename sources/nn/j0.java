package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import rx.functions.Action1;

public final /* synthetic */ class j0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58612b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58613c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f58614d;

    public /* synthetic */ j0(LoginPresenter loginPresenter, String str, String str2) {
        this.f58612b = loginPresenter;
        this.f58613c = str;
        this.f58614d = str2;
    }

    public final void call(Object obj) {
        this.f58612b.y1(this.f58613c, this.f58614d, (RiskControl) obj);
    }
}
