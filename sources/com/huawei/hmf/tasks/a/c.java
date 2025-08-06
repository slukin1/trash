package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

public final class c extends CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    public final List<Runnable> f37639a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Object f37640b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f37641c = false;

    public final boolean a() {
        return this.f37641c;
    }

    public final CancellationToken b(Runnable runnable) {
        synchronized (this.f37640b) {
            if (this.f37641c) {
                runnable.run();
            } else {
                this.f37639a.add(runnable);
            }
        }
        return this;
    }
}
