package zendesk.support;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import mz.f;
import okhttp3.Interceptor;
import okhttp3.Response;

class HelpCenterCachingInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return f.c(proceed.headers().get("X-ZD-Cache-Control")) ? proceed.newBuilder().header(HttpHeaders.CACHE_CONTROL, proceed.header("X-ZD-Cache-Control")).build() : proceed;
    }
}
