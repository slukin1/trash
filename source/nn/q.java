package nn;

import com.huobi.login.presenter.ForgetPasswordPresenter;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgetPasswordPresenter f58645b;

    public /* synthetic */ q(ForgetPasswordPresenter forgetPasswordPresenter) {
        this.f58645b = forgetPasswordPresenter;
    }

    public final void call(Object obj) {
        this.f58645b.b0((ImgCaptchaData) obj);
    }
}
