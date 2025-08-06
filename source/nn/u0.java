package nn;

import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class u0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u0 f58665b = new u0();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().z().compose(p.c0());
    }
}
