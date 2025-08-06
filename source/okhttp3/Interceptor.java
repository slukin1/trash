package okhttp3;

import d10.l;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i11, TimeUnit timeUnit);

        Chain withReadTimeout(int i11, TimeUnit timeUnit);

        Chain withWriteTimeout(int i11, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(l<? super Chain, Response> lVar) {
            return new Interceptor$Companion$invoke$1(lVar);
        }
    }

    Response intercept(Chain chain) throws IOException;
}
