package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

class BindingFailedResolveMgr {

    /* renamed from: b  reason: collision with root package name */
    public static final BindingFailedResolveMgr f37765b = new BindingFailedResolveMgr();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f37766c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public List<Activity> f37767a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (f37766c) {
            for (Activity next : this.f37767a) {
                if (!(next == null || next == activity || next.isFinishing())) {
                    next.finish();
                }
            }
            this.f37767a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (f37766c) {
            this.f37767a.remove(activity);
        }
    }
}
