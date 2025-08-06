package androidx.lifecycle;

import d10.l;
import kotlin.f;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;

public final /* synthetic */ class l0 implements z, u {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f10025b;

    public l0(l lVar) {
        this.f10025b = lVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z) || !(obj instanceof u)) {
            return false;
        }
        return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
    }

    public final f<?> getFunctionDelegate() {
        return this.f10025b;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.f10025b.invoke(obj);
    }
}
