package un;

import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;
import tg.r;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f60879b;

    public /* synthetic */ g(UserToken userToken) {
        this.f60879b = userToken;
    }

    public final Object call(Object obj) {
        return r.x().i0((UserInfoData) obj);
    }
}
