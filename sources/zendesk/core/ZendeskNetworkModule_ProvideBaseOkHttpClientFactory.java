package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import q00.a;

public final class ZendeskNetworkModule_ProvideBaseOkHttpClientFactory implements b<OkHttpClient> {
    private final a<ExecutorService> executorServiceProvider;
    private final a<HttpLoggingInterceptor> loggingInterceptorProvider;
    private final ZendeskNetworkModule module;
    private final a<ZendeskOauthIdHeaderInterceptor> oauthIdHeaderInterceptorProvider;
    private final a<UserAgentAndClientHeadersInterceptor> userAgentAndClientHeadersInterceptorProvider;

    public ZendeskNetworkModule_ProvideBaseOkHttpClientFactory(ZendeskNetworkModule zendeskNetworkModule, a<HttpLoggingInterceptor> aVar, a<ZendeskOauthIdHeaderInterceptor> aVar2, a<UserAgentAndClientHeadersInterceptor> aVar3, a<ExecutorService> aVar4) {
        this.module = zendeskNetworkModule;
        this.loggingInterceptorProvider = aVar;
        this.oauthIdHeaderInterceptorProvider = aVar2;
        this.userAgentAndClientHeadersInterceptorProvider = aVar3;
        this.executorServiceProvider = aVar4;
    }

    public static ZendeskNetworkModule_ProvideBaseOkHttpClientFactory create(ZendeskNetworkModule zendeskNetworkModule, a<HttpLoggingInterceptor> aVar, a<ZendeskOauthIdHeaderInterceptor> aVar2, a<UserAgentAndClientHeadersInterceptor> aVar3, a<ExecutorService> aVar4) {
        return new ZendeskNetworkModule_ProvideBaseOkHttpClientFactory(zendeskNetworkModule, aVar, aVar2, aVar3, aVar4);
    }

    public static OkHttpClient provideBaseOkHttpClient(ZendeskNetworkModule zendeskNetworkModule, HttpLoggingInterceptor httpLoggingInterceptor, Object obj, Object obj2, ExecutorService executorService) {
        return (OkHttpClient) d.f(zendeskNetworkModule.provideBaseOkHttpClient(httpLoggingInterceptor, (ZendeskOauthIdHeaderInterceptor) obj, (UserAgentAndClientHeadersInterceptor) obj2, executorService));
    }

    public OkHttpClient get() {
        return provideBaseOkHttpClient(this.module, this.loggingInterceptorProvider.get(), this.oauthIdHeaderInterceptorProvider.get(), this.userAgentAndClientHeadersInterceptorProvider.get(), this.executorServiceProvider.get());
    }
}
