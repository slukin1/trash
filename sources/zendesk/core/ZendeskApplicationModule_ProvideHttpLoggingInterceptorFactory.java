package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.logging.HttpLoggingInterceptor;

public final class ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory implements b<HttpLoggingInterceptor> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory INSTANCE = new ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory();

        private InstanceHolder() {
        }
    }

    public static ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return (HttpLoggingInterceptor) d.f(ZendeskApplicationModule.provideHttpLoggingInterceptor());
    }

    public HttpLoggingInterceptor get() {
        return provideHttpLoggingInterceptor();
    }
}
