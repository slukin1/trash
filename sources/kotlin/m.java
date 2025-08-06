package kotlin;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class m implements Comparable<m> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56800c = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final byte f56801b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ m(byte b11) {
        this.f56801b = b11;
    }

    public static final /* synthetic */ m a(byte b11) {
        return new m(b11);
    }

    public static byte b(byte b11) {
        return b11;
    }

    public static boolean c(byte b11, Object obj) {
        return (obj instanceof m) && b11 == ((m) obj).g();
    }

    public static int e(byte b11) {
        return b11;
    }

    public static String f(byte b11) {
        return String.valueOf(b11 & 255);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return x.c(g() & 255, ((m) obj).g() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f56801b, obj);
    }

    public final /* synthetic */ byte g() {
        return this.f56801b;
    }

    public int hashCode() {
        return e(this.f56801b);
    }

    public String toString() {
        return f(this.f56801b);
    }
}
