package un;

import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Func1;
import tg.r;

public final /* synthetic */ class v implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f60899b;

    public /* synthetic */ v(boolean z11) {
        this.f60899b = z11;
    }

    public final Object call(Object obj) {
        return r.x().f0(false).map(new x(this.f60899b, (UserToken) obj));
    }
}
