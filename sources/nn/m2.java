package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class m2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58630b;

    public /* synthetic */ m2(UserRegisterV2Presenter userRegisterV2Presenter) {
        this.f58630b = userRegisterV2Presenter;
    }

    public final Object call(Object obj) {
        return this.f58630b.S0((UserToken) obj);
    }
}
