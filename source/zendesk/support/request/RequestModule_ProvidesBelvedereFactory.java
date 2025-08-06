package zendesk.support.request;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import zendesk.belvedere.a;

public final class RequestModule_ProvidesBelvedereFactory implements b<a> {
    private final q00.a<Context> contextProvider;

    public RequestModule_ProvidesBelvedereFactory(q00.a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static RequestModule_ProvidesBelvedereFactory create(q00.a<Context> aVar) {
        return new RequestModule_ProvidesBelvedereFactory(aVar);
    }

    public static a providesBelvedere(Context context) {
        return (a) d.f(RequestModule.providesBelvedere(context));
    }

    public a get() {
        return providesBelvedere(this.contextProvider.get());
    }
}
