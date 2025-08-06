package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class q2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f58648b;

    public /* synthetic */ q2(UserToken userToken) {
        this.f58648b = userToken;
    }

    public final Object call(Object obj) {
        return UserRegisterV2Presenter.R0(this.f58648b, obj);
    }
}
