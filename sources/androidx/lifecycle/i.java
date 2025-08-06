package androidx.lifecycle;

import d10.l;
import kotlin.f;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;

public final /* synthetic */ class i implements z, u {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f10010b;

    public i(l lVar) {
        this.f10010b = lVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z) || !(obj instanceof u)) {
            return false;
        }
        return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
    }

    public final f<?> getFunctionDelegate() {
        return this.f10010b;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.f10010b.invoke(obj);
    }
}
