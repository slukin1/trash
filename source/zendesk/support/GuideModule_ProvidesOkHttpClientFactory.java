package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;

public final class GuideModule_ProvidesOkHttpClientFactory implements b<OkHttpClient> {
    private final GuideModule module;

    public GuideModule_ProvidesOkHttpClientFactory(GuideModule guideModule) {
        this.module = guideModule;
    }

    public static GuideModule_ProvidesOkHttpClientFactory create(GuideModule guideModule) {
        return new GuideModule_ProvidesOkHttpClientFactory(guideModule);
    }

    public static OkHttpClient providesOkHttpClient(GuideModule guideModule) {
        return (OkHttpClient) d.f(guideModule.providesOkHttpClient());
    }

    public OkHttpClient get() {
        return providesOkHttpClient(this.module);
    }
}
