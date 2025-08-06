package nn;

import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;

public final /* synthetic */ class o2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f58640b;

    public /* synthetic */ o2(UserToken userToken) {
        this.f58640b = userToken;
    }

    public final Object call(Object obj) {
        return this.f58640b.g(((ProUserToken) obj).getToken());
    }
}
