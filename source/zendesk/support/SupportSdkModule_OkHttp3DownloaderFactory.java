package zendesk.support;

import com.squareup.picasso.n;
import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;

public final class SupportSdkModule_OkHttp3DownloaderFactory implements b<n> {
    private final SupportSdkModule module;
    private final a<OkHttpClient> okHttpClientProvider;

    public SupportSdkModule_OkHttp3DownloaderFactory(SupportSdkModule supportSdkModule, a<OkHttpClient> aVar) {
        this.module = supportSdkModule;
        this.okHttpClientProvider = aVar;
    }

    public static SupportSdkModule_OkHttp3DownloaderFactory create(SupportSdkModule supportSdkModule, a<OkHttpClient> aVar) {
        return new SupportSdkModule_OkHttp3DownloaderFactory(supportSdkModule, aVar);
    }

    public static n okHttp3Downloader(SupportSdkModule supportSdkModule, OkHttpClient okHttpClient) {
        return (n) d.f(supportSdkModule.okHttp3Downloader(okHttpClient));
    }

    public n get() {
        return okHttp3Downloader(this.module, this.okHttpClientProvider.get());
    }
}
