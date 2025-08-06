package com.hbg.module.content.ui.fragment;

import androidx.lifecycle.z;
import d10.l;
import kotlin.f;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;

public final /* synthetic */ class n implements z, u {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f18818b;

    public n(l lVar) {
        this.f18818b = lVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z) || !(obj instanceof u)) {
            return false;
        }
        return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
    }

    public final f<?> getFunctionDelegate() {
        return this.f18818b;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.f18818b.invoke(obj);
    }
}
