package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import rx.functions.Action1;

public final /* synthetic */ class f2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58596c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f58597d;

    public /* synthetic */ f2(UserRegisterV2Presenter userRegisterV2Presenter, String str, boolean z11) {
        this.f58595b = userRegisterV2Presenter;
        this.f58596c = str;
        this.f58597d = z11;
    }

    public final void call(Object obj) {
        this.f58595b.h1(this.f58596c, this.f58597d, (RiskControl) obj);
    }
}
