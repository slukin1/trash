package kotlin;

import com.tencent.android.tpush.common.Constants;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class t implements Comparable<t> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56897c = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final short f56898b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ t(short s11) {
        this.f56898b = s11;
    }

    public static final /* synthetic */ t a(short s11) {
        return new t(s11);
    }

    public static short b(short s11) {
        return s11;
    }

    public static boolean c(short s11, Object obj) {
        return (obj instanceof t) && s11 == ((t) obj).g();
    }

    public static int e(short s11) {
        return s11;
    }

    public static String f(short s11) {
        return String.valueOf(s11 & Constants.PROTOCOL_NONE);
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return x.c(g() & Constants.PROTOCOL_NONE, ((t) obj).g() & Constants.PROTOCOL_NONE);
    }

    public boolean equals(Object obj) {
        return c(this.f56898b, obj);
    }

    public final /* synthetic */ short g() {
        return this.f56898b;
    }

    public int hashCode() {
        return e(this.f56898b);
    }

    public String toString() {
        return f(this.f56898b);
    }
}
