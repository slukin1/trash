package nn;

import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;
import tg.r;

public final /* synthetic */ class o0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f58638b;

    public /* synthetic */ o0(UserToken userToken) {
        this.f58638b = userToken;
    }

    public final Object call(Object obj) {
        return r.x().i0((UserInfoData) obj);
    }
}
