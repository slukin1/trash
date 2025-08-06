package un;

import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.functions.Func1;

public final /* synthetic */ class t implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60895b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserToken f60896c;

    public /* synthetic */ t(UserLoginPresenter userLoginPresenter, UserToken userToken) {
        this.f60895b = userLoginPresenter;
        this.f60896c = userToken;
    }

    public final Object call(Object obj) {
        return this.f60895b.o1(this.f60896c, (UserInfoData) obj);
    }
}
