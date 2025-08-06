package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f37816c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f37817d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f37818a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final List<Activity> f37819b = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f37817d) {
            for (Activity next : this.f37819b) {
                if (!(next == null || next == activity || next.isFinishing())) {
                    next.finish();
                }
            }
            this.f37819b.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f37817d) {
            this.f37819b.remove(activity);
        }
    }

    public void a(boolean z11) {
        this.f37818a.set(z11);
    }

    public AtomicBoolean a() {
        return this.f37818a;
    }
}
