package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.layout.j;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000  2\u00020\u0001:\u0002\u000b\u000fB\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010$¨\u0006("}, d2 = {"Landroidx/window/layout/k;", "Landroidx/window/layout/j;", "", "toString", "", "other", "", "equals", "", "hashCode", "Landroidx/window/core/b;", "a", "Landroidx/window/core/b;", "featureBounds", "Landroidx/window/layout/k$b;", "b", "Landroidx/window/layout/k$b;", "getType$window_release", "()Landroidx/window/layout/k$b;", "type", "Landroidx/window/layout/j$c;", "c", "Landroidx/window/layout/j$c;", "getState", "()Landroidx/window/layout/j$c;", "state", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "bounds", "()Z", "isSeparating", "Landroidx/window/layout/j$a;", "d", "()Landroidx/window/layout/j$a;", "occlusionType", "Landroidx/window/layout/j$b;", "()Landroidx/window/layout/j$b;", "orientation", "<init>", "(Landroidx/window/core/b;Landroidx/window/layout/k$b;Landroidx/window/layout/j$c;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class k implements j {

    /* renamed from: d  reason: collision with root package name */
    public static final a f12131d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final androidx.window.core.b f12132a;

    /* renamed from: b  reason: collision with root package name */
    public final b f12133b;

    /* renamed from: c  reason: collision with root package name */
    public final j.c f12134c;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/k$a;", "", "Landroidx/window/core/b;", "bounds", "", "a", "(Landroidx/window/core/b;)V", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final void a(androidx.window.core.b bVar) {
            boolean z11 = false;
            if ((bVar.d() == 0 && bVar.a() == 0) ? false : true) {
                if (bVar.b() == 0 || bVar.c() == 0) {
                    z11 = true;
                }
                if (!z11) {
                    throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
                }
                return;
            }
            throw new IllegalArgumentException("Bounds must be non zero".toString());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\u0004B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/window/layout/k$b;", "", "", "toString", "a", "Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;)V", "b", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public static final a f12135b = new a((r) null);

        /* renamed from: c  reason: collision with root package name */
        public static final b f12136c = new b("FOLD");

        /* renamed from: d  reason: collision with root package name */
        public static final b f12137d = new b("HINGE");

        /* renamed from: a  reason: collision with root package name */
        public final String f12138a;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/window/layout/k$b$a;", "", "Landroidx/window/layout/k$b;", "FOLD", "Landroidx/window/layout/k$b;", "a", "()Landroidx/window/layout/k$b;", "HINGE", "b", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }

            public final b a() {
                return b.f12136c;
            }

            public final b b() {
                return b.f12137d;
            }
        }

        public b(String str) {
            this.f12138a = str;
        }

        public String toString() {
            return this.f12138a;
        }
    }

    public k(androidx.window.core.b bVar, b bVar2, j.c cVar) {
        this.f12132a = bVar;
        this.f12133b = bVar2;
        this.f12134c = cVar;
        f12131d.a(bVar);
    }

    public Rect a() {
        return this.f12132a.f();
    }

    public boolean b() {
        b bVar = this.f12133b;
        b.a aVar = b.f12135b;
        if (x.b(bVar, aVar.b())) {
            return true;
        }
        if (!x.b(this.f12133b, aVar.a()) || !x.b(getState(), j.c.f12129d)) {
            return false;
        }
        return true;
    }

    public j.b c() {
        if (this.f12132a.d() > this.f12132a.a()) {
            return j.b.f12125d;
        }
        return j.b.f12124c;
    }

    public j.a d() {
        if (this.f12132a.d() == 0 || this.f12132a.a() == 0) {
            return j.a.f12120c;
        }
        return j.a.f12121d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!x.b(k.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        k kVar = (k) obj;
        return x.b(this.f12132a, kVar.f12132a) && x.b(this.f12133b, kVar.f12133b) && x.b(getState(), kVar.getState());
    }

    public j.c getState() {
        return this.f12134c;
    }

    public int hashCode() {
        return (((this.f12132a.hashCode() * 31) + this.f12133b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return k.class.getSimpleName() + " { " + this.f12132a + ", type=" + this.f12133b + ", state=" + getState() + " }";
    }
}
