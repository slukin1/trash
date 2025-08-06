package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class n2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58636b;

    public /* synthetic */ n2(UserRegisterV2Presenter userRegisterV2Presenter) {
        this.f58636b = userRegisterV2Presenter;
    }

    public final Object call(Object obj) {
        return this.f58636b.Q0((UserToken) obj);
    }
}
