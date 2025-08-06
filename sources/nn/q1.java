package nn;

import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class q1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f58647b;

    public /* synthetic */ q1(UserToken userToken) {
        this.f58647b = userToken;
    }

    public final Object call(Object obj) {
        return this.f58647b.g(((ProUserToken) obj).getToken());
    }
}
