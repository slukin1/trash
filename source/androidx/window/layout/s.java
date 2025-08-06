package androidx.window.layout;

import d10.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0017\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/s;", "", "", "toString", "other", "", "equals", "", "hashCode", "", "Landroidx/window/layout/e;", "a", "Ljava/util/List;", "()Ljava/util/List;", "displayFeatures", "<init>", "(Ljava/util/List;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f12157a;

    public s(List<? extends e> list) {
        this.f12157a = list;
    }

    public final List<e> a() {
        return this.f12157a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !x.b(s.class, obj.getClass())) {
            return false;
        }
        return x.b(this.f12157a, ((s) obj).f12157a);
    }

    public int hashCode() {
        return this.f12157a.hashCode();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.k0(this.f12157a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
