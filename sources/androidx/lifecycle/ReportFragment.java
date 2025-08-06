package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.r;

public class ReportFragment extends Fragment {

    /* renamed from: c  reason: collision with root package name */
    public static final b f9938c = new b((r) null);

    /* renamed from: b  reason: collision with root package name */
    public a f9939b;

    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a((r) null);

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }

            public final void a(Activity activity) {
                activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ReportFragment.f9938c.a(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            ReportFragment.f9938c.a(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            ReportFragment.f9938c.a(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            ReportFragment.f9938c.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            ReportFragment.f9938c.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            ReportFragment.f9938c.a(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public interface a {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public final void a(Activity activity, Lifecycle.Event event) {
            if (activity instanceof w) {
                ((w) activity).getLifecycle().i(event);
            } else if (activity instanceof LifecycleOwner) {
                Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
                if (lifecycle instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) lifecycle).i(event);
                }
            }
        }

        public final ReportFragment b(Activity activity) {
            return (ReportFragment) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
        }

        public final void c(Activity activity) {
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    public static final void e(Activity activity) {
        f9938c.c(activity);
    }

    public final void a(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            f9938c.a(getActivity(), event);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public final void f(a aVar) {
        this.f9939b = aVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f9939b);
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f9939b = null;
    }

    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        c(this.f9939b);
        a(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        d(this.f9939b);
        a(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }
}
