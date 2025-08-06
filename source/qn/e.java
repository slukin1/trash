package qn;

import com.huobi.kyc.bean.PhpLogin;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f60063b = new e();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.a0((PhpLogin) obj);
    }
}
