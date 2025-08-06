package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;

public final class SupportModule_ProvidesOkHttpClientFactory implements b<OkHttpClient> {
    private final SupportModule module;

    public SupportModule_ProvidesOkHttpClientFactory(SupportModule supportModule) {
        this.module = supportModule;
    }

    public static SupportModule_ProvidesOkHttpClientFactory create(SupportModule supportModule) {
        return new SupportModule_ProvidesOkHttpClientFactory(supportModule);
    }

    public static OkHttpClient providesOkHttpClient(SupportModule supportModule) {
        return (OkHttpClient) d.f(supportModule.providesOkHttpClient());
    }

    public OkHttpClient get() {
        return providesOkHttpClient(this.module);
    }
}
