package o4;

import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.r;

public abstract class g {

    /* renamed from: c  reason: collision with root package name */
    public static final a f66538c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final Handler f66539d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f66540e = Executors.newFixedThreadPool(8);

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel.Result f66541a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66542b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final ExecutorService a() {
            return g.f66540e;
        }
    }

    public g(MethodChannel.Result result) {
        this.f66541a = result;
    }

    public static final void d(MethodChannel.Result result, Object obj) {
        if (result != null) {
            result.success(obj);
        }
    }

    public final void c(Object obj) {
        if (!this.f66542b) {
            this.f66542b = true;
            MethodChannel.Result result = this.f66541a;
            this.f66541a = null;
            f66539d.post(new f(result, obj));
        }
    }
}
