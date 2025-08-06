package zendesk.support;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class SupportApplicationModule_ProvideMetadataFactory implements b<SupportSdkMetadata> {
    private final a<Context> contextProvider;
    private final SupportApplicationModule module;

    public SupportApplicationModule_ProvideMetadataFactory(SupportApplicationModule supportApplicationModule, a<Context> aVar) {
        this.module = supportApplicationModule;
        this.contextProvider = aVar;
    }

    public static SupportApplicationModule_ProvideMetadataFactory create(SupportApplicationModule supportApplicationModule, a<Context> aVar) {
        return new SupportApplicationModule_ProvideMetadataFactory(supportApplicationModule, aVar);
    }

    public static SupportSdkMetadata provideMetadata(SupportApplicationModule supportApplicationModule, Context context) {
        return (SupportSdkMetadata) d.f(supportApplicationModule.provideMetadata(context));
    }

    public SupportSdkMetadata get() {
        return provideMetadata(this.module, this.contextProvider.get());
    }
}
