package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

public abstract class u0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final f f57771a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57772b;

    public u0(f fVar) {
        this.f57771a = fVar;
        this.f57772b = 1;
    }

    public /* synthetic */ u0(f fVar, r rVar) {
        this(fVar);
    }

    public boolean b() {
        return f.a.c(this);
    }

    public int c(String str) {
        Integer m11 = StringsKt__StringNumberConversionsKt.m(str);
        if (m11 != null) {
            return m11.intValue();
        }
        throw new IllegalArgumentException(str + " is not a valid list index");
    }

    public f d(int i11) {
        if (i11 >= 0) {
            return this.f57771a;
        }
        throw new IllegalArgumentException(("Illegal index " + i11 + ", " + h() + " expects only non-negative indices").toString());
    }

    public int e() {
        return this.f57772b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return x.b(this.f57771a, u0Var.f57771a) && x.b(h(), u0Var.h());
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
        return i.b.f57648a;
    }

    public int hashCode() {
        return (this.f57771a.hashCode() * 31) + h().hashCode();
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
        return h() + '(' + this.f57771a + ')';
    }
}
