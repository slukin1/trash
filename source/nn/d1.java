package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;

public final /* synthetic */ class d1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58581b;

    public /* synthetic */ d1(LoginPresenter loginPresenter) {
        this.f58581b = loginPresenter;
    }

    public final void call(Object obj) {
        this.f58581b.u1((ImgCaptchaData) obj);
    }
}
