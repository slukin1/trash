package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Set<OnContextAvailableListener> f3671a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    public volatile Context f3672b;

    public final void a(OnContextAvailableListener onContextAvailableListener) {
        Context context = this.f3672b;
        if (context != null) {
            onContextAvailableListener.a(context);
        }
        this.f3671a.add(onContextAvailableListener);
    }

    public final void b() {
        this.f3672b = null;
    }

    public final void c(Context context) {
        this.f3672b = context;
        for (OnContextAvailableListener a11 : this.f3671a) {
            a11.a(context);
        }
    }

    public final Context d() {
        return this.f3672b;
    }

    public final void e(OnContextAvailableListener onContextAvailableListener) {
        this.f3671a.remove(onContextAvailableListener);
    }
}
