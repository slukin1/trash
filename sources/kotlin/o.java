package kotlin;

import kotlin.jvm.internal.r;

public final class o implements Comparable<o> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56805c = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final int f56806b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ o(int i11) {
        this.f56806b = i11;
    }

    public static final /* synthetic */ o a(int i11) {
        return new o(i11);
    }

    public static int b(int i11) {
        return i11;
    }

    public static boolean c(int i11, Object obj) {
        return (obj instanceof o) && i11 == ((o) obj).g();
    }

    public static int e(int i11) {
        return i11;
    }

    public static String f(int i11) {
        return String.valueOf(((long) i11) & 4294967295L);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return v.a(g(), ((o) obj).g());
    }

    public boolean equals(Object obj) {
        return c(this.f56806b, obj);
    }

    public final /* synthetic */ int g() {
        return this.f56806b;
    }

    public int hashCode() {
        return e(this.f56806b);
    }

    public String toString() {
        return f(this.f56806b);
    }
}
