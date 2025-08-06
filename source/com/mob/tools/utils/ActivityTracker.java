package com.mob.tools.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashSet;

public class ActivityTracker implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static ActivityTracker f27954a;

    /* renamed from: b  reason: collision with root package name */
    private HashSet<Tracker> f27955b = new HashSet<>();

    public interface EachTracker extends PublicMemberKeeper {
        void each(Tracker tracker);
    }

    public interface Tracker extends PublicMemberKeeper {
        void onCreated(Activity activity, Bundle bundle);

        void onDestroyed(Activity activity);

        void onPaused(Activity activity);

        void onResumed(Activity activity);

        void onSaveInstanceState(Activity activity, Bundle bundle);

        void onStarted(Activity activity);

        void onStopped(Activity activity);
    }

    private ActivityTracker(Context context) {
        a(context);
    }

    public static synchronized ActivityTracker getInstance(Context context) {
        ActivityTracker activityTracker;
        synchronized (ActivityTracker.class) {
            if (f27954a == null) {
                f27954a = new ActivityTracker(context);
            }
            activityTracker = f27954a;
        }
        return activityTracker;
    }

    public void addTracker(Tracker tracker) {
        synchronized (this.f27955b) {
            this.f27955b.add(tracker);
        }
    }

    public void removeTracker(Tracker tracker) {
        synchronized (this.f27955b) {
            this.f27955b.remove(tracker);
        }
    }

    /* access modifiers changed from: private */
    public void c(final Activity activity) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onPaused(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public void d(final Activity activity) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onStopped(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public void e(final Activity activity) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onDestroyed(activity);
            }
        });
    }

    private void a(Context context) {
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    ActivityTracker.this.a(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    ActivityTracker.this.e(activity);
                }

                public void onActivityPaused(Activity activity) {
                    ActivityTracker.this.c(activity);
                }

                public void onActivityResumed(Activity activity) {
                    ActivityTracker.this.b(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    ActivityTracker.this.b(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    ActivityTracker.this.a(activity);
                }

                public void onActivityStopped(Activity activity) {
                    ActivityTracker.this.d(activity);
                }
            });
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    /* access modifiers changed from: private */
    public void b(final Activity activity) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onResumed(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(final Activity activity, final Bundle bundle) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onSaveInstanceState(activity, bundle);
            }
        });
    }

    private void a(EachTracker eachTracker) {
        Tracker[] trackerArr;
        try {
            synchronized (this.f27955b) {
                HashSet<Tracker> hashSet = this.f27955b;
                trackerArr = (Tracker[]) hashSet.toArray(new Tracker[hashSet.size()]);
            }
            for (Tracker tracker : trackerArr) {
                if (tracker != null) {
                    eachTracker.each(tracker);
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    /* access modifiers changed from: private */
    public void a(final Activity activity, final Bundle bundle) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onCreated(activity, bundle);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final Activity activity) {
        a((EachTracker) new EachTracker() {
            public void each(Tracker tracker) {
                tracker.onStarted(activity);
            }
        });
    }
}
