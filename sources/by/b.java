package by;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.rodolfonavalon.shaperipplelibrary.ShapeRipple;

@TargetApi(14)
public class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b  reason: collision with root package name */
    public ShapeRipple f26393b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f26394c;

    public b(ShapeRipple shapeRipple) {
        this.f26393b = shapeRipple;
    }

    public void a() {
        ShapeRipple shapeRipple = this.f26393b;
        if (shapeRipple == null) {
            a.b("Shape Ripple is null, activity listener is not attached!!");
            return;
        }
        Activity c11 = c(shapeRipple.getContext());
        this.f26394c = c11;
        c11.getApplication().registerActivityLifecycleCallbacks(this);
    }

    public final void b() {
        Activity activity = this.f26394c;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public final Activity c(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        throw new IllegalArgumentException("Context does not derived from any activity, Do not use the Application Context!!");
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f26394c == activity) {
            b();
            a.a("Activity is Destroyed");
        }
    }

    public void onActivityPaused(Activity activity) {
        ShapeRipple shapeRipple = this.f26393b;
        if (shapeRipple != null && this.f26394c == activity) {
            shapeRipple.stop();
            a.a("Activity is Paused");
        }
    }

    public void onActivityResumed(Activity activity) {
        ShapeRipple shapeRipple = this.f26393b;
        if (shapeRipple != null && this.f26394c == activity) {
            shapeRipple.restartRipple();
            a.a("Activity is Resumed");
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
