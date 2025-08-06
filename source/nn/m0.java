package nn;

import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class m0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginPresenter f58626b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserToken f58627c;

    public /* synthetic */ m0(LoginPresenter loginPresenter, UserToken userToken) {
        this.f58626b = loginPresenter;
        this.f58627c = userToken;
    }

    public final Object call(Object obj) {
        return this.f58626b.r1(this.f58627c, (UserInfoData) obj);
    }
}
