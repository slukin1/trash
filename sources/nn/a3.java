package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;

public final /* synthetic */ class a3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58564b;

    public /* synthetic */ a3(UserRegisterV2Presenter userRegisterV2Presenter) {
        this.f58564b = userRegisterV2Presenter;
    }

    public final void call(Object obj) {
        this.f58564b.b1((ImgCaptchaData) obj);
    }
}
