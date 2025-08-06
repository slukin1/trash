package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.app.ActivityManager;
import android.os.StatFs;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class a0 implements z {

    /* renamed from: a  reason: collision with root package name */
    public final ActivityManager f34581a;

    /* renamed from: b  reason: collision with root package name */
    public final StatFs f34582b;

    /* renamed from: c  reason: collision with root package name */
    public final StatFs f34583c;

    public static final class a extends Lambda implements d10.a<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a0 f34584a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(a0 a0Var) {
            super(0);
            this.f34584a = a0Var;
        }

        /* renamed from: a */
        public final Long invoke() {
            return Long.valueOf(this.f34584a.f34583c.getTotalBytes());
        }
    }

    public static final class b extends Lambda implements d10.a<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a0 f34585a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a0 a0Var) {
            super(0);
            this.f34585a = a0Var;
        }

        /* renamed from: a */
        public final Long invoke() {
            return Long.valueOf(this.f34585a.f34582b.getTotalBytes());
        }
    }

    public static final class c extends Lambda implements d10.a<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a0 f34586a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a0 a0Var) {
            super(0);
            this.f34586a = a0Var;
        }

        /* renamed from: a */
        public final Long invoke() {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager a11 = this.f34586a.f34581a;
            if (a11 != null) {
                a11.getMemoryInfo(memoryInfo);
            }
            return Long.valueOf(memoryInfo.totalMem);
        }
    }

    public a0(ActivityManager activityManager, StatFs statFs, StatFs statFs2) {
        this.f34581a = activityManager;
        this.f34582b = statFs;
        this.f34583c = statFs2;
    }

    public long a() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new b(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = 0L;
        }
        return ((Number) a11).longValue();
    }

    public long b() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new c(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = 0L;
        }
        return ((Number) a11).longValue();
    }

    public long c() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, new a(this), 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = 0L;
        }
        return ((Number) a11).longValue();
    }
}
