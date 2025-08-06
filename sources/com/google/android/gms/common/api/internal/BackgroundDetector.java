package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final BackgroundDetector zza = new BackgroundDetector();
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final AtomicBoolean zzc = new AtomicBoolean();
    @GuardedBy("instance")
    private final ArrayList zzd = new ArrayList();
    @GuardedBy("instance")
    private boolean zze = false;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z11);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return zza;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        BackgroundDetector backgroundDetector = zza;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.zze) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.zze = true;
            }
        }
    }

    private final void zza(boolean z11) {
        synchronized (zza) {
            Iterator it2 = this.zzd.iterator();
            while (it2.hasNext()) {
                ((BackgroundStateChangeListener) it2.next()).onBackgroundStateChanged(z11);
            }
        }
    }

    @KeepForSdk
    public void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (zza) {
            this.zzd.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean isInBackground() {
        return this.zzb.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.zzc;
        boolean compareAndSet = this.zzb.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            zza(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.zzc;
        boolean compareAndSet = this.zzb.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            zza(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i11) {
        if (i11 == 20 && this.zzb.compareAndSet(false, true)) {
            this.zzc.set(true);
            zza(true);
        }
    }

    @TargetApi(16)
    @KeepForSdk
    public boolean readCurrentStateIfPossible(boolean z11) {
        if (!this.zzc.get()) {
            if (!PlatformVersion.isAtLeastJellyBean()) {
                return z11;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzc.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzb.set(true);
            }
        }
        return isInBackground();
    }
}
