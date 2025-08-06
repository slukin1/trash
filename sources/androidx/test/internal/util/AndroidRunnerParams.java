package androidx.test.internal.util;

import android.app.Instrumentation;
import android.os.Bundle;

public class AndroidRunnerParams {

    /* renamed from: a  reason: collision with root package name */
    public final Instrumentation f11601a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f11602b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11603c = false;

    /* renamed from: d  reason: collision with root package name */
    public final long f11604d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f11605e;

    public AndroidRunnerParams(Instrumentation instrumentation, Bundle bundle, long j11, boolean z11) {
        this.f11601a = instrumentation;
        this.f11602b = bundle;
        this.f11604d = j11;
        this.f11605e = z11;
    }

    public Bundle a() {
        return this.f11602b;
    }

    public Instrumentation b() {
        return this.f11601a;
    }

    public long c() {
        return this.f11604d;
    }

    public boolean d() {
        return this.f11605e;
    }
}
