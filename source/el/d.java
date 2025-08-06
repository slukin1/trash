package el;

import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f54343b = new d();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().m0(((LoginInfoData) obj).getTicket()).compose(p.a0()).compose(RxJavaHelper.s());
    }
}
