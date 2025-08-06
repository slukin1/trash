package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f37820b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f37821c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final List<Activity> f37822a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f37821c) {
            for (Activity next : this.f37822a) {
                if (!(next == null || next == activity || next.isFinishing())) {
                    next.finish();
                }
            }
            this.f37822a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f37821c) {
            this.f37822a.remove(activity);
        }
    }
}
