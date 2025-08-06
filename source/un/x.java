package un;

import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class x implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f60901b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserToken f60902c;

    public /* synthetic */ x(boolean z11, UserToken userToken) {
        this.f60901b = z11;
        this.f60902c = userToken;
    }

    public final Object call(Object obj) {
        return UserLoginPresenter.C1(this.f60901b, this.f60902c, (UserInfoData) obj);
    }
}
