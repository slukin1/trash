package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;

public final class ag {
    public static b AFInAppEventParameterName = null;
    public static long valueOf = 500;

    public interface b {
        void AFKeystoreWrapper(Activity activity);

        void values(Context context);
    }

    public static void valueOf(Context context, final b bVar, final Executor executor) {
        AFInAppEventParameterName = bVar;
        AnonymousClass3 r02 = new Application.ActivityLifecycleCallbacks() {
            public boolean valueOf = true;
            public boolean values;

            public final void onActivityCreated(final Activity activity, Bundle bundle) {
                executor.execute(new Runnable() {
                    public final void run() {
                        j.AFInAppEventType();
                        Intent intent = activity.getIntent();
                        if (j.AFInAppEventType(intent) != null && intent != j.values) {
                            j.values = intent;
                        }
                    }
                });
            }

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivityPaused(final Activity activity) {
                executor.execute(new Runnable() {
                    public final void run() {
                        AnonymousClass3.this.valueOf = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    AnonymousClass3 r02 = AnonymousClass3.this;
                                    if (r02.values && r02.valueOf) {
                                        r02.values = false;
                                        try {
                                            bVar.values(applicationContext);
                                        } catch (Exception e11) {
                                            AFLogger.AFInAppEventType("Listener threw exception! ", (Throwable) e11);
                                        }
                                    }
                                }
                            }, ag.valueOf);
                        } catch (Throwable th2) {
                            AFLogger.AFInAppEventType("Background task failed with a throwable: ", th2);
                        }
                    }
                });
            }

            public final void onActivityResumed(final Activity activity) {
                executor.execute(new Runnable() {
                    public final void run() {
                        AnonymousClass3 r02 = AnonymousClass3.this;
                        if (!r02.values) {
                            try {
                                bVar.AFKeystoreWrapper(activity);
                            } catch (Exception e11) {
                                AFLogger.AFInAppEventParameterName("Listener thrown an exception: ", (Throwable) e11);
                            }
                        }
                        AnonymousClass3 r03 = AnonymousClass3.this;
                        r03.valueOf = false;
                        r03.values = true;
                    }
                });
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }
        };
        if (context instanceof Activity) {
            r02.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r02);
    }
}
