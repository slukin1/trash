package dagger.android;

import android.app.Application;
import com.google.errorprone.annotations.ForOverride;
import pz.b;

public abstract class DaggerApplication extends Application implements b {

    /* renamed from: b  reason: collision with root package name */
    public volatile DispatchingAndroidInjector<Object> f53567b;

    public AndroidInjector<Object> a() {
        c();
        return this.f53567b;
    }

    @ForOverride
    public abstract AndroidInjector<? extends DaggerApplication> b();

    public final void c() {
        synchronized (this) {
            b().inject(this);
            throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
        }
    }

    public void onCreate() {
        super.onCreate();
        c();
    }
}
