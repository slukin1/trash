package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import kotlin.jvm.internal.r;

public final class c0 implements LifecycleOwner {

    /* renamed from: j  reason: collision with root package name */
    public static final b f9984j = new b((r) null);

    /* renamed from: k  reason: collision with root package name */
    public static final c0 f9985k = new c0();

    /* renamed from: b  reason: collision with root package name */
    public int f9986b;

    /* renamed from: c  reason: collision with root package name */
    public int f9987c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9988d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9989e = true;

    /* renamed from: f  reason: collision with root package name */
    public Handler f9990f;

    /* renamed from: g  reason: collision with root package name */
    public final LifecycleRegistry f9991g = new LifecycleRegistry(this);

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f9992h = new b0(this);

    /* renamed from: i  reason: collision with root package name */
    public final ReportFragment.a f9993i = new d(this);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9994a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public final LifecycleOwner a() {
            return c0.f9985k;
        }

        public final void b(Context context) {
            c0.f9985k.h(context);
        }
    }

    public static final class c extends EmptyActivityLifecycleCallbacks {
        public final /* synthetic */ c0 this$0;

        public static final class a extends EmptyActivityLifecycleCallbacks {
            public final /* synthetic */ c0 this$0;

            public a(c0 c0Var) {
                this.this$0 = c0Var;
            }

            public void onActivityPostResumed(Activity activity) {
                this.this$0.e();
            }

            public void onActivityPostStarted(Activity activity) {
                this.this$0.f();
            }
        }

        public c(c0 c0Var) {
            this.this$0 = c0Var;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                ReportFragment.f9938c.b(activity).f(this.this$0.f9993i);
            }
        }

        public void onActivityPaused(Activity activity) {
            this.this$0.d();
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            a.a(activity, new a(this.this$0));
        }

        public void onActivityStopped(Activity activity) {
            this.this$0.g();
        }
    }

    public static final class d implements ReportFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f9995a;

        public d(c0 c0Var) {
            this.f9995a = c0Var;
        }

        public void onCreate() {
        }

        public void onResume() {
            this.f9995a.e();
        }

        public void onStart() {
            this.f9995a.f();
        }
    }

    public static final void i(c0 c0Var) {
        c0Var.j();
        c0Var.k();
    }

    public static final LifecycleOwner l() {
        return f9984j.a();
    }

    public final void d() {
        int i11 = this.f9987c - 1;
        this.f9987c = i11;
        if (i11 == 0) {
            this.f9990f.postDelayed(this.f9992h, 700);
        }
    }

    public final void e() {
        int i11 = this.f9987c + 1;
        this.f9987c = i11;
        if (i11 != 1) {
            return;
        }
        if (this.f9988d) {
            this.f9991g.i(Lifecycle.Event.ON_RESUME);
            this.f9988d = false;
            return;
        }
        this.f9990f.removeCallbacks(this.f9992h);
    }

    public final void f() {
        int i11 = this.f9986b + 1;
        this.f9986b = i11;
        if (i11 == 1 && this.f9989e) {
            this.f9991g.i(Lifecycle.Event.ON_START);
            this.f9989e = false;
        }
    }

    public final void g() {
        this.f9986b--;
        k();
    }

    public Lifecycle getLifecycle() {
        return this.f9991g;
    }

    public final void h(Context context) {
        this.f9990f = new Handler();
        this.f9991g.i(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c(this));
    }

    public final void j() {
        if (this.f9987c == 0) {
            this.f9988d = true;
            this.f9991g.i(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f9986b == 0 && this.f9988d) {
            this.f9991g.i(Lifecycle.Event.ON_STOP);
            this.f9989e = true;
        }
    }
}
