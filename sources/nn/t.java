package nn;

import com.huobi.login.presenter.ForgetPasswordPresenter;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgetPasswordPresenter f58658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58659c;

    public /* synthetic */ t(ForgetPasswordPresenter forgetPasswordPresenter, String str) {
        this.f58658b = forgetPasswordPresenter;
        this.f58659c = str;
    }

    public final void call(Object obj) {
        this.f58658b.d0(this.f58659c, (ImgCaptchaData) obj);
    }
}
