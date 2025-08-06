package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

public abstract class y0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final String f57792a;

    /* renamed from: b  reason: collision with root package name */
    public final f f57793b;

    /* renamed from: c  reason: collision with root package name */
    public final f f57794c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57795d;

    public y0(String str, f fVar, f fVar2) {
        this.f57792a = str;
        this.f57793b = fVar;
        this.f57794c = fVar2;
        this.f57795d = 2;
    }

    public /* synthetic */ y0(String str, f fVar, f fVar2, r rVar) {
        this(str, fVar, fVar2);
    }

    public boolean b() {
        return f.a.c(this);
    }

    public int c(String str) {
        Integer m11 = StringsKt__StringNumberConversionsKt.m(str);
        if (m11 != null) {
            return m11.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid map index");
    }

    public f d(int i11) {
        if (i11 >= 0) {
            int i12 = i11 % 2;
            if (i12 == 0) {
                return this.f57793b;
            }
            if (i12 == 1) {
                return this.f57794c;
            }
            throw new IllegalStateException("Unreached".toString());
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + h() + " expects only non-negative indices").toString());
    }

    public int e() {
        return this.f57795d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return x.b(h(), y0Var.h()) && x.b(this.f57793b, y0Var.f57793b) && x.b(this.f57794c, y0Var.f57794c);
    }

    public String f(int i11) {
        return String.valueOf(i11);
    }

    public List<Annotation> g(int i11) {
        if (i11 >= 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + h() + " expects only non-negative indices").toString());
    }

    public List<Annotation> getAnnotations() {
        return f.a.a(this);
    }

    public h getKind() {
        return i.c.f57649a;
    }

    public String h() {
        return this.f57792a;
    }

    public int hashCode() {
        return (((h().hashCode() * 31) + this.f57793b.hashCode()) * 31) + this.f57794c.hashCode();
    }

    public boolean i(int i11) {
        if (i11 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + h() + " expects only non-negative indices").toString());
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        return h() + '(' + this.f57793b + ", " + this.f57794c + ')';
    }
}
