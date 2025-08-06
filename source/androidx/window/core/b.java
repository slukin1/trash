package androidx.window.core;

import android.graphics.Rect;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000f\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u000eR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Landroidx/window/core/b;", "", "Landroid/graphics/Rect;", "f", "", "toString", "other", "", "equals", "", "hashCode", "a", "I", "b", "()I", "left", "c", "top", "getRight", "right", "d", "getBottom", "bottom", "width", "height", "e", "()Z", "isZero", "<init>", "(IIII)V", "rect", "(Landroid/graphics/Rect;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f12054a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12055b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12056c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12057d;

    public b(int i11, int i12, int i13, int i14) {
        this.f12054a = i11;
        this.f12055b = i12;
        this.f12056c = i13;
        this.f12057d = i14;
    }

    public final int a() {
        return this.f12057d - this.f12055b;
    }

    public final int b() {
        return this.f12054a;
    }

    public final int c() {
        return this.f12055b;
    }

    public final int d() {
        return this.f12056c - this.f12054a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!x.b(b.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        b bVar = (b) obj;
        return this.f12054a == bVar.f12054a && this.f12055b == bVar.f12055b && this.f12056c == bVar.f12056c && this.f12057d == bVar.f12057d;
    }

    public final Rect f() {
        return new Rect(this.f12054a, this.f12055b, this.f12056c, this.f12057d);
    }

    public int hashCode() {
        return (((((this.f12054a * 31) + this.f12055b) * 31) + this.f12056c) * 31) + this.f12057d;
    }

    public String toString() {
        return b.class.getSimpleName() + " { [" + this.f12054a + ',' + this.f12055b + ',' + this.f12056c + ',' + this.f12057d + "] }";
    }

    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
    }
}
