package un;

import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60897b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserToken f60898c;

    public /* synthetic */ u(UserLoginPresenter userLoginPresenter, UserToken userToken) {
        this.f60897b = userLoginPresenter;
        this.f60898c = userToken;
    }

    public final Object call(Object obj) {
        return this.f60897b.y1(this.f60898c, (UserInfoData) obj);
    }
}
