package nn;

import com.huobi.login.presenter.SetForgetPswPresenter;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class r1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f58651b;

    public /* synthetic */ r1(UserToken userToken) {
        this.f58651b = userToken;
    }

    public final Object call(Object obj) {
        return SetForgetPswPresenter.g0(this.f58651b, (UserInfoData) obj);
    }
}
