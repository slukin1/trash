package eh;

import com.huobi.appupgrade.helper.AppUpgradeDownloadHelper;
import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppUpgradeDownloadHelper f54326a;

    public /* synthetic */ a(AppUpgradeDownloadHelper appUpgradeDownloadHelper) {
        this.f54326a = appUpgradeDownloadHelper;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return this.f54326a.d(chain);
    }
}
