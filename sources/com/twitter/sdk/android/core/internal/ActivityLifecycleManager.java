package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class ActivityLifecycleManager {
    private final ActivityLifecycleCallbacksWrapper callbacksWrapper;

    public static class ActivityLifecycleCallbacksWrapper {
        private final Application application;
        private final Set<Application.ActivityLifecycleCallbacks> registeredCallbacks = new HashSet();

        public ActivityLifecycleCallbacksWrapper(Application application2) {
            this.application = application2;
        }

        /* access modifiers changed from: private */
        public void clearCallbacks() {
            for (Application.ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.registeredCallbacks) {
                this.application.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        /* access modifiers changed from: private */
        public boolean registerLifecycleCallbacks(final Callbacks callbacks) {
            if (this.application == null) {
                return false;
            }
            AnonymousClass1 r02 = new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    callbacks.onActivityCreated(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    callbacks.onActivityDestroyed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    callbacks.onActivityPaused(activity);
                }

                public void onActivityResumed(Activity activity) {
                    callbacks.onActivityResumed(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    callbacks.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    callbacks.onActivityStarted(activity);
                }

                public void onActivityStopped(Activity activity) {
                    callbacks.onActivityStopped(activity);
                }
            };
            this.application.registerActivityLifecycleCallbacks(r02);
            this.registeredCallbacks.add(r02);
            return true;
        }
    }

    public static abstract class Callbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
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

    public ActivityLifecycleManager(Context context) {
        this.callbacksWrapper = new ActivityLifecycleCallbacksWrapper((Application) context.getApplicationContext());
    }

    public boolean registerCallbacks(Callbacks callbacks) {
        ActivityLifecycleCallbacksWrapper activityLifecycleCallbacksWrapper = this.callbacksWrapper;
        return activityLifecycleCallbacksWrapper != null && activityLifecycleCallbacksWrapper.registerLifecycleCallbacks(callbacks);
    }

    public void resetCallbacks() {
        ActivityLifecycleCallbacksWrapper activityLifecycleCallbacksWrapper = this.callbacksWrapper;
        if (activityLifecycleCallbacksWrapper != null) {
            activityLifecycleCallbacksWrapper.clearCallbacks();
        }
    }
}
