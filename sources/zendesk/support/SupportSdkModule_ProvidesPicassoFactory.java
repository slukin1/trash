package zendesk.support;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.n;
import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import q00.a;

public final class SupportSdkModule_ProvidesPicassoFactory implements b<Picasso> {
    private final a<Context> contextProvider;
    private final a<ExecutorService> executorServiceProvider;
    private final SupportSdkModule module;
    private final a<n> okHttp3DownloaderProvider;

    public SupportSdkModule_ProvidesPicassoFactory(SupportSdkModule supportSdkModule, a<Context> aVar, a<n> aVar2, a<ExecutorService> aVar3) {
        this.module = supportSdkModule;
        this.contextProvider = aVar;
        this.okHttp3DownloaderProvider = aVar2;
        this.executorServiceProvider = aVar3;
    }

    public static SupportSdkModule_ProvidesPicassoFactory create(SupportSdkModule supportSdkModule, a<Context> aVar, a<n> aVar2, a<ExecutorService> aVar3) {
        return new SupportSdkModule_ProvidesPicassoFactory(supportSdkModule, aVar, aVar2, aVar3);
    }

    public static Picasso providesPicasso(SupportSdkModule supportSdkModule, Context context, n nVar, ExecutorService executorService) {
        return (Picasso) d.f(supportSdkModule.providesPicasso(context, nVar, executorService));
    }

    public Picasso get() {
        return providesPicasso(this.module, this.contextProvider.get(), this.okHttp3DownloaderProvider.get(), this.executorServiceProvider.get());
    }
}
