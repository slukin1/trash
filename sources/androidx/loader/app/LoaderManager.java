package androidx.loader.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.q0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import r1.b;

public abstract class LoaderManager {

    public interface a<D> {
        b<D> onCreateLoader(int i11, Bundle bundle);

        void onLoadFinished(b<D> bVar, D d11);

        void onLoaderReset(b<D> bVar);
    }

    public static <T extends LifecycleOwner & q0> LoaderManager b(T t11) {
        return new a(t11, ((q0) t11).getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> b<D> c(int i11, Bundle bundle, a<D> aVar);

    public abstract void d();
}
