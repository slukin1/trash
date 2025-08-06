package com.sumsub.sns.internal.nfc;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.j;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0418a f35134d = new C0418a((r) null);
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final String f35135e = "NfcActivityAttacher";

    /* renamed from: a  reason: collision with root package name */
    public final d f35136a;

    /* renamed from: b  reason: collision with root package name */
    public final b f35137b = new b();

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<AppCompatActivity> f35138c;

    /* renamed from: com.sumsub.sns.internal.nfc.a$a  reason: collision with other inner class name */
    public static final class C0418a {
        public /* synthetic */ C0418a(r rVar) {
            this();
        }

        public C0418a() {
        }
    }

    public final class b implements DefaultLifecycleObserver {
        public b() {
        }

        public /* bridge */ /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            j.a(this, lifecycleOwner);
        }

        public void onDestroy(LifecycleOwner lifecycleOwner) {
            c.a(c.f35142a, a.f35135e, "LifecycleObserver onDestroy", (Throwable) null, 4, (Object) null);
            a.this.a();
        }

        public void onPause(LifecycleOwner lifecycleOwner) {
            c.a(c.f35142a, a.f35135e, "LifecycleObserver onPause", (Throwable) null, 4, (Object) null);
            a.this.f35136a.d((Activity) lifecycleOwner);
        }

        public void onResume(LifecycleOwner lifecycleOwner) {
            c.a(c.f35142a, a.f35135e, "LifecycleObserver onResume", (Throwable) null, 4, (Object) null);
            a.this.f35136a.e((Activity) lifecycleOwner);
        }

        public /* bridge */ /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            j.e(this, lifecycleOwner);
        }

        public /* bridge */ /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            j.f(this, lifecycleOwner);
        }
    }

    public a(d dVar) {
        this.f35136a = dVar;
    }

    public final void a(AppCompatActivity appCompatActivity) {
        if (this.f35138c == null) {
            this.f35138c = new WeakReference<>(appCompatActivity);
            appCompatActivity.getLifecycle().a(this.f35137b);
            c cVar = c.f35142a;
            c.a(cVar, f35135e, "Attached to " + appCompatActivity, (Throwable) null, 4, (Object) null);
            if (appCompatActivity.getLifecycle().b() == Lifecycle.State.RESUMED) {
                c.a(cVar, f35135e, "onActivityResume on attach", (Throwable) null, 4, (Object) null);
                this.f35136a.e(appCompatActivity);
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't attach activity twice");
    }

    public final void a() {
        WeakReference<AppCompatActivity> weakReference = this.f35138c;
        AppCompatActivity appCompatActivity = weakReference != null ? weakReference.get() : null;
        if (weakReference == null || appCompatActivity == null) {
            c.a(c.f35142a, f35135e, "Detach called but attachedActivity is null", (Throwable) null, 4, (Object) null);
            return;
        }
        c cVar = c.f35142a;
        c.a(cVar, f35135e, "Detached from " + appCompatActivity, (Throwable) null, 4, (Object) null);
        appCompatActivity.getLifecycle().d(this.f35137b);
        this.f35138c = null;
        if (appCompatActivity.getLifecycle().b() == Lifecycle.State.RESUMED) {
            c.a(cVar, f35135e, "onActivityPause on detach", (Throwable) null, 4, (Object) null);
            this.f35136a.d(appCompatActivity);
        }
    }
}
