package zendesk.core;

import android.content.Context;
import java.io.IOException;
import java.util.Locale;
import mz.c;
import mz.f;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class AcceptLanguageHeaderInterceptor implements Interceptor {
    private Context context;

    public AcceptLanguageHeaderInterceptor(Context context2) {
        this.context = context2;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Locale currentLocale = DeviceInfo.getCurrentLocale(this.context);
        if (!f.e(request.header("Accept-Language")) || currentLocale == null) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().addHeader("Accept-Language", c.d(currentLocale)).build());
    }
}
