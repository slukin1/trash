package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.ImgCaptchaData;
import rx.functions.Action1;

public final /* synthetic */ class c2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58575b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58576c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f58577d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f58578e;

    public /* synthetic */ c2(UserRegisterV2Presenter userRegisterV2Presenter, String str, String str2, boolean z11) {
        this.f58575b = userRegisterV2Presenter;
        this.f58576c = str;
        this.f58577d = str2;
        this.f58578e = z11;
    }

    public final void call(Object obj) {
        this.f58575b.i1(this.f58576c, this.f58577d, this.f58578e, (ImgCaptchaData) obj);
    }
}
