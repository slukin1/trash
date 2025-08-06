package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.c0;
import java.util.List;
import t1.a;
import t1.b;

public final class ProcessLifecycleInitializer implements b<LifecycleOwner> {
    /* renamed from: a */
    public LifecycleOwner create(Context context) {
        if (a.e(context).g(ProcessLifecycleInitializer.class)) {
            LifecycleDispatcher.a(context);
            c0.b bVar = c0.f9984j;
            bVar.b(context);
            return bVar.a();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    public List<Class<? extends b<?>>> dependencies() {
        return CollectionsKt__CollectionsKt.k();
    }
}
