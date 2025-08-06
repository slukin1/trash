package qt;

import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70479b;

    public /* synthetic */ n(String str) {
        this.f70479b = str;
    }

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().requestLicenseState(this.f70479b, false);
    }
}
