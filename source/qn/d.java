package qn;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserCenterRemoteDataSource f60061b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60062c;

    public /* synthetic */ d(UserCenterRemoteDataSource userCenterRemoteDataSource, String str) {
        this.f60061b = userCenterRemoteDataSource;
        this.f60062c = str;
    }

    public final Object call(Object obj) {
        return this.f60061b.d0(this.f60062c, (TradeRiskReminder) obj);
    }
}
