package g00;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.rxjava3.core.Scheduler;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Scheduler f54765a = f00.a.d(a.f54764b);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f54766a = new c(new Handler(Looper.getMainLooper()), true);
    }

    public static Scheduler c() {
        return f00.a.e(f54765a);
    }
}
