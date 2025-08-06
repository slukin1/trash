package kotlin;

import kotlin.jvm.internal.r;

public final class q implements Comparable<q> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56813c = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final long f56814b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ q(long j11) {
        this.f56814b = j11;
    }

    public static final /* synthetic */ q a(long j11) {
        return new q(j11);
    }

    public static long b(long j11) {
        return j11;
    }

    public static boolean c(long j11, Object obj) {
        return (obj instanceof q) && j11 == ((q) obj).g();
    }

    public static int e(long j11) {
        return com.fluttercandies.photo_manager.core.entity.a.a(j11);
    }

    public static String f(long j11) {
        return v.c(j11);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return v.b(g(), ((q) obj).g());
    }

    public boolean equals(Object obj) {
        return c(this.f56814b, obj);
    }

    public final /* synthetic */ long g() {
        return this.f56814b;
    }

    public int hashCode() {
        return e(this.f56814b);
    }

    public String toString() {
        return f(this.f56814b);
    }
}
