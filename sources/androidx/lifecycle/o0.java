package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

public final /* synthetic */ class o0 {
    static {
        ViewModelProvider.Factory.a aVar = ViewModelProvider.Factory.f9967e;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        return factory.create(cls);
    }
}
