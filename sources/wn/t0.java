package wn;

import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class t0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t0 f61481b = new t0();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().z().compose(p.c0());
    }
}
