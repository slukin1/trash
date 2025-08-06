package com.bbc876219.lib.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Keep;
import com.bbc876219.lib.utils.reflection.ReflectionUtils;

public class AppInstrumentation extends Instrumentation {

    /* renamed from: a  reason: collision with root package name */
    public Instrumentation f15596a;

    public AppInstrumentation(Instrumentation instrumentation) {
        this.f15596a = instrumentation;
    }

    @Keep
    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i11, Bundle bundle) {
        Context context2 = context;
        IBinder iBinder3 = iBinder;
        IBinder iBinder4 = iBinder2;
        Activity activity2 = activity;
        Intent intent2 = intent;
        Bundle bundle2 = bundle;
        Log.d("AppInstrumentation", "execStartActivity() called with: who = [" + context2 + "], contextThread = [" + iBinder3 + "], token = [" + iBinder4 + "], target = [" + activity2 + "], intent = [" + intent2 + "], requestCode = [" + i11 + "], options = [" + bundle2 + "]");
        return (Instrumentation.ActivityResult) ReflectionUtils.h(Instrumentation.class, this.f15596a, "execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class}, new Object[]{context2, iBinder3, iBinder4, activity2, intent2, Integer.valueOf(i11), bundle2}, (Object) null);
    }

    public Context getContext() {
        return this.f15596a.getContext();
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Log.d("AppInstrumentation", "newActivity() called with: cl = [" + classLoader + "], className = [" + str + "], intent = [" + intent + "]");
        return this.f15596a.newActivity(classLoader, str, intent);
    }

    public void onCreate(Bundle bundle) {
        Log.d("AppInstrumentation", "onCreate() called with: arguments = [" + bundle + "]");
    }

    public boolean onException(Object obj, Throwable th2) {
        Log.d("AppInstrumentation", "onException() called with: obj = [" + obj + "], e = [" + th2 + "]");
        return false;
    }

    public void onStart() {
        Log.d("AppInstrumentation", "onStart() called");
        this.f15596a.onStart();
    }

    public void start() {
        Log.d("AppInstrumentation", "start() called");
        this.f15596a.start();
    }
}
