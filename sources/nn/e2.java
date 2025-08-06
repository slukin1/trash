package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;

public final /* synthetic */ class e2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58589b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58590c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f58591d;

    public /* synthetic */ e2(UserRegisterV2Presenter userRegisterV2Presenter, String str, boolean z11) {
        this.f58589b = userRegisterV2Presenter;
        this.f58590c = str;
        this.f58591d = z11;
    }

    public final void call(Object obj) {
        this.f58589b.d1(this.f58590c, this.f58591d, (ImgCaptchaData) obj);
    }
}
