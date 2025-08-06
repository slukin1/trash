package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import rx.functions.Action1;

public final /* synthetic */ class d2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58582b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58583c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f58584d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f58585e;

    public /* synthetic */ d2(UserRegisterV2Presenter userRegisterV2Presenter, String str, String str2, boolean z11) {
        this.f58582b = userRegisterV2Presenter;
        this.f58583c = str;
        this.f58584d = str2;
        this.f58585e = z11;
    }

    public final void call(Object obj) {
        this.f58582b.m1(this.f58583c, this.f58584d, this.f58585e, (RiskControl) obj);
    }
}
