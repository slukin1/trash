package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.b;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/t;", "", "", "toString", "other", "", "equals", "", "hashCode", "Landroidx/window/core/b;", "a", "Landroidx/window/core/b;", "_bounds", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "bounds", "<init>", "(Landroidx/window/core/b;)V", "(Landroid/graphics/Rect;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final b f12158a;

    public t(b bVar) {
        this.f12158a = bVar;
    }

    public final Rect a() {
        return this.f12158a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !x.b(t.class, obj.getClass())) {
            return false;
        }
        return x.b(this.f12158a, ((t) obj).f12158a);
    }

    public int hashCode() {
        return this.f12158a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    public t(Rect rect) {
        this(new b(rect));
    }
}
