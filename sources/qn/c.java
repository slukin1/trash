package qn;

import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserCenterRemoteDataSource f60060b;

    public /* synthetic */ c(UserCenterRemoteDataSource userCenterRemoteDataSource) {
        this.f60060b = userCenterRemoteDataSource;
    }

    public final Object call(Object obj) {
        return this.f60060b.Z((KvStore) obj);
    }
}
