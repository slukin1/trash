package du;

import com.huobi.utils.download.FileDownloadHelper;
import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class c implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileDownloadHelper f54231a;

    public /* synthetic */ c(FileDownloadHelper fileDownloadHelper) {
        this.f54231a = fileDownloadHelper;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return this.f54231a.f(chain);
    }
}
